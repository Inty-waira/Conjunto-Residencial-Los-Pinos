package com.unab.CRLosPinos.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.CRLosPinos.Shared.FacturaDto;
import com.unab.CRLosPinos.data.entidades.FacturaEntidad;
import com.unab.CRLosPinos.data.entidades.PagoEntidad;
import com.unab.CRLosPinos.data.entidades.UsuarioEntidad;
import com.unab.CRLosPinos.data.repositorios.IFacturaRepositorio;
import com.unab.CRLosPinos.data.repositorios.IPagoRepositorio;
import com.unab.CRLosPinos.data.repositorios.IUsuarioRepositorio;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    @Autowired
    IFacturaRepositorio iFacturaRepositorio;

    @Autowired
    IPagoRepositorio iPagoRepositorio;

    @Override
    public FacturaDto crearFactura(FacturaDto facturaCrearDto) {

        UsuarioEntidad usuarioEntidad = iUsuarioRepositorio.findByUsername(facturaCrearDto.getUsername());

        PagoEntidad pagoEntidadCasa = iPagoRepositorio.findById(facturaCrearDto.getPagoCasa());

        PagoEntidad pagoEntidadParqueadero = iPagoRepositorio.findById(facturaCrearDto.getPagoParqueadero());

        FacturaEntidad facturaEntidad = new FacturaEntidad();
        facturaEntidad.setIdFactura(UUID.randomUUID().toString());
        facturaEntidad.setFecha(facturaCrearDto.getFecha());
        facturaEntidad.setPagadoCasa("0");
        facturaEntidad.setPagadoParqueadero("0");
        facturaEntidad.setUsuarioEntidad(usuarioEntidad);
        facturaEntidad.setPagoEntidadCasa(pagoEntidadCasa);
        facturaEntidad.setPagoEntidadParqueadero(pagoEntidadParqueadero);

        FacturaEntidad facturaEntidadGenerado = iFacturaRepositorio.save(facturaEntidad);

        FacturaDto facturaDto = modelMapper.map(facturaEntidadGenerado, FacturaDto.class);

        return facturaDto;
    }
    

    @Override
    public List<FacturaDto> facturasGeneradas() {

        List<FacturaEntidad> facturaEntidadList = iFacturaRepositorio.facturasGeneradas();

        List<FacturaDto>facturaDtoList = new ArrayList<>();

        for (FacturaEntidad facturaEntidad : facturaEntidadList) {
            FacturaDto facturaDto = modelMapper.map(facturaEntidad, FacturaDto.class);
        facturaDtoList.add(facturaDto);
        }

        return facturaDtoList;
    }

    @Override
    public FacturaDto detalleFactura(String id) {

        FacturaEntidad facturaEntidad = iFacturaRepositorio.findByIdFactura(id);

        FacturaDto facturaDto = modelMapper.map(facturaEntidad, FacturaDto.class);

        return facturaDto;
    }

    @Override
    public FacturaDto actualizarFactura(String idFactura, FacturaDto facturaActualizarDto) {

        FacturaEntidad facturaEntidad = iFacturaRepositorio.findByIdFactura(idFactura);

        UsuarioEntidad usuarioEntidad = iUsuarioRepositorio.findByUsername(facturaActualizarDto.getUsername());

        if (facturaEntidad.getUsuarioEntidad().getId() != usuarioEntidad.getId()) {
            throw new RuntimeException("No se puede realizar esta accion");
        }

        facturaEntidad.setPagadoCasa(facturaActualizarDto.getPagadoCasa());
        facturaEntidad.setPagadoParqueadero(facturaActualizarDto.getPagadoParqueadero());

        FacturaEntidad facturaEntidadActualizada = iFacturaRepositorio.save(facturaEntidad);

        FacturaDto facturaDto = modelMapper.map(facturaEntidadActualizada, FacturaDto.class);

        return facturaDto;
    }

    @Override
    public void eliminarFactura(String idFactura, long idUsuario) {

        FacturaEntidad facturaEntidad = iFacturaRepositorio.findByIdFactura(idFactura);

        if (facturaEntidad.getUsuarioEntidad().getId() != idUsuario) {
            throw new RuntimeException("No se puede realizar esta accion");
        }

        iFacturaRepositorio.delete(facturaEntidad);

    }

}
 