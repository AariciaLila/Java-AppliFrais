package com.sio.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.sio.dao.SaisieFraisDaoImpl;

public class Visiteur {
	
		private int id;
		private String nom;
		private String prenom;
		private String adresse;
		private String ville;
		private String profile;
		private String dateDeNaissance;
		private String cp;
		
		private ArrayList<FicheFrais> lesFichesFrais;

		
		/**
		 * Constructeur de Visiteur.
		 * 
		 * @param id
		 * 		Identifiant du visiteur.
		 * @throws SQLException
		 */
		public Visiteur(int id, String nom, String prenom, String ville, String adresse, String cp, String profile, String dateDeNaisance) throws SQLException
		{
			this.id = id;
			this.nom = nom; //SaisieFraisDaoImpl.getNomVisiteur(id);
			this.prenom = prenom; // SaisieFraisDaoImpl.getPrenomVisiteur(id);
			this.ville = ville;
			this.profile = profile;
			this.dateDeNaissance = dateDeNaisance;
			this.cp = cp;
			this.adresse = adresse;
			lesFichesFrais = SaisieFraisDaoImpl.get_fiches_frais_visiteur(id);
//			list<lesFichesFrais>;
//			Collections.sort(lesFichesFrais);
		}
		
		/**
		 * Renvoie la fiche de frais correspondant au Visiteur et au mois passer
		 * en paramètre.
		 * 
		 * @param mois
		 * 		Mois de la fiche à retourner.
		 * @return
		 * 		La fiche de frais correspondant au Visiteur et au mois.
		 */
		public FicheFrais rechercher_fiche_frais(String mois)
		{
			for(FicheFrais f : lesFichesFrais)
			{
				if(f.getMois().equals(mois))
				{
					return f;
				}				
			}
			return null;
		}
		
		public ArrayList<FicheFrais> getFiches()
		{
			return lesFichesFrais;
		}
		
		public String toString()
		{
			return nom + " " + prenom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getCp() {
			return cp;
		}

		public void setCp(String cp) {
			this.cp = cp;
		}

		public int getId() 
		{
			return id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getProfile() {
			return profile;
		}

		public void setProfile(String profile) {
			this.profile = profile;
		}

		public String getDateDeNaissance() {
			return dateDeNaissance;
		}

		public void setDateDeNaissance(String dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}

		public ArrayList<FicheFrais> getLesFichesFrais() {
			return lesFichesFrais;
		}

		public void setLesFichesFrais(ArrayList<FicheFrais> lesFichesFrais) {
			this.lesFichesFrais = lesFichesFrais;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
}
