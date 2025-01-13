class Warrior {
    // Attributes
    private int level;
    private String name;
    private String gender;
    private String race;


    // Constructors
    public Warrior(int level, String name, String gender, String race){
        this.level = level;
        this.name = name;
        this.gender = gender;
        this.race = race;
    }

    // Methods

    public int getLevel(){
        return this.level;
    }

    public String getName(){
        return this.name;
    }

    public String getGender(){
        return this.gender;
    }

    public String getRace(){
        return this.race;
    }

    public void levelUp(){
        this.level += 1;
    }

}

class testDrit{
    public static void main(String[] args){
        System.out.println("Jeg lager en kriger");
        Warrior party[] = [10]; 
        for (int i = 0; i<21; i++){
            azo.levelUp();
        }
        System.out.println("The warrior " + azo.getName() + " is level " + azo.getLevel() + " and is a " + azo.getGender() + " " + azo.getRace());
    }
}