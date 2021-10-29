package timing;

import java.io.IOException;
import java.util.Random;

import traktoros.Main;

public class Display extends Thread {
	Random r = new Random();
	int rand = r.nextInt(2 - 0) + 0;
	boolean arrived = false;
	int maxcycle = 1;
	String A, B;
	boolean earlyA, earlyB;

	public Display(String A, String B, boolean earlyA, boolean earlyB) {
		this.A = A;
		this.B = B;
		this.earlyA = earlyA;
		this.earlyB = earlyB;
	}

	public void run() {
		try {
			Main.sn.setKijelzoThread(this);

			int i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				if(!earlyA){
					Main.sn.sendmsg(A, Main.sn.getDisplay());
				} else {
					Main.sn.sendmsg("AK\n", Main.sn.getDisplay());
				}
				
				Thread.sleep(10);
				i++;
			}

			i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				if(!earlyB){
					Main.sn.sendmsg(B, Main.sn.getDisplay());
				} else {
					Main.sn.sendmsg("BK\n", Main.sn.getDisplay());
				}
				
				Thread.sleep(10);
				i++;
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setArrived(boolean state) {
		arrived = state;
	}
}
