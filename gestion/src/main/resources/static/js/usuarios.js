
$(document).ready(function() {
   cargarUsuario();
  $('#usuarios').DataTable();
});

 async function cargarUsuario(){
 const request = await fetch('http://localhost:8080/usuarios3',{
 METHOD: 'GET',
 headers:{
 'Accept':'application/JSON',
 'Content-Type':'application/json'
 },

 })

 const usuarios = request.json();
 console.log(usuarios);
}