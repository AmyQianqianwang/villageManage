<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>初选项目申报审核情况</title>
<%@ include file="/common/common.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${basePath }css/projectform.css" />
<script type="text/javascript" src="${basePath }js/projectforms.js"></script>
<script>
    function getResult(id,status,st)
    {
    	var str = "";
    	//alert(status);
    	if(status==8)
    	{
			if(id==false)
    			str="不通过";
    		else if(id==true)
    			str="通过";
    		else
    			str="error"; 	
    	}
    	else
    		str="无";
    	document.getElementById("stre_" + st).innerHTML = str;
    }
   
    </script>
</head>

<body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">

		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; <a style="text-decoration: none;"
					href="${basePath }projectFirstStage/index.jsp"> 管理菜单</a> &gt;
					初选项目申报审核情况</span>
			</div>
		</div>

		<div class="forTableSC" id="fss">

			<table id="dataTable" align="center">
				<tr>
					<td>序号</td>
					<td>项目名称</td>
					<td>项目状态</td>
					<td>区县审核意见</td>
					<td>市小城投公司审核意见</td>
					<td>市区审核意见</td>
					<td>审核结果</td>
					<td>操作</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="7">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
					<form name="reportCheck"
						action="${basePath }reportCheck_showReportCheckInfo.action"
						method="post">
						<c:forEach items="${itemList}" var="rcInfo" varStatus="s">
							<tr>
								<td>${(nowPage-1)*(intPageSize)+s.count}</td>
								<td>${rcInfo.project.proName}</td>
								<td id="st_${(nowPage-1)*(intPageSize)+s.count}"><script>getProjectStatusByID(${rcInfo.project.proStatus }, ${(nowPage-1)*(intPageSize)+s.count});</script>
								</td>
								<td>${rcInfo.countryCheckResult}</td>
								<td>${rcInfo.companyCheckResult }</td>
								<td>${rcInfo.cityCheckResult }</td>
								<td id="stre_${(nowPage-1)*(intPageSize)+s.count}"><script>getResult(${rcInfo.checkResult },${rcInfo.project.proStatus },${(nowPage-1)*(intPageSize)+s.count});</script>
								</td>
								<td>
								<input type="submit" value="编辑" name="btnSubmit">
								<input type="hidden" name="reportCheckInfo"
									value="${rcInfo.reportcheckinfoId}" />
								</td>

							</tr>
						</c:forEach>
					</form>

				</c:if>

				<tr class="dataTableFoot">
					<td height="25" colspan="12">
						<form id="PageForm"
							action="${basePath}projectforms_projectVoteInfoList.action"
							method="post">
							<input type="hidden" name="jumpPage" id="jumpPage"
								value="${nowPage}" /> <input type="hidden" name="keyword"
								value="${keyword}" />
						</form> 共有[${intRowCount}]条消息，共[${intPageCount}]页，[${intPageSize
						}条/页]，当前第[${nowPage}]页 &nbsp; <a href="javascript:gotoPage('1')">首页</a>&nbsp;
						<c:if test="${nowPage > 1}">
							<a HREF="javascript:gotoPage('${nowPage - 1}')">上一页</a>
						</c:if> <span id="jumpPageSpan"></span>&nbsp; <c:if
							test="${nowPage < intPageCount}">
							<a HREF="javascript:gotoPage('${nowPage + 1}')">下一页</a>&nbsp;
						</c:if> <a HREF="javascript:gotoPage('${intPageCount}')">尾页</a>&nbsp; 转到
						<SELECT id="selectPage" onchange="gotoPage(this.value);">
							<c:forEach begin="1" end="${intPageCount}" var="j">
								<c:if test="${j==nowPage}">
									<option value="${j}" selected="selected">${j}</option>
								</c:if>
								<c:if test="${j!=nowPage}">
									<option value="${j}">${j}</option>
								</c:if>
							</c:forEach>
					</SELECT> 页</td>
				</tr>
			</table>
		</div>
		<!-- end forTableSC -->

	</div>
	<!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
</body>
</html>
