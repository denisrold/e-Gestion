
$(document).ready(function() {
});

 async function iniciarSesion(){
 let datos = {};
 datos.email = document.getElementById('txtEmail').value;
 datos.password = document.getElementById('txtPassword').value;

const request = await fetch('http://localhost:8080/api/regusuarios', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(datos)
});

}