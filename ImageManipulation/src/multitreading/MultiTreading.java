package multitreading;

public class MultiTreading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunnableThing one = new MyRunnableThing("Thing One");
		MyRunnableThing two = new MyRunnableThing("Thing Two");
		
//		one.run();
//		two.run();
		
		Thread threadOne = new Thread(one);
		Thread threadTwo = new Thread(two);
		
		threadOne.start();
		threadTwo.start();	
		
	}

	}