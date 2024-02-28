package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuyXGetYDiscountOnNextOneTest 
{
	private BuyXGetYDiscountOnNextOne offer;

	@Before
	public void setUp() throws Exception 
	{
		offer = new BuyXGetYDiscountOnNextOne(1, 40);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetReqQuan() 
	{
		assertEquals(1, offer.getRequirementQuan());
	}
	
	@Test
	public void testSetReqQuan() 
	{
		offer.setRequirementQuan(3);
		assertEquals(3, offer.getRequirementQuan());
	}
	
	@Test
	public void testGetOfferDiscout() 
	{
		assertEquals(40, offer.getOfferDiscount());
	}
	
	@Test
	public void testSetOfferDiscount() 
	{
		offer.setOfferDiscount(0);
		assertEquals(0, offer.getOfferDiscount());
	}


}
