<html>
<body>
<h3>JSP built-in objects</h3>
Request User Agent: <%= request.getHeader("User-Agent") %>
<br>
<br>
Request User Language: <%= request.getLocale() %>
</body>
</html>