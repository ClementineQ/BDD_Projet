package hotel;

<<<<<<< HEAD
import java.sql.Date;
=======
<<<<<<< HEAD
import java.sql.Date;
=======
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
import java.util.Scanner;

import dao.Acces;
import dao.Chambre;
import dao.ChambreDAO;
import dao.Personne;
import dao.PersonneDAO;
<<<<<<< HEAD
=======
import dao.Etat;
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
import dao.Personne;
import dao.PersonneDAO;
import dao.Reservation;
import dao.ReservationDAO;
import dao.Type;

public class Gestion {

	private static boolean switchPersonne(int x, Acces acces, int id) {
		Scanner clavier = new Scanner(System.in);
		PersonneDAO pdao = new PersonneDAO();
		Personne p = pdao.find(id);
		String nom, prenom, mail, mdp, acc;
		String nom, prenom, mail, mdp, acc;
=======
		Personne p = new Personne();
		String nom, prenom, mail, mdp;
		Personne p = new Personne();
		String nom, prenom, mail, mdp;
		Acces acess;

		switch (x) {

		case 1: // Consulter
<<<<<<< HEAD
			p.toString();
			return true;
		case 2: // Ajouter
			if (acces.isGestionnaire()) {
=======
			if (acces.isGestionnaire() || (acces.isClient() && id == p.getId_pers())) {
				System.out.println(pdao.find(p.getId_pers()).toString());
				return true;
			} else {
				System.out.println("Vous n'avez pas les droits pour consulter un profil.");
				return true;
			}

		case 2: // Ajouter
			//if (acces.isGestionnaire()) {
<<<<<<< HEAD
=======

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				System.out.println("Donnez le nom");
				nom = clavier.nextLine();
				System.out.println("Donnez le pr�nom");
				prenom = clavier.nextLine();
				System.out.println("Donnez le mail");
				mail = clavier.nextLine();
				System.out.println("Donnez le mdp");
				mdp = clavier.nextLine();
				System.out.println("Donnez l'acc�s");
<<<<<<< HEAD
				acc = clavier.next();
				acc = clavier.next();
=======
				String acces2 = clavier.next();
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb

				p.setNom(nom);
				p.setPrenom(prenom);
				p.setMail(mail);
				p.setMdp(mdp);
				p.setAcces(acc);
			//	if (pdao.Existe(mail, mdp) != null) {
=======
				p.setAcces(acces2);
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				if (pdao.Existe(mail, mdp) != null) {
					pdao.create(p);
					return pdao.create(p);
			//	} else
				//	System.out.println("Cette personne existe d�j�!");
			//} else
			//	System.out.println("Vous n'avez pas les droits pour ajouter une personne.");
				//break;
		case 3: // Modifier
			if ((acces.isClient() && id == p.getId_pers()) || acces.isGestionnaire()) {
				if (acces.isGestionnaire()) {
					System.out.print("Donner le num�ro de la personne � modifier : ");
					int num = clavier.nextInt();
					p = pdao.find(num);
				}
				System.out.print("Que voulez-vous modifer ? " + "1. Nom " + "2. Prenom " + "3. E-mail " + "4. Mdp "
						+ "0.Sortie ");
				if (acces.isGestionnaire()) {
					System.out.print("5. Acces ");
				}
				int update = clavier.nextInt();
				while (update <= 5 && update > 0) {
				/*
				 * System.out.print(
				 * "Donner le num�ro de la personne � modifier : "); int num =
				 * clavier.nextInt(); p = pdao.find(num);
				 */
				System.out.println("Que voulez-vous modifer ?" + "1. Nom" + "2. Prenom" + "3. E-mail" + "4. Mdp"
						+ "5. Acces" + "0.Sortie");
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				int update = clavier.nextInt();
				while (update <= 5 && update > 0) {
					switch (update) {
					case 1:
						System.out.println("Quel est le nouveau nom ? ");
						nom = clavier.next();
<<<<<<< HEAD
=======
=======

				System.out.println("Que voulez-vous modifer ?" + "1. Nom" + "2. Prenom" + "3. E-mail" + "4. Mdp"
						+ "5. Acces" + "0.Sortie");
				int update = clavier.nextInt();
				while (update > 5 && update < 0) {
					switch (update) {
					case 1:
						System.out.println("Quel est le nouveau nom ? ");
			nom = clavier.nextLine();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
						p.setNom(nom);
						break;
					case 2:
						System.out.println("Quel est le nouveau pr�nom ? ");
						prenom = clavier.next();
						prenom = clavier.next();
=======
<<<<<<< HEAD
						prenom = clavier.next();
=======
						prenom = clavier.nextLine();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
						p.setPrenom(prenom);
						break;
					case 3:
						System.out.println("Quel est le nouvel email ? ");
						mail = clavier.next();
						mail = clavier.next();
=======
<<<<<<< HEAD
						mail = clavier.next();
=======
						mail = clavier.nextLine();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
						p.setMail(mail);
						break;
					case 4:
						System.out.println("Quel est le nouveau mdp ? ");
						mdp = clavier.next();
						p.setMdp(mdp);
						break;
					case 5:
						if (acces.isGestionnaire()) {
							System.out.println("Quel est le nouvel acces ? ");
							String acces3 = clavier.next();
							p.setAcces(acces3);
						} else {
							System.out.println("Vous ne pouvez pas modifier votre acc�s.");
						}
						}
=======
						System.out.println("Quel est le nouvel acces ? ");
<<<<<<< HEAD
						String acces3 = clavier.next();
=======
						String acces3 = clavier.nextLine();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
						p.setAcces(acces3);
						break;
					case 0:
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
						break;
					default:
						break;
					}
					return pdao.update(p);
				}
			} else {
				System.out.println("Vous ne pouvez pas modifier ce profil.");
				return false;
			}
			}
		case 4: // Supprimer
			if (acces.isGestionnaire()){
				System.out.print("Donner le num�ro de la personne � supprimer : "); 
				int num = clavier.nextInt();
				p = pdao.find(num);
				return pdao.delete(p);
			}
			else {
				System.out.println("Vous n'avez pas les droits pour supprimer un profil.");
=======
				return true;
			}
		case 4: // Supprimer
			if (acces.isGestionnaire()) {
				System.out.print("Donner le num�ro de la personne � supprimer : ");
				int num = clavier.nextInt();
				p = pdao.find(num);
			 */
=======
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
			if (acces.isGestionnaire())
				return pdao.delete(p);
			} else {
				System.out.println("Vous n'avez pas les droits pour supprimer un profil.");
				return true;
			}
			}
		default:
			return false;
		}
	}

	private static boolean ConsulterResa(int n_reserv) {
		Scanner clavier = new Scanner(System.in);
		ReservationDAO r = new ReservationDAO();
		Reservation resa = r.find(n_reserv);

		ChambreDAO ch = new ChambreDAO();
		Chambre c = ch.findResa(n_reserv);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb

		PersonneDAO pers = new PersonneDAO();
		Personne p = pers.find(c.getId_pers());

<<<<<<< HEAD
		System.out.println("La r�servation n�" + n_reserv + "est au nom de" + p.getPrenom() + " " + p.getPrenom()
				+ " et a comme modalit�s:");
		System.out.println("Nombre d'adultes: " + resa.getNb_adultes());
		System.out.println("Nombre d'enfants: " + resa.getNb_enfants());
		System.out.println("R�servation � partir du : " + resa.getDate_deb());
		System.out.println("R�servation pour : " + resa.getNb_nuits() + " nuit(s)");
		System.out.println("R�servation pour : " + resa.getPt_dej() + " petit(s) d�jeuner(s)");
		System.out.println("P�riode : " + resa.getSaison());
		clavier.close();
		return true;
	}

	private static boolean AjouterResa() {
		Scanner clavier = new Scanner(System.in);
		Reservation newr = new Reservation();
		System.out.println("Quel est le n� de la r�servation?");
		newr.setId_reservation(clavier.nextInt());
		System.out.println("Combien d'adultes seront pr�sents?");
		newr.setNb_adultes(clavier.nextInt());
		System.out.println("Combien d'enfants seront pr�sents?");
		newr.setNb_enfants(clavier.nextInt());
		System.out.println("Quelle est la date de d�but de s�jour?");
		String tempo = clavier.nextLine();
		newr.setDate_deb(Date.valueOf(tempo));
		System.out.println("Combien de nuits?");
		newr.setNb_nuits(clavier.nextInt());
		System.out.println("Combien de petits d�jeuners par nuit?");
		newr.setPt_dej(clavier.nextInt());
		System.out.println("En quelle p�riode (verte, orange, rouge)?");
		newr.setSaison(clavier.nextLine());

		ReservationDAO resaDAO = new ReservationDAO();
		clavier.close();
		return resaDAO.create(newr);
	}

	private static boolean ModifierResa(int nbresa) {
		Scanner clavier = new Scanner(System.in);
		ReservationDAO rsDAO = new ReservationDAO();
		Reservation rs = rsDAO.find(nbresa);
		int temp = 1;
		while (temp != 0) {
			System.out.println(
					"Que voulez vous modifier? 1: nombre d'adultes, 2: nombre d'enfants, 3: date de d�but de s�jour"
							+ ", 4: nombre de nuits, 5: nombre de petits d�jeuners, 6: la saison, 0: pour sortir");
			temp = clavier.nextInt();
			switch (temp) {
			case 1:
				System.out.println("Nouveau nombre d'adultes:");
				rs.setNb_adultes(clavier.nextInt());
				return true;

			case 2:
				System.out.println("Nouveau nombre d'enfants:");
				rs.setNb_enfants(clavier.nextInt());
				return true;

=======
=======

		PersonneDAO pers = new PersonneDAO();
		Personne p = pers.find(c.getId_pers());

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
		System.out.println("La r�servation n�" + n_reserv + "est au nom de" + p.getPrenom() + " " + p.getPrenom()
				+ " et a comme modalit�s:");
		System.out.println("Nombre d'adultes: " + resa.getNb_adultes());
		System.out.println("Nombre d'enfants: " + resa.getNb_enfants());
		System.out.println("R�servation � partir du : " + resa.getDate_deb());
		System.out.println("R�servation pour : " + resa.getNb_nuits() + " nuit(s)");
		System.out.println("R�servation pour : " + resa.getPt_dej() + " petit(s) d�jeuner(s)");
		System.out.println("P�riode : " + resa.getSaison());
		clavier.close();
		return true;
	}

	private static boolean AjouterResa() {
		Scanner clavier = new Scanner(System.in);
		Reservation newr = new Reservation();
		System.out.println("Quel est le n� de la r�servation?");
		newr.setId_reservation(clavier.nextInt());
		System.out.println("Combien d'adultes seront pr�sents?");
		newr.setNb_adultes(clavier.nextInt());
		System.out.println("Combien d'enfants seront pr�sents?");
		newr.setNb_enfants(clavier.nextInt());
		System.out.println("Quelle est la date de d�but de s�jour?");
		String tempo = clavier.nextLine();
		newr.setDate_deb(Date.valueOf(tempo));
		System.out.println("Combien de nuits?");
		newr.setNb_nuits(clavier.nextInt());
		System.out.println("Combien de petits d�jeuners par nuit?");
		newr.setPt_dej(clavier.nextInt());
		System.out.println("En quelle p�riode (verte, orange, rouge)?");
		newr.setSaison(clavier.nextLine());

		ReservationDAO resaDAO = new ReservationDAO();
		clavier.close();
		return resaDAO.create(newr);
	}

	private static boolean ModifierResa(int nbresa) {
		Scanner clavier = new Scanner(System.in);
		ReservationDAO rsDAO = new ReservationDAO();
		Reservation rs = rsDAO.find(nbresa);
		int temp = 1;
		while (temp != 0) {
			System.out.println(
					"Que voulez vous modifier? 1: nombre d'adultes, 2: nombre d'enfants, 3: date de d�but de s�jour"
							+ ", 4: nombre de nuits, 5: nombre de petits d�jeuners, 6: la saison, 0: pour sortir");
			temp = clavier.nextInt();
			switch (temp) {
			case 1:
				System.out.println("Nouveau nombre d'adultes:");
				rs.setNb_adultes(clavier.nextInt());
				return true;

			case 2:
				System.out.println("Nouveau nombre d'enfants:");
				rs.setNb_enfants(clavier.nextInt());
				return true;

>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			case 3:
				System.out.println("Nouvelle date de d�but:");
				String tempo2 = clavier.nextLine();
				rs.setDate_deb(Date.valueOf(tempo2));
				return true;

			case 4:
				System.out.println("Nouveau nombre de nuits:");
				rs.setNb_nuits(clavier.nextInt());
				return true;

			case 5:
				System.out.println("Nouveau nombre de petits d�jeuners:");
				rs.setPt_dej(clavier.nextInt());
				return true;

			case 6:
				System.out.println("Nouvelle p�riode (verte, orange, rouge) :");
				rs.setSaison(clavier.nextLine());
				return true;

			default:
				return false;
			}
		}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
		clavier.close();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
		return false;
	}

	private static boolean SupprimerResa(int nbsupp) {
		ReservationDAO rDAO = new ReservationDAO();
		Reservation r1 = rDAO.find(nbsupp);
		return rDAO.delete(r1);

	}

	private static boolean switchReservation(int x, Acces acces, int id) {
		Scanner clavier = new Scanner(System.in);

		switch (x) {

		// consulter une r�servation
		case 1:
			System.out.println("Quel est le num�ro de la r�servation � consulter?");
			int k = clavier.nextInt();
			ChambreDAO ch = new ChambreDAO();
			Chambre c = ch.findResa(k);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			if (acces.isClient() && id != c.getId_pers()) {
				System.out.println("Vous n'avez pas les droits pour consulter cette r�servation.");
				return false;
			} else {
				ConsulterResa(k);
				return true;
			}
			// ajouter une nouvealle r�servation
		case 2:
			if (acces.isEmployee()) {
				System.out.println("Vous n'avez pas les droits pour cr�er une r�servation.");
				return false;
			} else {
				AjouterResa();
				return true;
			}
<<<<<<< HEAD
=======
=======
			if (acces.isClient() && id != c.getId_pers())
				System.out.println("Vous n'avez pas les droits pour consulter cette r�servation.");
			else
				ConsulterResa(k);

			// ajouter une nouvealle r�servation
		case 2:
			if (acces.isEmployee())
				System.out.println("Vous n'avez pas les droits pour cr�er une r�servation.");
			else
				AjouterResa();

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			// modifier une r�servation existante
		case 3:
			System.out.println("Quel est le num�ro de la r�servation � modifier?");
			int b = clavier.nextInt();
			ChambreDAO ch1 = new ChambreDAO();
			Chambre c1 = ch1.findResa(b);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			if ((acces.isClient() && id != c1.getId_pers()) || acces.isEmployee()) {
				System.out.println("Vous n'avez pas les droits pour modifier cette r�servation.");
				return false;
			} else {
				ModifierResa(b);
				return true;
			}
<<<<<<< HEAD
=======
=======
			if ((acces.isClient() && id != c1.getId_pers()) || acces.isEmployee())
				System.out.println("Vous n'avez pas les droits pour modifier cette r�servation.");
			else
				ModifierResa(b);

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			// supprimer une r�servation existante
		case 4:
			if (acces.isClient()) {
				System.out.println("Quel est le num�ro de r�servation � supprimer?");
				int k1 = clavier.nextInt();
				ChambreDAO ch2 = new ChambreDAO();
				Chambre c2 = ch2.findResa(k1);

				if ((acces.isClient() && id == c2.getId_pers()) || acces.isGestionnaire()) {
					SupprimerResa(k1);
				}
<<<<<<< HEAD
				return true;
=======
<<<<<<< HEAD
				return true;
=======
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			}

			else {
				System.out.println("Vous n'avez pas les droits pour cr�er une r�servation.");
<<<<<<< HEAD
				return false;
			}
=======
<<<<<<< HEAD
				return false;
			}
=======

			}
			clavier.close();
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
		default:
			return false;
		}
	}

	private static boolean switchChambre(int choix, Acces acces) {
			Scanner clavier = new Scanner(System.in);
			Chambre c = new Chambre();
			ChambreDAO cDAO = new ChambreDAO();
			String type, etat;
			int cap, num;
			switch (choix) {
			case 1: // Consulter
				if (acces.isGestionnaire()) {
					System.out.print("Donner le num�ro de la chambre � afficher : ");
					num = clavier.nextInt();
					System.out.println(cDAO.find(num).toString());
=======
		case 1: // consulter
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			System.out.print("Donner le num�ro de la chambre � afficher : ");
			num = clavier.nextInt();
			if (acces.isClient()) {
				System.out.println("Vous n'avez pas les droits pour consulter les chambres.");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				return false;
			} else {
				System.out.println(cDAO.find(num).toString());
			return true;
				} else {
					System.out.println("Vous n'avez pas les droits pour consulter les chambres");
					return false;
				}
			case 2: // Ajouter
				if (acces.isGestionnaire()) {
					System.out.print("Donner le type de la nouvelle chambre : ");
			}
			return true;

		case 2:// Ajouter
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			if (acces.isGestionnaire()) {
				System.out.print("Donner le type de la nouvelle chambre : ");
					type = clavier.next();
			System.out.print("Donner le capacit� de la chambre : ");
				cap = clavier.nextInt();
				c.setType(type);
				c.setCapacite(cap);
				c.setEtat("Disponible");
					System.out.println(c.toString());
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				System.out.println(c.toString());
			return cDAO.create(c);
				} else {
					System.out.println("Vous n'avez pas les droits pour ajouter une chambre");
					return false;
				}
			case 3: // Modifier
				System.out.println("Quelle chambre voulez-vous modifier ?");
				num = clavier.nextInt();
				c.setId_chambre(num);
				System.out.println("Quel est le nouvel �tat de la chambre ? " + "Sale, Disponible ou Reservee ?");
			} else {
				System.out.println("Vous n'avez pas les droits pour ajouter une chambre");
				return true;
			}
		case 3:// modifier
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			if (acces.isGestionnaire()) {
				System.out.println("Quelle chambre voulez-vous modifier ?");
				num = clavier.nextInt();
				c.setId_chambre(num);
				System.out.println("Quel est le nouvel �tat de la chambre ? " + "Sale, Disponible ou Reservee ?");
				etat = clavier.next();
				c.setEtat(etat);
				return cDAO.update(c);
			case 4: // Supprimer
				if (acces.isGestionnaire()) {
					System.out.print("Donner le num�ro de la chambre � supprimer : ");
					num = clavier.nextInt();
					c.setId_chambre(num);
					System.out.println("ok");
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
			}
		case 4: // Supprimer
			if (acces.isGestionnaire()) {
				System.out.print("Donner le num�ro de la chambre � supprimer : ");
				num = clavier.nextInt();
				c.setId_chambre(num);
				System.out.println("ok");
					return cDAO.delete(c);
				} else {
					System.out.println("Vous n'avez pas les droits pour supprimer une chambre.");
					return false;
				}
				return false;
<<<<<<< HEAD
			}
		} else {
			System.out.println("Vous n'avez pas les droits pour consulter les chambres.");
			return false;
		}
		case 4:// Supprimer
			if (acces.isGestionnaire()) {
				System.out.print("Donner le num�ro de la chambre � supprimer : ");
				num = clavier.nextInt();
				c.setId_chambre(num);
				System.out.println("ok");
				return cDAO.delete(c);
			} else {
				System.out.println("Vous n'avez pas les droits pour supprimer une chambre.");
				return true;
			}
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
		default:
			return false;
		}

	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		String mail, mdp;
		PersonneDAO p = new PersonneDAO();

		do {
			System.out.print("Entrez votre mail :");
			mail = clavier.next();
			System.out.print("Entrez votre mdp :");
			mdp = clavier.next();
		} while (p.Existe(mail, mdp).getId_pers() == 0);
		Personne pers = p.Existe(mail, mdp);
=======
		// Personne pers = p.Existe(mail, mdp);
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb

		int choixO = 1, choixA;
		while (choixO < 4 || choixO > 0) {
			System.out.println("Sur quel object voulez-vous travailler? " + "Tapez 1 pour personne"
					+ "Tapez 2 pour chambre" + "Tapez 3 pour r�servation" + "Tapez 0 pour sortir");
			choixO = clavier.nextInt();
			choixA = 1;
			do {
				System.out.println("Que souhaitez-vous faire? " + "Tapez 1 pour consulter" + "Tapez 2 pour ajouter "
						+ "Tapez 3 pour modifier" + "Tapez 4 pour supprimer" + "Tapez 0 pour sortir");
				choixA = clavier.nextInt();
			} while (choixA > 5 && choixA < 0);

			switch (choixO) {
			case 1:
				switchPersonne(choixA, pers.getAcces(), pers.getId_pers());
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				switchPersonne(choixA, pers.getAcces(), pers.getId_pers());
				break;
			case 2:
				switchChambre(choixA, pers.getAcces());
				break;
			case 3:
				switchReservation(choixA, pers.getAcces(), pers.getId_pers());
				break;
=======
=======
				switchPersonne(choixA);
				break;
			case 2:
				switchChambre(choixA);
				break;
			case 3:
				// switchReservation(choixA, pers.getAcces(),
				// pers.getId_pers());
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
				break;
			}

		}

		clavier.close();

	}

}
