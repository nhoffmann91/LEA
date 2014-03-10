package lea.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Class to adapt the MySql Database
public class MySqlAdapter {

	private String Username = "root";
	private String Password = "Passwort";
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/bewertung";
	private Connection connection;

	public MySqlAdapter(String user, String pass) throws Exception {
		this.Username = user;
		this.Password = pass;
		this.connect();
	}

	public MySqlAdapter() {
	}

	public void close() throws Exception {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void connect() throws Exception {
		try {
			Class.forName(this.Driver).newInstance();
			this.connection = DriverManager.getConnection(this.URL,
					this.Username, this.Password);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isConnected() throws Exception {
		try {
			this.returnQuery("SELECT 1;");
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	public ResultSet returnQuery(String query) throws Exception {
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean runQuery(String query) throws Exception {
		try {
			Statement stmt = this.connection.createStatement();
			return stmt.execute(query);
		} catch (Exception e) {
			throw e;
		}
	}
}
