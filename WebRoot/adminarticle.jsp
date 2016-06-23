<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="admin.js"></script>

</head>

<body>
	<c:if test="${not empty user }">
		<ul class="nav nav-pills">
			<li><a href="admin.jsp">管理员账户</a></li>
			<li><a href="adminuser.jsp">用户账户</a></li>
			<li class="active"><a href="adminarticle.jsp">文章管理</a></li>
			<li><a href="adminrecord.jsp">音频管理</a></li>
		</ul>
		
        您好，管理员。<a href="logout.jsp">[退出]</a>

		<br>
		<br>
		<br>

		<div id="toolbar" class="btn-group">
			<button type="button" class="btn btn-default" data-target="#addModal" data-toggle="modal">
				<i class="glyphicon glyphicon-plus"></i>
			</button>
			<button type="button" class="btn btn-default">
				<i class="glyphicon glyphicon-trash"></i>
			</button>
		</div>
		<table id="table" data-toggle="table"
			data-url="servlet/AdminArticleServlet" data-search="true"
			data-show-refresh="true" data-show-toggle="true"
			data-show-columns="true" data-toolbar="#toolbar">
			<thead>
				<tr>
					<th data-field="id">id</th>
					<th data-field="title">标题</th>
					<th data-field="aclass">类别</th>
					<th data-field="author">作者</th>
					<th data-field="content">内容</th>
					<th data-field="picture">图片</th>
					<th data-field="top">置顶</th>
					<th data-field="modify" data-formatter="modifyFormatter"
						data-events="modifyEvents">修改</th>
					<th data-field="delete" data-formatter="removeFormatter"
						data-events="articleRemoveEvents">删除</th>
				</tr>
			</thead>
		</table>

		<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">修改文章信息</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form"
							id="addNoteForm">
							<div class="input-group">

								<span class="input-group-addon">ID</span> <input type="text"
									class="form-control comp_sponsor" id="modify_id" maxlength="15"
									placeholder="填写id"> <span class="input-group-addon">标题</span>
								<input type="text" class="form-control comp_sponsor"
									id="modify_title" maxlength="15" placeholder="填写标题"> <span
									class="input-group-addon">作者</span> <input type="text"
									class="form-control comp_sponsor" id="modify_author"
									maxlength="10" placeholder="填写作者">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">类别</span>
								<!-- <input class="form-control comp_sponsor" id="add_dept"  placeholder="填写系名"> -->
								<select class="form-control" id="modify_class">
									<option>文章</option>
									<option>帖子</option>
								</select> <span class="input-group-addon">置顶</span>
								<!-- <input class="form-control comp_sponsor" id="add_collage"  placeholder="填写院名"> -->
								<select class="form-control" id="modify_top">
									<option>是</option>
									<option>否</option>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">内容</span> <input type="text"
									class="form-control comp_sponsor" id="modify_content"
									maxlength="10" placeholder="填写内容">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">图片</span> <input type="text"
									class="form-control comp_sponsor" id="modify_picture"
									maxlength="10" placeholder="填写图片">
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary"
							id='sendModifyConfirm' data-dismiss="modal" data-toggle="modal"
							onclick="modifyClick()">确认修改</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">add Article</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example bs-example-form" role="form"
							id="addNoteForm">
							<div class="input-group">
								<span class="input-group-addon">Title</span> <input type="text"
									class="form-control comp_sponsor" id="add_title" maxlength="15"
									placeholder="please entering title"> <span class="input-group-addon">Author</span>
								<input type="text" class="form-control comp_sponsor"
									id="add_author" maxlength="10" placeholder="please entering author">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Article Class</span>
								<!-- <input class="form-control comp_sponsor" id="add_dept"  placeholder="填写系名"> -->
								<select class="form-control" id="select_class">
								<option>article</option>
								<option>post</option>
								</select> <span class="input-group-addon">Top</span>
								<!-- <input class="form-control comp_sponsor" id="add_collage"  placeholder="填写院名"> -->
								<select class="form-control" id="select_top">
								<option>Not Top</option> <option>Top</option>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Content</span> <input type="text"
									class="form-control comp_sponsor" id="add_content" maxlength="100"
									placeholder="Content Url">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Picture</span> <input type="text"
									class="form-control comp_sponsor" id="add_picture"
									maxlength="100" placeholder="Picture Url">
							</div>
		
							
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" id='sendConfirm'
							data-dismiss="modal" data-toggle="modal" onclick="confirmClick()">添加</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${empty user }">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>

</body>
</html>
