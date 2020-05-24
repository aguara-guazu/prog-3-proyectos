package ar.frp.controller;

import ar.frp.database.FacultadDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

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
    private JFXTextField txt_facultad;
    
    @FXML
    private JFXTextField txt_direccion;
    
    @FXML
    private JFXTextField txt_cuit;
    
    @FXML
    private JFXTextField txt_sucursal;
    
    @FXML
    private JFXTextField txt_telefonos;
    
    @FXML
    private JFXTextField txt_email;
    
    @FXML
    private JFXCheckBox chb_defecto;
    
    public void initialize(){
        col_sharp.setCellValueFactory(ColumnData -> ColumnData.getValue().id_facultadProperty());
        col_facultad.setCellValueFactory(ColumnData -> ColumnData.getValue().nombreProperty());
        col_direccion.setCellValueFactory(ColumnData -> ColumnData.getValue().direccionProperty());
        col_cuit.setCellValueFactory(ColumnData -> ColumnData.getValue().cuitProperty());
        col_suc.setCellValueFactory(ColumnData -> ColumnData.getValue().sucursalProperty().asString());
        col_telefono.setCellValueFactory(ColumnData -> ColumnData.getValue().telefonoProperty());
        col_email.setCellValueFactory(ColumnData -> ColumnData.getValue().correoProperty());
        col_defecto.setCellValueFactory(ColumnData -> ColumnData.getValue().defectoProperty().asString());
        
        Platform.runLater(() -> { txt_Buscar.requestFocus();});
        mostrarDetallesFacultad(null);
        
        tableView_facultad.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> mostrarDetallesFacultad(newValue)));
        btn_limpiar.setOnAction(event -> {
            txt_Buscar.clear();
            mostrarDetallesFacultad(null);
            tableView_facultad.getItems().clear();
            txt_Buscar.requestFocus();
        });
        tableView_facultad.setOnMouseClicked(event -> {
            ObservableList<Facultad> facultades = tableView_facultad.getSelectionModel().getSelectedItems();
            facultades.forEach(facultad -> idFacultad = facultad.getId_facultad());
        });
        btn_salir.setOnAction(event -> {((Node)(event.getSource())).getScene().getWindow().hide();});
        btn_insertar.setOnAction(event -> {
            try {
                insertarFacultad();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btn_borrar.setOnAction(event -> {
            try {
                borrarFacultad();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
    }
    
    private String idFacultad;
    private  Integer indexTabla;
    private void mostrarDetallesFacultad(Facultad unaFacultad){
        if (unaFacultad != null){
            txt_facultad.setText(unaFacultad.getNombre());
            txt_direccion.setText(unaFacultad.getDireccion());
            txt_cuit.setText(unaFacultad.getCuit());
            txt_sucursal.setText(unaFacultad.getSucursal().toString());
            txt_telefonos.setText(unaFacultad.getTelefono());
            txt_email.setText(unaFacultad.getCorreo());
            chb_defecto.setSelected(unaFacultad.getDefecto());
        }
        else{
            txt_email.clear();
            txt_telefonos.clear();
            txt_sucursal.clear();
            txt_cuit.clear();
            txt_direccion.clear();
            txt_facultad.clear();
            chb_defecto.setSelected(false);
        }
    }
    private void insertarFacultad() throws SQLException,ClassNotFoundException{
        try{
            String values =                                                  "'" +
                            txt_facultad.getText()                      + "', '" +
                            txt_direccion.getText()                     + "', '" +
                            txt_cuit.getText()                          + "', '" +
                            Integer.parseInt(txt_sucursal.getText())    + "', '" +
                            txt_telefonos.getText()                     + "', '" +
                            txt_email.getText()                         + "', '" +
                            Boolean.parseBoolean(chb_defecto.getText()) + "'";
    
            FacultadDAO.insertarFacultad(values);
            
            mostrarDetallesFacultad(null);
            txt_facultad.requestFocus();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void borrarFacultad() throws SQLException, ClassNotFoundException{
        try {
            if (idFacultad != null){
                FacultadDAO.borrarFacultad(idFacultad);
                indexTabla = tableView_facultad.getSelectionModel().getSelectedIndex();
                tableView_facultad.getItems().remove(indexTabla);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error sql");
            alert.setContentText("es necesario seleccionar una facultad para borrarla");
            alert.showAndWait();
            throw sqlException;
        }
    }
    private void modificarFaultad()throws SQLException, ClassNotFoundException{
        try {
            if (idFacultad != null){
                FacultadDAO.modificarFacultad();
                mostrarDetallesFacultad();
                txt_Buscar.requestFocus();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("error sql");
                alert.setContentText("seleccione una facultad para modificarla");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
