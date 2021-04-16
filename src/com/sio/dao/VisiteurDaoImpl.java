package com.sio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sio.utils.JDBCUtils;

public class VisiteurDaoImpl {

	
	public  VisiteurDaoImpl() {}
	
	
	
	public static void addNewVisiteur(String nom, String prenom,  String profile, String login, String mdp, int cp, String ville, String adresse, String dateNaissance, String dateEmbauche) throws SQLException 
	{
		
					try (Connection connection = JDBCUtils.getConnection();
					PreparedStatement ps = connection.prepareStatement("INSERT INTO utilisateur"
							+"( nom, prenom, profile, adresse, cp, ville, login, mdp, date_embauche, datenaissance) VALUES"
							+" ( ?, ?, ?, ?,?, ?, ? ,?,?,?)")){
						ps.setString(1, nom);
						ps.setString(2, prenom);
						ps.setString(3,profile);
						ps.setString(4, adresse);
						ps.setInt(5,cp);
						ps.setString(6, ville);
						ps.setString(7,login);
						ps.setString(8, mdp);
					ps.setString(9, dateEmbauche);
						ps.setString(10, dateEmbauche );
						
				
					ps.execute();
					ps.close();
					System.out.println(ps);
					}
					catch (SQLException exception) {
						JDBCUtils.printSQLException(exception);
					}
		
					
				
		}
			
	/**
	 * Retourne le nom du visiteur dont l'id est passé en paramètre.
	 * 
	 * @param id
	 * 		L'id du visiteur.
	 * @return
	 * 		Nom du Visiteur
	 * @throws SQLException
	 */
	
	public static  String getNomVisiteur(int id) throws SQLException
	{
		Connection c = JDBCUtils.getConnection();
		String req = "SELECT nom FROM utilisateur " +
				"WHERE id = '"+id+"'";
		ResultSet res = c.createStatement().executeQuery(req);
		String nom = null;
		if(res.next())
			nom = res.getString(1);
		res.close();
		return nom;
	}
	
	
	/**
	 * Retourne le prenom du visiteur dont l'id est passé en paramètre.
	 * 
	 * @param id
	 * 		L'id du visiteur.
	 * @return
	 * 		Prenom du Visiteur
	 * @throws SQLException
	 */

	public static  String getPrenomVisiteur(int id) throws SQLException
	{
		Connection c =JDBCUtils.getConnection();
		String req = "SELECT prenom FROM utilisateur " +
				"WHERE id = '"+id+"'";
		ResultSet res = c.createStatement().executeQuery(req);
		
		if(res.next())
			return res.getString(1);
		return null;
	}

	
	
}
