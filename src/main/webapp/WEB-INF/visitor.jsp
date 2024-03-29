<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>VIsitors</title>
</head>
<body class="center">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample08" aria-controls="navbarsExample08"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-md-center"
			id="navbarsExample08">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="visitor">Visitors
						Log</a></li>
				<li class="nav-item"><a class="nav-link" href="users">Users</a></li>
			</ul>
		</div>
		<form method="POST">
			<c:if test="${logged}">
			<button class="btn btn-danger mx-2" id="logout">Logout</button>
		</c:if>
			<a class="btn btn-success" href="login">Login</a>
		</form>
	</nav>
	<h1 style="text-align: center;">Visitors Log</h1>
	<div class="container">
		<table class="table table-striped table-hover">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">IP</th>
				<th scope="col">Port</th>
				<th scope="col">Timestamp</th>
				<th scope="col">Url</th>
				<th scope="col">Action</th>
			</tr>
			<c:forEach items="${visitors_list}" var="visitor">
				<tr>
					<td scope="col"><c:out value="${visitor.id}" /></td>
					<td scope="col"><c:out value="${visitor.ip}" /></td>
					<td scope="col"><c:out value="${visitor.port}" /></td>
					<td scope="col"><c:out value="${visitor.timestamp}" /></td>
					<td scope="col"><c:out value="${visitor.url}" /></td>
					<td scope="col"><form method="post">
							<input type="hidden" name="id" value="${visitor.id}" /> <input
								type="submit" class="btn btn-danger" value="Delete"
								name="request" />
						</form></td>
				</tr>
			</c:forEach>
		</table>
		<form method="post"
			style="display: flex; align-items: center; justify-content: center;">
			<input class="btn btn-primary" type="submit" value="Reset"
				name="request" />
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<jsp:include page="shared/logout-confirmation.jsp" />
</html>