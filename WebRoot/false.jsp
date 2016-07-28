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
    <title>成都市村级公共服务和社会管理项目管理系统</title>
    <%@ include file="/common/common.jsp" %>
    
  </head>
  
  <body>
	
	<div class="headerTable" style="height:30px;">
		<div class="headerTableTop">
			<div class="inheaderTableTop">
				欢迎进入成都市村级公共服务和社会管理项目管理系统...
				&nbsp;&nbsp;&nbsp;&nbsp;
				|&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${empty sessionScope.US }">
					<a href="${basePath }index.jsp" class="tableTop">主页</a>
				</c:if>
				<c:if test="${!empty sessionScope.US }">
					欢迎您：<a href="${basePath }index.action" class="tableTop"> ${sessionScope.US.userName }</a>
					<a href="${basePath }user_Logout.action" class="tableTop">注销</a>
				</c:if>				
			</div>			
		</div>
	</div><!-- end header -->
	
	<div class="mainTable">
		<div class="villageMessage" style="min-height:300px; color:red;line-height: 64px;text-align: center;"">
			<img src="${basePath }images/error404.png" alt="对不起，出错了！" />
		</div>
	</div>
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>