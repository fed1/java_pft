package by.stqa.pft.sandbox;

public class MyFirstProgram {

public static void main (String [] args){

    Point p1 = new Point(-14);
    Point p2 = new Point(-35);


    System.out.println("Дистанция между точками = " + distance(p1, p2));

}

   public static double distance(Point p1, Point p2){

    return Math.sqrt(Math.pow(p1.pointValue,2)+ Math.pow(p2.pointValue,2));
   }
}