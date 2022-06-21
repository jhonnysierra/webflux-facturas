package com.example.webflux.facturas.controller;

import com.example.webflux.facturas.model.Factura;
import com.example.webflux.facturas.service.IFacturaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final IFacturaService iFacturaService;

    public FacturaController(IFacturaService iFacturaService) {
        this.iFacturaService = iFacturaService;
    }

    @GetMapping("/listar")
    public Flux<Factura> listarFacturas(){
        return iFacturaService.listarFacturas();
    }

    @GetMapping("/listar/{id}")
    public Mono<Factura> buscarFacturaId(@PathVariable int id) {
        System.out.println("identificador: "+id);
        return iFacturaService.buscarFacturaId(id);
    }
}
