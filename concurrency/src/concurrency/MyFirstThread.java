package concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		try {
			Thread.sleep(3000);
			thread.interrupt(); // interrupts this particlular thread if it has not finished execution
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
		try {
//			Thread.sleep(3000);
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("The thread is interrupted");
		}
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