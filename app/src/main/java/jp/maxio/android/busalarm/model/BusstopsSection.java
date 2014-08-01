package jp.maxio.android.busalarm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BusstopsSection implements Parcelable {

    private Busstop departure;
    private Busstop arrival;

    public BusstopsSection() {
        this.departure = new Busstop();
        this.arrival = new Busstop();
    }

    public BusstopsSection(Parcel in) {
        this.departure = (Busstop) in.readSerializable();
        this.arrival = (Busstop) in.readSerializable();
    }

    public BusstopsSection(int departureId, int arrivalId) {
        Busstop departure = new Busstop();
        Busstop arrival = new Busstop();
        departure.setId(departureId);
        arrival.setId(arrivalId);
        setDeparture(departure);
        setArrival(arrival);
    }

    public BusstopsSection(Busstop departure, Busstop arrival) {
        setDeparture(departure);
        setArrival(arrival);
    }

    public Busstop getDeparture() {
        return departure;
    }

    public Busstop getArrival() {
        return arrival;
    }

    public void setDeparture(Busstop departure) {
        this.departure = departure;
    }

    public void setDeparture(int id, String name) {
        Busstop busstop = new Busstop();
        busstop.setId(id);
        busstop.setName(name);
        setDeparture(busstop);
    }

    public void setArrival(Busstop arrival) {
        this.arrival = arrival;
    }

    public void setArrival(int id, String name) {
        Busstop busstop = new Busstop();
        busstop.setId(id);
        busstop.setName(name);
        setArrival(busstop);
    }

    public boolean equals(Busstop departure, Busstop arrival) {
        return (this.departure.equals(departure) && this.arrival
                .equals(arrival));
    }

    public static final Creator<BusstopsSection> CREATOR = new Creator<BusstopsSection>() {

        @Override
        public BusstopsSection createFromParcel(Parcel source) {
            return new BusstopsSection(source);
        }

        @Override
        public BusstopsSection[] newArray(int size) {
            return new BusstopsSection[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(departure);
        dest.writeSerializable(arrival);
    }

    @Override
    public String toString() {
        return String.format("departure=%s, arrival=%s", departure.toString(),
                arrival.toString());
    }

}
