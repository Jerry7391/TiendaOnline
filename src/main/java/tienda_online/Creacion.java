package tienda_online;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Creacion {
    public static void main(String[] args) {
        try {
            // URL del endpoint
            URL url = new URL("http://localhost:8080/productos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configuración de la solicitud
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Cuerpo de la solicitud (JSON)
            String jsonInputString = """
                {
                    "nombre": "Acer Laptop Gaming Nitro 5 Modelo 2024",
                    "descripcion": "Domina el juego: con el procesador Intel Core i5-12450H de 12ª generación, tu Nitro 5 está repleto de una potencia increíble para todos tus juegos.",
                    "precio": 13499,
                    "cantidad": 20,
                    "imagen": "static/imagen/Acer Gaming.jpg"
                }
            """;

            // Enviar la solicitud
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Verificar la respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Producto creado exitosamente.");
            } else {
                System.out.println("Error al crear el producto. Código de respuesta: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
