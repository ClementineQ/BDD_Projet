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
		return acces;
	}

	public void setAcces(Acces acces) {
		this.acces = acces;
	}

}
