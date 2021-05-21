package com.example.myapplication.Fragments.Tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.LecturesAdapter;
import com.example.myapplication.R;

public class MetMatTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.metmat_tab, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.lectures);

    // Задаем адаптер и менеджер для RecycleView
        recyclerView.setAdapter(new LecturesAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}

