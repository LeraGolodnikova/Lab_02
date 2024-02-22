package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    EditText number;
    TextView vivod;
    Spinner value1, value2;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);

        ArrayAdapter<Unit> adp = new ArrayAdapter<Unit>(this, android.R.layout.simple_list_item_1);

        adp.add(new Unit("mm", 1000.0));
        adp.add(new Unit("cm", 100));
        adp.add(new Unit("m", 1));
        adp.add(new Unit("km", 0.001));

        number = findViewById(R.id.number);
        vivod = findViewById(R.id.vivod);
        value1.setAdapter(adp);
        value2.setAdapter(adp);

    }
    public void convert_click(View view)
    {
        Unit sfrom = (Unit) value1.getSelectedItem();
        Unit sto = (Unit) value2.getSelectedItem();


        try {
            float from = Float.parseFloat(number.getText().toString());
            double to = from / sfrom.coeff * sto.coeff;

            vivod.setText(String.valueOf(to));
        } catch (NumberFormatException e) {
            vivod.setText("Ошибка ввода числа");
        }

    }
}