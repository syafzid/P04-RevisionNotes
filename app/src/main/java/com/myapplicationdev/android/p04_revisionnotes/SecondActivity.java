package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView listView;

	ArrayAdapter aa;
	ArrayList<Note> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();

		//TODO implement the Custom ListView
		listView = findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);
		al = db.getAllNotes();
		db.close();

		for(int i = 0; i < al.size(); i++) {
			Log.d("Stars", i + ". " + al.get(i).getStars());
		}

		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, al);
		listView.setAdapter(aa);
	}


}
