(function(){
    //alert("hOLA MUNDO");
        var listaBotnoesEditar= document.querySelectorAll(".editarCliente")
        listaBotnoesEditar.forEach(item =>{
            item.addEventListener("click",e=>{
    
                document.getElementById('id').value=item.dataset.id;
                document.getElementById('txtdni').value=item.dataset.dni;
                document.getElementById('txtNombres').value=item.dataset.nombres;
                document.getElementById('txtApellidos').value=item.dataset.apellidos;
                document.getElementById('txtcelular').value=item.dataset.celular;
                document.getElementById('txtdireccion').value=item.dataset.direccion;
                
                new bootstrap.Modal(document.getElementById('modalEditar')).show();
                e.preventDefault();
            },false)
        })
    })();