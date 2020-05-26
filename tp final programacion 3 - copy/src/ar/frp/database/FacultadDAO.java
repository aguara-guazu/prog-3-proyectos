package ar.frp.database;

import ar.frp.controller.Facultad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultadDAO {
    public static void insertarFacultad(String values) throws SQLException, ClassNotFoundException {
        String columnas = "NOMBRE, DIRECCION, CUIT, SUCURSAL, TELEFONOS, EMAIL, DEFECTO";
        String tabla = "facultad";
        Results.shipDataTo(tabla, columnas, values);
    }
    public static void borrarFacultad(String idFacultad) throws SQLException, ClassNotFoundException {
        Results.deleteDataFrom("facultad", "id_facultad", idFacultad);
    }
    public static void modifcarFacultad(String values, String idFacultad) throws SQLException, ClassNotFoundException{
        String[] columns = new  String[]{"nombre", "direccion", "cuit", "sucursal", "telefonos", "email", "defecto", "id_facultad"};
        String[] valuesArray = values.split(",");
        Results.editDataFrom("facultad",columns, valuesArray,"id_facultad",idFacultad);
    }
    public static ObservableList<Facultad> buscarFacultades() throws SQLException, ClassNotFoundException{
        try {
            ObservableList<Facultad> listaFacultades;
            listaFacultades = FXCollections.observableArrayList();
            ResultSet resultSet = Results.bringResultSet("facultad");
            while (resultSet.next()) {
                Facultad facultad = new Facultad();
                facultad.setId_facultad(resultSet.getString("id_facultad"));
                facultad.setNombre(resultSet.getString("nombre"));// mover a general DAO
                facultad.setDireccion(resultSet.getString("direccion"));// mover a general DAO
                facultad.setCuit(resultSet.getString("cuit"));// mover a general DAO
                facultad.setSucursal(resultSet.getInt("sucursal"));
                facultad.setTelefono(resultSet.getString("telefonos"));// mover a general DAO
                facultad.setCorreo(resultSet.getString("email"));
                facultad.setDefecto(resultSet.getBoolean("defecto"));
                listaFacultades.add(facultad);
            }

            return listaFacultades;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            Results.genericAlert("imposible mostrar la facultad: ", sqlException).showAndWait();
            throw sqlException;
        }
    }
    public static ObservableList<Facultad> buscarFacultad(String nombreFacultad) throws SQLException, ClassNotFoundException{
        
        ResultSet resultSet = Results.searchData("facultad", "NOMBRE", nombreFacultad);
        ObservableList<Facultad> lista = FXCollections.observableArrayList();
    
        if (resultSet.isBeforeFirst()) {
            while (resultSet.next()) {
                Facultad facultad = new Facultad();
                facultad.setId_facultad(Integer.toString(resultSet.getInt("id_facultad")));
                facultad.setNombre(resultSet.getString("nombre"));// mover a general DAO
                facultad.setDireccion(resultSet.getString("direccion"));// mover a general DAO
                facultad.setCuit(resultSet.getString("cuit"));// mover a general DAO
                facultad.setSucursal(resultSet.getInt("sucursal"));
                facultad.setTelefono(resultSet.getString("telefonos"));// mover a general DAO
                facultad.setCorreo(resultSet.getString("email"));
                facultad.setDefecto(resultSet.getBoolean("defecto"));
                lista.add(facultad);
            }
        } else {
            Results.genericAlert("la busqueda \"" + nombreFacultad +"\" no existe en la base de datos", null).showAndWait();
            return null;
        }
    
        return lista;
    }
}
