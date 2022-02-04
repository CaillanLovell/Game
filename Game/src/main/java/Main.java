import java.util.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Enemy enemy = new Enemy();
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is your name?");
        player.name = myObj.nextLine();
        System.out.println("You awake in the middle of an open field with nothing but your clothes, some medicine, your axe and \n" +
                    "a suspicious compass. You glance at it and see it seems to be telling you your distance to a certain area.\n" +
                    "Feeling a drive deep inside of you, you head off into the vast expanse to find your destination.\n" +
                    "Something is not right, however, almost as if the ground beneath your feet warps and transforms as you move.... \nWhich direction do you head? (Enter East, West, North or South to head off or enter 'Help' for additional commands.)");
        String Direction = myObj.nextLine();
        Area area = new Area();
        int [] CurrentPosition = Player.Position();
        int [] CastlePosition = {(int) (Math.random() * 5 +3),(int) (Math.random() * 5 +3)};
        double Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]),2) + Math.pow((CastlePosition[1] - CurrentPosition[1]),2));
        List list = new LinkedList();
        do  {
            switch (Direction) {

                case "North":
                        CurrentPosition[0] += 1;
                        enemy.EnemyEncounter();
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        list.add(Arrays.toString(CurrentPosition));
                        System.out.println(area.Description(CurrentPosition));
                        System.out.println(list);
                        Direction = myObj.nextLine();
                        break;

                        case "South":
                        CurrentPosition[0] -= 1;
                        String CurrentArea = area.Description(CurrentPosition);
                        enemy.EnemyEncounter();
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        list.add(Arrays.toString(CurrentPosition));
                        System.out.println(CurrentArea);
                        Direction = myObj.nextLine();
                        break;

                        case "East":
                        CurrentPosition[1] += 1;
                        enemy.EnemyEncounter();
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(area.Description(CurrentPosition));
                        list.add(Arrays.toString((CurrentPosition)));
                        Direction = myObj.nextLine();
                        break;

                        case "West":
                            CurrentPosition[1] -= 1;
                            enemy.EnemyEncounter();
                            Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                            list.add(Arrays.toString(CurrentPosition));
                            System.out.println(area.Description(CurrentPosition));
                            Direction = myObj.nextLine();
                            break;

                            case "Help":
                                System.out.println("Hi Hi, it's me, Helpy the Helper! The commands you'll need are as follows:\n" +
                                        "Compass --- This lets you see the distance from you to your mysteeeeerious destination!\n" +
                                        "Status --- This will let you see all sorts of useful information, like your health and potions! You can sue this at anytime!\n" +
                                        "East, West, North and South --- These commands let you move around your ever changing map. Don't get lost!\n" +
                                        "Those are all the commands for now, why don't you have a go at using some!\n" +
                                        "I'll be here if you need any help again! (っ＾▿＾っ) ");
                                Direction = myObj.nextLine();
                                break;

                        case "Compass":
                            Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                            System.out.println(Distance +"kms away");
                            Direction = myObj.nextLine();
                            break;

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
                    Direction = myObj.nextLine();
                    break;

                        case "Status":
                            System.out.println("Name = " + Player.name);
                            System.out.println("Level =" + Player.Playerlevel);
                            System.out.println("Exp =" + Player.PlayerExp);
                            System.out.println("Health = " + Player.CurrentHealth + "/" + Player.MaxHealth);
                            System.out.println("Number of Potions = " + Player.Potions);
                            Direction = myObj.nextLine();
                            break;



                default:
                    throw new IllegalStateException("Unexpected value: " + Direction);
            }


            }while (Distance != 0.0);




            System.out.println("Congratulations, you found the castle!");
        }
    }
