package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.Optional;

public class InfoPage {
    private Main main;
    private Player player;

    @FXML
    private Label club;

    @FXML
    private Label labelName;

    @FXML
    private ImageView image;

    @FXML
    private Label labelClub;

    @FXML
    private Label labelCn;

    @FXML
    private Label labelPos;

    @FXML
    private Label labelNum;

    @FXML
    private Label labelSal;
    @FXML
    private Button sellBut;

    @FXML
    private Label labelAge;

    @FXML
    private Label labelH;

    @FXML
    private Button backBut;

    public void setMain(Main main) {
        this.main=main;
    }

    public void setPlayer(Player player) {
        this.player=player;
    }
    public void load()
    {
        AllInfo();
    }
    public void AllInfo()
    {
        club.setText(player.getClubName());
        labelName.setText(player.getName());
        labelAge.setText(String.valueOf(player.getAge())+" years");
        labelClub.setText(player.getClubName());
        labelCn.setText(player.getCountry());
        labelH.setText(String.valueOf(player.getHeight())+"m");
        labelPos.setText(player.getPosition());
        labelSal.setText(String.valueOf(player.getSalary()));
        labelNum.setText(String.valueOf(player.getNumber()));
        image.setImage(new Image(Main.class.getResourceAsStream("player.png")));

    }

    @FXML
    void Goback(ActionEvent event)
    {
        GotoPrevPage();
    }


    public void selling(ActionEvent actionEvent)
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sell Player");
        //alert.setHeaderText("Incorrect Password");
        alert.setContentText("Do you want to sell this player??");
        Optional<ButtonType> confirm=alert.showAndWait();
        if(confirm.get()==ButtonType.OK)
        {
            System.out.println("ok");
            RemovePlayer();
            GotoPrevPage();

        }
    }

    private void GotoPrevPage()
    {
        try {
            main.showHomePage(club.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void RemovePlayer()
    {
        player.setSold(true);
        player.setExClubName(player.getClubName());
        //player.setClubName("");
        HomePage.players.remove(player);
        try {
            main.getNetworkUtil().write(player);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("player removing error");
        }

        System.out.println("player removing");
    }
}
