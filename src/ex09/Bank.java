package ex09;

public class Bank {

    private int money = 0;

    public synchronized void balance() {
        System.out.println("Balance: " + money);
    }

    public synchronized void withdraw(int m) {
        money -= m;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

}
