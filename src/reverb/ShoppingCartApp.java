package reverb;


public class ShoppingCartApp 
{

	public static void main(String[] args) 
	{
		
		ShoppingCart cart = new ShoppingCart(10);
		Product doveSoap = new Product("Dove Soaps", 39.99);
		Product niveaSoap = new Product("Nivea Soaps", 50);
		Product jergens = new Product("Jergens Lotion", 40);
		Product axeDeo = new Product("Axe Deo", 99.99);
		
		cart.addProduct(doveSoap, 5);
		cart.addProduct(jergens);
		cart.addProduct(jergens);
		cart.displayProducts();
		
		

	}
	
	// For testing
	public static void console(String name)
	{
		System.out.println(name);
	}


}
