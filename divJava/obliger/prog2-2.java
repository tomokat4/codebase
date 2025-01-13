import java.util.*;

class Oblig2Oppgave1_261656{
    public static void main(String[] args){
        System.out.println("Test av oblig 2 startet");
        ComparableSphere kule1 = new ComparableSphere(2);
        ComparableSphere kule2 = new ComparableSphere(1.2);
        ComparableSphere kule3 = new ComparableSphere(4.4);
        ComparableSphere kule4 = new ComparableSphere(2.8);


        ComparableSphere[] kuleArray = new ComparableSphere[4];

        kuleArray[0] = kule1;
        kuleArray[1] = kule2;
        kuleArray[2] = kule3;
        kuleArray[3] = kule4;

        System.out.println("-------------------------\n");

        System.out.println("Array før sortering");
        for(ComparableSphere kule : kuleArray){
            System.out.println(kule);
        }
        Arrays.sort(kuleArray);

        System.out.println("-------------------------\n");


        System.out.println("Array etter sortering");
        for(ComparableSphere kule : kuleArray){
            System.out.println(kule);
        }
        System.out.println("-------------------------\n");
    }
}

class ComparableSphere extends Sphere implements Comparable<ComparableSphere> {
    public ComparableSphere(double radius){
        super(radius);
    }
    @Override
    public int compareTo(ComparableSphere otherSphere){
        if(this.calculateVolume() < otherSphere.calculateVolume()){
            return 1;
        }
        else if(this.calculateVolume() > otherSphere.calculateVolume()){
            return -1;
        }
        return 0;
    }
}

class Circle {
  private double radius;

  public Circle() {
    //SimpleGeometricObject blir kalt opp
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }
  
  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }
  
  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  public boolean equals(Object object) {
      if(object instanceof Circle) {
          return radius == ((Circle)object).radius;
      }
      else{
          return false;
      }
  }

}


class Sphere extends Circle {
    public Sphere(double radius) {
        super(radius);
    }
    public double calculateArea(){
    //Henter radius fra superklassen Circle her:
    return 4*Math.PI*Math.pow(super.getRadius(), 2);
    }

    public double calculateVolume(){
    //Henter radius fra superklassen Circle her:
    return 4*Math.PI*Math.pow(super.getRadius(), 3) / 3.0;
    }

    //override:
    public String toString(){
    return "kule med radius ="
    + super.getRadius()+"\nhar volum = "
    + this.calculateVolume();
    }
}
