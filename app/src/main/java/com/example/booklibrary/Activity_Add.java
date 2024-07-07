package com.example.booklibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Add extends AppCompatActivity {

    EditText input_title, input_author, input_pages;
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve inputs from layout by their id
        input_title = findViewById(R.id.input_title);
        input_author = findViewById(R.id.input_author);
        input_pages = findViewById(R.id.input_pages);

        // Retrieve button from layout by its id
        button_add = findViewById(R.id.button_add_item);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Activity_Add.this);
                myDB.addBook(
                        input_title.getText().toString().trim(),
                        input_author.getText().toString().trim(),
                        Integer.valueOf(input_pages.getText().toString().trim())
                );
            }
        });

    }
}