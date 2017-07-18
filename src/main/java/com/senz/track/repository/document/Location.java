package com.senz.track.repository.document;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class Location {

    @Id
    private String id;
    private String device;
    private Double lng;
    private Double lat;
    public DateTime createdTime;

    public Location() {
    }

    public Location(String[] loc,String device) {
        lng=Double.parseDouble(loc[0]);
        lat=Double.parseDouble(loc[1]);
        //lat = Math.floor(lat) + ((Math.floor(lat * 1000000) - Math.floor(lat) * 1000000) / 600000);
        //lng = Math.floor(lng) + ((Math.floor(lng * 1000000) - Math.floor(lng) * 1000000) / 600000);
        this.device=device;
        createdTime=DateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", device='" + device + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
