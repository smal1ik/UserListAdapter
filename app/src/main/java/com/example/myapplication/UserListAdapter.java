package com.example.myapplication;

import static com.example.myapplication.Sex.MAN;
import static com.example.myapplication.Sex.UNKNOWN;
import static com.example.myapplication.Sex.WOMAN;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class UserListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<User> users;


    public UserListAdapter(Context ctx, ArrayList<User> users){
        this.ctx = ctx;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        User user = users.get(i);

        view = LayoutInflater.from(ctx).inflate(R.layout.user_layout, viewGroup, false);
        ImageView userPic = view.findViewById(R.id.userpic);
        TextView tvName= view.findViewById(R.id.name);
        TextView tvNumberPhone = view.findViewById(R.id.numberphone);

        tvName.setText(user.getName());
        tvNumberPhone.setText(user.getNumberPhone());

        switch (user.getSex()){
            case MAN: userPic.setImageResource(R.drawable.user_man); break;
            case WOMAN: userPic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: userPic.setImageResource(R.drawable.user_unknown); break;
        }

        return view;
    }
}
