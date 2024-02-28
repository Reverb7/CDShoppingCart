package reverb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest 
{
	private ShoppingCart cart;
	Product doveSoap, jergens, nivea, axeDeo;

	@Before
	public void setUp() throws Exception 
	{
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
		nivea = new Product("Nivea Lotion", 50);
		axeDeo = new Product("Axe Deo", 99.99);
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
		cart.displayProducts();
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
	public void testGetTaxRate() 
	{
		cart = new ShoppingCart(12);
		assertEquals(true, cart.getTaxRate() == 12);
		
		cart = new ShoppingCart();
		cart.setTaxRate(18.4);
		assertEquals(true, cart.getTaxRate() == 18.40);
	}
	
	@Test
	public void testGetTaxAmount() 
	{
		cart = new ShoppingCart(7.5);
		cart.addProduct(jergens, 4);
		assertEquals(true, cart.getTaxAmount(true) == 12);
		
		cart = new ShoppingCart();
		cart.setTaxRate(17.3);
		cart.addProduct(nivea, 9);
		cart.addProduct(doveSoap);
		assertEquals(true, cart.getTaxAmount(true) == 84.77);
	}
	
	@Test
	public void testTaxRate() 
	{
		cart = new ShoppingCart(13.1);
		cart.addProduct(jergens, 4);
		cart.addProduct(nivea, 2);
		cart.addProduct(doveSoap, 4);
		assertEquals(true, cart.getTaxAmount(true) == 55.01);
		assertEquals(true, cart.getTotalPrice() == 474.97);
		
		cart.setTaxRate(0);
		assertEquals(true, cart.getTaxAmount(true) == 0);
		assertEquals(true, cart.getTotalPrice() == 419.96);
	}
	
	@Test
	public void testBuyXGetYFreeOffer() 
	{
		cart = new ShoppingCart(15);
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
		
		BuyXGetYFree Doveoffer = new BuyXGetYFree(2, 1);
		BuyXGetYFree Jergensoffer = new BuyXGetYFree(4, 2);
		
		doveSoap.setOffer(Doveoffer);
		jergens.setOffer(Jergensoffer);
		
		
		cart.addProduct(jergens, 3);
		assertEquals(true, cart.getTotalPrice() == 138);
		cart.addProduct(jergens, 2);
		assertEquals(true, cart.getTotalPrice() == 138);
		
		cart = new ShoppingCart(15);
		cart.addProduct(jergens, 3);
		cart.addProduct(doveSoap, 3);
		assertEquals(true, cart.getTotalPrice() == 229.98);
		
		cart.addProduct(jergens);
		assertEquals(true, cart.getTotalPrice() == 183.98);
		
	}
	
	@Test
	public void testBuyXGetYDiscountOnNextOne() 
	{
		cart = new ShoppingCart(17);
		nivea = new Product("Nivea Lotion", 105);
		jergens = new Product("Jergens Lotion", 40);
		
		BuyXGetYDiscountOnNextOne niveaoffer = new BuyXGetYDiscountOnNextOne(2, 60);
		BuyXGetYDiscountOnNextOne Jergensoffer = new BuyXGetYDiscountOnNextOne(2, 20);
		
		nivea.setOffer(niveaoffer);
		jergens.setOffer(Jergensoffer);
		
		
		cart.addProduct(nivea);
		assertEquals(true, cart.getTotalPrice() == 122.85);
		cart.addProduct(jergens, 2);
		assertEquals(true, cart.getTotalPrice() == 216.45);
		cart.addProduct(jergens);
		assertEquals(true, cart.getTotalPrice() == 253.89);
		
		cart = new ShoppingCart(9);
		cart.addProduct(nivea, 3);
		cart.addProduct(jergens, 3);
		assertEquals(true, cart.getTotalPrice() == 396.76);
		
		
	}
	
	@Test
	public void testMultipleOffers() 
	{
		cart = new ShoppingCart(14);
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
		
		BuyXGetYFree Doveoffer = new BuyXGetYFree(2, 1);
		
		BuyXGetYDiscountOnNextOne Jergensoffer = new BuyXGetYDiscountOnNextOne(2, 50);
		
		
		doveSoap.setOffer(Doveoffer);
		jergens.setOffer(Jergensoffer);
		
		
		cart.addProduct(jergens, 2);
		cart.addProduct(doveSoap);
		assertEquals(true, cart.getTotalPrice() == 136.79);
		assertEquals(true, cart.getTotalDiscount() == 0);
		
		
		cart.addProduct(jergens, 2);
		cart.addProduct(doveSoap);
		assertEquals(true, cart.getTotalPrice() == 205.19);
		assertEquals(true, cart.getTotalDiscount() == 59.99);
		
	}
	
	@Test
	public void testTotalDiscount1()
	{
		cart = new ShoppingCart(15);
		doveSoap = new Product("Dove Soaps", 39.99);
		jergens = new Product("Jergens Lotion", 40);
		
		BuyXGetYFree Doveoffer = new BuyXGetYFree(2, 1);
		BuyXGetYFree Jergensoffer = new BuyXGetYFree(4, 2);
		
		doveSoap.setOffer(Doveoffer);
		jergens.setOffer(Jergensoffer);
		
		
		cart.addProduct(jergens, 3);
		assertEquals(true, cart.getTotalPrice() == 138);
		assertEquals(true, cart.getTotalDiscount() == 0);
		
		cart.addProduct(jergens, 2);
		assertEquals(true, cart.getTotalPrice() == 138);
		assertEquals(true, cart.getTotalDiscount() == 80);
		
		cart = new ShoppingCart(15);
		cart.addProduct(jergens, 3);
		cart.addProduct(doveSoap, 3);
		assertEquals(true, cart.getTotalPrice() == 229.98);
		assertEquals(true, cart.getTotalDiscount() == 39.99);
		
		cart.addProduct(jergens);
		assertEquals(true, cart.getTotalPrice() == 183.98);
		assertEquals(true, cart.getTotalDiscount() == 119.99);
		
	}
	
	@Test
	public void testTotalDiscount2()
	{
		cart = new ShoppingCart(17);
		nivea = new Product("Nivea Lotion", 105);
		jergens = new Product("Jergens Lotion", 40);
		
		BuyXGetYDiscountOnNextOne niveaoffer = new BuyXGetYDiscountOnNextOne(2, 60);
		BuyXGetYDiscountOnNextOne Jergensoffer = new BuyXGetYDiscountOnNextOne(2, 20);
		
		nivea.setOffer(niveaoffer);
		jergens.setOffer(Jergensoffer);
		
		
		cart.addProduct(nivea);
		assertEquals(true, cart.getTotalPrice() == 122.85);
		assertEquals(true, cart.getTotalDiscount() == 0);
		cart.addProduct(jergens, 2);
		assertEquals(true, cart.getTotalPrice() == 216.45);
		assertEquals(true, cart.getTotalDiscount() == 0);
		cart.addProduct(jergens);
		assertEquals(true, cart.getTotalPrice() == 253.89);
		assertEquals(true, cart.getTotalDiscount() == 8);
		
		cart = new ShoppingCart(9);
		cart.addProduct(nivea, 3);
		cart.addProduct(jergens, 3);
		assertEquals(true, cart.getTotalPrice() == 396.76);
		assertEquals(true, cart.getTotalDiscount() == 71);
		
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

}
