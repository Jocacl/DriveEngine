(function(){
    //alert("hOLA MUNDO");
        var listaBotnoesEditar= document.querySelectorAll(".editarProovedor")
        listaBotnoesEditar.forEach(item =>{
            item.addEventListener("click",e=>{
    
                document.getElementById('id').value=item.dataset.id;
                document.getElementById('txtnombre').value=item.dataset.nombre;
                document.getElementById('txtdireccion').value=item.dataset.direccion;
                document.getElementById('txttelefono').value=item.dataset.telefono;
                document.getElementById('txtemail').value=item.dataset.email;
                
                new bootstrap.Modal(document.getElementById('modalEditar')).show();
                e.preventDefault();
            },false)
        })
    })();