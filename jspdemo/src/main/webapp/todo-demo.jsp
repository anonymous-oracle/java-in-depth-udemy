<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- create html form  -->
	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="item" /> <input type="submit"
			value="Submit" />
	</form>

	<!-- add an item to todo list -->
	<%-- <br> Item entered:
	<%=request.getParameter("item") %> --%>
	
	<%
	List<String> toDoList = (List<String>) session.getAttribute("toDoList");

	if (toDoList == null) {
		toDoList = new ArrayList<String>();
		session.setAttribute("toDoList", toDoList);
	}
	String itemValue = request.getParameter("item");
	if (itemValue != null) {
		toDoList.add(itemValue);
	}
	%>
	<!-- display all todo from session -->
	<br>
	<b>Todo:</b>
	<br>
	<ol>
		<%
		for (String item : (List<String>) session.getAttribute("toDoList")) {
			out.println("<li>" + item + "</li>");
		}
		%>
	</ol>
</body>
</html>