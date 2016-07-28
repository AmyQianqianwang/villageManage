<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>年度成都市项目表决通过情况统计</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
    <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>统计报表 &gt; <a style="text-decoration: none;" href="${basePath }projectForms/index.jsp"> 报表菜单</a> &gt; 年度七大种类项目资金情况统计</span>
			</div>
		</div>
		
		<div class="forSN">
			<div class="inforSN">
				<form>
					<select class="forSelectS">
						<option>成都市</option>
					</select>
					<select class="forSelectS">
						<option>-选择区县-</option>
						<option>项目编号</option>
						<option>项目名称</option>
						<option>项目类别</option>
						<option>项目种类</option>
					</select>
					<select class="forSelectS">
						<option>-选择乡镇-</option>
						<option>项目编号</option>
						<option>项目名称</option>
						<option>项目类别</option>
						<option>项目种类</option>
					</select>
					<select class="forSelectS">
						<option>2014年</option>
						<option>2013年</option>
						<option>2012年</option>
						<option>2011年</option>
						<option>2010年</option>
						<option>2009年</option>
					</select>
					<input type="button" class="forUpload" value="生成报表" />
				</form>
			</div><!-- end inforSN -->
		</div><!-- end forSN -->
		
		<div class="forSNNN">
			<input type="button" id="button_print" name="button_print" value="打印本单据" onclick="javascript:printit('fss');" />
			<input type="button" id="button_bar" name="button_bar" value="形成图表" onclick="javascript:window.location.href='${basePath }projectforms_projectClassifyFundBar.action'" />
		</div><!-- end forSN -->
		
		<div class="forTableSC" id="fss">
		
			<table id="dataTable" align="center">
				<tr>
					<td>序号</td>
					<td>项目名称</td>
					<td>登记时间</td>
					<td>项目类别</td>
					<td>项目种类</td>
					<td>项目来源</td>
					<td>推举时间</td>
					<td>计划完成时间</td>
					<td>实施方法</td>
					<td>项目状态</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="10">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
					<c:forEach items="${itemList}" var="project" varStatus="s">
						<tr>
							<td>${(nowPage-1)*(intPageSize)+s.count}</td>
							<td>${project.proName}</td>
							<td><fmt:formatDate value="${project.recTime }" pattern="yyyy年MM月dd日" /></td>
							<td>${project.proType }</td>
							<td>${project.proKind }</td>
							<td>${project.proSource }</td>
							<td><fmt:formatDate value="${project.electTime }" pattern="yyyy年MM月dd日" /></td>
							<td><fmt:formatDate value="${project.planEndTime }" pattern="yyyy年MM月dd日" /></td>
							<td>${project.impleMethod }</td>
							<td id="st_${(nowPage-1)*(intPageSize)+s.count}"><script>getProjectStatusByID(${project.proStatus }, ${(nowPage-1)*(intPageSize)+s.count});</script></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="dataTableFoot">
					<td height="25" colspan="10">
						<form id="PageForm" action="${basePath}projectforms_projectVoteInfoList.action" method="post">
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
						</c:if> <a HREF="javascript:gotoPage('${intPageCount}')">尾页</a>&nbsp; 转到 <SELECT
						id="selectPage" onchange="gotoPage(this.value);">
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
		</div><!-- end forTableSC -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
</body>
</html>