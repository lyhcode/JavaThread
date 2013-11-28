package ex05;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter1 = new Counter();

        for (int i = 0; i < 9999; i++) {
            new CounterThread(counter1, CounterThread.METHOD.NORMAL).start();
        }

        Counter counter2 = new Counter();

        for (int i = 0; i < 9999; i++) {
            new CounterThread(counter2, CounterThread.METHOD.SYNC).start();
        }

        Counter counter3 = new Counter();

        for (int i = 0; i < 9999; i++) {
            new CounterThread(counter3, CounterThread.METHOD.SYNC2).start();
        }

        System.out.println(counter1.count);
        System.out.println(counter2.count);
        System.out.println(counter3.count);
    }
}

class Counter {

    public int count = 0;

    private Object obj = new Object();

    public void plus() {
        count++;
    }

    public synchronized void syncPlus() {
        count++;
    }

    public void syncPlus2() {
        synchronized (obj) {
            count++;
        }
    }
}

class CounterThread extends Thread {

    enum METHOD {

        NORMAL, SYNC, SYNC2;
    };

    private final Counter counter;
    private final METHOD method;

    public CounterThread(Counter counter, METHOD method) {
        this.counter = counter;
        this.method = method;
    }

    @Override
    public void run() {
        if (method.equals(METHOD.NORMAL)) {
            counter.plus();
        } else if (method.equals(METHOD.SYNC)) {
            counter.syncPlus();
        } else if (method.equals(METHOD.SYNC2)) {
            counter.syncPlus2();
        }
    }
}
