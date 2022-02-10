package com.example.felonyreporter;

import android.os.Parcel;
import android.os.Parcelable;

public class CrimeRVModal implements Parcelable {
    private String name;
    private String state;
    private String city;
    private String pincode;
    private String crimedesc;
    private String category;
    private String crimeid;

    public CrimeRVModal() {

    }

    public CrimeRVModal(String name, String state, String city, String pincode, String crimedesc, String category, String crimeid) {
        this.name = name;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.crimedesc = crimedesc;
        this.category = category;
        this.crimeid = crimeid;
    }

    protected CrimeRVModal(Parcel in) {
        name = in.readString();
        state = in.readString();
        city = in.readString();
        pincode = in.readString();
        crimedesc = in.readString();
        category = in.readString();
        crimeid = in.readString();
    }

    public static final Creator<CrimeRVModal> CREATOR = new Creator<CrimeRVModal>() {
        @Override
        public CrimeRVModal createFromParcel(Parcel in) {
            return new CrimeRVModal(in);
        }

        @Override
        public CrimeRVModal[] newArray(int size) {
            return new CrimeRVModal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCrimedesc() {
        return crimedesc;
    }

    public void setCrimedesc(String crimedesc) {
        this.crimedesc = crimedesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCrimeid() {
        return crimeid;
    }

    public void setCrimeid(String crimeid) {
        this.crimeid = crimeid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(pincode);
        dest.writeString(crimedesc);
        dest.writeString(category);
        dest.writeString(crimeid);
    }
}
