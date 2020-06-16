package utn.frp.p4.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utn.frp.p4.model.controllers.RootLayoutController;
import utn.frp.p4.model.controllers.WhiskyController;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController mainController;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Whisky Manager");
            initRootLayout();
            showWhiskyOverview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void initRootLayout() {
        try {
            URL rootLayoutUrl = new File("src\\main\\java\\utn\\frp\\p4\\views\\RootLayout.fxml").toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(rootLayoutUrl);
            this.rootLayout = loader.load();
            this.mainController = loader.getController();
            Scene scene = new Scene(rootLayout, 600, 400);
            //scene.getStylesheets().add(getClass().getResource("views/application.css").toExternalForm()); //linea comentada ya que decidi no usar una hoja de estilos css
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            this.primaryStage.setOnCloseRequest(
                    we -> {
                        System.out.println("Stage is closing");
                        System.exit(0);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showWhiskyOverview() {
        try {
            URL whiskyUrl = new File("src\\main\\java\\utn\\frp\\p4\\views\\Whisky.fxml").toURL(); //nota adicional.
            // Se uso file para poder tener la url del path de los fxml ya que por algun motivo aun teniendo la misma estructura de archivos
            // que la del tutorial el metodo "class.getResource(url)" no me estaba resultando y no podia avanzar el tutorial.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(whiskyUrl);
            AnchorPane whiskyOverview = (AnchorPane) loader.load();
            this.rootLayout.setCenter(whiskyOverview);
            WhiskyController controller = (WhiskyController)loader.getController();
            controller.setPrimaryStage(primaryStage);
            controller.initializedWhiskyController();
            this.mainController.setWhiskyController(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
    }
}
