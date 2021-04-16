<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import= "com.sio.model.LoginBean" %>
<html>
<head>
<title>GSB Appli Frais</title>

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
				
  <ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a value='${visiteur.prenom}'> Bonjour ${visiteur.prenom}  ${visiteur.nom} </a></li>
			</ul>
				</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Liste des frais</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste des frais</h3>
			<hr>
			<div class="container text-left">
<caption>
					<h2>
						<c:if test="${ficheFrais == null}">
            		<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Ajouter des frais forfait</a>
            		</c:if>
						<c:if test="${ficheFrais != null}">
            			<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Modifier les frais forfait</a>
            		</c:if>
					</h2>
					<h2>
					  <a href="<%=request.getContextPath()%>/listHF"
					class="btn btn-success">Ajouter des frais forfait hors forfait</a>
            	
					</h2>
				</caption>
				
					<hr>
		
			
			
			</div>
			
			<br>
			<table class="table table-bordered">
			
				<thead>
					<tr>
						<th>Date</th>
						<th>Status</th>
						<th>Justificatifs</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="listFrais" items="${listFrais}">
<input type="hidden" name="mois"
 value="<c:out value='${listFrais.mois}' />">
						<tr>
						
							<td><c:out value="${listFrais.mois}" /></td>
							<td><c:out value="${listFrais.libelleEtat}" /></td>
							<td><c:out value="${listFrais.nbJustificatifs}" /></td>

							<td>

						  <td><a href="see?id=<c:out value='${listFrais.mois}' />">Voir</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${listFrais.mois}' />">Supprimer</a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
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
