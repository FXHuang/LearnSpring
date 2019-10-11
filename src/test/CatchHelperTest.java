package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import util.CatchHelper;

public class CatchHelperTest {
	
	@Before
	public void generateClass() {
		CatchHelper helper = new CatchHelper();
	}

	@Test
	public void testParsePath() {
		String result = "ddd";
		Assert.assertEquals(result, "ddd");
	}

}
