package by.stqa.pft.sandbox;

public class Point {

    public double pointX;
    public double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public Point() {
    }

    public  double distance(){

        this.pointX = pointX;
        this.pointY = pointY;

        return Math.sqrt(Math.pow(pointX,2)+ Math.pow(pointY,2));
    }
}
