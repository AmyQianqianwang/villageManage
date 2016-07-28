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
    <title>无权限</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
    <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">
		<div class="villageMessage" style="min-height:300px; color:red;line-height: 64px;text-align: center;"">
			<img src="${basePath }images/authore.png" alt="对不起，您没有操作权限！" />
		</div>
	</div>
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>