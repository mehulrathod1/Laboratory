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
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRequestUpcomingFragment extends Fragment {

    View view;
    RecyclerView testCompletedRecycler;
    TestRequestAdapter testRequestTabAdapter;
    List<TestRequestModel.TestRequestData> requestList = new ArrayList<>();


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
        getUpcomingTest(Global.token,Global.userId);
        return view;

    }

    public void init() {

        testCompletedRecycler = view.findViewById(R.id.testCompletedRecycler);
    }

    public void getUpcomingTest(String token, String user_id) {

        Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);

        call.getUpcomingTest(token, user_id).enqueue(new Callback<TestRequestModel>() {
            @Override
            public void onResponse(Call<TestRequestModel> call, Response<TestRequestModel> response) {

                TestRequestModel testRequestModel = response.body();

                List<TestRequestModel.TestRequestData> dataList = testRequestModel.getTestRequestData();
                for (int i = 0; i < dataList.size(); i++) {

                    TestRequestModel.TestRequestData model = dataList.get(i);

                    TestRequestModel.TestRequestData data = new TestRequestModel.TestRequestData(
                            model.getBooking_id(), model.getBooking_date(), model.getPatient_name(),
                            model.getLast_test_name(), model.getLast_test_result(), model.getAmount()
                    );

                    requestList.add(data);
                }

                requestData();
            }

            @Override
            public void onFailure(Call<TestRequestModel> call, Throwable t) {

            }
        });
    }

    public void requestData() {



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