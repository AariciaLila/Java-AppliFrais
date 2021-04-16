<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>GSB application de frais</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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

				<c:if test="${ficheFrais != null}">
					<input type="hidden" name="id" value="<c:out value='${loginBean.idVisiteur}' />" />
				</c:if>
				<c:if test="${ficheFrais != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${ficheFrais == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${ficheFrais != null}">
            			Modifier
            		</c:if>
						<c:if test="${ficheFrais == null}">
            			Ajouter
            		</c:if>
					</h2>
				</caption>

            			
           <c:if test="${ficheFrais != null}"> 	
				<fieldset class="form-group">
					<h2>Frais Forfait</h2>
						<c:forEach var="ligneFF" items="${ligneFF}">
				
							<c:choose>
				
				  <c:when test="${ligneFF.idFraisForfait == 'ETP'}">
				  	<label>Date</label> <input type="text"
						value="<c:out value='${ligneFF.mois}' />" class="form-control"
						name="targetDate" id= "datepicker" required="required">
						
					<label>Etape (Nuitée + Repas):</label> <input type="text"
						value="<c:out value='${ligneFF.quantite}' />" class="form-control"
						name="ETP" placeholder="(entrer un nombre)">
							</c:when>
							
						  <c:when test="${ligneFF.idFraisForfait == 'NUI'}">
						<label>Nuitée (hors étape):</label> <input type="number"
						value="<c:out value='${ligneFF.quantite}' />" class="form-control"
						name="NUI" minlength="5" placeholder="(entrer un nombre)">
							</c:when>
							
						  <c:when test="${ligneFF.idFraisForfait == 'REP'}">
						<label>Restaurant (hors étape):</label> <input type="number"
						value="<c:out value='${ligneFF.quantite}' />" class="form-control"
						name="REP" minlength="5" placeholder="(entrer un nombre)">
							</c:when>
							
							<c:otherwise>
						<label>Kilomètre:</label> <input type="number"
						value="<c:out value='${ligneFF.quantite}' />" class="form-control"
						name="KM" minlength="5" placeholder="(entrer un nombre)">
							</c:otherwise>
								</c:choose>	
						 </c:forEach> 	
						
				</fieldset>
				<button type="submit" name ="enregistrerHF" class="btn btn-success">Enregistrer</button>
				
				</c:if>
		
  	<c:if test="${ficheFrais == null}">
            				<fieldset class="form-group">
					<h2>Frais Forfait</h2>
					
				
				  	<label>Date</label> <input type="text"  class="form-control"
						name="targetDate" id="datepicker" required="required">
						
					<label>Etape (Nuitée + Repas):</label> <input type="text"
					 class="form-control"
						name="ETP" placeholder="(entrer un nombre)">
							
							
						
						<label>Nuitée (hors étape):</label> <input type="number"
						 class="form-control"
						name="NUI" minlength="5" placeholder="(entrer un nombre)">
							
							
						<label>Restaurant (hors étape):</label> <input type="number"
						 class="form-control"
						name="REP" minlength="5" placeholder="(entrer un nombre)">
						
						<label>Kilomètre:</label> <input type="number"
						 class="form-control"
						name="KM" minlength="5" placeholder="(entrer un nombre)">
						
					
						
				</fieldset>
				<button type="submit" name ="enregistrer" class="btn btn-success">Enregistrer</button>
						
            		</c:if>
				
					
            			
		</form>
					
			</div>
		</div>
	</div>
	

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
	<script>
$(function(){
    $("#datepicker").datepicker()
})
</script>	
</html>
