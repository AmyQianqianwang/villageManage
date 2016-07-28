<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.hwadee.orm.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);

Project project=(Project)request.getAttribute("PROJECT");
Directlyexecuteinfo dei=(Directlyexecuteinfo)request.getAttribute("INSTANCE");
String editable=(String)request.getAttribute("EDITABLE");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>ֱ��ʵʩ���</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    <div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>��Ŀ���� &gt; <a style="text-decoration: none;" href="${basePath }projectSecondStage/index.jsp"> ��Ŀʵʩ����</a> &gt;ֱ��ʵʩ���</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">��Ŀ״̬��</td>
					<td>��Ŀʵʩ�׶�</td>
				</tr>
				<tr>
					<td class="title">��λ���ƣ�</td>
					<td>�Ĵ�ʡ�ɶ��л���ʵѵ��˾����xxxxxxxxxxxx</td>
				</tr>
				<tr>
					<td class="title">���Ա��</td>
					<td>����</td>
				</tr>
				<tr>
					<td class="title">����ڣ�</td>
					<td>2014-7-14</td>
				</tr>
				
			</table>
		</div>
	
		<!-- ֱ��ʵʩ����� -->
		<div class="fillTable">			
			<<form name='infoForm' class="initialTable" action="" method="post">
				<table>
					<tr>
						<!-- ��Ŀ��� -->
						<td><span >��Ŀ���</span></td>
						<td><%=project.getProId() %></td>
					</tr>
					<tr>
						<!-- ��Ŀ���� -->
						<td><span>��Ŀ����</span></td>
						<td><%=project.getProName() %></td>
					</tr>
					<tr>
						<!-- ��Ŀ������ -->
						<td><span class="forPoint">*&nbsp;</span><span>��Ŀ������</span></td>
						<td><input type="text" name="projectLeaderName" class="forText"
									value='<%=dei.getProjectLeaderName() %>'/></td>
					</tr>
					<tr>
						<!-- ��Ŀ��������ϵ�绰 -->
						<td><span class="forPoint">*&nbsp;</span><span>��ϵ�绰</span></td>
						<td><input type="text" name="projectLeaderTel" class="forText"
									value='<%=dei.getProjectLeaderTel() %>' ></td>
					</tr>
					<tr>
						<!-- ��Ŀ�ල�� -->
						<td><span class="forPoint">*&nbsp;</span><span>��Ŀ�ල��</span></td>
						<td><input type="text" name="projectSupervisionName" class="forText"
									value='<%=dei.getProjectSupervisionName() %>' ></td>
					</tr>
					<tr>
						<!-- ��Ŀ�ල����ϵ�绰 -->
						<td><span class="forPoint">*&nbsp;</span><span>��ϵ�绰</span></td>
						<td><input type="text" name="projectSupervisionTel" class="forText" 
									value='<%=dei.getProjectSupervisionTel()%>'></td>
					</tr>
					<tr>
						<!-- ���� -->
						<td><span>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</span></td>
						<td>
							<input type="button" class="forUpload" value="�ϴ�"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>�����ϴ��ĸ���</td>
					</tr>
					<tr>
						<!-- ��ע -->
						<td><span>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ע</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5"
													name="tableComment" value='${dei.tableComment }'></textarea></td>
					</tr>
					<%if(editable.equals("true")){%>
						<tr>
							<td colspan="2" class="forPoint">ע������󣬼����༭���ύ�󣬲��������κθ���</td>
						</tr>
						<tr>
							<td colspan="5">
								<center>
									<input type="button" name="btnSave"
											onclick="javascript:doSubmit(false);" class="forBtn"
											value="����" /> 
									<input type="reset" id="reset" class="forBtn"
											value="����" /> 
									<input type="button" name="btn"
											onclick="javascript:doSubmit(true);" class="forBtn"
											value="�ύ" />
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
			formX.action="${basePath }implement_commitDEInfo.action";
			}
		else{
			formX.action="${basePath }implement_saveDEInfo.action";
			}
		formX.submit();
	}
	</script>
	
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>