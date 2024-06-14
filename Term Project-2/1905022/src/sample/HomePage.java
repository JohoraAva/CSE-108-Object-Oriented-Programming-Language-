package sample;

import Server.ClubInfo;
import Server.MakeTheList;
import Server.ReadThread;
import Server.ReadThreadServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.*;


public class HomePage  implements Initializable {
    private Main main;
    private String setTitle;
    ObservableList<Player> info= FXCollections.observableArrayList();
    ObservableList<String> pos= FXCollections.observableArrayList("Goalkeeper","Defender","Midfielder","Forward");
    ObservableList<String> op= FXCollections.observableArrayList("Player With Max Age","Player With Max Height","Player With Max Salary");
    public static List<Player> players=new ArrayList<Player>();


    @FXML
    private Label title;

    @FXML
    private VBox vbox;

    @FXML
    private TextField searcOp;

    @FXML
    private Button SearchBut;
    ///
    @FXML
    private TextField CnName;

    @FXML
    private TableView<Player> table;

    @FXML
    private TableColumn<Player,String> colName;

    @FXML
    private TableColumn<Player,String> colCoun;

    @FXML
    private TableColumn<Player,Double> colSal;
    @FXML
    private TableColumn<Player,String> colPos;


    @FXML
    private TableColumn<Player,Double> colHeight;

    @FXML
    private TableColumn<Player,Integer> colNum;

    @FXML
    private TableColumn<Player,Integer> colAge;

    @FXML
    private Button refreshBut;

    @FXML
    private Button enterBut1;
    @FXML
    private Button enterBut2;
    @FXML
    private Button ConPL;
    @FXML
    private Button logOutBut;
    @FXML
    private Label YearlySal;
    @FXML
    private ComboBox ChooseOp;

    @FXML
    private TextField Lowrange;

    @FXML
    private TextField UpRange;
    @FXML
    private Label LabSal;
    @FXML
    private  ComboBox ClubOpChoose;

    public void setMain(Main main)
    {
        this.main=main;
    }

    public String getSetTitle() {
        return setTitle;
    }

    public void setSetTitle(String setTitle) {
        this.setTitle = setTitle;
    }
    public void Tableset()
    {
        colName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        colCoun.setCellValueFactory(new PropertyValueFactory<Player,String>("country"));
        colSal.setCellValueFactory(new PropertyValueFactory<Player,Double>("salary"));
        colPos.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        colHeight.setCellValueFactory(new PropertyValueFactory<Player,Double>("height"));
        colAge.setCellValueFactory(new PropertyValueFactory<Player,Integer>("age"));
        colNum.setCellValueFactory(new PropertyValueFactory<Player,Integer>("number"));

    }
    public void load()
    {
        title.setText(setTitle);
        Main.flag=false;

        LabSal.setText("Total yearly salary of the club: "+ String.format("%f",Sal()));

        players=getList();

        Tableset();
        info= FXCollections.observableList(players);
        table.setItems(info);

        ChooseOp.setItems(pos);
        ClubOpChoose.setItems(op);
        searcOp.setText(null);
        CnName.setText(null);
        Lowrange.setText(null);
        UpRange.setText(null);


    }
    public void setList(List<Player> p)
    {
        players=p;
    }
    public List<Player> getList()
    {
        return players;
    }

