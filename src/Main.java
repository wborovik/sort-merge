import java.util.Arrays;

public class Main {

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            sort(A, p, q);
            sort(A, q + 1, r);

            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {

        int leftSize = q - p + 1;
        int rightSize = r - q;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = A[p - 1 + i];
        }

        for (int i = 0; i < rightSize; i++) {
            right[i] = A[q + i];
        }

        int i = 0, j = 0, k = p - 1;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            A[k++] = left[i++];
        }

        while (j < rightSize) {
            A[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3, 2, 6};

        sort(A, 1, A.length);

        System.out.println(Arrays.toString(A));
    }
}