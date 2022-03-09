package com.in.lab.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.in.lab.R;
import com.in.lab.adapter.TestRequestAdapter;
import com.in.lab.model.TestRequestModel;

import java.util.ArrayList;
import java.util.List;

public class TestRequestUpcomingFragment extends Fragment {

    View view;
    RecyclerView testCompletedRecycler;
    TestRequestAdapter testRequestTabAdapter;
    List<TestRequestModel> requestList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_test_request_upcoming, container, false);
        init();
        requestData();
        return view;

    }

    public void init() {

        testCompletedRecycler = view.findViewById(R.id.testCompletedRecycler);
    }

    public void requestData() {

        TestRequestModel model = new TestRequestModel("123456789", "Test Patient",
                "09-03-2022", "Test Test", "Result", "199");

        requestList.add(model);
        requestList.add(model);
        requestList.add(model);
        requestList.add(model);
        requestList.add(model);
        requestList.add(model);
        requestList.add(model);
        requestList.add(model);


        testRequestTabAdapter = new TestRequestAdapter(requestList, getContext(), new TestRequestAdapter.Click() {
            @Override
            public void onItemClick(int position) {

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        testCompletedRecycler.setLayoutManager(mLayoutManager);
        testCompletedRecycler.setAdapter(testRequestTabAdapter);
    }

}