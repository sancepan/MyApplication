package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;



public class MyManager extends GridLayoutManager {
    public MyManager(Context context, int spanCount) {
        super(context, spanCount);
    }
}
