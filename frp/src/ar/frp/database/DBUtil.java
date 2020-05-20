package ar.frp.database;

import javafx.scene.control.Alert;

import java.sql.*;

public class DBUtil {
    //conexion a la db
    public static Connection conn = null;
    //string con la url local de la db
    private static final String connStr = "jdbc:postgresql://localhost:5432/terceros";
    
    //funcion para conectar...
    public static void dbConnect() throws SQLException, ClassNotFoundException{
        try {
            conn = DriverManager.getConnection(connStr,"postgres","425727");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("informacion");
            alert.setHeaderText(null);
            alert.setContentText("conexion exitosa =)");
            alert.showAndWait();
        }
        catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("fallo de conexion");
            alert.setHeaderText(null);
            alert.setContentText("conexion fallida D=");
            e.printStackTrace();
            alert.showAndWait();
            throw e;
        }
    }
    
    //cerrar la conexion manualmente
    public static void dbDisconnect() throws SQLException{
        try {
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        }
        catch (Exception e){
            throw e;
        }
    }
    
    ///operacion Dol sobre la BD
    public static ResultSet dbExecutableQuery(String queryStmt) throws SQLException, ClassNotFoundException{
        //declaro null todos los argumentos del metodo
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //creo el objeto query
            stmt = conn.createStatement();
            //ejecuto la operacion query select
            resultSet = stmt.executeQuery(queryStmt);
        }
        catch (SQLException e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("error sql");
            alert2.setContentText("Problema en la ejecucion del query " + e);
            e.printStackTrace();
            alert2.showAndWait();
            throw e;
        }
        finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (stmt != null){
                stmt.close();
            }
        }
        return resultSet;
    }

    //operaciones DOL para update/inset/delete
    public static  void dbExecutableUpdate(String sqlStmt) throws SQLException, ClassNotFoundException{
        //declaro statement como null
        Statement stmt = null;
        try{
            //creo el objeto statement
            stmt = conn.createStatement();
            //ejecuto operaciones con executionupdate con las sentencias sql
            stmt.executeUpdate(sqlStmt);
        }
        catch (SQLException e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("error sql");
            alert2.setContentText("Problema con la operacion de update/insert o delete " + e);
            e.printStackTrace();
            alert2.showAndWait();
            throw e;
        }
        finally {
            if (stmt !=null){
                stmt.close();
            }
        }
    }
}
