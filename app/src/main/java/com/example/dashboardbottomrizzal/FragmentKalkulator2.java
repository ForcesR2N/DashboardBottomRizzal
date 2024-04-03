package com.example.dashboardbottomrizzal;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FragmentKalkulator2 extends AppCompatActivity {

    TextView shapeText2, resultView2;
    EditText inputParam2_1, inputParam2_2;
    ImageView imageParam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentkalkulator2);

        shapeText2 = findViewById(R.id.shapeName2);
        inputParam2_1 = findViewById(R.id.inputParam2_1);
        inputParam2_2 = findViewById(R.id.inputParam2_2);
        resultView2 = findViewById(R.id.resultView2);
        imageParam2 = findViewById(R.id.imageParam2);

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape2");
        String image = intent.getStringExtra("image2");

        shapeText2.setText(shape);

        Glide.with(this)
                .load(image)
                .into(imageParam2);

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea2(shape);
            }
        });

        Button buttonBack = findViewById(R.id.buttonback1);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    private void calculateArea2(String shape) {
        String inputUser1 = inputParam2_1.getText().toString();
        String inputUser2 = inputParam2_2.getText().toString();
        if (!inputUser1.isEmpty() && !inputUser2.isEmpty()) {
            double number1 = Double.parseDouble(inputUser1);
            double number2 = Double.parseDouble(inputUser2);
            double area = 0;
            switch (shape) {
                case "Persegi Panjang":
                    area = number1 * number2;
                    break;
                case "Segitiga":
                    area = 0.5 * number1 * number2;
                    break;
                case "Kerucut":
                    area = 3.14 * number1 * number1 * (number2 / 3);
                    break;
            }
            String resultArea = String.format("%.2f", area);
            resultView2.setText("Hasil: " + resultArea);

        } else {
            resultView2.setText("Masukkan Angka");
        }
    }
}