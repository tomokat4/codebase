import java.util.Scanner;
import java.util.Random;


class TestLocationMatrix {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tast inn antall rader i matrisen: ");
        int row = scanner.nextInt();
        System.out.print("Tast inn antall kolonner i matrisen: ");
        int col = scanner.nextInt();
        double[][] matrix = new double[row][col];
        
        fillMatrix(matrix);
        printMatrix(matrix);
        Location location = new Location();
        location.locateLargestElement(matrix);
        System.out.printf("Største element i matrisen er: %.2f \n",  + location.maksVerdi);
        System.out.println("Største element er på rad: " + location.radNr + " og på kolonne nummer: " + location.kolonneNr);  
        
        
    }


    // Metode for å fylle matrise, fra ArrayMatrixDemo
    static void fillMatrix(double[][] matrix){
            Random random = new Random();
                for(int row = 0; row < matrix.length; row++){
                    for(int col = 0; col < matrix[row].length; col++){
                        matrix[row][col] = random.nextDouble()*1000;
                    }
                }
    }

    // Metode for å printe matrise, fra ArrayMatrixDemo
    static void printMatrix(double[][] matrix){
                System.out.println(" ");
                for(int row = 0; row < matrix.length; row++){
                    for(int col = 0; col < matrix[row].length; col++){
                        System.out.printf("[%.2f]",matrix[row][col]);
                    
                            
            }System.out.println();
        }System.out.println();
    }
}




class Location{
    //Datafelt
    public int radNr, kolonneNr;
    public double maksVerdi;


    //Metoder
    public void locateLargestElement(double[][] matrix){
        maksVerdi = matrix[0][0];
        radNr = 0;
        kolonneNr = 0;
       

        // Nested for-loop som for hver row sjekker hver column for høyeste verdi
         for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > maksVerdi) {
                    maksVerdi = matrix[row][col];
                    radNr = row+1;
                    kolonneNr = col+1;
                    
                }
            }


        } 
        
    }
}