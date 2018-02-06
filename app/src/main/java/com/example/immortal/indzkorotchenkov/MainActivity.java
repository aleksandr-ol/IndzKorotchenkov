package com.example.immortal.indzkorotchenkov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText countET;
    Button submit;
    Spinner spinner;
    TextView resultTV;

    ArrayAdapter<String> SpinerAdapter;
    String[] arrayItems = {"Детралекса", "Флебодиа","Ангистакс","Венорутон","Троксевазин","Репарил",
            "Эскузан","Трентал","Курантил"};
    final int[] actualValues={600 ,720 ,450 ,300 ,130,150,150 ,150,350};
    int thePrice, count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countET = (EditText) findViewById(R.id.count_edit_text);
        spinner = (Spinner) findViewById(R.id.spinner);
        resultTV = (TextView) findViewById(R.id.resultTextView);
        submit = (Button) findViewById(R.id.submitBtn);

        SpinerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arrayItems);
        spinner.setAdapter(SpinerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                thePrice = actualValues[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt(countET.getText().toString());

                resultTV.setText(count + "x " + spinner.getSelectedItem().toString() + " = " + thePrice*count);
            }
        });
    }
}
