package dao;

public class Test {

	public static void main(String[] args) {
		// Personne p = new Personne();
		PersonneDAO pDAO = new PersonneDAO();
		pDAO.find(1);
	}
}
