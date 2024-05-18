<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
/* read form data */
String favLang = request.getParameter("favouriteLanguage");

/* create the cookie  */
Cookie theCookie = new Cookie("myApp.favouriteLanguage", favLang);

/* set the life span of the cookie */
theCookie.setMaxAge(60 * 60 * 24 * 365);

/* add cookie to the response */
response.addCookie(theCookie);
%>
<body>
	Thanks! The favourite language is set to ${param.favouriteLanguage }
	<br>
	<br>

	<a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>