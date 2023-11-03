
$(document).ready(function() {
   cargarUsuario();
  $('#usuarios').DataTable();
  updateUserEmail();
});
function updateUserEmail(){
document.getElementById('txtEmailUsuario').outerHTML = localStorage.email;
}

const token = localStorage.token
 async function cargarUsuario(){
 const request = await fetch('http://localhost:8080/api/allusuarios',{
 METHOD: 'GET',
 headers:{
 'Accept':'application/JSON',
 'Content-Type':'application/json',
   'Authorization':token,
 },
 })
const usuarios = await request.json();
let listadoHTML='';

//Mapeo lista de usuarios con js
 for(let usuario of usuarios){
 let deleteButton = '<a href="#" onclick="deleteUser('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

 let usuarioHTML = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre +' '+ usuario.apellido+'</td><td>'+usuario.telefono+'</td><td>'+usuario.email+'</td><td>'+deleteButton+'</td></tr>'
 listadoHTML += usuarioHTML;
 }

 document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
}

async function getHeader(){
return {
         'Content-Type':'application/json',
          'Authorization':token,
        }
}

async function deleteUser(id){
if(!confirm("¿Desea eliminar el usuario?")){
return
}



const deleteMethod = {
 method: 'DELETE',
 headers: getHeader(),
}
const request = await fetch('http://localhost:8080/api/usuarios/'+id, deleteMethod)

location.reload();
}