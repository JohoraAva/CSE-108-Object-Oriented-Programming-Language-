package sample;

import Server.MakeTheList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CnWisePlPage {
    private Main main;
    private String clubname;
    private HomePage hp = new HomePage();
    List<Player> players = new ArrayList();
    List<Country> cn = new ArrayList();
    // players=hp.searchPlayerByClub(clubname);

    @FXML
    private Label title;

    @FXML
    private TableView<Country> table;

    @FXML
    private TableColumn<Country, String> colName;

    @FXML
    private TableColumn<Country, Integer> colNum;

    @FXML
    private Button backBut;
    private ObservableList<Country> info=FXCollections.observableArrayList();

    @FXML
    void Goback(ActionEvent event) {

        Stage stage = (Stage) backBut.getScene().getWindow();

        stage.close();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setClubName(String setTitle) {
        clubname = setTitle;
    }


    public void load() {

        players= HomePage.players;
        setTable();
        info=FXCollections.observableArrayList(getCnList());
        table.setItems(info);


    }

    private List<Country> getCnList() {
        for (int i = 0; i < players.size(); i++) {
            if (!CountryExists(players.get(i).getCountry())) {
                Country c = new Country();
                c.setName(players.get(i).getCountry());
                cn.add(c);
            }
        }
        for (int i = 0; i < players.size(); i++)
        {
            for(int j=0;j< cn.size();j++)
            {
                if(players.get(i).getCountry().equalsIgnoreCase(cn.get(j).getName()))
                {
                    cn.get(j).playerCount++;
                    break;
                }
            }
        }
        for (int i = 0; i <cn.size(); i++)
            System.out.println(cn.get(i).playerCount);
        return cn;
    }

        public boolean CountryExists (String s)
        {
            for (int i = 0; i < cn.size(); i++) {
                if (cn.get(i).getName().equalsIgnoreCase(s))
                    return true;
            }
            return false;
        }

        public void setTable ()
        {
            colName.setCellValueFactory(new PropertyValueFactory<Country, String>("name"));
            colNum.setCellValueFactory(new PropertyValueFactory<Country, Integer>("playerCount"));

            table.setItems(info);

        }
    }

