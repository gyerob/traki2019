package timing;

import java.io.IOException;
import java.util.Random;

import traktoros.Main;

public class Lamp extends Thread {
	Random r = new Random();
	int rand = r.nextInt(2 - 0) + 0;
	boolean arrived = false;
	int maxcycle = 1;
	public volatile boolean running = true;

	public void megallit() {
		this.running = false;
	}

	public void run() {
		try {
			if (!Main.sn.getLampaThread().equals(null)) {
				//Main.sn.getLampaThread().interrupt();
				Main.sn.getLampaThread().megallit();
				running = true;
				System.out.println("megallit");
			}
			while (running) {
				Main.sn.setLampaThread(this);

				Main.mf.setLampColor(0);
				
				Main.mf.setElindult(1, 0);
				Main.mf.setElindult(2, 0);

				// Main.sn.sendmsg("D", Main.sn.getController());

				int i = 0;
				setArrived(false);
				while (!arrived && i < maxcycle && running) {
					Main.mf.setLampColor(1);
					Main.sn.sendmsg("A", Main.sn.getController());
					Thread.sleep(10);
					i++;
					// System.out.println(i);
				}
				Thread.sleep((long) (1000 - (i * 10)));

				i = 0;
				setArrived(false);
				while (!arrived && i < maxcycle && running) {
					Main.mf.setLampColor(2);
					Main.sn.sendmsg("B", Main.sn.getController());
					Thread.sleep(10);
					i++;
				}
				Thread.sleep((long) (1000 - (i * 10)));

				i = 0;
				setArrived(false);
				while (!arrived && i < maxcycle && running) {
					Main.mf.setLampColor(3);
					Main.sn.sendmsg("C", Main.sn.getController());
					Thread.sleep(10);
					i++;
				}
				Thread.sleep((long) (1000 - (i * 10) + rand * 1000));

				i = 0;
				setArrived(false);
				while (!arrived && i < maxcycle && running) {
					Main.mf.setLampColor(0);
					Main.sn.sendmsg("D", Main.sn.getController());
					Thread.sleep(10);
					i++;
				}
				running = false;
				/*
				 * Main.sn.sendmsg("A", Main.sn.getController());
				 * Thread.sleep(1000); Main.sn.sendmsg("B",
				 * Main.sn.getController()); Thread.sleep(1000);
				 * Main.sn.sendmsg("C", Main.sn.getController());
				 * Thread.sleep(1000 + rand * 1000); Main.sn.sendmsg("D",
				 * Main.sn.getController());
				 */
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setArrived(boolean state) {
		arrived = state;
	}
}
