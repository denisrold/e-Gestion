
$(document).ready(function() {
   cargarUsuario();
  $('#usuarios').DataTable();
});

 async function cargarUsuario(){
 const request = await fetch('http://localhost:8080/usuarios',{
 METHOD: 'GET',
 headers:{
 'Accept':'application/JSON',
 'Content-Type':'application/json'
 },

 })

 const usuarios = request.json();
 let usuario = '<tr><td>123456</td><td>Denis Roldan1</td><td>321321321</td><td>denis@denis.com</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'

 document.querySelector('#usuarios tbody').outerHTML = usuario;
}