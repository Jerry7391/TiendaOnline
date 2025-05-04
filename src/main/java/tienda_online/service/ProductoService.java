package tienda_online.service;

import org.springframework.stereotype.Service;
import tienda_online.model.Producto;
import tienda_online.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(String id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> updateProducto(String id, Producto producto) {
        if (!productoRepository.existsById(id)) {
            return Optional.empty();
        }
        producto.setId(id);
        return Optional.of(productoRepository.save(producto));
    }

    public Producto createProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public boolean deleteProducto(String id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }

}
