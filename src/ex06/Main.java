package ex06;

public class Main {

    public static void main(String[] args) throws InterruptedException {

    Game game = new Game();

    Thread thread = new Thread(game);
    thread.start();

    Thread.sleep(2000);

    game.suspend();

    Thread.sleep(2000);

    game.resume();

    Thread.sleep(3000);

    game.stop();
    }
}

class Game implements Runnable {

    private boolean isContinue = true;
    private boolean isSuspend = false;
    
    private int round = 0;

    @Override
    public void run() {
        while (isContinue) {
            while (isContinue && !isSuspend) {
                try {
                    Thread.sleep(1000);
                    System.out.println("round " + ++round);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        isContinue = false;
    }
    
    public void suspend() {
        isSuspend = true;
    }
    
    public void resume() {
        isSuspend = false;
    }
}

