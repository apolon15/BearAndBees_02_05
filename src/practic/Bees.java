package practic;

public class Bees extends Thread {

    private String name;

    public Bees(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " принесла в горшок " + Main.count--);
            Main.count-=Main.count;
            if (Main.count==0){
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
