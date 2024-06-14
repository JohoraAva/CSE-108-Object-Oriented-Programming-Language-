public class ClubSearch extends Main
{
    public static void MaxSalaryofaClub(String name)
    {
        if(!ClubExists(name))
            System.out.println("No such club with this name");
        else
        {
            for(int i=0;i< clubList.size();i++)
            {
                if(clubList.get(i).getName().equalsIgnoreCase(name))
                {
                    clubList.get(i).MaxSalary();
                    break;
                }
            }
        }
    }
    public static void MaxAgeofaClub(String name)
    {
        int index=-1;
        for(int i=0;i< clubList.size();i++)
        {
            if(clubList.get(i).getName().equalsIgnoreCase(name))
            {
                clubList.get(i).MaxAge();
                index=i;
                break;
            }
        }
        if(index==-1)
            System.out.println("No such club with this name");
    }
    public static void MaxHeightofaClub(String name)
    {
        int index=-1;
        for(int i=0;i< clubList.size();i++)
        {
            if(clubList.get(i).getName().equalsIgnoreCase(name))
            {
                clubList.get(i).MaxHeight();
                index=i;
                break;
            }
        }
        if(index==-1)
            System.out.println("No such club with this name");
    }

    public static void YearlySalofaClub(String name)
    {
        int index=-1;
        for(int i=0;i< clubList.size();i++)
        {
            if(clubList.get(i).getName().equalsIgnoreCase(name))
            {
                clubList.get(i).yearlysalary();
                index=i;
                break;
            }
        }
        if(index==-1)
            System.out.println("No such club with this name");
    }
}
