package dao;

public class Personne {

	private int id_pers;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private Acces acces;

	public int getId_pers() {
		return id_pers;
	}

	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Acces getAcces() {
		if (acces == null)
			return Acces.Client;
		else
			return acces;
	}

	public void setAcces(String s) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
		if (s.equals("Gestionnaire"))
			this.acces = Acces.Gestionnaire;
		else if (s.equals("Employee"))
			this.acces = Acces.Employee;
		else
			this.acces = Acces.Client;
<<<<<<< HEAD
	}
	
	public void setAcces1(String s) {
		if (s == "Gestionnaire")
			this.acces = Acces.Gestionnaire;
		else if (s == "Employee")
			this.acces = Acces.Employee;
		else
			this.acces = Acces.Client;
=======
=======
		this.acces = acces.setAcces(s);
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
	}

	@Override
	public String toString() {
		return "Personne [id_pers=" + id_pers + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp="
				+ mdp + ", acces=" + acces + "]";
	}

}
