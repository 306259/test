package p24_9;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
	private Socket s;
	private boolean isOn;
	private  InputStream in;
	private PrintWriter out;
	
	public Client(Socket server) throws IOException
	{
		s = server;
		isOn = false;
		in = s.getInputStream();
		out = new PrintWriter(s.getOutputStream());
	}
	
	public void sendMessage(String s)
	{
		if(s != null)
		{
			out.println(s);
			out.flush();
		}
	}
	
	public void changeLoginState()
	{
		isOn = !isOn;
	}
	
	public boolean loginState()
	{
		return isOn;
	}
	
	public InputStream getInput() 
	{
		return in;
	}
}
