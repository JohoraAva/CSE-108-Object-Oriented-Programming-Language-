package Server;

import sample.AllFile;
import sample.Club;
import sample.Main;
import sample.Player;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static sample.Main.playerList;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private  NetworkUtil networkUtil;
    private LoginDTO lg;
    public static HashMap<String, ClubInfo> clubs;
    static List<Player> sellList=new ArrayList<>();



    public ReadThreadServer(HashMap<String, ClubInfo> clubs, NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.clubs=clubs;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        System.out.println("wanna see the list before:" +sellList);
                        LoginDTO loginDTO = (LoginDTO) o;
                        lg=loginDTO;
                        ClubInfo clubInfo = new ClubInfo();
                        clubInfo.setPassword(loginDTO.getUserName());
                        clubInfo.setOnline(true);
                        clubInfo.setNetworkUtil(networkUtil);
                        clubs.put(loginDTO.getUserName(), clubInfo);
                        if(Main.ClubExists(loginDTO.getUserName()))
                        {
                            loginDTO.setClub(checkTheClub(loginDTO.getUserName(), loginDTO.getPassword()));
                            if(loginDTO.getClub()!=null)
                                loginDTO.setStatus(true);
                        }
                        networkUtil.write(loginDTO);
                        if(loginDTO.isStatus())
                        {
                            //clients.put(loginDTO,networkUtil);
                            System.out.println("reading from server");
                            MakeTheList m=new MakeTheList();
                            List<Player> players =new ArrayList<>();
                            players=loginDTO.getClub().getPlayers();
                            MarketList mk=new MarketList();
                            mk.setList(sellList);
                            m.setList(players);
                            networkUtil.write(m);
                            clubInfo.getNetworkUtil().write(mk);
                            //networkUtil.write(mk);
                            System.out.println("list got from server"+ m.getList().size());
                        }
                    }
                    if(o instanceof  Player)
                    {
                        Player p= (Player) o;
                        if(p.isSold())
                        {
                            List<Player> ps=lg.getClub().getPlayers();
                            for(int i=0;i<ps.size();i++)
                            {
                                if(ps.get(i).getName().equals(p.getName()))
                                {
                                   ps.remove(i);
                                }
                            }
                            sellList.add((Player)o);
                            p.setClubName(" ");
                            System.out.println("size of sellList:" + sellList.size());
                        }
                        else
                        {
                            lg.getClub().addPlayer(p);
                            for(int i=0;i<sellList.size();i++)
                            {
                                if(sellList.get(i).getName().equals(p.getName()))
                                {
                                    sellList.remove(i);
                                }
                            }
                            System.out.println(p.getClubName()+" ex: "+p.getExClubName());
                        }
                        Iterator<String> iterator = clubs.keySet().iterator();
                        while (iterator.hasNext()) {
                            String name = iterator.next();
                            ClubInfo clientInfo = clubs.get(name);
                            if(!(clientInfo.getPassword().equals(lg.getUserName())))
                                clientInfo.getNetworkUtil().write(p);
                        }
                        System.out.println("list got from server for sell List");
                    }
                }
                System.out.println("wanna see the list after:" +sellList);
            }
        }catch (Exception e) {
            System.out.println("From server: "+ e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public Club checkTheClub(String name,String pass) {
        for (int i = 0; i < AllFile.clubList.size(); i++) {
            if (AllFile.clubList.get(i).getName().equals(name)) {
                if (AllFile.clubList.get(i).getPas().equals(pass)) {
                    System.out.println("success");
                    return AllFile.clubList.get(i);

                }
            }
        }
        return null;
    }
}



