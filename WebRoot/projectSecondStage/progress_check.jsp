<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.hwadee.orm.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);

Project project=(Project)request.getAttribute("PROJECT");
Progresssupervisioninfo psi=(Progresssupervisioninfo)request.getAttribute("INSTANCE");
String editable=(String)request.getAttribute("EDITABLE");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>进度监督检查情况</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    <div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; <a style="text-decoration: none;" href="${basePath }projectSecondStage/index.jsp"> 项目实施与监察</a> &gt;进度监督检查情况</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
					<td>项目实施阶段</td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>四川省成都市华迪实训公司集团xxxxxxxxxxxx</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>张三</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>2014-7-14</td>
				</tr>
				
			</table>
		</div>
	
		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form name='infoForm' class="initialTable" action="" method="post">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span >项目编号</span></td>
						<td><%=project.getProId() %></td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><%=project.getProName() %></td>
					</tr>
					<tr>
						<!-- 监督人员-->
						<td><span class="forPoint">*&nbsp;</span><span>监督人员</span></td>
						<td><input type="text" name="psisupervisionName" class="forText"
									value='${psi.psisupervisionName }'/></td>
					</tr>
					<tr>
						<!-- 实施初期施工进度 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施初期施工进度</span></td>
						<td><input type="text" name="primaryProgress" class="forText"
									value='${psi.primaryProgress }' ></td>
					</tr>
					<tr>
						<!-- 实施初期施工问题 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施初期施工问题</span></td>
						<td><input type="text" name="primaryProblem" class="forText" 
									value='${psi.primaryProblem }' ></td>
					</tr>
					<tr>
						<!-- 实施初期记录日期 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施初期记录日期</span></td>
						<td><input type="text" name="primaryTime" class="forDate" 
									value='${psi.primaryTime }' ></td>
					</tr>
					<tr>
						<!-- 实施中期施工进度 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施中期施工进度</span></td>
						<td><input type="text" name="midProgress" class="forText" 
									value='${psi.midProgress }' ></td>
					</tr>
					<tr>
						<!-- 实施中期施工问题 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施中期施工问题</span></td>
						<td><input type="text" name="midProblem" class="forText" 
									value='${psi.midProblem }' ></td>
					</tr>
					<tr>
						<!-- 实施中期记录日期 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施中期记录日期</span></td>
						<td><input type="text" name="midTime" class="forDate" 
									value='${psi.midTime }' ></td>
					</tr>
					<tr>
						<!-- 实施末期施工进度 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施末期施工进度</span></td>
						<td><input type="text" name="lastProgress" class="forText" 
									value='${psi.lastProgress }' ></td>
					</tr>
					<tr>
						<!-- 实施中期施工问题 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施末期施工问题</span></td>
						<td><input type="text" name="lastProblem" class="forText" 
									value='${psi.lastProblem }' ></td>
					</tr>
					<tr>
						<!-- 实施中期记录日期 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施末期记录日期</span></td>
						<td><input type="text" name="lastTime" class="forDate" 
									value='${psi.lastTime }' ></td>
					</tr>
					<tr>
						<!-- 监督审定 -->
						<td><span class="forPoint">*&nbsp;</span><span>监督审定</span></td>
						<td><input type="text" name="psicheckResult" class="forText" 
									value='${psi.psicheckResult }' ></td>
					</tr>
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span></td>
						<td>
							<input type="button" class="forUpload" value="上传"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>放置上传的附件</td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5"
													name="tableComment" value='${csi.tableComment }'></textarea></td>
					</tr>
					<%if(editable.equals("true")){%>
						<tr>
							<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
						</tr>
						<tr>
							<td colspan="5">
								<center>
									<input type="button" name="btnSave"
											onclick="javascript:doSubmit(false);" class="forBtn"
											value="保存" /> 
									<input type="reset" id="reset" class="forBtn"
											value="重置" /> 
									<input type="button" name="btn"
											onclick="javascript:doSubmit(true);" class="forBtn"
											value="提交" />
									<input type="hidden" name="proID" value='${project.proId }'/> 
								</center>
							</td>
						</tr>
					<%} %>
				</table>
			</form>
		</div><!-- end fillTable -->	
	</div><!-- end mianTable -->
	
	<script>
	function doSubmit(bool) {
		var formX=document.infoForm;
		if(bool)
			{
			formX.action="${basePath }check_commitPSInfo.action";
			}
		else{
			formX.action="${basePath }check_savePSInfo.action";
			}
		formX.submit();
	}
	</script>
	
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>