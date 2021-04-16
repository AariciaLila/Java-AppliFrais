<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">SaisieFrais</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="row">
		<div class="container">
			<div class="text-center">
			<img src="file:///C:/Users/Consultant/eclipse-PPE-WK/appliFrais/WebContent/images/gsb.png"  width="100" height="60">
			</div>
			<h3 class="text-center">ETAT DE FRAIS ENGAGES</h3>
			<hr>
			<p class="text-center">A retourner accompagné des justificatifs au plus tard le 10 du mois qui suit l’engagement des frais</p>
			<br>
			<div class="container text-left">
			<p style="color:blue">Visiteur<p>
			<label>matricule:</label> <p style="color:black">${visiteur.prenom}  ${visiteur.nom}<p>
						
						
			<label>Nom:</label><p style="color:black">${visiteur.nom}  ${visiteur.prenom}<p>
			<p style=""><p>
			<label>Mois:</label> <a style="color:black">${mois}</a>
			
			
			</div>
			<br>
					<table class="table table-bordered">
			
				<thead>
					<tr>
						<th>Frais Forfaitaires<sup>1</sup></th>
						<th>Quantité</th>
						<th>Montant unitaire<sup>2</sup></th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="ligneFF" items="${ligneFF}">

 <tr>
			<c:choose>
					  <c:when test="${ligneFF.idFraisForfait == 'ETP'}">
					  <td>Etape</td>
					  	<td class = "quantite" name = "quantite"> <c:out value="${ligneFF.quantite}" /> </div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
					
  						</c:when>
  <c:when test="${ligneFF.idFraisForfait == 'NUI'}">
   <td>Nuité</td>
		  	<td> <c:out value="${ligneFF.quantite}" /></div></td>
						<td class = "quantite" name = "quantite"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
  						</c:when>
   <c:when test="${ligneFF.idFraisForfait == 'REP'}">
   <td>Repas Midi</td>
		  	<td> <c:out value="${ligneFF.quantite}" /></div></td>
						<td class = "quantite" name = "quantite" > <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>	
  						</c:when>

  <c:otherwise>
    <td>Kilométrages<sup>3</sup></td>
	  	<td> <c:out value="${ligneFF.quantite}" /></div></td>
						<td class = "quantite" name = "quantite"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>
						<td class = "montant" name = "montant"> <c:out value="${ligneFF.montant}" /></div></td>	
  								
  </c:otherwise>
</c:choose>			
			
					</tr>
						<tr>
					
					</tr>
					<tr>
				   	</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
				<h4 class="text-center">Autres Frais<sup>4</sup></h4>
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
					<c:forEach var="ligneHF" items="${ligneHF}">

						<tr>
							<td> <c:out value="${ligneHF.libelle}" /></td>
							<td><c:out value="${ligneHF.date}" /></td>
							<td><c:out value="${ligneHF.montant}" /></td>
							<td><a href="edithf?id=<c:out value='${ligneHF.id}' />">Valider</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deletehf?id=<c:out value='${ligneHF.id}' />">Refuser</a></td>

							

						<!--	  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> --> 
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>-->
			<p class="container text-right"  style="color:blue" >Signature</p>
			<br>
			<hr>
		<p><sup>1</sup>Les frais forfaitaires doivent être justifiés par une facture acquittée faisant apparaître le montant de la TVA.
Ces documents ne sont pas à joindre à l’état de frais mais doivent être conservés pendant trois années. Ils
peuvent être contrôlés par le délégué régional ou le service comptable
		</p>
		<p><sup>2</sup>Tarifs en vigueur au 01/09/2010
		</p>
		<p><sup>3</sup>Prix au kilomètre selon la puissance du véhicule déclaré auprès des services comptables
		</p>
		<ul>
 			<li>(Véhicule 4CV Diesel) 0.52 € / Km</li>
  			<li>(Véhicule 5/6CV Diesel) 0.58 € / Km</li>
  			<li>(Véhicule 4CV Essence) 0.62 € / Km</li>
  			<li>(Véhicule 5/6CV Essence) 0.67 € / Km</li>
		</ul>
		<p><sup>3</sup>Prix au kilomètre selon la puissance du véhicule déclaré auprès des services comptables
		</p>
		
		</div>
		
		
		
		
		
		
		</div>
		


	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>