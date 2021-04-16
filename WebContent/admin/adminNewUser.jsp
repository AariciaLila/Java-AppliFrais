<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

				<c:if test="${visiteur != null}">
					<input type="hidden" name="id" value="<c:out value='${saisieFrais.id}' />" />
				</c:if>
				<c:if test="${visiteur != null}">
					<form action="updateUser" method="post">
				</c:if>
				<c:if test="${visiteur == null}">
					<form action="newUser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${visiteur != null}">
            			Modifier
            		</c:if>
						<c:if test="${visiteur == null}">
            			Ajouter
            		</c:if>
					</h2>
				</caption>

				<c:if test="${visiteur != null}">
					<input type="hidden" name="id" value="<c:out value='${visiteur.id}' />" />
				</c:if>

				

				<fieldset class="form-group">
					<h2>Ajout utilisateur</h2>
						<fieldset class="form-group">
					<label>Date d'embauche</label> <input type="date"
						value="<c:out value='${visiteur.targetDate}' />" class="form-control"
						name="dateEmbauche" required="required">
				</fieldset>
					<label>Nom</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="nomU" >
						
						<label>Prenom</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="prenomU" minlength="5" >
						
						<label>Profile</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="profileU" minlength="5" >
						
						<label>Date de naissance</label> <input type="date"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="dateNaissance" minlength="5">
							
						<label>Login</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="loginU" minlength="5">
							
						<label>Mot de passe</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="mdpU" minlength="5">
						
						<label>Adresse</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="adresseu" minlength="5">
						
						<label>Code postale</label> <input type="number"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="codepostaleU" minlength="5">
						
						<label>Ville</label> <input type="text"
						value="<c:out value='${visiteur.quantite}' />" class="form-control"
						name="villeU" minlength="5">
				</fieldset>


				
				<button type="reset" class="btn btn-success">Réinitialiser</button>
				<button type="submit" name ="enregistrer" class="btn btn-success">Enregistrer</button>
			
		</form>
					
			</div>
		</div>
	</div>
	

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
		
</html>