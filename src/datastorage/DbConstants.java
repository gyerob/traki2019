package datastorage;

public class DbConstants {
	//public static String Database_Path = ".";
	public static String Database_Name = "data.db";
	public static int Database_Version = 1;
	public static String DatabaseDriver = "org.sqlite.JDBC";
	public static String DatabaseType = "jdbc:sqlite:";
	public static String Key_ID = "_id";

	public static class Abszolut {
		public static final String Database_Table = "osszesitett";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Nev = "nev";
		public static final String Key_Kategoria = "kategoria";
		public static final String Key_Potkocsis = "potkocsis";
		public static final String Key_Szlalom = "szlalom";
		public static final String Key_Gyorsulas = "gyorsulas";
		public static final String Key_Osszes = "osszes";

		public static final String Database_Drop = "drop table if exists " + Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table + " ( "
				+ Key_ID 			+ " integer primary key autoincrement, "
				+ Key_Rajtszam 		+ " integer, "
				+ Key_Nev			+ " text, "
				+ Key_Kategoria		+ " text, "
				+ Key_Potkocsis		+ " integer, "
				+ Key_Szlalom		+ " integer, "
				+ Key_Gyorsulas 	+ " integer, "
				+ Key_Osszes	 	+ " real" + "); ";
	}
	
	public static class Versenyzo {
		public static final String Database_Table = "adatok";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Nev = "nev";
		public static final String Key_Varos = "varos";
		public static final String Key_No = "no";
		public static final String Key_Osztozik = "osztozik";
		public static final String Key_Kategoria = "kategoria";
		public static final String Key_Potkocsis = "potkocsis";
		public static final String Key_Szlalom = "szlalom";
		public static final String Key_Gyorsulas = "gyorsulas";
		public static final String Key_Erohuzas = "erohuzas";

		public static final String Database_Drop = "drop table if exists " + Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table + " ( "
				+ Key_ID 			+ " integer primary key autoincrement, "
				+ Key_Rajtszam 		+ " integer, "
				+ Key_Nev			+ " text, "
				+ Key_Varos			+ " text, "
				+ Key_No			+ " text, "
				+ Key_Osztozik 		+ " integer, "
				+ Key_Kategoria		+ " text, "
				+ Key_Potkocsis		+ " text, "
				+ Key_Szlalom		+ " text, "
				+ Key_Gyorsulas 	+ " text, "
				+ Key_Erohuzas	 	+ " text" + "); ";
		
	}

	public static class Potkocsis {
		public static final String Database_Table = "potkocsi";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Ido = "ido";
		public static final String Key_Hiba = "hiba";
		public static final String Key_VIdo = "vegleges";

		public static final String Database_Drop = "drop table if exists "
				+ Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table 	+ " ( "
				+ Key_ID			+ " integer primary key autoincrement, "
				+ Key_Rajtszam		+ " integer, "
				+ Key_Ido			+ " text, "
				+ Key_Hiba			+ " text, "
				+ Key_VIdo			+ " text" + "); ";
	}
	
	public static class Erohuzas {
		public static final String Database_Table = "erohuzas";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Ido = "ido";
		public static final String Key_Hiba = "hiba";
		public static final String Key_VIdo = "vegleges";

		public static final String Database_Drop = "drop table if exists "
				+ Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table 	+ " ( "
				+ Key_ID			+ " integer primary key autoincrement, "
				+ Key_Rajtszam		+ " integer, "
				+ Key_Ido			+ " text, "
				+ Key_Hiba			+ " text, "
				+ Key_VIdo			+ " text" + "); ";
	}

	public static class Szlalom {
		public static final String Database_Table = "szlalom";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Ido = "ido";
		public static final String Key_Hiba = "hiba";
		public static final String Key_VIdo = "vegleges";

		public static final String Database_Drop = "drop table if exists "
				+ Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table 	+ " ( "
				+ Key_ID			+ " integer primary key autoincrement, "
				+ Key_Rajtszam		+ " integer, "
				+ Key_Ido			+ " text, "
				+ Key_Hiba			+ " text, "
				+ Key_VIdo 			+ " text" + "); ";
	}

	public static class SzlalomTop10 {
		public static final String Database_Table150f1 = "sz_kor_1_150_f";
		public static final String Database_Table150f2 = "sz_kor_2_150_f";
		public static final String Database_Table150f3 = "sz_kor_3_150_f";
		public static final String Database_Table150f4 = "sz_kor_4_150_f";
		public static final String Database_Table150a1 = "sz_kor_1_150_a";
		public static final String Database_Table150a2 = "sz_kor_2_150_a";
		public static final String Database_Table150a3 = "sz_kor_3_150_a";
		public static final String Database_Table150a4 = "sz_kor_4_150_a";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Nyert = "nyert";

		public static final String Database_Create1f = "create table if not exists "
				+ Database_Table150f1	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " 
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create2f = "create table if not exists "
				+ Database_Table150f2	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " 
				+ Key_Nyert				+ " integer" + "); ";
		public static final String Database_Create3f = "create table if not exists "
				+ Database_Table150f3	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert				+ " integer" + "); ";
		public static final String Database_Create4f = "create table if not exists "
				+ Database_Table150f4	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert				+ " integer" + "); ";

