package com.gientech.sys.codeInfo;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.MyConstants;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.Combo;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import com.gientech.sys.codeType.SysCodeType;
import com.gientech.sys.codeType.SysCodeTypeService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 代码信息--Service
 *
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysCodeInfoService extends BaseService<SysCodeInfoMapper, SysCodeInfo> {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SysCodeTypeService sysCodeTypeService;

    /**
     * 【1】查询和分页
     *
     * @param dto
     * @return
     */
    public DataGrid<SysCodeInfoVO> listCodeInfo(SysCodeInfoDTO4List dto) {
        log.info("【list查询条件--代码信息】" + dto);

        // 【2】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "content");

        // 【3】处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.CODE_TYPE_ID asc, a.SORT_NO asc"));

        // 【4】构造分页参数
        Page<SysCodeInfoVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<SysCodeInfoVO>(this.getBaseMapper().getSysCodeInfoList(page, dto), page.getTotal());
    }

    /**
     * 【2】新增--保存
     *
     * @param dto
     */
    public void saveCodeInfo(SysCodeInfoDTO4Save dto) {
        log.info("【新增--代码信息】" + dto);

        // 【1】 从dto中copy属性
        SysCodeInfo sysCodeInfo = new SysCodeInfo();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysCodeInfo);

        // 【2】 检查下拉框value是否重复
        if (isExistCodeInfoValue(sysCodeInfo)) {
            throw new AppException("新增失败,代码类别ID【" + sysCodeInfo.getCodeTypeId() + "】的下拉框值【" + sysCodeInfo.getValue() + "】已经存在!");
        }

        // 【3】保存操作
        sysCodeInfo.setVer(1);// 数据版本
        this.save(sysCodeInfo);

        // 【4】处理下拉框显示的内容，是否要按拼音排序。。 新增和修改，要重排序，删除可以不用。
        this.doClacSortNo(sysCodeInfo.getCodeTypeId());

        // 【5】更新缓存
        this.redisService.set(MyConstants.REDIS_SYS_CODE_TYPE + sysCodeInfo.getCodeTypeId(), this.getComboListByCodeTypeId(sysCodeInfo.getCodeTypeId()));

    }

    /**
     * 【3】修改
     *
     * @param dto
     */
    public void updateCodeInfo(SysCodeInfoDTO4Update dto) {
        log.info("【修改--代码信息】" + dto);

        // 【1】 从dto中copy属性
        SysCodeInfo sysCodeInfo = new SysCodeInfo();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysCodeInfo);

        // 【2】检查下拉框value是否重复
        if (isExistCodeInfoValue(sysCodeInfo)) {
            throw new AppException("修改失败,代码类别ID【" + sysCodeInfo.getCodeTypeId() + "】的下拉框值【" + sysCodeInfo.getValue() + "】已经存在!");
        }

        // 【3】更新操作
        if (!this.updateById(sysCodeInfo)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }

        // 【4】处理下拉框显示的内容，是否要按拼音排序。。 新增和修改，要重排序，删除可以不用。
        this.doClacSortNo(sysCodeInfo.getCodeTypeId());

        // 【5】更新缓存
        this.redisService.set(MyConstants.REDIS_SYS_CODE_TYPE + sysCodeInfo.getCodeTypeId(), this.getComboListByCodeTypeId(sysCodeInfo.getCodeTypeId()));
    }

    /**
     * 【4】删除--多个id以逗号分隔
     *
     * @param codeInfoIds
     */
    public void deleteCodeInfo(String codeInfoIds) {
        log.info("【删除--代码信息】" + codeInfoIds);

        // 【1】删除
        String[] codeInfoIdArray = StrUtil.splitToArray(codeInfoIds, ",");
        for (String codeInfoId : codeInfoIdArray) {
            // 【2】读取对象，获取codeTypeId
            SysCodeInfo sysCodeInfo = this.getById(codeInfoId);
            String codeTypeId = sysCodeInfo.getCodeTypeId();

            this.removeById(codeInfoId);

            // 【3】更新缓存
            this.redisService.set(MyConstants.REDIS_SYS_CODE_TYPE + codeTypeId, this.getComboListByCodeTypeId(codeTypeId));

        }
    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/
    /**
     * 【10】获取所有的码值，系统启动时SysCacheService加载到redis。
     *
     * @return
     */
    public List<SysCodeInfo> getAllCodeInfo() {
        // 【1】查询codeInfo
        QueryWrapper<SysCodeInfo> queryWrapper = new QueryWrapper<SysCodeInfo>();
        queryWrapper.orderBy(true, true, "CODE_INFO_ID");
        queryWrapper.orderBy(true, true, "SORT_NO");
        List<SysCodeInfo> codeInfoList = this.list(queryWrapper);

        return codeInfoList;
    }

    /**
     * 【11】通过codeTypeId得到下拉框list数据
     *
     * @param codeTypeId
     * @return
     */
    public List<Combo> getComboListByCodeTypeId(String codeTypeId) {
        // 【1】查询codeInfo
        QueryWrapper<SysCodeInfo> queryWrapper = new QueryWrapper<SysCodeInfo>();
        queryWrapper.orderBy(true, true, "SORT_NO").eq("CODE_TYPE_ID", codeTypeId);
        List<SysCodeInfo> codeInfoList = this.list(queryWrapper);

        // 【2】组装comboList
        List<Combo> comboList = new ArrayList<Combo>();
        comboList.add(new Combo(null, "请选择", null));
        for (SysCodeInfo sysCodeInfo : codeInfoList) {
            comboList.add(new Combo(sysCodeInfo.getValue(), sysCodeInfo.getContent(), sysCodeInfo.getParentValue()));
        }

        return comboList;
    }

    /**
     * 【12】检查下拉框value是否重复
     *
     * @param sysCodeInfo
     * @return
     */
    private boolean isExistCodeInfoValue(SysCodeInfo sysCodeInfo) {
        QueryWrapper<SysCodeInfo> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isEmpty(sysCodeInfo.getCodeInfoId())) {// 新增
            queryWrapper.eq("CODE_TYPE_ID", sysCodeInfo.getCodeTypeId());
            queryWrapper.eq("VALUE", sysCodeInfo.getValue());

        } else {// 修改
            queryWrapper.eq("CODE_TYPE_ID", sysCodeInfo.getCodeTypeId());
            queryWrapper.eq("VALUE", sysCodeInfo.getValue());
            queryWrapper.ne("CODE_INFO_ID", sysCodeInfo.getCodeInfoId());// 不能于
        }

        return this.list(queryWrapper).size() > 0;
    }

    /**
     * 【13】重新计算，按下拉框内容，拼音排序
     *
     * @param codeTypeId
     */
    public void doClacSortNo(String codeTypeId) {
        SysCodeType sysCodeType = this.sysCodeTypeService.getById(codeTypeId);

        if ("1".equals(sysCodeType.getIsPinyin())) {
            QueryWrapper<SysCodeInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("CODE_TYPE_ID", codeTypeId);
            List<SysCodeInfo> list = this.list(queryWrapper);

            Collections.sort(list, new ComparatorPinYin());// 按下拉框内容排序

            int i = 1;
            for (SysCodeInfo sysCodeInfo : list) {
                sysCodeInfo.setSortNo(i++);
                this.updateById(sysCodeInfo);
            }
        }
    }

    /**
     * 【14】功能：实现SysCodeInfo,汉语拼音序比较
     */
    private static class ComparatorPinYin implements Comparator<SysCodeInfo> {
        @Override
        public int compare(SysCodeInfo o1, SysCodeInfo o2) {
            return ToPinYinString(o1.getContent()).compareTo(ToPinYinString(o2.getContent()));
        }

        private String ToPinYinString(String str) {

            StringBuilder sb = new StringBuilder();
            String[] arr = null;

            for (int i = 0; i < str.length(); i++) {
                arr = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));
                if (arr != null && arr.length > 0) {
                    for (String string : arr) {
                        sb.append(string);
                    }
                }
            }

            return sb.toString();
        }
    }
}
