package jp.maxio.android.busalarm.model;

import java.io.Serializable;

public class Bus implements Serializable {

    private static final long serialVersionUID = 6699820457016395484L;
    private String serial;
    private Route route;
    private String destination;
    private int remainder;

    public String getSerial() {
        return serial;
    }

    public Route getRoute() {
        return route;
    }

    public String getDestination() {
        return destination;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public boolean equals(Bus other) {
        return serial.equals(other.getSerial());
    }
}
