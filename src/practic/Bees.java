package practic;

public class Bees extends Thread {

    private String name;

    public Bees(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (Main.locker) {
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Main.count < 11) {
                    System.out.println(this.getName() + " принесла в горшок 1 порцию  и тепеь там " + ++Main.count + " грамм меда");
                } else {
                    Main.locker.notify();
                    try {
                        Main.locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
