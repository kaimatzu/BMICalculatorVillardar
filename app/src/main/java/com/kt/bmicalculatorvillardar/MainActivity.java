package com.kt.bmicalculatorvillardar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateListenerMethod();
    }

    public void calculateListenerMethod() {
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // GET weight
                EditText weightEditText = (EditText) findViewById(R.id.weightEditText);
                String str_weight = weightEditText.getText().toString();
                double weight = Double.parseDouble(str_weight);

                // GET height
                EditText heightEditText = (EditText) findViewById(R.id.heightEditText);
                String str_height = heightEditText.getText().toString();
                double height = Double.parseDouble(str_height);

                // CALCULATE BMI
                double BMI = weight / Math.pow(height, 2);
                EditText bmiEditText = (EditText) findViewById(R.id.bmiEditText);
                bmiEditText.setText(Double.toString(BMI));

                String BMI_Cat;
                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                EditText classEditText = (EditText) findViewById(R.id.classEditText);
                classEditText.setText(BMI_Cat);
            }
        });
    }
}