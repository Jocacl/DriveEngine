(function(){
    //alert("hOLA MUNDO");
        var listaBotnoesEditar= document.querySelectorAll(".editarAuto")
        listaBotnoesEditar.forEach(item =>{
            item.addEventListener("click",e=>{
    
                document.getElementById('id').value=item.dataset.id;
                document.getElementById('cboCliente').value=item.dataset.cliente;
                document.getElementById('txtmarca').value=item.dataset.marca;
                document.getElementById('txtmodelo').value=item.dataset.modelo;
                document.getElementById('txtanio').value=item.dataset.anio;
                document.getElementById('txtplaca').value=item.dataset.placa;
                
                new bootstrap.Modal(document.getElementById('modalEditar')).show();
                e.preventDefault();
            },false)
        })
    })();