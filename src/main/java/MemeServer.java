import java.net.*;
import java.io.*;

public class MemeServer {

	/**
	*	Main Entry point of program
	*/
	public static void main (String[] args) {
		int port;
		ServerSocket server;

		if (args.length != 1) {
			port = 8080;
		} else {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Arguement is not valid, should be number. Or no arguments supplied for default [8080]");
				e.printStackTrace();
				System.exit(1);
			}
		}

		try {
			server = new ServerSocket(port);
		} catch (Exception e) {
			System.out.println("Issue binding server to port, check that port is not in use.");
			System.exit(1);
		}

		while(true) { // beginning of loop to listen for clients
			try {

				Socket client = server.accept();

				ClientHandler handler = new ClientHandler(client);
				handler.start();				


			} catch (IOException e) {
			

			} catch (Exception e) {
			

			}

		}

	}

}