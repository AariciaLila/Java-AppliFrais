<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>GSB appli frais</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: darkblue">
			<div>
				<a href="" class="navbar-brand"> GSB </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listAdmin"
					class="nav-link">Liste des visiteurs</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">Liste des utilisateurs</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newFormUser"
					class="btn btn-success">Ajouter un utilisateur</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Adresse</th>
						<th>Date de naissance</th>
						<th>Profile</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="visiteur" items="${listVisiteur}">

						<tr>
							<td><c:out value="${visiteur.nom}" /></td>
							<td><c:out value="${visiteur.prenom}" /></td>
							<td><c:out value="${visiteur.adresse}" /></td>
							<td><c:out value="${visiteur.dateDeNaissance}" /></td>
							<td><c:out value="${visiteur.profile}" /></td>
							

							 <td><a href="delete?id=<c:out value='${visiteur.id}' />">Supprimer</a></td>

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>