import java.util.Random;

class RandomLetter{
    public static void main(String[] args){
        System.out.println("Dette program vil vise deg en tilfeldig bokstav!");
        Random rand = new Random();

        int preTall = rand.nextInt(25) + 65;
        String bokstav = Character.toString((char) preTall);
        System.out.println("Nå har jeg generert bokstaven: " + bokstav);
    }
}