 var airportFinderModule =( function (){
	
        document.addEventListener('DOMContentLoaded', function () {
        if (document.querySelectorAll('#map').length > 0)
        {
          if (document.querySelector('html').lang)
            lang = document.querySelector('html').lang;
          else
            lang = 'en';

          var js_file = document.createElement('script');
          js_file.type = 'text/javascript';
          js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
          document.getElementsByTagName('head')[0].appendChild(js_file);
        }
      });
        
	var map;
        var bounds;
        var markers = [];
	
       var  getAirpotsbyName= function(){
            
            var name = $('#nameofcity').val();
            airpotsFinderClient.getAirpotsByName(name,mapeador);
        }
        
      
      
        var mapeador = function(airpots){
            $("#keywords tbody tr").remove();
              for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(null);
              }
 
            airpots=JSON.parse(airpots);
            markers = [];
            bounds = new google.maps.LatLngBounds();
 
             airpots.map(function(airport){
                 var contenedor = "<tr><td class=\"lalign\">"+airport.code+"</td>  <td>"+ airport.name+"</td>  <td>"+ airport.city+"</td>  <td>"+ airport.countryCode+"</td>  </tr>";
                 var loc = airport.location;
                  
                 markers.push(
                    new google.maps.Marker({
                        position: {lat: loc.latitude, lng: loc.longitude},
                      map: map,
                      animation: google.maps.Animation.DROP
                    })
                  );
 
                   bounds.extend({lat: loc.latitude, lng: loc.longitude});
 
 
                  $("#keywords tbody").append(contenedor);

             })
 
             map.fitBounds(bounds);
        }
	
        function initMap()
        {
          map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: -4.0},
            zoom: 8
          });

          fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
            .then(function(response){return response.json()})
            .then(plotMarkers);
        }
	
	
	return {
		mapeador: mapeador,
                getAirpotsbyName: getAirpotsbyName,
                initMap: initMap
	};
})();