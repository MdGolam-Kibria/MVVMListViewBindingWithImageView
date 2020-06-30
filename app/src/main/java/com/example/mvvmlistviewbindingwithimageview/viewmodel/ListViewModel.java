package com.example.mvvmlistviewbindingwithimageview.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.mvvmlistviewbindingwithimageview.R;

public class ListViewModel extends BaseObservable {
    public String title,desc,imagePath;

    public ListViewModel(String title, String desc, String imagePath) {
        this.title = title;
        this.desc = desc;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView,String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }
    public String getImageUrl(){
        return imagePath;
    }
}
