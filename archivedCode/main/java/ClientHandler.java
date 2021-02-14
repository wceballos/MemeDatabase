import java.io.*;
import java.net.*;

/**
*	Instance that will handle a client's session
*/ 

public class ClientHandle extends Thread {

	private Socket client;

	public ClientHandler (Socket initClient) {
		client = initClient;
	}

	/**
	*	Entry point of thread
	*/
	@Override
	public void run () {

	}

}