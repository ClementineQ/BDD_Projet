package dao;

public class Chambre {

	private int id_chambre;
	private Etat etat;
	private Type type;
	private int capacite;
	private double tarif;
	private int id_pers;
	private int id_reservation;

	public int getId_pers() {
		return id_pers;
	}

	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public String getEtat() {
		return etat.getEtat();
	}

	public void setEtat(String s) {
		this.etat = etat.setEtat(s);
	}

	public String getType() {
		return type.getType();
	}

	public void setType(String s) {
		this.type = type.setType(s);
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public double prix(Reservation r){
		double tarif;
		tarif = (type.prixType() +r.getNb_adultes()*15 + r.getNb_enfants()*10 + r.getPt_dej()*6)*r.getNb_nuits();
		if(r.getSaison().equals("Verte"))
			tarif *= 0.8;
		if(r.getSaison().equals("Rouge"))
			tarif *= 1.2;
		return tarif;
	}

}
