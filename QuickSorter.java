public class QuickSorter {
    public double[] sort(double[] a) {
        if (a == null || a.length <= 1) return a;
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private void quickSort(double[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
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
