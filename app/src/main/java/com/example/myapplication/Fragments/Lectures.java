package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.EqualSpacingItemDecoration;
import com.example.myapplication.Adapters.ObjectsAdapter;
import com.example.myapplication.R;

public class Lectures extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lectures, container, false);

    // Задаем отступы для RecycleView
        RecyclerView recyclerView = v.findViewById(R.id.objcts);
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration());

    // Задаем адаптер и менеджер для RecycleView
        recyclerView.setAdapter(new ObjectsAdapter(getContext(), getFragmentManager()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return v;
    }
}