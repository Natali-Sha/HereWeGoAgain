package io.ctdev.tests.login;




import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {


    public String data_1() {
        return "a";
    }
    public String data_2() {
        return "b";
    }


    public String data_3() {
        return "c";
    }

    public String data_4() {
        return "null";
    }

    @org.testng.annotations.DataProvider(name = "allData")
    public Object [][] dataProviderMethod() {

        return new Object[][] { { data_1() }, { data_2() }, { data_3() },  { data_4() } };

    }

    @Test(dataProvider = "allData")

    public void testMethod(String data) {

        System.out.println("Data is - "  + data);

        Assert.assertNotNull(data, "Data is null");


    }
}

