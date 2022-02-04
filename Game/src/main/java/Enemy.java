import java.util.Scanner;

public class Enemy {
    public boolean encounter = false;
    private String AttackType;
    public String Goblin(){
        int GoblinNum = (int) (Math.random()*3 +1);
        int GoblinHP = 15;
        int GroupHP = GoblinHP*GoblinNum;
        int Attack = 4;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Goblins have appeared! Their short stature and green skin stretched " +
                "over their swollen bellys do\nnot seem daunting at first, but they more than make up for it with their numbers!\n" +
                "This time there are " + GoblinNum + " of them. What do you do?\n" +
                "Strike\nRecover\nRun");
        String Action = myObj.nextLine();
        Boolean Escape = false;
        do{
            switch (Action){
                case "Run":
                    int RunChance = (int) (Math.random()*4 +1);
                    if (RunChance == 5){
                        System.out.println("You tried to escape but you failed! Now the Goblins have a free attack at your back!");
                        int SneakGobDamage =  (int) (Math.random()*4 +3);
                        Player.CurrentHealth -= SneakGobDamage;
                        System.out.print("BAM! They club you in the back of the head for " + SneakGobDamage + "damage!");
                        Action = myObj.nextLine();
                        break;
                    }
                    else{
                        Escape = true;
                        System.out.println("You managed to escape! Hopefully that's the last you will see of them.....");
                        break;
                    }

                case "Recover":
                    if (Player.Potions != 0){
                        System.out.println("You use one of your potions from your bag and sprinkle it over yourself.\n" +
                                "The crystal clear liquid revitalises you and you feel ready for battle!");
                        Player.Potions -= 1;
                        Player.CurrentHealth += 10;
                    }
                    else{
                        System.out.println("You're out of potions and there's no potion seller in sight!");
                    }
                    Action = myObj.nextLine();
                    break;

                case "Strike":
                    System.out.println("You aim at one of the Goblins with your trusty axe.");
                    int StrikeChance = (int) (Math.random()*3 +1);
                    if (StrikeChance == 3){
                        System.out.println("You missed!");
                        System.out.println("The goblin reacts ferociously with a flurry of teeth and claws!");
                        int GobDamage =  (int) (Math.random()*3 +1);
                        Player.CurrentHealth -= GobDamage;
                        Action = myObj.nextLine();
                        break;
                    }
                    else{
                        System.out.println("You strike the Goblin with a cleaving blow!");
                        int GobDamage =  (int) (Math.random()*3 +1);
                        Player.CurrentHealth -= GobDamage;
                        GroupHP -= Player.Damage;
                        var Firstkill = true;
                        var Secondkill = true;
                        if ((GroupHP <= (GoblinHP * GoblinNum) - 15  && Firstkill == true)){
                            System.out.println("Your axe carves its way through the Goblin's chest and you turn\n" +
                                    "your attention to the next, wiping its comrades remains off your axe.");
                            Firstkill = false;
                        }
                        else if (GroupHP <= (GoblinHP*GoblinNum) -30 && Secondkill == true && GoblinNum == 3){
                            System.out.println("A lucky hit and the second Goblin's head comes clean off.\n" +
                                    "Wearily you gather yourself and face the final one, its eyes burning with hate.");
                            Secondkill = false;
                        }
                        else{System.out.println("The goblin reacts ferociously with a flurry of teeth and claws!");}
                        Action = myObj.nextLine();
                        break;
                    }

                case "Status":
                    System.out.println("Name = " + Player.name);
                    System.out.println("Level =" + Player.Playerlevel);
                    System.out.println("Exp =" + Player.PlayerExp);
                    System.out.println("Health = " + Player.CurrentHealth + "/" + Player.MaxHealth);
                    System.out.println("Number of Potions = " + Player.Potions);
                    Action = myObj.nextLine();
                    break;


            }
        }while (GroupHP>= 1 && Escape == false);
        if (Escape == false){
            Player.PlayerExp += 30*GoblinNum;
            Player.Levelup();
            System.out.println("You have slain the Goblins!");}
        else{

        }
        return  "";
    }
    public String EnemyEncounter(){

        int Chanceofattack = (int) (Math.random() * 3);
        if (Chanceofattack == 1) {
            encounter = true;
            AttackType = Goblin();
            }
//        else if (Chanceofattack == 3) {
//            encounter = true;
//            AttackType = Ghoul();
//            }
//
//        else if (Chanceofattack == 8) {
//            encounter = true;
//            AttackType = Hydra();
            //}

        else{

            }

        return AttackType;


    }
}
