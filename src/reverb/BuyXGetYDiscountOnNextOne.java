package reverb;

public class BuyXGetYDiscountOnNextOne implements Offer
{
	// Initial fields
		private int requirementQuan, offerDiscount;

		/**
		 * @param requirement Quantity
		 * @param offer quantity
		 */
		public BuyXGetYDiscountOnNextOne(int requirementQuan, int offerDis) 
		{
			super();
			this.requirementQuan = requirementQuan;
			this.offerDiscount = offerDis;
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
		 * @return offer Discount
		 */
		public int getOfferDiscount() 
		{
			return offerDiscount;
		}

		/**
		 * @param offer Discount
		 */
		public void setOfferDiscount(int offerDis) 
		{
			this.offerDiscount = offerDis;
		}

}
