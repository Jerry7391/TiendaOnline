package tienda_online.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tienda_online.model.Producto;


public interface ProductoRepository extends MongoRepository<Producto, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar productos por nombre o precio
}
