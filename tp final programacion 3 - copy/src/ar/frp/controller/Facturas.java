package ar.frp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Facturas {
    
    @FXML
    private JFXButton btn_imprimirFactura;
    
    @FXML
    private JFXButton btn_cancelarFactura;
    
    @FXML
    private TableView<?> tableview_detalles;
    
    @FXML
    private JFXComboBox<?> combobox_tercero;
    
    @FXML
    private JFXTextField tb_cuitCuil;
    
    @FXML
    private JFXComboBox<?> combobox_iva;
    
    @FXML
    private JFXComboBox<?> combobox_provincia;
    
    @FXML
    private JFXTextField tb_localidad;
    
    @FXML
    private JFXTextField tb_domicilio;
    
    @FXML
    private JFXButton btn_eliminarItem;
    
    @FXML
    private JFXButton btn_agregarItem;
    
    @FXML
    private TextField tb_cantidad;
    
    @FXML
    private TextArea tb_detalle;
    
    @FXML
    private TextField tb_monto;
    
    @FXML
    private Label label_total;
    
    @FXML
    private JFXButton btn_salir;
    
}
