package dao;

public enum Acces {
	
	Client, Gestionnaire, Employee;
	
	public String getAcces(){
		return this.toString();
	}
	
	public Acces setAcces(String s){
		if(s.equals(Client))
			return Client;
		else if(s.equals(Gestionnaire))
			return Gestionnaire;
		else if(s.equals(Employee))
			return Employee;
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
	
	public boolean isGestion() {
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
