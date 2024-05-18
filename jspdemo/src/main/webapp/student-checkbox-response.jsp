<html>
<head>
<title>
Student Confirmation Title
</title>
</head>

<body>
The Student is confirmed: ${param.firstName} ${param.lastName}
<br><br>
<!-- The list of student's favourite programming languages  -->
<ul>
<%
String[] langs = request.getParameterValues("favouriteLanguage");
for (String lang: langs){
	out.println("<li>"+lang+"</li>");
}
%>
</ul>
</body>
</html>