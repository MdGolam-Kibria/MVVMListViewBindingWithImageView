package com.example.mvvmlistviewbindingwithimageview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.example.mvvmlistviewbindingwithimageview.R;
import com.example.mvvmlistviewbindingwithimageview.databinding.ListViewBinding;
import com.example.mvvmlistviewbindingwithimageview.viewmodel.ListViewModel;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListViewModel> newsList;
    private ListViewBinding listViewBinding;//this is inner_layout.xml dataBinding class for access the view without any id

    public CustomAdapter(Context context, ArrayList<ListViewModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.inner_layout, null);
            listViewBinding = DataBindingUtil.bind(convertView);
            convertView.setTag(listViewBinding);

        } else {
            listViewBinding = (ListViewBinding) convertView.getTag();
        }
        listViewBinding.setNewsmodel(newsList.get(position));
        return listViewBinding.getRoot();
    }
}
