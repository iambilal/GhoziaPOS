package com.example.ghoziapos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.Volley;
import com.example.ghoziapos.Model.MenuModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dashboard extends AppCompatActivity implements MenuRecyclerAdapter.OnItemClickListener{

    public List<MenuModel> menuModelsList;
    public JsonArrayRequest jsonArrayRequest;
    public RequestQueue requestQueue;
    public RecyclerView menuRecyclerView;
    public MenuRecyclerAdapter menuRecyclerAdapter;
    public String URL = "https://raw.githubusercontent.com/iambilal/GhoziaPOS/master/Menu.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //initialization
        menuModelsList = new ArrayList<MenuModel>();
        menuRecyclerView = findViewById(R.id.MenuList);
        menuRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new
                GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        menuRecyclerView.setLayoutManager(gridLayoutManager);

        //Setting Adapter
        menuRecyclerAdapter = new MenuRecyclerAdapter(getApplicationContext(),menuModelsList);
        menuRecyclerView.setAdapter(menuRecyclerAdapter);

        //Calling getJson Function

        getJson();

    }

    //Get Json File
    public void getJson() {
        jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                 for (int i=0; i<response.length();i++){

                     try{
                         jsonObject = response.getJSONObject(i);
                         MenuModel menuModel = new MenuModel();
                         menuModel.setMenuImage(jsonObject.getString("menu_img"));
                         menuModel.setMenuName(jsonObject.getString("menu_name"));

                         menuModelsList.add(menuModel);
                         menuRecyclerAdapter.notifyDataSetChanged();
                         Toast.makeText(Dashboard.this, "check"+menuModelsList.size(), Toast.LENGTH_SHORT).show();
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

                 }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onShowItemClick(int position) {

    }

    @Override
    public void onDeleteItemClick(int position) {

    }
}