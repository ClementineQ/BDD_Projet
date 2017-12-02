package hotel;

import java.util.Scanner;

import dao.Chambre;
import dao.ChambreDAO;
import dao.Etat;
import dao.Reservation;
import dao.ReservationDAO;
import dao.Type;

public class Gestion {
	
	private static boolean  SwitchPersonne(int x){
		Scanner clavier = new Scanner(System.in);
		PersonneDAO pdao = new PersonneDAO();
		Personne p = new Personne();
		String nom, prenom, mail, mdp;
		Acces acess;
		
		switch(x){	
		
	case 1 : //Consulter
		System.out.println(pdao.find(p.getId_personne()));
		return true;
		
	case 2 : //Ajouter
		System.out.println("Donnez le nom");
		String nom = clavier.nextLine();
		System.out.println("Donnez le prénom");
		String prenom = clavier.nextLine();
		System.out.println("Donnez le mail");
		String mail = clavier.nextLine();
		System.out.println("Donnez le mdp");
		String mdp = clavier.nextLine();
		// pour ACCES, PAS SUR
		System.out.println("Donnez l'accès");
		String acces = clavier.nextObject();
		
		Personne p = new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setMail(mail);
		p.setMdp(mdp);
		p.setAcces(acces);
		PersonneDAO pdao = new PersonneDAO();
		pdao.create(p);		
		return pdao.create(p);	

	case 3 : // Modifier
		System.out.println("Que voulez-vous modifer ?"
				+ "1. Nom"
				+ "2. Prenom"
				+ "3. E-mail"
				+ "4. Mdp"
				+ "5. Acces");
		update = clavier.nextInt();
		switch(update){
		case 1 :
			System.out.println("Quel est le nouveau nom ? ");
			nom = clavier.nextLine();
			p.setNom(nom);
			break;
		case 2 :
			System.out.println("Quel est le nouveau prénom ? ");
			prenom = clavier.Line();
			p.setPrenom(prenom);
			break;
		case 3 :
			System.out.println("Quel est le nouvel email ? ");
			mail = clavier.Line();
			p.setMail(mail);
			break;
		case 4 :
			System.out.println("Quel est le nouveau mdp ? ");
			mdp = clavier.Line();
			p.setMdp(mdp);
			break;
		case 5 : // ACCES ????????
			break;
		default :
			break;
		}
		return pdao.update(p);

	case 4 : // Supprimer
		return pdao.delete(p);
	default :
		return false;
	}
	
	
	
	private static boolean switchChambre(int choix){
		Scanner clavier = new Scanner(System.in);
		Chambre c = new Chambre();
		ChambreDAO cDAO = new ChambreDAO();
		String type, etat;
		int cap, modif;
		double tarif;
		switch(choix){
		case 1 :
			System.out.println(cDAO.find(c.getId_chambre()));
			return true;
		case 2 :
			System.out.print("Donner le type de la chambre : ");
			type = clavier.next();
			System.out.print("Donner le capacité de la chambre : ");
			cap = clavier.nextInt();
			c.setType(type);
			c.setCapacite(cap);
			c.setEtat("Disponible");
			return cDAO.create(c);
		case 3 :
			System.out.println("Que voulez-vous modifer ?"
					+ "1. Etat"
					+ "2. Tarif");
			modif = clavier.nextInt();
			switch(modif){
			case 1 :
				System.out.println("Quel est le nouvel état de la chambre ? "
						+"Sale, Disponible ou Reservee ?");
				etat = clavier.next();
				c.setEtat(etat);
				break;
			case 2 :
				ReservationDAO rDAO = new ReservationDAO();
				tarif = c.prix(rDAO.find(c.getId_reservation()));
				c.setTarif(tarif);
			default :
				break;
			}
			return cDAO.update(c);
		case 4 :
			return cDAO.delete(c);
		default :
			return false;
		}
	}
	
	

	public static void main(String[] args) {
		
		// Etape 1 : une personne rentre son mail + mdp
		// Vérifier s'il est dans la base de données > Méthode Existe
		
		// Méthodes ajouter, supprimer, modifier, consulter
		// Marie : Personne
		// Clémentine : Réservation
		// Emeline : Chambre
		
		Scanner clavier = new Scanner(System.in);
		clavier.close();
	}

}
