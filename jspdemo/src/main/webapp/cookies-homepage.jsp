<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookies homepage</title>
</head>
<body>
	<h3>Training Portal</h3>
	<!-- read the favourite programming language cookie -->
	<%
	// the default language just in case there is no value for the favourite programming language
	String favLang = "Java";

	// read the cookies
	Cookie[] theCookies = request.getCookies();

	// find the cookie

	if (theCookies != null) {
		for (Cookie tempCookie : theCookies) {
			if ("myApp.favouriteLanguage".equals(tempCookie.getName())) {
		favLang = tempCookie.getValue();
		break;
			}
		}
	}
	%>
	<!-- Show a personalised page for the favourite Language -->

	<!-- show new books for this language -->
	<h4>
		New books for
		<%=favLang%></h4>
	<ul>
		<li>placeholder</li>
		<li>placeholder</li>
	</ul>
	<h4>
		Latest updates for
		<%=favLang%></h4>
	<ul>
		<li>placeholder</li>
		<li>placeholder</li>
	</ul>
	<h4>
		Latest jobs for
		<%=favLang%></h4>
	<ul>
		<li>placeholder</li>
		<li>placeholder</li>
	</ul>
	<hr>
	<a href="cookies-personalise-form.html">Personalise this page</a>

</body>
</html>