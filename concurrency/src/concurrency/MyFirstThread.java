package concurrency;


public class MyFirstThread {

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Inside main...");
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run function...");
		go();
	}

	private void go() {
		System.out.println("Inside go function...");
		more();
	}

	private void more() {
		System.out.println("Inside more function...");
		
	}
	
	
}