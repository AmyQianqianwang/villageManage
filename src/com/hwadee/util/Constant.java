package com.hwadee.util;

public class Constant {

	/**
	 * 以个人为单位投票
	 */
	public static final int SENOND_MELT_VOTE_PERSONAL=0;
	/**
	 * 以户为单位投票
	 */
	public static final int SENOND_MELT_VOTE_FAMILY=1;

	/**
	 * 原始项目表决
	 */
	public static final int FIRST_VOTE = 0;

	/**
	 * 初选项目融资表决
	 */
	public static final int SECOND_MELT_VOTE = 1;

	/**
	 * 初选项目非融资表决
	 */
	public static final int SECOND_VOTE = 2;

	public static final int OK = 1;
	public static final int FAILD = 0;

	/**
	 * @TODO:项目实施方法公共字符串
	 * @author Dong
	 * 
	 */

	/**
	 * 竞岗
	 */
	public static final String JOB_COMPET = "竞岗项目";
	/**
	 * 直接实施
	 */
	public static final String DIR_EXEC = "直接实施";
	/**
	 * 比选
	 */
	public static final String COMPARE_SELECT = "比选项目";
	/**
	 * 自建
	 */
	public static final String SELF_BUILD = "自建项目";

	/**
	 * END
	 */

	/**
	 * 暂停项目取当前值的负值
	 * 
	 * @TODO:项目状态编号
	 * @author Dong
	 */

	/**
	 * 原始项目未提交
	 */
	public static final int ORIGIN_UNCOMMIT = 1;
	/**
	 * 原始项目未投票
	 */
	public static final int ORIGIN_UNVOTED = 2;
	/**
	 * 初选项目未填写实施计划
	 */
	public static final int PRESELECTION_UNPLAN = 3;
	/**
	 * 初选项目未议事完善
	 */
	public static final int PRESELECTION_UNCOMPLETE = 4;
	/**
	 * 初选项目未投票
	 */
	public static final int PRESELECTION_UNVOTED = 5;
	/**
	 * 初选项目区县未申报
	 */
	public static final int PRESELECTION_UNREPORT_COUNTRY = 6;
	/**
	 * 初选项目城投公司未审核
	 */
	public static final int PRESELECTION_UNCHECK_COMPANY = 7;
	/**
	 * 初选项目市级未申报
	 */
	public static final int PRESELECTION_UNREPORT_CITY = 8;
	/**
	 * 项目实施阶段（竞岗、直接实施、比选、自建）
	 */
	public static final int PROJECT_IMPLEMENT = 9;
	/**
	 * 项目进度监督
	 */
	public static final int PROJECT_PROGRESS_SUPERVISION = 10;
	/**
	 * 项目经费监督
	 */
	//public static final int PROJECT_FUNDS_SUPERVISISON = 11;
	public static final int PROJECT_FUNDS_SUPERVISION=11;
	/**
	 * 项目未评议/验收
	 */
	public static final int WAIT_COMMENT_OR_ACCPTION = 12;
	/**
	 * 项目未评测
	 */
	public static final int WAIT_EVALUATING = 13;
	/**
	 * 项目通过
	 */
	public static final int PROJECT_PASSED = 14;
	/**
	 * 项目未通过
	 */
	public static final int PROJECT_FAILED = 15;
	/**
	 * 项目取消
	 */
	public static final int PROJECT_CANCELED = 16;

	/**
	 * END
	 */
	
	/**
	 * 项目类型(ProType)公字符串 
	 */
	
	/**
	 * 基础设施类项目   for ProType
	 */
	public static final String BASIC_DEVICES="基础设施类";
	
	/**
	 * 公共服务类项目 for ProType
	 */
	public static final String PUBLIC_SERVICE="公共服务类";
	
	/**
	 *  END
	 */
}
