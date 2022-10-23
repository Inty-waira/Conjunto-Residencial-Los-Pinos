package com.unab.CRLosPinos.models.peticiones;

import java.util.Date;

public class FacturaCrearRequestModel {

    private Date fecha;
    private String pagoCcasa;
    private String pagoParqueadero;


    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPagoCcasa() {
        return this.pagoCcasa;
    }

    public void setPagoCcasa(String pagoCcasa) {
        this.pagoCcasa = pagoCcasa;
    }

    public String getPagoParqueadero() {
        return this.pagoParqueadero;
    }

    public void setPagoParqueadero(String pagoParqueadero) {
        this.pagoParqueadero = pagoParqueadero;
    }
    
    
}
