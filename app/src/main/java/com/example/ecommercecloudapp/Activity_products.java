package com.example.ecommercecloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Activity_products extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        list=findViewById(R.id.list);


        //To Sort Data retrieved
        DataQueryBuilder builder=DataQueryBuilder.create();
        builder.setSortBy("created desc");
        //builder.setWhereClause("price = '22'");

        Backendless.Data.of(Cart.class).find(new AsyncCallback<List<Cart>>() {
            @Override
            public void handleResponse(List<Cart> response) {
                ArrayList<String> products = new ArrayList<>();
                for(Cart cart :response){
                    products.add(cart.getName());
                }
                ArrayAdapter adapter=new ArrayAdapter(Activity_products.this,
                        android.R.layout.simple_list_item_1,products);
                list.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });




    }
}
