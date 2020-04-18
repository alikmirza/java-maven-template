package FigureApp;

import java.util.ArrayList;

import java.util.ArrayList;

public class FiguresApp {

    public static Figure rand_figure() {
        switch ((int)(Math.random()*3)) {
            case 0: return Circle.rand();
            case 1: return Triangle.rand();
            case 2: return Rectangle.rand();
            default: throw new IllegalArgumentException("java random is broken :(");
        }
    }

    public static void main(String[] args) {
        //Triangle tr = new Triangle(new Point(6,1), new Point(2,3), new Point(4,5));
        //Rectangle rt = new Rectangle(new Point(2,6), new Point(9,3));
        //Circle cr = new Circle(new Point(3,1),8);

        ArrayList<Figure> figures = new ArrayList<>();
        //figures.add(tr);
        //figures.add(rt);
        //figures.add(cr);
        for (int i = 0; i < Fn.rand(); i++) {
            figures.add(rand_figure());
        }

        int total = 0;
        for (Figure f: figures) {
            System.out.println(f);
            total += f.area();
        }
        System.out.printf("The total area is %d\n", total);
    }
}
