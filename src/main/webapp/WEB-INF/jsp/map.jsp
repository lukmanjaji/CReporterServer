<%
    String lat = request.getParameter("lat");
    String lon = request.getParameter("lon");
%>
<!-- Replace the value of the key parameter with your own API key. -->
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC9HSProR_c3ETwPjN0LQpr3UScor8NCE&callback=initMap">
</script>

<!DOCTYPE html>

    <style>
      
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  
    <div id="map" ></div>
    <script>

      function initMap() {
        var myLatLng = {lat: <%=lat%>, lng: <%=lon%>};

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: myLatLng
        });

        var marker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          title: 'Hello World!'
        });
      }
    </script>

</html>