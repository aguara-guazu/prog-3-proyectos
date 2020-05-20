package ar.frp.controller;

import ar.frp.database.DBUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {

    @FXML
    private Menu menu_archivo;

    @FXML
    private MenuItem mitem_DatosFacultad;

    @FXML
    private MenuItem mitem_salir;

    @FXML
    private Menu menu_facturas;

    @FXML
    private MenuItem mitem_crearFactura;

    @FXML
    private MenuItem mitem_buscarFactura;

    @FXML
    private Menu menu_pagos;

    @FXML
    private MenuItem mitem_registrarPagos;

    @FXML
    private MenuItem mitem_buscarPagos;

    @FXML
    private Menu menu_terceros;

    @FXML
    private MenuItem mitem_actualizacion;

    @FXML
    private MenuItem mitem_cuenta;

    @FXML
    private Menu menu_mantenimiento;

    @FXML
    private MenuItem mitem_backupBd;

    @FXML
    private MenuItem mitem_restaurarBd;

    @FXML
    private Menu menu_ayuda;

    @FXML
    private MenuItem mitem_acercaDe;

    @FXML
    private Button btn_conectarBd;

    @FXML
    private Button btn_desconectarBd;

    @FXML
    private Button btn_salir;

    @FXML
    private void initialize(){

        mitem_DatosFacultad.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facultad.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }); //facultad

        mitem_crearFactura.setOnAction(event -> {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);

            Scene scene = new Scene(loader.load());
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }
            catch (IOException e){
            e.printStackTrace();
        }
        }); //facultades

        mitem_buscarFactura.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }); //facultades

        mitem_registrarPagos.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        });

        mitem_buscarPagos.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        });

        mitem_actualizacion.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Tercero.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }); //tercero

        mitem_cuenta.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Tercero.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }); //tercero

        mitem_backupBd.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        });

        mitem_restaurarBd.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Facturas.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        });

        mitem_acercaDe.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/About.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);

                Scene scene = new Scene(loader.load());
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }); //about
        
        btn_conectarBd.setOnAction(event -> {
            try {
                DBUtil.dbConnect();
            }
            catch (ClassNotFoundException | SQLException classNotFoundException){
                classNotFoundException.printStackTrace();
            }
        });
       
        btn_salir.setOnAction(event -> {
            try {
                DBUtil.dbDisconnect();
                Platform.exit();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        });
    }
}
