package com.example.myapplication.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DATA.DataObject;
import com.example.myapplication.Fragments.MetMat_Video;
import com.example.myapplication.R;

// Адапетр для отображения предметов на вкладке "Лекции"
public class ObjectsAdapter extends  RecyclerView.Adapter{

    private Context context;
    private FragmentManager f_manager;

// Конструктор адаптера (f_manager - менеджер фрагментов, для возможности перехода в новый фрагмент по нажатию на элемент списка RecycleView)
    public ObjectsAdapter(Context context, FragmentManager f_manager)
    {
        this.context = context;
        this.f_manager = f_manager;
    }

// Функция для присвоения item_view элементов RecycleView относительно их позиции (условие нужно для возможности добавить заголовок как элемент RecycleView)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v;
        if(viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
        }else if(viewType == 1){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_2, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_object, parent, false);
        }
        return new ObjectsAdapter.ObjectHolder(v);
    }

// Функция получения типа айтема, согласно позиции (для возможности менять каркас айтемов относительно позиции)
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if(position == 1){
            return 1;
        } else{
            return 2;
        }
    }

// Функция заполнения элементов RecycleView значениями
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int type = getItemViewType(position);
        if(type > 1) {
            ((ObjectsAdapter.ObjectHolder) holder).bindView(position);
        }
    }

// Функция получения элементов RecycleView (количество предметов + 2 ячейки для заголовка)
    @Override
    public int getItemCount() {
        return DataObject.nameObj.length + 2;
    }

//  Функция перевода 2 элементов информации тип int, в один типа String, для того, чтобы потом использовать в Холдере
    private String formatValue(int position){
            return String.format("%02d", DataObject.infoNow[position - 2]) + "/" + String.format("%02d", DataObject.infoAll[position - 2]);
    }

// Создаем Холдер
    private class ObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameObj, teacherObj, infoObj;

// Функция присвоения ссылок на элементы айтема
        private ObjectHolder(View itemView) {
            super(itemView);
            nameObj = itemView.findViewById((R.id.nameObj));
            teacherObj = itemView.findViewById((R.id.teacherObj));
            infoObj = itemView.findViewById(R.id.infoObj);
            itemView.setOnClickListener(this);
        }

// Функция заполнения этих элементов
        public void bindView(int position){
            nameObj.setText(DataObject.nameObj[position - 2]);
            teacherObj.setText(DataObject.teacherObj[position - 2]);
            infoObj.setText(formatValue(position));
        }

// Функция отработки нажатия на айтем списка RecycleView
        @Override
        public void onClick(View v) {
        // Получаем позицию нажатого элемента
            int position = getAdapterPosition();

        // Создаем "Сообщение" для передачи в новый фрагмент (Передаем ID предмета из базы данных, для отобажения лекций согласно этому предмету)
            MetMat_Video intent = new MetMat_Video();
            Bundle bundle = new Bundle();
            bundle.putInt("tag", DataObject.ID[position - 2]);
            intent.setArguments(bundle);

        // Переключаемся на новый фрагмент
            if(DataObject.acsess[position - 2]) {
                f_manager.beginTransaction()
                        .replace(R.id.fragment_container, intent)
                        .commit();
            } else{
                Toast.makeText(v.getContext(), "На данный момент у вас нет доступа к этому предмету", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
