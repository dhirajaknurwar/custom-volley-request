package com.master.volleylibdemonstration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomDataAdapter extends RecyclerView.Adapter<CustomDataAdapter.ViewHolder> {
    private ArrayList<CountryCodeModel.DataList> countryCodeModelArrayList;

    public CustomDataAdapter(ArrayList<CountryCodeModel.DataList> countryCodeModelArrayList) {
        this.countryCodeModelArrayList = countryCodeModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_country_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.mLinearLayout.setTag(i);
        CountryCodeModel.DataList countryCodeModel = countryCodeModelArrayList.get(i);
        viewHolder.mName.setText(String.valueOf("NAME: " + countryCodeModel.getName()));
        viewHolder.mCode.setText(String.valueOf("DIAL CODE: " + countryCodeModel.getDial()));
    }

    @Override
    public int getItemCount() {
        return countryCodeModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mCode;
        private LinearLayout mLinearLayout;

        public ViewHolder(View view) {
            super(view);
            mName = view.findViewById(R.id.country_name_textView);
            mCode = view.findViewById(R.id.country_code_textView);
            mLinearLayout = view.findViewById(R.id.countryNameLL);
        }
    }
}
