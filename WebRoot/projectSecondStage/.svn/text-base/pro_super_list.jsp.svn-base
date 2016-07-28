<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    <title>进度监督与检查</title>
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
				<span>项目管理   &gt; <a style="text-decoration: none;" href="${basePath }projectSecondStage/index.jsp"> 项目实施与监察</a> &gt; 进度监督与检查</span>
			</div>
		</div>

		<div class="forTableSC" id="fss">
		
			<table id="dataTable" align="center">
				<tr>
					<td>序号</td>
					<td>项目编号</td>
					<td>项目名称</td>
					<td>实施方法</td>
					<td>操作</td>
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
							<td>${project.proId}</td>
							<td>${project.proName}</td>
							<td>${project.impleMethod}</td>
							<td>
								<a href="${basePath}implement_getInfoPage.action?proID=${project.proId}" 
									target="_self">详情</a>
							</td>
						</tr>
					</c:forEach>
				
				</c:if>
				
				<tr class="dataTableFoot">
					<td height="25" colspan="12">
						<form id="PageForm" action="${basePath}check_getPSList.action" method="post">
							<input type="hidden" name="jumpPage" id="jumpPage"
								value="${nowPage}" /> <input type="hidden" name="keyword"
								value="${keyword}" />
						</form> 共有[${intRowCount}]条消息，共[${intPageCount}]页，[${intPageSize
						}条/页]，当前第[${nowPage}]页 &nbsp; <a href="javascript:gotoPage('1')">首页</a>&nbsp;
						<c:if test="${nowPage > 1}">
							<a href="javascript:gotoPage('${nowPage - 1}')">上一页</a>
						</c:if> <span id="jumpPageSpan"></span>&nbsp; <c:if
							test="${nowPage < intPageCount}">
							<a href="javascript:gotoPage('${nowPage + 1}')">下一页</a>&nbsp;
						</c:if> <a href="javascript:gotoPage('${intPageCount}')">尾页</a>&nbsp; 转到 
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
		</div><!-- end forTableSC -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
  </body>
</html>
