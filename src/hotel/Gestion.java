package hotel;

import java.util.Scanner;

import dao.Chambre;
import dao.ChambreDAO;
import dao.Etat;
import dao.Reservation;
import dao.ReservationDAO;
import dao.Type;

public class Gestion {
	
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
		// Vérifier s'il est dans la base de données
		
		// Méthodes ajouter, supprimer, modifier, consulter
		// Marie : Personne
		// Clémentine : Réservation
		// Emeline : Chambre
		
		Scanner clavier = new Scanner(System.in);
		clavier.close();
	}

}
