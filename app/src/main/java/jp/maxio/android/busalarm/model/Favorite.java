package jp.maxio.android.busalarm.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import android.os.Parcel;
import android.os.Parcelable;

public class Favorite extends BusstopsSection {

	private long favoriteId = 0;
	private boolean useAlarm;
	private String tone;
	private WeekdaysSet repeatWeekdays;
	private int hour = 9;
	private int minute = 0;
	private int remainder = 5;
	private boolean vibrate;

	public Favorite() {
		super();
		tone = "";
		repeatWeekdays = WeekdaysSet.getInstance(false);
	}

	public Favorite(Parcel in) {
		super(in);
		favoriteId = in.readLong();
		useAlarm = (in.readInt() > 0);
		tone = in.readString();
		repeatWeekdays = in.readParcelable(WeekdaysSet.class.getClassLoader());
		hour = in.readInt();
		minute = in.readInt();
		remainder = in.readInt();
		vibrate = (in.readInt() > 0);
	}

	public long getFavoriteId() {
		return favoriteId;
	}

	public boolean isUseAlarm() {
		return useAlarm;
	}

	public String getTone() {
		return tone;
	}

	public boolean isVibrate() {
		return vibrate;
	}

	public WeekdaysSet getRepeatWeekdays() {
		return repeatWeekdays;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setFavoriteId(long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public void setUseAlarm(boolean useAlarm) {
		this.useAlarm = useAlarm;
	}

	public void setTone(String tone) {
		this.tone = tone;
	}

	public void setVibrate(boolean vibrate) {
		this.vibrate = vibrate;
	}

	public void setRepeatWeekdays(WeekdaysSet repeatWeekdays) {
		this.repeatWeekdays = repeatWeekdays;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {

		@Override
		public Favorite createFromParcel(Parcel source) {
			return new Favorite(source);
		}

		@Override
		public Favorite[] newArray(int size) {
			return new Favorite[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		dest.writeLong(favoriteId);
		dest.writeInt((useAlarm) ? 1 : 0);
		dest.writeString(tone);
		dest.writeParcelable(repeatWeekdays, flags);
		dest.writeInt(hour);
		dest.writeInt(minute);
		dest.writeInt(remainder);
		dest.writeInt((vibrate) ? 1 : 0);
	}

	public Date getNextAlertTime() {
		Calendar thisTime = Calendar.getInstance(
				TimeZone.getTimeZone("GMT+9:00"), Locale.JAPAN);
		Calendar nextTime = Calendar.getInstance(
				TimeZone.getTimeZone("GMT+9:00"), Locale.JAPAN);
		nextTime.set(Calendar.HOUR_OF_DAY, hour);
		nextTime.set(Calendar.MINUTE, minute);
		nextTime.set(Calendar.SECOND, 0);
		nextTime.set(Calendar.MILLISECOND, 0);

		if (repeatWeekdays.isEmpty()) {
			if (nextTime.before(thisTime)) {
				nextTime.add(Calendar.DATE, 1);
			}
		} else {
			nextTime.add(Calendar.DATE, 7);

			for (int weekend : repeatWeekdays.getArray()) {
				Calendar currentCal = Calendar.getInstance(
						TimeZone.getTimeZone("GMT+9:00"), Locale.JAPAN);
				currentCal.set(Calendar.HOUR_OF_DAY, hour);
				currentCal.set(Calendar.MINUTE, minute);
				currentCal.set(Calendar.SECOND, 0);
				currentCal.set(Calendar.MILLISECOND, 0);
				currentCal.set(Calendar.DAY_OF_WEEK, weekend);
				if (currentCal.before(thisTime)) {
					currentCal.add(Calendar.DATE, 7);
				}
				if (currentCal.before(nextTime)) {
					nextTime = currentCal;
				}
			}
		}

		return nextTime.getTime();
	}

	@Override
	public String toString() {
		return String.format(Locale.JAPAN, "%s, alarm=%s, remainder=%d",
				super.toString(), Boolean.toString(useAlarm), remainder);
	}

}
