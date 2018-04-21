
package SE02;

//Разработайте спецификацию и создайте класс Ручка (Pen). Определите в этом классе
//        методы equals(), hashCode() и toString().

public class Pen extends Staff {
    int articul = 0;
    String type;
    COLOR color;

    public Pen() {
    }

    public Pen(int articul, String type, COLOR color, double price) {
        this.articul = articul;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public COLOR getColor() {
        return this.color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public int getArticul() {
        return this.articul;
    }

    public void setArticul(int articul) {
        this.articul = articul;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Pen pen = new Pen();
            if (this.articul != pen.articul) {
                return false;
            } else if (this.name != pen.name) {
                return false;
            } else if (this.color != pen.color) {
                return false;
            } else {
                return this.type != null ? this.type.equals(pen.type) : pen.type == null;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.type != null ? this.type.hashCode() : 0;
        result = 31 * result + this.articul;
        return result;
    }

    public String toString() {
        return "Pen{type='" + this.type + "', articul=" + this.articul + ", color=" + this.color + ", price=" + this.price + ", name=" + this.name + "}";
    }
}
