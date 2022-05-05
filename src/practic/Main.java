package practic;


public class Main {
    public static Integer count = 100;

    public static void main(String[] args) {


        Bees b1 = new Bees("пчела 1");
        Bees b2 = new Bees("пчела 2");
        Bear bear = new Bear("Мишка");
        b1.setName("Пчела 1");
        b2.setName("Пчела 2");
        bear.setName("Мишка");
        b1.start();
        b2.start();
        bear.start();


    }
}
