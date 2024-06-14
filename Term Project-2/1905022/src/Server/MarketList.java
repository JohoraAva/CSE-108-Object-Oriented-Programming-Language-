package Server;

import sample.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MarketList implements Serializable
{
    private List<Player> players= new ArrayList<>();

    public void setList( List<Player> players)
    {
        this.players=players;
    }
    public List<Player> getList()
    {
        return players;
    }
}
