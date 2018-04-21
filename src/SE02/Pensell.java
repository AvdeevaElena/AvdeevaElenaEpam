package SE02;

public class Pensell extends Staff {
    COLOR color;

    public Pensell() {
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public COLOR getColor() {
        return this.color;
    }

    public String toString() {
        return "Pensell{, color=" + this.color + ", price=" + this.price + ", name=" + this.name + "}";
    }
}