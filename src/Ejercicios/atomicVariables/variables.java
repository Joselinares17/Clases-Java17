package Ejercicios.atomicVariables;

public class variables {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread first = new Thread(counter, "First");

        first.start();

        System.out.println(counter.count);

    }

    static class Counter extends Thread{
        public int count = 0;
        public void run() {
            for(int i = 0; i < 100_000_000; i++) {
                count++;
            }
        }
    }
}


