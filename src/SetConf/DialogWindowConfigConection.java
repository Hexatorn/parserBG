package SetConf;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Util.SERWER_TYPE;



public class DialogWindowConfigConection extends Application {

    private static SERWER_TYPE serwer_type = null;
    private ConfigData config = new ConfigData();

    public void showWindow(SERWER_TYPE type){
        serwer_type = type;
        launch();
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
                    <Password Field - password>
                <HBox - buttons container> <- add hBox to set spacing
                    <Button - Save>
                </HBox - buttons container>
            </VBox - root>
         */
        primaryStage.setTitle("Konfiguracja Połącznia z serwerem "+serwer_type);

        //Server Address
        Label lbl_serverAdress = new Label("Adres Serwera "+serwer_type);
        TextField tf_ServerAdress = new TextField();
        VBox vb_serverAdress = new VBox(lbl_serverAdress,tf_ServerAdress);
        vb_serverAdress.paddingProperty().setValue(new Insets(0,0,20,0));
        //Login
        Label lbl_login = new Label("Login");
        TextField tf_login = new TextField();
        //Password
        Label lbl_password = new Label("Hasło");
        PasswordField pf_password = new PasswordField();


        //Button(s)
        Button btn_save = new Button("Zapisz");
        HBox hb_butons = new HBox(btn_save);
        hb_butons.paddingProperty().setValue(new Insets(30,0,20,0));
        hb_butons.setAlignment(Pos.CENTER_RIGHT);

        btn_save.setOnAction(event -> {
            ConfigData newConfigData = new ConfigData(
                    serwer_type,
                    tf_ServerAdress.getText(),
                    tf_login.getText(),
                    pf_password.getText());
            /*
            * Changing the configuration data of one of the servers.
            * */
            System.out.println("log-> Wprowadznie zmian w pliku konfiguracyjnym");
            System.out.println("log-> Zmienianie danych serwera "+serwer_type);
            if (CreateNewConfig.create(newConfigData))
                System.out.println("log-> Zmiany zapisane");
            else
                System.out.println("log-> Błąd przy próbie zapisu zmian");
            primaryStage.close();
        });

        //Add all to main container
        VBox root = new VBox();
        root.paddingProperty().setValue(new Insets(20,20,0,20));
        root.getChildren().addAll(
                vb_serverAdress,
                lbl_login,
                tf_login,
                lbl_password,
                pf_password,
                hb_butons);
        //Create Scene
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
