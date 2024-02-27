package reverb;


public class ShoppingCartApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Working");
		
		ShoppingCart cart = new ShoppingCart();
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
