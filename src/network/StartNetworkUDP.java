package network;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import timing.Display;
import timing.Lamp;
import timing.NextDisplay;
import traktoros.Main;

public class StartNetworkUDP extends Thread {
	private DatagramSocket clientsocket;
	private InetAddress controller;
	private InetAddress gate1;
	private InetAddress gate2;
	private InetAddress display;
	private InetAddress nextdisplay;

	private InetAddress forras;

	private byte[] receiveData = new byte[1024];
	private byte[] sendData = new byte[1024];
	private volatile String read;
	private DatagramPacket receivePacket;
	private int port;

	private long startA = -1;
	private long startB = -1;
	private long endA = -1;
	private long endB = -1;
	private boolean koraiA = false;
	private boolean koraiB = false;
	private boolean started = false;
	private boolean ready = false;
	private boolean gystartA = false;
	private boolean gystartB = false;

	private volatile int pageindex = -1;
	private volatile int dropdownindex = -1;

	private Lamp lampa;
	private Display kijelzo;
	private NextDisplay kovikijelzo;
	
	public StartNetworkUDP(){
		lampa = new Lamp();
		kijelzo = new Display("", "", false, false);
		kovikijelzo = new NextDisplay();
	}

	public void setLampaThread(Lamp l) {
		lampa = l;
	}
	
	public Lamp getLampaThread(){
		return lampa;
	}

	public void setKijelzoThread(Display d) {
		kijelzo = d;
	}

	public void setKoviKijelzoThread(NextDisplay d) {
		kovikijelzo = d;
	}

	public void setPageIndex(int i) {
		pageindex = i;
		// System.out.println("page:" + pageindex);
	}

	public void setDropdownIndex(int i) {
		dropdownindex = i;
		// System.out.println("drop:" + dropdownindex);
	}

	public void sendmsg(String s, InetAddress dest) throws IOException {
		sendData = new byte[1024];
		sendData = s.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, dest, 21);
		clientsocket.send(sendPacket);

		//System.out.println("küld: " + s);

		/*
		 * if(s.equals("A")){ started = false; ready = false; koraiA = koraiB =
		 * false; endA = endB = -1; startA = startB = -1; }
		 */

