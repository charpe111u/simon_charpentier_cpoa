package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SQL.Connexion;

public class Produit {
	public static void AjouterProduit(int id_produit,String nom, String description, float tarif, String visuel, int id_categorie) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="INSERT INTO Produit VALUES("+id_produit+",'"+nom+"','"+description+"',"+tarif+",'"+visuel+"',"+id_categorie+")"; 
			requete.executeUpdate(query);
			System.out.println("Produit ajouté");
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void ModifierProduit(int id_produit,String nom, String description, float tarif, String visuel, int id_categorie) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="UPDATE Produit SET nom='"+nom+"',"
					+ "description='"+description+"' ,"
					+ "tarif="+tarif+" ,"
					+ "visuel='"+visuel+"' ,"
					+ "id_categorie="+id_categorie+" "
					+ "WHERE id_produit="+id_produit;
			requete.executeUpdate(query);
			System.out.println("Produit modifié.");
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void SupprimerProduit(int id_produit) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="DELETE FROM Produit WHERE id_produit="+id_produit;
			requete.executeUpdate(query);
			System.out.println("Produit supprimé.");
			
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void ListeProduit() {		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="SELECT * FROM Produit ";
			ArrayList<String> listeProd = new ArrayList<>();
			ResultSet resultset = requete.executeQuery(query);
			while(resultset.next()) {
				int id_produit = resultset.getInt(1);
				String nom = resultset.getString(2);
				String description = resultset.getString(3);
				float  tarif = resultset.getFloat(4);
				String visuel = resultset.getString(5);
				int  id_categorie = resultset.getInt(6);
				listeProd.add(id_produit+"");
				listeProd.add(nom);
				listeProd.add(description);
				listeProd.add(tarif+"");
				listeProd.add(visuel);
				listeProd.add(id_categorie+"'");
				System.out.println("id_produit:" + id_produit  + "  nom:"+nom +" description:"+description+"tarif : " + tarif  + "  visuel:"+visuel +" id_categorie:"+id_categorie);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
}
