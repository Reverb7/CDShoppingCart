package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest 
{
	private Product doveSoap;
	private Product jergens;

	@Before
	public void setUp() throws Exception 
	{
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
	}

	@After
	public void tearDown() throws Exception 
	{
		doveSoap = null;
	}

	@Test
	public void testProductName() 
	{
		assertEquals("Dove Soaps", doveSoap.getName());
		assertEquals("Jergens Lotion", jergens.getName());
	}
	
	
	@Test
	public void testProductPrice() 
	{
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(true, jergens.getPrice() == 40.00);
	}
	
	@Test
	public void testProductBuyXGetYFreeOffer() 
	{
		Offer offer = new BuyXGetYFree(4, 1);
		jergens.setOffer(offer);
		
		assertEquals(4, ((BuyXGetYFree)(jergens.getOffer())).getRequirementQuan());
		assertEquals(1, ((BuyXGetYFree)(jergens.getOffer())).getOfferQuan());
	}
	
	@Test
	public void testProductBuyXGetYDiscountOnNextOne() 
	{
		Offer offer = new BuyXGetYDiscountOnNextOne(2, 55);
		jergens.setOffer(offer);
		
		assertEquals(2, ((BuyXGetYDiscountOnNextOne)(jergens.getOffer())).getRequirementQuan());
		assertEquals(55, ((BuyXGetYDiscountOnNextOne)(jergens.getOffer())).getOfferDiscount());
	}

}
