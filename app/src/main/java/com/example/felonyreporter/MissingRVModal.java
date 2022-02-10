package com.example.felonyreporter;

import android.os.Parcel;
import android.os.Parcelable;

public class MissingRVModal implements Parcelable {
    String name2;
    String city2;
    String state2;
    String pincode2;
    String perdes2;
    String image2;
    public MissingRVModal(){

    }

    protected MissingRVModal(Parcel in) {
        name2 = in.readString();
        city2 = in.readString();
        state2 = in.readString();
        pincode2 = in.readString();
        perdes2 = in.readString();
        image2 = in.readString();
    }

    public static final Creator<MissingRVModal> CREATOR = new Creator<MissingRVModal>() {
        @Override
        public MissingRVModal createFromParcel(Parcel in) {
            return new MissingRVModal(in);
        }

        @Override
        public MissingRVModal[] newArray(int size) {
            return new MissingRVModal[size];
        }
    };


    public MissingRVModal(String name2, String city2, String state2, String pincode2, String perdes2, String image2) {
        this.name2 = name2;
        this.city2 = city2;
        this.state2 = state2;
        this.pincode2 = pincode2;
        this.perdes2 = perdes2;
        this.image2 = image2;
    }

    public String getName() {
        return name2;
    }

    public void setName(String name) {
        this.name2 = name;
    }

    public String getCity() {
        return city2;
    }

    public void setCity(String city) {
        this.city2 = city;
    }

    public String getState() {
        return state2;
    }

    public void setState(String state) {
        this.state2 = state;
    }

    public String getPincode() {
        return pincode2;
    }

    public void setPincode(String pincode) {
        this.pincode2 = pincode;
    }

    public String getPerdes() {
        return perdes2;
    }

    public void setPerdes(String perdes) {
        this.perdes2 = perdes;
    }

    public String getImage() {
        return image2;
    }

    public void setImage(String image) {
        this.image2 = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name2);
        dest.writeString(city2);
        dest.writeString(state2);
        dest.writeString(pincode2);
        dest.writeString(perdes2);
        dest.writeString(image2);
    }
}
