package com.unab.CRLosPinos.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.CRLosPinos.Services.IFacturaService;
import com.unab.CRLosPinos.Services.IUsuarioService;
import com.unab.CRLosPinos.Shared.FacturaDto;
import com.unab.CRLosPinos.Shared.UsuarioDto;
import com.unab.CRLosPinos.models.peticiones.FacturaActualizarRequestModel;
import com.unab.CRLosPinos.models.peticiones.FacturaCrearRequestModel;
import com.unab.CRLosPinos.models.respuestas.FacturaDataRestModel;
import com.unab.CRLosPinos.models.respuestas.MensajeRestModel;

@RestController
@RequestMapping("/factura")
public class FacturaControl {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IFacturaService iFacturaService;

    @Autowired
    IUsuarioService iUsuarioService;

    @PostMapping
    public FacturaDataRestModel crearFactura(@RequestBody FacturaCrearRequestModel facturaCrearRequestModel) {

        // Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username = "gato"; //authentication.getPrincipal().toString();

        FacturaDto facturaCrearDto = modelMapper.map(facturaCrearRequestModel, FacturaDto.class);
        facturaCrearDto.setUsername(username);

        FacturaDto facturaDto = iFacturaService.crearFactura(facturaCrearDto);

        FacturaDataRestModel facturaDataRestModel = modelMapper.map(facturaDto, FacturaDataRestModel.class);

        return facturaDataRestModel;
    }

    @GetMapping(path = "/{id}")
    public FacturaDataRestModel detalleFactura(@PathVariable String id) {

        FacturaDto facturaDto = iFacturaService.detalleFactura(id);

        FacturaDataRestModel facturaDataRestModel = modelMapper.map(facturaDto, FacturaDataRestModel.class);

        return facturaDataRestModel;
    }

    @PutMapping(path = "/{id}")
    public FacturaDataRestModel actualizarFactura(@PathVariable String id,
                                                  @RequestBody FacturaActualizarRequestModel partidoActualizarRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        FacturaDto facturaActualizarDto = modelMapper.map(partidoActualizarRequestModel, FacturaDto.class);
        facturaActualizarDto.setUsername(username);

        FacturaDto facturaDto = iFacturaService.actualizarFactura(id, facturaActualizarDto);

        FacturaDataRestModel facturaDataRestModel = modelMapper.map(facturaDto, FacturaDataRestModel.class);

        return facturaDataRestModel;
    }

    @DeleteMapping(path = "/{id}")
    public MensajeRestModel eliminarFactura(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioService.leeUsuario(username);

        MensajeRestModel mensajeRestModel = new MensajeRestModel();
        mensajeRestModel.setNombre("Eliminar factura");

        iFacturaService.eliminarFactura(id, usuarioDto.getId());

        mensajeRestModel.setResultado("La factura fue Elimina");

        return mensajeRestModel;
    }
    
}
