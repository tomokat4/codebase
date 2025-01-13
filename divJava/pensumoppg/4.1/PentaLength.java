import java.lang.Math; 
import java.util.Scanner;

class PentaLength{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a radius from the centre to the vertex of a pentagon :");
        Pentagon pentagon1 = new Pentagon(input.nextDouble());
        System.out.println("The area of this pentagon is " + pentagon1.getArea() + ".");
    }
}

class Pentagon{
    double vertex;

    public Pentagon() {
        vertex = 0;
    }

    public Pentagon(double newVertex) {
        vertex = newVertex;
    }

    public double getArea() {
        double side = (2*vertex*Math.sin(Math.PI/5));
        double area = ((5 * (side * side)) / (4 * Math.tan(Math.PI/5)));
        return area;
    }

    public void setVertex(double newVertex) {
        vertex = newVertex;
    }
}