<%@ page contentType="text/html;
charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Page Login</title>
</head>
<body>
<s:form>
	<table cellpadding="0" cellspacing="0" width="500">
		<tr>
			<td valign="top" width="500">
			<table cellpadding="0" cellspacing="0" height="300" width="500">
				<tr>
					<td > Titre </td>
				</tr>
				<tr>
					<td>
					<table>
						<tr>
							<td align="center">
							<table summary="" class="tableFormulaire"cellpadding="0" cellspacing="0" width="300">
								<tr>
									<td width="10">&nbsp;</td>
									<td width="100"><label>Login <font color="red" size="1">*</font></label></td>
									<td width="150"><s:textfield label="login" name='username' /></td>
								</tr>
								<tr>
									<td width="10">&nbsp;</td>
									<td width="100"><label for="j_spring_security_check_j_password"> Mot de passe <font color="red" size="1">*</font></label></td>
									<td width="161"><s:password name='password' /></td>
								</tr>
								<tr>
									<td colspan="2"></td>
									<td><s:submit value="Identification" ></s:submit></td>
								</tr>
							</table>
						</tr>
						<tr>
							<td colspan="5" align="center"></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
		</tr>
	</table>
</s:form>
</body>
</html>