
$(document).ready(function() {
});

 async function registrarUsuario(){
 let datos = {}
 datos.nombre = document.getElementById('txtNombre').value;
 datos.apellido = document.getElementById('txtApellido').value;
 datos.telefono = document.getElementById('txtTelefono').value;
 datos.email = document.getElementById('txtEmail').value;
 datos.password = document.getElementById('txtPassword').value;

 const request = await fetch('http://localhost:8080/api/allusuarios',{
 METHOD: 'POST',
 headers:{
 'Accept':'application/JSON',
 'Content-Type':'application/json'
 },
 body:JSON.stringify(datos)
 })
const usuarios = await request.json();

}
