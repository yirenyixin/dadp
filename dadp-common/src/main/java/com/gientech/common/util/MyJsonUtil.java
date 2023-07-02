package com.gientech.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gientech.common.view.Combo;

/**
 * 工具类：实现json字符串和java对象之间互转
 * 
 * @author 胡砥峰
 *
 */
public class MyJsonUtil {

	// 自动忽略，转换类中没有的字段，免得抛异常。
	public static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	/**
	 * 【1a】对象转str
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToStr(Object obj) {
		try {

			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 【2a】str转对象(简单对象)
	 * 
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T strToObj(String str, Class<T> clazz) {
		try {

			return objectMapper.readValue(str, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 【2b】str转List
	 *
	 * @param str
	 * @param beanType
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> strToList(String str, Class<T> beanType) {

		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = objectMapper.readValue(str, javaType);
			return list;
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;
	}

	/**
	 * 【2c】str转Map
	 *
	 * @param str
	 * @param beanType
	 * @param <T>
	 * @return
	 */
	public static <T> Map<String, T> strToMap(String str, Class<T> valueType) {

		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class, valueType);
		try {
			Map<String, T> map = objectMapper.readValue(str, javaType);
			return map;
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;
	}

	/**
	 * 【2d】str转Map对象,【特别注意：此方法只支持Map的key值类型为String类型】
	 * 
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static Map strToMap(String jsonStr) {
		try {

			Map m = objectMapper.readValue(jsonStr, HashMap.class);
			return m;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 【3】str转对象(复杂对象，List，Map等)
	 * 
	 * @param str
	 * @param typeReference 【例1：单个对象】Combo combo2 = strToObj(str, new TypeReference<Combo>() { });
	 * 
	 *                      【例2：list对象】List<Combo> list = strToObj(str, new TypeReference<List<Combo>>() { });
	 * 
	 *                      【例3：map对象】Map<String, Combo> map = strToObj(str, new TypeReference<Map<String, Combo>>() { });
	 * @return
	 */
	public static <T> T strToObj(String str, TypeReference<T> typeReference) {
		try {
			if (StringUtils.isEmpty(str)) {// 空值返回null
				return null;
			}

			return objectMapper.readValue(str, typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		List<Combo> list1 = new ArrayList<Combo>();
		Combo combo1 = new Combo();
		combo1.setValue("1");
		combo1.setContent("男");
		list1.add(combo1);

		Combo combo2 = new Combo();
		combo2.setValue("0");
		combo2.setContent("女");
		list1.add(combo2);

		String str1 = MyJsonUtil.objToStr(list1);

		System.out.println(str1);

		List<Combo> list2 = MyJsonUtil.strToList(str1, Combo.class);
		for (Combo tmp : list2) {
			System.out.println(tmp.getValue() + "【】" + tmp.getContent());
		}

		System.out.println("------------------------------------------------------------------------");

		Map<String, Combo> map1 = new HashMap<String, Combo>();
		Combo combo11 = new Combo();
		combo11.setValue("1");
		combo11.setContent("男");
		map1.put("11", combo11);

		Combo combo22 = new Combo();
		combo22.setValue("0");
		combo22.setContent("女");
		map1.put("22", combo22);

		String str11 = MyJsonUtil.objToStr(map1);

		System.out.println(str11);

		Map<String, Combo> map2 = MyJsonUtil.strToMap(str11, Combo.class);
		System.out.println(map2.get("11").getValue());
		System.out.println(map2.get("22").getValue());

		System.out.println("------------------------------------------------------------------------");
	}
}
