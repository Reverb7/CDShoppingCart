package reverb;

public class BuyXGetYFree 
{
	// Initial fields
	private int requirementQuan, offerQuan;

	/**
	 * @param requirement Quantity
	 * @param offer quantity
	 */
	public BuyXGetYFree(int requirementQuan, int offerQuan) 
	{
		super();
		this.requirementQuan = requirementQuan;
		this.offerQuan = offerQuan;
	}

	/**
	 * @return requirement Quantity
	 */
	public int getRequirementQuan() 
	{
		return requirementQuan;
	}

	/**
	 * @param requirement Quantity
	 */
	public void setRequirementQuan(int requirementQuan) 
	{
		this.requirementQuan = requirementQuan;
	}

	/**
	 * @return offer Quantity
	 */
	public int getOfferQuan() 
	{
		return offerQuan;
	}

	/**
	 * @param offer Quantity
	 */
	public void setOfferQuan(int offerQuan) 
	{
		this.offerQuan = offerQuan;
	}
	
	

}
