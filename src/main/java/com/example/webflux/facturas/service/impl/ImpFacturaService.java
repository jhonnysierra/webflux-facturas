package com.example.webflux.facturas.service.impl;

import com.example.webflux.facturas.model.Factura;
import com.example.webflux.facturas.model.Producto;
import com.example.webflux.facturas.service.IFacturaService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ImpFacturaService implements IFacturaService {

    /**
     * Se crea un web client para realizar el llamado a otra API REST que se esta corriendo en el sistema
     */
    private final WebClient productos = WebClient.create("http://localhost:8091/productos");

    /**
     * Se crea un delay para que el flujo tarde 3 segundos en responder
     */
    Flux<Factura> facturas = Flux.just(
            new Factura(1, "PC Asus", 1000),
            new Factura(2, "TV 45'", 300),
            new Factura(3, "Silla", 100))
            .delaySequence(Duration.ofSeconds(3));

    @Override
    public Flux<Factura> listarFacturas() {
        facturas.subscribe(System.out::println);
        /*
        Flux<Producto> productosFlux = productos.get().retrieve().bodyToFlux(Producto.class);
        productosFlux.subscribe(System.out::println);
        */
        return facturas;
    }

    /**
     * single-> funciona siempre y cuando no hayan valores duplicados
     * next() -> Encuentr la primera ocurrencia del dato
     * @param id
     * @return
     */
    @Override
    public Mono<Factura> buscarFacturaId(int id) {
        Mono<Factura> factura = facturas
                .filter(element-> element.getId()==id)
                .next();
        return factura;
    }
}
