import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("You awake in the middle of an open field with nothing but your clothes, your axe and \n" +
                    "a suspicious compass. You glance at it and see it seems to be telling you your distance to a certain area.\n " +
                    "Feeling a drive deep inside of you, you head off into the vast expanse to find your destination.\n" +
                    " Which direction do you head? (Enter East, West, North or South)");
        String Direction = myObj.nextLine();
        Area area = new Area();
        int [] CurrentPosition = Player.Position();
        int [] CastlePosition = {(int) (Math.random() * 8),(int) (Math.random() * 8)};
        double Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]),2) + Math.pow((CastlePosition[1] - CurrentPosition[1]),2));
        do  {
            switch (Direction) {
                    case "North":
                        CurrentPosition[0] += 1;
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(area.Description());
                        Direction = myObj.nextLine();
                        break;

                    case "South":
                        CurrentPosition[0] -= 1;
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(area.Description());
                        Direction = myObj.nextLine();
                        break;

                    case "East":
                        CurrentPosition[1] += 1;
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(area.Description());
                        Direction = myObj.nextLine();
                        break;

                    case "West":
                        CurrentPosition[1] -= 1;
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(area.Description());
                        Direction = myObj.nextLine();
                        break;


                    case "Compass":
                        Distance = Math.sqrt(Math.pow((CastlePosition[0] - CurrentPosition[0]), 2) + Math.pow((CastlePosition[1] - CurrentPosition[1]), 2));
                        System.out.println(Distance);
                        Direction = myObj.nextLine();
                        break;

                }


            }while (Distance != 0.0);

            System.out.println("Congratulations, you found the castle!");
        }
    }
