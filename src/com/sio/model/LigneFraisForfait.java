package com.sio.model;

import java.sql.Date;

public class LigneFraisForfait {

	private String idFraisForfait, libelle;
	private int quantite;
	private double montant;
	private String mois ;
	
	

	public LigneFraisForfait(String unIdFraisForfait, String unLibelle, int uneQuantite, double unMontant, String unMois) {
		idFraisForfait = unIdFraisForfait;
		libelle = unLibelle;
		quantite = uneQuantite;
		montant = unMontant;
		mois = unMois;
		
	}
	
	public double getTotal(int quantité, double montant){
		double total = quantité * montant;
		return total;
	}
	
	public String getMois() {
		return mois;
	}



	public void setMois(String mois) {
		this.mois = mois;
	}



	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public String toString() {
		return "LigneFraisForfait [idFraisForfait=" + idFraisForfait
				+ ", libelle=" + libelle + ", quantite=" + quantite
				+ ", montant=" + montant + "]";
	}
	
}
