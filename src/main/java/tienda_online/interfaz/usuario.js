// Filtro de productos
document.getElementById("search-bar").addEventListener("input", (e) => {
    const searchValue = e.target.value.toLowerCase();
    const products = document.querySelectorAll(".product-card");
    products.forEach((product) => {
        const productName = product.querySelector("h3").textContent.toLowerCase();
        product.style.display = productName.includes(searchValue) ? "block" : "none";
    });
});

// Carrito de compras
let cart = [];
document.querySelectorAll(".btn-success").forEach((button) => {
    button.addEventListener("click", (e) => {
        const productCard = e.target.closest(".product-card");
        const productName = productCard.querySelector("h3").textContent;
        const productPrice = productCard.querySelector("p").textContent;
        cart.push({ name: productName, price: productPrice });
        alert(`${productName} añadido al carrito.`);
    });
});
document.addEventListener("DOMContentLoaded", async () => {
    const productList = document.getElementById("product-list");

    try {
        const response = await fetch("http://localhost:8080/productos");
        const productos = await response.json();

        productos.forEach((producto) => {
            const productCard = document.createElement("div");
            productCard.classList.add("product-card");
            productCard.innerHTML = `
                <img src="${producto.imagen}" alt="${producto.nombre}">
                <h3>${producto.nombre}</h3>
                <p>${producto.descripcion}</p>
                <p>Precio: $${producto.precio}</p>
                <button class="btn-success">Añadir al carrito</button>
            `;
            productList.appendChild(productCard);
        });
    } catch (error) {
        console.error("Error al cargar productos:", error);
    }
});