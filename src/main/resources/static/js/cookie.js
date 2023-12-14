// Verificar si la cookie "nombreUsuario" existe
const nombreUsuarioCookie = obtenerCookie("nombreUsuario");

// Obtener el elemento enlaceLogin
const enlaceLogin = document.getElementById("enlaceLogin");

// Si la cookie existe, establecer su valor como texto del enlace
if (nombreUsuarioCookie) {
    enlaceLogin.innerText = `Hola, ${nombreUsuarioCookie}!`;
}

// Función para obtener el valor de una cookie por nombre
function obtenerCookie(nombre) {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i].trim();
        if (cookie.startsWith(nombre + '=')) {
            return cookie.substring(nombre.length + 1);
        }
    }
    return null;
}
