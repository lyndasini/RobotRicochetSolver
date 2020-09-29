package robotricochet.graphics;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

public class RulesBuilder {


    public static void showRules() throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Gaming Rules");
        Group root = new Group();
        Scene scene = new Scene(root,600,500);
        ImageView rulesImage = null;
        try {
            rulesImage = new ImageView(
                    new Image(new FileInputStream("src/main/resources/images/RULES.jpg")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        rulesImage.setFitHeight(600);
        rulesImage.setFitWidth(600);
        rulesImage.setPreserveRatio(true);
        root.getChildren().add(rulesImage);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}



