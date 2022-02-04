public class Area {
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

    public final String Description(){
        int Chanceofarea = (int) (Math.random() * 5);
        String AreaDescription = "";
        if (Chanceofarea == 1) {
            AreaDescription = Desert();
        }
        else if (Chanceofarea == 2) {
            AreaDescription = Swamp();
        }
        return AreaDescription;
    }


}
