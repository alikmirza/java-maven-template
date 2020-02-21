package FigureApp;

public class Triangle extends Figure {
    Point point1;
    Point point2;
    Point point3;

    public Triangle(Point pt1, Point pt2, Point pt3) {
        this.point1 =pt1;
        this.point2 =pt2;
        this.point3 =pt3;
    }

    public static Triangle rand() {
        return new Triangle(Point.rand(), Point.rand(), Point.rand());
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }

    @Override
    public int area() {
        double side1 = distance(point1, point2);
        double side2 = distance(point2, point3);
        double side3 = distance(point3, point1);
        double hp = (side1 + side2 + side3) / 2;
        return (int)(Math.sqrt(hp*(hp-side1)*(hp-side2)*(hp-side3)));
    }

    @Override
    public String toString(){
        return String.format("Area of Triangle: %d",area());
    }

}
