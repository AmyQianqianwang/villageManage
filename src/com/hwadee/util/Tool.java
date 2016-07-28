package com.hwadee.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
  * @TODO: 工具类
  * @author LUO-Administrator
  * @date 2014-7-20 下午11:13:13
 */
public class Tool {
	
	//创建日期格式
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 时间日期格式
	 */
	private static SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	  * @TODO: 项目状态号—>状态字符串
	  * @author LUO-Administrator
	  * @date 2014-7-22 下午9:38:16
	 */
	public static String getProjectStatusStringByID(int id) {
		String str = "";
		if (id <= 0) {
			str = "暂停状态";
		} else {
			switch (id) {
			case 1:
				str = "原始项目未提交";
				break;
			case 2:
				str = "原始项目未表决";
				break;
			case 3:
				str = "初选项目未实施计划";
				break;
			case 4:
				str = "初选项目未议事完善";
				break;
			case 5:
				str = "初选项目未表决";
				break;
			case 6:
				str = "初选项目区县未申报";
				break;
			case 7:
				str = "初选项目城投未审核";
				break;
			case 8:
				str = "初选项目市级未申报";
				break;
			case 9:
				str = "初选项目实施（竞岗、实施、比选、自建）";
				break;
			case 10:
				str = "项目进度监督";
				break;
			case 11:
				str = "项目经费监督";
				break;
			case 12:
				str = "项目评议/验收";
				break;
			case 13:
				str = "项目评测";
				break;
			case 14:
				str = "项目完成且通过";
				break;
			case 15:
				str = "项目完成未通过";
				break;
			case 16:
				str = "项目中途取消";
				break;
			default:
				str = "";
			}
		}
		return str;
	}
	
	
	/**
	 * 
	 * @TODO String转化为Date
	 * @author GUO
	 * @data 2014-7-23上午8:26:44
	 * @param strDate
	 * @return
	 */
	public static final Date StringToDate(String strDate) {
		Date date = new Date();
		// 注意format的格式要与日期String的格式相匹配
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
	
	/** 按yyyy-MM-dd格式格式化日期 */
	public static String formatDate(Date date){   
		if (date==null){
			return "";
		}else{
			return df.format(date);
		}
    }
	
	/**
	 * @TODO:按1900-01-31 23:00:22格式返回时间日期字符串
	 * @author Dong 
	 * @date 2014-7-22下午9:28:37
	 */
	public static String formatDateTime(Date date){
		if(date==null){
			return "";
		}else{
			return dtf.format(date);
		}
	}
	
	/**
	 * @TODO:日期字符串转日期
	 * @author Dong 
	 * @date 2014-7-22下午7:10:20
	 * @param dateStr 1900-01-31 格式
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
	 * @TODO:根据字符串返回时间日期
	 * @author Dong 
	 * @date 2014-7-22下午9:29:41
	 * @param dateTimeStr 1900-01-31 23:00:22 格式
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
