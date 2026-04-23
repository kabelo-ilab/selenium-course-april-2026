import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author: Kabelo Tlhape
 **/
public class CalculatorTest {
    MyCalculator calc;
    @BeforeClass
    void setup(){
        int number1 = 5;
        int number2 = 3;
        calc = new MyCalculator(number1, number2);
    }

    @Test(testName = "TC1 - Test Sum", description = "Test the sum of two numbers")
    void testSum(){
        //Arrange - data / inputs to be used
        double expectedSum = 8;
        //Actual
        double actualSum = calc.sum();

        //Assert
        Assert.assertEquals(actualSum, expectedSum, "The sum should be 8");
    }

    @Test(testName = "TC2 - Test Difference", description = "Test the difference of two numbers")
    void testDifference(){
        //Arrange - data / inputs to be used
        double expectedDiff = 2;
        //Actual
        double actualDiff = calc.difference();
        //Assert
        Assert.assertEquals(actualDiff, expectedDiff, "The difference should be 2");
    }


}
