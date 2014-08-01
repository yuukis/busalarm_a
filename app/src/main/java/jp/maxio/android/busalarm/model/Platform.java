package jp.maxio.android.busalarm.model;

import java.io.Serializable;

public class Platform implements Serializable {

    private static final long serialVersionUID = -6650331766907572623L;
    private int id;
    private String name;
    private double lat;
    private double lon;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

}
