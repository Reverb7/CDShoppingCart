package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuyXGetFreeTest 
{
	private BuyXGetYFree offer;

	@Before
	public void setUp() throws Exception 
	{
		offer = new BuyXGetYFree(2, 1);
	}

	@After
	public void tearDown() throws Exception 
	{
		offer  = null;
	}

	@Test
	public void testGetRequirementQuan() 
	{
		assertEquals(2, offer.getRequirementQuan());
	}
	
	@Test
	public void testseTRequirementQuan() 
	{
		assertEquals(1, offer.getOfferQuan());
	}

}
