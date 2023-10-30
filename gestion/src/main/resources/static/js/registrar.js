
$(document).ready(function() {
});

 async function registrarUsuario(){
 let datos = {}
 datos.nombre = document.getElementById('txtNombre').value;
 datos.apellido = document.getElementById('txtApellido').value;
 datos.telefono = document.getElementById('txtTelefono').value;
 datos.email = document.getElementById('txtEmail').value;

 let password = document.getElementById('txtPassword').value;
 let repetirPassword = document.getElementById('txtrepeatPassword').value;
  if(password != repetirPassword){
  alert('Contraseñas diferentes')
  return}
  datos.password = password;

const request = await fetch('http://localhost:8080/api/regusuarios', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(datos)
});


}
