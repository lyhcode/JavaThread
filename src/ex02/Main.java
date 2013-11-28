package ex02;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new HelloThread("John");
        Thread thread2 = new HelloThread("Mary");
        Thread thread3 = new HelloThread("Kyle");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class HelloThread extends Thread {

    private final String who;

    public HelloThread(String name) {
        who = name;
    }

    @Override
    public void run() {
        System.out.println("Hello " + who);
    }
}
