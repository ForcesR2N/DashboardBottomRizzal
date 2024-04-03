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

public class FragmentKalkulator1 extends AppCompatActivity {

    TextView shapeText1, resultView1;
    EditText inputParam1;
    ImageView imageParam1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentkalkulator1);

        shapeText1 = findViewById(R.id.shapeName1);
        inputParam1 = findViewById(R.id.inputParam1);
        resultView1 = findViewById(R.id.resultView1);
        imageParam1 = findViewById(R.id.imageParam1);

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape1");
        String image = intent.getStringExtra("image1");

        shapeText1.setText(shape);

        Glide.with(this)
                .load(image)
                .into(imageParam1);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea1(shape);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Kembali ke Fragment_Bangun_Datar
        finish(); // Opsional, tergantung pada kebutuhan aplikasi Anda
    }


    private void calculateArea1(String shape) {
        String inputUser = inputParam1.getText().toString();
        if (!inputUser.isEmpty()) {
            double number = Double.parseDouble(inputUser);
            double area = 0;
            switch (shape) {
                case "Persegi":
                    area = number * number;
                    break;
                case "Lingkaran":
                    area = 3.14 * number * number;
                    break;
                case "Kubus":
                    area = number * number * number;
                    break;
                case "Bola":
                    area = ((double) 4 / 3) * 3.14 * number * number * number;
                    break;
            }
            String resultArea = String.format("%.2f", area);
            resultView1.setText("Hasil: " + resultArea);

        } else {
            resultView1.setText("Masukkan Angka");
        }
    }
}