(function(){
//alert("hOLA MUNDO");
    var listaBotnoesEditar= document.querySelectorAll(".editarAlumno")
    listaBotnoesEditar.forEach(item =>{
        item.addEventListener("click",e=>{

            document.getElementById('id').value=item.dataset.id;
            document.getElementById('cboCarrera').value=item.dataset.carrera;
            document.getElementById('txtCodigo').value=item.dataset.codigo;
            document.getElementById('txtNombres').value=item.dataset.nombres;
            document.getElementById('txtApellidos').value=item.dataset.apellidos;
            document.getElementById('txtCorreo').value=item.dataset.correo;
            
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
            e.preventDefault();
        },false)
    })
})();