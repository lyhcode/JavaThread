package ex03;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new CountDownThread(5);
        thread1.start();
        
        thread1.join();
        
        System.out.println("END");
    }
}

class CountDownThread extends Thread {
    
    private final int num;
    
    public CountDownThread(int num) {
        this.num = num;
    }
    
    @Override
    public void run() {
        for (int i = num; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
