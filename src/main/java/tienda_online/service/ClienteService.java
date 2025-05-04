package tienda_online.service;

import org.springframework.stereotype.Service;
import tienda_online.model.Cliente;
import tienda_online.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    public Optional<Cliente> getClienteById(String id) {
        return clienteRepository.findById(id);
    }
    public Optional<Cliente> updateCliente(String id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return Optional.empty();
        }
        cliente.setId(id);
        return Optional.of(clienteRepository.save(cliente));
    }
    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public boolean deleteCliente(String id) {
        if (!clienteRepository.existsById(id)) {
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
    public Optional<Cliente> authenticate(String correo, String contrasena) {
        return clienteRepository.findAll().stream()
                .filter(cliente -> cliente.getCorreo().equals(correo) && cliente.getContrasena().equals(contrasena))
                .findFirst();
    }

}
