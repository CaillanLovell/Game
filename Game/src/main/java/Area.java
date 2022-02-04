public class Area extends Enemy {
    Main main = new Main();
    private String AreaDescription;
    public String Desert(){

        return "You enter an arid, dry land, with sand stretching as far as the eye can see. \n" +
                "The new terrain slows your progress and the sun beaming in the sky drys your mouth. \n" +
                "Your move speed and stamina is decreased. Where will you head?";

    }

    public String Swamp(){

        return "You enter a humid wetland, steam coiling up in the air before you. \n" +
                "The new area that bubbles and squishing beneath your every step slows your progress. \n" +
                "Your move speed is decreased. Where will you head?";

    }

    public String Tundra(){

        return "You enter a cold, icy field, the frigid air attempting to freeze your lungs with every breath. . \n" +
                "The new area's snowy terrain clutches at your feet with every step, slowing your progress. \n" +
                "Your move speed is decreased. Where will you head?";

    }

    public String Mountain(){

        return "The air grows thin as you look down at the dizzying height you have climbed to on this grim peak. \n" +
                "The mountain's rocky face resists your efforts to climb, but you press on nonetheless. \n" +
                "Your move speed is decreased. Where will you head?";

    }

    public String Continued(){
        return "The terrain continues unchanged, and you press on towards your unknown destination,\n" +
                "the mysterious compass burning a hole in your pocket.";
    }


    public final String Description(int [] Coord){
        Enemy enemy1 = new Enemy();
        int OldChance = 0;
        int Chanceofarea = (int) (Math.random() * 8);
        final int Coordtype = Chanceofarea;
        if (Chanceofarea == 1) {
            AreaDescription = Desert();
            OldChance = Chanceofarea;
        }
        else if (Chanceofarea == 2) {
            AreaDescription = Swamp();
            OldChance = Chanceofarea;
        }

        else if (Chanceofarea == 3) {
            AreaDescription = Tundra();
            OldChance = Chanceofarea;
        }

        else if (Chanceofarea ==4) {
            AreaDescription = Mountain();
            OldChance = Chanceofarea;
        }
        else if (enemy1.encounter == true){

        }
        else if (OldChance == Chanceofarea){
            AreaDescription = Continued();

    }
        else {
            AreaDescription = Continued();
        }

        return AreaDescription;

}

}
