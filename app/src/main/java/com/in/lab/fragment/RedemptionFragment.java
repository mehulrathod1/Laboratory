package com.in.lab.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.in.lab.R;
import com.in.lab.model.CommonModel;
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RedemptionFragment extends Fragment {

    View view;
    Button btnSubmit;
    TextView amount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_redemption, container, false);
        init();
        return view;
    }

    public void init() {


//        Global.progressDialog(getContext());
        btnSubmit = view.findViewById(R.id.btnSubmit);
        amount = view.findViewById(R.id.amount);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (amount.getText().toString().equals("")) {
                    amount.setError("Please add amount");
                } else {
                    requestToRedemption(Global.token, Global.userId, amount.getText().toString());
                }
            }
        });
    }

    public void requestToRedemption(String token, String user_id, String amount) {

            Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);
//        Global.dialog.show();

        call.withdrawalRequest(token, user_id, amount).enqueue(new Callback<CommonModel>() {
            @Override
            public void onResponse(Call<CommonModel> call, Response<CommonModel> response) {

                CommonModel commonModel = response.body();

                Toast.makeText(getContext(), "" + commonModel.getMessage(), Toast.LENGTH_SHORT).show();
//                Global.dialog.dismiss();
            }

            @Override
            public void onFailure(Call<CommonModel> call, Throwable t) {

//                Global.dialog.dismiss();
            }
        });
    }
}