import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controller.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        String css = this.getClass().getResource("Controller.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setMinWidth(600);
        stage.setMinHeight(700);

        Image icon = new Image("XO_icon.PNG");
        stage.getIcons().add(icon);

        stage.show();
    }
}
