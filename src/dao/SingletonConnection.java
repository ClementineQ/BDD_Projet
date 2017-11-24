package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static String url = "jdbc:postgresql://rhodes.ima.uco.fr:5432/cqueinnec";
	private static String user = "postgres";
	private static String passwd = "null";

	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;

	}
}
