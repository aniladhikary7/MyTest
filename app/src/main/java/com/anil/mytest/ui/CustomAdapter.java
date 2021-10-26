package com.anil.mytest.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.anil.mytest.R;
import com.anil.mytest.userPayload.Datum;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Datum> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Datum> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView nameTv;
        TextView emailTv;
        TextView genderTv;
        TextView statusTv;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            nameTv = mView.findViewById(R.id.name_tv);
            emailTv = mView.findViewById(R.id.email_tv);
            genderTv = mView.findViewById(R.id.gender_tv);
            statusTv = mView.findViewById(R.id.status_tv);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.nameTv.setText(dataList.get(position).getName());
        holder.emailTv.setText(dataList.get(position).getEmail());
        holder.genderTv.setText(dataList.get(position).getGender());
        holder.statusTv.setText(dataList.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