		if (s.equals("D")) {
			if (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3))) {
				startA = startB = System.nanoTime();
				// System.out.println("gyorsstart " + startA);

				Main.mf.setElindult(1, 1);
				Main.mf.setElindult(2, 1);
			}
			started = true;
		} else if (s.equals("A")) {
			ready = true;
			
			started = false;
			//ready = false;
			koraiA = koraiB = false;
			gystartA = gystartB = false;
			endA = endB = -1;
			startA = startB = -1;
		}
	}
	
	public void setread(String s){
		read = s;
	}

	public void run() {
		try {
			port = 21;
			clientsocket = new DatagramSocket(port);
			setController(InetAddress.getByName("192.168.1.110"));
			setDisplay(InetAddress.getByName("192.168.1.104"));
			setNextdisplay(InetAddress.getByName("192.168.1.103"));
			/*
			 * try { sleep(500); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */
			while (true) {
				
				receiveData = new byte[2];
				receivePacket = new DatagramPacket(receiveData, receiveData.length);

				
				clientsocket.receive(receivePacket);
				forras = receivePacket.getAddress();
				read = new String(receivePacket.getData());
				
				/*
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				read = reader.readLine();
				*/
				//System.out.println(read);

				// System.out.println("herr");
				//System.out.println(read);

				if (read != null) {
					System.out.println(read);
					if (read.equals("kk")) {
						if (forras.equals(getDisplay())) {
							// System.out.println("kijelzõ");
							if (kijelzo.isAlive())
								kijelzo.setArrived(true);
						} else if (forras.equals(getNextdisplay())) {
							// System.out.println("kövikijelzõ");
							if (kovikijelzo.isAlive())
								kovikijelzo.setArrived(true);
						} else if (forras.equals(getController())) {
							// System.out.println("lámpa");
							if (lampa.isAlive())
								lampa.setArrived(true);
						}
					} else if (read.equals("1A")) {
						if (pageindex == 1 || pageindex == 2 || (pageindex == 4
								&& (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4))) {
							if (startA == -1 && ready) {
								startA = System.nanoTime();
								Main.mf.setElindult(1, 1);
							} else if (((System.nanoTime() - startA) > 6000000000L) && ready && (endA == -1)) {
								endA = System.nanoTime();
								Main.mf.setTime(startA, endA, 1, koraiA);
								Main.mf.setElindult(1, 2);
							}
						} else if (ready && (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3)))) {
							gystartA = true;
							Main.mf.setElindult(1, 1);
						}

						if (!started && ready) {
							koraiA = true;
							// endA = 0;
							Main.mf.earlyStart(1);
							Main.mf.setElindult(1, 1);
						}

						Main.od.setLastTime(0);
						Main.mf.setColor(0, Color.RED);
					} else if (read.equals("1B")) {
						if (pageindex == 1 || pageindex == 2 || (pageindex == 4
								&& (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4))) {
							if (startB == -1 && ready) {
								startB = System.nanoTime();
								Main.mf.setElindult(2, 1);
							} else if (((System.nanoTime() - startB) > 6000000000L) && ready && (endB == -1)) {
								endB = System.nanoTime();
								Main.mf.setTime(startB, endB, 2, koraiB);
								Main.mf.setElindult(2, 2);
							}
						} else if (ready && (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3)))) {
							gystartB = true;
							Main.mf.setElindult(2, 1);
						}

						if (!started && ready) {
							koraiB = true;
							// endB = 0;
							Main.mf.earlyStart(2);
							Main.mf.setElindult(2, 1);
						}

						Main.od.setLastTime(1);
						Main.mf.setColor(1, Color.RED);
					} else if (read.equals("2A")) {
						if (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3))) {
							if (ready && (endA == -1)) {
								endA = System.nanoTime();
								Main.mf.setTime(startA, endA, 1, koraiA);
								Main.mf.setElindult(1, 2);
							}
						}

						Main.od.setLastTime(2);
						Main.mf.setColor(2, Color.RED);
					} else if (read.equals("2B")) {
						if (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3))) {
							if (ready && (endB == -1)) {
								endB = System.nanoTime();
								Main.mf.setTime(startB, endB, 2, koraiB);
								Main.mf.setElindult(2, 2);
							}
						}

						Main.od.setLastTime(3);
						Main.mf.setColor(3, Color.RED);
					}

					if (endA != -1 && endB != -1) {
						started = false;
						ready = false;
						koraiA = koraiB = false;
						gystartA = gystartB = false;
						endA = endB = -1;
						startA = startB = -1;
						// Main.mf.setElindult(1, 0);
						// Main.mf.setElindult(2, 0);
					} else if (pageindex == 1 || pageindex == 2
							|| (pageindex == 4 && (dropdownindex == 0 || dropdownindex == 1 || dropdownindex == 4))) {
						if ((endA != -1 && startB == -1) || (endB != -1 && startA == -1)) {
							started = false;
							ready = false;
							koraiA = koraiB = false;
							gystartA = gystartB = false;
							endA = endB = -1;
							startA = startB = -1;
							// Main.mf.setElindult(1, 0);
							// Main.mf.setElindult(2, 0);
						}
					} else if (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3))) {
						if ((endA != -1 && gystartB == false) || (endB != -1 && gystartA == false)) {
							started = false;
							ready = false;
							koraiA = koraiB = false;
							gystartA = gystartB = false;
							endA = endB = -1;
							startA = startB = -1;
							// Main.mf.setElindult(1, 0);
							// Main.mf.setElindult(2, 0);
						}
					}
					/*
					 * if ((endA != -1 && endB != -1) || (endA != -1 && (startB
					 * == -1 || gystartB == false)) || (endB != -1 && (startA ==
					 * -1 || gystartA == false))) { started = false; ready =
					 * false; koraiA = koraiB = false; gystartA = gystartB =
					 * false; endA = endB = -1; startA = startB = -1;
					 * Main.mf.setElindult(1, 0); Main.mf.setElindult(2, 0); }
					 */
					read = null;
				}
				
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public InetAddress getDisplay() {
		return display;
	}

	public void setDisplay(InetAddress display) {
		this.display = display;
	}

	public InetAddress getController() {
		return controller;
	}

	public void setController(InetAddress controller) {
		this.controller = controller;
	}

	public InetAddress getGate1() {
		return gate1;
	}

	public void setGate1(InetAddress gate1) {
		this.gate1 = gate1;
	}

	public InetAddress getGate2() {
		return gate2;
	}

	public void setGate2(InetAddress gate2) {
		this.gate2 = gate2;
	}

	public InetAddress getNextdisplay() {
		return nextdisplay;
	}

	public void setNextdisplay(InetAddress nextdisplay) {
		this.nextdisplay = nextdisplay;
	}
}
