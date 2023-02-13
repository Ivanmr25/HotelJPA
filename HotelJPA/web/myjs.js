$(document).ready(function() {
    console.log('ready');
    init();
});

function init(){

   onshowresumen();
}


function onshowresumen(){
	$('#modalreservas').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) 
          var partido = button.data('id')
          
	  var modal = $(this)
	
          // Ajax
          $.ajax({
            type: "GET",
            url: "Controller?op=resumen&nhabitacion="+partido,
            success : function(info) {
                    $("#reservas").html(info);
                }
            });
          })
}
