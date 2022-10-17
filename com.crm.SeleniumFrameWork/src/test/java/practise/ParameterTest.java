package practise;

import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	public void method() {
		String var=System.getProperty("browser");
		System.out.println(var);
	}

}
