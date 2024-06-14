import java.util.ArrayList;
import java.util.List;

public class Main  extends Menue{

    public static List<Club> clubList=new ArrayList();
    public static List<Player> playerList = new ArrayList();
    public static List<Country> countryList=new ArrayList();

    public static void main(String[] args) throws Exception {
        AllFile.readFromFile();

        AllFile.writeToFile();
        AllFile.ShowCountrywisePlayer();
        // write your code here
        Showmenu();

        }
   public static boolean ClubExists(String s)
    {
        for(int i=0;i< clubList.size();i++)
        {
            if(clubList.get(i).getName().equalsIgnoreCase(s))
                return true;
        }
        return false;
    }
    public static boolean CountryExists(String s)
    {
        for(int i=0;i< countryList.size();i++)
        {
            if(countryList.get(i).getName().equalsIgnoreCase(s))
                return true;
        }
        return false;
    }
    public static String ValidPosition(int p)
    {
        String[] pos={"Forward","Midfielder","Defender","Goalkeeper"};
        return pos[p-1];
    }
    public static void PrintPosition()
    {
        String[] pos={"Forward","Midfielder","Defender","Goalkeeper"};
        System.out.println("Positions of Player:");
        for(int i=0;i<pos.length;i++)
            System.out.println((i+1)+"."+pos[i]);
        System.out.println("Enter the Position of the player:");
    }

}
