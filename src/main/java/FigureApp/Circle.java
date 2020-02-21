package FigureApp;

public class Circle extends Figure {
    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.center=center;
        this.radius=radius;
    }

    public static Circle rand() {
        return new Circle(Point.rand(), Fn.rand());
    }

    @Override
    public int area() {
        return (int)(Math.PI * radius * radius);
    }

    @Override
    public String toString(){
        return String.format("Area of Circle: %d",area());
    }
}