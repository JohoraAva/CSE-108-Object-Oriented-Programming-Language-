import java.util.Scanner;

public class Menue
{
    public static void Showmenu() throws Exception
    {
        System.out.println("Main Menu:");
        System.out.println("(1)Search Players");
        System.out.println("(2)Search Clubs");
        System.out.println("(3)Add Player");
        System.out.println("(4)Exit System");
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Showmenu2(n);
    }
    public static void Showmenu2(int n) throws Exception {
        if (n<1 || n>4)
        {
            System.out.println("Wrong option");
            Showmenu();
        }
        Scanner input = new Scanner(System.in);
        if (n == 1) {
            System.out.println("Player Searching options:");
            System.out.println("(1)By Player Name");
            System.out.println("(2) By Club and Country");
            System.out.println("(3) By Position");
            System.out.println("(4) By Salary Range");
            System.out.println("(5) Country-wise player count");
            System.out.println("(6) Back to Main Menu");

            int n2 = input.nextInt();
            SearchPlayer(n2);
        }
        if(n==2)
        {
            System.out.println("Club Searching options:");
            System.out.println("(1)Player(s) with the maximum salary of a club");
            System.out.println("(2)Player(s) with the maximum age of a club");
            System.out.println("(3)Player(s) with the maximum height of a club");
            System.out.println("(4)Total yearly salary of a club");
            System.out.println("(5) Back to Main Menu");

            int n2 = input.nextInt();
            searchClub(n2);
        }
        if(n==3)
        {
            Input.TakeInput();
        }
        if(n==4)
        {
            AllFile.writeToFile();
            System.exit(0);
        }
    }


    public static void SearchPlayer(int n) throws Exception {
        Scanner input=new Scanner(System.in);
        String s;
        if(n<1 || n>6)
        {
            System.out.println("Wrong option");
            Showmenu2(1);
        }
        if (n==1)
        {
            System.out.println("Enter Player Name:");
            s=input.nextLine();
            PlayerSearch.SearchPlayerByName(s.trim());
        }
        if(n==2)
        {
            System.out.println("Enter Country Name:");
            String countryname=input.nextLine();
            System.out.println("Enter Club Name:");
            String clubname=input.nextLine();
            PlayerSearch.SearchPlayerByCountryAndClubName(countryname.trim(),clubname.trim());
        }
        if(n==3)
        {
            Main.PrintPosition();
            //System.out.println("");
            int pos=input.nextInt(); ///position must be just four types
            PlayerSearch.SearchPlayerByposition(Main.ValidPosition(pos));
        }
        if(n==4)
        {
            System.out.println("Enter Lower Limit of weekly Salary:");
            Scanner range=new Scanner(System.in);
            double rStart= range.nextDouble();
            System.out.println("Enter Upper Limit of weekly Salary:");
            double rEnd=range.nextDouble();
            while(rEnd<rStart)
            {
                System.out.println("Your upper limit is lower than lower limit.Please correct your range");
                System.out.println("Enter Lower Limit of weekly Salary:");
                rStart= range.nextDouble();
                System.out.println("Enter Upper Limit of weekly Salary:");
                rEnd=range.nextDouble();
            }
            PlayerSearch.SearchPlayerBySalaryRange(rStart,rEnd);
        }
        if(n==5)
        {
            System.out.println("Country-wise Player number:");
            PlayerSearch.ShowCountrywisePlayer();
        }
        if(n==6)
        {
            Showmenu();
        }
        Showmenu2(1);
    }


    public static void searchClub(int n) throws Exception {
        if(n<1 || n>5)
        {
            System.out.println("Wrong option");
            Showmenu2(2);
        }
        Scanner sc=new Scanner(System.in);
        if(n==1)
        {
            System.out.println("Enter the Club Name:");
            String name=sc.nextLine();
            ClubSearch.MaxSalaryofaClub(name.trim());
        }
        if(n==2)
        {
            System.out.println("Enter the Club Name:");
            String name=sc.nextLine();
            ClubSearch.MaxAgeofaClub(name.trim());
        }
        if(n==3)
        {
            System.out.println("Enter the Club Name:");
            String name=sc.nextLine();
            ClubSearch.MaxHeightofaClub(name.trim());
        }
        if(n==4)
        {
            System.out.println("Enter the Club Name:");
            String name=sc.nextLine();
            ClubSearch.YearlySalofaClub(name.trim());
        }
        if(n==5)
        {
            Showmenu();
        }
        Showmenu2(2);
    }
    public static void Continue() throws Exception {
        System.out.println("Do you want to continue search?");
        System.out.println("(1)Yes");
        System.out.println("(2)No");
        Scanner n=new Scanner(System.in);
        int op=n.nextInt();
        if(op==1)
            Showmenu2(3);
        else
            Showmenu();
    }
}
