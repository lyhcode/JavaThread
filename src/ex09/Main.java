package ex09;

/**
 * Multi-thread Example: Bank
 */
public class Main {

    public static void main(String[] args) {

        for (int j = 0; j < 5; j++) {

            final Bank bank = new Bank();

            for (int i = 0; i < 1000; i++) {
                new Client(bank).start();
            }

            while (Thread.currentThread().getThreadGroup().activeCount() > 1) {
                //wait
            }

            bank.balance();
        }

    }

}
