package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO extends DAO<Reservation> {

	public boolean create(Reservation r) {
		try {

			PreparedStatement state = connect.prepareStatement(
					"INSERT INTO RESERVATION( nb_adultes, nb_enfants, date_deb, nb_nuits, pt_dej, saison) VALUES (?,?,?,?,?,?)");
			state.setInt(1, r.getNb_adultes());
			state.setInt(2, r.getNb_enfants());
			state.setDate(3, r.getDate_deb());
			state.setInt(4, r.getNb_nuits());
			state.setInt(5, r.getPt_dej());
			state.setString(6, r.getSaison());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Reservation r) {
		try {

			PreparedStatement state = connect.prepareStatement("DELETE FROM RESERVATION WHERE id_reservation= ?");
			state.setInt(1, r.getId_reservation());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Reservation r) {
		try {

			PreparedStatement state = connect.prepareStatement(
					"UPDATE RESERVATION set nb_adultes=? AND nb_enfants = ? AND date_deb=? AND nb_nuits =? AND pt_dej=? AND saison=? WHERE id_reservation= ?");
			state.setInt(1, r.getNb_adultes());
			state.setInt(2, r.getNb_enfants());
			state.setDate(3, r.getDate_deb());
			state.setInt(4, r.getNb_nuits());
			state.setInt(5, r.getPt_dej());
			state.setString(6, r.getSaison());
			state.setInt(7, r.getId_reservation());
			state.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Reservation find(int id) {
		Reservation reservation = new Reservation();
		try {
			PreparedStatement state = connect.prepareStatement("SELECT * FROM RESERVATION WHERE id_reservation=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();

			if (result.next()) {
				reservation.setId_reservation(result.getInt("id_reservation"));
				reservation.setNb_adultes(result.getInt("nb_adultes"));
				reservation.setNb_enfants(result.getInt("nb_enfants"));
				reservation.setDate_deb(result.getDate("date_deb"));
				reservation.setNb_nuits(result.getInt("nb_nuits"));
				reservation.setPt_dej(result.getInt("pt_dej"));
				reservation.setSaison(result.getString("saison"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;

	}

}
