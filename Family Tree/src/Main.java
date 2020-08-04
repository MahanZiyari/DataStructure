import controller.Login;
import controller.SignUpDrawer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
        Parent root = loader.load();
        Login login = loader.getController();
        primaryStage.setTitle("My Family Tree");
        primaryStage.setScene(new Scene(root, 835, 505));
        primaryStage.show();
        login.setPrimaryStage(primaryStage);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
