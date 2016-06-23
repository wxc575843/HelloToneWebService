<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'admin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="srcipts/jquery-2.2.3.js"></script>
<link rel="Stylesheet" type="text/css"
	href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="Stylesheet" type="text/css"
	href="bootstrap-3.3.5-dist/css/bootstrap-table.css">
<link rel="Stylesheet" type="text/css"
	href="font-awesome-4.6.3/css/font-awesome.min.css">
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap-table.js"></script>


</head>

<body>
	<c:if test="${not empty user }">
		<ul class="nav nav-pills">
			<li><a href="admin.jsp">管理员账户</a></li>
			<li class="active"><a href="adminuser.jsp">用户账户</a></li>
			<li><a href="adminarticle.jsp">文章管理</a></li>
			<li><a href="adminrecord.jsp">音频管理</a></li>
		</ul>
		
        您好，管理员。<a href="logout.jsp">[退出]</a>
        <br><br><br>
        
        <div id="toolbar" class="btn-group">
			<button type="button" class="btn btn-default">
				<i class="glyphicon glyphicon-plus"></i>
			</button>
			<button type="button" class="btn btn-default">
				<i class="glyphicon glyphicon-trash"></i>
			</button>
		</div>
		<table data-toggle="table" data-url="servlet/AdminUserServelt" data-search="true" data-show-refresh="true"
			data-show-toggle="true" data-show-columns="true"
			data-toolbar="#toolbar">
			<thead>
				<tr>
					<th data-field="id">id</th>
					<th data-field="email">Email</th>
					<th data-field="nickName">nickName</th>
					<th data-field="password">password</th>
					<th data-field="gender">gender</th>
					<th data-field="country">country</th>
					<th data-field="chineseLevel">chineseLevel</th>
					<th data-field="experience">experience</th>
					<th data-field="postNum">postNum</th>
					<th data-field="articleNum">articleNum</th>
				</tr>
			</thead>
		</table>
	</c:if>
	<c:if test="${empty user }">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>
	
</body>
</html>
