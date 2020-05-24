package ar.frp.database;

import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Results {
    /*
    * Pequeña generaizacion que tomara los resutset de la db y los devolvera
    * para ser tratado como corresponda por su clase DAO.
    * GenercAlert es simplemente un alerta generalizada para no reescribir los alerts, podria ir aparte de la clase
    * Pero esta en esta clase mas por pereza que por necesidad.
    */
    
    public static ResultSet bringResultSet(String tableName) throws SQLException, ClassNotFoundException {
        String string = "SELECT * FROM "+ tableName;
        try {
            ResultSet resultSet = DBUtil.dbExecutableQuery(string);
            return resultSet;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            genericAlert("Imposible obtener el resultSet de la tabla ", sqlException).showAndWait();
            throw sqlException;
        }
    }
    public static void shipDataTo(String tableName, String tableColums, String values) throws SQLException,ClassNotFoundException{
        
        String updateStatement = "INSERT INTO " + tableName +"("+ tableColums.toUpperCase() + ")\n" +
                "VALUES (" + values + ")";
        
        try {
            DBUtil.dbExecutableUpdate(updateStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            genericAlert("Imposible cargar la tabla: ", e).showAndWait();
            throw e;
        }
    }
    public static void deleteDataFrom(String table, String idTable, String value) throws SQLException, ClassNotFoundException {
        try {
            String deleteStatement = "DELETE FROM " + table + "\n" +
                    "WHERE " + idTable + " is " + value;
            
            DBUtil.dbExecutableUpdate(deleteStatement);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            genericAlert("error operacion delete: ", sqlException).showAndWait();
            throw sqlException;
        }
    }
    public static Alert genericAlert(String message, Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("error SQL");
        alert.setContentText(message + e);
        return alert;
    }
    
}
