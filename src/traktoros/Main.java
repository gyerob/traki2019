package traktoros;

import datastorage.DbFunctions;
import network.StartNetworkUDP;
import timing.ObstructionDetection;
import view.MainFrame;
import view.Splash;

public class Main {
	public static StartNetworkUDP sn;
	public static MainFrame mf;
	public static ObstructionDetection od;
	public static Adatok adatok;
	public static Splash splash;

	public Main() {
	}

	public static void main(String args[]) {
		splash = new Splash();
		splash.setVisible(true);
		
		splash.setMessage("Adatbázis létrehozása");
		new DbFunctions().createTables();

		splash.setMessage("Adatok beolvasása");
		adatok = new Adatok();

		sn = new StartNetworkUDP();

		od = new ObstructionDetection();

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				splash.setMessage("Ablak betöltése");
				mf = new MainFrame();
				mf.setVisible(true);

				splash.setMessage("Hálózati kommunikáció indítása");
				sn.start();

				splash.setMessage("Megszakítás érzékelés indítása");
				od.start();
			}
		});

		splash.setVisible(false);
	}
}
