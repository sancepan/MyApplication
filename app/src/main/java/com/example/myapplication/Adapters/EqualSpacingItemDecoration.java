package com.example.myapplication.Adapters;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public class EqualSpacingItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

    // Получаем позицию и количество элементов
        int position = parent.getChildViewHolder(view).getAdapterPosition();
        int itemCount = state.getItemCount();

    // Задаем отступы для элементов (исключаем отступы для заголовка, для последнего задаем отступ снизу, для остальных
    // согласно четности задаем отступ слева + отступы сверху, исключая заголовок
        if(position != 0 && position != 1){
            outRect.top = 10;
            if(position % 2 == 0){
                outRect.left = 30;
                outRect.right = 0;
            } else{
                outRect .right = 0;
                outRect.left = 20;
            }
            if(position == itemCount - 1){
                outRect.bottom = 10;
            }
        }
    }
}
