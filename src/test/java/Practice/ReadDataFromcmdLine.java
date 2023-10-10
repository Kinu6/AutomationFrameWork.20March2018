package Practice;

import org.testng.annotations.Test;

public class ReadDataFromcmdLine {
	@Test
	public void read() {
		String BROWSER= System.getProperty("browser"); //RunTime Parameter
		System.out.println(BROWSER);
		String URL=System.getProperty("url");
		System.out.println(URL);
	}

}
