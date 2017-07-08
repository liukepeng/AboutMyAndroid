package com.lkp.android.criminalintent.test;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/19.
 *
 */

public class CrimeParclable implements Parcelable {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Boolean mSolved = false;
    private String mSuspect;

    public CrimeParclable(UUID id, String title, Date date, Boolean solved, String suspect) {
        this.mId = id;
        this.mTitle = title;
        this.mDate = date;
        this.mSolved = solved;
        this.mSuspect = suspect;
    }

    private CrimeParclable(Parcel in) {
        mId = (UUID) in.readSerializable();
        mTitle = in.readString();
        mDate = (Date) in.readSerializable();
        mSolved = in.readInt() == 1;
        mSuspect = in.readString();
    }

    public static final Creator<CrimeParclable> CREATOR = new Creator<CrimeParclable>() {
        @Override
        public CrimeParclable createFromParcel(Parcel in) {
            return new CrimeParclable(in);
        }

        @Override
        public CrimeParclable[] newArray(int size) {
            return new CrimeParclable[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mId);
        dest.writeString(mTitle);
        dest.writeSerializable(mDate);
        dest.writeInt(mSolved ? 1 : 0);
        dest.writeString(mSuspect);
    }
}
