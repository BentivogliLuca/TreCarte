/*
 * Controller of Main GUI Frame.
 */
package control;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Bentivogli Luca
 */
public class MainController implements Initializable {

    int c = 0;
    int won = 0;
    int lost = 0;
    double percent = 0;
    
    int x = 0;
    String default0;
    String default1;
    String default2;
    
    Stage stageW = new Stage();
    Stage stageL = new Stage();

    @FXML
    private Button btnExit;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;

    @FXML
    private Label lblWin;
    @FXML
    private Label lblLost;
    @FXML
    private Label lblPercentage;

    @FXML
    private void handleBtn0Action(ActionEvent event) throws Exception {

        if (x == 0) {
            System.out.println("hai vinto");
            btn0.setStyle("-fx-background-color: #6CDE68;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(true);
            
            c++;
            won++;
            percent = (won*100)/c;
            
            setterLbl();

        } else {
            System.out.println("hai perso");
            btn0.setStyle("-fx-background-color: #E44D5C;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(false);
            
            c++;
            lost++;
            percent = (won*100)/c;
            
            setterLbl();
            
        }
        
        switch(x){
            case 0: break;
            case 1: btn1.setStyle("-fx-background-color: #6CDE68;");
                break;
            case 2: btn2.setStyle("-fx-background-color: #6CDE68;");
                break;
        }

    }

    @FXML
    private void handleBtn1Action(ActionEvent event) throws Exception {

        if (x == 1) {
            System.out.println("hai vinto");
            btn1.setStyle("-fx-background-color: #6CDE68;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(true);
            
            c++;
            won++;
            percent = (won*100)/c;
            
            setterLbl();
            
        } else {
            System.out.println("hai perso");
            btn1.setStyle("-fx-background-color: #E44D5C;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(false);
            
            c++;
            lost++;
            percent = (won*100)/c;
            
            setterLbl();
        }
        
        switch(x){
            case 0: btn0.setStyle("-fx-background-color: #6CDE68;");
                break;
            case 1: break;
            case 2: btn2.setStyle("-fx-background-color: #6CDE68;");
                break;
        }

    }

    @FXML
    private void handleBtn2Action(ActionEvent event) throws Exception {

        if (x == 2) {
            System.out.println("hai vinto");
            btn2.setStyle("-fx-background-color: #6CDE68;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(true);
            
            c++;
            won++;
            percent = (won*100)/c;
            
            setterLbl();
        } else {
            System.out.println("hai perso");
            btn2.setStyle("-fx-background-color: #E44D5C;");
            btn0.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            dialogWindow(false);
            
            c++;
            lost++;
            percent = (won*100)/c;
            
            setterLbl();
        }
        
        switch(x){
            case 0: btn0.setStyle("-fx-background-color: #6CDE68;");
                break;
            case 1: btn1.setStyle("-fx-background-color: #6CDE68;");
                break;
            case 2: break;
        }

    }

    @FXML
    private void handleBtnPlayAction(ActionEvent event) {

        Play();

    }

    @FXML
    private void handleBtnExitAction(ActionEvent event) {
        System.out.println("Exit application: bye bye.");
        Platform.exit();
    }
    
    public void Play() {

        Random r = new Random();
        x = r.nextInt(3);

        btn0.setStyle(default0);
        btn1.setStyle(default1);
        btn2.setStyle(default2);

        btn0.setDisable(false);
        btn1.setDisable(false);
        btn2.setDisable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        default0 = btn0.getStyle();
        default1 = btn1.getStyle();
        default2 = btn2.getStyle();
        Play();

    }

    public void dialogWindow(boolean x) throws Exception {

        if (x == true) {
            Parent wD = FXMLLoader.load(getClass().getResource("/view/winDialog.fxml"));
            Scene win = new Scene(wD);
            stageW.setScene(win);
            stageW.show();
        } else {
            Parent lD = FXMLLoader.load(getClass().getResource("/view/looseDialog.fxml"));
            Scene loose = new Scene(lD);
            stageL.setScene(loose);
            stageL.show();
        }
    }
    
    public void setterLbl(){
        
        lblWin.setText("\t" + String.valueOf(won));
        lblLost.setText("\t" + String.valueOf(lost));
        lblPercentage.setText("\t" + String.valueOf(percent) + "%");
        
    }
}
