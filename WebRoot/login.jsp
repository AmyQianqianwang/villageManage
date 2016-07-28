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
    <title>用户登录-成都市村级公共服务和社会管理项目管理系统</title>
    <%@ include file="/common/common.jsp" %>
    
  </head>
  
  <body>
	
	<div class="headerTable" style="height:30px;">
		<div class="headerTableTop">
			<div class="inheaderTableTop">
				欢迎进入成都市村级公共服务和社会管理项目管理系统...
				&nbsp;&nbsp;&nbsp;&nbsp;|
				<a href="${basePath }index.jsp" class="tableTop">首页</a>				
			</div>			
		</div>
	</div><!-- end header -->
	
	
	<div class="mainTable">
		
		<div class="content_login">
    	<div class="head_content_login">
    		<div class="triangle-left" style="margin-left:15px;"></div>
			<div class="headerTableName">
				<span>用户登录</span>
			</div>
    	</div>
    	<div class="left_content_login" style="margin-left: -50px;margin-top: 45px;"></div>
    	<div class="right_out_content_login">
        	<div class="right_in_content_login">
            	<div class="content_input">
                <form id="userlogin">
                	<div class="label_input"><span>用户名</span></div>
                    <div class="txt_psw_input" id="txt_part_input">
                    	<input type="text" class="txt_input" id="username" />
                        <div class="txt_picture_input"></div>
                    </div>
                	<div class="label_input" style="margin-top:15px;"><span>密码</span></div>
                    <div class="txt_psw_input" id="psw_part_input">
                    	<input type="password" class="txt_input" id="password" />
                        <div class="psw_picture_input"></div>
                    </div>
                    <div class="label_input error-box" style="color: red;margin-top: 5px;"></div>
                    <input type="button" id="submit" class="btn_login" style="margin-top: 30px;" />
                </form>
                    <div class="label_input submit" style="color: red;margin-top: 5px;"></div>
                </div>
                </div>
            </div>
    	</div>
    </div>
	
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").click(function(){
				userLogin('${basePath}');
			});
			function userLogin(path){
				var name = $("#username").val();
				var password = $("#password").val();
				var url_string = "user_login.action";
				$.ajax({
					type: "post",
					url: url_string,
					data: {'user_name':name, 'user_password':password},
					dataType:'json',	//预期服务器返回的数据类型
					beforeSend:function(){
		   				$("#submit").attr("type", "hidden");
		   				$(".error-box").html("");
		   				$(".submit").html("正在登录。。。");
					},
					success:function(json) {
						var result = json.result;
						if (result == "1"){
							location.href = path + "index.action";
						}
						else if (result == "0"){
							$(".error-box").html("<p>*用户名或密码错误</p>");
						}
						else if (result == "程序内部错误"){
							$(".error-box").html("<p>*程序内部错误</p>");
						}
					},
					complete:function(){
						$("#submit").attr("type", "button");
						$(".submit").html("");
					},
					error:function(){
						$(".error-box").html("*发生内部错误！");
						$(".submit").html("");
					}
				});
			}
		});
	</script>
</body>
</html>