package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAO extends DAO<Personne> {

	public boolean create(Personne p) {
		try {

			PreparedStatement state = connect.prepareStatement("INSERT INTO PERSONNE(nom, prenom) VALUES (?,?)");
			state.setString(1, p.getNom());
			state.setString(2, p.getPrenom());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Personne p) {
		try {

			PreparedStatement state = connect.prepareStatement("DELETE FROM PERSONNE WHERE id_pers= ?");
			state.setInt(1, p.getId_pers());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Personne p) {
		try {

			PreparedStatement state = connect
					.prepareStatement("UPDATE PERSONNE set nom=? AND prenom = ? WHERE id_pers= ?");
			state.setString(1, p.getNom());
			state.setString(2, p.getPrenom());
			state.setInt(3, p.getId_pers());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Personne find(int id) {
		Personne personne = new Personne();
		try {
			PreparedStatement state = connect.prepareStatement("SELECT * FROM PERSONNE WHERE id_pers=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();

			if (result.first()) {
				personne.setId_pers(result.getInt("id_pers"));
				personne.setNom(result.getString("nom"));
				personne.setPrenom(result.getString("prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}

}
