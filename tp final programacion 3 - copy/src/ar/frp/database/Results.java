package ar.frp.database;

import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String deleteStatement = "DELETE  FROM " + table + "\n" +
                    "WHERE " + idTable + " = " + value;
            
            DBUtil.dbExecutableUpdate(deleteStatement);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            genericAlert("error operacion delete: ", sqlException).showAndWait();
            throw sqlException;
        }
    }
    public static void editDataFrom(String table, String[] columns, String[] values, String idTable, String valueIdToUpdate) throws SQLException, ClassNotFoundException {
        StringBuilder columsAndValues = new StringBuilder();
        if (columns.length == values.length){
            for (int i = 0; i < columns.length; i++) {
                columsAndValues.append(columns[i] + " = " + "'" + values[i] + "'" + ",\n");
            }
            String newColumsAndValues = columsAndValues.substring(0, columsAndValues.lastIndexOf(",")); //remover la ultima coma sobrante antes del where
            String updateStatement = "UPDATE " + table +
                                     " SET " + newColumsAndValues +
                                     " WHERE " + idTable + " = " + valueIdToUpdate;
            try {
                DBUtil.dbExecutableUpdate(updateStatement);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                genericAlert("error en el update del elemento : ", sqlException);
                throw sqlException;
            }
        }else {
            genericAlert("Error.\nni los values ni las columnas tienen la misma cantida de valores!.", null).showAndWait();
        }
    }
    public static ResultSet searchData(String table, String column, String keyword) throws SQLException, ClassNotFoundException{
        try {
            
            String resultStatement = "SELECT * FROM " + table +
                                    " WHERE " + column + " LIKE " + "'"+ keyword + "'";
            return DBUtil.dbExecutableQuery(resultStatement);
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            genericAlert("imposible obtener el/los resultado/s ", sqlException).showAndWait();
            throw sqlException;
        }
    }
    public static Alert genericAlert(String message, Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("error SQL");
        if (e != null) {
            alert.setContentText(message + e);
        } else {
            alert.setContentText(message);
        }
        return alert;
    }
    
}
