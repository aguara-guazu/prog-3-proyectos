package utn.frp.p4.model.controllers;

import io.vertx.core.Future;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utn.frp.p4.model.Whisky;
import utn.frp.p4.model.server.ServerAccess;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class WhiskyController {
    
    @FXML
    private TableView<Whisky> whiskyTable;
    
    @FXML
    private TableColumn<Whisky, String> nameColumn;
    
    @FXML
    private TableColumn<Whisky, String> originColumn;
    
    @FXML
    private Label label_id;
    
    @FXML
    private Label label_marca;
    
    @FXML
    private Label label_origen;
    
    @FXML
    private Button btnAgregar;
    
    @FXML
    private Button btnModificar;
    
    @FXML
    private Button btnEliminar;
    
    private ObservableList<Whisky> whiskyData = FXCollections.observableArrayList();
    private  int seletedIndex;
    private Stage primaryStage;
    @FXML
    private void initialize(){
        this.whiskyTable.setItems(whiskyData);
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        this.originColumn.setCellValueFactory(celldata -> celldata.getValue().getOrigin());
        showWhiskyDetails(null);
        initializedWhiskyController();
        whiskyTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> showWhiskyDetails(newValue)));
        
        btnModificar.setOnAction(event -> {
            handleEditWhisky();
        });
        btnAgregar.setOnAction(event -> {
            handleNewWhisky();
        });
        
        btnEliminar.setOnAction(event -> {
            handleDeleteWhisky();
        });
    }
    
    @FXML
    public void handleNewWhisky(){
        System.out.println("handleNewWhisky");
        Whisky whisky = new Whisky();
        boolean clicked = this.showWhiskyEditDialog(whisky);
        if (clicked){
            this.whiskyData.add(whisky);
        }
    }
    
    @FXML
    public void handleEditWhisky(){
        this.seletedIndex = whiskyTable.getSelectionModel().getSelectedIndex();
        Whisky selectedWhisky = whiskyTable.getSelectionModel().getSelectedItem();
        if (selectedWhisky != null){
            boolean clicked = this.showWhiskyEditDialog(selectedWhisky);
            if (clicked){
                showWhiskyDetails(selectedWhisky);
            } else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("no selection detected");
                alert.setHeaderText("No se selecciono nada");
                alert.setContentText("seleccione algun whisky de la tabla");
                alert.show();
            }
        }
    }
    
    @FXML
    public void handleDeleteWhisky(){
        this.seletedIndex = whiskyTable.getSelectionModel().getSelectedIndex();
        if (seletedIndex >= 0){
            Whisky whisky = whiskyTable.getItems().get(seletedIndex);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmar borrado");
            String message = "¿esta seguro que decea borrar este item?\n"+
                    whisky.getId().get() +"\n" +
                    whisky.getName().getValue();
            alert.setContentText(message);
            Optional<ButtonType> result = alert.showAndWait();
            
            if ((result.isPresent()) && (result.get() == ButtonType.OK)){
                Future<Void> deleteResult = ServerAccess.deleteWhisky(whisky);
                deleteResult.setHandler(ar ->{
                    if (ar.succeeded()){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                whiskyTable.getSelectionModel().clearSelection();
                                whiskyData.remove(seletedIndex);
                            }
                        });
                    } else {
                        System.out.println(ar.cause());
                    }
                });
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("sin seleccion");
            alert.setHeaderText("no se selecciono nada");
            alert.setContentText("seleccione un whisky de la tabla");
            alert.show();
        }
    }
    
    public void initializedWhiskyController(){
        ServerAccess.getWhiskyStock(whiskyData);
    }
    
    private void showWhiskyDetails( Whisky whisky){
        if (whisky != null){
            label_id.setText(whisky.getId().getValue().toString());
            label_marca.setText(whisky.getName().getValue());
            label_origen.setText(whisky.getOrigin().getValue());
        } else {
            label_id.setText("");
            label_marca.setText("");
            label_origen.setText("");
        }
    }
    
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    
    public boolean showWhiskyEditDialog(Whisky whisky){
        try {
            FXMLLoader loader = new FXMLLoader();
            URL editDialogUrl = new File("src\\main\\java\\utn\\frp\\p4\\views\\WhiskyEditDialog.fxml").toURL();
            loader.setLocation(editDialogUrl);
            AnchorPane pane = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("edicion de whisky");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.primaryStage);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);
            
            WhiskyEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setWhisky(whisky);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
