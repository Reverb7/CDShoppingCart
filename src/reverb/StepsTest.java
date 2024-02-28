package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StepsTest {
	
	private ShoppingCart cart;
	Product doveSoap, jergens, nivea, axeDeo;

	@Before
	public void setUp() throws Exception 
	{
		doveSoap = new Product("Dove Soaps", 39.99);
		nivea = new Product("Nivea Lotion", 50);
		axeDeo = new Product("Axe Deo", 99.99);
	}

	@After
	public void tearDown() throws Exception 
	{
		cart = null;
		doveSoap = null;
	}
	
	@Test
	public void testStep1() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 5);
		
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(5, cart.countProduct(doveSoap.getName()));
		assertEquals(true, cart.getTotalPrice() == 199.95);
	}
	
	@Test
	public void testStep2() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 5);
		cart.addProduct(doveSoap, 3);
		
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(8, cart.countProduct(doveSoap.getName()));
		assertEquals(true, cart.getTotalPrice() == 319.92);
	}
	
	@Test
	public void testStep3() 
	{
		cart = new ShoppingCart(12.5);
		cart.addProduct(doveSoap, 2);
		cart.addProduct(axeDeo, 2);
		
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(true, axeDeo.getPrice() == 99.99);
		assertEquals(2, cart.countProduct(doveSoap.getName()));
		assertEquals(2, cart.countProduct(axeDeo.getName()));
		assertEquals(true, cart.getTaxAmount(true) == 35.00);
		assertEquals(true, cart.getTotalPrice() == 314.96);
	}
	
	@Test
	public void testStep4() 
	{
		cart = new ShoppingCart(12.5);
		doveSoap = new Product("Dove Soaps", 39.99);
		axeDeo = new Product("Axe Deo", 89.99);
		
		BuyXGetYFree doveoffer = new BuyXGetYFree(2, 1);
		doveSoap.setOffer(doveoffer);
		
		// 3 dove soaps
		cart.addProduct(doveSoap, 3);
		assertEquals(3, cart.countProduct(doveSoap.getName()));
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(true, cart.getTotalPrice() == 89.98);
		assertEquals(true, cart.getTotalDiscount() == 39.99);
		assertEquals(true, cart.getTaxAmount(true) == 10.00);
		
		// 5 dove soaps
		cart = new ShoppingCart(12.5);
		cart.addProduct(doveSoap, 5);
		assertEquals(true, cart.getTotalPrice() == 179.96);
		assertEquals(true, cart.getTotalDiscount() == 39.99);
		assertEquals(true, cart.getTaxAmount(true) == 20.00);
		
		// 3 dove soaps and 2 Axe Deos
		cart = new ShoppingCart(12.5);
		cart.addProduct(doveSoap, 3);
		cart.addProduct(axeDeo, 2);
		assertEquals(3, cart.countProduct(doveSoap.getName()));
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(2, cart.countProduct(axeDeo.getName()));
		assertEquals(true, axeDeo.getPrice() == 89.99);
		assertEquals(true, cart.getTotalPrice() == 292.46);
		assertEquals(true, cart.getTotalDiscount() == 39.99);
		assertEquals(true, cart.getTaxAmount(true) == 32.50);
	}
	
	@Test
	public void testStep5() 
	{
		cart = new ShoppingCart(12.5);
		doveSoap = new Product("Dove Soaps", 39.99);
		
		BuyXGetYDiscountOnNextOne doveOffer = new BuyXGetYDiscountOnNextOne(1, 50);
		doveSoap.setOffer(doveOffer);
		
		cart.addProduct(doveSoap, 2);
		assertEquals(2, cart.countProduct(doveSoap.getName()));
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(true, cart.getTotalPrice() == 67.48);
		assertEquals(true, cart.getTotalDiscount() == 20.00);
		assertEquals(true, cart.getTaxAmount(true) == 7.5);
		
	}
	
	@Test
	public void testStep6() 
	{
		cart = new ShoppingCart(12.5);
		doveSoap = new Product("Dove Soaps", 39.99);
		axeDeo = new Product("Axe Deo", 89.99);
		
		cart.setCartDiscount(20);
		cart.setCartDisCountReq(500);
		
		cart.addProduct(doveSoap, 5);
		cart.addProduct(axeDeo, 4);
		assertEquals(5, cart.countProduct(doveSoap.getName()));
		assertEquals(4, cart.countProduct(axeDeo.getName()));
		assertEquals(true, doveSoap.getPrice() == 39.99);
		assertEquals(true, cart.getTotalPrice() == 503.92);
		assertEquals(true, cart.getTotalDiscount() == 111.98);
		assertEquals(true, cart.getTaxAmount(true) == 55.99);
		
	}

}
