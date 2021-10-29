package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

@SuppressWarnings("unused")
public class StartNetworkTCP extends Thread {
	private ServerSocket serversocket;

	private Socket connsocket;
	private Socket kovsocket;
	private Socket kijelzosocket;
	private Socket lampasocket;

	public static Thread kovthread;
	public static Thread kijelzothread;
	public static Thread lampathread;

	private int port = 50001;

	private long startA = -1;
	private long startB = -1;
	private long endA = -1;
	private long endB = -1;
	private boolean koraiA = false;
	private boolean koraiB = false;
	private boolean started = false;
	private boolean ready = false;

	private volatile int pageindex = -1;
	private volatile int dropdownindex = -1;

	public void sendmsg(String s, Socket dest) throws IOException {
		DataOutputStream outToClient = new DataOutputStream(dest.getOutputStream());
		outToClient.writeBytes(s);

		System.out.println("küld: " + s);

		if (s.equals("D")) {
			if (pageindex == 3 || (pageindex == 4 && (dropdownindex == 2 || dropdownindex == 3))) {
				startA = startB = System.nanoTime();
				// System.out.println("gyorsstart " + startA);
			}
			started = true;
		} else if (s.equals("A")) {
			ready = true;
		}
	}

	public void run() {
		try {
			serversocket = new ServerSocket(port);

			while (true) {
				connsocket = serversocket.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connsocket.getInputStream()));

				String clientSentence = inFromClient.readLine();
				System.out.println("Received: " + clientSentence);

				if (inFromClient.equals("kovi")) {
					setKovsocket(connsocket);
					kovthread = new CommunicateTCP(getKovsocket());
					kovthread.start();
				} else if (inFromClient.equals("kijelzo")) {
					setKijelzosocket(connsocket);
					kijelzothread = new CommunicateTCP(getKijelzosocket());
					kijelzothread.start();
				} else if (inFromClient.equals("lampa")) {
					setLampasocket(connsocket);
					lampathread = new CommunicateTCP(getLampasocket());
					lampathread.start();
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

	public Socket getKovsocket() {
		return kovsocket;
	}

	public void setKovsocket(Socket kovsocket) {
		this.kovsocket = kovsocket;
	}

	public Socket getKijelzosocket() {
		return kijelzosocket;
	}

	public void setKijelzosocket(Socket kijelzosocket) {
		this.kijelzosocket = kijelzosocket;
	}

	public Socket getLampasocket() {
		return lampasocket;
	}

	public void setLampasocket(Socket lampasocket) {
		this.lampasocket = lampasocket;
	}

}
