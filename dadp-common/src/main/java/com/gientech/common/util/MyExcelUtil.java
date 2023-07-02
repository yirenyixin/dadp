package com.gientech.common.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyExcelUtil {

	public void exportListToExcel(HttpServletRequest request, HttpServletResponse response, List<?> list, String columnCnNames, String columnNames, String fileName, String sheetName) {
		try {

			// 【1】拼接 导出文件路径
			String path = request.getSession().getServletContext().getRealPath("");
			path = path.replaceAll("\\\\", "/");
			path += "/export/" + DateUtil.today().replace("-", "");// 每天1个文件夹
			String excelShowName = IdUtil.fastSimpleUUID() + ".xlsx";// uuid临时文件
			path += "/" + excelShowName;// uuid临时文件

			// 【2】通过工具类创建writer
			ExcelWriter writer = ExcelUtil.getWriter(path); // 对于大量数据输出，采用ExcelWriter容易引起内存溢出，因此有了BigExcelWriter，使用方法与ExcelWriter完全一致
			writer.setOnlyAlias(true);// 只保留别名中的字段值，多余的字段不导出。

			// 【2.1】处理sheet名
			if (StringUtils.isNotEmpty(sheetName)) {
				writer.renameSheet(0, sheetName);
			}

			String[] columnCnNameArray = StrUtil.splitToArray(columnCnNames, ",");
			String[] columnNameArray = StrUtil.splitToArray(columnNames, ",");
			for (int i = 0; i < columnNameArray.length; i++) {
				writer.addHeaderAlias(columnNameArray[i], columnCnNameArray[i]);
			}

			// 【3】一次性写出内容，使用默认样式，强制输出标题
			writer.write(list, true);

			// 【4】输出到前端浏览器
			response.setContentType("application/vnd.ms-excel;charset=utf-8");

			// 【5】处理输出的文件名
			if (StringUtils.isEmpty(fileName)) {
				response.setHeader("Content-Disposition", "attachment;filename=" + excelShowName);
			} else {
				fileName = URLUtil.encode(fileName, CharsetUtil.CHARSET_UTF_8);// 中文编码
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
			}

			ServletOutputStream out = response.getOutputStream();

			writer.flush(out, true);

			// 关闭writer，释放内存
			writer.close();

			// 此处记得关闭输出Servlet流
			IoUtil.close(out);

		} catch (IOException e) {
			log.error("导出Excel失败." + e.getMessage());
		}
	}

	public void exportListToExcel(HttpServletRequest request, HttpServletResponse response, List<?> list, String columnCnNames, String columnNames, String fileName) {
		this.exportListToExcel(request, response, list, columnCnNames, columnNames, fileName, null);
	}

	public void exportListToExcel(HttpServletRequest request, HttpServletResponse response, List<?> list, String columnCnNames, String columnNames) {
		this.exportListToExcel(request, response, list, columnCnNames, columnNames, null, null);
	}

}
