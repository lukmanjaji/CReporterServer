<%@page import="org.apache.http.HttpResponse" %>
<%@page import="org.apache.http.util.EntityUtils" %>
<%@page import="org.apache.http.client.HttpClient" %>
<%@page import="org.apache.http.impl.client.HttpClients" %>
<%@page import="org.apache.http.client.methods.HttpGet" %>
<%@page import="java.util.List" %>
<%@page import="com.labafrique.creporter.model.ReportModel" %>
<%@page import="com.google.gson.Gson" %>
<%@page import="java.lang.reflect.Type" %>
<%@page import="com.google.gson.reflect.TypeToken" %>




<%
    String rest = "http://localhost:9494/creporter/listener";
    List<ReportModel> posts = null;
    try
    {
        HttpGet post = new HttpGet(rest+"/getCases?t=");
        HttpClient client = HttpClients.createDefault();
        HttpResponse r = client.execute(post);
        String res = EntityUtils.toString(r.getEntity()).trim();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ReportModel>>(){}.getType();
        posts = gson.fromJson(res, listType);
    }
    catch(Exception ee)
    {
        ee.printStackTrace();
    }
%>
<!-- Replace the value of the key parameter with your own API key. -->
 <script src="/js/ws.js"></script>
<script src="/js/alertify.js"></script>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyCC9HSProR_c3ETwPjN0LQpr3UScor8NCE&callback" 
          type="text/javascript"></script>
          <link rel="stylesheet" href="css/alertify.css"/>

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
 <script type="text/javascript">
     
     window.onload = function() {
     var locations = [];
        
        <%
                for(Object t: posts)
                {
                    ReportModel md = (ReportModel) t;
                    String toSplit[] = md.getCaseLocation().split(",");
                    
        %>
      
      locations [locations.length] = ['<%=md.getCategory()%>', <%=toSplit[0]%>, <%=toSplit[1]%>,<%=md.getCode()%>, 4];
              
        <%
                }
        %>
      console.log(locations);
    
    

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 14,
      zoomControl: false,
      center: new google.maps.LatLng(6.4549, 3.4246),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });
      var infowindow = new google.maps.InfoWindow({
      content: locations[i][0],
      maxWidth: 160
    });
    infowindow.open(map, marker);
      

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
        
          parent.openCase(locations[i][3]);
        }
      })(marker, i));
    
    };
     
     
     
    
      
      
      
      
      
    }
  </script>

</html>