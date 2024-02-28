package reverb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BuyXGetFreeTest.class, BuyXGetYDiscountOnNextOneTest.class, ProductTest.class, ShoppingCartTest.class,
		StepsTest.class })
public class AllTests 
{

}
