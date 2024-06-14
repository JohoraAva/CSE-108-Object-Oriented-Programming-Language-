import java.util.Scanner;

public class Input extends Main
{
    public static void TakeInput() throws Exception {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the player:");
        String name= input.nextLine().trim();
        //System.out.println(name);
        int index=-1;
        for(int i=0;i<playerList.size();i++)
        {
            if(playerList.get(i).getName().equalsIgnoreCase(name))
            {
                index=i;
                System.out.println("The player already exists");
                break;
            }
        }
        if(index!=-1)
        {
            Menue.Continue();
        }
        else
        {
            Player p=new Player();
            p.setName(name);

            System.out.println("Enter the Club name of the player:");
            String clubname=input.nextLine().trim();
            //p.setClubName(clubname);///clublist
            Club c=new Club();
            c.setName(clubname);
            if(ClubExists(clubname))
            {
                for(int i=0;i< clubList.size();i++)
                {
                    if(clubList.get(i).getName().equalsIgnoreCase(c.getName()))
                    {
                        if(clubList.get(i).getPlayerCount()==7)
                        {
                            System.out.println("This club is full.You cannot add players to this club.");
                            Showmenu2(3);
                        }
                        else
                        {
                            clubList.get(i).addPlayer(p);
                            p.setClubName(clubList.get(i).getName());
                        }
                    }
                }
            }
            else
            {
                c.addPlayer(p);
                clubList.add(c);
                p.setClubName(clubname);
            }
            PrintPosition();
            int pos=input.nextInt();
            while(pos<1 || pos>4)
            {
                System.out.println("You entered the wrong position.Please try again.");
                PrintPosition();
                pos=input.nextInt();
            }
            p.setPosition(ValidPosition(pos));

            System.out.println("Enter the number of the player:");
            int number=input.nextInt();
            index=-1;
            for(int i=0;i< clubList.size();i++)
            {
                if(clubList.get(i).getName().equals(p.getClubName()))
                {
                    if(clubList.get(i).NumberExists(number))
                    {
                        index=i;
                        System.out.println("The Number already exists in this club");
                        break;

                    }
                }
            }
            if(index!=-1)
            {
                Menue.Continue();
            }
            else
                p.setNumber(number);

            System.out.println("Enter the Country name of the player:");
            Scanner sc=new Scanner(System.in);
            String countryname=sc.nextLine().trim();
            p.setCountryName(countryname); ///add to country list
            Country cn=new Country();
            cn.setName(countryname);
            if(!CountryExists(countryname))
            {
                countryList.add(cn);
                cn.playerCount++;
            }
            else {
                for (int i = 0; i < countryList.size(); i++) {
                    if (countryList.get(i).getName().equalsIgnoreCase(cn.getName()))
                        countryList.get(i).playerCount++;
                }
            }

            System.out.println("Enter the Age of the player:");
            int age=input.nextInt();
            p.setAge(age);


            System.out.println("Enter the Height of the player:");
            double height=input.nextDouble();
            p.setHeight(height);
            System.out.println("Enter the Weekly Salary of the player:");
            double sal=input.nextDouble();
            p.setSalary(sal);
            playerList.add(p);
        }

        Menue.Continue();
    }
}

