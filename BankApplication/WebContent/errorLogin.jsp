<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Application</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="logo.png" type="img/icon" rel="icon">
</head>
<body>

<form action="Login">
	<div style="background-image: url('img/bank4.jpg');background-size :100% 700px; width:100%;height: 700px;" >
		<div id ="header">
			<div id="logo">
				<h1><font color ="white">BANK APPLICATION</font></h1>
			</div>
			
			<div id="banner"><br><br><br><br><br><br><br><br><br>
			<center><div style="background:rgba(255,255,255,0.5);width:80%; ">
<table>
<tr>
	<td style="color: black" width="50%" height="50px">CUSTOMER ID</td>
	<td  width="50% " height="50px"><input type="text" name="custid" placeholder="enter Customer id" title="Enter customer id"></td>
</tr>
<tr>
	<td style="color: black" width="50%" height="50px">PASSWORD</td>
	<td width="50% " height="50px"><input type="password" name="pwd" placeholder="enter password" title="Enter password"></td>
</tr>

<tr><td><input type="submit" name="submit"></td>
<td>enter both the fields!!</td></tr>
</table>
</div>
</div>
</div>
</div>

</form>
</body>
</html>