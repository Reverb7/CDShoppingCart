package reverb;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart 
{
	//Initialise fields
	private ArrayList<Product> productList;
	private double taxRate;
	
	/**
	 * Default constructor with no parameters
	 */
	public ShoppingCart() 
	{
		this.productList = new ArrayList<Product>();
		taxRate = 0;
	}
	
	/**
	 * @param Shopping cart tax rate
	 * Constructor with tax rate parameter
	 */
	public ShoppingCart(double taxRate) 
	{
		this.productList = new ArrayList<Product>();
		this.taxRate = taxRate;
	}
	
	/**
	 * @return shopping cart tax rate
	 */
	public double getTaxRate() 
	{
		return taxRate;
	}
	
	/**
	 * @return shopping cart tax amount
	 */
	public double getTaxAmount() 
	{
		double totalAmount = getTotalProductAmount() * 100;
		
		// Formats total price to 2dp
		return get2dp((totalAmount * taxRate) / 10000);
	}

	/**
	 * @param taxRate of shopping cart
	 * Sets shopping cart tax rate
	 */
	public void setTaxRate(double taxRate) 
	{
		this.taxRate = taxRate;
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
	 * @return products total amounts
	 */
	private Double getTotalProductAmount() 
	{
		double totalAmount = 0;
		
		// loop through unique product list to get total price
		for(String name: getUniqueProducts())
		{
			Product product = getProduct(name);
			int count = countProduct(name);
			// Calculates price in cents
			double price = product.getPrice() * 100 * count;
			totalAmount += price;
		}
		
		// Formats total amount to 2dp
		return get2dp(totalAmount / 100);
	}

	/**
	 * @return products total price with tax rate
	 */
	public Double getTotalPrice() 
	{
		// Calculation in cents
		double totalAmount = getTotalProductAmount() * 100;
		
		totalAmount += (getTaxAmount() * 100);
		
		// Formats total price to 2dp
		return get2dp(totalAmount / 100);
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

	/**
	 * @return two decimal point double with rounding up
	 */
	public double get2dp(double number) 
	{
        String dpNum = String.format("%.2f", Math.ceil(number * 10000) / 10000);

        // Parse back to double:
        return Double.parseDouble(dpNum);

	}
}
