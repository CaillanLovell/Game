

public class Player {

    public static String name = "Baldur";


    public static int Playerlevel = 1;

    public static int PlayerExp = 0;

    public static int Levelup(){
        if (PlayerExp >= (100 + 20*Playerlevel)){
            System.out.println("You levelled up!");
            Playerlevel += 1;
            PlayerExp = 0;
        }
        else{

        }
        return 0;
    }

    public static int MaxHealth = 25 + (5*Playerlevel);

    public static int CurrentHealth = 25 + (5*Playerlevel);

    public static int Damage =  (int) (Math.random()*(4*Playerlevel)+7);

    public static String getName(){
        return name;
    }
    public static int Potions = 3;


    public void setName(String newName){
        this.name =newName;
    }

    public static int[] Position(){
        int [] StartPosition = {0,0};
        return StartPosition;

    }

}
