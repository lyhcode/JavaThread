package ex01;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new HelloThread();
        thread1.start();
    }
}

class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}
