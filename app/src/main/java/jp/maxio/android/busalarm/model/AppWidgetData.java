package jp.maxio.android.busalarm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AppWidgetData implements Parcelable {

    private int appWidgetId;
    private Busstop departure;
    private Busstop arrival;

    public AppWidgetData() {
    }

    public AppWidgetData(Parcel in) {
        appWidgetId = in.readInt();
        departure = (Busstop) in.readSerializable();
        arrival = (Busstop) in.readSerializable();
    }

    public int getAppWidgetId() {
        return appWidgetId;
    }

    public Busstop getDeparture() {
        return departure;
    }

    public int getDepartureId() {
        if (departure == null) {
            return -1;
        }
        return departure.getId();
    }

    public Busstop getArrival() {
        return arrival;
    }

    public int getArrivalId() {
        if (arrival == null) {
            return -1;
        }
        return arrival.getId();
    }

    public void setAppWidgetId(int appWidgetId) {
        this.appWidgetId = appWidgetId;
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

    public void setArrival(Busstop departure) {
        this.arrival = departure;
    }

    public void setArrival(int id, String name) {
        Busstop busstop = new Busstop();
        busstop.setId(id);
        busstop.setName(name);
        setArrival(busstop);
    }

    public static final Creator<AppWidgetData> CREATOR = new Creator<AppWidgetData>() {

        @Override
        public AppWidgetData createFromParcel(Parcel source) {
            return new AppWidgetData(source);
        }

        @Override
        public AppWidgetData[] newArray(int size) {
            return new AppWidgetData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(appWidgetId);
        dest.writeSerializable(departure);
        dest.writeSerializable(arrival);
    }

}
