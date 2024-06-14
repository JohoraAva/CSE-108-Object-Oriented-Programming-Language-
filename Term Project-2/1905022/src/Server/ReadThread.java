package Server;

import javafx.application.Platform;
import sample.*;

import java.io.IOException;
import java.util.List;

import static sample.Main.ClubExists;

public class ReadThread implements Runnable {
    private  Thread thr;
    private Main main;
    private LoginDTO loginDTO;



    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                System.out.println("reading from client");
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        loginDTO=(LoginDTO) o;
                        LoginDTO loginDTO = (LoginDTO) o;
                        System.out.println(loginDTO.getUserName());
                        System.out.println(loginDTO.isStatus());

                        // the following is necessary to update JavaFX UI components from user created threads
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Controller cn=new Controller();
                                if(ClubExists(loginDTO.getUserName()) && !loginDTO.isStatus())
                                    cn.showAlert();
                                else if (loginDTO.isStatus()) {
                                    try {
                                        System.out.println("login successfully");
                                        //
                                        main.showHomePage(loginDTO.getUserName());

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                } else {
                                    cn.ShowAlert();
                                }

                            }
                        });
                    }

                    if(o instanceof MakeTheList)
                    {
                        HomePage h=new HomePage();
                        MakeTheList m=(MakeTheList) o;
                        for(int i=0;i<m.getList().size();i++)
                        {
                            if(!(m.getList().get(i).isSold()))
                                HomePage.players.add(m.getList().get(i));
                        }

                        System.out.println(((MakeTheList) o).getList().size());
                        System.out.println("list got "+ HomePage.players.size()+" "+ h.getList());
                    }
                    if(o instanceof  Player)
                    {
                       Player p=(Player) o;
                        ///change the flag
                        if(p.isSold())
                            MarketPage.sellPlayers.add(p);
                        else
                        {
                            for(int i=0;i<MarketPage.sellPlayers.size();i++)
                            {
                                if(MarketPage.sellPlayers.get(i).getName().equals(p.getName()))
                                {
                                    MarketPage.sellPlayers.remove(i);
                                }
                            }
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if(Main.flag)
                                        main.BuyPage(loginDTO.getUserName());
                                } catch (IOException e) {
                                    System.out.println("loading market page");
                                    e.printStackTrace();
                                }
                            }
                        });
                        System.out.println("New Player at  market page");
                    }
                    if(o instanceof  MarketList)
                    {
                        MarketPage.sellPlayers.addAll(((MarketList) o).getList());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e);

        }

    }
}



