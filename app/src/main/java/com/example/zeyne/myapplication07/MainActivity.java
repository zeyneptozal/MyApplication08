package com.example.zeyne.myapplication07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.listview_product);
        mProductList = new ArrayList<>();

        mProductList.add(new Product(1,"Fiyata Göre Azalan"));
        mProductList.add(new Product(2,"Fiyata Göre Artan"));
        mProductList.add(new Product(3,"En Çok Satılanlar"));
        mProductList.add(new Product(1,"En Yeniler"));

        adapter= new ProductListAdapter(getApplicationContext(),mProductList);
        lvProduct.setAdapter(adapter);

        //Handle on item click

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Tıklanan ürünün id si = " + view.getTag(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
