package com.senz.track.platform;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/*{
        "message": "on",
        "deviceId": "8",
        "applicationId": "2",
        "deviceLocation":"long:lat"
        }*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DOMessage {

    private String applicationId;
    private String message;
    private String deviceId;
    private String deviceLocation;



    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "DOMessage{" +
                "applicationId='" + applicationId + '\'' +
                ", message='" + message + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceLocation='" + deviceLocation + '\'' +
                '}';
    }
}
