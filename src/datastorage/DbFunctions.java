package datastorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pojo.Abszolut;
import pojo.Dontos;
import pojo.Gyorsulas;
import pojo.Potkocsi;
import pojo.Szlalom;
import pojo.Versenyzo;
import view.RegPanel;

public class DbFunctions {
	private static Connection connection;
	private PreparedStatement stmt;
	private Statement stmt2;

	public DbFunctions() {
		// connect();
	}

	private void connect() {
		if (!isDataConnected()) {
			try {
				Class.forName(DbConstants.DatabaseDriver);
				connection = DriverManager.getConnection(DbConstants.DatabaseType + DbConstants.Database_Name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		try {
			if (isDataConnected()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isDataConnected() {
		try {
			return (connection != null) && !connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// TODO
	public void createTables() {
		try {
			connect();
			stmt2 = connection.createStatement();

			stmt2.executeUpdate(DbConstants.Versenyzo.Database_Create);
			stmt2.executeUpdate(DbConstants.Potkocsis.Database_Create);
			stmt2.executeUpdate(DbConstants.Szlalom.Database_Create);
			stmt2.executeUpdate(DbConstants.Gyorsulas.Database_Create);
			stmt2.executeUpdate(DbConstants.Abszolut.Database_Create);
			stmt2.executeUpdate(DbConstants.Erohuzas.Database_Create);

			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateT150a);
			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateT150f);
			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateS150a);
			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateS150f);
			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateD150a);
			stmt2.executeUpdate(DbConstants.Eredmenyek.Database_CreateD150f);

			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create1f);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create2f);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create3f);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create4f);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create1a);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create2a);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create3a);
			stmt2.executeUpdate(DbConstants.GyorsulasTop10.Database_Create4a);

			ResultSet rs = stmt2.executeQuery("SELECT COUNT(*) FROM " + DbConstants.GyorsulasTop10.Database_Table150f1);
			if (rs.getInt(1) == 0) {
				for (int i = 0; i < 8; i++) {
					stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150f1 + " ("
							+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
							+ ") VALUES ('0',  '0');");
					stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150a1 + " ("
							+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
							+ ") VALUES ('0',  '0');");
					if (i % 2 == 0) {
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150f2 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150f3 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150f4 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150a2 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150a3 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.GyorsulasTop10.Database_Table150a4 + " ("
								+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", " + DbConstants.GyorsulasTop10.Key_Nyert
								+ ") VALUES ('0',  '0');");
					}
				}
				rs.close();
			}

			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create1f);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create2f);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create3f);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create4f);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create1a);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create2a);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create3a);
			stmt2.executeUpdate(DbConstants.SzlalomTop10.Database_Create4a);
			ResultSet rs1 = stmt2.executeQuery("SELECT COUNT(*) FROM " + DbConstants.SzlalomTop10.Database_Table150f1);
			if (rs1.getInt(1) == 0) {
				for (int i = 0; i < 8; i++) {
					stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150f1 + " ("
							+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
							+ ") VALUES ('0', '0');");
					stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150a1 + " ("
							+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
							+ ") VALUES ('0', '0');");
					if (i % 2 == 0) {
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150f2 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150f3 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ('0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150f4 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150a2 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150a3 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ('0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.SzlalomTop10.Database_Table150a4 + " ("
								+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
					}
				}
				rs1.close();
			}

			stmt2.executeUpdate(DbConstants.VeteranTop10.Database_Create1);
			stmt2.executeUpdate(DbConstants.VeteranTop10.Database_Create2);
			stmt2.executeUpdate(DbConstants.VeteranTop10.Database_Create3);
			stmt2.executeUpdate(DbConstants.VeteranTop10.Database_Create4);
			ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM " + DbConstants.VeteranTop10.Database_Table1);
			if (rs2.getInt(1) == 0) {
				for (int i = 0; i < 8; i++) {
					stmt2.executeUpdate("INSERT INTO " + DbConstants.VeteranTop10.Database_Table1 + " ("
							+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Key_Nyert
							+ ") VALUES ('0', '0');");
					if (i % 2 == 0) {
						stmt2.executeUpdate("INSERT INTO " + DbConstants.VeteranTop10.Database_Table2 + " ("
								+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.VeteranTop10.Database_Table3 + " ("
								+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Key_Nyert
								+ ") VALUES ('0', '0');");
						stmt2.executeUpdate("INSERT INTO " + DbConstants.VeteranTop10.Database_Table4 + " ("
								+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Key_Nyert
								+ ") VALUES ( '0', '0');");
					}
				}
				rs2.close();
			}

			stmt2.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int count(String table) {
		try {
			connect();

			stmt = connection.prepareStatement("SELECT COUNT(*) FROM " + table);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int szum = rs.getInt(1);

			rs.close();
			stmt.close();
			close();
			return szum;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insert_or_update_Adat(int rajt, String nev, String varos, String osztozik, String neme,
			String kategoria, String potkocsis, String szlalom, String gyorsulas, String erohuzas) {
		try {
			connect();

			boolean exist = false;

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Versenyzo.Database_Table + " WHERE "
					+ DbConstants.Versenyzo.Key_Rajtszam + "= " + rajt);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Versenyzo.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist)
				updateAdat(rajt, nev, varos, osztozik, neme, kategoria, potkocsis, szlalom, gyorsulas, erohuzas);
			else
				insertAdat(rajt, nev, varos, osztozik, neme, kategoria, potkocsis, szlalom, gyorsulas, erohuzas);

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_or_update_Potkocsis(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			boolean exist = false;

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Potkocsis.Database_Table + " WHERE "
					+ DbConstants.Potkocsis.Key_Rajtszam + "= " + rajt);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Potkocsis.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist) {
				// updatePotkocsis(rajt, ido, hiba, vegleges);
			} else {
				insertPotkocsis(rajt, ido, hiba, vegleges);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_or_update_Erohuzas(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			boolean exist = false;

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Erohuzas.Database_Table + " WHERE "
					+ DbConstants.Erohuzas.Key_Rajtszam + "= " + rajt);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Erohuzas.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist) {
				// updatePotkocsis(rajt, ido, hiba, vegleges);
			} else {
				insertErohuzas(rajt, ido, hiba, vegleges);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_or_update_Szlalom(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			boolean exist = false;

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Szlalom.Database_Table + " WHERE "
					+ DbConstants.Szlalom.Key_Rajtszam + "= " + rajt);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Szlalom.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist) {
				// updateSzlalom(rajt, ido, hiba, vegleges);
			} else {
				insertSzlalom(rajt, ido, hiba, vegleges);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_or_update_Gyorsulas(int rajt, String ido1, String ido2, String legjobb) {
		try {
			connect();

			boolean exist = false;

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Gyorsulas.Database_Table + " WHERE "
					+ DbConstants.Gyorsulas.Key_Rajtszam + "= " + rajt);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Gyorsulas.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist) {
				// updateGyorsulas(rajt, ido1, ido2, legjobb);
			} else {
				insertGyorsulas(rajt, ido1, ido2, legjobb);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertAdat(int rajt, String nev, String varos, String osztozik, String neme, String kategoria,
			String potkocsis, String szlalom, String gyorsulas, String erohuzas) {
		try {
			connect();

			stmt = connection.prepareStatement(
					"INSERT INTO " + DbConstants.Versenyzo.Database_Table + " (" + DbConstants.Versenyzo.Key_Rajtszam
							+ ", " + DbConstants.Versenyzo.Key_Nev + ", " + DbConstants.Versenyzo.Key_Varos + ", "
							+ DbConstants.Versenyzo.Key_Osztozik + ", " + DbConstants.Versenyzo.Key_No + ", "
							+ DbConstants.Versenyzo.Key_Kategoria + ", " + DbConstants.Versenyzo.Key_Potkocsis + ", "
							+ DbConstants.Versenyzo.Key_Szlalom + ", " + DbConstants.Versenyzo.Key_Gyorsulas + ", "
							+ DbConstants.Versenyzo.Key_Erohuzas + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, rajt);
			stmt.setString(2, nev);
			stmt.setString(3, varos);
			stmt.setString(4, osztozik);
			stmt.setString(5, neme);
			stmt.setString(6, kategoria);
			stmt.setString(7, potkocsis);
			stmt.setString(8, szlalom);
			stmt.setString(9, gyorsulas);
			stmt.setString(10, erohuzas);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAdat(int rajt, String nev, String varos, String osztozik, String neme, String kategoria,
			String potkocsis, String szlalom, String gyorsulas, String erohuzas) {
		try {
			connect();

			stmt = connection.prepareStatement("UPDATE " + DbConstants.Versenyzo.Database_Table + " SET "
					+ DbConstants.Versenyzo.Key_Nev + " = ?, " + DbConstants.Versenyzo.Key_Varos + " = ?, "
					+ DbConstants.Versenyzo.Key_Osztozik + " = ?, " + DbConstants.Versenyzo.Key_No + " = ?, "
					+ DbConstants.Versenyzo.Key_Kategoria + " = ?, " + DbConstants.Versenyzo.Key_Potkocsis + " = ?, "
					+ DbConstants.Versenyzo.Key_Szlalom + " = ?, " + DbConstants.Versenyzo.Key_Gyorsulas + " = ?, "
					+ DbConstants.Versenyzo.Key_Erohuzas + " = ? " + "WHERE " + DbConstants.Versenyzo.Key_Rajtszam
					+ " = ?");

			stmt.setInt(9, rajt);
			stmt.setString(1, nev);
			stmt.setString(2, varos);
			stmt.setString(3, osztozik);
			stmt.setString(4, neme);
			stmt.setString(5, kategoria);
			stmt.setString(6, potkocsis);
			stmt.setString(7, szlalom);
			stmt.setString(8, gyorsulas);

			stmt.execute();

			if (potkocsis.equals("false")) {
				delete(DbConstants.Potkocsis.Database_Table, rajt);
			}
			if (szlalom.equals("false")) {
				delete(DbConstants.Szlalom.Database_Table, rajt);
			}
			if (gyorsulas.equals("false")) {
				delete(DbConstants.Gyorsulas.Database_Table, rajt);
			}

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertPotkocsis(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			stmt = connection.prepareStatement("INSERT INTO " + DbConstants.Potkocsis.Database_Table + " ("
					+ DbConstants.Potkocsis.Key_Rajtszam + ", " + DbConstants.Potkocsis.Key_Ido + ", "
					+ DbConstants.Potkocsis.Key_Hiba + ", " + DbConstants.Potkocsis.Key_VIdo + ") VALUES (?, ?, ?, ?)");
			stmt.setInt(1, rajt);
			stmt.setString(2, ido);
			stmt.setInt(3, hiba);
			stmt.setString(4, vegleges);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePotkocsis(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			stmt = connection.prepareStatement(
					"UPDATE " + DbConstants.Potkocsis.Database_Table + " SET " + DbConstants.Potkocsis.Key_Ido
							+ " = ?, " + DbConstants.Potkocsis.Key_Hiba + " = ?, " + DbConstants.Potkocsis.Key_VIdo
							+ " = ? " + "WHERE " + DbConstants.Potkocsis.Key_Rajtszam + " = ?");
			stmt.setString(1, ido);
			stmt.setInt(2, hiba);
			stmt.setString(3, vegleges);
			stmt.setInt(4, rajt);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertErohuzas(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			stmt = connection.prepareStatement("INSERT INTO " + DbConstants.Erohuzas.Database_Table + " ("
					+ DbConstants.Erohuzas.Key_Rajtszam + ", " + DbConstants.Erohuzas.Key_Ido + ", "
					+ DbConstants.Erohuzas.Key_Hiba + ", " + DbConstants.Erohuzas.Key_VIdo + ") VALUES (?, ?, ?, ?)");
			stmt.setInt(1, rajt);
			stmt.setString(2, ido);
			stmt.setInt(3, hiba);
			stmt.setString(4, vegleges);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSzlalom(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			stmt = connection.prepareStatement("INSERT INTO " + DbConstants.Szlalom.Database_Table + " ("
					+ DbConstants.Szlalom.Key_Rajtszam + ", " + DbConstants.Szlalom.Key_Ido + ", "
					+ DbConstants.Szlalom.Key_Hiba + ", " + DbConstants.Szlalom.Key_VIdo + ") VALUES (?, ?, ?, ?)");

			stmt.setInt(1, rajt);
			stmt.setString(2, ido);
			stmt.setInt(3, hiba);
			stmt.setString(4, vegleges);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSzlalom(int rajt, String ido, int hiba, String vegleges) {
		try {
			connect();

			stmt = connection.prepareStatement("UPDATE " + DbConstants.Szlalom.Database_Table + " SET "
					+ DbConstants.Szlalom.Key_Ido + " = ?, " + DbConstants.Szlalom.Key_Hiba + " = ?, "
					+ DbConstants.Szlalom.Key_VIdo + " = ? " + "WHERE " + DbConstants.Szlalom.Key_Rajtszam + " = ?");
			stmt.setString(1, ido);
			stmt.setInt(2, hiba);
			stmt.setString(3, vegleges);
			stmt.setInt(4, rajt);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertGyorsulas(int rajt, String ido1, String ido2, String legjobb) {
		try {
			connect();

			stmt = connection.prepareStatement("INSERT INTO " + DbConstants.Gyorsulas.Database_Table + " ("
					+ DbConstants.Gyorsulas.Key_Rajtszam + ", " + DbConstants.Gyorsulas.Key_Ido1 + ", "
					+ DbConstants.Gyorsulas.Key_Ido2 + ", " + DbConstants.Gyorsulas.Key_LIdo + ") VALUES (?, ?, ?, ?)");

			stmt.setInt(1, rajt);
			stmt.setString(2, ido1);
			stmt.setString(3, ido2);
			stmt.setString(4, legjobb);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGyorsulas(int rajt, String ido1, String ido2, String legjobb) {
		try {
			connect();

			stmt = connection.prepareStatement(
					"UPDATE " + DbConstants.Gyorsulas.Database_Table + " SET " + DbConstants.Gyorsulas.Key_Ido1
							+ " = ?, " + DbConstants.Gyorsulas.Key_Ido2 + " = ?, " + DbConstants.Gyorsulas.Key_LIdo
							+ " = ? " + "WHERE " + DbConstants.Gyorsulas.Key_Rajtszam + " = ?");
			stmt.setString(1, ido1);
			stmt.setString(2, ido2);
			stmt.setString(3, legjobb);
			stmt.setInt(4, rajt);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_or_update_Abszolut(int rajt, String nev, String kategoria, int potkocsis, int szlalom,
			int gyorsulas) {
		try {
			connect();

			boolean exist = false;
			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Abszolut.Database_Table + " WHERE "
					+ DbConstants.Abszolut.Key_Rajtszam + " = ?");
			stmt.setInt(1, rajt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(DbConstants.Abszolut.Key_Rajtszam) == rajt) {
					exist = true;
					break;
				}
			}

			if (exist) {
				int pot, sz, gy;
				pot = rs.getInt(DbConstants.Abszolut.Key_Potkocsis);
				sz = rs.getInt(DbConstants.Abszolut.Key_Szlalom);
				gy = rs.getInt(DbConstants.Abszolut.Key_Gyorsulas);
				if (potkocsis > 0)
					pot = potkocsis;
				if (szlalom > 0)
					sz = szlalom;
				if (gyorsulas > 0)
					gy = gyorsulas;
				updateAbszolut(rajt, nev, kategoria, pot, sz, gy);
			} else
				insertAbsolut(rajt, nev, kategoria, potkocsis, szlalom, gyorsulas);

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertAbsolut(int rajt, String nev, String kategoria, int potkocsis, int szlalom, int gyorsulas) {
		try {
			connect();

			stmt = connection.prepareStatement("INSERT INTO " + DbConstants.Abszolut.Database_Table + " ("
					+ DbConstants.Abszolut.Key_Rajtszam + ", " + DbConstants.Abszolut.Key_Nev + ", "
					+ DbConstants.Abszolut.Key_Kategoria + ", " + DbConstants.Abszolut.Key_Potkocsis + ", "
					+ DbConstants.Abszolut.Key_Szlalom + ", " + DbConstants.Abszolut.Key_Gyorsulas + ", "
					+ DbConstants.Abszolut.Key_Osszes + ") VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, rajt);
			stmt.setString(2, nev);
			stmt.setString(3, kategoria);
			stmt.setInt(4, potkocsis);
			stmt.setInt(5, szlalom);
			stmt.setInt(6, gyorsulas);
			stmt.setFloat(7, 0.0f);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAbszolut(int rajt, String nev, String kategoria, int potkocsis, int szlalom, int gyorsulas) {
		try {
			connect();

			float sum = 0.0f;
			stmt = connection.prepareStatement("UPDATE " + DbConstants.Abszolut.Database_Table + " SET "
					+ DbConstants.Abszolut.Key_Nev + " = ?, " + DbConstants.Abszolut.Key_Kategoria + " = ?, "
					+ DbConstants.Abszolut.Key_Potkocsis + " = ?, " + DbConstants.Abszolut.Key_Szlalom + " = ?, "
					+ DbConstants.Abszolut.Key_Gyorsulas + " = ?, " + DbConstants.Abszolut.Key_Osszes + " = ? WHERE "
					+ DbConstants.Abszolut.Key_Rajtszam + " = ?");

			if (kategoria.equals("150a")) {
				//sum = ((float) potkocsis / RegPanel.pot150a) + ((float) szlalom / RegPanel.szl150a)
				//		+ ((float) gyorsulas / RegPanel.gy150a);

				if (RegPanel.pot150a < 1) {
					sum += (float) potkocsis;
				} else {
					sum += (float) potkocsis / RegPanel.pot150a;
				}
				if (RegPanel.szl150a < 1) {
					sum += (float) szlalom;
				} else {
					sum += (float) szlalom / RegPanel.szl150a;
				}
				if (RegPanel.gy150a < 1) {
					sum += (float) gyorsulas;
				} else {
					sum += (float) gyorsulas / RegPanel.gy150a;
				}

			} else if (kategoria.equals("150f")) {
				//sum = ((float) potkocsis / RegPanel.pot150f) + ((float) szlalom / RegPanel.szl150f)
				//		+ ((float) gyorsulas / RegPanel.gy150f);
				
				if (RegPanel.pot150f < 1) {
					sum += (float) potkocsis;
				} else {
					sum += (float) potkocsis / RegPanel.pot150f;
				}
				if (RegPanel.szl150f < 1) {
					sum += (float) szlalom;
				} else {
					sum += (float) szlalom / RegPanel.szl150f;
				}
				if (RegPanel.gy150f < 1) {
					sum += (float) gyorsulas;
				} else {
					sum += (float) gyorsulas / RegPanel.gy150f;
				}
			}

			System.out.println("szumma " + sum);

			stmt.setString(1, nev);
			stmt.setString(2, kategoria);
			stmt.setInt(3, potkocsis);
			stmt.setInt(4, szlalom);
			stmt.setInt(5, gyorsulas);
			stmt.setFloat(6, sum);
			stmt.setInt(7, rajt);

			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Versenyzo selectVerenyzo(int rajt) {
		Versenyzo v = new Versenyzo();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Versenyzo.Database_Table + " WHERE "
					+ DbConstants.Versenyzo.Key_Rajtszam + " = " + rajt);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				v.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				v.setRajt(rs.getInt(DbConstants.Versenyzo.Key_Rajtszam));
				v.setNeme(rs.getString(DbConstants.Versenyzo.Key_No));
				v.setVaros(rs.getString(DbConstants.Versenyzo.Key_Varos));
				v.setKategoria(rs.getString(DbConstants.Versenyzo.Key_Kategoria));
				v.setOsztozik(rs.getString(DbConstants.Versenyzo.Key_Osztozik));
				v.setPotkocsis(rs.getString(DbConstants.Versenyzo.Key_Potkocsis));
				v.setSzlalom(rs.getString(DbConstants.Versenyzo.Key_Szlalom));
				v.setGyorsulas(rs.getString(DbConstants.Versenyzo.Key_Gyorsulas));
				v.setErohuzas(rs.getString(DbConstants.Versenyzo.Key_Erohuzas));
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public ArrayList<Versenyzo> selectAdat() {
		try {
			ArrayList<Versenyzo> lista = new ArrayList<>();
			Versenyzo v;
			connect();

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Versenyzo.Database_Table + " ORDER BY "
					+ DbConstants.Versenyzo.Key_Rajtszam);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				v = new Versenyzo();
				v.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				v.setRajt(rs.getInt(DbConstants.Versenyzo.Key_Rajtszam));
				v.setNeme(rs.getString(DbConstants.Versenyzo.Key_No));
				v.setVaros(rs.getString(DbConstants.Versenyzo.Key_Varos));
				v.setKategoria(rs.getString(DbConstants.Versenyzo.Key_Kategoria));
				v.setOsztozik(rs.getString(DbConstants.Versenyzo.Key_Osztozik));
				v.setPotkocsis(rs.getString(DbConstants.Versenyzo.Key_Potkocsis));
				v.setSzlalom(rs.getString(DbConstants.Versenyzo.Key_Szlalom));
				v.setGyorsulas(rs.getString(DbConstants.Versenyzo.Key_Gyorsulas));
				v.setErohuzas(rs.getString(DbConstants.Versenyzo.Key_Erohuzas));

				lista.add(v);
			}

			rs.close();
			stmt.close();
			close();

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Potkocsi> selectPotkocsis() {
		try {
			ArrayList<Potkocsi> lista = new ArrayList<Potkocsi>();
			Potkocsi p;
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_Rajtszam + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Nev + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_No + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + ", " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_Ido + ", " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_Hiba + ", " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_VIdo + " FROM " + DbConstants.Potkocsis.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " ORDER BY " + DbConstants.Potkocsis.Database_Table + "."
					+ DbConstants.Potkocsis.Key_VIdo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				p = new Potkocsi();
				p.setRajt(rs.getInt(DbConstants.Potkocsis.Key_Rajtszam));
				p.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				p.setNeme(rs.getString(DbConstants.Versenyzo.Key_No));
				p.setKategoria(rs.getString(DbConstants.Versenyzo.Key_Kategoria));
				p.setIdo(rs.getString(DbConstants.Potkocsis.Key_Ido));
				p.setHiba(rs.getInt(DbConstants.Potkocsis.Key_Hiba));
				p.setVido(rs.getString(DbConstants.Potkocsis.Key_VIdo));

				lista.add(p);
			}

			rs.close();
			stmt.close();
			close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Szlalom> selectSzlalom() {
		try {
			ArrayList<Szlalom> lista = new ArrayList<Szlalom>();
			Szlalom sz;
			connect();

			stmt = connection.prepareStatement(
					"SELECT " + DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_Rajtszam + ", "
							+ DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + ", "
							+ DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_No + ", "
							+ DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Kategoria + ", "
							+ DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_Ido + ", "
							+ DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_Hiba + ", "
							+ DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_VIdo + " FROM "
							+ DbConstants.Szlalom.Database_Table + ", " + DbConstants.Versenyzo.Database_Table
							+ " WHERE " + DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_Rajtszam
							+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
							+ " ORDER BY " + DbConstants.Szlalom.Database_Table + "." + DbConstants.Szlalom.Key_VIdo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sz = new Szlalom();
				sz.setRajt(rs.getInt(DbConstants.Szlalom.Key_Rajtszam));
				sz.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				sz.setNeme(rs.getString(DbConstants.Versenyzo.Key_No));
				sz.setKategoria(rs.getString(DbConstants.Versenyzo.Key_Kategoria));
				sz.setIdo(rs.getString(DbConstants.Szlalom.Key_Ido));
				sz.setHiba(rs.getInt(DbConstants.Szlalom.Key_Hiba));
				sz.setVido(rs.getString(DbConstants.Szlalom.Key_VIdo));

				lista.add(sz);
			}

			rs.close();
			stmt.close();
			close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Gyorsulas> selectGyorsulas() {
		try {
			ArrayList<Gyorsulas> lista = new ArrayList<Gyorsulas>();
			Gyorsulas gy;
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Nev + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_No + ", " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + ", " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Ido1 + ", " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Ido2 + ", " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_LIdo + " FROM " + DbConstants.Gyorsulas.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " ORDER BY " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_LIdo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				gy = new Gyorsulas();
				gy.setRajt(rs.getInt(DbConstants.Gyorsulas.Key_Rajtszam));
				gy.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				gy.setNeme(rs.getString(DbConstants.Versenyzo.Key_No));
				gy.setKategoria(rs.getString(DbConstants.Versenyzo.Key_Kategoria));
				gy.setIdo1(rs.getString(DbConstants.Gyorsulas.Key_Ido1));
				gy.setIdo2(rs.getString(DbConstants.Gyorsulas.Key_Ido2));
				gy.setLido(rs.getString(DbConstants.Gyorsulas.Key_LIdo));

				lista.add(gy);
			}

			rs.close();
			stmt.close();
			close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Abszolut> selectAbsolut() {
		try {
			ArrayList<Abszolut> lista = new ArrayList<Abszolut>();
			Abszolut a;
			connect();

			stmt = connection.prepareStatement("SELECT * FROM " + DbConstants.Abszolut.Database_Table + " ORDER BY "
					+ DbConstants.Abszolut.Key_Osszes);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				a = new Abszolut();
				a.setRajt(rs.getInt(DbConstants.Abszolut.Key_Rajtszam));
				a.setNev(rs.getString(DbConstants.Abszolut.Key_Nev));
				a.setKategoria(rs.getString(DbConstants.Abszolut.Key_Kategoria));
				a.setPotkocsis(rs.getInt(DbConstants.Abszolut.Key_Potkocsis));
				a.setSzlalom(rs.getInt(DbConstants.Abszolut.Key_Szlalom));
				a.setGyorsulas(rs.getInt(DbConstants.Abszolut.Key_Gyorsulas));
				a.setOsszes(rs.getFloat(DbConstants.Abszolut.Key_Osszes));

				lista.add(a);
			}

			rs.close();
			stmt.close();
			close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Gyorsulas selectOneDrag(int num) {
		try {
			connect();

			Gyorsulas gy = new Gyorsulas();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Gyorsulas.Key_Ido1 + ", "
					+ DbConstants.Gyorsulas.Key_Ido2 + " FROM " + DbConstants.Gyorsulas.Database_Table + " WHERE "
					+ DbConstants.Gyorsulas.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			ResultSet rs = stmt.executeQuery();
			rs.next();

			gy.setRajt(num);
			gy.setIdo1(rs.getString(DbConstants.Gyorsulas.Key_Ido1));
			gy.setIdo2(rs.getString(DbConstants.Gyorsulas.Key_Ido2));

			rs.close();
			stmt.close();
			close();

			return gy;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void sortDontok() {
		sortSzlalom150aDonto();
		sortSzlalom150fDonto();
		sortGyorsulas150aDonto();
		sortGyorsulas150fDonto();
		sortVeteranDonto();
	}

	public void sortSzlalom150fDonto() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " FROM " + DbConstants.Szlalom.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " AND " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + " = '150f' AND " + DbConstants.Versenyzo.Database_Table
					+ "." + DbConstants.Versenyzo.Key_No + " = 'Ferfi' ORDER BY " + DbConstants.Szlalom.Database_Table
					+ "." + DbConstants.Szlalom.Key_VIdo + " LIMIT 10");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(rs.getInt(DbConstants.Szlalom.Key_Rajtszam));
			}

			int i = 0;
			if (lista.size() > 9) {
				i = 0;
				while (i < 10) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 8: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 9: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 7) {
				i = 0;
				while (i < 8) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 5) {
				i = 0;
				while (i < 6) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 3) {
				i = 0;
				while (i < 4) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					}
				}
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortSzlalom150aDonto() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " FROM " + DbConstants.Szlalom.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " AND " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + " = '150a' AND " + DbConstants.Versenyzo.Database_Table
					+ "." + DbConstants.Versenyzo.Key_No + " = 'Ferfi' ORDER BY " + DbConstants.Szlalom.Database_Table
					+ "." + DbConstants.Szlalom.Key_VIdo + " LIMIT 10");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(rs.getInt(DbConstants.Szlalom.Key_Rajtszam));
			}

			int i = 0;
			if (lista.size() > 9) {
				i = 0;
				while (i < 10) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 8: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 9: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 7) {
				i = 0;
				while (i < 8) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 5) {
				i = 0;
				while (i < 6) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 3) {
				i = 0;
				while (i < 4) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3
								+ " SET " + DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					}
				}
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortGyorsulas150aDonto() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + " FROM " + DbConstants.Gyorsulas.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " AND " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + " = '150a' AND " + DbConstants.Versenyzo.Database_Table
					+ "." + DbConstants.Versenyzo.Key_No + " = 'Ferfi' ORDER BY " + DbConstants.Gyorsulas.Database_Table
					+ "." + DbConstants.Gyorsulas.Key_LIdo + " LIMIT 10");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(rs.getInt(DbConstants.Gyorsulas.Key_Rajtszam));
			}

			int i = 0;
			if (lista.size() > 9) {
				i = 0;
				while (i < 10) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 8: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 9: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 7) {
				i = 0;
				while (i < 8) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 5) {
				i = 0;
				while (i < 6) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 3) {
				i = 0;
				while (i < 4) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					}
				}
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortGyorsulas150fDonto() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + " FROM " + DbConstants.Gyorsulas.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Gyorsulas.Database_Table + "."
					+ DbConstants.Gyorsulas.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " AND " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + " = '150f' AND " + DbConstants.Versenyzo.Database_Table
					+ "." + DbConstants.Versenyzo.Key_No + " = 'Ferfi' ORDER BY " + DbConstants.Gyorsulas.Database_Table
					+ "." + DbConstants.Gyorsulas.Key_LIdo + " LIMIT 10");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(rs.getInt(DbConstants.Gyorsulas.Key_Rajtszam));
			}

			int i = 0;
			if (lista.size() > 9) {
				i = 0;
				while (i < 10) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 8: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 9: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 7) {
				i = 0;
				while (i < 8) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 5) {
				i = 0;
				while (i < 6) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 3) {
				i = 0;
				while (i < 4) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3
								+ " SET " + DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					}
				}
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortVeteranDonto() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			connect();

			stmt = connection.prepareStatement("SELECT " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " FROM " + DbConstants.Szlalom.Database_Table + ", "
					+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.Szlalom.Database_Table + "."
					+ DbConstants.Szlalom.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Rajtszam + " AND " + DbConstants.Versenyzo.Database_Table + "."
					+ DbConstants.Versenyzo.Key_Kategoria + " = 'veteran' AND " + DbConstants.Versenyzo.Database_Table
					+ "." + DbConstants.Versenyzo.Key_No + " = 'Ferfi' ORDER BY " + DbConstants.Szlalom.Database_Table
					+ "." + DbConstants.Szlalom.Key_VIdo + " LIMIT 10");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(rs.getInt(DbConstants.Szlalom.Key_Rajtszam));
			}

			// System.out.println(lista.size());

			int i = 0;
			if (lista.size() > 9) {
				i = 0;
				while (i < 10) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 8: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 9: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 7) {
				i = 0;
				while (i < 8) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 6");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 7");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 8");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 6: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 7: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 5");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 5) {
				i = 0;
				while (i < 6) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 4: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					case 5: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;

						break;
					}
					}
				}
			} else if (lista.size() > 3) {
				i = 0;
				while (i < 4) {
					switch (i) {
					case 0: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 4");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 1: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 2");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 2: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 1");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					case 3: {
						stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3
								+ " SET " + DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID
								+ " = 3");
						stmt.setInt(1, lista.get(i));
						stmt.execute();
						i++;
						break;
					}
					}
				}
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Dontos> selectDonto(int kategoria, int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();

		switch (kategoria) {
		case 0: {
			lista = selectSzlalom150a(fordulo);
			break;
		}
		case 1: {
			lista = selectSzlalom150f(fordulo);
			break;
		}
		case 2: {
			lista = selectGyorsulas150a(fordulo);
			break;
		}
		case 3: {
			lista = selectGyorsulas150f(fordulo);
			break;
		}
		case 4: {
			lista = selectVeteran(fordulo);
		}
		}

		return lista;
	}

	public ArrayList<Dontos> selectSzlalom150a(int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();
		Dontos d;
		try {
			connect();
			ResultSet rs = null;

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150a1 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150a1
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150a1 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150a1 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150a1 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150a1 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150a2 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150a2
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150a2 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150a2 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150a2 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150a2 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150a3 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150a3
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150a3 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150a3 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150a3 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150a3 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150a4 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150a4
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150a4 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150a4 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150a4 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150a4 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			}

			while (rs.next()) {
				d = new Dontos();
				d.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				d.setRajt(rs.getInt(DbConstants.SzlalomTop10.Key_Rajtszam));
				d.setNyert(rs.getInt(DbConstants.SzlalomTop10.Key_Nyert));
				lista.add(d);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Dontos> selectSzlalom150f(int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();
		Dontos d;
		try {
			connect();
			ResultSet rs = null;

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150f1 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150f1
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150f1 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150f1 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150f1 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150f1 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150f2 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150f2
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150f2 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150f2 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150f2 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150f2 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150f3 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150f3
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150f3 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150f3 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150f3 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150f3 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("Select " + DbConstants.SzlalomTop10.Database_Table150f4 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + ", " + DbConstants.SzlalomTop10.Database_Table150f4
						+ "." + DbConstants.SzlalomTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.SzlalomTop10.Database_Table150f4 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE "
						+ DbConstants.SzlalomTop10.Database_Table150f4 + "." + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Rajtszam
						+ " GROUP BY " + DbConstants.SzlalomTop10.Database_Table150f4 + "."
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " ORDER BY "
						+ DbConstants.SzlalomTop10.Database_Table150f4 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			}

			while (rs.next()) {
				d = new Dontos();
				d.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				d.setRajt(rs.getInt(DbConstants.SzlalomTop10.Key_Rajtszam));
				d.setNyert(rs.getInt(DbConstants.SzlalomTop10.Key_Nyert));
				lista.add(d);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Dontos> selectGyorsulas150a(int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();
		Dontos d;
		try {
			connect();
			ResultSet rs = null;

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150a1 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150a1 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150a1 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150a1 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150a1 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150a1 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150a2 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150a2 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150a2 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150a2 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150a2 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150a2 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150a3 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150a3 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150a3 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150a3 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150a3 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150a3 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150a4 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150a4 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150a4 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150a4 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150a4 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150a4 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			}

			while (rs.next()) {
				d = new Dontos();
				d.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				d.setRajt(rs.getInt(DbConstants.GyorsulasTop10.Key_Rajtszam));
				d.setNyert(rs.getInt(DbConstants.GyorsulasTop10.Key_Nyert));
				lista.add(d);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Dontos> selectGyorsulas150f(int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();
		Dontos d;
		try {
			connect();
			ResultSet rs = null;

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150f1 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150f1 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150f1 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150f1 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150f1 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150f1 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150f2 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150f2 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150f2 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150f2 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150f2 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150f2 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150f3 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150f3 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150f3 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150f3 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150f3 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150f3 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("Select " + DbConstants.GyorsulasTop10.Database_Table150f4 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + ", "
						+ DbConstants.GyorsulasTop10.Database_Table150f4 + "." + DbConstants.GyorsulasTop10.Key_Nyert
						+ ", " + DbConstants.Versenyzo.Database_Table + "." + DbConstants.Versenyzo.Key_Nev + " FROM "
						+ DbConstants.GyorsulasTop10.Database_Table150f4 + ", " + DbConstants.Versenyzo.Database_Table
						+ " WHERE " + DbConstants.GyorsulasTop10.Database_Table150f4 + "."
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.GyorsulasTop10.Database_Table150f4 + "." + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.GyorsulasTop10.Database_Table150f4 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			}

			while (rs.next()) {
				d = new Dontos();
				d.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				d.setRajt(rs.getInt(DbConstants.GyorsulasTop10.Key_Rajtszam));
				d.setNyert(rs.getInt(DbConstants.GyorsulasTop10.Key_Nyert));
				lista.add(d);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Dontos> selectVeteran(int fordulo) {
		ArrayList<Dontos> lista = new ArrayList<>();
		Dontos d;
		try {
			connect();
			ResultSet rs = null;

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("Select " + DbConstants.VeteranTop10.Database_Table1 + "."
						+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Database_Table1 + "."
						+ DbConstants.VeteranTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.VeteranTop10.Database_Table1 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.VeteranTop10.Database_Table1
						+ "." + DbConstants.VeteranTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table
						+ "." + DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.VeteranTop10.Database_Table1 + "." + DbConstants.VeteranTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.VeteranTop10.Database_Table1 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("Select " + DbConstants.VeteranTop10.Database_Table2 + "."
						+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Database_Table2 + "."
						+ DbConstants.VeteranTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.VeteranTop10.Database_Table2 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.VeteranTop10.Database_Table2
						+ "." + DbConstants.VeteranTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table
						+ "." + DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.VeteranTop10.Database_Table2 + "." + DbConstants.VeteranTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.VeteranTop10.Database_Table2 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("Select " + DbConstants.VeteranTop10.Database_Table3 + "."
						+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Database_Table3 + "."
						+ DbConstants.VeteranTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.VeteranTop10.Database_Table3 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.VeteranTop10.Database_Table3
						+ "." + DbConstants.VeteranTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table
						+ "." + DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.VeteranTop10.Database_Table3 + "." + DbConstants.VeteranTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.VeteranTop10.Database_Table3 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("Select " + DbConstants.VeteranTop10.Database_Table4 + "."
						+ DbConstants.VeteranTop10.Key_Rajtszam + ", " + DbConstants.VeteranTop10.Database_Table4 + "."
						+ DbConstants.VeteranTop10.Key_Nyert + ", " + DbConstants.Versenyzo.Database_Table + "."
						+ DbConstants.Versenyzo.Key_Nev + " FROM " + DbConstants.VeteranTop10.Database_Table4 + ", "
						+ DbConstants.Versenyzo.Database_Table + " WHERE " + DbConstants.VeteranTop10.Database_Table4
						+ "." + DbConstants.VeteranTop10.Key_Rajtszam + " = " + DbConstants.Versenyzo.Database_Table
						+ "." + DbConstants.Versenyzo.Key_Rajtszam + " GROUP BY "
						+ DbConstants.VeteranTop10.Database_Table4 + "." + DbConstants.VeteranTop10.Key_Rajtszam
						+ " ORDER BY " + DbConstants.VeteranTop10.Database_Table4 + "." + DbConstants.Key_ID);

				rs = stmt.executeQuery();
				break;
			}
			}

			while (rs.next()) {
				d = new Dontos();
				d.setNev(rs.getString(DbConstants.Versenyzo.Key_Nev));
				d.setRajt(rs.getInt(DbConstants.VeteranTop10.Key_Rajtszam));
				d.setNyert(rs.getInt(DbConstants.VeteranTop10.Key_Nyert));
				lista.add(d);
			}

			rs.close();
			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void updateDonto(int kategoria, int fordulo, int rajt, int nyert) {
		switch (kategoria) {
		case 0: {
			updateSzlalomDonto150a(fordulo, rajt, nyert);
			break;
		}
		case 1: {
			updateSzlalomDonto150f(fordulo, rajt, nyert);
			break;
		}
		case 2: {
			updateGyorsulasDonto150a(fordulo, rajt, nyert);
			break;
		}
		case 3: {
			updateGyorsulasDonto150f(fordulo, rajt, nyert);
			break;
		}
		case 4: {
			updateVeteranDonto(fordulo, rajt, nyert);
			break;
		}
		}
	}

	public void updateSzlalomDonto150a(int fordulo, int rajt, int nyert) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a4 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			}

			stmt.setInt(1, nyert);
			stmt.setInt(2, rajt);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSzlalomDonto150f(int fordulo, int rajt, int nyert) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f4 + " SET "
						+ DbConstants.SzlalomTop10.Key_Nyert + " = ? WHERE " + DbConstants.SzlalomTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			}

			stmt.setInt(1, nyert);
			stmt.setInt(2, rajt);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGyorsulasDonto150a(int fordulo, int rajt, int nyert) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a4 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			}

			stmt.setInt(1, nyert);
			stmt.setInt(2, rajt);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGyorsulasDonto150f(int fordulo, int rajt, int nyert) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f4 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Nyert + " = ? WHERE " + DbConstants.GyorsulasTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			}

			stmt.setInt(1, nyert);
			stmt.setInt(2, rajt);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateVeteranDonto(int fordulo, int rajt, int nyert) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1 + " SET "
						+ DbConstants.VeteranTop10.Key_Nyert + " = ? WHERE " + DbConstants.VeteranTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2 + " SET "
						+ DbConstants.VeteranTop10.Key_Nyert + " = ? WHERE " + DbConstants.VeteranTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3 + " SET "
						+ DbConstants.VeteranTop10.Key_Nyert + " = ? WHERE " + DbConstants.VeteranTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			case 3: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table4 + " SET "
						+ DbConstants.VeteranTop10.Key_Nyert + " = ? WHERE " + DbConstants.VeteranTop10.Key_Rajtszam
						+ " = ?");
				break;
			}
			}

			stmt.setInt(1, nyert);
			stmt.setInt(2, rajt);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nextDonto(int kategoria, int fordulo, int hely, int rajt) {
		fordulo--;
		switch (kategoria) {
		case 0: {
			nextSzlalomDonto150a(fordulo, hely, rajt);
			break;
		}
		case 1: {
			nextSzlalomDonto150f(fordulo, hely, rajt);
			break;
		}
		case 2: {
			nextGyorsulasDonto150a(fordulo, hely, rajt);
			break;
		}
		case 3: {
			nextGyorsulasDonto150f(fordulo, hely, rajt);
			break;
		}
		case 4: {
			nextVeteranDonto(fordulo, hely, rajt);
			break;
		}
		}
	}

	public void nextSzlalomDonto150a(int fordulo, int hely, int rajt) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a4 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			}

			stmt.setInt(1, rajt);
			stmt.setInt(2, hely);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nextSzlalomDonto150f(int fordulo, int hely, int rajt) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f4 + " SET "
						+ DbConstants.SzlalomTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			}

			stmt.setInt(1, rajt);
			stmt.setInt(2, hely);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nextGyorsulasDonto150a(int fordulo, int hely, int rajt) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a4 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			}

			stmt.setInt(1, rajt);
			stmt.setInt(2, hely);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nextGyorsulasDonto150f(int fordulo, int hely, int rajt) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f4 + " SET "
						+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			}

			stmt.setInt(1, rajt);
			stmt.setInt(2, hely);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nextVeteranDonto(int fordulo, int hely, int rajt) {
		try {
			connect();

			switch (fordulo) {
			case 0: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2 + " SET "
						+ DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 1: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3 + " SET "
						+ DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			case 2: {
				stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table4 + " SET "
						+ DbConstants.VeteranTop10.Key_Rajtszam + " = ? WHERE " + DbConstants.Key_ID + " = ?");
				break;
			}
			}

			stmt.setInt(1, rajt);
			stmt.setInt(2, hely);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String table, int num) {
		try {
			connect();
			stmt = connection
					.prepareStatement("DELETE FROM " + table + " WHERE " + DbConstants.Versenyzo.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAdat(int num) {
		try {
			connect();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Versenyzo.Database_Table + " WHERE "
					+ DbConstants.Versenyzo.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Potkocsis.Database_Table + " WHERE "
					+ DbConstants.Potkocsis.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Erohuzas.Database_Table + " WHERE "
					+ DbConstants.Erohuzas.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Szlalom.Database_Table + " WHERE "
					+ DbConstants.Szlalom.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Gyorsulas.Database_Table + " WHERE "
					+ DbConstants.Gyorsulas.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Abszolut.Database_Table + " WHERE "
					+ DbConstants.Abszolut.Key_Rajtszam + " = ?");
			stmt.setInt(1, num);
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void emptyDB() {
		try {
			connect();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Versenyzo.Database_Table);
			stmt.execute();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Potkocsis.Database_Table);
			stmt.execute();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Szlalom.Database_Table);
			stmt.execute();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Gyorsulas.Database_Table);
			stmt.execute();
			stmt = connection.prepareStatement("DELETE FROM " + DbConstants.Abszolut.Database_Table);
			stmt.execute();

			/**
			 * Szlalom döntõ 150a
			 */
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a1 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a2 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a3 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150a4 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();

			/**
			 * Szlalom döntõ 150f
			 */
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f1 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f2 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f3 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.SzlalomTop10.Database_Table150f4 + " SET "
					+ DbConstants.SzlalomTop10.Key_Rajtszam + " = 0, " + DbConstants.SzlalomTop10.Key_Nyert + " = 0");
			stmt.execute();

			/**
			 * Szlalom veterán döntõ
			 */
			stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table1 + " SET "
					+ DbConstants.VeteranTop10.Key_Rajtszam + " = 0, " + DbConstants.VeteranTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table2 + " SET "
					+ DbConstants.VeteranTop10.Key_Rajtszam + " = 0, " + DbConstants.VeteranTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table3 + " SET "
					+ DbConstants.VeteranTop10.Key_Rajtszam + " = 0, " + DbConstants.VeteranTop10.Key_Nyert + " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.VeteranTop10.Database_Table4 + " SET "
					+ DbConstants.VeteranTop10.Key_Rajtszam + " = 0, " + DbConstants.VeteranTop10.Key_Nyert + " = 0");
			stmt.execute();

			/**
			 * Gyorsulás döntõ 150a
			 */
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a1 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a2 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a3 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150a4 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();

			/**
			 * Gyorsulás döntõ 150f
			 */
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f1 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f2 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f3 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE " + DbConstants.GyorsulasTop10.Database_Table150f4 + " SET "
					+ DbConstants.GyorsulasTop10.Key_Rajtszam + " = 0, " + DbConstants.GyorsulasTop10.Key_Nyert
					+ " = 0");
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void calcAbszolut() {
		// TODO
		lastposAbszolut();
		try {
			Abszolut a;
			int helyezes = 1;
			int offset = 0;
			int offsetmin = 0;
			int j = 0;
			ArrayList<Abszolut> lista = selectAbsolut();
			Map<Integer, Abszolut> map = new HashMap<Integer, Abszolut>();
			ResultSet rs = null;

			for (int i = 0; i < lista.size(); i++) {
				map.put(lista.get(i).getRajt(), lista.get(i));
			}

			connect();
			// POTKOCSI 150 alatt
			stmt = connection.prepareStatement("SELECT potkocsi.rajtszam, adatok.kategoria, adatok.no, "
					+ "potkocsi.vegleges FROM potkocsi, adatok WHERE adatok.kategoria = '150a'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = potkocsi.rajtszam ORDER BY potkocsi.vegleges");
			rs = stmt.executeQuery();
			while (rs.next()) {
				a = map.get(rs.getInt("rajtszam"));
				a.setPotkocsis(helyezes++);
				map.put(a.getRajt(), a);
			}
			rs.close();

			// POTKOCSI 150 felett
			stmt = connection.prepareStatement("SELECT potkocsi.rajtszam, adatok.kategoria, adatok.no, "
					+ "potkocsi.vegleges FROM potkocsi, adatok WHERE adatok.kategoria = '150f'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = potkocsi.rajtszam ORDER BY potkocsi.vegleges");
			rs = stmt.executeQuery();
			helyezes = 1;
			while (rs.next()) {
				a = map.get(rs.getInt("rajtszam"));
				a.setPotkocsis(helyezes++);
				map.put(a.getRajt(), a);
			}
			rs.close();

			// SZLALOM SELEJTEZÕ 150 alatt
			if (RegPanel.szl150a > 9) {
				helyezes = 11;
				offsetmin = 9;
			} else if (RegPanel.szl150a > 7) {
				helyezes = 9;
				offsetmin = 7;
			} else if (RegPanel.szl150a > 5) {
				helyezes = 7;
				offsetmin = 5;
			} else if (RegPanel.szl150a > 3) {
				helyezes = 5;
				offsetmin = 3;
			}
			stmt = connection.prepareStatement("SELECT szlalom.rajtszam, adatok.kategoria, adatok.no, "
					+ "szlalom.vegleges FROM szlalom, adatok WHERE adatok.kategoria = '150a'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = szlalom.rajtszam ORDER BY szlalom.vegleges");
			rs = stmt.executeQuery();
			// helyezes = 11;
			while (rs.next()) {
				if (offset > offsetmin) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
				offset++;
			}
			rs.close();

			// SZLALOM SELEJTEZÕ 150 felett
			if (RegPanel.szl150f > 9) {
				helyezes = 11;
				offsetmin = 9;
			} else if (RegPanel.szl150f > 7) {
				helyezes = 9;
				offsetmin = 7;
			} else if (RegPanel.szl150f > 5) {
				helyezes = 7;
				offsetmin = 5;
			} else if (RegPanel.szl150f > 3) {
				helyezes = 5;
				offsetmin = 3;
			}
			stmt = connection.prepareStatement("SELECT szlalom.rajtszam, adatok.kategoria, adatok.no, "
					+ "szlalom.vegleges FROM szlalom, adatok WHERE adatok.kategoria = '150f'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = szlalom.rajtszam ORDER BY szlalom.vegleges");
			rs = stmt.executeQuery();
			// helyezes = 11;
			offset = 0;
			while (rs.next()) {
				if (offset > offsetmin) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
				offset++;
			}
			rs.close();

			// GYORSULAS SELEJTEZÕ 150 alatt
			if (RegPanel.gy150a > 9) {
				helyezes = 11;
				offsetmin = 9;
			} else if (RegPanel.gy150a > 7) {
				helyezes = 9;
				offsetmin = 7;
			} else if (RegPanel.gy150a > 5) {
				helyezes = 7;
				offsetmin = 5;
			} else if (RegPanel.gy150a > 3) {
				helyezes = 5;
				offsetmin = 3;
			}
			stmt = connection.prepareStatement("SELECT gyorsulas.rajtszam, adatok.kategoria, adatok.no, "
					+ "gyorsulas.legjobb FROM gyorsulas, adatok WHERE adatok.kategoria = '150a'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = gyorsulas.rajtszam ORDER BY gyorsulas.legjobb");
			rs = stmt.executeQuery();
			// helyezes = 11;
			offset = 0;
			while (rs.next()) {
				if (offset > offsetmin) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
				offset++;
			}
			rs.close();

			// GYORSULAS SELEJTEZÕ 150 felett
			if (RegPanel.gy150f > 9) {
				helyezes = 11;
				offsetmin = 9;
			} else if (RegPanel.gy150f > 7) {
				helyezes = 9;
				offsetmin = 7;
			} else if (RegPanel.gy150f > 5) {
				helyezes = 7;
				offsetmin = 5;
			} else if (RegPanel.gy150f > 3) {
				helyezes = 5;
				offsetmin = 3;
			}
			stmt = connection.prepareStatement("SELECT gyorsulas.rajtszam, adatok.kategoria, adatok.no, "
					+ "gyorsulas.legjobb FROM gyorsulas, adatok WHERE adatok.kategoria = '150f'"
					+ " AND adatok.no = 'Ferfi' AND adatok.rajtszam = gyorsulas.rajtszam ORDER BY gyorsulas.legjobb");
			rs = stmt.executeQuery();
			// helyezes = 11;
			offset = 0;
			while (rs.next()) {
				if (offset > offsetmin) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
				offset++;
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 alatt FORDULO 1
			stmt = connection
					.prepareStatement("SELECT sz_kor_1_150_a.rajtszam,sz_kor_1_150_a.nyert, szlalom.vegleges FROM "
							+ "sz_kor_1_150_a,szlalom WHERE sz_kor_1_150_a.rajtszam =szlalom.rajtszam ORDER BY vegleges");
			rs = stmt.executeQuery();
			helyezes = 7;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 alatt FORDULO 2
			stmt = connection
					.prepareStatement("SELECT sz_kor_2_150_a.rajtszam,sz_kor_2_150_a.nyert, szlalom.vegleges FROM "
							+ "sz_kor_2_150_a,szlalom WHERE sz_kor_2_150_a.rajtszam =szlalom.rajtszam ORDER BY vegleges");
			rs = stmt.executeQuery();
			helyezes = 5;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 alatt FORDULO 4
			stmt = connection.prepareStatement("SELECT * FROM sz_kor_4_150_a ORDER BY _id");
			rs = stmt.executeQuery();
			helyezes = 1;
			j = 0;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					System.out.println(helyezes);
					a.setSzlalom(helyezes + 1);
					map.put(a.getRajt(), a);
				} else if (rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes);
					map.put(a.getRajt(), a);
				}
				if (j % 2 == 1)
					helyezes += 2;
				j++;
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 felett FORDULO 1
			stmt = connection
					.prepareStatement("SELECT sz_kor_1_150_f.rajtszam,sz_kor_1_150_f.nyert, szlalom.vegleges FROM "
							+ "sz_kor_1_150_f,szlalom WHERE sz_kor_1_150_f.rajtszam =szlalom.rajtszam ORDER BY vegleges");
			rs = stmt.executeQuery();
			helyezes = 7;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 felett FORDULO 2
			stmt = connection
					.prepareStatement("SELECT sz_kor_2_150_f.rajtszam,sz_kor_2_150_f.nyert, szlalom.vegleges FROM "
							+ "sz_kor_2_150_f,szlalom WHERE sz_kor_2_150_f.rajtszam =szlalom.rajtszam ORDER BY vegleges");
			rs = stmt.executeQuery();
			helyezes = 5;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// SZLALOM DÖNTÕ 150 felett FORDULO 4
			stmt = connection.prepareStatement("SELECT * FROM sz_kor_4_150_f ORDER BY _id");
			rs = stmt.executeQuery();
			helyezes = 1;
			j = 0;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes + 1);
					map.put(a.getRajt(), a);
				} else if (rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setSzlalom(helyezes);
					map.put(a.getRajt(), a);
				}
				if (j % 2 == 1)
					helyezes += 2;
				j++;
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 alatt FORDULO 1
			stmt = connection
					.prepareStatement("SELECT gy_kor_1_150_a.rajtszam,gy_kor_1_150_a.nyert, gyorsulas.legjobb FROM "
							+ "gy_kor_1_150_a,gyorsulas WHERE gy_kor_1_150_a.rajtszam =gyorsulas.rajtszam ORDER BY legjobb");
			rs = stmt.executeQuery();
			helyezes = 7;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 alatt FORDULO 2
			stmt = connection
					.prepareStatement("SELECT gy_kor_2_150_a.rajtszam,gy_kor_2_150_a.nyert, gyorsulas.legjobb FROM "
							+ "gy_kor_2_150_a,gyorsulas WHERE gy_kor_2_150_a.rajtszam =gyorsulas.rajtszam ORDER BY legjobb");
			rs = stmt.executeQuery();
			helyezes = 5;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 alatt FORDULO 4
			stmt = connection.prepareStatement("SELECT * FROM gy_kor_4_150_a ORDER BY _id");
			rs = stmt.executeQuery();
			helyezes = 1;
			j = 0;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes + 1);
					map.put(a.getRajt(), a);
				} else if (rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes);
					map.put(a.getRajt(), a);
				}
				if (j % 2 == 1)
					helyezes += 2;
				j++;
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 felett FORDULO 1
			stmt = connection
					.prepareStatement("SELECT gy_kor_1_150_f.rajtszam,gy_kor_1_150_f.nyert, gyorsulas.legjobb FROM "
							+ "gy_kor_1_150_f,gyorsulas WHERE gy_kor_1_150_f.rajtszam =gyorsulas.rajtszam ORDER BY legjobb");
			rs = stmt.executeQuery();
			helyezes = 7;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 felett FORDULO 2
			stmt = connection
					.prepareStatement("SELECT gy_kor_2_150_f.rajtszam,gy_kor_2_150_f.nyert, gyorsulas.legjobb FROM "
							+ "gy_kor_2_150_f,gyorsulas WHERE gy_kor_2_150_f.rajtszam =gyorsulas.rajtszam ORDER BY legjobb");
			rs = stmt.executeQuery();
			helyezes = 5;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes++);
					map.put(a.getRajt(), a);
				}
			}
			rs.close();

			// GYORSULAS DÖNTÕ 150 felett FORDULO 4
			stmt = connection.prepareStatement("SELECT * FROM gy_kor_4_150_f ORDER BY _id");
			rs = stmt.executeQuery();
			helyezes = 1;
			j = 0;
			while (rs.next()) {
				if (rs.getInt("nyert") < 2 && rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes + 1);
					map.put(a.getRajt(), a);
				} else if (rs.getInt("rajtszam") != 0) {
					a = map.get(rs.getInt("rajtszam"));
					a.setGyorsulas(helyezes);
					map.put(a.getRajt(), a);
				}
				if (j % 2 == 1)
					helyezes += 2;
				j++;
			}
			rs.close();

			for (int i = 0; i < lista.size(); i++) {
				a = map.get(lista.get(i).getRajt());
				// lista.remove(i);
				// lista.add(i, a);
				System.out.println("absz számolás " + a.getPotkocsis() + " " + a.getSzlalom() + " " + a.getGyorsulas());
				updateAbszolut(a.getRajt(), a.getNev(), a.getKategoria(), a.getPotkocsis(), a.getSzlalom(),
						a.getGyorsulas());
			}

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void lastposAbszolut() {
		// TODO
		try {
			connect();
			stmt = connection.prepareStatement("UPDATE osszesitett SET potkocsis = " + (RegPanel.pot150a + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE potkocsis='false' AND kategoria='150a')");
			stmt.execute();

			stmt = connection.prepareStatement("UPDATE osszesitett SET potkocsis = " + (RegPanel.pot150f + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE potkocsis='false' AND kategoria='150f')");
			stmt.execute();

			stmt = connection.prepareStatement("UPDATE osszesitett SET szlalom = " + (RegPanel.szl150a + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE szlalom='false' AND kategoria='150a')");
			stmt.execute();

			stmt = connection.prepareStatement("UPDATE osszesitett SET szlalom = " + (RegPanel.szl150f + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE szlalom='false' AND kategoria='150f')");
			stmt.execute();

			stmt = connection.prepareStatement("UPDATE osszesitett SET gyorsulas = " + (RegPanel.gy150a + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE gyorsulas='false' AND kategoria='150a')");
			stmt.execute();

			stmt = connection.prepareStatement("UPDATE osszesitett SET gyorsulas = " + (RegPanel.gy150f + 1)
					+ " WHERE rajtszam IN (SELECT rajtszam FROM adatok WHERE gyorsulas='false' AND kategoria='150f')");
			stmt.execute();

			stmt.close();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
