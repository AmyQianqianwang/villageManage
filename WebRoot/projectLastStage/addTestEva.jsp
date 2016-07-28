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
    <title>项目评测情况</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 项目评测情况</span>
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
						<!-- 测评结果 -->
						<td><span>测评结果</span></td>
						<c:if test="${testEva.teresult}">
						<td style="text-align:left;">
							<input type="radio" name="pass" id="pass" alt="通过" value="通过" checked="checked"/><label for="pass">通过</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pass"  id="unpass" alt="未通过" value="未通过" /><label for="unpass">未通过</label>
						</td>
						</c:if>
						<c:if test="${!testEva.teresult}">
						<td style="text-align:left;">
							<input type="radio" name="pass" id="pass" alt="通过" value="1" /><label for="pass">通过</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pass"  id="unpass" alt="未通过" value="0"  checked="checked"/><label for="unpass">未通过</label>
						</td>
						</c:if>
					</tr>
					
					<tr>
						<!-- 测评时间 -->
						<td><span>测评时间</span></td>
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
						<!-- 项目实施时间 -->
						<td><span>项目实施时间</span></td>
						<td style="text-align:left; float:left;">
							<select class="forSelectDate" id="selYear1" name="year1"></select>
							<select class="forSelectDate" id="selMonth1" name="month1"></select>
							<select class="forSelectDate" id="selDay1" name="day1"></select>
							<script type="text/javascript"> 
								var selYear1 = window.document.getElementById("selYear1"); 
								var selMonth1 = window.document.getElementById("selMonth1"); 
								var selDay1 = window.document.getElementById("selDay1");  
								new DateSelector(selYear1, selMonth1, selDay1,"${year}","${month}","${day}");  
							</script>
						</td>
					</tr>
					
					<tr>
						<!-- 项目最低保修年限（年） -->
						<td><span>项目最低保修年限（年）</span></td>
						<td style="text-align:left; float:left;">
							<select style="margin-top:8px;" class="forRepairDate" name="warrantyPeriod" >
								<option value="0" id="w0">半年</option>
								<option value="1" id="w1">1年</option>
								<option value="2" id="w2">2年</option>
								<option value="3" id="w3">3年</option>
								<option value="4" id="w4">4年</option>
								<option value="5" id="w5">5年</option>
							</select>	
							<script type="text/javascript"> 
								window.document.getElementById("w"+"${testEva.warrantyPeriod}").setAttribute('selected','selected'); 
							</script>			
						</td>
						
					</tr>
					<tr>
						<!-- 验收小组成员 -->
						<td><span>验收小组成员</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="teacceptName">${testEva.teacceptName}</textarea></td>
					</tr>
					<tr>
						<!-- 验收意见 -->
						<td><span>验收意见</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="teacceptOpinion">${testEva.teacceptOpinion}</textarea></td>
					</tr>
					<tr>
						<!-- 质保金支付金额（万元） -->
						<td><span>质保金支付金额（万元）</span></td>
						<td><input type="text" class="forDate" name="guaranteeMoney" value="${testEva.guaranteeMoney}" /></td>
					</tr>
					<tr>
						<!-- 群众评议结果 -->
						<td><span>群众评议结果</span></td>
						<c:if test="${testEva.temassesEvaluateResult}">
						<td style="text-align:left;">
							<input type="radio" name="review" alt="满意" checked="checked" value="1" id="pleased"/><label for="pleased">满意</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="review"  alt="不满意" value="0" id="yawp"/><label for="yawp">不满意</label>
			</td>
						</c:if>
						<c:if test="${!testEva.temassesEvaluateResult}">
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
						<c:forEach items="${testEva.testevaluateinfoAttachments}" var="r1" varStatus="s1">
						<div style="color:#0000ff;"><a href="${r1.attachmentUrl}">${r1.attachmentName}</a></div>
						</c:forEach>
						</td>
						
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="tableComment">${testEva.tableComment}</textarea></td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，仍可继续编辑；提交后，不能再进行任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
							<input type="button" class="forBtn" value="保存" onclick="javascript:fSubmit('${basePath}testEva_save.action')"/>
							<input type="reset" class="forBtn" value="重置" />
							<input type="button" class="forBtn" value="提交" onclick="javascript:fSubmit('${basePath}testEva_add.action')"/>
							</center>
							<input type="hidden" value="${project.proId}" name="proId"/>
							<input type="hidden" value="${testEva.testevaluateinfoId}" name="tid" />
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