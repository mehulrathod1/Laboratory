package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.in.lab.R;
import com.in.lab.adapter.MyReviewAdapter;
import com.in.lab.model.MyReviewModel;

import java.util.ArrayList;
import java.util.List;

public class MyReviewActivity extends AppCompatActivity {


    ImageView back;
    TextView headerTitle;

    RecyclerView recyclerView;
    MyReviewAdapter adapter;
    List<MyReviewModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_review);
        init();
        clickEvent();
        recyclerData();
    }

    public void init() {

        back = findViewById(R.id.Back);
        headerTitle = findViewById(R.id.header_title);
        headerTitle.setText("My Review");
        recyclerView = findViewById(R.id.recycler);
    }

    public void clickEvent() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void recyclerData() {


        MyReviewModel model = new MyReviewModel("Mehul Rathod","27/09/2021","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo du");
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);




        adapter = new MyReviewAdapter(list, getApplicationContext(), new MyReviewAdapter.Click() {
            @Override
            public void onItemClick(int position) {


            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
