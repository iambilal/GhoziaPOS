package com.example.ghoziapos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Model.MenuModel;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    public List<MenuModel> menuModelsList;
    public JsonArrayRequest jsonArrayRequest;
    public RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //initialization
        menuModelsList = new ArrayList<MenuModel>();

    }

    //Get Json File
    public void getJson() {
        jsonArrayRequest = new JsonArrayRequest("", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

            }
        });
    }
}