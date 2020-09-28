package Application;
import java.util.Scanner;
import Metier.CMCategorie;
import Metier.CMProduit;
import dao.DAOFactory;
import dao.DAOFactory.Persistance;

public class Main {
	public static void main(String[] args) {
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez choisir une table :");
		System.out.println("1:Catégorie 2:Produit 3:Client 4:Commande 5:Ligne de commande");
		int table = scanner.nextInt();
//Table Catégorie
		if (table==1) {
			System.out.println("Vous avez choisi : Catégorie");
			System.out.println("Que souhaitez-vous faire?");
			System.out.println("1:Ajouter 2:Modifier 3:Supprimer 4:Afficher");
			int p=scanner.nextInt();
			if(p==1) {
				System.out.println("Ajouter");
				System.out.println ("titre = ");
				String titre=scanner.next();
				System.out.println ("visuel = ");
				String visuel=scanner.next();
				try {
					daos.getCategorieDAO().create(new CMCategorie( titre, visuel));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (p==2) {
				System.out.println("Modifier");
				System.out.println("id_categorie = ");
				int id=scanner.nextInt();
				System.out.println ("titre = ");
				String titre=scanner.next();
				System.out.println ("visuel = ");
				String visuel=scanner.next();			
				try {
					daos.getCategorieDAO().update(new CMCategorie(id,titre,visuel));
				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
			else if (p==3) {
				System.out.println("Supprimer");
				System.out.println("id_categorie = ");
				int id=scanner.nextInt();			
				try {
					daos.getCategorieDAO().delete(new CMCategorie(id));
				} catch (Exception e) {				
					e.printStackTrace();
				}	
			}
			else if(p==4) {
				Categorie.ListeCategorie();
			}
			else {
				System.out.println("Invalide");
			}
		}
//Table Produit
		else if(table==2) {
			System.out.println("Produit");
			System.out.println("Que souhaitez-vous faire?");
			System.out.println("1.Ajouter 2:Modifier 3:Supprimer 4:Afficher");
			int p=scanner.nextInt();
			if(p==1) {
				System.out.println("Ajouter");
				System.out.println ("nom = ");
				String nom=scanner.next();
				System.out.println ("description = ");
				String description=scanner.next();
				System.out.println ("tarif = ");
				float tarif=scanner.nextFloat();
				System.out.println ("visuel = ");
				String visuel=scanner.next();
				System.out.println("id_categorie = ");
				int idc=scanner.nextInt();
				try {
					daos.getProduitDAO().create(new CMProduit(nom, description, tarif, visuel,idc));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(p==2) {
				System.out.println("Modifier");
				System.out.println("id_produit = ");
				int id=scanner.nextInt();
				System.out.println ("nom = ");
				String nom=scanner.next();
				System.out.println ("description = ");
				String description=scanner.next();
				System.out.println ("tarif = ");
				float tarif=scanner.nextFloat();
				System.out.println ("visuel = ");
				String visuel=scanner.next();
				System.out.println("id_categorie = ");
				int idc=scanner.nextInt();
				Produit.ModifierProduit(id, nom, description, tarif, visuel, idc);
			}
			else if(p==3) {
				System.out.println("Supprimer");
				System.out.println("id_produit = ");
				int id=scanner.nextInt();
				Produit.SupprimerProduit(id);
			}
			else if(p==4) {
				Produit.ListeProduit();
			}
			else 
			{
				System.out.println("Invalide");
			}
		}
//Table Client
		else if(table==3) {
			System.out.println("Client");
			System.out.println("Que souhaitez-vous faire?");
			System.out.println("1.Ajouter 2:Modifier 3:Supprimer 4:Afficher");
			int p=scanner.nextInt();
			if(p==1) {
				System.out.println("Ajouter");
				System.out.println("id_client = ");
				int id=scanner.nextInt();
				System.out.println ("nom = ");
				String nom=scanner.next();
				System.out.println ("prenom = ");
				String prenom=scanner.next();
				System.out.println ("identifiant = ");
				String iden=scanner.next();
				System.out.println ("mot_de_passe = ");
				String mode=scanner.next();
				System.out.println("adr_numero = ");
				String adr=scanner.next();
				System.out.println ("adr_voie = ");
				String adr_voie=scanner.next();
				System.out.println ("adr_code_postal = ");
				String adr_code_postal=scanner.next();
				System.out.println ("adr_ville = ");
				String adr_ville=scanner.next();
				System.out.println ("adr_pays = ");
				String adr_pays=scanner.next();
				Client.AjouterClient(id, nom, prenom, iden, mode, adr, adr_voie, adr_code_postal, adr_ville, adr_pays);
					}
			else if(p==2) {
				System.out.println("Modifier");
				System.out.println("id_client = ");
				int id=scanner.nextInt();
				System.out.println ("nom = ");
				String nom=scanner.next();
				System.out.println ("prenom = ");
				String prenom=scanner.next();
				System.out.println ("identifiant = ");
				String iden=scanner.next();
				System.out.println ("mot_de_passe = ");
				String mode=scanner.next();
				System.out.println("adr_numero = ");
				String adr=scanner.next();
				System.out.println ("adr_voie = ");
				String adr_voie=scanner.next();
				System.out.println ("adr_code_postal = ");
				String adr_code_postal=scanner.next();
				System.out.println ("adr_ville = ");
				String adr_ville=scanner.next();
				System.out.println ("adr_pays = ");
				String adr_pays=scanner.next();
				Client.ModifierClient(id, nom, prenom, iden, mode, adr, adr_voie, adr_code_postal, adr_ville, adr_pays);
					}
			else if (p==3) {
				System.out.println("Supprimer");
				System.out.println("id_client = ");
				int id=scanner.nextInt();
				Client.SupprimerClient(id);
			}
			else if(p==4)
			{
				Client.ListeClient();
			}
			else {
				System.out.println("Invalide");
			}
		}
//Table Commande	
		else if(table==4) {
		}
//Table Ligne de Commande
		else if (table==5) {
		}
		else {
			System.out.println("Invalide");
		}
	}
}