package tienda_online.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document(collection = "ventas")
@Data
public class Venta {
    @Id
    private String id;
    @NotBlank(message = "La fecha no puede estar vacía")
    private Date fecha;
    private String idCliente;
    private Map<Producto, Integer> productos; // Producto y cantidad
    @NotBlank(message = "El total no puede estar vacío")
    private double total;

    public Venta(String id, Date fecha, String idCliente, Map<Producto, Integer> productos, double total) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.productos = productos;
        this.total = total;
    }

    public Venta() {
    }
}
