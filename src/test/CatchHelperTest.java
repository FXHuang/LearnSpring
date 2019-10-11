package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import util.CatchHelper;

public class CatchHelperTest {
	
	CatchHelper helper;
	@Before
	public void generateClass() {
		helper = new CatchHelper();
	}

	@Test
	public void testParsePath() {
		Map<String, String> result = new HashMap<>();
		String str1 = "login.do?userName=Tom&password=123456";
		result = helper.stringSplit(str1);
		for (String key : result.keySet()) {
			System.out.println("key " + key + "  val " + result.get(key));
		}
		Assert.assertEquals(result, "");
	}

}
