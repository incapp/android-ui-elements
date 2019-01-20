package com.incapp.androiduielements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] versions = {
            "Cupcake", "Donut", "Eclairs",
            "Froyo", "Gingerbread", "Honeycomb",
            "Ice-Cream Sandwich", "Jellybean", "Kitkat",
            "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie"
    };

    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grapes", "Kiwi", "Mango", "Pear"};

    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;
    SeekBar seekBar;
    TextView textViewSeekBar;
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        textViewSeekBar = findViewById(R.id.textView_seekBar);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        //AutoCompleteTextView
        autoCompleteTextView.setThreshold(1);   //Minimum characters to show suggestions.
        ArrayAdapter<String> autoCompleteTextViewAdapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        fruits);
        autoCompleteTextView.setAdapter(autoCompleteTextViewAdapter);

        //Spinner
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        versions
                );
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        versions[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    textViewSeekBar.setTextSize(1);
                } else {
                    textViewSeekBar.setTextSize(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //ListView
        ArrayAdapter<String> listViewAdapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        versions
                );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        versions[position], Toast.LENGTH_SHORT).show();
            }
        });

        //Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
