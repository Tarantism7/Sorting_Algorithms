public class Benchmarks {
    private static final int NUM_RUNS = 10;
    private static final int[] ARRAY_SIZES = {100, 1000, 15000, 50000, 100000};


    public static void main(String[] args) {
        Sorter insertionSort = new InsertionSorter();
        Sorter quickSort = new QuickSorter();
        Sorter introSort = new IntroSorter();

        for (int size : ARRAY_SIZES) {
            double insertionTime = 0;
            double quickTime = 0;
            double introTime = 0;

            for (int i = 0; i < NUM_RUNS; i++) {
                double[] ra = generateRandomArray(size);

                double[] insertionA = ra.clone();
                double[] quickA = ra.clone();
                double[] introA = ra.clone();

                long start = System.nanoTime();
                quickSort.sort(quickA);
                long end = System.nanoTime();
                quickTime += (end - start) / 1e6;

                start = System.nanoTime();
                introSort.sort(introA);
                end = System.nanoTime();
                introTime += (end - start) / 1e6;
            }
            System.out.printf("\n" + "Array size: %d\n", size);
            System.out.printf("Quick:  %2f ms\n", quickTime / NUM_RUNS);
            System.out.printf("Intro:  %2f ms\n", introTime / NUM_RUNS);
        }
    }

    private static double[] generateRandomArray(int size) {
        Random r = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextDouble();
        }
        return array;
    }
}
