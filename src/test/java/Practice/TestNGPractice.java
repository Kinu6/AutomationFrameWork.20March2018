package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
    
	@Test(/**priority = -1,invocationCount = 2,**/enabled = false)
	public void createUser() {
		System.out.println("create");
		Assert.fail();
    }
	@Test(/**priority = 2,dependsOnMethods = "createUser"**/)
	public void updateUser() {
		System.out.println("update");
	}
	@Test
	public void deleteUser() {
		System.out.println("delete");
    }
}