package jp.maxio.android.busalarm.model;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusPlatformResult {

    @SuppressLint("UseSparseArrays")
    Map<Integer, Busstop> busstops = new HashMap<Integer, Busstop>();

    public Busstop getBusstop(int id) {
        return busstops.get(id);
    }

    public List<Busstop> getBusstops() {
        List<Busstop> s = new ArrayList<Busstop>();
        s.addAll(busstops.values());
        return s;
    }

    public void setBusstop(Busstop busstop) {
        int id = busstop.getId();
        busstops.put(id, busstop);
    }

}
