public class Country
{
    String name;
    int playerCount;
    Player []  players=new Player[7];

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
    public void addPlayer(Player p)
    {
        players[playerCount++]=p;
    }
    public void show()
    {
        System.out.println("Country name: "+name+ " Number of players: "+playerCount);
    }
}
