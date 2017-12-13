package dao;

public enum Etat {

	Reservee, Sale, Disponible;

	public String getEtat() {
		return this.toString();
	}

	public boolean isDispo() {
		switch (this) {
		case Disponible:
			return true;
		default:
			return false;
		}
	}

	public boolean isSale() {
		switch (this) {
		case Sale:
			return true;
		default:
			return false;
		}
	}

	public boolean isReservee() {
		switch (this) {
		case Reservee:
			return true;
		default:
			return false;
		}
	}

}
