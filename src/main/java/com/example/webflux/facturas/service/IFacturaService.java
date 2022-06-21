package com.example.webflux.facturas.service;

import com.example.webflux.facturas.model.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFacturaService {

    Flux<Factura> listarFacturas();

    Mono<Factura> buscarFacturaId(int id);
}
