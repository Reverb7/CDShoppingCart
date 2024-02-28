package reverb;


public class Product 
{
	// Initialises field
	private double price;
	private String name;
	private Offer offer;
	
	/**
	 * @param product price 
	 * @param product name
	 * Sets product price and name
	 */
	public Product(String name, double price) 
	{
		this.price = price;
		this.name = name;
		this.offer = null;
	}

	/**
	 * @return product price 
	 * 
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * @param product price 
	 * Sets product price
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}

	/**
	 * @return product name 
	 * 
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param product name
	 * Sets product name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	/**
	 * @return product BuyXGetYFree offer
	 * 
	 */
	public Offer getOffer() 
	{
		return this.offer;
	}

	/**
	 * @param product BuyXGetYFree offer
	 * Sets product BuyXGetYFree offer
	 */
	public void setOffer(Offer offer) 
	{
		this.offer = offer;
	}

	
}
