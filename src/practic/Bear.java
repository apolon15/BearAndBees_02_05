package practic;

public class Bear extends Thread {
    private String name;

    public Bear(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            this.wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Main.count == 0) {
            System.out.println("Пришел " + Thread.currentThread().getName() + " и все съел");
            Main.count = 100;
            this.notifyAll();
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
