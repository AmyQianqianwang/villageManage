package com.hwadee.util;

/**
  * @TODO: 字符编码
  * @date 2014-7-20 下午11:26:18
 */
public class DealStr {

	/**
	  * @TODO: 用于处理字符串，用于通用字符处理，过滤一般符号、不转码，用于Struts2等自动转码的框架
	  * @date 2014-7-20 下午11:25:24
	 */
	public String codeStringNoEncode(String s) {
		String str = s;
		try {
			str = str.replace("'", "");
			str = str.replace("\"", "“");
			str = str.replace("<", "＜");
			str = str.replace(">", "＞");
			str = str.replace("--", "，");
			str = str.replace(";", "；");
			str = str.replace("/*", "");
			str = str.replace("*/", "");
			str = str.replace("xp_", "");
			str = str.trim();
			return str;
		} catch (Exception e) {
			return str;
		}
	}

	/**
	  * @TODO: 用于处理登录时的非法字符
	  * @date 2014-7-20 下午11:25:00
	 */
	public String formatAllString(String s) {
		String str = s;
		try {
			str = str.replace("'", "‘");
			str = str.replace(",", "，");
			str = str.replace("+", "");
			str = str.replace("-", "");
			str = str.replace("*", "");
			str = str.replace("/", "");
			str = str.replace("<", "");
			str = str.replace(">", "");
			str = str.replace(".", "");
			str = str.replace("!", "");
			str = str.replace("@", "");
			str = str.replace("#", "");
			str = str.replace("$", "");
			str = str.replace("%", "");
			str = str.replace("^", "");
			str = str.replace("&", "");
			str = str.replace("(", "");
			str = str.replace(")", "");
			str = str.replace("|", "");
			str = str.replace("?", "");
			str = str.replace("/*", "");
			str = str.replace("*/", "");
			str = str.replace("xp_", "");
			str = str.replace("--", "");
			str = str.trim();
			return str;
		} catch (Exception e) {
			return str;
		}
	}
}
