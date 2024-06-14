public class PlayerSearch extends Main
{
    public static void SearchPlayerByName(String name)
    {
        int index=-1;
        for(int i=0;i<playerList.size();i++)
        {
            if(playerList.get(i).getName().equalsIgnoreCase(name))
            {
                index=i;
                break; ///just for one name for one
            }
        }
        if(index==-1)
        {
            System.out.println("No such player with this name");
        }
        else
        {
            System.out.println(playerList.get(index));
        }
    }


    public static void SearchPlayerByCountryAndClubName(String countryname,String clubname)
    {
        int index=-1;
        for(int i=0;i< playerList.size();i++)
        {
            if(playerList.get(i).getCountryName().equalsIgnoreCase(countryname))
            {
                if(clubname.equalsIgnoreCase("ANY"))
                {
                    index=i;
                    System.out.println(playerList.get(i));
                }
                else
                {
                    if(playerList.get(i).getClubName().equalsIgnoreCase(clubname))
                    {
                        index=i;
                        System.out.println(playerList.get(i));
                    }
                }
            }
        }
        if(index==-1)
        {
            System.out.println("No such player with this country and club");
        }
    }

    public static void SearchPlayerByposition(String pos)
    {
        int index=-1;
        for(int i=0;i<playerList.size();i++)
        {
            if(playerList.get(i).getPosition().equalsIgnoreCase(pos))
            {
                index=i;
                System.out.println(playerList.get(index));
            }
        }
        if(index==-1)
        {
            System.out.println("No such player with this Position");
        }
    }

    public static void SearchPlayerBySalaryRange(double rStart,double rEnd)
    {
        int index=-1;
        for(int i=0;i<playerList.size();i++)
        {
            if(playerList.get(i).getSalary()>=rStart && playerList.get(i).getSalary()<=rEnd)
            {
                index=i;
                System.out.println(playerList.get(index));
            }
        }
        if(index==-1)
        {
            System.out.println("No such player with this weekly salary range");
        }
    }

    public static void ShowCountrywisePlayer()
    {
        for(int i=0;i< countryList.size();i++)
            countryList.get(i).show();
    }
}
