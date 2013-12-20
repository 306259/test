package multitreading;

public class MyRunnableThing implements Runnable 
{
	private final String id;
	
	public MyRunnableThing(String id)
	{
		this.id = id;
	}

	public void run() 
	{
			try 
			{
				for(int i = 1; i <=10; i++)
				{
					System.out.println(id + " " + System.nanoTime());
			
		
					Thread.sleep(500);
				} 
			}
				
			catch (InterruptedException e)
			{
				
			}
		
	}

}
