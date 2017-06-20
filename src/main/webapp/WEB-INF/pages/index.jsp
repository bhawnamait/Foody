<%--
Created by IntelliJ IDEA.
User: bhawna
Date: 20/04/16
Time: 01:29
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script src="${jqueryJs}"></script>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
    <script type="text/javascript">
        function initialize() {
            var address = (document.getElementById('my-address'));
            var autocomplete = new google.maps.places.Autocomplete(address);
            autocomplete.setTypes(['geocode']);
            google.maps.event.addListener(autocomplete, 'place_changed', function() {
                var place = autocomplete.getPlace();
                if (!place.geometry) {
                    return;
                }
                var address = '';
                if (place.address_components) {
                    address = [
                        (place.address_components[0] && place.address_components[0].short_name || ''),
                        (place.address_components[1] && place.address_components[1].short_name || ''),
                        (place.address_components[2] && place.address_components[2].short_name || '')
                    ].join(' ');
                }
            });
        }
        function codeAddress() {
            geocoder = new google.maps.Geocoder();
            var address = document.getElementById("my-address").value;
            geocoder.geocode( { 'address': address}, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    var lati=results[0].geometry.location.lat();
                    var longi=results[0].geometry.location.lng();
                    alert("Latitude: "+lati);
                    alert("Longitude: "+longi);

                }
                else {
                    alert("Geocode was not successful for the following reason: " + status);
                }
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);



    jQuery(document).ready(function($) {
        searchViaAjax();
    });

    function searchViaAjax() {

        var search = {}
        search["lat"] = lati;
        search["lon"] = longi;
        search["dist"] = 9.08;
        search["name"] = "dsfsdf";
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/restaurant/store",
            data : JSON.stringify(search),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");

            }
        });

    }
        function display(data) {
        var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
    }
    </script>
</head>
<body>
<form action="/restaurant/store" method="post"></form>
<input type="text" id="my-address">
<button id="getCords" onClick="codeAddress();">getLat&Long</button>
</body>
</html>

