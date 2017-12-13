package dao;

public enum Etat {

	Reservee, Sale, Disponible;

	public String getEtat() {
		return this.toString();
	}

<<<<<<< HEAD
=======
	public Etat setEtat(String s) {
		if (s.equals(Disponible))
			return Disponible;
		else if (s.equals(Reservee))
			return Reservee;
		else if (s.equals(Sale))
			return Sale;
		else
			return null;
	}

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
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
