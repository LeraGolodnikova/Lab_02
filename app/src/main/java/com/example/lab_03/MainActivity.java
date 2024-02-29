package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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



        RadioGroup radioGroup = findViewById(R.id.radiobutton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                adp.clear();
                if (checkedId == R.id.mass)
                {
                    adp.add(new Unit("g", 1000.0));
                    adp.add(new Unit("kg", 1));
                    adp.add(new Unit("cwt", 0.01));
                    adp.add(new Unit("t", 0.001));

                }
                else if (checkedId==R.id.distance)
                {


                    adp.add(new Unit("mm", 1000.0));
                    adp.add(new Unit("cm", 100));
                    adp.add(new Unit("m", 1));
                    adp.add(new Unit("km", 0.001));
                }
                else if (checkedId==R.id.volume)
                {

                    adp.add(new Unit("ml", 1000.0));
                    adp.add(new Unit("l", 1));
                    adp.add(new Unit("m^3", 0.001));

                }
            }
        });



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