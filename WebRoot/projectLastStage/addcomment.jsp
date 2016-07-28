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
    <title>项目评议情况（公共服务类）</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 项目评议情况（公共服务类）</span>
			</div>
		</div>	
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目内容：</td>
					<td>${project.proContext}</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>${US.userName}</td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>${US.office}</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>${today}</td>
				</tr>
			</table>
		</div>
	
		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form class="initialTable" id="mform" action="" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><input type="text" class="forText" readonly="readonly" value="${project.proName}" style="color:#c9c9c9;"/></td>
					</tr>
					<tr>
						<!-- 季度 -->
						<td><span>季度</span></td>
						<td>
							<select class="forDate" name="quarter">
								<option value="" id="q">---请选择---</option>
								<option value="1" id="q1">第一季度</option>
								<option value="2" id="q2">第二季度</option>
								<option value="3" id="q3">第三季度</option>
								<option value="4" id="q4">第四季度</option>
							</select>
							<script type="text/javascript"> 
								window.document.getElementById("q"+"${commentinfo.quarter}").setAttribute('selected','selected'); 
							</script>
						</td>
					</tr>
					<tr>
						<!-- 评议对象 -->
						<td><span>评议对象</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="commentObject">${commentinfo.commentObject}</textarea></td>
					</tr>
					<tr>
						<!-- 评议人员 -->
						<td><span>评议人员</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="commentName">${commentinfo.commentName}</textarea></td>
					</tr>
					<tr>
						<!-- 评议日期 -->
						<td><span>评议日期</span></td>
						<td style="text-align:left; float:left;">
							<select class="forSelectDate" id="selYear" name="year"></select>
							<select class="forSelectDate" id="selMonth" name="month"></select>
							<select class="forSelectDate" id="selDay" name="day"></select>
							<script type="text/javascript"> 
								var selYear = window.document.getElementById("selYear"); 
								var selMonth = window.document.getElementById("selMonth"); 
								var selDay = window.document.getElementById("selDay");  
								new DateSelector(selYear, selMonth, selDay,"${year}","${month}","${day}");  
							</script>
						</td>
					</tr>
					<tr>
						<!-- 评议情况  -->
						<td><span>评议情况 </span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="commentSituation">${commentinfo.commentSituation}</textarea></td>
					</tr>
					<tr>
						<!-- 群众评议结果 -->
						<td><span>群众评议结果</span></td>
						<c:if test="${commentinfo.cicheckResult}">
						<td style="text-align:left;">
							<input type="radio" name="review" alt="满意" checked="checked" value="1" id="pleased"/><label for="pleased">满意</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="review"  alt="不满意" value="0" id="yawp"/><label for="yawp">不满意</label>
						</td>
						</c:if>
						<c:if test="${!commentinfo.cicheckResult}">
						<td style="text-align:left;">
							<input type="radio" name="review" alt="满意" value="1" id="pleased"/><label for="pleased">满意</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="review"  alt="不满意" checked="checked" value="0" id="yawp"/><label for="yawp">不满意</label>
						</td>
						</c:if>
					</tr>
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span></td>
						<td id="upload">
							<input type="button" class="forUpload" value="上传" onclick="javascript:funClick();" />
							<input type="file" id="path1" name="file" style="display:none;" onchange="javascript:addAttach();" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td id="attach">
						<c:forEach items="${commentinfo.commentinfoAttachments}" var="r1" varStatus="s1">
						<div style="color:#0000ff;"><a href="${r1.attachmentUrl}">${r1.attachmentName}</a></div>
						</c:forEach>
						</td>
						
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="tableComment">${commentinfo.tableComment}</textarea></td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，仍可继续编辑；提交后，不能再进行任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
							<input type="button" class="forBtn" value="保存" onclick="javascript:fSubmit('${basePath}comment_save.action')"/>
							<input type="reset" class="forBtn" value="重置" />
							<input type="button" class="forBtn" value="提交" onclick="javascript:fSubmit('${basePath}comment_add.action')"/>
							</center>
							<input type="hidden" value="${project.proId}" name="proId"/>
							<input type="hidden" value="${commentinfo.commentinfoId}" name="cid" />
							<!-- 注：用户的单位。用户的id。从session中获取  填表时间直接读服务器时间 -->
							
						</td>
					</tr>
				</table>
			</form>
		</div><!-- end fillTable -->	
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
<script type="text/javascript">
	function fSubmit(path) {
		var Oform = document.getElementById("mform");
   		Oform.action = path;
   		Oform.submit();
	}
</script>
</body>
</html>