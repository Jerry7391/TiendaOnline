package tienda_online.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "productos")
@Data
public class Producto {
    @Id
    private String id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @NotNull(message = "El precio no puede estar vacío")
    private double precio;
    private String imagen;
    @NotNull(message = "La cantidad no puede estar vacía")
    private int cantidad;


    public Producto(String id, String nombre, String descripcion, double precio, int cantidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }
    public Producto() {
    }
}
