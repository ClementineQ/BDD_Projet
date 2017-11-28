package dao;

public enum Type {
	
	Appartement, Luxe, Classique;
	
	public String getType(){
		return this.toString();
	}
	
	public Type setType(String s){
		if(s.equals(Appartement))
			return Appartement;
		else if(s.equals(Luxe))
			return Luxe;
		else if(s.equals(Classique))
			return Classique;
		else
			return null;
	}
	
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

}