    @FXML
    public void SearchMine(ActionEvent actionEvent)
    {
        List<Player> Wplayer=new ArrayList();
        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).getName().trim().equalsIgnoreCase(searcOp.getText()))
            {
               Wplayer.add(players.get(i));
            }
        }
        Tableset();
        info= FXCollections.observableList(Wplayer);
        table.setItems(info);

        CnName.setText(null);
        Lowrange.setText(null);
        UpRange.setText(null);

    }



    @FXML
    public void Refresh(ActionEvent actionEvent)
    {
        load();
    }

    @FXML
    public void SearchResult(ActionEvent actionEvent)
    {
        String s=CnName.getText().trim();
        Tableset();
        info= FXCollections.observableList(searchPlayerByCntry(s));
        table.setItems(info);

        searcOp.setText(null);
        Lowrange.setText(null);
        UpRange.setText(null);
    }

    public List<Player> searchPlayerByCntry(String s)
    {
        List<Player> playerByCon = new ArrayList();

        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).getCountry().equalsIgnoreCase(s))
            {
                playerByCon.add(players.get(i));
            }
        }
        return playerByCon;
    }


    public void PosChoose(ActionEvent actionEvent)
    {
        String position= ChooseOp.getSelectionModel().getSelectedItem().toString();

        Tableset();
        info= FXCollections.observableList(searchPlayerByPos(position));
        table.setItems(info);

        searcOp.setText(null);
        CnName.setText(null);
        Lowrange.setText(null);
        UpRange.setText(null);
    }

    public List<Player> searchPlayerByPos(String position)
    {
        List<Player> playerbyPos = new ArrayList();

        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).getPosition().equals(position))
            {
                playerbyPos.add(players.get(i));
            }
        }
        return playerbyPos;
    }

    public void SalSearch(ActionEvent actionEvent)
    {

        Double start=Double.parseDouble(Lowrange.getText());
        Double end=Double.parseDouble(UpRange.getText());

        Tableset();
        info= FXCollections.observableList(SearchPlayerBySalaryRange(start,end));
        table.setItems(info);

        searcOp.setText(null);
        CnName.setText(null);


    }
    public List<Player> SearchPlayerBySalaryRange(Double rSart, Double rEnd)
    {
        List<Player> playerbySal = new ArrayList();

        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).getSalary()>=rSart && players.get(i).getSalary()<=rEnd)
            {
                playerbySal.add(players.get(i));
            }
        }
        return playerbySal;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        load();

        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println(table.getSelectionModel().getSelectedItem().getName());
                try {
                    main.ShowInfoPage(table.getSelectionModel().getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }


    public double Sal()
    {
        double salary=0.00;
        for(int i=0;i<players.size();i++)
        {
            salary+=52*players.get(i).getSalary();
        }
        return salary;
    }
    public void logOut(ActionEvent actionEvent)
    {
        players.clear();
        try {
            main.mainpage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCnWisePlayer(ActionEvent actionEvent)
    {

        try {
            main.ShowCnWisePlayerPage(setTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buYing(ActionEvent actionEvent)
    {
        try {
            main.BuyPage(setTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClubChoose(ActionEvent actionEvent)
    {
        String option= ClubOpChoose.getSelectionModel().getSelectedItem().toString();
        System.out.println(option);

        Tableset();
        info= FXCollections.observableList(searchPlayer(option));
        System.out.println("List:"+ searchPlayer(option));
        table.setItems(info);

        searcOp.setText(null);
        CnName.setText(null);
        Lowrange.setText(null);
        UpRange.setText(null);
    }

    private List<Player> searchPlayer(String option)
    {
        List<Player> player = new ArrayList();
       // ("Player With Max Age","Player With Max Height","Player With Max Salary");

        if(option.equalsIgnoreCase("Player with Max age"))
        {
            player=MaxAgePlayer();
        }
        else if(option.equalsIgnoreCase("Player with Max Height"))
        {
            player=MaxHeightPlayer();
        }
        else if(option.equalsIgnoreCase("Player with Max Salary"))
        {
            player=MaxSalPlayer();
        }
        return player;
    }

    private List<Player> MaxSalPlayer()
    {
        List<Player> playerMaxSal = new ArrayList();

        double maxSal=players.get(0).getSalary();
        for(int i=0;i<players.size();i++)
        {
            if(maxSal<players.get(i).getSalary())
            {
                maxSal=players.get(i).getSalary();
            }
        }
        for(int i=0;i<players.size();i++)
        {
            if(maxSal==players.get(i).getSalary())
                playerMaxSal.add(players.get(i));
            //System.out.println(players[i]);
        }
        return playerMaxSal;
    }

    private List<Player> MaxHeightPlayer()
    {
        List<Player> playerMaxHeight = new ArrayList();

        double maxHeight=players.get(0).getHeight();
        for(int i=0;i<players.size();i++)
        {
            if(maxHeight<players.get(i).getHeight())
            {
                maxHeight=players.get(i).getHeight();
            }
        }
        for(int i=0;i<players.size();i++)
        {
            if(maxHeight==players.get(i).getHeight())
                playerMaxHeight.add(players.get(i));
            //System.out.println(players[i]);
        }
        return playerMaxHeight;

    }

    private List<Player> MaxAgePlayer()
    {
        List<Player> playerMaxAge = new ArrayList();

        int maxage=players.get(0).getAge();
        for(int i=0;i<players.size();i++)
        {
            if(maxage<players.get(i).getAge())
            {
                maxage=players.get(i).getAge();
            }
        }
        for(int i=0;i<players.size();i++)
        {
            if(maxage==players.get(i).getAge())
                playerMaxAge.add(players.get(i));
                //System.out.println(players[i]);
        }
        return playerMaxAge;
    }
}
