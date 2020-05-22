package ar.frp.controller;

import javafx.beans.property.*;

public class Tercero {
    private SimpleIntegerProperty id_tercero;
    private StringProperty nombre, cuitl, sitiva, direccion, localidad, provincia, telefono, tipo_saldo;
    private DoubleProperty saldo_apertura;
    
    public Tercero(){
        this.id_tercero = new SimpleIntegerProperty();
        this.saldo_apertura = new SimpleDoubleProperty();
        this.cuitl = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.sitiva = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
        this.localidad = new SimpleStringProperty();
        this.provincia = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.tipo_saldo = new SimpleStringProperty();
    }
    
    public final Integer getId_tercero(){
        return id_tercero.get();
    }
    public SimpleIntegerProperty id_terceroProperty(){
        if (id_tercero == null){
            id_tercero = new SimpleIntegerProperty();
        }
        return id_tercero;
    }
    public final void setId_tercero(Integer id_tercero){
        id_terceroProperty().set(id_tercero);
    }
    
    public final Double getSaldo_apertura(){
        return saldo_apertura.get();
    }
    public DoubleProperty saldo_aperturaProperty(){
        if (saldo_apertura == null){
            saldo_apertura = new SimpleDoubleProperty();
        }
        return saldo_apertura;
    }
    public final void setSaldo_apertura(Double saldo_apertura){
        saldo_aperturaProperty().set(saldo_apertura);
    }
    
    public final String getCuitl(){
        return cuitl.get();
    }
    public StringProperty cuitlProperty(){
        if (cuitl == null){
            cuitl = new SimpleStringProperty();
        }
        return cuitl;
    }
    public final void setCuitl(String cuitl){
        cuitlProperty().set(cuitl);
    }
    
    public final String getNombre(){
        return nombre.get();
    }
    public StringProperty nombreProperty(){
        if (nombre == null){
            nombre = new SimpleStringProperty();
        }
        return nombre;
    }
    public final void setNombre(String nombre){
        nombreProperty().set(nombre);
    }
    
    public final String getSitiva(){
        return sitiva.get();
    }
    public StringProperty sitivaProperty(){
        if (sitiva == null){
            sitiva = new SimpleStringProperty();
        }
        return sitiva;
    }
    public final void setSitiva(String sitiva){
        sitivaProperty().set(sitiva);
    }
    
    public final String getDireccion(){
        return direccion.get();
    }
    public StringProperty direccionProperty(){
        if (direccion == null){
            direccion = new SimpleStringProperty();
        }
        return direccion;
    }
    public final void setDireccion(String direccion){
        direccionProperty().set(direccion);
    }
    
    public final String getLocalidad(){
        return localidad.get();
    }
    public StringProperty localidadProperty(){
        if (localidad == null){
            localidad = new SimpleStringProperty();
        }
        return localidad;
    }
    public final void setLocalidad(String localidad){
        localidadProperty().set(localidad);
    }
    
    public final String getProvincia(){
        return provincia.get();
    }
    public StringProperty provinciaProperty(){
        if (provincia == null){
            provincia = new SimpleStringProperty();
        }
        return provincia;
    }
    public final void setProvincia(String provincia){
        provinciaProperty().set(provincia);
    }
    
    public final String getTelefono(){
        return telefono.get();
    }
    public StringProperty telefonoProperty(){
        if (telefono == null){
            telefono = new SimpleStringProperty();
        }
        return telefono;
    }
    public final void setTelefono(String telefono){
        telefonoProperty().set(telefono);
    }
    
    public final String getTipo_saldo(){
        return tipo_saldo.get();
    }
    public StringProperty tipo_saldoProperty(){
        if (tipo_saldo == null){
            tipo_saldo = new SimpleStringProperty();
        }
        return tipo_saldo;
    }
    public final void setTipo_saldo(String tipo_saldo){
        tipo_saldoProperty().set(tipo_saldo);
    }
    
}
