package com.sio.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.sio.dao.LoginDao;
import com.sio.dao.SaisieFraisDaoImpl;
import com.sio.dao.VisiteurDaoImpl;
import com.sio.model.FicheFrais;
import com.sio.model.LigneFraisForfait;
import com.sio.model.LigneFraisHorsForfait;
import com.sio.model.ListeComptable;
import com.sio.model.LoginBean;
import com.sio.model.Visiteur;
import com.sio.utils.Tools;


@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SaisieFraisDaoImpl saisieDAO;
	//private LoginBean loginBean = new LoginBean();
	
	 LocalDate today = LocalDate.now();
	 java.util.Date date = new java.util.Date();
	 int month = today.getMonthValue();
	 String mois = Integer.toString(month);
	 int year = today.getYear();
	 String now = Integer.toString(month)+"-"+Integer.toString(year);
	
	public void init() {
	
		saisieDAO = new SaisieFraisDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertFrais(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showFicheFrais(request, response);
				break;
			case "/deletehf":
				deleteFraisHorsFrais(request, response);
				break;
			case "/edithf":
				showEditFormHF(request, response);
				break;
			case "/see":
				showFicheFrais(request, response);
				break;
			case "/update":
				insertFrais(request, response);
				break;
			case "/updatehf":
				updatehf(request, response);
				break;
			case "/list":
				listTodo(request, response);
				break;
			case "/listHF":
				listTodoHF(request, response);
				break;
			case "/listAdmin":
				listAdmin(request, response);
				break;
			case "/newFraisHF":
				newFraisHF(request, response);
				break;
			case "/newUser":
				AddNew(request, response);
				break;
			case "/newFormUser":
				showNewFormUser(request, response);
				break;
			case "/listComptable":
				listComptable(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	


private void listComptable(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException {
	List<ListeComptable> listComptable = SaisieFraisDaoImpl.get_fiches_frais_encours();
	request.setAttribute("listComptable", listComptable);
	RequestDispatcher dispatcher = request.getRequestDispatcher("comptable/listComptable.jsp");
	dispatcher.forward(request, response);
	}

	
	private void listTodo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer i_id =LoginBean.getId();
		List<FicheFrais> listFrais = SaisieFraisDaoImpl.get_fiches_frais_visiteur(i_id);
		FicheFrais ficheFrais = SaisieFraisDaoImpl.getUneFicheFrais(i_id, now);
		Visiteur visiteur = SaisieFraisDaoImpl.getUnVisiteur(i_id);
		System.out.println("visiteur.prenom" + visiteur.getPrenom());
		request.setAttribute("visiteur", visiteur);
		request.setAttribute("ficheFrais", ficheFrais);
		request.setAttribute("listFrais", listFrais);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frais/frais-list.jsp");
		dispatcher.forward(request, response);
		

	}
	
	
	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Visiteur> listVisiteur = SaisieFraisDaoImpl.get_all_visiteurs();
		request.setAttribute("listVisiteur", listVisiteur);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminAccueil.jsp");
		dispatcher.forward(request, response);
	}

	
	private void listTodoHF(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer i_id =LoginBean.getId();
		List<LigneFraisHorsForfait> ligneFHF = SaisieFraisDaoImpl.get_lignes_frais_hors_forfait(i_id, now);
		request.setAttribute("ligneFHF", ligneFHF);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frais/fraisHorsForfait.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private void showNewFormUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminNewUser.jsp");
		dispatcher.forward(request, response);
	}
	
	private void AddNew(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String cp = request.getParameter("codepostaleU");
	int cpInt =Integer.parseInt(cp) ;
	//hashache mdp
	//admin
	String mdp = request.getParameter("mdpU");
	System.out.println(mdp);
	String mdpHash = DigestUtils.shaHex(mdp);
	System.out.println(mdpHash);

		//SaisieFraisDaoImpl.addNewVisiteur(request.getParameter(" request.getParameter("dateNaissance"),  cp, request.getParameter("villeU"), request.getParameter("dateEmbauche"));		
	VisiteurDaoImpl.addNewVisiteur(request.getParameter("nomU"), request.getParameter("prenomU"),  request.getParameter("profileU"), request.getParameter("loginU"), request.getParameter("mdpU"), cpInt, request.getParameter("villeU"),request.getParameter("adresseu"), request.getParameter("dateNaissance"), request.getParameter("dateEmbauche"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminAccueil.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = LoginBean.getId();
		ArrayList<LigneFraisForfait> ligneFF = SaisieFraisDaoImpl.get_lignes_frais_forfait(id, now);
		//ArrayList<FicheFrais> fichefrais = SaisieFraisDaoImpl.get_fiches_frais_visiteur(id);
		 FicheFrais ficheFrais = SaisieFraisDaoImpl.getUneFicheFrais(id, now);
		 request.setAttribute("ficheFrais", ficheFrais);
		 System.out.println("ficheFrais" +ficheFrais);
		 System.out.println("now" +now);
		 request.setAttribute("ligneFF", ligneFF);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frais/saisieFrais.jsp");
		dispatcher.forward(request, response);
	}

	private void showFicheFrais(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = LoginBean.getId();
		String mois = request.getParameter("id");
		ArrayList<LigneFraisHorsForfait> ligneHF = SaisieFraisDaoImpl.get_lignes_frais_hors_forfait(id, mois);
		ArrayList<LigneFraisForfait> ligneFF = SaisieFraisDaoImpl.get_lignes_frais_forfait(id, mois);
		Visiteur visiteur = SaisieFraisDaoImpl.getUnVisiteur(id);
		//Double total = ligneFF.get
		System.out.println("visiteur.prenom" + visiteur.getPrenom());
		
		request.setAttribute("mois", mois);
		request.setAttribute("visiteur", visiteur);	//Visiteur visiteur = SaisieFraisDaoImpl.getUnVisiteur();
		request.setAttribute("ligneFF", ligneFF);
		request.setAttribute("ligneHF", ligneHF);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frais/ficheFraisModif.jsp");
		
		dispatcher.forward(request, response);

	}
	
	private void showEditFormHF(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
	
		Integer i_id =LoginBean.getId();
		List<LigneFraisHorsForfait> ligneFHF = SaisieFraisDaoImpl.get_lignes_frais_hors_forfait(i_id, now);
		request.setAttribute("ligneFHF", ligneFHF);
	
		String idLigneHF = request.getParameter("id");
		System.out.println("idLigneHF dans showEditForm: " + idLigneHF);
		int id = Integer.parseInt(idLigneHF);
		System.out.println("id dans showEditForm: " + id);
		 LigneFraisHorsForfait ligneFraisHorsForfait = SaisieFraisDaoImpl.getUneLigneHF(id);
			System.out.println("ligneFraisHF dans showEditForm: " + ligneFraisHorsForfait);
		 request.setAttribute("ligneFraisHorsForfait", ligneFraisHorsForfait);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("frais/fraisHorsForfait.jsp");
			
		dispatcher.forward(request, response);
		
		
	

	}
	
//	private void editFicheFrais(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//	
//		String idLigneFF = request.getParameter("id");
//		System.out.println("idLigneFF dans editFicheFrais: " + idLigneFF);
//		int id = Integer.parseInt(idLigneFF);
//		System.out.println("id dans editFicheFrais: " + id);
//		 LigneFraisHorsForfait ligneFraisHorsForfait = SaisieFraisDaoImpl.getUneLigneHF(id);
//			System.out.println("ligneFraisHF dans showEditForm: " + ligneFraisHorsForfait);
//		 request.setAttribute("ligneFraisHorsForfait", ligneFraisHorsForfait);
//		 RequestDispatcher dispatcher = request.getRequestDispatcher("frais/fraisHorsForfait.jsp");
//			
//		dispatcher.forward(request, response);
//		
//
//	}
	
	private   void  insertFrais(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		int quatite= 0;
		String unIdFraisForfait = "";
		String libelle = " ";
	
		String dateFicheFrais=request.getParameter("targetDate");
		int i_id =LoginBean.getId();
		System.out.println("i_id "+ i_id);
		ArrayList<LigneFraisForfait> listeLigneFraisForfait = new ArrayList <LigneFraisForfait>();
		ArrayList<LigneFraisHorsForfait> listeLigneFraisHorsForfait = new ArrayList <LigneFraisHorsForfait>();

		//A voir, créer une fiche frais à maintenant puis lui mettre à jour la date si elle est changé ?
		//Pour éviter un problème / Donc update la fiche frais en premier pour update les date des autres frais
		FicheFrais ficheFrais;// = new FicheFrais(dateFicheFrais, i_id, 0, 0.0, Date.valueOf(today),"CR","CR", listeLigneFraisHorsForfait, listeLigneFraisForfait);
		//SaisieFraisDaoImpl.creeNouvellesLignesFrais(i_id, dateFicheFrais);
		ficheFrais = SaisieFraisDaoImpl.getUneFicheFrais(i_id, dateFicheFrais);
		
		if(ficheFrais == null){
			
			 ficheFrais = new FicheFrais(dateFicheFrais, i_id, 0, 0.0, Date.valueOf(today),"CR","CR", listeLigneFraisHorsForfait, listeLigneFraisForfait);
			 System.out.println("ficheFrais est null" );
					
		}
		//String mois = ficheFrais.getMois();
		System.out.println("request.getParameter('enregistrer') "+request.getParameter("enregistrer") );
		System.out.println("request.getParameter('enregistrerHF') "+request.getParameter("enregistrerHF") );
		
		if (request.getParameter("enregistrer") != null) {
	    	if( request.getParameter("ETP") != null || request.getParameter("ETP") != ""){
				 quatite = Integer.parseInt(request.getParameter("ETP"));
				 //quatite = request.getParameter("ETP"));
				 unIdFraisForfait = "ETP";
				 libelle = "Etape";
				 
					LigneFraisForfait lff = new LigneFraisForfait(unIdFraisForfait, libelle, quatite, 0,"");
					listeLigneFraisForfait.add(lff);
					
			}
			if( request.getParameter("NUI") != null || request.getParameter("NUI") !=  ""){
				 quatite = Integer.parseInt(request.getParameter("NUI"));
				 unIdFraisForfait = "NUI";
				 libelle = "Nuité";
				
					LigneFraisForfait lff = new LigneFraisForfait(unIdFraisForfait, libelle, quatite, 0, dateFicheFrais);
					listeLigneFraisForfait.add(lff);
			}
			if( request.getParameter("REP") != null || request.getParameter("REP") != ""){
				 quatite = Integer.parseInt(request.getParameter("REP"));
				 unIdFraisForfait = "REP";
				 libelle = "Repas midi";
				 
				 LigneFraisForfait lff = new LigneFraisForfait(unIdFraisForfait, libelle, quatite, 0, dateFicheFrais);
					listeLigneFraisForfait.add(lff);
			}
			if( request.getParameter("KM") != null || request.getParameter("KM") != ""){
				 quatite = Integer.parseInt(request.getParameter("KM"));
				 unIdFraisForfait = "KM";
				 libelle = "kilometre";
				 
				 LigneFraisForfait lff = new LigneFraisForfait(unIdFraisForfait, libelle, quatite, 0, dateFicheFrais);
					listeLigneFraisForfait.add(lff);
			}
		

			ficheFrais.setLignesFraisForfait(listeLigneFraisForfait);
			//SaisieFraisDaoImpl.validerFraisForfait(ficheFrais);
			if (request.getParameter("enregistrer") != null) {
				
				SaisieFraisDaoImpl.validerFraisForfait(ficheFrais);
				}
				else {
					SaisieFraisDaoImpl.updateLigneFraisForfait(ficheFrais);
				}
				
			
			
	    } 
		System.out.println("on retourne les fiches frais ");
		//return ficheFrais;
		SaisieFraisDaoImpl.updateLigneFraisForfait(ficheFrais);
		response.sendRedirect("list");
	}
	

	private void newFraisHF(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		Integer i_id =LoginBean.getId();
		ArrayList<LigneFraisHorsForfait> listeLigneFraisHorsForfait = new ArrayList <LigneFraisHorsForfait>();
	    
		if( request.getParameter("libelle") != null && request.getParameter("montant") != null ){
		double	montant =Double.parseDouble(request.getParameter("montant"));
	
		String dateHF = request.getParameter("dateHF");
		String libelleHF = request.getParameter("libelle");
		String date = Tools.getMois(dateHF);
			
				LigneFraisHorsForfait lfhr = new LigneFraisHorsForfait(dateHF, montant, libelleHF);
				listeLigneFraisHorsForfait.add(lfhr);
				FicheFrais ficheFrais;
				
				ficheFrais = SaisieFraisDaoImpl.getUneFicheFrais(i_id, now);
				if (ficheFrais == null){
				 SaisieFraisDaoImpl.creeNouvellesLignesFrais(i_id, now);
				 ficheFrais =SaisieFraisDaoImpl.getUneFicheFrais(i_id, now);
				}
				ficheFrais.setLignesFraisHorsForfait(listeLigneFraisHorsForfait);
				
				SaisieFraisDaoImpl.validerLigneFraisHorsForfait(ficheFrais);
				response.sendRedirect("listHF");
		
		}
		
		else {
			System.out.println("Libellé ou montant manquant");
		}
	}


//	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//	
//		FicheFrais ficheFrais = this.getLesIds(request, response);
//	
//	
////	SaisieFraisDaoImpl.updateLigneFraisForfait(ficheFrais);
////		response.sendRedirect("list");
//	}
	private void updatehf(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		Double montant =Double.parseDouble(request.getParameter("montant"));
		 String s_id = request.getParameter("id");
		 System.out.printf("id " , s_id);
		 int id  = Integer.parseInt(s_id);
 System.out.printf("id " , s_id);
 System.out.println("on passe dans le updatehf ");
	LigneFraisHorsForfait ligneFraisHorsForfait = new LigneFraisHorsForfait(id,request.getParameter("dateHF"), montant, request.getParameter("libelle"));
	
	SaisieFraisDaoImpl.updateFraisHF(ligneFraisHorsForfait);
		response.sendRedirect("listHF");
	}
	
	private void updateHF(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		Double montant =Double.parseDouble(request.getParameter("montant"));
		//FicheFrais ficheFrais = this.getLesIds(request, response);
	LigneFraisHorsForfait ligneFraisHorsForfait = new LigneFraisHorsForfait(request.getParameter("dateHF"), montant, request.getParameter("libelle"));
	
	SaisieFraisDaoImpl.updateFraisHF(ligneFraisHorsForfait);
		response.sendRedirect("listHF");
	}
	
	private void updateFraisHorsForfait(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		//Todo updateTodo = new Todo(id, title, username, description, targetDate, isDone);
		
		//todoDAO.updateTodo(updateTodo);
		
		response.sendRedirect("list");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = LoginBean.getId();
		String mois = request.getParameter("id");
		System.out.println(id +" id et mois " + mois);
	SaisieFraisDaoImpl.DeleteUneFicheFrais(id, mois);
		response.sendRedirect("list");
	}
	
	private void deleteFraisHorsFrais(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String id = request.getParameter("id");
	SaisieFraisDaoImpl.deleteFraisHF(id);
		response.sendRedirect("listHF");
	}
}
