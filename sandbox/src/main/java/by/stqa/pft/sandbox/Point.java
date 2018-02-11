package by.stqa.pft.sandbox;

public class Point {

    public double pointX;


    public Point(double pointX){
        this.pointX = pointX;

    }

    public  double distance(Point second){

        return Math.sqrt(Math.pow(pointX,2)+ Math.pow(second.pointX,2));
    }
}
