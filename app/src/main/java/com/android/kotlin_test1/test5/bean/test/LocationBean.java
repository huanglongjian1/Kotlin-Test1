package com.android.kotlin_test1.test5.bean.test;

public class LocationBean {
    /**
     * street : {"number":1572,"name":"Kolodyazna"}
     * city : Zavodske
     * state : Harkivska
     * country : Ukraine
     * postcode : 24496
     * coordinates : {"latitude":"79.2701","longitude":"107.9680"}
     * timezone : {"offset":"-1:00","description":"Azores, Cape Verde Islands"}
     */

    private StreetBean street;
    private String city;
    private String state;
    private String country;
    private Integer postcode;
    private CoordinatesBean coordinates;
    private TimezoneBean timezone;

    public StreetBean getStreet() {
        return street;
    }

    public void setStreet(StreetBean street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public CoordinatesBean getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesBean coordinates) {
        this.coordinates = coordinates;
    }

    public TimezoneBean getTimezone() {
        return timezone;
    }

    public void setTimezone(TimezoneBean timezone) {
        this.timezone = timezone;
    }
}
