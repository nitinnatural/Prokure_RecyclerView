package com.androidyug.nitin.prokure;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IAMONE on 9/7/2015.
 */
public class FragmentProkure extends Fragment {

    RecyclerView mRecyclerView;
    ArrayList<Contact> mContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_prokure, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mContacts = ContactLab.getInstance(getActivity()).getContacts();
        mRecyclerView.setAdapter(new ContactAdapter(mContacts));



        return v;
    }


    // inner Class

    private class ContactViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mNumber;
        private Contact mContact;


        public ContactViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.tv_name);
            mNumber = (TextView) itemView.findViewById(R.id.tv_number);
        }

        public void bindContact(Contact contact){
            mContact = contact;
            mName.setText(contact.getName().toString());
            mNumber.setText(contact.getMobNumber().toString());
        }
    }


    class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
        ArrayList<Contact> contactList;

        ContactAdapter(ArrayList<Contact> object){
            this.contactList = object;
        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rv_item, parent, false);

            return new ContactViewHolder(view);

        }

        @Override
        public void onBindViewHolder(ContactViewHolder holder, int position) {

            Contact contact = contactList.get(position);
            holder.bindContact(contact);
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }
    }
}
