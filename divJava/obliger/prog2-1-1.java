import java.util.*;

class LinearEquation{
    //Datafields
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;


    //Constructors

    public LinearEquation(double x[], double y[]){
        a = (y[0] - y[1]);
        b = -(x[0] - x[1]);
        c = (y[2] - y[3]);
        d = -(x[2] - x[3]);
        e = (y[0] - y[1]) *  x[0] - (x[0] - x[1]) * y[0];
        f = (y[2] - y[3]) * x[2] - (x[2] - x[3]) * y[2];
    }

    //Methods

    public void isSolvable(){
        if (a*d - b*c != 0){
            System.out.println("Likningen kan loeses");
            solveEquation();

        }
        else {
            System.out.println("Likningen kan ikke loeses");
        }
    }

    public void solveEquation(){
        double x = (e * d - b * f)/ab_Minus_bc();
        double y = (a * f - e * c)/ab_Minus_bc();
        System.out.println("Funksjonene du har oppgitt krysser i x = " + x + " og y = " + y);
    }

    public double ab_Minus_bc(){
        return (a*d - b*c);
    }
}

class TestLinearEquation{
    public static void main(String[] args){
        double x[];
        double y[];
        x = new double[4];
        y = new double[4];
        Scanner input = new Scanner(System.in);
        System.out.println("Hei! oppgi start og slutt xy koordinatene til F(x) og G(x)!");
        for(int i = 0;i<4;i++){
            int index = i + 1;
            System.out.println("x " + index + " er : ");
            x[i] = input.nextDouble();
            System.out.println("Du har oppgitt x" + index + " = " + x[i]);
        }
        for(int i = 0;i<4;i++){
            int index = i + 1;
            System.out.println("y " + index + " er : ");
            y[i] = input.nextDouble();
            System.out.println("Du har oppgitt y" + index + " = " + x[i]);
        }
        LinearEquation test = new LinearEquation(x, y);
        test.isSolvable();
    }
}