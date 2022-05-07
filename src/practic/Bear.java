package practic;

public class Bear extends Thread {
    private String name;

    public Bear(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Main.locker) {
            try {
                Main.locker.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Main.count > 10) {
                System.out.println("Пришел " + Thread.currentThread().getName() + " и все съел");
                Main.count = 1;
                Main.locker.notifyAll();
                try {
                    Main.locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
