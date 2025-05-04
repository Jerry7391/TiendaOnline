document.getElementById("register-form")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    const nombre = document.getElementById("nombre").value;
    const correo = document.getElementById("correo-registro").value;
    const contrasena = document.getElementById("contrasena-registro").value;

    try {
        const response = await fetch('http://localhost:8080/clientes/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nombre, correo, contrasena, tipo: "USER" })
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error del servidor: ${response.status} - ${errorText}`);
        }

        document.getElementById("register-success").style.display = "block";
        document.getElementById("register-error").style.display = "none";
    } catch (error) {
        console.error("Error al registrarse:", error);

        // Mostrar mensaje de error en pantalla
        const errorDiv = document.getElementById("register-error");
        errorDiv.textContent = `No se pudo completar el registro: ${error.message}`;
        errorDiv.style.display = "block";

        // Arrojar el error (opcional si deseas que escale)
        throw error;
    }
});
