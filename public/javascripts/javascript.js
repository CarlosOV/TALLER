$(document).ready(function(){
    $('#table-view').dataTable({
        "language":{
            "lengthMenu": "Viendo  _MENU_  registros por página",
            "zeroRecords": "No existen registros disponibles",
            "info": "Viendo la página _PAGE_ de _PAGES_",
            "infoEmpty": "No se encontró coincidencia de registros",
            "infoFiltered": "(filtrado _MAX_ registros totales)",
            "search": "Buscar: "
        }
    });
    $('#user_type').change(function(){
        var index = $('#user_type').val();
        if(index == 1){
            $('#btnLogin').attr('formaction', "/tutor/tutorMenu");
        }else{
            $('#btnLogin').attr('formaction', "/administrator/adminMenu");
        }
    }); 

    $('·truco').click(function(){
        $('#pintado').addClass('success');
    });
});
