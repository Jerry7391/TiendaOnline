package tienda_online.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Data
public class Cliente {
    @Id
    private String id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contrasena;
    private String tipo;

    public Cliente(String id, String nombre, String correo, String contrasena, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    public Cliente() {
    }

}
