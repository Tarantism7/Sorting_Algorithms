public class IntroSorter {
    private final int THRESHOLD = 16;

    @Override
    public double[] sort(double[] a) {
        if (a == null || a.length <= 1) return a;
        introSort(a, 0, a.length - 1);
        return a;
    }

    private void introSort(double[] a, int p, int r) {
        if (r - p + 1 < THRESHOLD) {
            insertionSort(a, p, r);
        } else if (p < r) {
            int q = partition(a, p, r);
            introSort(a, p, q - 1);
            introSort(a, q + 1, r);
        }
    }

    private void insertionSort(double[] a, int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= p && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private int partition(double[] a, int p, int r) {
        double x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                exchange(a, i, j);
            }
        }
        exchange(a, i + 1, r);
        return i + 1;
    }

    private void exchange(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
