package homework5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException{

        fillArray();
        fillArrayTread();
    }

    static void fillArray() {
        float[] array = new float[SIZE];

        Arrays.fill(array, 1);
        long a = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время выполнение метода вычисляющий новые значения массива без разбиения на потоки: " + (System.currentTimeMillis() - a));
    }

    static void fillArrayTread() throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] a1 = new float[H];
        float[] a2 = new float[H];

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);
        Thread t1 = new Thread(new Fill(a1));
        Thread t2 = new Thread(new Fill(a2));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.println("Время выполнение метода вычисляющий новые значения массива с разбиением на два потока: " + (System.currentTimeMillis() - a));
    }

    static class Fill implements Runnable {
        private float[] array;

        Fill(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++)
                array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
