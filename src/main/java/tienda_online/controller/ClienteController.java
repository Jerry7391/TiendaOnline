package tienda_online.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda_online.model.Cliente;
import tienda_online.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@Valid @PathVariable String id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(201).body(savedCliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@Valid @PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@Valid @PathVariable String id) {
        if (!clienteService.deleteCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Cliente> authenticate(@RequestParam String correo, @RequestParam String contrasena) {
        Optional<Cliente> cliente = clienteService.authenticate(correo, contrasena);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
    }
    @PostMapping("/register")
    public ResponseEntity<Cliente> register(@Valid @RequestBody Cliente cliente) {
        System.out.println("Cuerpo recibido: " + cliente);

        // Forzar el tipo a "USER" para todos los registros
        cliente.setTipo("USER");

        if (clienteService.getAllClientes().stream().anyMatch(c -> c.getCorreo().equals(cliente.getCorreo()))) {
            return ResponseEntity.status(409).build();
        }
        Cliente savedCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(201).body(savedCliente);
    }
}
