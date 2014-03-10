package lea.helper;

import java.sql.ResultSet;

import lea.controller.MySqlAdapter;

public class SQLHelper {
	// Singleton
	private static SQLHelper sqlHelper = null;

	public SQLHelper() {
		this.mySqlAdapter = new MySqlAdapter();
	}

	public static SQLHelper getInstance() {
		if (sqlHelper == null)
			sqlHelper = new SQLHelper();
		return sqlHelper;
	}

	private MySqlAdapter mySqlAdapter;

	// Method to set the pupil id if it not exists
	public int getPupilId(String firstname, String lastname, String password)
			throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			// Query to get the entered pupil
			String query = "SELECT id FROM t_schueler WHERE " + "vname="
					+ firstname + " AND nname=" + lastname + " AND passwort="
					+ password + ";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result.getInt("ID"));
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("Username or Password incorrect");
				}
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}

	// Method to get all teachers by a pupil id
	public ResultSet getAllTeachersByPupil(int pupilId) throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			// Query to get the entered pupil
			String query = "select distinct l.id, l.vname, l.nname "
					+ "from t_ergebnis join t_schueler s on fk_schueler = s.id "
					+ "join t_lehrer l on fk_lehrer = l.id where s.id = "
					+ pupilId + ";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result);
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("No Data found");
				}
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}

	// Method to get all subjects by a pupil id
	public ResultSet getAllSubjectsByPupil(int pupilId) throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			// Query to get the entered pupil
			String query = "select distinct f.id, f.name "
					+ "from t_ergebnis join t_schueler s on fk_schueler = s.id "
					+ "join t_lehrer l on fk_lehrer = l.id where s.id = "
					+ pupilId + ";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result);
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("Username or Password incorrect");
				}
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}

	public ResultSet getTopTenTeacher() throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			// Query to get the entered pupil
			String query = "";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result);
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("Username or Password incorrect");
				}
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}

	public void updateResult(int pupilId, int teacherId, int subjectId,
			int result) {
		// Push result to database
	}

	// // Method to get all subjects by a teacher id and a pupil id
	// public ResultSet getAllSubjectsByPupilAndTeacher(int pupilId, int
	// teacherId)
	// throws Exception {
	// if (this.mySqlAdapter.isConnected()) {
	// // Query to get the entered pupil
	// String query = "select distinct f.id, f.kurz_bez from t_ergebnis "
	// + "join t_schueler s on fk_schueler = s.id "
	// + "join t_lehrer l on fk_lehrer = l.id "
	// + "join t_fach f on fk_fach = f.id where s.id = " + pupilId
	// + " and l.id=" + teacherId + ";";
	// try {
	// ResultSet result = this.mySqlAdapter.returnQuery(query);
	//
	// if (result != null) {
	// try {
	// return (result);
	// } catch (Exception e) {
	// throw e;
	// }
	// } else {
	// throw new Exception("Username or Password incorrect");
	// }
	// } catch (Exception e) {
	// throw e;
	// }
	// } else {
	// throw new Exception("Not connected to the database server");
	// }
	// }
}
