package Practice;

import org.testng.annotations.Test;

public class DebuggingPractice {
	
	public static int div(int a, int b){
		int c= a/b;
		return c;	
	}
	@Test
	public void test()
	{
		System.out.println("Main Method is started here");
		System.out.println("add is called ");
	    int c= div(10, 2);
	    System.out.println("Division ="+ c);
	    System.out.println("Division performed");
	}
	
}
