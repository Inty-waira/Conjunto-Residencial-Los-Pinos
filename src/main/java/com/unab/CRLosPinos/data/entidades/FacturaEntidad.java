package com.unab.CRLosPinos.data.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "factura")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
    @Index(columnList = "idFactura",name = "index_idFactura", unique = true)
})
public class FacturaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idFactura;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String pagadoCasa;

    @Column
    private String pagadoParqueadero;

    @CreatedDate
    private Date generado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntidad usuarioEntidad;

    @ManyToOne
    @JoinColumn(name = "id_pagoCasa")
    private PagoEntidad pagoEntidadCasa;

    @ManyToOne
    @JoinColumn(name = "id_pagoParqueadero")
    private PagoEntidad pagoEntidadParqueadero;



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

    public UsuarioEntidad getUsuarioEntidad() {
        return this.usuarioEntidad;
    }

    public void setUsuarioEntidad(UsuarioEntidad usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
    }

    public PagoEntidad getPagoEntidadCasa() {
        return this.pagoEntidadCasa;
    }

    public void setPagoEntidadCasa(PagoEntidad pagoEntidadCasa) {
        this.pagoEntidadCasa = pagoEntidadCasa;
    }

    public PagoEntidad getPagoEntidadParqueadero() {
        return this.pagoEntidadParqueadero;
    }

    public void setPagoEntidadParqueadero(PagoEntidad pagoEntidadParqueadero) {
        this.pagoEntidadParqueadero = pagoEntidadParqueadero;
    }

}
