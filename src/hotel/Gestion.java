package hotel;

import java.sql.Date;
import java.util.Scanner;

import dao.Acces;
import dao.Chambre;
import dao.ChambreDAO;
import dao.Personne;
import dao.PersonneDAO;
import dao.Reservation;
import dao.ReservationDAO;

public class Gestion {

	private static boolean switchPersonne(int x, Acces acces, int id) {
		Scanner clavier = new Scanner(System.in);
		PersonneDAO pdao = new PersonneDAO();
		Personne p = pdao.find(id);
		String nom, prenom, mail, mdp, acc;

		switch (x) {

		case 1: // Consulter
			p.toString();
			return true;
		case 2: // Ajouter
			//if (acces.isGestionnaire()) {
				System.out.println("Donnez le nom");
				nom = clavier.nextLine();
				System.out.println("Donnez le prénom");
				prenom = clavier.nextLine();
				System.out.println("Donnez le mail");
				mail = clavier.nextLine();
				System.out.println("Donnez le mdp");
				mdp = clavier.nextLine();
				System.out.println("Donnez l'accès");
				acc = clavier.next();

				p.setNom(nom);
				p.setPrenom(prenom);
				p.setMail(mail);
				p.setMdp(mdp);
				p.setAcces(acc);
			//	if (pdao.Existe(mail, mdp) != null) {
					pdao.create(p);
					return pdao.create(p);
			//	} else
				//	System.out.println("Cette personne existe déjà!");
			//} else
			//	System.out.println("Vous n'avez pas les droits pour ajouter une personne.");
				//break;
		case 3: // Modifier
			if ((acces.isClient() && id == p.getId_pers()) || acces.isGestionnaire()) {
				if (acces.isGestionnaire()) {
					System.out.print("Donner le numéro de la personne à modifier : ");
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
					switch (update) {
					case 1:
						System.out.println("Quel est le nouveau nom ? ");
						nom = clavier.next();
						p.setNom(nom);
						break;
					case 2:
						System.out.println("Quel est le nouveau prénom ? ");
						prenom = clavier.next();
						p.setPrenom(prenom);
						break;
					case 3:
						System.out.println("Quel est le nouvel email ? ");
						mail = clavier.next();
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
							System.out.println("Vous ne pouvez pas modifier votre accès.");
						}
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
		case 4: // Supprimer
			if (acces.isGestionnaire()) {
				System.out.print("Donner le numéro de la personne à supprimer : ");
				int num = clavier.nextInt();
				p = pdao.find(num);
				return pdao.delete(p);
			} else {
				System.out.println("Vous n'avez pas les droits pour supprimer un profil.");
				return true;
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

		PersonneDAO pers = new PersonneDAO();
		Personne p = pers.find(c.getId_pers());

		System.out.println("La réservation n°" + n_reserv + "est au nom de" + p.getPrenom() + " " + p.getPrenom()
				+ " et a comme modalités:");
		System.out.println("Nombre d'adultes: " + resa.getNb_adultes());
		System.out.println("Nombre d'enfants: " + resa.getNb_enfants());
		System.out.println("Réservation à partir du : " + resa.getDate_deb());
		System.out.println("Réservation pour : " + resa.getNb_nuits() + " nuit(s)");
		System.out.println("Réservation pour : " + resa.getPt_dej() + " petit(s) déjeuner(s)");
		System.out.println("Période : " + resa.getSaison());
		clavier.close();
		return true;
	}

	private static boolean AjouterResa() {
		Scanner clavier = new Scanner(System.in);
		Reservation newr = new Reservation();
		System.out.println("Quel est le n° de la réservation?");
		newr.setId_reservation(clavier.nextInt());
		System.out.println("Combien d'adultes seront présents?");
		newr.setNb_adultes(clavier.nextInt());
		System.out.println("Combien d'enfants seront présents?");
		newr.setNb_enfants(clavier.nextInt());
		System.out.println("Quelle est la date de début de séjour?");
		String tempo = clavier.nextLine();
		newr.setDate_deb(Date.valueOf(tempo));
		System.out.println("Combien de nuits?");
		newr.setNb_nuits(clavier.nextInt());
		System.out.println("Combien de petits déjeuners par nuit?");
		newr.setPt_dej(clavier.nextInt());
		System.out.println("En quelle période (verte, orange, rouge)?");
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
					"Que voulez vous modifier? 1: nombre d'adultes, 2: nombre d'enfants, 3: date de début de séjour"
							+ ", 4: nombre de nuits, 5: nombre de petits déjeuners, 6: la saison, 0: pour sortir");
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

			case 3:
				System.out.println("Nouvelle date de début:");
				String tempo2 = clavier.nextLine();
				rs.setDate_deb(Date.valueOf(tempo2));
				return true;

			case 4:
				System.out.println("Nouveau nombre de nuits:");
				rs.setNb_nuits(clavier.nextInt());
				return true;

			case 5:
				System.out.println("Nouveau nombre de petits déjeuners:");
				rs.setPt_dej(clavier.nextInt());
				return true;

			case 6:
				System.out.println("Nouvelle période (verte, orange, rouge) :");
				rs.setSaison(clavier.nextLine());
				return true;

			default:
				return false;
			}
		}
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

		// consulter une réservation
		case 1:
			System.out.println("Quel est le numéro de la réservation à consulter?");
			int k = clavier.nextInt();
			ChambreDAO ch = new ChambreDAO();
			Chambre c = ch.findResa(k);

			if (acces.isClient() && id != c.getId_pers()) {
				System.out.println("Vous n'avez pas les droits pour consulter cette réservation.");
				return false;
			} else {
				ConsulterResa(k);
				return true;
			}
			// ajouter une nouvealle réservation
		case 2:
			if (acces.isEmployee()) {
				System.out.println("Vous n'avez pas les droits pour créer une réservation.");
				return false;
			} else {
				AjouterResa();
				return true;
			}
			// modifier une réservation existante
		case 3:
			System.out.println("Quel est le numéro de la réservation à modifier?");
			int b = clavier.nextInt();
			ChambreDAO ch1 = new ChambreDAO();
			Chambre c1 = ch1.findResa(b);

			if ((acces.isClient() && id != c1.getId_pers()) || acces.isEmployee()) {
				System.out.println("Vous n'avez pas les droits pour modifier cette réservation.");
				return false;
			} else {
				ModifierResa(b);
				return true;
			}
			// supprimer une réservation existante
		case 4:
			if (acces.isClient()) {
				System.out.println("Quel est le numéro de réservation à supprimer?");
				int k1 = clavier.nextInt();
				ChambreDAO ch2 = new ChambreDAO();
				Chambre c2 = ch2.findResa(k1);

				if ((acces.isClient() && id == c2.getId_pers()) || acces.isGestionnaire()) {
					SupprimerResa(k1);
				}
				return true;
			}

			else {
				System.out.println("Vous n'avez pas les droits pour créer une réservation.");
				return false;
			}
		default:
			return false;
		}
	}

