package utn.frp.p4.model.controllers;

import javafx.fxml.FXML;

public class RootLayoutController {
    
    WhiskyController wController;
    
    @FXML
    public void onExit() {
        System.exit(0);
    }
    
    public void setWhiskyController(WhiskyController wController) {
        this.wController = wController;
    }
}
