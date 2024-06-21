package concurrency;


// FROM A DESIGN STANDPOINT THIS IS NOT ADVISABLE; BETTER TO CREATE A LOOSELY COUPLED DESIGN AND CREATE A TASK THAT IMPLEMENTS RUNNABLE INTERFACE WHICH CAN BE PASSED TO A THREAD CLASS
public class MyFirstThread2 extends Thread {
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
