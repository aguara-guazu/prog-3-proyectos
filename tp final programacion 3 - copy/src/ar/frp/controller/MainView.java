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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.sql.SQLException;

public class MainView {
    
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
                gettingStage("../view/Facultad.fxml").show();
            } catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_crearFactura.setOnAction(event -> {
            try {
                gettingStage("../view/Facturas.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_buscarFactura.setOnAction(event -> {
            try {
                gettingStage("../view/Facturas.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_registrarPagos.setOnAction(event -> {
            try {
                gettingStage("../view/Facturas.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_buscarFactura.setOnAction(event -> {
            try {
                gettingStage("../view/Facturas.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_actualizacion.setOnAction(event -> {
            try {
                gettingStage("../view/Tercero.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_cuenta.setOnAction(event -> {
            try {
                gettingStage("../view/Tercero.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println(message_error);
            }
        });
        mitem_backupBd.setOnAction(event -> {
            //gettingStage("../view/.fxml").show();
        });
        mitem_restaurarBd.setOnAction(event -> {
          //gettingStage("../view/.fxml").show();
        });
        mitem_acercaDe.setOnAction(event -> {
            try {
                gettingStage("../view/About.fxml").show();
            }  catch (NullPointerException e) {
                System.out.println("el stage a vuelto como null!\nrevisar la pila de excepciones, " +
                        " si el path del fxml es correcto o si el propio fxml a cargar tiene todos los parametros corectos" +
                        "\nIE. si la clase controller del componente esta bien escrita o existe");
            }
        });
        btn_conectarBd.setOnAction(event -> {
            try {
                DBUtil.dbConnect();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btn_desconectarBd.setOnAction(event -> {
            try {
                DBUtil.dbDisconnect();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btn_salir.setOnAction(event -> {
            try {
                DBUtil.dbDisconnect();
                Platform.exit();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        
    }
    /*
    * si bien los nombres son claros, solo unas pequeñas aclaraciones tecnicas.
    * - esto se hizo para hacer mas modular la carga de los fxml y el setup de los stages.
    * - se dividio la creacion y el tratamiento de los stage, scene y fxml en 3 funciones distintas.
    * - cada una trata una parte del setup final para ser usadas en "gettingStage" quien finalmente
    *   devolvera un stage funcional en base al path del stage que se le indique.
    * - esto permitiria en un futuro controlar el estilo y la posicion de todos los stage a la vez, dado que
    *   en este caso se busca que todos los stages tengan el mismo estilo...
    * - loadFxml devolvera un fxml ya cargado.
    * - settingStage prepara un stage y con las propiedades (posicion y modalidad) ya cargadas mas la carga
    *   del scene que se le indique.
    * - gettingStage hace uso de las otras dos funciones, toma el path del archivo fxml como string y devuelve
    *   un stage armado con su respectivo scene ya cargado. En caso de ocurrir alguna excepcion por el momento
    *   este solo usara el printStack de la excepcion y como retorno dara un null.
    * */
    private @NotNull FXMLLoader loadFxml(String path){
         FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
         return loader;
    }
    private @NotNull Stage settingStage(Scene scene){
        Stage principalStage = new Stage();
        principalStage.initModality(Modality.APPLICATION_MODAL);
        principalStage.centerOnScreen();
        principalStage.setScene(scene);
        return principalStage;
    }
    private @Nullable Stage gettingStage(String path){
        try {
            FXMLLoader loader = loadFxml(path);
            Scene scene = new Scene(loader.load());
            return settingStage(scene);
        } catch (IOException e) {
            e.printStackTrace();
            return null; //solucion poco elegante al return de la excepcion, corregir luego por algo mejor...
        }
    }
    private final String message_error = "el stage a vuelto como null!\nrevisar la pila de excepciones, " +
            "si el path del fxml es correcto o si el propio fxml a cargar tiene todos los parametros corectos" +
            "\nIE. si la clase controller del componente esta bien escrita o existe";
}
