package dao;

//import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//Scanner clavier = new Scanner(System.in);
		PersonneDAO pDAO = new PersonneDAO();
		pDAO.find(6);
		/*
		 * System.out.print("Entrez votre mail :"); String mail =
		 * clavier.next(); System.out.print("Entrez votre mdp :"); String mdp =
		 * clavier.next(); Personne p = pDAO.Existe(mail, mdp); p.toString();
		 */
	}
}
