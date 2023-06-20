$(document).ready(function() {

    //alert("Aquiiii con jquery");
    $('#listar').on('click', function() {
        let tabla = document.querySelector('#tabla')
        tabla.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarEstudiantes",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                tabla.innerHTML = '';
                for (i = 0; i < respuesta.length; i++) {
                    tabla.innerHTML += '<tr><td>' + respuesta[i].codigo +
                        '</td><td>' + respuesta[i].nombre +
                        '</td><td>' + respuesta[i].apellido+
                        '</td><td>' + respuesta[i].curso +
                        '</td><td>' + respuesta[i].nota1 +
                        '</td><td>' + respuesta[i].nota2 +
                        '</td><td>' + respuesta[i].nota3 +
                        '</td><td>' + respuesta[i].aprobado +
                        '</td><td>' + respuesta[i].promedio +
                        '</td></tr>';
                }
            }
        })

    $('#buscar').on('click', function() {
        let cod = $('#codigo').val();
        $.ajax({
            url: "http://localhost:8080/buscarEstudiantes/" + cod,
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                
                if (respuesta) {
                    alert("Bienvenido " +
                        respuesta.nombre);
                } else {
                    alert("No se encontro el usuario");
                }
            }
        });
    });

    $('#cargar').on('click', function() {
        let cod = parseInt($('#codigo').val());
        $.ajax({
            url: "http://localhost:8080/buscarEstudiantes/" + cod,
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                if (respuesta) {
                    $("#codigo").val(respuesta.codigo)
                    $("#nombre").val(respuesta.nombre)
                    $("#apellido").val(respuesta.apellido)
                    $("#curso").val(respuesta.curso)
                    $("#nota1").val(respuesta.nota1)
                    $("#nota2").val(respuesta.nota2)
                    $("#nota3").val(respuesta.nota3)
                    $("#aprobado").val(respuesta.aprobado)
                    $("#promedio").val(respuesta.promedio)

                } else {
                    alert("No se encontro el usuario");
                }
            }
        })
    });
    $('#actualizar').on('click', function() {
        let cod = parseInt($('#codigo').val());
        let data = {
            codigo: $("#codigo").val(),
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
            curso:  $("#curso").val(),
            nota1: $("#nota1").val(),
            nota2: $("#nota2").val(),
            nota3: $("#nota3").val(),
            aprobado: $("#aprobado").val(),
            promedio: $("#promedio").val(),
        };
        $.ajax({
            url: "http://localhost:8080/actualizarEstudiantes/" + cod,
            type: "PUT",
            datatype: "JSON",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(respuesta) {
                console.log(respuesta);
                alert("Se actualizo exitosamente");
            },
            error:function(){
                alert("Error en la solicitud")
            }
        })
    });
});
});
