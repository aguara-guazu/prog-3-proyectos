package ar.frp.controller;
// se crea una correspondencia 1:1 con las tablas de la bd

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Facultad {
    private final SimpleStringProperty id_facultad;
    private final StringProperty nombre;
    private final StringProperty direccion;
    private final StringProperty cuit;
    private final StringProperty sucursal;
    private final StringProperty telefono;
    private final StringProperty correo;
    private final StringProperty defecto;
    
    public Facultad() {
        this.id_facultad = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
        this.cuit = new SimpleStringProperty();
        this.sucursal = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.defecto = new SimpleStringProperty();
        this.correo = new SimpleStringProperty();
    }
    
    public final String getId_facultad() {
        return id_facultad.get();
    }
    
    public final SimpleStringProperty id_facultadProperty() {
        return id_facultad;
    }
    
    public final String getNombre() {
        return nombre.get();
    }
    
    public final StringProperty nombreProperty() {
        return nombre;
    }
    
    public final String getDireccion() {
        return direccion.get();
    }
    
    public final StringProperty direccionProperty() {
        return direccion;
    }
    
    public final String getCuit() {
        return cuit.get();
    }
    
    public final StringProperty cuitProperty() {
        return cuit;
    }
    
    public final String getSucursal() {
        return sucursal.get();
    }
    
    public final StringProperty sucursalProperty() {
        return sucursal;
    }
    
    public final String getTelefono() {
        return telefono.get();
    }
    
    public final StringProperty telefonoProperty() {
        return telefono;
    }
    
    public final String getCorreo() {
        return correo.get();
    }
    
    public final StringProperty correoProperty() {
        return correo;
    }
    
    public final String getDefecto() {
        return defecto.get();
    }
    
    public final StringProperty defectoProperty() {
        return defecto;
    }
    
    public final void setId_facultad(String id_facultad) {
        id_facultadProperty().set(id_facultad);
    }
    
    public final void setNombre(String nombre) {
        nombreProperty().set(nombre);
    }
    
    public final void setDireccion(String direccion) {
        direccionProperty().set(direccion);
    }
    
    public final void setCuit(String cuit) {
        cuitProperty().set(cuit);
    }
    
    public final void setSucursal(String sucursal) {
        sucursalProperty().set(sucursal);
    }
    
    public final void setTelefono(String telefono) {
        telefonoProperty().set(telefono);
    }
    
    public final void setCorreo(String correo) {
        correoProperty().set(correo);
    }
    
    public final void setDefecto(boolean defecto) {
        defectoProperty().set(String.valueOf(defecto));
    }
    
}
