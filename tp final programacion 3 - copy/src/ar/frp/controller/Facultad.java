package ar.frp.controller;

import javafx.beans.property.*;

public class Facultad {
    private SimpleStringProperty id_facultad;
    private StringProperty nombre, direccion, cuit, telefono, correo;
    private IntegerProperty sucursal;
    private BooleanProperty defecto;
    
    public Facultad(){
        this.id_facultad = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
        this.cuit = new SimpleStringProperty();
        this.sucursal = new SimpleIntegerProperty();
        this.telefono = new SimpleStringProperty();
        this.correo = new SimpleStringProperty();
        this.defecto = new SimpleBooleanProperty(false);
    }
    
    
    public final String getId_facultad() {
        return id_facultad.get();
    }
    public SimpleStringProperty id_facultadProperty() {
        if (id_facultad == null) {
            id_facultad = new SimpleStringProperty();
        }
        return id_facultad;
    }
    public final void setId_facultad(String id_facultad) {
        id_facultadProperty().set(id_facultad);
    }
    
    public final String getNombre() {
        return nombre.get();
    }
    public StringProperty nombreProperty() {
        if (nombre == null) {
            nombre = new SimpleStringProperty();
        }
        return nombre;
    }
    public final void setNombre(String nombre) {
        nombreProperty().set(nombre);
    }
    
    public final String getDireccion() {
        return direccion.get();
    }
    public StringProperty direccionProperty() {
        if (direccion == null) {
            direccion = new SimpleStringProperty();
        }
        return direccion;
    }
    public final void setDireccion(String direccion) {
        direccionProperty().set(direccion);
    }
    
    public final String getCuit() {
        return cuit.get();
    }
    public StringProperty cuitProperty() {
        if (cuit == null) {
            cuit = new SimpleStringProperty();
        }
        return cuit;
    }
    public final void setCuit(String cuit) {
        cuitProperty().set(cuit);
    }
    
    public final String getTelefono() {
        return telefono.get();
    }
    public StringProperty telefonoProperty() {
        if (telefono == null) {
            telefono = new SimpleStringProperty();
        }
        return telefono;
    }
    public final void setTelefono(String telefono) {
        telefonoProperty().set(telefono);
    }
    
    public final String getCorreo() {
        return correo.get();
    }
    public StringProperty correoProperty() {
        if (correo == null) {
            correo = new SimpleStringProperty();
        }
        return correo;
    }
    public final void setCorreo(String correo) {
        correoProperty().set(correo);
    }
    
    public final Integer getSucursal(){
        return sucursal.get();
    }
    public IntegerProperty sucursalProperty(){
        if (sucursal == null){
            sucursal = new SimpleIntegerProperty();
        }
        return sucursal;
    }
    public final void setSucursal(Integer sucursal){
        sucursalProperty().set(sucursal);
    }
    
    public final Boolean getDefecto(){
        return defecto.get();
    }
    public BooleanProperty defectoProperty(){
        if (defecto == null){
            defecto = new SimpleBooleanProperty(false);
        }
        return defecto;
    }
    public final void setDefecto(Boolean defecto){
        defectoProperty().set(defecto);
    }
    
}
