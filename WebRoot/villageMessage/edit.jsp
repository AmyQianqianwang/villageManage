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
    <title>首页</title>
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
				<span>首页 &gt; 概况信息</span>
			</div>
		</div>
		<form action="${basePath }index_edit.action" method="post">
			<div class="villageSN">
				<input type="text" name="pCount" value="${location.peopleCount }" /><label>人</label>
			</div><!-- end forSN -->
				
			<div class="villageMessage" id="fss">
				<textarea name="villagemessage" rows="10" cols="20" style="width:890px;">${location.summary }</textarea>
			</div><!-- end forTableSC -->
			
			<div class="submitButton">
				<input type="reset" value="重     置 " />
				<input type="submit" value="提     交" />
			</div>
		</form>
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
</body>
</html>