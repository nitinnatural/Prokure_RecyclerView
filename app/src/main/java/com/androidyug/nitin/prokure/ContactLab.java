package com.androidyug.nitin.prokure;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by IAMONE on 9/7/2015.
 */
public class ContactLab {

    private static ContactLab mContactLab;
    private Context mAppContext;

    private ArrayList<Contact> mContacts;

    private ContactLab(Context appContext){
        mAppContext = appContext;
        mContacts = new ArrayList<Contact>();

        for(int i = 1; i<=200; i++){
            Contact c = new Contact();
            c.setName("Person: " + i);
            c.setMobNumber("890000000" + i);
            mContacts.add(c);
        }
    }

    // return the instance of the ContactLab
    public static ContactLab getInstance(Context c){
        if(mContactLab == null){
            mContactLab = new ContactLab(c.getApplicationContext());
        }
        return mContactLab;
    }

    // Return all the contacts as an ArrayList<>
    public ArrayList<Contact> getContacts(){
        return mContacts;
    }
}
