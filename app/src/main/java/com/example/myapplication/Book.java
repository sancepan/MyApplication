package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.DATA.DataBook;
import com.github.barteksc.pdfviewer.PDFView;

public class Book extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

// Получаем ключ (позиция названия PDF документа в базе данных)
        Intent file = getIntent();
        int position = file.getIntExtra("file", 2);

// Открываем pdf документ в активити
        book = (PDFView) findViewById(R.id.book);
        book.fromAsset(DataBook.file[position]).load();

    }
}
