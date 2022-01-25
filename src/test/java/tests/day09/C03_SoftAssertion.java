package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {


    @Test
    public  void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(a,b);// FAILED
        softAssert.assertTrue(a>b);//FAILED
        softAssert.assertTrue(a<c);//PASSED
        softAssert.assertTrue(c>b);//PASSED
        softAssert.assertTrue(c<a);//FAILED

        //asserAll demezsek class calisir ve passed yazar
        // aslinda raporlama yapmaz ve odlar calismis olur

        softAssert.assertAll();
        System.out.println("eger sofassert lerden failed olan varsa bu satir calismaz");

    }


}
