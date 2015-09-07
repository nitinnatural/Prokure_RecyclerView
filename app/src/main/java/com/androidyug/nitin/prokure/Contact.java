package com.androidyug.nitin.prokure;

import java.util.UUID;

/**
 * Created by IAMONE on 9/7/2015.
 */
public class Contact {
    private UUID mId;
    private String mName;
    private String mMobNumber;

    Contact(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getMobNumber() {
        return mMobNumber;
    }

    public void setMobNumber(String mMobNumber) {
        this.mMobNumber = mMobNumber;
    }


}
