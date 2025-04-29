async function guardarLibro() {
    const libro = {
        titulo: document.getElementById("titulo").value.trim(),
        isbn: document.getElementById("isbn").value.trim(),
        fechaPublicacion: document.getElementById("fecha").value,
        editorial: { id: parseInt(document.getElementById("editorial").value) }
    };

    console.log("📤 Enviando JSON:", JSON.stringify(libro, null, 2));

    const response = await fetch("http://localhost:8080/api/libros", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(libro)
    });

    const responseData = await response.text();
    console.log("✅ Respuesta del backend:", responseData);
}
