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
    private static ObservableList<Facultad> buscarFacultades() throws SQLException, ClassNotFoundException{
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
}
