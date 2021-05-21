package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.Fragments.Home;
import com.example.myapplication.Fragments.Lectures;
import com.example.myapplication.Fragments.MetMat_Video;
import com.example.myapplication.Fragments.News;
import com.example.myapplication.Fragments.Message;
import com.example.myapplication.Fragments.Homework;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navigationListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new News()).commit(); // установка дефолтного фрагмента
    }


    // функция обработкаи нажатий на элементы bottom_nav и вызов соответствующих фрагментов
    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.news:
                            selectedFragment = new News();
                            break;
                        case R.id.lectures:
                            selectedFragment = new Lectures();
                            break;
                        case R.id.message:
                            selectedFragment = new Message();
                            break;
                        case R.id.homework:
                            selectedFragment = new Homework();
                            break;
                        case R.id.home:
                            selectedFragment = new Home();
                            break;
                    }
                    try {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    } catch (NullPointerException e) {
                    }
                    return true;
                }
            };

}
