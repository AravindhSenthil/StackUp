package com.android.aravindhsenthil.stackup.Core;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aravindh senthil on 8/1/2017.
 */

public class ClassA implements Parcelable {

    String java;
    String android;
    String OS;
    int k = 0;

    protected ClassA(Parcel in) {
        this.java =
                in.readString();
        this.android =
                in.readString();
        this.k =
                in.readInt();


    }

    public static final Creator<ClassA> CREATOR = new Creator<ClassA>() {
        @Override
        public ClassA createFromParcel(Parcel in) {
            return new ClassA(in);
        }

        @Override
        public ClassA[] newArray(int size) {
            return new ClassA[size];
        }
    };

    public ClassA(String java, String android, int k) {
        this.java = java;
        this.android = android;
        this.k = k;
    }

    void method1() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(java);
    }
}
