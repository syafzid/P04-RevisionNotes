package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnInsert, btnShowList;

    int selectedID, stars;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNote);
        radioGroup = findViewById(R.id.radioGroupStars);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = editText.getText().toString();
                selectedID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedID);
                stars = Integer.parseInt(radioButton.getText().toString());
                Log.i("info", content + " " + stars);

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertNote(content, stars);
                db.close();

                Toast toast = Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT);
                toast.show();

                editText.setText("");
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
