package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import SQL.Connexion;

public class Client {
	public static void AjouterClient(int id_client,String nom, String prenom, String identifiant,String mot_de_passe,String adr_numero,String adr_voie,String adr_code_postal,String adr_ville,String adr_pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="INSERT INTO Client VALUES("+id_client+",'"+nom+"','"+prenom+"','"+identifiant+"','"+mot_de_passe+"','"+adr_numero+"','"+adr_voie+"','"+adr_code_postal+"','"+adr_ville+"','"+adr_pays+"')"; 
			requete.executeUpdate(query);
			System.out.println("Client ajouté.");
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void ModifierClient(int id_client,String nom, String prenom, String identifiant,String mot_de_passe,String adr_numero,String adr_voie,String adr_code_postal,String adr_ville,String adr_pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="UPDATE Client SET nom='"+nom+"',prenom='"+prenom+"',identifiant='"+identifiant+"',mot_de_passe='"+mot_de_passe+"',adr_numero='"+adr_numero+"',adr_voie='"+adr_voie+"',adr_code_postal='"+adr_code_postal+"',adr_ville='"+adr_ville+"',adr_pays='"+adr_pays+"' WHERE id_client="+id_client;
			requete.executeUpdate(query);
			System.out.println("Client modifié.");
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void SupprimerClient(int id_client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="DELETE FROM Client WHERE id_client="+id_client;
			requete.executeUpdate(query);
			System.out.println("Client supprimé.");
			
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	public static void ListeClient() {		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			Statement requete = laConnexion.createStatement();
			String query="SELECT * FROM Client ";
			ArrayList<String> listeCli = new ArrayList<>();
			ResultSet resultset = requete.executeQuery(query);
			while(resultset.next()) {
				int id_client = resultset.getInt(1);
				String nom = resultset.getString(2);
				String prenom = resultset.getString(3);
				String identifiant = resultset.getString(4);
				String mot_de_passe = resultset.getString(5);
				String adr_numero = resultset.getString(6);
				String adr_voie = resultset.getString(7);
				String adr_code_postal = resultset.getString(8);
				String adr_ville = resultset.getString(9);
				String adr_pays = resultset.getString(10);
				listeCli.add(id_client+"");
				listeCli.add(nom);
				listeCli.add(prenom);
				listeCli.add(identifiant);
				listeCli.add(mot_de_passe);
				listeCli.add(adr_numero);
				listeCli.add(adr_voie);
				listeCli.add(adr_code_postal);
				listeCli.add(adr_ville);
				listeCli.add(adr_pays);
				System.out.println("id_client:" + id_client  + "  nom:"+nom +" prenom:"+prenom+" identifiant:"+identifiant+" mot_de_passe:"+mot_de_passe
						+" adr_numero:"+adr_numero+" adr_voie:"+adr_voie+" adr_code_postal:"+adr_code_postal+" adr_ville:"+adr_ville+" adr_pays:"+adr_pays);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
}