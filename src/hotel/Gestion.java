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
		Scanner clavier = new Scanner(System.in);

	}
		
		// Etape 1 : une personne rentre son mail + mdp
		// Vérifier s'il est dans la base de données > Méthode Existe
		
		// Méthodes ajouter, supprimer, modifier, consulter
		// Marie : Personne
		// Clémentine : Réservation
		// Emeline : Chambre	
	
		Properties prop = new Properties();
		InputStream input = null;
	try {
		int mail, mdp, choix;
		ResultSet result2;
		choix=1;

		input = new FileInputStream("properties");
		prop.load(input);
		Class.forName(prop.getProperty("driver"));
		Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"),
				prop.getProperty("passwd"));

		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM PERSONNE");
		ResultSetMetaData resultMeta = result.getMetaData();

		do {
			System.out.print("Entrez votre mail :");
			mail = clavier.nextInt();
			System.out.print("Entrez votre mdp :");
			mdp = clavier.nextInt();
			result2 = state.executeQuery(
					"SELECT * FROM PERSONNE WHERE PERSONNE.mail=" + mail + " AND PERSONNE.mdp=" + mdp);

		} while (!Existe(mail, mdp, result2));
	
	
		
		int choixO=1, choixA=1;	
		while(choixO<4 || choixO>0){
		System.out.println("Sur quel object voulez-vous travailler? "
				+ "Tapez 1 pour personne"
				+ "Tapez 2 pour chambre"
				+ "Tapez 3 pour réservation"
				+ "Tapez 0 pour sortir");
		choixO = clavier.nextInt();
	
		while(choixA<5 && choixA>0){		
			System.out.println("Que souhaitez-vous faire? "
					+ "Tapez 1 pour consulter"
					+ "Tapez 2 pour ajouter "
					+ "Tapez 3 pour modifier"
					+ "Tapez 4 pour supprimer"
					+ "Tapez 0 pour sortir");
			choixA = clavier.nextInt();
		}
		
		  switch(choixO){
		case 1 : 
			switchPersonne(choixA);
			break;
		case 2 :
			switchReservation(choixA);
			break;
		case 3 : 
			switchChambre(choixA);
		}
	
		
	
	}

}
