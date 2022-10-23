package com.unab.CRLosPinos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.CRLosPinos.Services.IUsuarioService;
import com.unab.CRLosPinos.Shared.FacturaDto;
import com.unab.CRLosPinos.Shared.UsuarioDto;
import com.unab.CRLosPinos.models.peticiones.UsuarioCrearRequestModel;
import com.unab.CRLosPinos.models.respuestas.FacturaDataRestModel;
import com.unab.CRLosPinos.models.respuestas.UsuarioDataRestModel;

@RestController
@RequestMapping("/usuario")

public class UsuarioControl {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioService iUsuarioService; 

    @GetMapping
    public UsuarioDataRestModel leerUsuario() {
        String username = "gato"; //intyW

        UsuarioDto usuarioDto = iUsuarioService.leeUsuario(username);
        
        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);
        
        return usuarioDataRestModel;
    }

    @PostMapping
    public UsuarioDataRestModel crearUsuario(@RequestBody UsuarioCrearRequestModel usuarioCrearRequestModel) {

        UsuarioDto usuarioCrearDto = modelMapper.map(usuarioCrearRequestModel, UsuarioDto.class);

        UsuarioDto usuarioDto = iUsuarioService.crearUsuario(usuarioCrearDto);

        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

        return usuarioDataRestModel;
    }
    
    @GetMapping(path = "/misfacturas")
    public List<FacturaDataRestModel> leerFacturas() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<FacturaDto> facturaDtolList = iUsuarioService.leerFacturas(username);

        List<FacturaDataRestModel> facturaDataRestModelist = new ArrayList<>();

        for (FacturaDto facturaDto : facturaDtolList) {
            FacturaDataRestModel facturaDataRestModel = modelMapper.map(facturaDto, FacturaDataRestModel.class);
            if (facturaDataRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0) {
                facturaDataRestModel.setPagada(true);
            }
            facturaDataRestModelist.add(facturaDataRestModel);
        }

        return facturaDataRestModelist;
    }

}
