package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static sample.Player.exchangePlayerList;

public class BuyPlayerInfoPage {
    private Main main;
    private String name;

    @FXML
    private Label title;

    @FXML
    private ImageView image;

    @FXML
    private Label labelName;


    @FXML
    private Label labelCn;

    @FXML
    private Label labelPos;

    @FXML
    private Label labelNum;

    @FXML
    private Label labelSal;

    @FXML
    private Label labelAge;

    @FXML
    private Label labelH;

    @FXML
    private Button backBut;

    @FXML
    private Button buyBut;
    private Player player;

    @FXML
    void Goback(ActionEvent event)
    {
        try {
            main.BuyPage(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void buy(ActionEvent actionEvent)
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Buy Player");
        alert.setHeaderText("Player Buy");
        alert.setContentText("Do you want to buy this player??");
        Optional<ButtonType> confirm=alert.showAndWait();
        if(confirm.get()==ButtonType.OK)
        {
            System.out.println("ok buying");
            AddPlayer();

            try {
                Main.flag=true;
                main.BuyPage(name);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void AddPlayer()
    {
        player.setSold(false);
        player.setClubName(name);
        MarketPage.sellPlayers.remove(player);
        HomePage.players.add(player);
        try {
            main.getNetworkUtil().write(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main)
    {
        this.main =main;
    }
    public void setName(String s)
    {
        name=s;
    }
    public void setPlayer(Player p)
    {
        player=p;
    }

    public void load()
    {
        AllInfo();
    }

    private void AllInfo()
    {
        labelName.setText(player.getName());
        labelAge.setText(String.valueOf(player.getAge())+" years");

        labelCn.setText(player.getCountry());
        labelH.setText(String.valueOf(player.getHeight())+" m");
        labelPos.setText(player.getPosition());
        labelSal.setText(String.valueOf(player.getSalary()));
        labelNum.setText(String.valueOf(player.getNumber()));
        image.setImage(new Image(Main.class.getResourceAsStream("player.png")));//;
    }
}
