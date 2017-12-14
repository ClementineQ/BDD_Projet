package dao;

public enum Saison {
	
	Rouge, Vert, Orange;

	public boolean isRouge(){
		switch (this) {
		case Rouge:
			return true;
		default:
			return false;
		}
	}

	public boolean isVert(){
		switch (this) {
		case Vert:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isOrange(){
		switch (this) {
		case Orange:
			return true;
		default:
			return false;
		}
	}
	
}
