package dao;

public enum Etat {

	Reservee, Sale, Disponible;

	public String getEtat() {
		return this.toString();
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	public Etat setEtat(String s) {
		if (s.equals(Disponible))
		else if (s.equals(Reservee))
		else if (s.equals(Sale))
	
>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
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
