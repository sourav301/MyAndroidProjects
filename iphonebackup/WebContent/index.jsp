<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
if((String)session.getAttribute("status")!=null){
out.println("<script>alert(\"New User Created\");</script>");
session.setAttribute("status",null);
}
%>
<script type="text/javascript" charset="utf-8" src="cordovaios.js"></script>
 <script type="text/javascript" charset="utf-8">

 function formValidation(){
 var x=document.forms["login"]["name"].value;
	var y=document.forms["login"]["password"].value; 
	
	if(x==""){
		alert("Username Cannot be Blank");
		return false;
		}
	if(y==""){
		alert("Password Cannot be Blank");
		return false;
		
		}
	
	else{
		return true;
	}
 
 }
function exitFromApp()
             {
             
               navigator.app.exitApp();
             }
</script>

</head>
<body>
Welcome To Backup/Restore App!!
<form action="controller" method="get">
 <input type="hidden" name="requestpage" value="createuser">
  <input type="submit" value="New User">
</form>

<form name="login" action="controller" method="get" onsubmit="return formValidation()">
  User name: <input type="text" name="name"><br>
  Password: <input type="password" name="password"><br>
  <input type="hidden" name="requestpage" value="login">
  <input type="submit" value="Submit">
</form>

</body>
</html>