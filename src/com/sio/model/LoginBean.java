package com.sio.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String profil;
	private static String nom;
	private static String prenom;
	private static int id;

	
	
	public LoginBean(String username, String password, String profil, String nom, String prenom) {
		super();
		this.username = username;
		this.password = password;
		this.profil = profil;
		this.nom = nom;
		this.prenom = prenom;
	}

	public static String getNom() {
		return nom;
	}

	public  void setNom(String nom) {
		this.nom = nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
