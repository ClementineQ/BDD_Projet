package dao;

public enum Type {

	Appartement, Luxe, Classique;

	public String getType() {
		return this.toString();
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	public Type setType(String s) {
		if (s.equals(Appartement))
			return Appartement;
		else if (s.equals(Luxe))
			return Luxe;
		else if (s.equals(Classique))
			return Classique;
		else
			return null;
	}

>>>>>>> 2d23d9992e591fa562be24866e179cbbeef7f7c1
>>>>>>> 3eec79b8b7c133eb58dae23c28f60820e71f6afb
	public boolean isAppart() {
		switch (this) {
		case Appartement:
			return true;
		default:
			return false;
		}
	}

	public boolean isLuxe() {
		switch (this) {
		case Luxe:
			return true;
		default:
			return false;
		}
	}

	public boolean isClassique() {
		switch (this) {
		case Classique:
			return true;
		default:
			return false;
		}
	}

	public double prixType() {
		switch (this) {
		case Appartement:
			return 75;
		case Classique:
			return 50;
		case Luxe:
			return 100;
		default:
			return 0;
		}
	}

}
