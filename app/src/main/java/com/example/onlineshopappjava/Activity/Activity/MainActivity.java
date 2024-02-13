package com.example.onlineshopappjava.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.onlineshopappjava.Activity.Adapter.PopularListAdapter;
import com.example.onlineshopappjava.Activity.Domain.PopularDomain;
import com.example.onlineshopappjava.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPupolar;
private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        bottom_navigation();
    }

    private void bottom_navigation() {
        LinearLayout homeBtm=findViewById(R.id.homeBtn);
        LinearLayout cartBtm=findViewById(R.id.cartBtn);

        homeBtm.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        cartBtm.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("Ноутбук Asus", "Ноутбук Asus Vivobook 17X i5 13500H представляет собой мощное и универсальное устройство, идеально подходящее как для повседневных задач, так и для выполнения требовательных профессиональных заданий. Свежий процессор Intel Core i5 13500H обеспечивает высокую производительность и эффективность, позволяя легко справляться с множеством задач одновременно.", "pic1",25,5,500000));
        items.add(new PopularDomain("Ps-5 Digital" , "", "pic2",10,5,280000));
        items.add(new PopularDomain("Iphone14","","pic3",21,4,420000));

        recyclerViewPupolar=findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar= new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}