package com.sio.model;

import java.sql.Date;

public class LigneFraisHorsForfait {

	private int id;
	private String date; 
	private double montant;
	private String libelle; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMontant() 
	{
		System.out.println(estRefuse()+"-"+libelle);
		if(!estRefuse())
			return montant;
		else
			return 0;
		
	}
	public void setMontant(double montant) 
	{
		if(montant != 0)
		{
			this.montant = montant;
		}
		else
		{
			refuser();
		}
	}
	public String getLibelle() 
	{
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	public LigneFraisHorsForfait( String date2, double montant, String libelle){
		//this.id = id;
		this.date = date2;
		this.montant = montant;
		this.libelle = libelle;
	}
	
	public LigneFraisHorsForfait(int id, String date, double montant, String libelle) {
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.libelle = libelle;
	}
	public void refuser() //throws SQLException
	{
		//Passerelle.refusserHorsForfait(id);
		if(!estRefuse())
			libelle = "REFUSE:"+libelle;
	}
	
	public void accepter() 
	{
		if(estRefuse())
			libelle = libelle.substring(7);
		System.out.println(libelle);
		
	}
	
	@Override
	public String toString() {
		/*return "LigneFraisHorsForfait [id=" + id + ", date=" + date
				+ ", montant=" + montant + ", libelle=" + libelle + "]";
		*/
		return libelle;
	}
	
	/**
	 * Retourne vrai si le libelle indique que la ligne est refusée
	 * (commence par "REFUSE:"), sinon false.
	 * 
	 * @return vrai si le libelle indique que la ligne est refusée
	 * (commence par "REFUSE:"), sinon false.
	 */
	public boolean estRefuse()
	{
		if(libelle.length()>=7)
			return libelle.substring(0,7).equals("REFUSE:");
		return false;
	}


	
}

