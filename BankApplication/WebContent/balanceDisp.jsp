<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BANK APPLICATION</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="logo.png" type="img/icon" rel="icon">
</head>
<body>
<form action ="CheckBalance">
<div id= "full">
		<div style="background-image: url('img/pig9.jpg');background-size :100% 700px; width:100%;height: 700px;" >
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
			
			
		</div>
		<div id="banner"><br><br><br><br><br><br><br><br><br>
			<h1 style="color: black;text-align: center;"><%out.println("Balance:"+session.getAttribute("balance")); %></h1>
			
		</div>
		
	
	<center>
	
	
	</center>
	</div>
	</div>
	
</div >
		
	

			
 </form>                         
</body>
</html>