package SE01;

public class DoubleLoops {

    public DoubleLoops() {
    }

    public static void main(String[] args) {
        int size = 5;
        int[][] arr = new int[size][size];

        int i;
        int j;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; ++j) {
                arr[i][j] = i != j && size - i != j + 1 ? 0 : 1;
            }
        }

        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; ++j) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();

        }
    }
}