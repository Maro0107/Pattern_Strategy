import com.patterns.strategy.CorporateCustomer;
import com.patterns.strategy.Customer;
import com.patterns.strategy.IndividualCustomer;
import com.patterns.strategy.IndividualYoungCustomer;
import com.strategy.predictor.AggressivePredictor;
import org.junit.Assert;
import org.junit.Test;


public class CustomerTestSuite {


    @Test
    public void testDefaultInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer marek = new CorporateCustomer("Maro");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String marekShouldBuy = marek.predict();
        System.out.println("Marek should: " + marekShouldBuy);

        //Then
        Assert.assertEquals("[Conservative predictor] Buy debentures of XYZ",stevenShouldBuy);
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ",johnShouldBuy);
        Assert.assertEquals("[Balanced predictor] Buy shared units",marekShouldBuy);
    }

    @Test
    public void testIndividualInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

                //Then
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
