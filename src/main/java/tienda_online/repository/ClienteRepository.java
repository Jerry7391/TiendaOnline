package tienda_online.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tienda_online.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar clientes por nombre o correo
}
