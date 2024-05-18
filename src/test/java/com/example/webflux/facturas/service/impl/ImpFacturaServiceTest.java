package com.example.webflux.facturas.service.impl;

import com.example.webflux.facturas.model.Factura;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImpFacturaServiceTest {

    private ImpFacturaService impFacturaService;
    Flux<Factura> facturas;
    @BeforeEach
    void setUp() {
        impFacturaService = new ImpFacturaService();
        facturas = Flux.just(
                new Factura(1, "PC Asus", 1000),
                new Factura(2, "TV 45'", 300),
                new Factura(3, "Silla", 100))
                .delaySequence(Duration.ofSeconds(3));
    }

    @Test
    void listarFacturas() {
        Flux<Factura> facturaFlux = impFacturaService.listarFacturas();
        assertEquals(facturaFlux.collectList().block(), facturas.collectList().block());
        assertEquals(facturaFlux.getClass(), facturas.getClass());
    }

    @Test
    void buscarFacturaId() {
    }
}