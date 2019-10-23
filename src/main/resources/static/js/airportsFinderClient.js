airpotsFinderClient= (function(){
    return {

        

        getAirpotsByName: function(name,callback){

            jQuery.ajax({
                url: "airpotsfinder/" + name ,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Nombre no encontrado");
                     
                } ,
                async: true
            });
        }
    };
})();
