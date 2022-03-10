package com.in.lab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.in.lab.R;
import com.in.lab.model.TestRequestModel;

import java.util.List;

public class TestRequestAdapter extends RecyclerView.Adapter<TestRequestAdapter.ViewHolder> {
    List<TestRequestModel.TestRequestData> list;
    Context context;
    Click click;


    public interface Click {
        void onItemClick(int position);
    }

    public TestRequestAdapter(List<TestRequestModel.TestRequestData> list, Context context, Click click) {
        this.list = list;
        this.context = context;
        this.click = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lab_test_request_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TestRequestModel.TestRequestData model = list.get(position);

        holder.BookingId.setText(model.getBooking_id());
        holder.patientName.setText(model.getPatient_name());
        holder.dateOfBooking.setText(model.getBooking_date());
        holder.labTestName.setText(model.getLast_test_name());
        holder.labTestResult.setText(model.getLast_test_result());
        holder.amount.setText(model.getAmount());


        holder.viewBookingDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView BookingId, patientName, dateOfBooking, labTestName, labTestResult, amount, viewBookingDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            BookingId = itemView.findViewById(R.id.BookingId);
            patientName = itemView.findViewById(R.id.patientName);
            dateOfBooking = itemView.findViewById(R.id.dateOfBooking);
            labTestName = itemView.findViewById(R.id.labTestName);
            labTestResult = itemView.findViewById(R.id.labTestResult);
            amount = itemView.findViewById(R.id.amount);
            viewBookingDetail = itemView.findViewById(R.id.viewBookingDetail);

        }
    }
}
