package com.gientech.common.util;

import org.apache.commons.lang3.StringUtils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * String转换,判断--工具类
 *
 * @author 胡砥峰
 */
public class MyStringUtil {

	/**
	 * mybatis查询的时候,给属性条件加上%%,以使用LIKE通配符查询
	 *
	 * @param obj  查询条件的对象
	 * @param name 需要增加%的属性,以逗号分割
	 */
	public static void addObjectLike(Object obj, String name) {
		try {
			if (StringUtils.isNotEmpty(name)) {
				String[] nameArray = name.split(",");

				for (String fieldName : nameArray) {
					String value = BeanUtil.getProperty(obj, fieldName);

					if (StringUtils.isNotEmpty(value)) {
						BeanUtil.setProperty(obj, fieldName, "%" + value + "%");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * mybatis查询的时候,给属性条件左边加上%,以使用LIKE通配符查询
	 *
	 * @param obj  查询条件的对象
	 * @param name 需要增加%的属性,以逗号分割
	 */
	public static void addObjectLikeLeft(Object obj, String name) {
		try {
			if (StringUtils.isNotEmpty(name)) {
				String[] nameArray = name.split(",");

				for (String fieldName : nameArray) {
					String value = BeanUtil.getProperty(obj, fieldName);

					if (StringUtils.isNotEmpty(value)) {
						BeanUtil.setProperty(obj, fieldName, "%" + value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * mybatis查询的时候,给属性条件右边加上%,以使用LIKE通配符查询
	 *
	 * @param obj  查询条件的对象
	 * @param name 需要增加%的属性,以逗号分割
	 */
	public static void addObjectLikeRight(Object obj, String name) {
		try {
			if (StringUtils.isNotEmpty(name)) {
				String[] nameArray = name.split(",");

				for (String fieldName : nameArray) {
					String value = BeanUtil.getProperty(obj, fieldName);

					if (StringUtils.isNotEmpty(value)) {
						BeanUtil.setProperty(obj, fieldName, value + "%");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到排序字段，如果排序字段长度不一致，返回默认排序条件
	 *
	 * @param pageInfo
	 * @param defaultOrderBy 默认排序条件
	 */
	public static String getOrderBy(String sort, String order, String defaultOrderBy) {
		String orderBy = "";
		if (StrUtil.isBlank(sort) || StrUtil.isBlank(order)) {
			return defaultOrderBy;
		}
		String[] sortArray = StrUtil.splitToArray(sort, ",");
		String[] orderArray = StrUtil.splitToArray(order, ",");

		if (sortArray.length == orderArray.length && sortArray.length > 0) {
			for (int i = 0; i < orderArray.length; i++) {
				orderBy += sortArray[i] + " " + orderArray[i] + ",";
			}

			if (orderBy.endsWith(",")) {// 去除最后那个逗号
				orderBy = StringUtils.substringBeforeLast(orderBy, ",");
			}
			return orderBy;
		} else {
			return defaultOrderBy;
		}

	}

	/**
	 * 验证[某字符串]是否存在于逗号分隔的字符串中
	 *
	 * @param str       【abc,123,www】
	 * @param substr    【123】
	 * @param sepatator 【,】
	 * @return
	 */
	public static boolean isExist(String str, String substr, String sepatator) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}

		if (StringUtils.isEmpty(substr)) {
			return false;
		}

		String[] strArray = StrUtil.splitToArray(str, ",");
		for (String tmp : strArray) {
			if (tmp.equals(substr)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 在数字面前补0; addPrefix(1, 4); 返回的是 0001
	 *
	 * @param value 数字.
	 * @param num   返回几位数
	 * @return
	 */
	public static String addPrefix(Integer value, int num) {
		String ret = String.valueOf(value);

		for (int i = 0, len = num - ret.length(); i < len; i++) {
			ret = "0" + ret;
		}

		return ret;
	}

	public static void main(String[] args) {

		System.out.println(StrUtil.toCamelCase("SAMPLE_ID"));// sampleId，驼峰法

		System.out.println(SecureUtil.md5("test"));

		System.out.println(StringUtils.leftPad("123", 6, "0"));
		System.out.println(StringUtils.leftPad("123", 6));
	}
}
