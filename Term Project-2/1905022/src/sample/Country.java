package sample;

public class Country
{
    String name;
    int playerCount;

    public Country()
    {
        playerCount=0;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public int getPlayerCount(){return playerCount;}

    public void show()
    {
        System.out.println("Country name: "+name+ " Number of players: "+playerCount);
    }
}
