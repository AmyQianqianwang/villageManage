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
				<span>统计报表 &gt; <a style="text-decoration: none;" href="${basePath }projectForms/index.jsp"> 报表菜单</a> &gt;年度县级项目资金使用情况统计图表</span>
			</div>
		</div>
		
		<div class="forSNNN">
			<input type="button" id="button_back" name="button_back" value="返回列表" onclick="javascript:window.location.href='${basePath }projectforms_projectCountryFundList.action'" />
		</div><!-- end forSN -->
		
		<div class="forTableSC" id="fss">
		
			<table id="dataTable" align="center">
				<c:if test="${!empty itemList}">
						<tr>
							<c:forEach items="${itemList}" var="item" varStatus="s">
							<td>${item[0] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${itemList}" var="item" varStatus="s">
							<td>${item[1] }个</td>
							</c:forEach>
						</tr>
				</c:if>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="${size }">暂无数据</td>
					</tr>
				</c:if>
			</table>
		</div><!-- end forTableSC -->
				
		<div class="forTableSC formbar">
			<div id="chartdiv"></div>
		</div><!-- end forTableSC -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
	
	<script language="JavaScript" type="text/javascript"
	src="${basePath }plugins/fusionCharts/js/FusionCharts.js"></script>
	<script type="text/javascript">
		createChart("${dataurl}");
		function createChart(url) {
			var myChart = new FusionCharts(
					"plugins/fusionCharts/swf/Column3D.swf", "myChartId",
					"1000", "500");
			var url = "plugins/dataXml/" + url;
			myChart.setDataURL(url);
			myChart.render("chartdiv");
		}
	</script>
</body>
</html>