package com.unab.CRLosPinos.Services;

import java.util.List;

import com.unab.CRLosPinos.Shared.FacturaDto;

public interface IFacturaService {
    
    FacturaDto crearFactura(FacturaDto facturaCrearDto);
    
    List<FacturaDto> facturasGeneradas();

    FacturaDto detalleFactura(String id);

    FacturaDto actualizarFactura(String idFactura, FacturaDto partidoActualizarDto);

    void eliminarFactura(String idFactura, long idUsuario);
}

