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
    getBook();
}
document.getElementById("Agregar").addEventListener("click",function () {
    guardarLibro();
})
async function getEditorial() {
    const url = `http://localhost:8080/api/editoriales`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al obtener el editorial", response.status);
        return;
      }
  
      const countries = await response.json();
      
      const select = document.getElementById("editorial");
  
      countries.forEach(editorial => {
        const option = document.createElement("option");
        option.value = editorial["id"];
        option.textContent = editorial['nombre'];
        select.appendChild(option);
      });
  
    } catch (error) {
      console.error("Error al obtener el editorial:", error);
    }
}
document.addEventListener("DOMContentLoaded",function () {
    getEditorial();
    getBook();
})
async function getBook() {
    const url = `http://localhost:8080/api/libros/`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al obtener los libros:", response.status);
        return;
      }
  
      const loan = await response.json();
      console.log(loan);

      const tbody = document.getElementById("libroList");
      tbody.innerHTML = ""; // Limpiar antes de insertar
  
      loan.forEach(book => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${book.id}</td>
            <td>${book.titulo}</td>
            <td>${book.isbn}</td>
            <td>${book.editorial.nombre}</td>
            <td>
            <button class="btn btn-sm btn-warning me-1" onclick="getModify(${book.id})">Modificar</button>
            <button class="btn btn-sm btn-danger" onclick="deleteBook(${book.id})">Eliminar</button>
            </td>

        `;

        tbody.appendChild(tr);
      });
    } catch (error) {
      console.error("Error al obtener los libros:", error);
    }
}

async function deleteBook(id) {
    const url = `http://localhost:8080/api/libros/${id}`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "DELETE",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al eliminar", response.status);
        return;
      }
      alert("Se elimino correctamente")
      getBook();
    } catch{
        console.log("Error al intentar borra");
    }
}
async function getModify(id) {
    const url = `http://localhost:8080/api/libros/${id}`;
  
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };
  
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: headersList
      });
  
      if (!response.ok) {
        console.error("Error al actualizar", response.status);
        return;
      }
      const book = await response.json();
        document.getElementById("titulo").value=book.titulo,
        document.getElementById("isbn").value=book.isbn,
        document.getElementById("fecha").valueAsDate = new Date(book.fechaPublicacion),
        document.getElementById("editorial").value=book.editorial.id
        document.getElementById("idmodificacion").value=book.id
      getBook();
      document.getElementById("Agregar").style="display:none;"
      document.getElementById("actualizar").style="display:block;"
    } catch (error){
        console.log("Error al intentar borra"+error);
    } 
}
async function updateBook() {
    const id=document.getElementById("idmodificacion")
    const url = `http://localhost:8080/api/libros/${id}`;
    let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
        "titulo": document.getElementById("titulo").value.trim(),
        "isbn": document.getElementById("isbn").value.trim(),
        "fechaPublicacion": document.getElementById("fecha").value,
        "editorial": document.getElementById("editorial").value
    });    
    try {
        const response = await fetch(url, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) {
            console.error("Error al actualizar:", response.status);
            return;
        }
        alert("Se actualizo correctamente")
        getBook();
    } catch (error) {
        console.error("Error inesperado:", error);
    }

}
document.getElementById("actualizar").addEventListener("click",function () {
    updateBook();
})
