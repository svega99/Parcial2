 var airportFinderModule =( function (){
	
	
	
       var  getAirpotsbyName= function(){
            
            var name = $('#nameofcity').val();
            airpotsFinderClient.getAirpotsByName(name,mapeador);
        }
        
      
      
        var mapeador = function(airpots){
            $("#keywords tbody tr").remove();
  
            
             airpots.map(function(airport){
                 var contenedor = "<tr><td class=\"lalign\">"+airport.codigo+"</td>  <td>"+ airport.nombre+"</td>  <td>"+ airport.ciudad+"</td>  <td>"+ airport.codigoPais+"</td>  </tr>";
 
                  $("#keywords tbody").append(contenedor);

             })
        }
	
	
	
	return {
		mapeador: mapeador,
                getAirpotsbyName: getAirpotsbyName
	};
})();