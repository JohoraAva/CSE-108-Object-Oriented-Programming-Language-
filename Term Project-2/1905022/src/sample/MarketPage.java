package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketPage  implements Initializable {
    private Main main;
    ObservableList<Player> info= FXCollections.observableArrayList();

    @FXML
    private Label title;

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
    private Button backBut;
    @FXML
    private TableColumn<Player,Integer>  colAge;
    private String clubName;
    public static List<Player> sellPlayers=new ArrayList<>();


    public void load()
    {
        Tableset();
        Main.flag=true;
        title.setText("Auction List");
        info= FXCollections.observableList(getTheList());
        table.setItems(info);

        table.refresh();


    }
    public List<Player> getTheList()
    {
        List<Player> ep=new ArrayList<Player>();
        for(Player e: sellPlayers)
        {
            if(e.getExClubName().equals(clubName))
                continue;

            ep.add(e);
        }
        return ep;
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

    public void setMain(Main main)
    {
        this.main=main;
    }
    public void setClubName(String name)
    {
        clubName=name;
    }

    public void Goback(ActionEvent actionEvent)
    {
        try {
            main.showHomePage(clubName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println(table.getSelectionModel().getSelectedItem().getName()+" buying ");
                try {
                    main.BuyPlayerInfoPage(table.getSelectionModel().getSelectedItem(),clubName);
                   // main.setClub(clubName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

