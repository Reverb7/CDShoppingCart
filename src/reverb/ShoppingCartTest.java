package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest 
{
	private ShoppingCart cart;
	Product doveSoap, jergens, nivea;

	@Before
	public void setUp() throws Exception 
	{
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
		nivea = new Product("Nivea Lotion", 50);
	}

	@After
	public void tearDown() throws Exception 
	{
		cart = null;
		doveSoap = null;
		jergens = null;
	}

	@Test
	public void testProductAddition() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap);
		assertEquals(1, cart.getProductList().size());
		
		cart.addProduct(jergens);
		assertEquals(2, cart.getProductList().size());
	}
	
	@Test
	public void testProductAdditionWithQuantity() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 3);
		assertEquals(3, cart.getProductList().size());
		
		cart.addProduct(jergens, 5);
		assertEquals(8, cart.getProductList().size());
		
		cart.addProduct(nivea, 2);
		assertEquals(10, cart.getProductList().size());
	}
	
	@Test
	public void testTotalPrice() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 3);
		assertEquals(true, cart.getTotalPrice() == 119.97);
		
		cart.addProduct(jergens, 5);
		assertEquals(true, cart.getTotalPrice() == 319.97);
		
		cart.addProduct(nivea, 2);
		assertEquals(true, cart.getTotalPrice() == 419.97);
	}
	
	@Test
	public void testCountProduct() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 3);
		cart.addProduct(jergens, 5);
		cart.addProduct(nivea, 2);
		
		
		assertEquals(3, cart.countProduct(doveSoap.getName()));
		assertEquals(5, cart.countProduct(jergens.getName()));
		assertEquals(2, cart.countProduct(nivea.getName()));
		
		cart.addProduct(doveSoap);
		cart.addProduct(jergens, 3);
		cart.addProduct(nivea, 2);
		assertEquals(4, cart.countProduct(doveSoap.getName()));
		assertEquals(8, cart.countProduct(jergens.getName()));
		assertEquals(4, cart.countProduct(nivea.getName()));
	}
	
	@Test
	public void testgetUniqueProductList() 
	{
		cart = new ShoppingCart();
		cart.addProduct(doveSoap, 3);
		cart.addProduct(jergens, 5);
		cart.addProduct(nivea, 2);
		assertEquals(3, cart.getUniqueProducts().size());
		
		cart.addProduct(jergens, 5);
		cart.addProduct(nivea, 2);
		assertEquals(3, cart.getUniqueProducts().size());
	}
	
	@Test
	public void testGetProduct() 
	{
		cart = new ShoppingCart();
		cart.addProduct(nivea, 3);
		cart.addProduct(jergens, 5);
		
		assertEquals(true, nivea.getName() == cart.getProduct("Nivea Lotion").getName());
		assertEquals(true, nivea.getPrice() == cart.getProduct("Nivea Lotion").getPrice());
		
		assertEquals(true, jergens.getName() == cart.getProduct("Jergens Lotion").getName());
		assertEquals(true, jergens.getPrice() == cart.getProduct("Jergens Lotion").getPrice());
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

}
