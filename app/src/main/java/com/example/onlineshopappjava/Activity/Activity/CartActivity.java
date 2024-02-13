package com.example.onlineshopappjava.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.onlineshopappjava.Activity.Adapter.CartListAdapter;
import com.example.onlineshopappjava.Activity.Helper.ChangeNumberItemsListener;
import com.example.onlineshopappjava.Activity.Helper.ManagmentCart;
import com.example.onlineshopappjava.R;

public class CartActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerView;
private ManagmentCart managmentCart;

private TextView totalFeeTxt,taxTxt,deliveryTxt,totallTxt,emptyTxt;
private double tax;
private ScrollView scrollView;
private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart=new ManagmentCart(this);

        initView();
        setVariavle();
        initList();
        calcualterCart();

    }

    private void initList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calcualterCart();
            }
        });

        recyclerView.setAdapter(adapter);
        if(managmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }

    private void calcualterCart() {
        double percentTax=0.02;
        double delivery=1000;
        tax=Math.round((managmentCart.getTotalFee()*percentTax*100.0))/100.0;

        double total=Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100)/100;

        totalFeeTxt.setText("₸"+itemTotal);
        taxTxt.setText("₸"+tax);
        deliveryTxt.setText("₸"+delivery);
        totallTxt.setText("₸"+total);
    }

    private void setVariavle() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totallTxt=findViewById(R.id.totallTxt);
        recyclerView=findViewById(R.id.view3);
        scrollView=findViewById(R.id.scrollView3);
        backBtn=findViewById(R.id.backBtn);
        emptyTxt=findViewById(R.id.emptyTxt);
    }
}