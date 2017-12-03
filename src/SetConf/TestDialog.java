package SetConf;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import sun.applet.Main;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * Created by Hexatorn on 2017-12-03.
 */
public class TestDialog extends Application{

    public String s1;
    public String s2;

    public void showDialog(){
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Configure connection...");
        dialog.setHeaderText("Configure connection to FTP Server");

        // Set the button types.

        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,ButtonType.CANCEL);

        // Create the username and password labels and fields.

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

        //Server Address
        Label lbl_serverAdress = new Label("Adres Serwera FTP");
        TextField tf_ServerAdress = new TextField();
        tf_ServerAdress.setPromptText("Server Address");
        VBox vb_serverAdress = new VBox(lbl_serverAdress,tf_ServerAdress);
        vb_serverAdress.paddingProperty().setValue(new Insets(0,0,20,0));
        //Login
        Label lbl_login = new Label("Login");
        TextField tf_login = new TextField();
        tf_login.setPromptText("Login");
        //Password
        Label lbl_password = new Label("Password");
        PasswordField pf_password = new PasswordField();
        pf_password.setPromptText("Password");

        //Add all to main container
        VBox root = new VBox();
        root.paddingProperty().setValue(new Insets(20,20,0,20));
        root.getChildren().addAll(
                vb_serverAdress,
                lbl_login,
                tf_login,
                lbl_password,
                pf_password);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        tf_login.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(root);

        // Request focus on the username field by default.
        Platform.runLater(() -> tf_login.requestFocus());


        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(tf_login.getText(), pf_password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            s1 = usernamePassword.getKey();
            s2 = usernamePassword.getValue();

            System.out.println(s1+" "+s2);


            //System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });



    }
}
