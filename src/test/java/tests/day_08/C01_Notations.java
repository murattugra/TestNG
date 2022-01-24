package tests.day_08;

import org.testng.annotations.Test;

public class C01_Notations {


    @Test(priority = -9)// once bu
    public void youtubeTest(){
        System.out.println("youtubetest calisti");

    }


    @Test// priorty olmazs o kabul eder 2. bu calisir

    public void amazonTest(){
        System.out.println("amazon test calisti");

    }

    @Test(priority = 5)// 3. bu
    public void bestbuyTest(){
        System.out.println("bestbuy test calisti");

    }
}
