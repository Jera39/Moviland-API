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
            window.location.href = "index.html";
            console.log('Usuario autenticado:', data);
        }else{
            alert('¡error!');
            console.log('Usuario autenticado:', data);
        }
       
        
    })
    .catch(error => {
        // Manejar errores
        console.error('Error:', error);
        alert('Error al iniciar sesión');
    });
}