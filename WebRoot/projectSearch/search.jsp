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
    <title>综合查询</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
    <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
<style type="text/css">
input,select{font-family:"微软雅黑";}
#userTable {table-layout: fixed;}
#userTable tr td{overflow: hidden;white-space: nowrap;text-overflow: ellipsis;} 
</style>
  </head>
  
  <body>
	
	<jsp:include page="/common/header.jsp" />
	
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 综合查询</span>
			</div>
		</div>
		
		<div class="forSN">
			<div class="inforSN">
				<form method="post" action="${basePath}s_search.action">
					<select class="forSelectS" name="selType">
						<option value="proId" id="proId">项目编号</option>
						<option value="proName" id="proName">项目名称</option>
						<option value="proType" id="proType">项目类别</option>
						<option value="proKind" id="proKind">项目种类</option>
						<option value="unitName" id="unitName">单位名称</option>
					</select>
					<input type="text" class="forDate" name="selValue" value="${selValue}"/>
					<input type="submit" class="forUpload" value="查询" />
					<script type="text/javascript"> 
						window.document.getElementById("${selType}").setAttribute('selected','selected'); 
					</script>
				</form>
			</div><!-- end inforSN -->
		</div>
		
		<div class="forTableSC" id="fss">
			<table id="userTable" align="center">
				<tr style="background: #ddd; height: 25px;">
					<td style="width:40px;">序号</td>
					<td>项目编号</td>
					<td>项目名称</td>
					<td>项目状态</td>
					<td>起始时间</td>
					<td>结束时间</td>
					<td>启动人</td>
					<td>项目来源</td>
					<td>项目种类</td>
					<td>项目类别</td>
					<td>建议户数</td>
				</tr>
				<c:if test="${empty proList}">
					<tr>
						<td colspan="11">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty proList}">
					<c:forEach items="${proList}" var="r" varStatus="s">
						<tr class="dataTable">
							<td style="width:40px;">${(nowPage-1)*(intPageSize)+s.count}</td>
							<td title="${r.proId}">${r.proId}</td>
							<td title="${r.proName}">${r.proName}</td>
							<td id="st_${(nowPage-1)*(intPageSize)+s.count }">
							<script type="text/javascript">
							getProjectStatusByID(${r.proStatus }, "${(nowPage-1)*(intPageSize)+s.count }");
							</script> </td>
							<td title="${r.electTime}">${r.electTime}</td>
							<td title="${r.planEndTime}">${r.planEndTime}</td>
							<td title="${r.user.userName}">${r.user.userName}</td>
							<td title="${r.proSource}">${r.proSource}</td>
							<td title="${r.proKind}">${r.proKind}</td>
							<td title="${r.proType}">${r.proType}</td>
							<td title="${r.familyCount}">${r.familyCount}</td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="dataTableFoot">
					<td height="25" colspan="11">
						<form id="PageForm" action="${basePath}s_search.action" method="post">
							<input type="hidden" name="jumpPage" id="jumpPage"value="${nowPage}" /> 
							
							<input type="hidden" name="selType"	value="${selType}" />
							<input type="hidden" name="selValue" value="${selValue}" />
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
	<script type="text/javascript" src="${basePath}js/tool.js"></script>
</body>
</html>