<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>待评议项目（公共服务类）</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
    <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
<style type="text/css">
input,select{font-family:"微软雅黑";}
#userTable {table-layout: fixed;}
#userTable tr td{overflow: hidden;white-space:nowrap; text-overflow: ellipsis;} 
</style>
  </head>
  
  <body>
	
	<jsp:include page="/common/header.jsp" />
	
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 待评议项目（公共服务类）列表</span>
			</div>
		</div>
		
		<div class="forTableSC">
			<!-- 列表标题 -->
			<div class="rowStyleTh">
				<div class="colStyleNum">序号</div>
				<div class="colStyleNo colTh">项目编号</div>
				<div class="colStyleName colTh">项目名称</div>
				<div class="colStyleSort colTh">项目类别</div>
				<div class="colStyleSort colTh">项目种类</div>
				<div class="colStyleSort colTh">操作</div>
			</div>
			<c:if test="${empty proList}">
			<div class="rowStyle" style="text-align:center;line-height:50px;">
				<span style="font-weight:bold;">暂无数据！</span>
			</div><!-- end rowStyle -->
			</c:if>
			<c:forEach items="${proList}" var="r" varStatus="s">
			<div class="rowStyle">
				<div class="colStyleNum">${s.count}</div>
				<div class="colStyleNo" title="${r.proId}">${r.proId}</div>
				<div class="colStyleName" title="${r.proName}">${r.proName}</div>
				<div class="colStyleSort" title="${r.proType}">${r.proType}</div>
				<div class="colStyleSort" title="${r.proKind}">${r.proKind}</div>
				<div class="edit">
					<div class="forImgIcon" style="margin-left:35px; margin-right:3px;">
						<img src="${basePath }images/icon_pen.png" alt="评议" />
					</div>
					<div class="forA">
						<a href="${basePath}comment_preAdd.action?proId=${r.proId}" target="_self">评议</a>
					</div>										
				</div>
			</div><!-- end rowStyle -->
			</c:forEach>
			<!-- 页码 -->
			<table id="userTable" align="center" style="width:90%;">
			<tr class="dataTableFoot" >
					<td height="25" colspan="1">
						<form id="PageForm" action="${basePath}s_search.action" method="post">
							<input type="hidden" name="jumpPage" id="jumpPage"value="${nowPage}" /> 
							
						</form> 共有[${intRowCount}]条消息，共[${intPageCount}]页，[${intPageSize}条/页]，当前第[${nowPage}]页 &nbsp; 
						<a href="javascript:gotoPage('1')">首页</a>&nbsp;
						<c:if test="${nowPage > 1}">
							<a href="javascript:gotoPage('${nowPage - 1}')">上一页</a>
						</c:if> <span id="jumpPageSpan"></span>&nbsp; <c:if
							test="${nowPage < intPageCount}">
							<a href="javascript:gotoPage('${nowPage + 1}')">下一页</a>&nbsp;
						</c:if> <a href="javascript:gotoPage('${intPageCount}')">尾页</a>&nbsp; 转到 
						<select id="selectPage" onchange="gotoPage(this.value);">
							<c:forEach begin="1" end="${intPageCount}" var="j">
								<c:if test="${j==nowPage}">
									<option value="${j}" selected="selected">${j}</option>
								</c:if>
								<c:if test="${j!=nowPage}">
									<option value="${j}">${j}</option>
								</c:if>
							</c:forEach>
					</select> 页</td>
				</tr>
			</table>
		</div><!-- end forTableSC -->

	</div><!-- end mianTable -->
	
	<jsp:include page="/common/footer.jsp" />

</body>
</html>