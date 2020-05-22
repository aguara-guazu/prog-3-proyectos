package ar.frp.database;

import javafx.scene.control.Alert;
import org.jetbrains.annotations.NotNull;
import java.sql.*;

public class DBUtil {
    public static Connection connection = null; //se genera una conexion sql vacia.
    
    private static final String path = "jdbc:postgresql://localhost:5432/terceros";//se pasa el path url de la bd postgre local
    
    private static @NotNull Alert showAlert(String titile, String message, SQLException e){
        Alert genericAlert = new Alert(Alert.AlertType.INFORMATION);
        genericAlert.setTitle(titile);
        genericAlert.setHeaderText(null);
        if (e == null){
            genericAlert.setContentText(message);
        }
        else {
            genericAlert.setContentText(message + e);
        }
        return genericAlert;
    } //alerta generica para las excepciones.
    public  static void dbConnect() throws SQLException, ClassNotFoundException{
        try {
            connection = DriverManager.getConnection(path,"postgres","425727");
            showAlert("inforacion","conexion exitosa =)", null).showAndWait();
        }
        catch (SQLException e){
            e.printStackTrace();
            showAlert("fallo de conexion", "conexion a la db fallida", e).showAndWait();
            throw e;
        }
    } //conexion a la base de datos
    public  static void dbDisconnect()  throws SQLException, ClassNotFoundException{
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            throw e;
        }
    } // desconexion manual
    public  static ResultSet dbExecutableQuery(String queryStatement) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
        }catch (SQLException e){
            e.printStackTrace();
            showAlert("error SQL", "problema en la ejecucion del query", e).showAndWait();
            throw e;
        }
        finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
        }
        return resultSet;
    } //operaciones DOL sobre la bd
    public  static void dbExecutableUpdate(String sqlStatement) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("error SQL", "Problema con la operacion de update, insert o delete ", e).showAndWait();
            throw e;
        }
        finally {
            if (statement != null){
                statement.close();
            }
        }
    } //operaciones DOL para update/insert/delete
}
