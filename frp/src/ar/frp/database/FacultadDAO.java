package ar.frp.database;

import ar.frp.controller.Facultad;
import ar.frp.controller.Facturas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultadDAO {
    //select de la tabla de FACULTAD

    public static ObservableList<Facultad> buscarFacultades() throws SQLException, ClassNotFoundException{
        //declaro resultados del metodo dbexecutequery
        String selectStmt = "SELECT * FROM facultad";
        try {
            //obtengo resultados del metodo dbexecutequery
            ResultSet rsFacus = DBUtil.dbExecutableQuery(selectStmt);
            ObservableList<Facultad> facuList = getFacultades(rsFacus);
            //devuelve el objeto facultad
            return facuList;
        }
        catch (SQLException e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("error sql");
            alert2.setContentText("Imposible mostrar la facultad:  " + e);
            e.printStackTrace();
            alert2.showAndWait();
            throw e;
        }
    }

    private static ObservableList<Facultad> getFacultades(ResultSet rs) throws SQLException, ClassNotFoundException {
        //declaro una lista observable que comprende a los objetos facultades
        ObservableList<Facultad> faculist = FXCollections.observableArrayList();
        while (rs.next()){
            Facultad facu = new Facultad();
            facu.setId_facultad(rs.getString("id_facultad"));
            facu.setNombre(rs.getString("nombre"));
            facu.setDireccion(rs.getString("direccion"));
            facu.setCuit(rs.getString("cuit"));
            facu.setSucursal(rs.getString("sucursal"));
            facu.setTelefono(rs.getString("telefonos"));
            facu.setCorreo(rs.getString("email"));
            facu.setDefecto(rs.getBoolean("defecto"));
            faculist.add(facu);
        }
        return faculist;
    }
    
    //insert a la tabla de facultad
    public static void insertarFacultad(String nombre, String direccion, String cuit, Integer sucursal,
                                        String telefonos, String email, Boolean defecto) throws SQLException, ClassNotFoundException {
        //declaracion del insert
        String updateStmt = "INSERT INTO facultad (NOMBRE, DIRECCION, CUIT, SUCURSAL, TELEFONO, EMAIL, DEFECTO)\n"+
                "VALUES ('" + nombre + "', " + direccion + "', " + cuit + "', " +
                sucursal + "', " + telefonos + "', " + email + "', " + defecto + ")";
        
        //se ejecuta el insert
        
        try {
            DBUtil.dbExecutableUpdate(updateStmt);
        }
        catch (SQLException e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("error sql");
            alert2.setContentText("Imposible dar de alta la facultad:  " + e);
            e.printStackTrace();
            alert2.showAndWait();
            throw e;
        }
    }
}

