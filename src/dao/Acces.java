package dao;

public enum Acces {

	Client, Gestionnaire, Employee;

	public Acces setAcces(String s) {
		if (s.equals("Client"))
			return Acces.Client;
		else if (s.equals("Gestionnaire"))
			return Acces.Gestionnaire;
		else if (s.equals("Employee"))
			return Acces.Employee;
		else
			return null;
	}

	public boolean isClient() {
		switch (this) {
		case Client:
			return true;
		default:
			return false;
		}
	}

	public boolean isGestionnaire() {
		switch (this) {
		case Gestionnaire:
			return true;
		default:
			return false;
		}
	}

	public boolean isEmployee() {
		switch (this) {
		case Employee:
			return true;
		default:
			return false;
		}
	}

}
