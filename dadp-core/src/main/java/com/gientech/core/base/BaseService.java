package com.gientech.core.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.common.MyConstants;
import com.gientech.common.auth.UserSession;
import com.gientech.core.redis.RedisService;
import com.gientech.core.security.service.TokenService;
import com.gientech.sys.org.SysOrg;
import com.gientech.sys.roleData.SysRoleData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 基础service类，所有的Service都要继承。封装了dao操作和其他常用方法
 *
 * @param <M>
 * @param <T>
 * @author 胡砥峰，吴清赫
 */
public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisService redisService;

    /*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/

    /**
     * 【1】获取当前用户的UserSession
     *
     * @return
     */
    public UserSession getUserSession() {
        return this.tokenService.getUserSession();
    }

    /**
     * 【2】是否admin用户
     *
     * @return
     */
    public boolean isAdmin() {
        return MyConstants.ADMIN.equals(this.getUserSession().getUserId());
    }

    /**
     * 【3】数据权限---获取权限sql
     *
     * @param tableName            业务对象名称(表名) ex: T_TEST_SALE【需要控制数据权限的表，必须具备着3个字段：ORG_ID、USER_ID、ORG_LEVEL_CODE,前面2个可以命名不一样，但ORG_LEVEL_CODE字段必须一样(一些具备下级机构权限的情况用右like)】
     * @param orgIdTableAliasName  org字段所在业务对象别名(表别名) ex: a
     * @param orgFieldName         数据表中的所属机构标识 ex:org_id
     * @param userIdTableAliasName user字段所在业务对象别名(表别名) ex: a
     * @param userFieldName        数据表中的所属用户标识 ex:user_id(or create_man)
     * @return a.org_id in('1', '2', '3' ) …… 还有其他几种情况,请看代码
     */
    public String getDataAuthFliterSql(String tableName, String orgIdTableAliasName, String orgFieldName, String userIdTableAliasName, String userFieldName) {

        UserSession userSession = this.getUserSession();

        // 返回权限结果字符串.
        StringBuffer stringBuffer = new StringBuffer();

        // 【1】admin自动拥有超级权限
        if (this.isAdmin()) {
            return "1=1";
        }

        List<SysRoleData> roleDataList = (List<SysRoleData>) this.redisService.get(MyConstants.REDIS_SYS_ROLE + userSession.getRoleId());

        // 【2】数据权限表没有记录, 没有数据权限
        if (roleDataList == null || roleDataList.size() == 0) {
            return "1=2";
        }

        // 【3】在数据权限表有记录，分几种情况处理
        for (SysRoleData sysRoleData : roleDataList) {

            // 【3.1】业务对象表名为【all_table_name所有表】 或正好等于【传值进来的tableName】,说明系统为这张表设定了数据权限的控制
            if (sysRoleData.getTableName().equals(tableName) || MyConstants.DATA_AUTH_ALL_TABLE_NAME.equals(sysRoleData.getTableName())) {

                // 【3.1.1】数据权限为---机构权限控制(即：拥有哪些机构的数据权限)
                if (MyConstants.DATA_AUTH_DATA_TYPE_ORG.equals(sysRoleData.getAuthType())) {
                    if (StringUtils.isEmpty(orgFieldName)) {// orgId字段不能为空
                        continue;
                    }

                    // 【3.1.1.1】情况1.1:所有机构
                    if (MyConstants.DATA_AUTH_ALL_ORG.equals(sysRoleData.getAuthScopeId())) {
                        return "1=1";

                    } // 【3.1.1.2】情况1.2:用户所属机构
                    else if (MyConstants.DATA_AUTH_OWNER.equals(sysRoleData.getAuthScopeId())) {
                        // 【3.1.1.2.1】情况1.2.1:不含下级机构
                        if (MyConstants.DATA_AUTH_INCLUDE_SUB_NO.equals(sysRoleData.getIsIncludeSub())) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(" or ");
                            }
                            if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                stringBuffer.append(orgIdTableAliasName).append(".");
                            }
                            stringBuffer.append(orgFieldName).append("='").append(userSession.getOrgId()).append("'");// 用户所属机构
                        } // 【3.1.1.2.2】情况1.2.2:含下级机构
                        else {
                            if (this.isHasChildOrg(userSession.getOrgId())) {// 本用户机构有子节点，输出的是ORG_LEVEL_CODE
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(" or ");
                                }

                                if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                    stringBuffer.append(orgIdTableAliasName).append(".");
                                }
                                stringBuffer.append("ORG_LEVEL_CODE").append(" like '").append(userSession.getOrgLevelCode()).append("%'");// 【注意】ORG_LEVEL_CODE的hibernate写法不一样
                            } else {// 本用户机构没有子节点，
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(" or ");
                                }
                                if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                    stringBuffer.append(orgIdTableAliasName).append(".");
                                }
                                stringBuffer.append(orgFieldName).append("='").append(userSession.getOrgId()).append("'");// 用户所属机构
                            }
                        }
                    } // 【3.1.1.3】 情况1.3:具体的一个一个单独机构
                    else {
                        SysOrg sysOrg = this.getOrgById(sysRoleData.getAuthScopeId());// 单独的一个机构id
                        if (sysOrg != null) {

                            // 【3.1.1.3.1】情况1.3.1:不含下级机构
                            if (MyConstants.DATA_AUTH_INCLUDE_SUB_NO.equals(sysRoleData.getIsIncludeSub())) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(" or ");
                                }
                                if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                    stringBuffer.append(orgIdTableAliasName).append(".");
                                }
                                stringBuffer.append(orgFieldName).append("='").append(sysOrg.getOrgId()).append("'");
                            } // 【3.1.1.3.2】 情况1.3.2:含下级机构
                            else {
                                if (this.isHasChildOrg(sysOrg.getOrgId())) {// 该机构有子节点，输出的是ORG_LEVEL_CODE
                                    if (stringBuffer.length() > 0) {
                                        stringBuffer.append(" or ");
                                    }

                                    if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                        stringBuffer.append(orgIdTableAliasName).append(".");
                                    }
                                    stringBuffer.append("ORG_LEVEL_CODE").append(" like '").append(sysOrg.getOrgLevelCode()).append("%'");// 【注意】ORG_LEVEL_CODE的hibernate写法不一样
                                } else {// 该机构没有子节点，
                                    if (stringBuffer.length() > 0) {
                                        stringBuffer.append(" or ");
                                    }
                                    if (!StringUtils.isEmpty(orgIdTableAliasName)) {
                                        stringBuffer.append(orgIdTableAliasName).append(".");
                                    }
                                    stringBuffer.append(orgFieldName).append("='").append(sysOrg.getOrgId()).append("'");
                                }

                            }
                        }
                    }
                } // 【3.1.2】数据权限为---用户权限控制(即：拥有哪些用户的数据权限)
                else if (MyConstants.DATA_AUTH_DATA_TYPE_USER.equals(sysRoleData.getAuthType())) {
                    if (StringUtils.isEmpty(userFieldName)) {
                        continue;
                    }

                    // 【3.1.2.1】情况2.1:用户本人数据
                    if (MyConstants.DATA_AUTH_OWNER.equals(sysRoleData.getAuthScopeId())) {
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(" or ");
                        }
                        if (!StringUtils.isEmpty(userIdTableAliasName)) {
                            stringBuffer.append(userIdTableAliasName).append(".");
                        }
                        stringBuffer.append(userFieldName).append("='").append(userSession.getUserId()).append("'");
                    } // 【3.1.2.2】情况2.2:具体的一个一个单独用户,【目前前台只支持本人数据】
                    else {
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(" or ");
                        }
                        if (!StringUtils.isEmpty(userIdTableAliasName)) {
                            stringBuffer.append(userIdTableAliasName).append(".");
                        }
                        stringBuffer.append(userFieldName).append("='").append(sysRoleData.getAuthScopeId()).append("'");
                    }
                }

            }
        }

        if (stringBuffer.length() > 0) {
            stringBuffer.insert(0, "( ").append(" )");
        } else {
            return "1=2";
        }

        return stringBuffer.toString();
    }

    /**
     * 【11】判断这个orgId是否有子节点
     *
     * @param orgId
     * @return
     */
    public boolean isHasChildOrg(String orgId) {

        Map<String, SysOrg> map = (Map<String, SysOrg>) this.redisService.get(MyConstants.REDIS_SYS_ORG_MAP);
        for (String key : map.keySet()) {
            SysOrg sysOrg = map.get(key);

            // 说明该orgId有子节点
            if (StringUtils.isNotEmpty(sysOrg.getParentOrgId())) {
				if (sysOrg.getParentOrgId().equals(orgId)) {
					return true;
				}
            }
        }

        return false;
    }

    /**
     * 【12】根据orgId获取SysOrg对象
     *
     * @param orgId
     * @return
     */
    public SysOrg getOrgById(String orgId) {
        Map<String, SysOrg> map = (Map<String, SysOrg>) this.redisService.get(MyConstants.REDIS_SYS_ORG_MAP);

        return map.get(orgId);
    }
}
