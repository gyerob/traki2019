package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class CommunicateTCP extends Thread {
	private Socket clientsocket;

	private String read;

	@SuppressWarnings("unused")
	private long startA = -1;
	@SuppressWarnings("unused")
	private long startB = -1;
	@SuppressWarnings("unused")
	private long endA = -1;
	@SuppressWarnings("unused")
	private long endB = -1;
	@SuppressWarnings("unused")
	private boolean koraiA = false;
	@SuppressWarnings("unused")
	private boolean koraiB = false;
	@SuppressWarnings("unused")
	private boolean started = false;
	@SuppressWarnings("unused")
	private boolean ready = false;

	private volatile int pageindex = -1;
	private volatile int dropdownindex = -1;
	
	public CommunicateTCP(Socket socket){
		clientsocket = socket;
	}

	public void setPageIndex(int i) {
		pageindex = i;
		// System.out.println("page:" + pageindex);
	}

	public void setDropdownIndex(int i) {
		dropdownindex = i;
		// System.out.println("drop:" + dropdownindex);
	}

	public void sendmsg(String s) throws IOException {
		DataOutputStream outToClient = new DataOutputStream(clientsocket.getOutputStream());
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
			while (true) {
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

				read = inFromClient.readLine();
				System.out.println("Received: " + read);

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
