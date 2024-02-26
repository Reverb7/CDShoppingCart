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

}
