function realizarLogin(event) {
    event.preventDefault();

    // Obtener los valores del formulario
    const correo = document.getElementById('exampleInputEmail1').value;
    const contraseña = document.getElementById('exampleInputPassword1').value;

    // Hacer la solicitud POST a la API
    fetch('http://localhost:8085/api/v1/moviland/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ correo, contraseña }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al iniciar sesión');
            alert("error")

        }
        return response.json();
    })
    .then(data => {
        if(data){
            return fetch(`http://localhost:8085/api/v1/moviland/user/${correo}`);
        }else{
            alert('¡error!');
            console.log('Usuario autenticado:', data);
        }
       
        
    })
    .then(response => response.json())
    .then(usuario => {
        localStorage.setItem('nombreUsuario', usuario.nombre);
        localStorage.setItem('correoUsuario', usuario.correo);
        console.log(usuario.nombre)
        console.log(usuario,correo)
        const expireDate = new Date();
        expireDate.setTime(expireDate.getTime() + (24 * 60 * 60 * 1000));

        document.cookie = `nombreUsuario=${usuario.nombre}; expires=${expireDate.toUTCString()}; path=/`;
        console.log('Usuario autenticado:', usuario);
        window.location.href = "index.html";

        
    })
    .catch(error => {
        // Manejar errores
        console.error('Error:', error);
        alert('Error al iniciar sesión');
    });
}