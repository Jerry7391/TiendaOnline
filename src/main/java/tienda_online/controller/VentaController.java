package tienda_online.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda_online.model.Venta;
import tienda_online.service.VentaService;

import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaRepository){
        this.ventaService = ventaRepository;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@Valid @PathVariable String id){
        Optional<Venta> venta = ventaService.getVentaById(id);
        return venta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@Valid @RequestBody Venta venta){
        Venta savedVenta = ventaService.createVenta(venta);
        return ResponseEntity.status(201).body(savedVenta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@Valid @PathVariable String id, @RequestBody Venta venta){
        return ventaService.updateVenta(id, venta)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@Valid @PathVariable String id){
        if(!ventaService.deleteVenta(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
