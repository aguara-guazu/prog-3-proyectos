package ar.frp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Facultades {
    
    @FXML
    private TableView<Facultad> tableView_facultad;
    
    @FXML
    private TableColumn<Facultad, String> col_sharp;
    
    @FXML
    private TableColumn<Facultad, String> col_facultad;
    
    @FXML
    private TableColumn<Facultad, String> col_direccion;
    
    @FXML
    private TableColumn<Facultad, String> col_cuit;
    
    @FXML
    private TableColumn<Facultad, String> col_suc;
    
    @FXML
    private TableColumn<Facultad, String> col_telefono;
    
    @FXML
    private TableColumn<Facultad, String> col_email;
    
    @FXML
    private TableColumn<Facultad, String> col_defecto;
    
    @FXML
    private JFXTextField txt_Buscar;
    
    @FXML
    private JFXButton btn_limpiar;
    
    @FXML
    private JFXButton btn_salir;
    
    @FXML
    private JFXButton btn_buscar;
    
    @FXML
    private JFXButton btn_buscarTodos;
    
    @FXML
    private JFXButton btn_insertar;
    
    @FXML
    private JFXButton btn_borrar;
    
    @FXML
    private JFXButton btn_modificar;
    
    @FXML
    private JFXButton btn_imprimir;
    
    @FXML
    private JFXTextField txt_apellidoyNombres;
    
    @FXML
    private JFXTextField txt_cuilCuit;
    
    @FXML
    private JFXTextField txt_direccion;
    
    @FXML
    private JFXTextField txt_localidad;
    
    @FXML
    private JFXTextField txt_telefonos;
    
    @FXML
    private JFXTextField txt_saldoApertura;
    
    @FXML
    public void initialize(){
        /*
        El metodo setCellValueFactory() es usado en las columnas para determinar que atributos de la clase facultad
        en el paquete model facultad
         */
        col_sharp.setCellValueFactory(ColData -> ColData.getValue().id_facultadProperty());
        col_facultad.setCellValueFactory(ColData -> ColData.getValue().nombreProperty());
        col_direccion.setCellValueFactory(ColData -> ColData.getValue().direccionProperty());
        col_cuit.setCellValueFactory(ColData -> ColData.getValue().cuitProperty());
        col_suc.setCellValueFactory(ColData -> ColData.getValue().sucursalProperty());
        col_telefono.setCellValueFactory(ColData -> ColData.getValue().telefonoProperty());
        col_email.setCellValueFactory(ColData -> ColData.getValue().correoProperty());
        col_defecto.setCellValueFactory(ColData -> ColData.getValue().defectoProperty());
        
        tableView_facultad.setOnMouseClicked(event -> {
            
        });
    }
}
