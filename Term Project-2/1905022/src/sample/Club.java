package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable
{
    private String name;
    private List<Player> players=new ArrayList<Player>();
    private String pas;

    public void addPlayer(Player p)
    {
       players.add(p);
    }
    public String getName()
    {
        return name;
    }
    public void setName(String s)
    {
        name=s;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String toString()
    {
        return "Name "+ name+ " Pass "+pas;
    }


}
