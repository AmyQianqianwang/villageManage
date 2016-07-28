package com.hwadee.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXml {
	
	public void newXML(List<Object[]> list, String location) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("GB2312");							// 指定XML编码
			XMLWriter writer = new XMLWriter(new FileOutputStream(location),format);
			Document doc = createDoc(list);
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
		}
	}
	
	public Document createDoc(List<Object[]> list) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc
				.addElement("chart")
				.addAttribute("yAxisName", "数量")
				.addAttribute("caption", "年度项目表决通过情况统计图表")
				.addAttribute("showBorder", "1")
				.addAttribute("numberSuffix", "个")
				.addAttribute("imageSave", "1")
				;
		for(Object[] objects:list){
			root.addElement("set")					// 循环添加set
				.addAttribute("label", String.valueOf(objects[0]))
				.addAttribute("value", String.valueOf(objects[1]));
		}
		return doc;
	}
}
