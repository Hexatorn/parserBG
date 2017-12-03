package SetConf;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by Hexatorn on 2017-12-03.
 */
public class TestedWidnow extends Application {

    public String test;

    public void  testShow(){
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();
        textField.setText("lalala");
        Button button = new Button("Klik Me");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(textField.getText());
                test = textField.getText();
                System.out.println(test);
                primaryStage.hide();
            }
        });
        VBox root = new VBox();
        root.getChildren().addAll(textField,button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
