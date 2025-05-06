document.getElementById("login-form")?.addEventListener("submit", async (e) => {
    e.preventDefault(); // Evita el envío predeterminado del formulario
    const correo = document.getElementById("correo").value;
    const contrasena = document.getElementById("contrasena").value;

    try {
        const response = await fetch(`http://localhost:8080/clientes/authenticate?correo=${correo}&contrasena=${contrasena}`, {
            method: "POST"
        });

        if (response.ok) {
            const cliente = await response.json();
            console.log("Tipo de usuario:", cliente.tipo); // Depuración
            if (cliente.tipo === "ADMIN") {
                window.location.href = "admin.html"; // Redirige a la interfaz de administrador
            } else if (cliente.tipo === "USER") {
                window.location.href = "user.html"; // Redirige a la interfaz de usuario común
            } else {
                alert("Tipo de usuario desconocido.");
            }
        } else {
            document.getElementById("login-error").style.display = "block";
        }
    } catch (error) {
        console.error("Error al iniciar sesión:", error);
        alert("Ocurrió un error al intentar iniciar sesión. Intenta nuevamente.");
    }
});