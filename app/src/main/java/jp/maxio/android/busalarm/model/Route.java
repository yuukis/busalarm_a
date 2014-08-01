package jp.maxio.android.busalarm.model;

import java.io.Serializable;

public class Route implements Serializable {

    private int id;
    private String number;
    private String name;

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
