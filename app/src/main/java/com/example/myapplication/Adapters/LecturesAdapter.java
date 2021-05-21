package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Book;
import com.example.myapplication.DATA.DataLecture;
import com.example.myapplication.R;

public class LecturesAdapter extends  RecyclerView.Adapter{

// Функция присвоения item_lecture всем элементам списка RecycleView
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lecture, parent, false);
        return new LectureHolder(view);
    }

// Функция item_lecture согласно позиции элемента в списке RecycleView
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((LectureHolder) holder).bindView(position);
    }

// функция получения количества элементов списка RecycleView
    @Override
    public int getItemCount() {
        return DataLecture.title.length;
    }

// Создание Холдера для адаптера
    private class LectureHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, info;

// Функция присвоения ссылок на элементы itemView
        public LectureHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            info = (TextView) itemView.findViewById((R.id.info));
            itemView.setOnClickListener(this);
        }

// Функция заполнения itemView согласно позиции элемента в списке
        public void bindView(int position){
            title.setText(DataLecture.title[position]);
            info.setText(DataLecture.info[position]);
        }

// фунция отработки по нажатию на элемен списка (По нажатию мы переходим из фрагмента в активити с PDF файлом лекции, при условии наличия доступа)
        @Override
        public void onClick(View v) {

// Получаем позицию нажатого элемента
            int position = getAdapterPosition();

// Переход в активити
            if( DataLecture.access[position]) {
                Intent intent = new Intent(v.getContext(), Book.class);
            //Создаем ключ для откурытия нужного pdf документа
                intent.putExtra("file",(Integer) position);
                v.getContext().startActivity(intent);
            } else{
                Toast.makeText(v.getContext(), "На данный момент у вас нет доступа к этой лекции", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
