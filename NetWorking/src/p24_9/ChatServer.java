package p24_9;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

import ttt.TTTClient;

public class ChatServer 
{
//	private final static String PASSWORD = "CHATTER";
	private static ArrayList<TTTClient> clients = new ArrayList<TTTClient>();
	private static ArrayList<String> messages = new ArrayList<String>();

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ServerSocket server = new ServerSocket(8888);
		
		
		final int CONVERT = 1000000000;
		
		long endTime = System.nanoTime() / CONVERT + 600;
		
//		String pass = null;
		server.setSoTimeout(100);
		
		while(System.nanoTime() / CONVERT < endTime)
		{
			 messages = new ArrayList<String>();
			 
			try
			{
				Socket s = server.accept();
				clients.add(new TTTClient(s));
			}
			catch (SocketTimeoutException e)
			{
				
			}
			
			for (TTTClient c: clients)
			{
				String message = read(c.getInput());
				
				if (message != null){
					messages.add(message);
			}
		}
			
			for (TTTClient c: clients)
			{
				for (String mess: messages)
																								{
					c.sendMessage(mess);
				}
			}
			
		}
		

	}
	public static String read(InputStream in) throws IOException
	{
		int available = in.available();
		
		if(available > 0)
		{
			byte [] bytes = new byte [available];
			in.read(bytes);
			return new String(bytes);
		}
		
		else
			return null;
	}

}
