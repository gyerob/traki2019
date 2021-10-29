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
		
		splash.setMessage("Adatb�zis l�trehoz�sa");
		new DbFunctions().createTables();

		splash.setMessage("Adatok beolvas�sa");
		adatok = new Adatok();

		sn = new StartNetworkUDP();

		od = new ObstructionDetection();

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				splash.setMessage("Ablak bet�lt�se");
				mf = new MainFrame();
				mf.setVisible(true);

				splash.setMessage("H�l�zati kommunik�ci� ind�t�sa");
				sn.start();

				splash.setMessage("Megszak�t�s �rz�kel�s ind�t�sa");
				od.start();
			}
		});

		splash.setVisible(false);
	}
}
