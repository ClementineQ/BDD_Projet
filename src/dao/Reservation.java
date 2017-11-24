package dao;

import java.sql.Date;

public class Reservation {

	private int id_reservation;
	private int nb_adultes;
	private int nb_enfants;
	private Date date_deb;
	private int nb_nuits;
	private int pt_dej;
	private String saison;

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public int getPt_dej() {
		return pt_dej;
	}

	public void setPt_dej(int pt_dej) {
		this.pt_dej = pt_dej;
	}

	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}

	public int getNb_adultes() {
		return nb_adultes;
	}

	public void setNb_adultes(int nb_adultes) {
		this.nb_adultes = nb_adultes;
	}

	public int getNb_enfants() {
		return nb_enfants;
	}

	public void setNb_enfants(int nb_enfants) {
		this.nb_enfants = nb_enfants;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public int getNb_nuits() {
		return nb_nuits;
	}

	public void setNb_nuits(int nb_nuits) {
		this.nb_nuits = nb_nuits;
	}

}
