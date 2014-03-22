package lea.helper;

import java.sql.ResultSet;

import lea.controller.MySqlAdapter;

public class SQLHelper {
	// Singleton
	private static SQLHelper sqlHelper = null;

	public SQLHelper() throws Exception {
		this.mySqlAdapter = new MySqlAdapter();
	}

	public static SQLHelper Instance() throws Exception {
		if (sqlHelper == null)
			sqlHelper = new SQLHelper();
		return sqlHelper;
	}

	private MySqlAdapter mySqlAdapter;

	// Method to set the pupil id if it not exists
	public int getPupilId(String firstname, String lastname, String password)
			throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			//
			String query = "SELECT id FROM t_schueler WHERE vname=\""
					+ firstname + "\" AND nname=\"" + lastname
					+ "\" AND passwort=\"" + password + "\";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						int id = -99;
						while (result.next()) {
							id = result.getInt("ID");
						}
						return id;
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("No data found");
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
			//
			String query = "select distinct l.id, l.vname, l.nname "
					+ "from t_ergebnis join t_schueler s on fk_schueler = s.id "
					+ "join t_lehrer l on fk_lehrer = l.id where s.id = \""
					+ pupilId + "\";";
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
	public ResultSet getAllSubjectsByPupilAndTeacher(int pupilId, int teacherId)
			throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			//
			String query = "select distinct f.id, f.kuerzel from t_ergebnis "
					+ "join t_schueler s on fk_schueler = s.id join t_lehrer l "
					+ "on fk_lehrer = l.id join t_fach f on fk_fach = f.id where s.id = \""
					+ pupilId + "\" and l.id=\"" + teacherId + "\";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result);
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("No data found");
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
			//
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

	// Method to get the questions for the rating
	public ResultSet getRatingQuestions(int pupilId, int teacherId,
			int subjectId) throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			//
			String query = "select distinct f.id, f.frage from t_ergebnis "
					+ "join t_schueler s on fk_schueler = s.id join t_lehrer l on "
					+ "fk_lehrer = l.id join t_fach fach on fk_fach = fach.id join "
					+ "t_fragenkatalog f on f.id = fk_fragenkatalog where s.id = \""
					+ pupilId + "\" " + "and l.id = \"" + teacherId
					+ "\" and fach.id = \"" + subjectId + "\";";
			try {
				ResultSet result = this.mySqlAdapter.returnQuery(query);

				if (result != null) {
					try {
						return (result);
					} catch (Exception e) {
						throw e;
					}
				} else {
					throw new Exception("No data found");
				}
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}

	public void updateRating(int pupilId, int teacherId, int questionId,
			int subjectId, int result) throws Exception {
		if (this.mySqlAdapter.isConnected()) {
			// Query to get the entered pupil
			String query = "update t_ergebnis " + "set ergebnis = \"" + result
					+ "\" " + "where fk_fach = \"" + subjectId + "\" "
					+ "and fk_fragenkatalog = \"" + questionId
					+ "\" and fk_klasse = 2 and fk_lehrer = \"" + teacherId
					+ "\" and fk_schueler = \"" + pupilId + "\";";

			if (!this.mySqlAdapter.runQuery(query)) {
				throw new Exception(
						"Something went wrong during push your data");
			}
		} else {
			throw new Exception("Not connected to the database server");
		}
	}
}
