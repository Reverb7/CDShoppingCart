package reverb;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart 
{
	//Initialise fields
	private ArrayList<Product> productList;
	
	public ShoppingCart() 
	{
		this.productList = new ArrayList<Product>();
	}

	/**
	 * @return product list
	 */
	public ArrayList<Product> getProductList() 
	{
		return productList;
	}
	
	/**
	 * @return product display
	 */
	public void displayProducts() 
	{
		System.out.println("***--------------------***");
		System.out.println();
		
		// Loops through unique product list to display total amount and unit price
		for(String name: getUniqueProducts())
		{
			Product product = getProduct(name);
			int count = countProduct(name);
			System.out.println("Product: " + name + ", Unit price: £" + product.getPrice() + ", Quantity: x" + count);
		}
		
		//Calculates total price
		System.out.println();
		System.out.println("Total Price: £" + getTotalPrice());
		System.out.println();
		System.out.println("***--------------------***");

	}

	/**
	 * @param product to add to shopping cart
	 * Sets product price
	 */
	public void addProduct(Product product) 
	{
		this.productList.add(product);
	}
	
	/**
	 * @param product to add to shopping cart with quantity
	 * Sets product price
	 */
	public void addProduct(Product product, int count) 
	{
		for(int i = 0; i < count; i++)
		{
			this.productList.add(product);
		}
	}

	/**
	 * @return products total price 
	 */
	public Double getTotalPrice() 
	{
		double totalPrice = 0;
		
		// loop through unique product list to get total price
		for(String name: getUniqueProducts())
		{
			Product product = getProduct(name);
			int count = countProduct(name);
			// Calculates price in cents
			double price = product.getPrice() * 100 * count;
			totalPrice += price;
		}
		
		// Formats total price to 2dp
		return Double.parseDouble(new DecimalFormat("#.00").format(totalPrice/100));
	}
	
	/**
	 * @return product of name 
	 */
	public Product getProduct(String name) 
	{
		Product productFound = null;
		
		// Loops through product list to get product
		for(Product product: productList)
		{
			if(product.getName().equalsIgnoreCase(name))
			{
				productFound = product;
			}
		}
		
		return productFound;
	}
	
	/**
	 * @param product name
	 * Counts total number of product with name in the cart
	 */
	public int countProduct(String name) 
	{
		int count = 0;
		
		//loops through product list to count product with name
		for(Product product: productList)
		{
			if(product.getName().equalsIgnoreCase(name))
			{
				count++;
			}
		}
		
		return count;
	}
	
	
	/**
	 * @return unique product list
	 */
	public ArrayList<String> getUniqueProducts() 
	{
		ArrayList<String> uniqueProducts = new ArrayList<String>();
		
		//loops through product list to get unique product name
		for(Product product: productList)
		{
			if(!uniqueProducts.contains(product.getName()))
			{
				uniqueProducts.add(product.getName());
			}
		}
		
		return uniqueProducts;
	}

	
}
