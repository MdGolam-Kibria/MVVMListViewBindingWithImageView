package com.example.mvvmlistviewbindingwithimageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mvvmlistviewbindingwithimageview.adapter.CustomAdapter;
import com.example.mvvmlistviewbindingwithimageview.databinding.ActivityMainBinding;
import com.example.mvvmlistviewbindingwithimageview.viewmodel.ListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    ListView listView;
    ArrayList<ListViewModel> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        newsList = new ArrayList<>();
        getData();
        CustomAdapter adapter = new CustomAdapter(this,newsList);
        activityMainBinding.listView.setAdapter(adapter);
    }

    private void getData() {
        ListViewModel listViewModel = new ListViewModel("hello world","This is MVVM listView with image ","https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        ListViewModel listViewModel2 = new ListViewModel("hello world snd","This is MVVM listView with image snd ","https://homepages.cae.wisc.edu/~ece533/images/cat.png");
        ListViewModel listViewModel3 = new ListViewModel("hello world third","This is MVVM listView with image sthird ","https://homepages.cae.wisc.edu/~ece533/images/fruits.png");
        newsList.add(listViewModel);
        newsList.add(listViewModel2);
        newsList.add(listViewModel3);
    }
}