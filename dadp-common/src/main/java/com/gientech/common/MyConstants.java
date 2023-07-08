package com.gientech.common;

import java.io.File;

/**
 * 常量文件类
 *
 * @author 胡砥峰
 */
public class MyConstants {

    /*-----------------【1】系统级-----------------------------------------------------------------------------------*/
    public static String ADMIN = "admin"; // 系统管理员 用户ID, 角色ID

    public static final String HEADER = "Authorization";// Token令牌自定义标识
    public static final String TOKEN_PREFIX = "Bearer ";// Token令牌前缀
    public static final int TOKEN_EXPIRE = 60 * 60 * 6;// 令牌有效期（秒）。保存6小时

    public static final String IS_LOGIN = "LOGIN";// 权限码：表示已登录才能访问

    /*-----------------【2】redis前缀-----------------------------------------------------------------------------------*/
    public static final String REDIS_SESSION_ID = "dadpToken:";

    public static final String REDIS_SYS_CONFIG = "sysConfig:";
    public static final String REDIS_SYS_CODE_TYPE = "sysCodeType:";
    public static final String REDIS_SYS_ROLE = "sysRole:";
    public static final String REDIS_SYS_ORG_MAP = "sysOrgMap";
    public static final String REDIS_COMBO_ORG = "comboOrg";
    public static final String REDIS_COMBO_USER = "comboUser";
    public static final String REDIS_COMBO_ROLE = "comboRole";
    //新增bookState
    public static final String REDIS_SYS_BOOK_STATE_INFO = "sysBookStateInfo:";
    public static final String REDIS_COMBO_BOOK_STATE = "comboBookState";

    public static final String COMBO_ORG_ID = "orgId";// 机构下拉框key
    public static final String COMBO_USER_ID = "userId";// 用户下拉框key
    public static final String COMBO_ROLE_ID = "roleId";// 角色下拉框key

    //新增book
    public static final String REDIS_COMBO_BOOK = "comboBook";
    public static final String COMBO_BOOK_ID = "bookId"; // 图书下拉框key

    //新增DEP_FIXED
    public static final String REDIS_DEP_FIXED = "depFixed";
    public static final String DEP_FIXED_ID = "depFixedId";

    //新增DEP_CURR
    public static final String REDIS_PCM_DEP_CURR = "pcmDepCurr";
    public static final String PCM_DEP_CURR_ID = "depCurrId";

    // 新增Loan
    public static final String REDIS_PCM_LOAN = "pcmLoan";
    public static final String PCM_LOAN_ID = "loanId";

    //新增Prod
    public static final String REDIS_PPM_PROD = "ppmProd";
    public static final String PPM_PROD_ID = "prodId";

    //新增PROD_OWN
    public static final String REDIS_PCM_PROD_OWN = "pcmProdOwn";
    public static final String PCM_PROD_OWN_ID = "prodOwnId";

    /*-----------------【3】系统参数-----------------------------------------------------------------------------------*/
    public static final String CONFIG_SUPER_PASSWORD = "superPassword"; // 【系统参数】 系统超级密码 的编号
//	public static final String CONFIG_SYSTEM_NAME = "sysName"; // 【系统参数】 本系统名称 的编号

    /*-----------------【4】操作权限-----------------------------------------------------------------------------------*/
    public static final String OPER_TYPE_01 = "1"; // 操作权限类型:菜单权限
    public static final String OPER_TYPE_02 = "2"; // 操作权限类型:功能权限

    // **************【角色权限 开始】******************************************************************

    public static final String DATA_AUTH_ALL_TABLE_NAME = "all_table_name"; // 数据权限: 所有业务对象权限
    public static final String DATA_AUTH_OWNER = "owner"; // 数据权限: 本人所属部门 or 本人数据权限
    public static final String DATA_AUTH_ALL_ORG = "all_org"; // 数据权限:所有部门数据权限
    public static final String DATA_AUTH_PARENT_ORG = "parent_org"; // 数据权限:上级部门数据权限

    public static final String DATA_AUTH_DATA_TYPE_ORG = "1"; // 数据权限:权限类型:机构数据
    public static final String DATA_AUTH_DATA_TYPE_USER = "2"; // 数据权限:权限类型:用户数据

    public static final String DATA_AUTH_INCLUDE_SUB_YES = "1"; // 数据权限:含下级部门
    public static final String DATA_AUTH_INCLUDE_SUB_NO = "0"; // 数据权限:不含下级部门

    // **************【角色权限 结束】******************************************************************

    // 标识符，表示不需要传递token的feign 2022-6-22 吴小毅add
    public static final String FEIGN_NOT_TOKEN = "feignNotToken";
    public static final String REDIS_SYS_ROLE_INFO = "sysRoleInfo:";


    public static final String REDIS_SYS_BOOK_INFO = "sysBookInfo:";

    // -----------------------------【下面的胡砥峰还没整理】-----------------------------------------

    /**
     * 手机号正则表达式
     */
    public static final String PHONE_REGEXP = "|1\\d{10}";
    /**
     * 密码正则表达式
     */
    public static final String PASSWORD_REGEXP = "^[A-Za-z0-9][A-Za-z0-9`~!@#%*()?\\-_=+.]{7,17}$";
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 导出时文件存放目录
     */
    public static final String FILE_PATH = File.separator + "static" + File.separator + "downfile" + File.separator;

}
