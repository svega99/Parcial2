 var airportFinderModule =( function (){
	
	
	
       var  getAirpotsbyName= function(){
            
            var name = $('#nameofcity').val();
            airpotsFinderClient.getAirpotsByName(name,mapeador);
        }
        
      
      
        var mapeador = function(airpots){
            $("#keywords tbody tr").remove();
            alert(JSON.stringify(airpots));
            airpots=JSON.stringify(airpots);
             airpots.map(function(airport){
                 var contenedor = "<tr><td class=\"lalign\">"+airport.code+"</td>  <td>"+ airport.name+"</td>  <td>"+ airport.city+"</td>  <td>"+ airport.countryCode+"</td>  </tr>";
 
                  $("#keywords tbody").append(contenedor);

             })
        }
	
	
	
	return {
		mapeador: mapeador,
                getAirpotsbyName: getAirpotsbyName
	};
})();