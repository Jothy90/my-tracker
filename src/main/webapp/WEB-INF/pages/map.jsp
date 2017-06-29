<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>My Tracker Application</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='assets/css/custom.css' rel='stylesheet' type='text/css'>
</head>
<body>

<div id="map" style="height:550px;"></div>

<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBixAyGVilHKslqnlZPNAqEgO45AYitaTY"></script>
<script type="text/javascript">
    $(function () {

        function initMap() {

            var location = new google.maps.LatLng('<c:out value="${loc.lng}"/>', '<c:out value="${loc.lat}"/>');
            var mapCanvas = document.getElementById('map');
            var mapOptions = {
                center: location,
                zoom: 16,
                panControl: false,
                scrollwheel: false,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
            var map = new google.maps.Map(mapCanvas, mapOptions);

            var markerImage = 'assets/img/car.png';

            var marker = new google.maps.Marker({
                position: location,
                map: map,
                icon: markerImage
            });

            var contentString = '<div class="info-window">' +
                    '<h3>Device</h3>' +
                    '<div class="info-content">' +
                    '<p>Location</p>' +
                    '</div>' +
                    '</div>';

            var infowindow = new google.maps.InfoWindow({
                content: contentString,
                maxWidth: 100
            });

            marker.addListener('click', function () {
                infowindow.open(map, marker);
            });

            var styles = [{
                "featureType": "landscape",
                "stylers": [{"saturation": -100}, {"lightness": 65}, {"visibility": "on"}]
            }, {
                "featureType": "poi",
                "stylers": [{"saturation": -100}, {"lightness": 51}, {"visibility": "simplified"}]
            }, {
                "featureType": "road.highway",
                "stylers": [{"saturation": -100}, {"visibility": "simplified"}]
            }, {
                "featureType": "road.arterial",
                "stylers": [{"saturation": -100}, {"lightness": 30}, {"visibility": "on"}]
            }, {
                "featureType": "road.local",
                "stylers": [{"saturation": -100}, {"lightness": 40}, {"visibility": "on"}]
            }, {
                "featureType": "transit",
                "stylers": [{"saturation": -100}, {"visibility": "simplified"}]
            }, {"featureType": "administrative.province", "stylers": [{"visibility": "off"}]}, {
                "featureType": "water",
                "elementType": "labels",
                "stylers": [{"visibility": "on"}, {"lightness": -25}, {"saturation": -100}]
            }, {
                "featureType": "water",
                "elementType": "geometry",
                "stylers": [{"hue": "#ffff00"}, {"lightness": -25}, {"saturation": -97}]
            }];

            //map.set('styles', styles);


        }

        google.maps.event.addDomListener(window, 'load', initMap);
    });
</script>
</body>
</html>