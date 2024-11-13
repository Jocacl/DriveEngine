setTimeout(()=>{
    const alert= document.getElementById("alertMensaje");
    if (alert) {
        alert.classList.remove("show");
        setTimeout(()=>alert.remove(),150);
    }

    const alertEliminar= document.getElementById("alertEliminar");
    if (alertEliminar) {
        alertEliminar.classList.remove("show");
        setTimeout(()=>alertEliminar.remove(),150);
    }
},3000);

