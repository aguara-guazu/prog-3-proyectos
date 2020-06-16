package utn.frp.p4.model.controllers;

import io.vertx.core.Future;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utn.frp.p4.model.Whisky;
import utn.frp.p4.model.server.ServerAccess;

public class WhiskyEditDialogController {
    
    @FXML
    private Label idLabel;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField originField;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
    
    private Stage dialogStage;
    private boolean okClicked = false;
    private Whisky whisky;
    
    @FXML
    private void initialize() {
        okButton.setOnAction(event -> { handleOk();});
        cancelButton.setOnAction(event -> {handleCancel();});
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setWhisky(Whisky whisky) {
        this.whisky = whisky;
        this.idLabel.setText(whisky.getId().getValue().toString());
        this.nameField.setText(whisky.getName().getValue());
        this.originField.setText(whisky.getOrigin().getValue());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            Future<Integer> handlerResult = (whisky.getId().get() == 0) ? ServerAccess.insertWhisky(nameField.getText(), originField.getText()) :
                    ServerAccess.updateWhisky(whisky.getId().get(), nameField.getText(), originField.getText());
            handlerResult.setHandler(ar -> {
                if (ar.succeeded()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            whisky.setId(ar.result());
                            whisky.setName(nameField.getText());
                            whisky.setOrigin(originField.getText());
                            okClicked = true;
                            dialogStage.close();
                        }
                    });
                } else {
                    System.out.println(ar.cause());
                    okClicked = false;
                    dialogStage.close();
                }
            });
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "¡Marca de whisky no válida!\n";
        }
        if (originField.getText() == null || originField.getText().length() == 0) {
            errorMessage += "¡Origen no válido!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else { // Show the error message.
            Alert exceptionDialog = new Alert(Alert.AlertType.ERROR);
            exceptionDialog.setTitle("Error de carga de datos");
            exceptionDialog.setHeaderText("Corrija los siguientes errores");
            exceptionDialog.setContentText(errorMessage);
            exceptionDialog.show();
            return false;
        }
    }
}
