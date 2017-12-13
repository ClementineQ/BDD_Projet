package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChambreDAO extends DAO<Chambre> {

	public boolean create(Chambre c) {
		try {

			PreparedStatement state = connect
					.prepareStatement("INSERT INTO CHAMBRE(etat, type, capacite, tarif) VALUES (?, ?, ?, ?)");
			state.setString(1, c.getEtat().toString());
			state.setString(2, c.getType().toString());
			state.setInt(3, c.getCapacite());
			state.setDouble(4, c.getTarif());
			state.executeUpdate();
			c.toString();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Chambre c) {
		try {

			PreparedStatement state = connect.prepareStatement("DELETE FROM CHAMBRE WHERE id_chambre= ?");
			state.setInt(1, c.getId_chambre());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Chambre c) {
		try {

			PreparedStatement state = connect.prepareStatement(
					"UPDATE CHAMBRE SET etat=?, type = ?, capacite=?, tarif=?,id_pers=?, id_reservation WHERE id_chambre= ?");
			state.setString(1, c.getEtat().toString());
			state.setString(2, c.getType().toString());
			state.setInt(3, c.getCapacite());
			state.setDouble(4, c.getTarif());
			state.setInt(5, c.getId_pers());
			state.setInt(6, c.getId_reservation());
			state.setInt(7, c.getId_chambre());

			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Chambre find(int id) {
		Chambre chambre = new Chambre();
		try {
			PreparedStatement state = connect.prepareStatement("SELECT * FROM CHAMBRE WHERE id_chambre=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();

			if (result.next()) {
				chambre.setId_chambre(result.getInt("id_chambre"));
				chambre.setEtat(result.getString("etat"));
				chambre.setType(result.getString("type"));
				chambre.setCapacite(result.getInt("capacite"));
				chambre.setTarif(result.getInt("tarif"));
				chambre.setId_pers(result.getInt("id_pers"));
				chambre.setId_reservation(result.getInt("id_reservation"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chambre;
	}

	public Chambre findResa(int id) {
		Chambre chambre = new Chambre();
		try {
			PreparedStatement state = connect.prepareStatement("SELECT * FROM CHAMBRE WHERE id_reservation=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();

			if (result.first()) {
				chambre.setId_chambre(result.getInt("id_chambre"));
				chambre.setEtat(result.getString("etat"));
				chambre.setType(result.getString("type"));
				chambre.setCapacite(result.getInt("capacite"));
				chambre.setTarif(result.getInt("tarif"));
				chambre.setId_pers(result.getInt("id_pers"));
				chambre.setId_reservation(result.getInt("id_reservation"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chambre;
	}

}
