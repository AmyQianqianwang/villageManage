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
    <title>成都市村级公共服务和社会管理项目管理系统</title>
    <%@ include file="/common/common.jsp" %>
    
  </head>
  
  <body>
	
	<div class="headerTable">
		<div class="headerTableTop">
			<div class="inheaderTableTop">
				欢迎进入成都市村级公共服务和社会管理项目管理系统...
				&nbsp;&nbsp;&nbsp;&nbsp;
				|&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${empty sessionScope.US }">
					<a href="${basePath }login.jsp" class="tableTop">登录</a>
				</c:if>
				<c:if test="${!empty sessionScope.US }">
					欢迎您：<a href="${basePath }index.action" class="tableTop"> ${sessionScope.US.userName }</a>
					<a href="${basePath }user_Logout.action" class="tableTop">注销</a>
				</c:if>				
			</div>			
		</div>
		<div class="headerTableLogo">
			<div class="headerTableLogoImg">
				<a href="#"><img src="${basePath }images/logo.png"/></a>
			</div>
			<div class="headerTableLocation">
				<span>成都市村级公共服务和社会管理项目管理系统</span>
			</div>
		</div>
		<div class="headerTableNav">
			<div class="inheaderTableNav">
				<a href="javascript:void();" class="everyNav">首页</a>
				<a href="javascript:void();" class="everyNav">政策法规</a>
				<a href="javascript:void();" class="everyNav">基层公开</a>
				<a href="javascript:void();" class="everyNav">便民服务</a>
				<a href="javascript:void();" class="everyNav">沟通互动</a>
				<a href="javascript:void();" class="everyNav">监督管理</a>
				<a href="javascript:void();" class="everyNav">服务发展</a>
			</div>
		</div>
	</div><!-- end header -->
	
	<!-- main index -->
	<div class="mainIndex">
		<div class="outBanner">
		<div class="banner" id="banner">			
			<i id="prev"></i>
    		<i id="next"></i>
    		<ul class="img_list">
        		<li><a href="#"><img src="${basePath }images/pic1.jpg" /></a> </li>
        		<li><a href="#"><img src="${basePath }images/pic2.jpg" /></a> </li>
        		<li><a href="#"><img src="${basePath }images/pic3.jpg" /></a> </li>
        		<li><a href="#"><img src="${basePath }images/pic4.jpg" /></a> </li>
        		<li><a href="#"><img src="${basePath }images/pic5.jpg" /></a> </li>
    		</ul>
    		<ul id="img_page"><li></li><li></li><li></li><li></li><li></li></ul>
    		<div id="mask"><h1></h1></div>
    		
				
		</div><!-- end banner -->
		</div><!-- outBanner -->
		
		<div class="aboutSystem">
			<div class="forsearch">
				<div class="inForsearch">
					<div class="forsearchPic">
						<div class="inForsearchPic">
							<img src="${basePath }images/picx_01.jpg" alt="天府广场"/>
						</div>
					</div>
					<div class="forsearchTxt">
						<form>
							<input type="text" class="searchTxt" value="查找乡镇（街道）/村（社区）" />
							<input type="button" class="searchBtn" />
						</form>
						<form>
							<input type="text" class="searchTxt" value="查找具体信息" />
							<input type="button" class="searchBtn" />
						</form>
					</div>
				</div>
			</div>
			<div class="forIntroduce">
				<div class="descSystem">
				 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎访问成都市村级公共服务和社会管理项目管理系统！
				 	
				 	<ul>
				 		<li>
				 			<div class="aboutVisit">
				 				<span>&bull;</span>
				 				<a>乡镇(街道)<em>316</em>个， 村(社区)<em>3406</em>个</a>
				 			</div>
				 		</li>
				 		<li>
				 			<div class="aboutVisit">
				 				<span>&bull;</span>
				 				<a>累计更新信息 <em>34289115</em>条</a>
				 			</div>
				 		</li>
				 		<li>
				 			<div class="aboutVisit">
				 				<span>&bull;</span>
				 				<a>访问总量：<em>351627654</em>次</a>
				 			</div>
				 		</li>
				 	</ul>
				</div>
			</div>
		</div>	
		
		<div class="forPlaceNav">
			区（市）县导航
		</div>
		<div class="place">
			<div class="forTr">
				<a href="#" class="tr_td" id="tr_jj">锦江区</a>				
				<a href="#" class="tr_td" id="tr_qy">青羊区</a>
				<a href="#" class="tr_td" id="tr_jn">金牛区</a>
				<a href="#" class="tr_td" id="tr_wh">武侯区</a>
				<a href="#" class="tr_td" id="tr_xd">新都区</a>
				<a href="#" class="tr_td" id="tr_xj">新津县</a>		
				<a href="#" class="tr_td" id="tr_lqy">龙泉驿区</a>
				<a href="#" class="tr_td" id="tr_qbj">青白江区</a>
			</div>
			<!-- 第一行，各地区的详细地址 -->
			<div class="everyTrInfo" id="info_tr_jj">
				<div class="title"><div class="titleLine lineWidth_03 lineColor_01"></div></div>
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_01"><a href="#">督院街街道</a></div>
					<div class="everyTd"><a href="#">&gt;滨江社区</a></div>
					<div class="everyTd"><a href="#">&gt;青石桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;督院街社区</a></div>
					<div class="everyTd"><a href="#">&gt;人南社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02">盐市口街道</div>
					<div class="everyTd"><a href="#">&gt;青年路社区</a></div>
					<div class="everyTd"><a href="#">&gt;学道街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">双桂路街道</a></div>
					<div class="everyTd"><a href="#">&gt;牛沙路社区</a></div>
					<div class="everyTd"><a href="#">&gt;五福桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;净居寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;通慧社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">沙河街道</a></div>
					<div class="everyTd"><a href="#">&gt;沙河社区</a></div>
					<div class="everyTd"><a href="#">&gt;塔子山社区</a></div>
					<div class="everyTd"><a href="#">&gt;静康社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">春熙路街道</a></div>
					<div class="everyTd"><a href="#">&gt;总府路社区</a></div>
					<div class="everyTd"><a href="#">&gt;华兴街社区</a></div>
					<div class="everyTd"><a href="#">&gt;岳府街社区</a></div>
					<div class="everyTd"><a href="#">&gt;桂王桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;暑袜街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">书院街街道</a></div>
					<div class="everyTd"><a href="#">&gt;中道街社区</a></div>
					<div class="everyTd"><a href="#">&gt;华星路社区</a></div>
					<div class="everyTd"><a href="#">&gt;惜字宫社区</a></div>
					<div class="everyTd"><a href="#">&gt;五昭路社区</a></div>
					<div class="everyTd"><a href="#">&gt;庆云社区</a></div>
					<div class="everyTd"><a href="#">&gt;东安南路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_05"><a href="#">合江亭街道</a></div>
					<div class="everyTd"><a href="#">&gt;合江亭社区</a></div>
					<div class="everyTd"><a href="#">&gt;大慈寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;东升社区</a></div>
					<div class="everyTd"><a href="#">&gt;纱帽街社区</a></div>
					<div class="everyTd"><a href="#">&gt;崇德里社区</a></div>
					<div class="everyTd"><a href="#">&gt;王家坝社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_06"><a href="#">水井坊街道</a></div>
					<div class="everyTd"><a href="#">&gt;水井坊社区</a></div>
					<div class="everyTd"><a href="#">&gt;交子社区</a></div>
					<div class="everyTd"><a href="#">&gt;点将台社区</a></div>
					<div class="everyTd"><a href="#">&gt;校场坝社区</a></div>
					<div class="everyTd"><a href="#">&gt;光明路社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦官驿社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">牛市口街道</a></div>
					<div class="everyTd"><a href="#">&gt;水碾河路南社区</a></div>
					<div class="everyTd"><a href="#">&gt;华成路社区</a></div>
					<div class="everyTd"><a href="#">&gt;得胜街社区</a></div>
					<div class="everyTd"><a href="#">&gt;牛王庙社区</a></div>
					<div class="everyTd"><a href="#">&gt;经华南路社区</a></div>
					<div class="everyTd"><a href="#">&gt;牛市口路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_01"><a href="#">龙舟路街道</a></div>
					<div class="everyTd"><a href="#">&gt;龙舟社区</a></div>
					<div class="everyTd"><a href="#">&gt;顺江社区</a></div>
					<div class="everyTd"><a href="#">&gt;河滨社区</a></div>
					<div class="everyTd"><a href="#">&gt;莲桂西路社区</a></div>
					<div class="everyTd"><a href="#">&gt;莲花新区社区</a></div>
					<div class="everyTd"><a href="#">&gt;三官堂社区</a></div>
					<div class="everyTd"><a href="#">&gt;河心村社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">狮子山街道</a></div>
					<div class="everyTd"><a href="#">&gt;菱窠社区</a></div>
					<div class="everyTd"><a href="#">&gt;川师大社区</a></div>
					<div class="everyTd"><a href="#">&gt;万科城花社区</a></div>
					<div class="everyTd"><a href="#">&gt;花果社区</a></div>
					<div class="everyTd"><a href="#">&gt;菱安路社区</a></div>
					<div class="everyTd"><a href="#">&gt;静沙路社区</a></div>
					<div class="everyTd"><a href="#">&gt;佳宏路社区</a></div>
					<div class="everyTd"><a href="#">&gt;静明路社区</a></div>
				</div>
								
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">三圣街道</a></div>
					<div class="everyTd"><a href="#">&gt;红纱社区</a></div>
					<div class="everyTd"><a href="#">&gt;幸福社区</a></div>
					<div class="everyTd"><a href="#">&gt;驸马社区</a></div>
					<div class="everyTd"><a href="#">&gt;万福社区</a></div>
					<div class="everyTd"><a href="#">&gt;大安桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;江家堰社区</a></div>
					<div class="everyTd"><a href="#">&gt;喜树路社区</a></div>
					<div class="everyTd"><a href="#">&gt;栀子街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02"><a href="#">莲新街道</a></div>
					<div class="everyTd"><a href="#">&gt;一心桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;海椒市社区</a></div>
					<div class="everyTd"><a href="#">&gt;宏济路社区</a></div>
					<div class="everyTd"><a href="#">&gt;九眼桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;莲花社区</a></div>
					<div class="everyTd"><a href="#">&gt;紫东社区</a></div>
					<div class="everyTd"><a href="#">&gt;晶蓝社区</a></div>
					<div class="everyTd"><a href="#">&gt;东四街社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦东社区</a></div>
					<div class="everyTd"><a href="#">&gt;新桂社区</a></div>
					<div class="everyTd"><a href="#">&gt;莲花西路社区</a></div>
				</div>
				
				
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">东光街道</a></div>
					<div class="everyTd"><a href="#">&gt;永兴社区</a></div>
					<div class="everyTd"><a href="#">&gt;新莲新社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦华社区</a></div>
					<div class="everyTd"><a href="#">&gt;东怡社区</a></div>
					<div class="everyTd"><a href="#">&gt;翡翠社区</a></div>
					<div class="everyTd"><a href="#">&gt;北顺社区</a></div>
					<div class="everyTd"><a href="#">&gt;东润社区</a></div>
					<div class="everyTd"><a href="#">&gt;东光社区</a></div>
					<div class="everyTd"><a href="#">&gt;观音桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;绿岭社区</a></div>
					<div class="everyTd"><a href="#">&gt;东湖社区</a></div>
				</div>
				
			
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_05"><a href="#">柳江街道</a></div>
					<div class="everyTd"><a href="#">&gt;生研所社区</a></div>
					<div class="everyTd"><a href="#">&gt;柳江社区</a></div>
					<div class="everyTd"><a href="#">&gt;琉璃社区</a></div>
					<div class="everyTd"><a href="#">&gt;包江桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;祝国寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;潘家沟社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦馨社区</a></div>
					<div class="everyTd"><a href="#">&gt;凯天社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦源社区</a></div>
					<div class="everyTd"><a href="#">&gt;桂馨社区</a></div>
					<div class="everyTd"><a href="#">&gt;楠馨社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_06"><a href="#">成龙路街道</a></div>
					<div class="everyTd"><a href="#">&gt;皇经社区</a></div>
					<div class="everyTd"><a href="#">&gt;金象花园社区</a></div>
					<div class="everyTd"><a href="#">&gt;花香苑社区</a></div>
					<div class="everyTd"><a href="#">&gt;国槐路社区</a></div>
					<div class="everyTd"><a href="#">&gt;皇经楼社区</a></div>
					<div class="everyTd"><a href="#">&gt;棬子树社区</a></div>
					<div class="everyTd"><a href="#">&gt;金像寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;粮丰社区</a></div>
					<div class="everyTd"><a href="#">&gt;大观社区</a></div>
					<div class="everyTd"><a href="#">&gt;华新社区</a></div>
					<div class="everyTd"><a href="#">&gt;经天社区</a></div>
					<div class="everyTd"><a href="#">&gt;晨辉社区</a></div>
					<div class="everyTd"><a href="#">&gt;赖家新桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;卓锦城社区</a></div>
					<div class="everyTd"><a href="#">&gt;蓝谷地社区</a></div>
				</div>
				
				
			</div>
			
			<div class="everyTrInfo" id="info_tr_qy">
				<div class="title"><div class="titleLine lineWidth_03 lineColor_02 lineMargin_02"></div></div>
			
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">草市街街道</a></div>
					<div class="everyTd"><a href="#">&gt;文殊院社区</a></div>
					<div class="everyTd"><a href="#">&gt;双眼井社区</a></div>
					<div class="everyTd"><a href="#">&gt;玉带桥社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">西域河街道</a></div>
					<div class="everyTd"><a href="#">&gt;西华门社区</a></div>
					<div class="everyTd"><a href="#">&gt;东御河社区</a></div>
					<div class="everyTd"><a href="#">&gt;羊市街社区</a></div>
					<div class="everyTd"><a href="#">&gt;五福街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_05"><a href="#">汪家拐街道</a></div>
					<div class="everyTd"><a href="#">&gt;文庙社区</a></div>
					<div class="everyTd"><a href="#">&gt;文翁社区</a></div>
					<div class="everyTd"><a href="#">&gt;少城社区</a></div>
					<div class="everyTd"><a href="#">&gt;长城社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_06"><a href="#">少城街道</a></div>
					<div class="everyTd"><a href="#">&gt;宽巷子社区</a></div>
					<div class="everyTd"><a href="#">&gt;四道街社区</a></div>
					<div class="everyTd"><a href="#">&gt;过街楼社区</a></div>
					<div class="everyTd"><a href="#">&gt;商业街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">新华西路街</a></div>
					<div class="everyTd"><a href="#">&gt;通锦桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;八宝街社区</a></div>
					<div class="everyTd"><a href="#">&gt;宁夏街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02"><a href="#">金沙街道</a></div>
					<div class="everyTd"><a href="#">&gt;金凤社区</a></div>
					<div class="everyTd"><a href="#">&gt;同怡社区</a></div>
					<div class="everyTd"><a href="#">&gt;金沙遗址社区</a></div>
					<div class="everyTd"><a href="#">&gt;金鹏社区</a></div>
				</div>
				
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_01"><a href="#">草堂街道</a></div>
					<div class="everyTd"><a href="#">&gt;宽巷子社区</a></div>
					<div class="everyTd"><a href="#">&gt;四道街社区</a></div>
					<div class="everyTd"><a href="#">&gt;过街楼社区</a></div>
					<div class="everyTd"><a href="#">&gt;商业街社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">东坡街道</a></div>
					<div class="everyTd"><a href="#">&gt;清水河社区</a></div>
					<div class="everyTd"><a href="#">&gt;贝森路社区</a></div>
					<div class="everyTd"><a href="#">&gt;双新路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02"><a href="#">太升路街道</a></div>
					<div class="everyTd"><a href="#">&gt;太升南路社区</a></div>
					<div class="everyTd"><a href="#">&gt;鼓楼南街社区</a></div>
					<div class="everyTd"><a href="#">&gt;小关庙社区</a></div>
					<div class="everyTd"><a href="#">&gt;德盛路社区</a></div>
					<div class="everyTd"><a href="#">&gt;玉沙路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">府南街道</a></div>
					<div class="everyTd"><a href="#">&gt;锦屏社区</a></div>
					<div class="everyTd"><a href="#">&gt;文苑社区</a></div>
					<div class="everyTd"><a href="#">&gt;清溪社区</a></div>
					<div class="everyTd"><a href="#">&gt;石人南路社区</a></div>
					<div class="everyTd"><a href="#">&gt;石人北路社区</a></div>
					<div class="everyTd"><a href="#">&gt;同德社区</a></div>
					<div class="everyTd"><a href="#">&gt;战旗社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_05"><a href="#">光华街道</a></div>
					<div class="everyTd"><a href="#">&gt;浣花社区</a></div>
					<div class="everyTd"><a href="#">&gt;青华社区</a></div>
					<div class="everyTd"><a href="#">&gt;财大社区</a></div>
					<div class="everyTd"><a href="#">&gt;清康社区</a></div>
					<div class="everyTd"><a href="#">&gt;花园社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_06"><a href="#">黄田坝街道</a></div>
					<div class="everyTd"><a href="#">&gt;民安社区</a></div>
					<div class="everyTd"><a href="#">&gt;成航社区</a></div>
					<div class="everyTd"><a href="#">&gt;安康社区</a></div>
					<div class="everyTd"><a href="#">&gt;康华社区</a></div>
					<div class="everyTd"><a href="#">&gt;华兴社区</a></div>
					<div class="everyTd"><a href="#">&gt;联工社区</a></div>
					<div class="everyTd"><a href="#">&gt;高坎社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">苏坡街道</a></div>
					<div class="everyTd"><a href="#">&gt;中鹏社区</a></div>
					<div class="everyTd"><a href="#">&gt;中坝社区</a></div>
					<div class="everyTd"><a href="#">&gt;万家湾社区</a></div>
					<div class="everyTd"><a href="#">&gt;培风路社区</a></div>
					<div class="everyTd"><a href="#">&gt;清江社区</a></div>
					<div class="everyTd"><a href="#">&gt;黄土社区</a></div>
					<div class="everyTd"><a href="#">&gt;清波社区</a></div>
					<div class="everyTd"><a href="#">&gt;龙嘴社区</a></div>
					<div class="everyTd"><a href="#">&gt;百仁社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">文家街道</a></div>
					<div class="everyTd"><a href="#">&gt;康庄社区</a></div>
					<div class="everyTd"><a href="#">&gt;蔡桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;七里沟社区</a></div>
					<div class="everyTd"><a href="#">&gt;马厂社区</a></div>
					<div class="everyTd"><a href="#">&gt;康河社区</a></div>
					<div class="everyTd"><a href="#">&gt;华严社区</a></div>
					<div class="everyTd"><a href="#">&gt;红碾社区</a></div>
					<div class="everyTd"><a href="#">&gt;董家坝社区</a></div>
					<div class="everyTd"><a href="#">&gt;乐平社区</a></div>
					<div class="everyTd"><a href="#">&gt;快活社区</a></div>
					<div class="everyTd"><a href="#">&gt;盐井社区</a></div>
					<div class="everyTd"><a href="#">&gt;张家碾社区</a></div>
					<div class="everyTd"><a href="#">&gt;大石桥社区</a></div>
				</div>
				
			</div>
			<div class="everyTrInfo" id="info_tr_jn">
				金牛区
			</div>
			
			<div class="everyTrInfo" id="info_tr_wh">
				武侯区
			</div>
			
			<div class="everyTrInfo" id="info_tr_xd">
				新都区
			</div>
			
			<div class="everyTrInfo" id="info_tr_xj">
				新津县
			</div>
			
			<div class="everyTrInfo" id="info_tr_lqy">
				龙泉驿区
			</div>
			<div class="everyTrInfo" id="info_tr_qbj">
				青白江区
			</div>
			
			<div class="forTr">
				<a href="#" class="tr_td" id="tr_ch">成华区</a>				
				<a href="#" class="tr_td" id="tr_wj">温江区</a>
				<a href="#" class="tr_td" id="tr_pz">彭州市</a>
				<a href="#" class="tr_td" id="tr_ql">邛崃市</a>
				<a href="#" class="tr_td" id="tr_cz">崇州市</a>
				<a href="#" class="tr_td" id="tr_djy">都江堰市</a>
				<a href="#" class="tr_td" id="tr_jt">金堂县</a>
				<a href="#" class="tr_td" id="tr_px">郫县</a>
			</div>
			
			<div class="everyTrInfo" id="info_tr_ch">
				<div class="title"><div class="titleLine lineWidth_03 lineColor_01"></div></div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">府青路街道</a></div>
					<div class="everyTd"><a href="#">&gt;八里庄社区</a></div>
					<div class="everyTd"><a href="#">&gt;府青社区</a></div>
					<div class="everyTd"><a href="#">&gt;李家沱社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02"><a href="#">双桥子街道</a></div>
					<div class="everyTd"><a href="#">&gt;双林中横路社区</a></div>
					<div class="everyTd"><a href="#">&gt;水碾河路北社区</a></div>
					<div class="everyTd"><a href="#">&gt;双桥路北社区</a></div>
					<div class="everyTd"><a href="#">&gt;双林社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">新鸿路街道</a></div>
					<div class="everyTd"><a href="#">&gt;新鸿社区</a></div>
					<div class="everyTd"><a href="#">&gt;菽香里社区</a></div>
					<div class="everyTd"><a href="#">&gt;新华社区</a></div>
					<div class="everyTd"><a href="#">&gt;万晟社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">建设路街道</a></div>
					<div class="everyTd"><a href="#">&gt;电子科大社区</a></div>
					<div class="everyTd"><a href="#">&gt;建兴路社区</a></div>
					<div class="everyTd"><a href="#">&gt;建设中路社区</a></div>
					<div class="everyTd"><a href="#">&gt;培华路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_01"><a href="#">猛追湾街道</a></div>
					<div class="everyTd"><a href="#">&gt;望平社区</a></div>
					<div class="everyTd"><a href="#">&gt;祥和里社区</a></div>
					<div class="everyTd"><a href="#">&gt;东街社区</a></div>
					<div class="everyTd"><a href="#">&gt;建华社区</a></div>
					<div class="everyTd"><a href="#">&gt;石油社区</a></div>
					<div class="everyTd"><a href="#">&gt;新兴社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_02"><a href="#">桃溪路街道</a></div>
					<div class="everyTd"><a href="#">&gt;桃源社区</a></div>
					<div class="everyTd"><a href="#">&gt;文德社区</a></div>
					<div class="everyTd"><a href="#">&gt;怡福社区</a></div>
					<div class="everyTd"><a href="#">&gt;桃溪社区</a></div>
					<div class="everyTd"><a href="#">&gt;踏水社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_03"><a href="#">跳蹬河街道</a></div>
					<div class="everyTd"><a href="#">&gt;东篱路社区</a></div>
					<div class="everyTd"><a href="#">&gt;杉板桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;跳蹬河社区</a></div>
					<div class="everyTd"><a href="#">&gt;锦绣社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">万年场街道</a></div>
					<div class="everyTd"><a href="#">&gt;长天路社区</a></div>
					<div class="everyTd"><a href="#">&gt;万年路社区</a></div>
					<div class="everyTd"><a href="#">&gt;槐树店社区</a></div>
					<div class="everyTd"><a href="#">&gt;双庆路社区</a></div>
					<div class="everyTd"><a href="#">&gt;红桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;联合社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_05"><a href="#">二仙桥街道</a></div>
					<div class="everyTd"><a href="#">&gt;东路社区</a></div>
					<div class="everyTd"><a href="#">&gt;下涧槽社区</a></div>
					<div class="everyTd"><a href="#">&gt;西北路社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_06"><a href="#">双水碾街道</a></div>
					<div class="everyTd"><a href="#">&gt;花径路社区</a></div>
					<div class="everyTd"><a href="#">&gt;站北路社区</a></div>
					<div class="everyTd"><a href="#">&gt;东沙路社区</a></div>
					<div class="everyTd"><a href="#">&gt;红花堰社区</a></div>
					<div class="everyTd"><a href="#">&gt;横桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;荆竹社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">圣灯街道</a></div>
					<div class="everyTd"><a href="#">&gt;关家社区</a></div>
					<div class="everyTd"><a href="#">&gt;圣灯社区</a></div>
					<div class="everyTd"><a href="#">&gt;建北社区</a></div>
					<div class="everyTd"><a href="#">&gt;崔家店社区</a></div>
					<div class="everyTd"><a href="#">&gt;东华社区</a></div>
					<div class="everyTd"><a href="#">&gt;长林盘社区</a></div>
					<div class="everyTd"><a href="#">&gt;人民塘社区</a></div>
					<div class="everyTd"><a href="#">&gt;关家堰社区</a></div>
					<div class="everyTd"><a href="#">&gt;华林社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">保和街道</a></div>
					<div class="everyTd"><a href="#">&gt;杨柳社区</a></div>
					<div class="everyTd"><a href="#">&gt;团结社区</a></div>
					<div class="everyTd"><a href="#">&gt;和顺社区</a></div>
					<div class="everyTd"><a href="#">&gt;东升社区</a></div>
					<div class="everyTd"><a href="#">&gt;天鹅社区</a></div>
					<div class="everyTd"><a href="#">&gt;斑竹社区</a></div>
					<div class="everyTd"><a href="#">&gt;东虹路社区</a></div>
					<div class="everyTd"><a href="#">&gt;迎晖社区</a></div>
					<div class="everyTd"><a href="#">&gt;和美社区</a></div>
					<div class="everyTd"><a href="#">&gt;胜利社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">青龙街道</a></div>
					<div class="everyTd"><a href="#">&gt;白莲社区</a></div>
					<div class="everyTd"><a href="#">&gt;昭青路社区</a></div>
					<div class="everyTd"><a href="#">&gt;仁义路社区</a></div>
					<div class="everyTd"><a href="#">&gt;昭觉社区</a></div>
					<div class="everyTd"><a href="#">&gt;回龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;一里塘社区</a></div>
					<div class="everyTd"><a href="#">&gt;海滨湾社区</a></div>
					<div class="everyTd"><a href="#">&gt;白莲池社区</a></div>
					<div class="everyTd"><a href="#">&gt;西林社区</a></div>
					<div class="everyTd"><a href="#">&gt;狮子社区</a></div>
					<div class="everyTd"><a href="#">&gt;将军碑社区</a></div>
					<div class="everyTd"><a href="#">&gt;东林社区</a></div>
					<div class="everyTd"><a href="#">&gt;新山社区</a></div>
					<div class="everyTd"><a href="#">&gt;石岭社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">龙潭街道</a></div>
					<div class="everyTd"><a href="#">&gt;正街社区</a></div>
					<div class="everyTd"><a href="#">&gt;隆兴路社区</a></div>
					<div class="everyTd"><a href="#">&gt;鹅林社区</a></div>
					<div class="everyTd"><a href="#">&gt;向龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;平丰社区</a></div>
					<div class="everyTd"><a href="#">&gt;高洪社区</a></div>
					<div class="everyTd"><a href="#">&gt;光明社区</a></div>
					<div class="everyTd"><a href="#">&gt;桂林社区</a></div>
					<div class="everyTd"><a href="#">&gt;建设社区</a></div>
					<div class="everyTd"><a href="#">&gt;同乐社区</a></div>
					<div class="everyTd"><a href="#">&gt;丛树社区</a></div>
					<div class="everyTd"><a href="#">&gt;威灵社区</a></div>
					<div class="everyTd"><a href="#">&gt;院东社区</a></div>
					<div class="everyTd"><a href="#">&gt;院山社区</a></div>
					<div class="everyTd"><a href="#">&gt;保平社区</a></div>
					<div class="everyTd"><a href="#">&gt;同仁社区</a></div>
					<div class="everyTd"><a href="#">&gt;石马社区</a></div>
					<div class="everyTd"><a href="#">&gt;秀水社区</a></div>
					<div class="everyTd"><a href="#">&gt;和成社区</a></div>
					<div class="everyTd"><a href="#">&gt;新民社区</a></div>					
				</div>
			</div>
			
			
			
			<div class="everyTrInfo" id="info_tr_wj">
				<div class="title"><div class="titleLine lineWidth_03 lineColor_02 lineMargin_02"></div></div>
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">金马镇</a></div>
					<div class="everyTd"><a href="#">&gt;金泉社区</a></div>
					<div class="everyTd"><a href="#">&gt;天王社区</a></div>
					<div class="everyTd"><a href="#">&gt;温泉社区</a></div>
					<div class="everyTd"><a href="#">&gt;光明社区</a></div>
					<div class="everyTd"><a href="#">&gt;新春社区</a></div>
					<div class="everyTd"><a href="#">&gt;同福社区</a></div>
					<div class="everyTd"><a href="#">&gt;刘家濠社区</a></div>
					<div class="everyTd"><a href="#">&gt;兴元社区</a></div>
					<div class="everyTd"><a href="#">&gt;四友村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">天府街道</a></div>
					<div class="everyTd"><a href="#">&gt;梓潼社区</a></div>
					<div class="everyTd"><a href="#">&gt;学府社区</a></div>
					<div class="everyTd"><a href="#">&gt;金府社区</a></div>
					<div class="everyTd"><a href="#">&gt;游家渡社区</a></div>
					<div class="everyTd"><a href="#">&gt;海科社区</a></div>
					<div class="everyTd"><a href="#">&gt;天府家园社区</a></div>
					<div class="everyTd"><a href="#">&gt;笼堰村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">涌泉街道</a></div>
					<div class="everyTd"><a href="#">&gt;瑞泉馨城社区</a></div>
					<div class="everyTd"><a href="#">&gt;花土社区</a></div>
					<div class="everyTd"><a href="#">&gt;大田社区</a></div>
					<div class="everyTd"><a href="#">&gt;明光渡社区</a></div>
					<div class="everyTd"><a href="#">&gt;共耕社区</a></div>
					<div class="everyTd"><a href="#">&gt;凤凰社区</a></div>
					<div class="everyTd"><a href="#">&gt;双堰社区</a></div>
					<div class="everyTd"><a href="#">&gt;前锋社区</a></div>
					<div class="everyTd"><a href="#">&gt;洪江村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">公平街道</a></div>
					<div class="everyTd"><a href="#">&gt;长安路社区</a></div>
					<div class="everyTd"><a href="#">&gt;合江社区</a></div>
					<div class="everyTd"><a href="#">&gt;龙凤社区</a></div>
					<div class="everyTd"><a href="#">&gt;建安社区</a></div>
					<div class="everyTd"><a href="#">&gt;惠民社区</a></div>
					<div class="everyTd"><a href="#">&gt;红桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;正宗社区</a></div>
					<div class="everyTd"><a href="#">&gt;太极社区</a></div>
					<div class="everyTd"><a href="#">&gt;惠和村</a></div>
					<div class="everyTd"><a href="#">&gt;分水村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">柳城街道</a></div>
					<div class="everyTd"><a href="#">&gt;东街社区</a></div>
					<div class="everyTd"><a href="#">&gt;南街社区</a></div>
					<div class="everyTd"><a href="#">&gt;西街社区</a></div>
					<div class="everyTd"><a href="#">&gt;北街社区</a></div>
					<div class="everyTd"><a href="#">&gt;黄金路社区</a></div>
					<div class="everyTd"><a href="#">&gt;德通桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;万盛社区</a></div>
					<div class="everyTd"><a href="#">&gt;和平社区</a></div>
					<div class="everyTd"><a href="#">&gt;永宁路社区</a></div>
					<div class="everyTd"><a href="#">&gt;鱼凫路社区</a></div>
					<div class="everyTd"><a href="#">&gt;凉水社区</a></div>
					<div class="everyTd"><a href="#">&gt;红光社区</a></div>
					<div class="everyTd"><a href="#">&gt;凤溪社区</a></div>
					<div class="everyTd"><a href="#">&gt;燎原社区</a></div>
					<div class="everyTd"><a href="#">&gt;新华社区</a></div>
					<div class="everyTd"><a href="#">&gt;光华社区</a></div>
					<div class="everyTd"><a href="#">&gt;迎晖路社区</a></div>
					<div class="everyTd"><a href="#">&gt;航天路社区</a></div>				
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">寿安镇</a></div>
					<div class="everyTd"><a href="#">&gt;吴家场社区</a></div>
					<div class="everyTd"><a href="#">&gt;王家湾社区</a></div>
					<div class="everyTd"><a href="#">&gt;团结桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;喻庙社区</a></div>
					<div class="everyTd"><a href="#">&gt;百花社区</a></div>
					<div class="everyTd"><a href="#">&gt;复兴社区</a></div>
					<div class="everyTd"><a href="#">&gt;东岳社区</a></div>
					<div class="everyTd"><a href="#">&gt;苦竹村</a></div>
					<div class="everyTd"><a href="#">&gt;长青村</a></div>
					<div class="everyTd"><a href="#">&gt;天源村</a></div>
					<div class="everyTd"><a href="#">&gt;清水村</a></div>
					<div class="everyTd"><a href="#">&gt;胜利村</a></div>
					<div class="everyTd"><a href="#">&gt;新林村</a></div>
					<div class="everyTd"><a href="#">&gt;天星村</a></div>
					<div class="everyTd"><a href="#">&gt;岷江村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">和盛镇</a></div>
					<div class="everyTd"><a href="#">&gt;柳岸社区</a></div>
					<div class="everyTd"><a href="#">&gt;广水社区</a></div>
					<div class="everyTd"><a href="#">&gt;舒家渡社区</a></div>
					<div class="everyTd"><a href="#">&gt;土桥村</a></div>
					<div class="everyTd"><a href="#">&gt;石坝村</a></div>
					<div class="everyTd"><a href="#">&gt;渡口村</a></div>
					<div class="everyTd"><a href="#">&gt;玉河村</a></div>
					<div class="everyTd"><a href="#">&gt;渡桥村</a></div>
					<div class="everyTd"><a href="#">&gt;李义村</a></div>
					<div class="everyTd"><a href="#">&gt;石牛村</a></div>
					<div class="everyTd"><a href="#">&gt;友庆社区</a></div>
					<div class="everyTd"><a href="#">&gt;铁犁村</a></div>
					<div class="everyTd"><a href="#">&gt;东宫寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;临江村</a></div>
					<div class="everyTd"><a href="#">&gt;春林村</a></div>
					<div class="everyTd"><a href="#">&gt;綦江社区</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">万春镇</a></div>
					<div class="everyTd"><a href="#">&gt;春江路社区</a></div>
					<div class="everyTd"><a href="#">&gt;天乡路社区</a></div>
					<div class="everyTd"><a href="#">&gt;踏水桥社区</a></div>
					<div class="everyTd"><a href="#">&gt;红专社区</a></div>
					<div class="everyTd"><a href="#">&gt;黄石社区</a></div>
					<div class="everyTd"><a href="#">&gt;南岳社区</a></div>
					<div class="everyTd"><a href="#">&gt;长石社区</a></div>
					<div class="everyTd"><a href="#">&gt;永和社区</a></div>
					<div class="everyTd"><a href="#">&gt;红旗村</a></div>
					<div class="everyTd"><a href="#">&gt;先锋村</a></div>
					<div class="everyTd"><a href="#">&gt;幸福村</a></div>
					<div class="everyTd"><a href="#">&gt;新河村</a></div>
					<div class="everyTd"><a href="#">&gt;鱼凫村</a></div>
					<div class="everyTd"><a href="#">&gt;和林村</a></div>
					<div class="everyTd"><a href="#">&gt;报恩村</a></div>
					<div class="everyTd"><a href="#">&gt;三井村</a></div>
					<div class="everyTd"><a href="#">&gt;镇江村</a></div>
					<div class="everyTd"><a href="#">&gt;新升村</a></div>
					<div class="everyTd"><a href="#">&gt;高山村</a></div>
					<div class="everyTd"><a href="#">&gt;金星村</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">永盛镇</a></div>
					<div class="everyTd"><a href="#">&gt;尚和社区</a></div>
					<div class="everyTd"><a href="#">&gt;永盛场社区</a></div>
					<div class="everyTd"><a href="#">&gt;团结社区</a></div>
					<div class="everyTd"><a href="#">&gt;金鸡社区</a></div>
					<div class="everyTd"><a href="#">&gt;石磊社区</a></div>					
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_04"><a href="#">永宁镇</a></div>
					<div class="everyTd"><a href="#">&gt;八角社区</a></div>
					<div class="everyTd"><a href="#">&gt;天王社区</a></div>
					<div class="everyTd"><a href="#">&gt;永福社区</a></div>
					<div class="everyTd"><a href="#">&gt;城武社区</a></div>
					<div class="everyTd"><a href="#">&gt;花离社区</a></div>
					<div class="everyTd"><a href="#">&gt;新庄社区</a></div>					
				</div>				
			</div>
			
			<div class="everyTrInfo" id="info_tr_pz">
				彭州市
			</div>
			<div class="everyTrInfo" id="info_tr_ql">
				邛崃市
			</div>
			<div class="everyTrInfo" id="info_tr_cz">
				崇州市
			</div>
			<div class="everyTrInfo" id="info_tr_djy">
				都江堰市
			</div>
			<div class="everyTrInfo" id="info_tr_jt">
				金堂县
			</div>
			<div class="everyTrInfo" id="info_tr_px">
				郫县
			</div>
			
			<div class="forTr">
				<a href="#" class="tr_td" id="tr_gx">高新区</a>
				<a href="#" class="tr_td" id="tr_dy">大邑县</a>
				<a href="#" class="tr_td" id="tr_sl">双流县</a>							
				<a href="#" class="tr_td" id="tr_pj">蒲江县</a>
				
			</div>
			
			<div class="everyTrInfo" id="info_tr_gx">
				<div class="title"><div class="titleLine lineWidth_03 lineColor_01"></div></div>
				
				<!-- 高新开始 -->
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">肖家河街道</a></div>
					<div class="everyTd"><a href="#">&gt;联谊社区</a></div>
					<div class="everyTd"><a href="#">&gt;正街社区</a></div>
					<div class="everyTd"><a href="#">&gt;永丰社区</a></div>
					<div class="everyTd"><a href="#">&gt;兴蓉社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">合作街道</a></div>
					<div class="everyTd"><a href="#">&gt;顺江社区</a></div>
					<div class="everyTd"><a href="#">&gt;清江社区</a></div>
					<div class="everyTd"><a href="#">&gt;檬梓社区</a></div>
					<div class="everyTd"><a href="#">&gt;独柏社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">桂溪街道</a></div>
					<div class="everyTd"><a href="#">&gt;双源社区</a></div>
					<div class="everyTd"><a href="#">&gt;和平社区</a></div>
					<div class="everyTd"><a href="#">&gt;三瓦窑社区</a></div>
					<div class="everyTd"><a href="#">&gt;双和社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">芳草街街道</a></div>
					<div class="everyTd"><a href="#">&gt;新能巷社区</a></div>
					<div class="everyTd"><a href="#">&gt;芳华社区</a></div>
					<div class="everyTd"><a href="#">&gt;紫竹社区</a></div>
					<div class="everyTd"><a href="#">&gt;蓓蕾社区</a></div>
					<div class="everyTd"><a href="#">&gt;元通社区</a></div>
					<div class="everyTd"><a href="#">&gt;紫薇社区</a></div>
					<div class="everyTd"><a href="#">&gt;紫荆社区</a></div>
					<div class="everyTd"><a href="#">&gt;神仙树社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">石羊街道</a></div>
					<div class="everyTd"><a href="#">&gt;庆安社区</a></div>
					<div class="everyTd"><a href="#">&gt;新北社区</a></div>
					<div class="everyTd"><a href="#">&gt;三元社区</a></div>
					<div class="everyTd"><a href="#">&gt;新街社区</a></div>
					<div class="everyTd"><a href="#">&gt;新园社区</a></div>
					<div class="everyTd"><a href="#">&gt;新光社区</a></div>
					<div class="everyTd"><a href="#">&gt;新盛社区</a></div>
					<div class="everyTd"><a href="#">&gt;新南社区</a></div>
				</div>
				
				<div class="inEveryTrInfo">
					<div class="everyTd everyTdTitle leftTitleColor_07"><a href="#">中和街道</a></div>
					<div class="everyTd"><a href="#">&gt;新民社区</a></div>
					<div class="everyTd"><a href="#">&gt;朝阳社区</a></div>
					<div class="everyTd"><a href="#">&gt;应龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;新华社区</a></div>
					<div class="everyTd"><a href="#">&gt;双龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;化龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;府河社区</a></div>
					<div class="everyTd"><a href="#">&gt;劲松社区</a></div>
					<div class="everyTd"><a href="#">&gt;观东社区</a></div>
					<div class="everyTd"><a href="#">&gt;会龙社区</a></div>
					<div class="everyTd"><a href="#">&gt;龙灯山社区</a></div>
					<div class="everyTd"><a href="#">&gt;东寺社区</a></div>
					<div class="everyTd"><a href="#">&gt;姐儿堰社区</a></div>
					<div class="everyTd"><a href="#">&gt;蒲草社区</a></div>
				</div>
			</div>
			
			<div class="everyTrInfo" id="info_tr_dy">
				大邑县
			</div>
						
			<div class="everyTrInfo" id="info_tr_sl">				
				 双流  							
			</div>
			
			<div class="everyTrInfo" id="info_tr_pj">				
				 蒲江  							
			</div>			
		</div><!-- end place -->
		
		
		<div class="otherInfo">
			<div class="leftOtherInfo">
				<div class="everyLeftInfoTitlePart">
					<div class="everyLeftInfoTitle">政策法规</div>
					<div class="titleMore"><a href="#">更多&raquo;</a></div>				
				</div>				
				<div class="everyLeftInfo">
						<div class="everyPolicy">
							<div class="picPolicyInfo">
								<div class="inPicPolicyInfo">
									<a href="#"><img src="${basePath }images/picx_02.jpg" alt="政策法规" /></a>
								</div>
							</div>
							<div class="picPolicyInfo">
								<div class="inPicPolicyInfo">
									<a href="#"><img src="${basePath }images/picx_03.jpg" alt="政策法规" /></a>
								</div>
							</div>
							
						</div><!-- 政策文件 -->
						
						<div class="everyPolicyWord">
							<ul>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[市国税局]国家税务总局关于启用新版增值税发票有关问题的公告">[市国税局]国家税务总局关于启用新版增值税发票有关问题的公告</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[市国税局]国家税务总局关于国际货物运输代理服务有关增值税问题的公告">[市国税局]国家税务总局关于国际货物运输代理服务有关增值税问题的公告</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[市国税局]国家税务总局关于启用新版增值税发票有关问题的公告">[市国税局]国家税务总局关于启用新版增值税发票有关问题的公告</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[市国税局]国家税务总局关于发布《纳税信用管理办法（试行）》的公告">[市国税局]国家税务总局关于发布《纳税信用管理办法（试行）》的公告</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[市交委]成都市交通运输委员会关于在交通行业开展重大火灾隐患集中整治专项行动的通知">[市交委]成都市交通运输委员会关于在交通行业开展重大火灾隐患集中整治专项行动的通知</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[成都市医疗管理保险局]关于转发《四川省流动就业人员基本医疗保障关系转移接续登记管理实施办法（暂行）》的通知">[成都市医疗管理保险局]关于转发《四川省流动就业人员基本医疗保障关系转移接续登记管理实施办法（暂行）》的通知</a>
									</div>
								</li>
							</ul>
						</div>
				</div><!-- end 政策法规 everyLeftInfo -->
				<div class="everyLeftInfoTitlePart">
					<div class="everyLeftInfoTitle">基层公开</div>
					<div class="titleMore"><a href="#">更多&raquo;</a></div>				
				</div>				
				<div class="everyLeftInfo">
						<div class="everyPolicy">
							<div class="picPolicyInfo">
								<div class="inPicPolicyInfo">
									<a href="#"><img src="${basePath }images/picx_04.jpg" alt="基层公开" /></a>
								</div>
							</div>
							<div class="picPolicyInfo">
								<div class="inPicPolicyInfo">
									<a href="#"><img src="${basePath }images/picx_05.jpg" alt="基层公开" /></a>
								</div>
							</div>
							
						</div><!-- end everyPolicy 基层公开 -->
						
						<div class="everyPolicyWord">
							<ul>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[花径路社区]2013年10月花郡佳圆财务公示表">[花径路社区]2013年10月花郡佳圆财务公示表</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[八里庄社区]八里庄社区开展“巾帼维权月”法制宣传活动">[八里庄社区]八里庄社区开展“巾帼维权月”法制宣传活动</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[聚和社区]聚和社区一组2014年6月财务公布">[聚和社区]聚和社区一组2014年6月财务公布</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[关家社区]关家社区2014年组务公开情况说明">[关家社区]关家社区2014年组务公开情况说明</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[玉石社区]玉石社区2组2014年1-6月财务公开（单位：元）">[玉石社区]玉石社区2组2014年1-6月财务公开（单位：元）</a>
									</div>
								</li>
								<li>
									<div class="everyPolicyInfo">
										<span class="pointer"></span>
										<a href="#" title="[永益村]永益社区对全社区河道沟渠进行大排查">[永益村]永益社区对全社区河道沟渠进行大排查</a>
									</div>
								</li>
							</ul>
						</div>
				</div><!-- end 基层公开 everyLeftInfo -->
				
				<div class="everyLeftInfoTitlePart">
					<div class="everyLeftInfoTitle">监督管理</div>
					<div class="titleMore"><a href="#">更多&raquo;</a></div>				
				</div>				
				<div class="everyLeftInfo">
					<!-- 网络举报投诉 -->
					<div class="everyManage">
						<div class="btnEveryManage">
							<img width="260px" height="50px" src="${basePath }images/picx_04.jpg" alt="基层公开">
						</div>
						<ul>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="纪检监察在线举报 ">纪检监察在线举报 </a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="行政效能暨软环境投诉举报">行政效能暨软环境投诉举报 </a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="组织部党员举报投诉 ">组织部党员举报投诉 </a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="信访局在线信访">信访局在线信访</a>
								</div>
							</li>
						</ul>
					</div>
					<!-- 监督工作平台 -->
					<div class="everyManage" style="border:none;">
						<div class="btnEveryManage">
							<img width="260px" height="50px" src="${basePath }images/picx_05.jpg" alt="基层公开">
						</div>
						<ul>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="行政审批电子监察系统 ">行政审批电子监察系统</a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="农村集体“三资”监管系统">农村集体"三资"监管系统</a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="村级公共专项资金监管系统">村级公共专项资金监管系统</a>
								</div>
							</li>
							<li>
								<div class="everyManageWord">
									<span>&bull;</span>
									<a href="#" title="基层平台运行监管系统">基层平台运行监管系统</a>
								</div>
							</li>
						</ul>
					</div>
				</div><!-- end 监督管理 everyLeftInfo -->				
			</div><!-- leftOtherInfo -->
						
			<div class="rightOtherInfo">
				<div class="everyInfo everyInfoUpLine_01">
					<div class="titleEveryInfoTriangle"></div>
					<div class="titlePart">
						<div class="titleEveryInfo titleEveryInfoColor_01">市县级动态</div>
						<div class="titleMore"><a href="">更多&raquo;</a></div>
					</div>
					<div class="everyInfoPic">
						<div class="picInfo picInfoBackColor_01">
							<div class="inPicInfo">
								<a href="#"><img src="${basePath }images/picx_06.jpg" alt="市县级动态" /></a>
							</div>
						</div>
						<div class="descPicInfo">
							<div class="titleDescPicInfo">
								<a href="#">[成都市]上半年市政基础设施投资298亿元</a>
							</div>
							<div class="detailDescPicInfo">
								<a href="#">成立专门小组，实行“白加黑”</a>
							</div>
						</div>
					</div>
					<ul>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[成都市]未雨绸缪 暴雨袭来有险无灾 ">[成都市]未雨绸缪 暴雨袭来有险无灾 </a>
							</div>
							<div class="everyInfoLiTime">07-10</div>
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[成都市]地铁3号线二、三期工程预计今年年底开工 ">[成都市]地铁3号线二、三期工程预计今年年底开工 </a>
							</div>
							<div class="everyInfoLiTime">07-09</div> 
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[成都市]今年竣工保障房和棚户区改造25924套">[成都市]今年竣工保障房和棚户区改造25924套</a>
							</div>
							<div class="everyInfoLiTime">07-04</div> 
						</li>								
					</ul>				
				</div>
				<div class="everyInfo everyInfoUpLine_02">
					<div class="titleEveryInfoTriangle"></div>
					<div class="titlePart">
						<div class="titleEveryInfo titleEveryInfoColor_02">乡镇/街道动态</div>
						<div class="titleMore"><a href="">更多&raquo;</a></div>
					</div>
					<div class="everyInfoPic">
						<div class="picInfo picInfoBackColor_02">
							<div class="inPicInfo">
								<a href="#"><img src="${basePath }images/picx_07.jpg"/></a>
							</div>
						</div>
						<div class="descPicInfo">
							<div class="titleDescPicInfo">
								<a href="#">[二仙桥街道] 街道文化活动中心协同区旅体局下院落</a>
							</div>
							<div class="detailDescPicInfo">
								<a href="#">2014年7月21日下午14:00，二仙桥</a>
							</div>
						</div>
					</div>
					<ul>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[道明镇]高翔到道明镇调研 ">[道明镇]高翔到道明镇调研</a>
							</div>
							<div class="everyInfoLiTime">07-10</div>
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[鹤山镇]副县长刘琳调研鹤山镇“儿童之家”暑期工作">[鹤山镇]副县长刘琳调研鹤山镇“儿童之家”暑期工作</a>
							</div>
							<div class="everyInfoLiTime">07-10</div> 
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[公议乡]公议乡汛期做好地质灾害多发区防汛安全工作">[公议乡]公议乡汛期做好地质灾害多发区防汛安全工作 </a>
							</div>
							<div class="everyInfoLiTime">07-10</div> 
						</li>			
					</ul>
				</div>
				<div class="everyInfo everyInfoUpLine_03">
					<div class="titleEveryInfoTriangle"></div>
					<div class="titlePart">
						<div class="titleEveryInfo titleEveryInfoColor_03">村/社区动态</div>
						<div class="titleMore"><a href="">更多&raquo;</a></div>
					</div>
					<div class="everyInfoPic">
						<div class="picInfo picInfoBackColor_03">
							<div class="inPicInfo">
								<img src="http://172.39.255.169:80/VillageManage/images/picx_06.jpg" alt="市县级动态">
							</div>
						</div>
						<div class="descPicInfo">
							<div class="titleDescPicInfo">
								<a href="#">[五星村]五星村灭螺工作</a>
							</div>
							<div class="detailDescPicInfo">
								<a href="#">近日，五星村开展2014年灭螺</a>
							</div>
						</div>
					</div>
					<ul>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[胜利村]土地流转 ">[胜利村]土地流转 </a>
							</div>
							<div class="everyInfoLiTime">07-20</div>
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[舟渡村]支部座谈会">[舟渡村]支部座谈会</a>
							</div>
							<div class="everyInfoLiTime">07-11</div>
						</li>
						<li>
							<div class="everyInfoLi">
								<span class="point"></span>
								<a href="#" title="[乌尤村]乌尤村综合组织机构网路 ">[乌尤村]乌尤村综合组织机构网路</a>
							</div>
							<div class="everyInfoLiTime">07-11</div> 
						</li>			
					</ul>
				</div><!-- end everyInfo -->
			</div><!-- end rightOtherInfo -->
			<div class="forPeople">
				<div class="forPeopleTitle">便民服务</div>
				<div class="forPeopleContent">
					<div class="partforPeople">
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">生育</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">户籍</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">教育</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">文化</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">医疗</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">住房</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">就业</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">兵役</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">社保</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">婚姻</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">纳税</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">更多&raquo;</div>
						</div>
					</div>
					<div class="partforPeople" style="border:none;">
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">设立变更</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">企业准营</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">缴纳税收</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">年检年审</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">质量检查</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">资格认证</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">安全防护</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">立项审报</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">建筑城建</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">劳动保障</div>
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">人力资源</div>							
						</div>
						<div class="everyForPeople">
							<div class="everyForPeopleImg">
								
							</div>
							<div class="everyForPeopleWord">更多&raquo;</div>
						</div>
						</div>
					</div>					
				</div>
			</div>
		
		<div class="picLink">
			<div class="inPicLink">
				<a href="#">
					<img src="${basePath }images/picLink_01.jpg" alt="天府新区建设" />
				</a>
			</div>
			<div class="inPicLink">
				<a href="#">
					<img src="${basePath }images/picLink_02.jpg" alt="统筹城乡重点改革" />
				</a>
			</div>
			<div class="inPicLink" style="margin:0;">
				<a href="#">
					<img src="${basePath }images/picLink_03.jpg" alt="奋力打造西部核心增长极" />
				</a>
			</div>
		</div>
	</div><!-- end main -->
	
	
	<jsp:include page="/common/footer.jsp" />

</body>
</html>