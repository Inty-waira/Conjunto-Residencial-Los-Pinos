package com.unab.CRLosPinos.models.respuestas;

import java.util.Date;

public class FacturaDataRestModel {
    
    private String idFactura;
    private Date fecha;
    private String pagadoCasa;
    private String pagadoParqueadero;
    private Date creada;
    private boolean pagada;
    private UsuarioDataRestModel usuarioEntidad;
    private FacturaDataRestModel pagoEntidadCasa;
    private FacturaDataRestModel pagoEntidadParqueadero;



    public String getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPagadoCasa() {
        return this.pagadoCasa;
    }

    public void setPagadoCasa(String pagadoCasa) {
        this.pagadoCasa = pagadoCasa;
    }

    public String getPagadoParqueadero() {
        return this.pagadoParqueadero;
    }

    public void setPagadoParqueadero(String pagadoParqueadero) {
        this.pagadoParqueadero = pagadoParqueadero;
    }

    public Date getCreada() {
        return this.creada;
    }

    public void setCreada(Date creada) {
        this.creada = creada;
    }

    public boolean isPagada() {
        return this.pagada;
    }

    public boolean getPagada() {
        return this.pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public UsuarioDataRestModel getUsuarioEntidad() {
        return this.usuarioEntidad;
    }

    public void setUsuarioEntidad(UsuarioDataRestModel usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
    }

    public FacturaDataRestModel getPagoEntidadCasa() {
        return this.pagoEntidadCasa;
    }

    public void setPagoEntidadCasa(FacturaDataRestModel pagoEntidadCasa) {
        this.pagoEntidadCasa = pagoEntidadCasa;
    }

    public FacturaDataRestModel getPagoEntidadParqueadero() {
        return this.pagoEntidadParqueadero;
    }

    public void setPagoEntidadParqueadero(FacturaDataRestModel pagoEntidadParqueadero) {
        this.pagoEntidadParqueadero = pagoEntidadParqueadero;
    }

}
