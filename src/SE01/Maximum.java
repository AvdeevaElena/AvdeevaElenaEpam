package SE01;

public class Maximum {
    public Maximum() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5};
        if (arr.length < 2) {
            System.out.println("Кол-во элементов должно более двух.");
        } else {
            int maxValue = arr[0] + arr[1];

            for(int i = 0; i < (args.length + arr[1]) / arr[2]; ++i) {
                if (arr[i] + arr[arr.length - i - arr[1]] > maxValue) {
                    maxValue = arr[i] + arr[arr.length - i - arr[1]];
                }
            }

            System.out.println(maxValue);
        }

    }
}