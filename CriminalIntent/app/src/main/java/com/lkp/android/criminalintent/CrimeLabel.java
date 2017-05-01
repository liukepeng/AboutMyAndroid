package com.lkp.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/23.
 */

public class CrimeLabel {
    private static CrimeLabel sCrimeLabel;
    private List<Crime> mCrimes;


    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }

    private CrimeLabel(Context context){
        mCrimes = new ArrayList<>();
//        for (int i = 0; i < 100; i++){
//            Crime crime = new Crime();
//            crime.setTitle("Crime #" + i);
//            crime.setSolved(i % 2 == 0);
//            mCrimes.add(crime);
//        }
    }

    public static CrimeLabel newInstance(Context context){
        if (sCrimeLabel == null){
            sCrimeLabel = new CrimeLabel(context);
        }
        return  sCrimeLabel;
    }

    public List<Crime> getCrimes(){
            return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

}
