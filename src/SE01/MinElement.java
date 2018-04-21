package SE01;



public class MinElement {
    public MinElement() {
    }

    public static void main(String[] args) {
        double a = 1.5D;
        double b = 2.5D;
        double h = 0.3D;

        do {
            double f = Math.tan(2.0D * a) - 3.0D;
            System.out.println(a + ": " + f);
        } while((a += h) <= b);

    }
}
