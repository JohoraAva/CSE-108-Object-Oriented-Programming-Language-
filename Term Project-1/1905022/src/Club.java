public class Club
{
    private String name;
    private int playerCount=0;
    Player [] players=new Player[7];

    public void addPlayer(Player p)
    {
        players[playerCount++]=p;
    }
    public String getName()
    {
        return name;
    }
    public int getPlayerCount()
    {
        return playerCount;
    }
    public void setName(String s)
    {
        name=s;
    }
    public void show()
    {
        System.out.println("Show players info:");
        for(int i=0;i<playerCount;i++)
            System.out.println(players[i]);
    }
    public void MaxSalary()
    {
        int index=-1;
        double maxsalary=players[0].getSalary();
        for(int i=0;i<playerCount;i++)
        {
            if(maxsalary<players[i].getSalary())
            {
                index=i;
                maxsalary=players[i].getSalary();
            }
        }
        for(int i=0;i<playerCount;i++)
        {
            if(maxsalary==players[i].getSalary())
                System.out.println(players[i]);
        }
    }

    public void MaxAge()
    {
        int index=-1;
        double maxage=players[0].getAge();
        for(int i=0;i<playerCount;i++)
        {
            if(maxage<players[i].getAge())
            {
                index=i;
                maxage=players[i].getAge();
            }
        }
        for(int i=0;i<playerCount;i++)
        {
            if(maxage==players[i].getAge())
                System.out.println(players[i]);
        }
    }
    public void MaxHeight()
    {
        int index=-1;
        double maxheight=players[0].getHeight();
        for(int i=0;i<playerCount;i++)
        {
            if(maxheight<players[i].getHeight())
            {
                index=i;
                maxheight=players[i].getHeight();
            }
        }
        for(int i=0;i<playerCount;i++)
        {
            if(maxheight==players[i].getHeight())
                System.out.println(players[i]);
        }
    }
    public void yearlysalary()
    {
        double salary=0.00;
        for(int i=0;i<playerCount;i++)
        {
            salary+=52*players[i].getSalary();
        }
        System.out.printf("Total yearly salary of the club: %f\n",salary);
    }
    public boolean NumberExists(int n)
    {
        for(int i=0;i<playerCount;i++)
        {
            if(players[i].getNumber()==n)
            {
                playerCount--;
                return true;
            }
        }
        return false;
    }
}
