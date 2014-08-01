package jp.maxio.android.busalarm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Busstop implements Serializable {

    private static final long serialVersionUID = -5693866191710966130L;
    private int id;
    private String name;
    private double lat;
    private double lon;
    private List<Platform> platforms = new ArrayList<Platform>();

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

    public List<Platform> getPlatforms() {
        return platforms;
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

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void addPlatform(Platform platform) {
        double lat = platform.getLat();
        double lon = platform.getLon();
        if (lat > 0.0d && lon > 0.0d) {
            int size = platforms.size();
            this.lat = (this.lat * size + lat) / (size + 1);
            this.lon = (this.lon * size + lon) / (size + 1);
        }
        platforms.add(platform);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Busstop)) {
            return false;
        }
        Busstop other = (Busstop) o;
        return (id == other.getId());
    }

    @Override
    public String toString() {
        String name = this.name;
        name = (name != null) ? name : "null";
        return String.format("Busstop(%d:%s)", id, name);
    }

}
