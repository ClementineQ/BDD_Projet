package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAO extends DAO<Personne> {

	public boolean create(Personne p) {
		try {

			PreparedStatement state = connect
					.prepareStatement("INSERT INTO PERSONNE(nom, prenom, mail, mdp, acces) VALUES (?,?,?,?,?)");
			state.setString(1, p.getNom());
			state.setString(2, p.getPrenom());
			state.setString(3, p.getMail());
			state.setString(4, p.getMdp());
			state.setString(5, p.getAcces().toString());
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

			PreparedStatement state = connect.prepareStatement(
					"UPDATE PERSONNE SET nom = ?, prenom = ?, mail = ?, mdp = ?, acces = ? WHERE id_pers = ?");
			state.setString(1, p.getNom());
			state.setString(2, p.getPrenom());
			state.setString(3, p.getMail());
			state.setString(4, p.getMdp());
			state.setString(5, p.getAcces().toString());
			state.setInt(6, p.getId_pers());
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
			PreparedStatement state = connect.prepareStatement("SELECT * FROM PERSONNE WHERE id_pers =?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();

			if (result.next()) {
				personne.setId_pers(result.getInt("id_pers"));
				personne.setNom(result.getString("nom"));
				personne.setPrenom(result.getString("prenom"));
				personne.setMail(result.getString("mail"));
				personne.setMdp(result.getString("mdp"));
				personne.setAcces(result.getString("acces"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(personne.toString());
		return personne;
	}

	public Personne Existe(String mail, String mdp) {
		try {
			PreparedStatement state = connect
					.prepareStatement("SELECT * FROM PERSONNE WHERE PERSONNE.mail = ? AND PERSONNE.mdp = ?");
			state.setString(1, mail);
			state.setString(2, mdp);
			ResultSet result = state.executeQuery();
			if (result.next()) {
				Personne personne = new Personne();
				personne.setId_pers(result.getInt("id_pers"));
				personne.setNom(result.getString("nom"));
				personne.setPrenom(result.getString("prenom"));
				personne.setMail(mail);
				personne.setMdp(mdp);
				personne.setAcces(result.getString("acces"));
				return personne;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
