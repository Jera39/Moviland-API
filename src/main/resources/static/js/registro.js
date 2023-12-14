function realizarRegistro(event) {
    event.preventDefault();

    const nombre = document.getElementById('InputUserName').value;
    const correo = document.getElementById('exampleInputEmail1').value;
    const contraseña = document.getElementById('exampleInputPassword1').value;

    fetch('http://localhost:8085/api/v1/moviland/user/registro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nombre, correo, contraseña }),
    })
    .then(response => {
        if (!response.ok) {
            alert("API NO LECENTADA")
            throw new Error('Error al registrar usuario');
        }
        return response.json();
    })
    .then(data => {
        console.log('Usuario registrado:', data);
        alert('¡Registro exitoso!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al registrar usuario');
    });
}