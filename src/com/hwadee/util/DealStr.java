package com.hwadee.util;

/**
  * @TODO: �ַ�����
  * @date 2014-7-20 ����11:26:18
 */
public class DealStr {

	/**
	  * @TODO: ���ڴ����ַ���������ͨ���ַ���������һ����š���ת�룬����Struts2���Զ�ת��Ŀ��
	  * @date 2014-7-20 ����11:25:24
	 */
	public String codeStringNoEncode(String s) {
		String str = s;
		try {
			str = str.replace("'", "");
			str = str.replace("\"", "��");
			str = str.replace("<", "��");
			str = str.replace(">", "��");
			str = str.replace("--", "��");
			str = str.replace(";", "��");
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
	  * @TODO: ���ڴ����¼ʱ�ķǷ��ַ�
	  * @date 2014-7-20 ����11:25:00
	 */
	public String formatAllString(String s) {
		String str = s;
		try {
			str = str.replace("'", "��");
			str = str.replace(",", "��");
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
