import java.net.*;
import java.io.*;

public class MemeServer {

	/**
	*	Main Entry point of program
	*/
	public static void main (String[] args) {
		int port;
		if (args.length != 1) {
			port = 8080;
		} else {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Arguement is not valid, should be number. Or no arguments supplied for default [8080]");
				e.printStackTrace();
			}
		}

		while(true) { // beginning of loop to listen for clients
			try {

				ServerSocket server = new ServerSocket(port);

				Socket client = server.accept();

				ClientHandler handler = new ClientHandler(client);
				handler.start();				


			} catch (IOException e) {
			

			} catch (Exception e) {
			

			}

		}

	}

}