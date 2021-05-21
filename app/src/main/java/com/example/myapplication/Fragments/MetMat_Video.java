package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Fragments.Tabs.MetMatTab;
import com.example.myapplication.Fragments.Tabs.VideoTab;
import com.example.myapplication.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

// Фрагмент с метадическими материалами и лекциями разбитые по вкладкам Tab
public class MetMat_Video extends Fragment {

    public void onBackPressed() {
            new Lectures();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_met_mat__video, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    // Инициализируем адаптер
        MyTabPagerAdapter tabPager = new MyTabPagerAdapter(getChildFragmentManager());

    // Присваеваем адаптер viewPager-у
        ViewPager viewPager = getView().findViewById(R.id.viewpager);
        viewPager.setAdapter(tabPager);

    // Отображаем фрагмент во ViewPager согласно вкладке Tab
        TabLayout tabLayout = getView().findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    //Получаем значение из предыдущего фрагмента
        Bundle bundle = getArguments();
        if (bundle != null) {
            Integer recieveInfo = bundle.getInt("tag");
        }
    }

// Адапетр вкладок Tab
    static class MyTabPagerAdapter extends FragmentPagerAdapter {

    // Название вкладок
        private String tabTitles[] = new String[] { "МетМат", "Видео" };

    // Конструктор Адаптера
        MyTabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

    // Получаем количество вкладок
        @Override
        public int getCount() {
            return 2;
        }

    // Функция возвращающая фрагмент согласно выбранной вкладке
        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new MetMatTab();
                case 1:
                    return new VideoTab();
                default:
                    return null;
            }
        }

    // Функция генерирующая заголовок в зависимости от позиции
        @Override public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
