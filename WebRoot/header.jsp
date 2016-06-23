<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'admin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="scripts/jquery.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</head>

<body>
	<c:if test="${not empty user }">
		<ul class="nav nav-pills">
			<li class="active"><a href="admin.jsp">管理员账户</a></li>
			<li><a href="#">用户账户</a></li>
			<li><a href="#">文章管理</a></li>
			<li><a href="#">音频管理</a></li>
		</ul>
		
        您好，管理员。<a href="logout.jsp">[退出]</a>
	</c:if>
	<c:if test="${empty user }">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>
</body>
</html>
