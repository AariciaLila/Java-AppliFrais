
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Comptable - liste de frais</title>
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
				<a href="" class="navbar-brand"> GSB - Application de gestion de frais </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listComptable"
					class="nav-link">Liste de Frais</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Déconnexion</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">Liste des Fiches de Frais à valider</h3>
			<hr>
			<div class="container text-left">
				<form class="form-inline" action="/recherche/" method="get">
    				<fieldset>    
      					<div class="input-group">
        					<div class="input-group-prepend">
          						<select id="oCategorie" name="oCategorie" class="form-control">
            						<option selected="selected" value="0">Visiteur</option>
            						<option value="1">Mois</option>
          						</select>
        					</div>
        					<input id="oSaisie" name="oSaisie" type="text" class="form-control" placeholder="Mot(s) clé(s)" required="required">
        					<div class="input-group-append">
          						<button class="btn btn-primary" type="submit">Recherche</button>
        					</div>
      					</div>
    				</fieldset> 
  				</form>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Date</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Statut</th>
						<th>Nombres de justificatifs</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="listComptable" items="${listComptable}">

						<tr>
							<td><c:out value="${listComptable.mois}" /></td>
							<td><c:out value="${listComptable.nomVisiteur}" /></td>
							<td><c:out value="${listComptable.prenomVisiteur}" /></td>
							<td><c:out value="${listComptable.libelleEtat}" /></td>
							<td><c:out value="${listComptable.justificatifs}" /></td>
							
							

							 <td><a href="select?id=<c:out value='${listComptable.mois} ${listComptable.idVisiteur}' />">Consulter</a></td>

							
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

