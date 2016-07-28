package com.hwadee.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
  * @TODO: ������
  * @author LUO-Administrator
  * @date 2014-7-20 ����11:13:13
 */
public class Tool {
	
	//�������ڸ�ʽ
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * ʱ�����ڸ�ʽ
	 */
	private static SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	  * @TODO: ��Ŀ״̬�š�>״̬�ַ���
	  * @author LUO-Administrator
	  * @date 2014-7-22 ����9:38:16
	 */
	public static String getProjectStatusStringByID(int id) {
		String str = "";
		if (id <= 0) {
			str = "��ͣ״̬";
		} else {
			switch (id) {
			case 1:
				str = "ԭʼ��Ŀδ�ύ";
				break;
			case 2:
				str = "ԭʼ��Ŀδ���";
				break;
			case 3:
				str = "��ѡ��Ŀδʵʩ�ƻ�";
				break;
			case 4:
				str = "��ѡ��Ŀδ��������";
				break;
			case 5:
				str = "��ѡ��Ŀδ���";
				break;
			case 6:
				str = "��ѡ��Ŀ����δ�걨";
				break;
			case 7:
				str = "��ѡ��Ŀ��Ͷδ���";
				break;
			case 8:
				str = "��ѡ��Ŀ�м�δ�걨";
				break;
			case 9:
				str = "��ѡ��Ŀʵʩ�����ڡ�ʵʩ����ѡ���Խ���";
				break;
			case 10:
				str = "��Ŀ���ȼල";
				break;
			case 11:
				str = "��Ŀ���Ѽල";
				break;
			case 12:
				str = "��Ŀ����/����";
				break;
			case 13:
				str = "��Ŀ����";
				break;
			case 14:
				str = "��Ŀ�����ͨ��";
				break;
			case 15:
				str = "��Ŀ���δͨ��";
				break;
			case 16:
				str = "��Ŀ��;ȡ��";
				break;
			default:
				str = "";
			}
		}
		return str;
	}
	
	
	/**
	 * 
	 * @TODO Stringת��ΪDate
	 * @author GUO
	 * @data 2014-7-23����8:26:44
	 * @param strDate
	 * @return
	 */
	public static final Date StringToDate(String strDate) {
		Date date = new Date();
		// ע��format�ĸ�ʽҪ������String�ĸ�ʽ��ƥ��
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date = sdf.parse(strDate);
			// System.out.println(date.toString());
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** ��yyyy-MM-dd��ʽ��ʽ������ */
	public static String formatDate(Date date){   
		if (date==null){
			return "";
		}else{
			return df.format(date);
		}
    }
	
	/**
	 * @TODO:��1900-01-31 23:00:22��ʽ����ʱ�������ַ���
	 * @author Dong 
	 * @date 2014-7-22����9:28:37
	 */
	public static String formatDateTime(Date date){
		if(date==null){
			return "";
		}else{
			return dtf.format(date);
		}
	}
	
	/**
	 * @TODO:�����ַ���ת����
	 * @author Dong 
	 * @date 2014-7-22����7:10:20
	 * @param dateStr 1900-01-31 ��ʽ
	 */
	public static Date toDate(String dateStr){
		if(dateStr!=null){
			try{
				return df.parse(dateStr);
			}catch(Exception e){}
		}
		return null;
	}
	
	/**
	 * @TODO:�����ַ�������ʱ������
	 * @author Dong 
	 * @date 2014-7-22����9:29:41
	 * @param dateTimeStr 1900-01-31 23:00:22 ��ʽ
	 */
	public static Date toDateTime(String dateTimeStr){
		if(dateTimeStr!=null){
			try{
				return df.parse(dateTimeStr);
			}catch(Exception e){}
		}
		return null;
	}
}
