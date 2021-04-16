package com.sio.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collections;

import com.sio.dao.SaisieFraisDaoImpl;
import com.sio.dao.VisiteurDaoImpl;

public class Admin {

	String nom;
	String prenom;
	Date date;
	String mdp;
	String login;
	String profile;
	int id;
	
	public Admin(int id) throws SQLException
	{
		this.id = id;
		this.nom = VisiteurDaoImpl.getNomVisiteur(id);
		this.prenom = VisiteurDaoImpl.getPrenomVisiteur(id);
		//this.login = 
	
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}
