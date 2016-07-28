<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>参考列表</title>
<%@ include file="/common/common.jsp"%>
 <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
   <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
<script type="text/javascript">
	function ChangeSelect(o) {
		var obj = o.selectedIndex;
		var e = document.mainform.impleMethod;
		for ( var i = e.options.length; i >= 0; i--)
			e.remove(i);
		if (obj == 1) { //如果选择的值是 0 
			//document.impleMethod.options.length = 0; //初始化select2
			e.options.add(new Option("比选", "比选"));
			e.options.add(new Option("自建", "自建"));
			/* document.impleMethod.options[1] = new Option("比选", "比选");
			document.impleMethod.optinos[2] = new Option("自建", "自建"); */
		} else {
			//document.impleMethod.options.length = 0;
			e.options.add(new Option("竞岗", "竞岗"));
			e.options.add(new Option("直接实施", "直接实施"));
			/* 	document.impleMethod.options[1] = new Option("竞岗", "竞岗");
				document.impleMethod.optinos[2] = new Option("直接实施", "直接实施"); */
		}
	}

	function btnSaveOrbtnSubmit(str) {
		//alert(str);
		document.getElementById("typeSubmit").value = str;
		document.mainform.submit();
	}
</script>
</head>

<body>

	<jsp:include page="/common/header.jsp" />

	<div class="mainTable">

		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 原始项目表决</span>
			</div>
		</div>

		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
					<td id="st_${(nowPage-1)*(intPageSize)+s.count}"><script>getProjectStatusByID(${project.proStatus }, ${(nowPage-1)*(intPageSize)+s.count});</script></td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<!-- <td>四川省成都市华迪实训公司集团xxxxxxxxxxxx</td> -->
					<td>${project.unitName }</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<!-- <td>张三</td> -->
					<td>${project.user.userName }</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>${project.paddingTime }</td>
				</tr>

			</table>
		</div>

		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">
			<%-- <form name="mainform" class="initialTable" action="${basePath }project_outString.action" method="post"> --%>
			<form name="mainform" class="initialTable"
				action="${basePath }project_insertProjectInfo.action" method="post">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span>项目编号</span>
						</td>
						<td><input type="text" class="forDate" name="proID"
							value="${project.proId}" />
						</td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目名称</span>
						</td>
						<td><input type="text" name="proName" class="forText"
							value="${project.proName}" />
						</td>
					</tr>
					<tr>
						<!-- 登记时间为当前时间（默认值） -->
						<td><span class="forPoint">*&nbsp;</span><span>项目登记时间</span>
						</td>
						<td><input type="text" name="recTime" class="forDate getDate"
							value="${project.recTime}" /></td>
					</tr>

					<tr>
						<!-- 项目类别 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目类别</span>
						</td>
						<td>
							<!-- ITClass = Initial Table Class --> <select class="forSelect"
							name="proType" id="ITClass" onchange="ChangeSelect(this)">
								<option value="">---请选择---</option>
								<option value="基础建设类">基础建设类</option>
								<option value="公共服务类">公共服务类</option>
						</select></td>
					</tr>
					<tr>
						<!-- 项目种类 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目种类</span>
						</td>
						<td><select class="forSelect" name="proKind">
								<option value="">---请选择---</option>
								<option value="文体类">文体类</option>
								<option value="教育类">教育类</option>
								<option value="医疗卫生类">医疗卫生类</option>
								<option value="社会就业保障类">社会就业保障类</option>
								<option value="农村基础设施和环境建设类">农村基础设施和环境建设类</option>
								<option value="农村生产服务类">农村生产服务类</option>
								<option value="社会管理类">社会管理类</option>
						</select></td>
					</tr>
					<tr>
						<!-- 项目内容 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目内容</span>
						</td>
						<td><textarea class="forTextarea" name="proText" rows="5"
								cols="5" >${project.proContext}</textarea>
						</td>
					</tr>
					<tr>
						<!--项目来源 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目来源 </span>
						</td>
						<td><select class="forSelect" name="proSourse">
								<option value="">---请选择---</option>
								<option value="村民推荐">村民推荐</option>
								<option value="两委建议">两委建议</option>
						</select></td>
					</tr>
					<tr>
						<!-- 建议户数 -->
						<td><span>建议户数</span>
						</td>
						<td><input type="text" class="forDate" name="familyCount"
							value="${project.familyCount}" />
						</td>
					</tr>
					<tr>
						<!-- 项目推荐时间 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目推荐时间</span>
						</td>
						<td><input type="text" class="forDate getDate"
							name="electTime" value="${project.electTime}" /></td>
					</tr>
					<tr>
						<!-- 项目计划完成时间 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目计划完成时间</span>
						</td>
						<td><input type="text" class="forDate getDate"
							name="planEndTime" value="${project.planEndTime}" /></td>
					</tr>
					<tr>
						<!-- 项目实施方法 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目实施方法</span>
						</td>
						<td><select class="forSelect" id="ITDoWay" name="impleMethod">
								<!-- <option value="">---请选择---</option>
								<option value="01">比选/自建</option>
								<option value="02">竞岗/直接实施</option> -->

						</select></td>
					</tr>
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span>
						</td>
						<td><input type="button" class="forUpload" value="上传"
							name="attachment" /></td>
					</tr>
					<tr>
						<td></td>
						<td>放置上传的附件</td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span>
						</td>
						<td colspan="4"><textarea class="forTextarea" rows="5"
								cols="5" name="tableComment" >${project.tableComment}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
								<input type="button" name="btnSave" class="forBtn" value="保存"
									onclick="javascript:btnSaveOrbtnSubmit('sa');" /> <input
									type="reset" name="btnReset" id="reset" class="forBtn"
									value="重置" /> <input type="button" name="btnSubmit"
									class="forBtn" value="提交"
									onclick="javascript:btnSaveOrbtnSubmit('su');" /> <input
									type="hidden" name="typeSubmit" id="typeSubmit" value="" />
									<input type="hidden" name="projectProID" value="${project.proId }"/>
							</center></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- end fillTable -->
	</div>
	<!-- end mianTable -->


	<jsp:include page="/common/footer.jsp" />
	<script>
		function init() {
			$("select[name=proType] option[value='${project.proType }']").attr(
					"selected", "selected");
			$("select[name=proKind] option[value='${project.proKind }']").attr(
					"selected", "selected");
			$("select[name=proSourse] option[value='${project.proSource }']")
					.attr("selected", "selected");
			ChangeSelect(document.mainform.proType);
			$("select[name=impleMethod] option[value='${project.impleMethod }']")
					.attr("selected", "selected");
		}
		init();
	</script>
</body>
</html>