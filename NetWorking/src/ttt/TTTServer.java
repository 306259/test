package ttt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;


public class TTTServer
{
	private static ArrayList<TTTClient> clients = new ArrayList<TTTClient>();
	private static ArrayList<String> messages = new ArrayList<String>();
	private static int numPlayers = 0;
	private static char gameState;
	private static char[] board = {'N','N','N','N','N','N','N','N','N'};
	private static int turn;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		final int CONVERT = 1000000000;

		ServerSocket server = new ServerSocket(8888);
		
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
		
		
		
		messages = new ArrayList<String>();
		
		for(TTTClient c : clients)
		{
			InputStream inStream = c.getInput();
			
			String action = read(inStream);
			
			if(action != null)
			{
				if(action.startsWith("GAME"))
				{
					if(!c.joined());
					{
						if(getParam("GAME", action).equals("P"))
						{
							if(numPlayers == 0)
							{
								c.join('X');
								numPlayers ++;
								c.sendMessage("200 X");
							}
							else if(numPlayers == 1)
							{
								c.join('O');
								numPlayers ++;
								c.sendMessage("200 O");
								gameState = 'C';
								turn = 1;
							}
							else
								c.sendMessage("403");
							
						}
						
						else if(getParam("GAME", action).equals("S"))
						{
							c.join('S');
							c.sendMessage("200");
						}
						
						else
						{
							c.sendMessage("403");
						}
					}
				}
						
						else if(action.startsWith("MOVE"))
						{
							if(gameState == 'C'){
								if(c.joined())
								{
				
									if(c.getPlayer() != 'S')
									{
										int index = Integer.parseInt(getParam("MOVE", action));
										
										if(index > 8 || index < 0)
											c.sendMessage("400");
										
										else
										{
											if((c.getPlayer() == 'X' && turn == 1) || (c.getPlayer() == 'O' && turn == 2))
											{
												if(board[index] == 'N')
												{	board[index] = c.getPlayer();
													c.sendMessage("200");
													
													checkGame(c);
													
													String b = "";
													for(int i = 0; i < board.length; i++)
													{
														b += board[i];
													}
													
													messages.add("001 " + b + " " + gameState);
													
													if(turn == 1)
														turn = 2;
													else
														turn = 1;
													
													
												}
												
												else
													c.sendMessage("403");
												
											}
											
											else
												c.sendMessage("403");
											
											
											
										}
								}
									else
										c.sendMessage("403");
						}
								else
									c.sendMessage("403");

						}
							else
								c.sendMessage("403");
						
					}
						else
							c.sendMessage("400");
				}
			} 	
			
			if(messages.size() > 0)
				for(TTTClient c : clients)
					for(String message : messages)
						if(c.joined())
							c.sendMessage(message);
		}
		
		server.close();
				
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
	public static String getParam(String command, String total)
	{
		return total.substring(command.length() + 1, total.length() - 2);
	}
	
	public static void checkGame(TTTClient c){
		if (board[0] == board[1] && board[1] == board[2] && board[0] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[0] == board[3] && board[3] == board[6] && board[0] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[0] == board[4] && board[4] == board[8] && board[0] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[1] == board[4] && board[4] == board[7] && board[1] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[2] == board[5] && board[5] == board[8] && board[2] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[2] == board[4] && board[4] == board[6] && board[2] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[3] == board[4] && board[4] == board[5] && board[3] == c.getPlayer())
			gameState = c.getPlayer();
		else if (board[6] == board[7] && board[7] == board[8] && board[6] == c.getPlayer())
			gameState = c.getPlayer();
		
		for (int i = 0; i < board.length; i++){
			if (board[i] == 'N')
				return;
		}
		
		gameState = 'D';
	}


}
