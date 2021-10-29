package timing;

import java.io.IOException;
import java.util.Random;

import traktoros.Main;

public class NextDisplay extends Thread {
	Random r = new Random();
	int rand = r.nextInt(2 - 0) + 0;
	boolean arrived = false;
	int A1, B1, A2, B2;
	int maxcycle = 1;

	public void run() {
		try {
			Main.sn.setKoviKijelzoThread(this);

			String a1, b1, a2, b2;
			a1 = String.format("%02d", A1 % 100);
			b1 = String.format("%02d", B1 % 100);
			a2 = String.format("%02d", A2 % 100);
			b2 = String.format("%02d", B2 % 100);

			int i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				Main.sn.sendmsg("A" + a1 + "\n", Main.sn.getNextdisplay());
				Thread.sleep(10);
				i++;
			}

			i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				Main.sn.sendmsg("B" + b1 + "\n", Main.sn.getNextdisplay());
				Thread.sleep(10);
				i++;
			}

			i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				Main.sn.sendmsg("C" + a2 + "\n", Main.sn.getNextdisplay());
				Thread.sleep(10);
				i++;
			}

			i = 0;
			setArrived(false);
			while (!arrived && i < maxcycle) {
				Main.sn.sendmsg("D" + b2 + "\n", Main.sn.getNextdisplay());
				Thread.sleep(10);
				i++;
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setNumbers(int A1, int B1, int A2, int B2) {
		this.A1 = A1;
		this.B1 = B1;
		this.A2 = A2;
		this.B2 = B2;
	}

	public void setArrived(boolean state) {
		arrived = state;
	}
}
