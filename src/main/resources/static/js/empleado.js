(function(){
    //alert("hOLA MUNDO");
        var listaBotnoesEditar= document.querySelectorAll(".editarEmpleado")
        listaBotnoesEditar.forEach(item =>{
            item.addEventListener("click",e=>{
    
                document.getElementById('id').value=item.dataset.id;
                document.getElementById('txtdni').value=item.dataset.dni;
                document.getElementById('txtNombre').value=item.dataset.nombre;
                document.getElementById('txtApellidos').value=item.dataset.apellidos;
                document.getElementById('txtcelular').value=item.dataset.celular;
                document.getElementById('txtcargo').value=item.dataset.cargo;
                document.getElementById('txtfecha').value=item.dataset.fecha;
                
                new bootstrap.Modal(document.getElementById('modalEditar')).show();
                e.preventDefault();
            },false)
        })
    })();