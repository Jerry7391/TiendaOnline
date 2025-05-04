package tienda_online.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tienda_online.model.Venta;

public interface VentaRepository extends MongoRepository<Venta, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar ventas por cliente o fecha
}
