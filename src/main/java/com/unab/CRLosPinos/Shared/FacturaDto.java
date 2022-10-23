package com.unab.CRLosPinos.Shared;

import java.io.Serializable;
import java.util.Date;

public class FacturaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;  

    private long id;
    private String idFactura;
    private Date fecha;
    private String username;
    private String pagoCasa;
    private String pagoParqueadero;
    private String pagadoCasa;
    private String pagadoParqueadero;
    private Date generado;  
    private UsuarioDto usuarioEntidad;
    private PagoDto pagoEntidadCasa;
    private PagoDto pagoEntidadParqueadero;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPagoCasa() {
        return this.pagoCasa;
    }

    public void setPagoCasa(String pagoCasa) {
        this.pagoCasa = pagoCasa;
    }

    public String getPagoParqueadero() {
        return this.pagoParqueadero;
    }

    public void setPagoParqueadero(String pagoParqueadero) {
        this.pagoParqueadero = pagoParqueadero;
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

    public Date getGenerado() {
        return this.generado;
    }

    public void setGenerado(Date generado) {
        this.generado = generado;
    }

    public UsuarioDto getUsuarioEntidad() {
        return this.usuarioEntidad;
    }

    public void setUsuarioEntidad(UsuarioDto usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
    }

    public PagoDto getPagoEntidadCasa() {
        return this.pagoEntidadCasa;
    }

    public void setPagoEntidadCasa(PagoDto pagoEntidadCasa) {
        this.pagoEntidadCasa = pagoEntidadCasa;
    }

    public PagoDto getPagoEntidadParqueadero() {
        return this.pagoEntidadParqueadero;
    }

    public void setPagoEntidadParqueadero(PagoDto pagoEntidadParqueadero) {
        this.pagoEntidadParqueadero = pagoEntidadParqueadero;
    }
       
}
