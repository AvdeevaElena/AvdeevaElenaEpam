package SE01;

public class Loops {
    public Loops() {
    }

    public static void main(String[] args) {
        double start = 10.0D;
        double end = 20.0D;
        double step = 2.0D;

        do {
            double f = Math.tan(2.0D * start) - 3.0D;
            System.out.println(start + ": " + f);
        } while((start += step) <= end);

    }
}
