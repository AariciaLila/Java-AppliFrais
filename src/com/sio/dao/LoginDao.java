package com.sio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.sio.model.LoginBean;
import com.sio.utils.JDBCUtils;

public class LoginDao {

	public String profil = "";
	public String prenom ="";
	public String nom ="";
	public String login = "";
	public String mdp = "";
	public int id = 0;
	public int validate(LoginBean loginBean) throws ClassNotFoundException {
		int status = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				Statement statement = connection.createStatement();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from utilisateur where login = ? and mdp = ? ")) {
			preparedStatement.setString(1, loginBean.getUsername());
			
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			ResultSetMetaData resultat = rs.getMetaData();
			int nbCol = resultat.getColumnCount();
			System.out.println("resultats" + resultat);
			//System.out.println("resultats" + resultat.get);
			//String title = resultat.
			while (rs.next()){
				 profil = rs.getString("profile");
				 mdp = rs.getString("mdp");
				 login = rs.getString("login");
				 id = rs.getInt("id");
				 prenom = rs.getString("prenom");
				 nom = rs.getString("nom");
				
			}
			String thisLogin = loginBean.getUsername();
			String thisPassword = loginBean.getPassword();
		
		   if(thisLogin.equals(login)  && thisPassword.equals(mdp)){
			
			   
			   loginBean.setNom(nom);
			   loginBean.setPrenom(prenom);
			   loginBean.setId(id);
			   loginBean.setProfil(profil);
			   loginBean.setUsername(login);
			   loginBean.setPassword(mdp); 
			   if(profil.equals("2")){
				   status = 2;
			   }
			   else if (profil.equals("1")){
				   status = 1;
			   }
			   else if(profil.equals("3")){
				   status = 3;
			   }
		   }
		   else {
			 status = 0;  
		   }
			
			//status = true;
		} catch (SQLException e) {
			// process sql exception

			System.out.println("erreur de connexion");
			JDBCUtils.printSQLException(e);
		}
		System.out.println("le numéro du statut = " + status);
		return status;
	}

}
