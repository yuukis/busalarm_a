package jp.maxio.android.busalarm.model;

import android.util.SparseArray;

public class AppWidgetDataMap {

    private static AppWidgetDataMap instance = new AppWidgetDataMap();

    public static AppWidgetDataMap getInstance() {
        return instance;
    }

    private SparseArray<AppWidgetData> map;

    private AppWidgetDataMap() {
        map = new SparseArray<AppWidgetData>();
    }

    public AppWidgetData getData(int appWidgetId) {
        return map.get(appWidgetId);
    }

    public int getAppWidgetId(AppWidgetData data) {
        int index = map.indexOfValue(data);
        if (index < 0) {
            return -1;
        }
        return map.keyAt(index);
    }

    public void putData(int appWidgetId, AppWidgetData data) {
        map.put(appWidgetId, data);
    }

    public void removeData(int appWidgetId) {
        map.delete(appWidgetId);
    }

    public int size() {
        return map.size();
    }
}
