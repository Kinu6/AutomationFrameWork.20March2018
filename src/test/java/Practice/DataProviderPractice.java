package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderPractice {

	@Test(dataProvider = "getData")
	public void addToCart(String name, int price, int qty, String color,boolean isAvaliable)
	{
		System.out.println(name+"-"+price+"-"+qty+"-"+color+"-"+isAvaliable);
	}
	
	@DataProvider
	public Object[][] getData()
	{                           //row //cell
		Object[][] data= new Object[2][5]; //2 data sets of 5 details inside
		
		data[0][0]="Samsung";
		data[0][1]=1000;
		data[0][2]=12;
		data[0][3]="Black";
		data[0][4]=true;
		
		//SoftAssert sa= new SoftAssert();
		//sa.assertTrue(true);
		
		data[1][0]="Iphone";
		data[1][1]=112000;
		data[1][2]=15;
		data[1][3]="White";
		data[1][4]=false;
		
		//sa.assertAll();
		
		return data;
	}
	
	
	
}
