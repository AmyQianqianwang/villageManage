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
    <title>统计报表菜单</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>统计报表 &gt; 报表菜单</span>
			</div>
		</div>
		
		<div class="formCol">
			<div class="grid_left">
				<a href="${basePath }projectforms_projectVoteInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">表决通过情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }projectforms_projectCountryClassifyList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">县级项目分类情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }projectforms_projectCountryCheckedList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">县级项目验收评议情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_right">
				<a href="${basePath }projectforms_projectCountrySpecialFundList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">县级项目专项资金使用情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_left">
				<a href="${basePath }projectforms_projectCountryFundList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">县级项目资金使用情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }projectforms_projectClassifyFundList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">七大种类项目资金情况统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }projectforms_villageResidentCount.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">村（居）民数量分布统计</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
		</div><!-- end forSN -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />

</body>
</html>