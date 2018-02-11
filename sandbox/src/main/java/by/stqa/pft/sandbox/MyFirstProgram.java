package by.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point(5);
        Point p2 = new Point(6);
        Point p3 = new Point(-76);
        Point p4 = new Point(-0.78);

        System.out.println("Дистанция между точками = "+p1.distance(p2)
                + "; " + p2.distance(p1)
                + "; " + p3.distance(p4));

    }

}