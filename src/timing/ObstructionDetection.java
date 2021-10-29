package timing;

import java.awt.Color;

import traktoros.Main;

public class ObstructionDetection extends Thread {
	private volatile long lasta1 = 0;
	private volatile long lasta2 = 0;
	private volatile long lastb1 = 0;
	private volatile long lastb2 = 0;

	public volatile boolean started = false;

	public ObstructionDetection() {
		lasta1 = 0;
		lasta2 = 0;
		lastb1 = 0;
		lastb2 = 0;
	}

	public void setLastTime(int sensor) {
		//System.out.println("set" + sensor);
		switch (sensor) {
		case 0: {
			lasta1 = System.currentTimeMillis();
			break;
		}
		case 1: {
			lastb1 = System.currentTimeMillis();
			break;
		}
		case 2: {
			lasta2 = System.currentTimeMillis();
			break;
		}
		case 3: {
			lastb2 = System.currentTimeMillis();
			break;
		}
		}
	}

	public void run() {
		while (true) {
			if (lasta1 != 0 && ((System.currentTimeMillis() - lasta1) > 1000)) {
				Main.mf.setColor(0, Color.GREEN);
			}
			if (lasta2 != 0 && ((System.currentTimeMillis() - lasta2) > 1000)) {
				Main.mf.setColor(2, Color.GREEN);
			}
			if (lastb1 != 0 && ((System.currentTimeMillis() - lastb1) > 1000)) {
				Main.mf.setColor(1, Color.GREEN);
			}
			if (lastb2 != 0 && ((System.currentTimeMillis() - lastb2) > 1000)) {
				Main.mf.setColor(3, Color.GREEN);
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
