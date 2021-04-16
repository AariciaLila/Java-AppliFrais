
package com.sio.model;

import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sio.dao.SaisieFraisDaoImpl;
import com.sio.utils.JDBCUtils;

public class ListeComptable {
	private String mois;
	private String nomVisiteur;
	private String prenomVisiteur;
	private String libelleEtat;
	private int idVisiteur;
	private int justificatifs;


	private ArrayList<ListeComptable> listeComptable;
	
	/**
	 * Constructeur de ListeComptable.
	 * 
	 * @param mois
	 * 		Mois correspondant à la fiche.
	 * @param id
	 * 		Id du visiteur dont la fiche appartient.
	 * @param nom
	 * 		Nom du visiteur dont la fiche appartient
	 * @aram prenom
	 * 		Prenom du visiteur dont la fiche appartient
	 * @param nbJustifs
	 * 		Nombre de justificatifs.
	 * @param montantValide
	 * 		Ca je ne sais pas trop ce que c'est.
	 * @param dateModif
	 * 		Date de dernière modification de la fiche.
	 * @param idEtat
	 * 		Identifiant de l'état de la fiche.
	 * @param libEtat
	 * 		Libellé de l'état de la fiche.
	 * @param lignesFraisHorsForfait
	 * 		ArrayList de LigneFraisForfait associées à la fiche.
	 * @param lignesFraisForfait
	 * 		ArrayList de LigneFraisHorforfait associées à la fiche.
	 */
	
	public ListeComptable(String mois, String nom, String prenom, String libEtat, int idVisiteur, int justificatifs)
	{
		this.mois = mois;
		this.nomVisiteur = nom;
		this.prenomVisiteur = prenom;
		this.libelleEtat = libEtat;
		this.idVisiteur = idVisiteur;
		this.justificatifs = justificatifs;
	}




	//getters et setters
		
	public ArrayList<ListeComptable> getListeComptable() {
		return listeComptable;
	}


	public int getJustificatifs() {
		return justificatifs;
	}




	public void setJustificatifs(int justificatifs) {
		this.justificatifs = justificatifs;
	}




	public int getIdVisiteur() {
		return idVisiteur;
	}




	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}




	public void setListeComptable(ArrayList<ListeComptable> listeComptable) {
		this.listeComptable = listeComptable;
	}

	public void setLibelleEtat(String libelleEtat) 
	{
		this.libelleEtat = libelleEtat;
	}
	
	public String getLibelleEtat() {
		return libelleEtat;
	}
	
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}
	
	public String getNomVisiteur() {
		return nomVisiteur;
	}
	
	public void setNomVisiteur(String nom) {
		this.nomVisiteur = nom;
	}
	
	public String getPrenomVisiteur() {
		return prenomVisiteur;
	}
	
	public void setPrenomVisiteur(String prenom) {
		this.prenomVisiteur = prenom;
	}
}
