package SetConfig;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Hexatorn on 2017-11-23.
 */
public class DialogWindowConfigConection extends Application {
    static void showWindow(){
        launch();
        System.out.println("Okno");
    }

    @Override
    public void start(Stage primaryStage)  {
        /*
            Structure of the dialog window. XML-like pseudocode.
            <VBox - root>
                <VBox - server address> <- add vBox to set spacing
                    <Label - server address>
                    <Text Field - server address>
                </VBox - server address>
                    ... <- adding vbox would be consistent, but it was not necessary
                    <Label - login>
                    <Text Field - login>
                    <Label - password>
                    <Text Field - password>
                <HBox - buttons container> <- add hBox to set spacing
                    <Button - Save>
                </HBox - buttons container>
            </VBox - root>
         */
        primaryStage.setTitle("Konfiguracja Połącznia z serwerem FTP");

        //Server Address
        Label lbl_serverAdress = new Label("Adres Serwera FTP");
        TextField tf_ServerAdress = new TextField();
        VBox vb_serverAdress = new VBox(lbl_serverAdress,tf_ServerAdress);
        vb_serverAdress.paddingProperty().setValue(new Insets(0,0,20,0));
        //Login
        Label lbl_login = new Label("Login");
        TextField tf_login = new TextField();
        //Password
        Label lbl_password = new Label("Hasło");
        TextField tf_password = new TextField();
        //Button(s)
        Button btn_save = new Button("Zapisz");
        HBox hb_butons = new HBox(btn_save);
        hb_butons.paddingProperty().setValue(new Insets(30,0,20,0));
        hb_butons.setAlignment(Pos.CENTER_RIGHT);
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SaveData.SaveData();
            }
        });
        //Add all to main container
        VBox root = new VBox();
        root.paddingProperty().setValue(new Insets(20,20,0,20));
        root.getChildren().addAll(
                vb_serverAdress,
                lbl_login,
                tf_login,
                lbl_password,
                tf_password,
                hb_butons);
        //Create Scene
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
