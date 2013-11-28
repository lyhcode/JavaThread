package ex09;

public class Client extends Thread {

    private final Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.deposit(1000);
        bank.withdraw(900);
    }

}
