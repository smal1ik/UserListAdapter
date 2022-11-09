package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<User> users;
    UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream stream = null;
        try {
            stream = getAssets().open("Users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        Type typeMyType = new TypeToken<ArrayList<User>>(){}.getType();
        users = gson.fromJson(reader, typeMyType);

        listView = findViewById(R.id.listview);
        adapter = new UserListAdapter(this, users);
        listView.setAdapter(adapter);

    }
}