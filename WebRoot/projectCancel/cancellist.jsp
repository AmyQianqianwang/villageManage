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
    <title>项目取消</title>
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
				<span>项目取消&gt; 取消项目列表</span>
			</div>
		</div>
		
		<div class="forTableSC" id="fss">
		
			<table id="userTable" align="center">
				<tr style="background: #ddd; height: 25px;">
					<td>序号</td>
					<td>项目名称</td>
					<%--<td>项目类别</td>
					--%>
					<td>项目种类</td>
					<td>项目来源</td>
					<td>推举时间</td>
					<td>计划完成时间</td>
					<td>实施方法</td>
					<td>项目状态</td>
					<td>取消项目</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="9">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
					<c:forEach items="${itemList}" var="project" varStatus="s">
						<tr class="dataTable">
							<td>${(nowPage-1)*(intPageSize)+s.count}</td>
							<td>${project.proName}</td>
							<%--<td>${project.proType }</td>
							--%>
							<td>${project.proKind }</td>
							<td>${project.proSource }</td>
							<td><fmt:formatDate value="${project.electTime }" pattern="yyyy年MM月dd日" /></td>
							<td><fmt:formatDate value="${project.planEndTime }" pattern="yyyy年MM月dd日" /></td>
							<td>${project.impleMethod }</td>
							<td id="st_${(nowPage-1)*(intPageSize)+s.count}"><script>getProjectStatusByID(${project.proStatus }, ${(nowPage-1)*(intPageSize)+s.count});</script></td>
							<td>
								<c:choose>
									<c:when test="${project.proStatus == 16 }">
										已取消
									</c:when>
									<c:otherwise>
										<a href="javascript:deleteproject('${project.proId}');">取消</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="dataTableFoot">
					<td height="25" colspan="9">
						<form id="PageForm" action="${basePath}projectc_cancelList.action" method="post">
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
	<script>
		function deleteproject(id){
			if(confirm('确定取消吗？')){
				window.location.href='${basePath }'+"projectc_cancel.action?id=" + id;
			}
		}
	</script>
</body>
</html>