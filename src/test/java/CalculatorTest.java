import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CalculatorTest {
Calculator calculator1;
Calculator calculator2;
    @BeforeMethod(groups = {"easy"})
    private void setup1(){
         calculator1 = new Calculator();
        System.out.println("Inside Before setup 1 Method");
    }

    @BeforeMethod(groups = {"hard"})
    private void setup2(){
        calculator2 = new Calculator();
        System.out.println("Inside Before setup 2 Method");
    }

        @Test()
        private void testAdditionOfTwoNumbers(){
            int number1 = 1;
            int number2 = 2;
            int addition = calculator1.add(number1, number2);
            System.out.println("Addition");
            //Assert
            System.out.println("kiki");
            Assert.assertEquals(addition, 3);
        }

        @Test(groups = {"easy"})
        private void testGroupPrint1(){
         System.out.println("Inside easy group 1");
         calculator1.add(3,2);
        }

        @Test(groups = {"easy"})
        private void testGroupPrint2(){
            calculator1.add(3,2);
         System.out.println("Inside easy group 2");
        }

    @Test(groups = {"hard"})
    private void testGroupPrint3(){
        int addition = calculator2.add(5,7);
        System.out.println("Inside hard group 3");
    }

    @Test(groups = {"hard"})
    private void testGroupPrint4(){

        int addition = calculator2.add(5,7);
        System.out.println("Inside easy group 4");
    }

    @Test(enabled = true)
         private void testSubtractionOfTwoNumbers(){
            int number1 = 2;
            int number2 = 1;
            //Act
            int addition = calculator1.subtract(number1, number2);
        System.out.println("Subtraction");
            //Assert
             Assert.assertEquals(addition, 1);
        }

         @Test(timeOut = 200)
         private void testMultiplicationOfTwoNumbers(){
             int number1 = 2;
             int number2 = 2;
             //Act
             int addition = calculator1.multiply(number1, number2);
             System.out.println("Multiplication");
            //Assert
             Assert.assertEquals(addition, 4);
        }


        @Test (expectedExceptions = {IOException.class})
        private void testForException() throws IOException {
            int number1=1;
            int number2=1;
            int division = number1/number2;
            Assert.assertEquals(division,1);
            throw new IOException("Number cannot be divided by 0");
    }

        @Test()
        private void testPercentage(){
            int number1 = 20;
            int number2 = 40;
            //Act
            double addition = calculator2.percentage(number1, number2);
            System.out.println("Percentage");
            //Assert
            Assert.assertEquals(addition, 50);
        }

         @Test
         private void testSquareOfNumber(){
            int number1 = 5;
            //Act
            int addition = calculator2.square(number1);
            System.out.println("Square");
            //Assert
            Assert.assertEquals(addition, 25);
        }

    @DataProvider (name = "additionData")
    private Object[][] additionDataMethod(){
        return new Object[][]{{1,2,3},
                {2,3,5},
                {4,5,9}};
    }

    @Test (dataProvider = "additionData")
    private void testAdditionOfTwoNumbers(int a, int b, int result){
        //Act
        int addition = calculator2.add(a, b);
        //Assert
        Assert.assertEquals(addition, result);
    }

}


