<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>GSB application de frais</title>

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
				<a href="https://www.javaguides.net" class="navbar-brand"> GSB</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Fiche de Frais</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Déconnexion</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

			
				<c:if test="${ligneFraisHorsForfait != null}">
					<form action="updatehf" method="post">
				</c:if>
				<c:if test="${ligneFraisHorsForfait == null}">
					<form action="newFraisHF" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${ligneFraisHorsForfait != null}">
            			Modifier
            		</c:if>
						<c:if test="${ligneFraisHorsForfait == null}">
            			Ajouter
            		</c:if>
					</h2>
				</caption>

		<c:if test="${ligneFraisHorsForfait != null}">
					<input type="hidden" name="id" value="<c:out value='${ligneFraisHorsForfait.id}' />" />
				</c:if>
	
				<fieldset class="form-group">
				<h2>Frais Hors Forfait</h2>
				
						<fieldset class="form-group">
					<label>Date</label> <input type="text"
						  value="<c:out value='${ligneFraisHorsForfait.date}' />" class="form-control"
						name="dateHF" required="required" >
				</fieldset>
					<label>Libellé:</label> <input type="text"
						value="<c:out value='${ligneFraisHorsForfait.libelle}' />" class="form-control"
						name="libelle" minlength="5">
						
						<label>Montant:</label> <input type="number" step="any" 
						value="<c:out value='${ligneFraisHorsForfait.montant}' />" class="form-control"
						name="montant" minlength="5">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="submit" name ="enregistrerHF" class="btn btn-success" href="updatehf?id=<c:out value='${ligneFraisHorsForfait.id}' />">Enregistrer le frais hors forfait</button>
	
				</fieldset>
		<table class="table table-bordered">
				<thead>
					<tr>
						<th>Libellé</th>
						<th>Date</th>
						<th>Montant</th>
						<th>Action</th>
						
					</tr>
				</thead>
			  	<tbody>
				<!--	  for (Todo todo: todos) {  -->
					<c:forEach var="ligneFHF" items="${ligneFHF}">

						<tr>
							<td><c:out value="${ligneFHF.libelle}" /></td>
							<td><c:out value="${ligneFHF.date}" /></td>
							<td><c:out value="${ligneFHF.montant}" /></td>
							

							<td><a href="edithf?id=<c:out value='${ligneFHF.id}' />">Modifier</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletehf?id=<c:out value='${ligneFHF.id}' />">Supprimer</a></td>

						<!--	  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> --> 
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>-->				
			

		</form>
					
			</div>
		</div>
	</div>
	

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
		
</html>
