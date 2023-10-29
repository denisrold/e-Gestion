
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
let listadoHTML='';
 const usuarios = await request.json();
 console.log(usuarios);
 for(let usuario of usuarios){
 let usuarioHTML = '<tr><td>123456</td><td>'+usuario.nombre +' '+ usuario.apellido+'</td><td>'+usuario.telefono+'</td><td>'+usuario.email+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'
 listadoHTML += usuarioHTML;
 }

 document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}