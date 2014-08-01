package jp.maxio.android.busalarm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class BusApproachDataResult implements Parcelable {

	private BusstopsSection section;
	private List<Bus> buses;
	private Date date;
	private int requestId;

	public BusApproachDataResult() {
	}

	public BusApproachDataResult(Parcel in) {
		section = in.readParcelable(BusstopsSection.class.getClassLoader());
		buses = (List<Bus>) in.readSerializable();
		date = new Date(in.readLong());
		requestId = in.readInt();
	}

	public BusstopsSection getSection() {
		return section;
	}

	public Busstop getDepartureBusstop() {
		if (section == null) {
			return null;
		}
		return section.getDeparture();
	}

	public Busstop getArrivalBusstop() {
		if (section == null) {
			return null;
		}
		return section.getArrival();
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public Date getDate() {
		return date;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setSection(BusstopsSection section) {
		this.section = section;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public static final Creator<BusApproachDataResult> CREATOR = new Creator<BusApproachDataResult>() {

		@Override
		public BusApproachDataResult createFromParcel(Parcel source) {
			return new BusApproachDataResult(source);
		}

		@Override
		public BusApproachDataResult[] newArray(int size) {
			return new BusApproachDataResult[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(section, flags);
		dest.writeSerializable((Serializable) buses);
		// TODO: Null Pointer
		dest.writeLong(date.getTime());
		dest.writeInt(requestId);
	}

	@Override
	public String toString() {
		return String.format("%s, buses=array[%d], requestId=%d", section.toString(), buses.size(), requestId);
	}
}
