package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class LampaTCP extends Thread {
	Socket socket;

	public LampaTCP(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		while (true) {

		}
	}

	public void sendmsg(String s) {
		DataOutputStream outToClient;
		try {
			outToClient = new DataOutputStream(socket.getOutputStream());
			outToClient.writeBytes(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readmsg() {
		BufferedReader inFromClient;
		try {
			inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String read = inFromClient.readLine();
			System.out.println("Received: " + read);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
