package by.stqa.pft.sandbox;

public class MyFirstProgram {

   public static void main (String [] args){

       Point p1 = new Point(5,6);
       Point p2 = new Point(14,-76);
       Point p3 = new Point(-123,-0.78);

       System.out.println("Дистанция между точками = " + p1.distance()
                                                        + "; " + p2.distance()
                                                        + "; " + p3.distance());
       }
}