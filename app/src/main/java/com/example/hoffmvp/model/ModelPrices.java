package com.example.hoffmvp.model;

import com.google.gson.annotations.SerializedName;

public class ModelPrices {

    @SerializedName("new")
    private int _new;

    @SerializedName("old")
    private int old;

    public int getNew() {
        return _new;
    }

    public void setNew(int _new) {
        this._new = _new;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

}
