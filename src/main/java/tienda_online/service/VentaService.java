package tienda_online.service;

import org.springframework.stereotype.Service;
import tienda_online.model.Venta;
import tienda_online.repository.ProductoRepository;
import tienda_online.repository.VentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository =ventaRepository;
    }

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(String id) {
        return ventaRepository.findById(id);
    }
    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
    public Optional<Venta> updateVenta(String id, Venta venta) {
        if (!ventaRepository.existsById(id)) {
            return Optional.empty();
        }
        venta.setId(id);
        return Optional.of(ventaRepository.save(venta));
    }
    public boolean deleteVenta(String id) {
        if (!ventaRepository.existsById(id)) {
            return false;
        }
        ventaRepository.deleteById(id);
        return true;
    }
}