		public static final String Database_Create1a = "create table if not exists "
				+ Database_Table150a1	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " + Key_Nyert + " integer" + "); ";
		public static final String Database_Create2a = "create table if not exists "
				+ Database_Table150a2	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " + Key_Nyert + " integer" + "); ";
		public static final String Database_Create3a = "create table if not exists "
				+ Database_Table150a3	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " + Key_Nyert + " integer" + "); ";
		public static final String Database_Create4a = "create table if not exists "
				+ Database_Table150a4	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " + Key_Nyert + " integer" + "); ";
	}
	
	public static class VeteranTop10 {
		public static final String Database_Table1 = "v_kor_1_150";
		public static final String Database_Table2 = "v_kor_2_150";
		public static final String Database_Table3 = "v_kor_3_150";
		public static final String Database_Table4 = "v_kor_4_150";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Nyert = "nyert";

		public static final String Database_Create1 = "create table if not exists "
				+ Database_Table1	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " 
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create2 = "create table if not exists "
				+ Database_Table2	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " 
				+ Key_Nyert				+ " integer" + "); ";
		public static final String Database_Create3 = "create table if not exists "
				+ Database_Table3	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert				+ " integer" + "); ";
		public static final String Database_Create4 = "create table if not exists "
				+ Database_Table4	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert				+ " integer" + "); ";
	}

	public static class Gyorsulas {
		public static final String Database_Table = "gyorsulas";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Ido1 = "ido1";
		public static final String Key_Ido2 = "ido2";
		public static final String Key_LIdo = "legjobb";

		public static final String Database_Drop = "drop table if exists " + Database_Table + "; ";
		public static final String Database_Create = "create table if not exists "
				+ Database_Table	+ " ( "
				+ Key_ID			+ " integer primary key autoincrement, "
				+ Key_Rajtszam		+ " integer, "
				+ Key_Ido1			+ " text, "
				+ Key_Ido2			+ " text, "
				+ Key_LIdo			+ " text" + "); ";
	}

	public static class GyorsulasTop10 {
		public static final String Database_Table150f1 = "gy_kor_1_150_f";
		public static final String Database_Table150f2 = "gy_kor_2_150_f";
		public static final String Database_Table150f3 = "gy_kor_3_150_f";
		public static final String Database_Table150f4 = "gy_kor_4_150_f";
		public static final String Database_Table150a1 = "gy_kor_1_150_a";
		public static final String Database_Table150a2 = "gy_kor_2_150_a";
		public static final String Database_Table150a3 = "gy_kor_3_150_a";
		public static final String Database_Table150a4 = "gy_kor_4_150_a";
		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Nyert = "nyert";

		public static final String Database_Create1f = "create table if not exists "
				+ Database_Table150f1	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create2f = "create table if not exists "
				+ Database_Table150f2	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create3f = "create table if not exists "
				+ Database_Table150f3	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create4f = "create table if not exists "
				+ Database_Table150f4	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, " +
				Key_Nyert 				+ " integer" + "); ";

		public static final String Database_Create1a = "create table if not exists "
				+ Database_Table150a1	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create2a = "create table if not exists "
				+ Database_Table150a2	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create3a = "create table if not exists "
				+ Database_Table150a3	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
		public static final String Database_Create4a = "create table if not exists "
				+ Database_Table150a4	+ " ( "
				+ Key_ID				+ " integer primary key autoincrement, "
				+ Key_Rajtszam			+ " integer, "
				+ Key_Nyert 			+ " integer" + "); ";
	}

	public static class Eredmenyek {
		public static final String Database_TableTrailer150a = "pot_eredmeny_150_a";
		public static final String Database_TableTrailer150f = "pot_eredmeny_150_f";
		public static final String Database_TableSlalom150a = "sz_eredmeny_150_a";
		public static final String Database_TableSlalom150f = "sz_eredmeny_150_f";
		public static final String Database_TableDrag150a = "gy_eredmeny_150_a";
		public static final String Database_TableDrag150f = "gy_eredmeny_150_f";

		public static final String Key_Rajtszam = "rajtszam";
		public static final String Key_Helyezes = "helyezes";

		public static final String Database_CreateT150a = "create table if not exists "
				+ Database_TableTrailer150a	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
		public static final String Database_CreateT150f = "create table if not exists "
				+ Database_TableTrailer150f	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
		public static final String Database_CreateS150a = "create table if not exists "
				+ Database_TableSlalom150a	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
		public static final String Database_CreateS150f = "create table if not exists "
				+ Database_TableSlalom150f	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
		public static final String Database_CreateD150a = "create table if not exists "
				+ Database_TableDrag150a	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
		public static final String Database_CreateD150f = "create table if not exists "
				+ Database_TableDrag150f	+ " ( "
				+ Key_ID					+ " integer primary key autoincrement, "
				+ Key_Rajtszam 				+ " integer, "
				+ Key_Helyezes 				+ " integer" + "); ";
	}
}
