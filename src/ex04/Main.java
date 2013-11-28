package ex04;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(new Date());

        Thread.sleep(5000);

        System.out.println(new Date());
    }
}