	private static boolean switchChambre(int choix, Acces acces) {
		if (acces.isGestionnaire() || acces.isEmployee()) {
			Scanner clavier = new Scanner(System.in);
			Chambre c = new Chambre();
			ChambreDAO cDAO = new ChambreDAO();
			String type, etat;
			int cap, num;
			switch (choix) {
			case 1: // Consulter
				if (acces.isGestionnaire()) {
					System.out.print("Donner le numéro de la chambre à afficher : ");
					num = clavier.nextInt();
					System.out.println(cDAO.find(num).toString());
					return true;
				} else {
					System.out.println("Vous n'avez pas les droits pour consulter les chambres");
					return false;
				}
			case 2: // Ajouter
				if (acces.isGestionnaire()) {
					System.out.print("Donner le type de la nouvelle chambre : ");
					type = clavier.next();
					System.out.print("Donner le capacité de la nouvelle chambre : ");
					cap = clavier.nextInt();
					c.setType(type);
					c.setCapacite(cap);
					c.setEtat("Disponible");
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
				System.out.println("Quel est le nouvel état de la chambre ? " + "Sale, Disponible ou Reservee ?");
				etat = clavier.next();
				c.setEtat(etat);
				return cDAO.update(c);
			case 4: // Supprimer
				if (acces.isGestionnaire()) {
					System.out.print("Donner le numéro de la chambre à supprimer : ");
					num = clavier.nextInt();
					c.setId_chambre(num);
					System.out.println("ok");
					return cDAO.delete(c);
				} else {
					System.out.println("Vous n'avez pas les droits pour supprimer une chambre.");
					return false;
				}
			default:
				return false;
			}
		} else {
			System.out.println("Vous n'avez pas les droits pour consulter les chambres.");
			return false;
		}
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

		int choixO = 1, choixA;
		while (choixO < 4 || choixO > 0) {
			System.out.println("Sur quel object voulez-vous travailler? " + "Tapez 1 pour personne"
					+ "Tapez 2 pour chambre" + "Tapez 3 pour réservation" + "Tapez 0 pour sortir");
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
				break;
			case 2:
				switchChambre(choixA, pers.getAcces());
				break;
			case 3:
				switchReservation(choixA, pers.getAcces(), pers.getId_pers());
				break;
			}

		}

		clavier.close();

	}

}
