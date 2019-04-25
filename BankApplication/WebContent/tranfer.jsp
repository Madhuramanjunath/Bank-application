<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="logo.png" type="img/icon" rel="icon">
</head>
<body>
<form action="Transfer">
<div style="background-image: url('img/bank4.jpg');background-size :100% 700px; width:100%;height: 700px;" >
		<div id ="header">
			<div id="logo">
				<h1><font color ="white">BANK APPLICATION</font></h1>
			</div>
			<div id="nav">
				<ul>
					<li><a href="CheckBalance">CheckBalance</a></li>
					<li><a href="changePwd.jsp">ChangePassword</a></li>
					<li><a href="tranfer.jsp">Money Transfer</a></li>
					<li><a href="applyLoan.jsp">Apply loan</a></li>
					<li><a href="GetStatements">get Statement</a></li>
					<li><a href="Logout">Logout</a></li>
					
					
					
					</ul>
					
				</div>
			<div id="banner"><br><br><br><br><br><br><br><br><br>
			<center><div style="background:rgba(255,255,255,0.5);width:80%; ">
<table>
<tr>
	<td style="color: black" width="50%" height="50px">RECEIVER ACCNO</td>
	<td  width="50% " height="50px"><input type="text" name="raccno" placeholder=" Enter receiver accno" title="Enter receiver accno"></td>
</tr>
<tr>
	<td style="color: black" width="50%" height="50px">AMOUNT</td>
	<td width="50% " height="50px"><input type="text" name="amount" placeholder="enter amount to transfer" title="Enter amount "></td>
</tr>

<tr><td><input type="submit" name="Submit"></td></tr>

</table>
</div>
</div>
</div>
</div>


</form>

</body>
</html>