<% 
String getname = null;
try{
	getname = (String)session.getAttribute("username") ;
}catch(Exception e){
	e.printStackTrace();
}
if (getname != null) {
	out.println("Session Exists");
}else{
	response.sendRedirect("index.html");
}
%>
<html>
<head>
<title>File Uploading Form</title>
</head>
<body>
<h3>File Upload:</h3>
<h3>Welcome:<%= (String)session.getAttribute("username") %></h3>
Select a file to upload: <br />
<form action="controller" method="post"
                        enctype="multipart/form-data">
<input type="file" name="requestpage" value="createaccount" size="5000" />
<br />
<input type="submit" value="Upload File" />
</form>
<form action="controller" method="get">
 <input type="hidden" name="requestpage" value="logout">
  <input type="submit" value="Log Out">
</form>
</body>
</html>