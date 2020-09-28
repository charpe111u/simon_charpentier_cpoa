package Application;
import SQL.Connexion;
import java.sql.*;
import java.util.ArrayList;

public class Categorie {
	public static void AjouterCategorie(int id_categorie,String titre, String visuel) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="INSERT INTO Categorie VALUES("+id_categorie+",'"+titre+"','"+visuel+"')"; 
			requete.executeUpdate(query);
			System.out.println("Ligne de catégorie ajoutée");
		} catch (SQLException sqle) {
			System.out.println("Pb select :" + sqle.getMessage());
		}
	}
	public static void ModifierCategorie(int id_categorie,String titre, String visuel) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="UPDATE Categorie SET titre='"+titre+"',visuel='"+visuel+"' WHERE id_categorie="+id_categorie;
			requete.executeUpdate(query);
			System.out.println("Ligne de catégorie modifiée");
		} catch(SQLException sqle) {
			System.out.println("Pb select :" + sqle.getMessage());
		}
	}
	public static void SupprimerCategorie(int id_categorie) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="DELETE FROM Categorie WHERE id_categorie="+id_categorie;
			requete.executeUpdate(query);
			System.out.println("Ligne de catégorie supprimée");
		} catch(SQLException sqle) {
			System.out.println("Pb select :" + sqle.getMessage());
		}
	}

	public static void ListeCategorie() {		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="SELECT * FROM Categorie ";
			ArrayList<String> listeCateg = new ArrayList<>();
			ResultSet rs = requete.executeQuery(query);
			while(rs.next()) {
				int id_categorie = rs.getInt(1);
				String titre = rs.getString(2);
				String visuel = rs.getString(3);
				listeCateg.add(id_categorie+"");
				listeCateg.add(titre);
				listeCateg.add(visuel);
				System.out.println("id_categorie:" + id_categorie  + "  titre:"+titre +" visuel:"+visuel);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
}
