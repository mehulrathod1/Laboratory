package com.in.lab.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;

import com.in.lab.R;
import com.in.lab.adapter.TransactionHistoryAdapter;
import com.in.lab.model.TransactionHistoryModel;
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionHistoryFragment extends Fragment {

    TransactionHistoryAdapter adapter;
    RecyclerView recyclerView;
    List<TransactionHistoryModel.TransactionHistoryData> list = new ArrayList<>();
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        init();
        recyclerData();
        getTransactionHistory(Global.token,Global.userId);
        return view;
    }

    public void init() {
        recyclerView = view.findViewById(R.id.recycler);

    }

    public void getTransactionHistory(String token, String user_id) {

        Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);


        call.getTransactionHistory(token, user_id).enqueue(new Callback<TransactionHistoryModel>() {
            @Override
            public void onResponse(Call<TransactionHistoryModel> call, Response<TransactionHistoryModel> response) {

                TransactionHistoryModel transactionHistoryModel = response.body();
                List<TransactionHistoryModel.TransactionHistoryData> dataList = transactionHistoryModel.getTransactionHistoryData();
                for (int i = 0; i < dataList.size(); i++) {

                    TransactionHistoryModel.TransactionHistoryData model = dataList.get(i);
                    TransactionHistoryModel.TransactionHistoryData data = new TransactionHistoryModel.TransactionHistoryData(
                            model.getId(), model.getTxn_id(), model.getAmount(), model.getPayment_status(), model.getRemarks(),
                            model.getTxn_date());

                    list.add(data);
                }
                recyclerData();

            }

            @Override
            public void onFailure(Call<TransactionHistoryModel> call, Throwable t) {

            }
        });

    }

    public void recyclerData() {


        adapter = new TransactionHistoryAdapter(list, getContext());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }


}