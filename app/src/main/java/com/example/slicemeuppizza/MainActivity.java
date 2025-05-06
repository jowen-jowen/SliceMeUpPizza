package com.example.slicemeuppizza;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    RadioButton ham, italian, sm, med, lar, thick, thin;
    Button process;

    CheckBox cheese,mush, onion, tom, pine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Radio Button
        ham = findViewById(R.id.rbHam);
        italian = findViewById(R.id.rbitalian);
        sm = findViewById(R.id.rbSmall);
        med = findViewById(R.id.rbMed);
        lar = findViewById(R.id.rbLar);
        thick = findViewById(R.id.rbThick);
        thin = findViewById(R.id.rbThin);

        //Button
        process = findViewById(R.id.btnProcess);

        //Check Box
        cheese = findViewById(R.id.cbExCheese);
        mush = findViewById(R.id.cbMushrooms);
        onion = findViewById(R.id.cbOnion);
        tom = findViewById(R.id.cbTomato);
        pine = findViewById(R.id.cbPineapple);

        OrderProcessing();
    }

    private void OrderProcessing() {
        final double ITALIAN_SMALL = 100.00;
        final double ITALIAN_MEDIUM = 150.00;
        final double ITALIAN_LARGE = 200.00;

        final double HAM_SMALL = 200.00;
        final double HAM_MEDIUM = 300.00;
        final double HAM_LARGE = 400.00;

        final double TOMATO = 10.00;
        final double ONION = 10.00;
        final double PINEAPPLE = 15.00;
        final double CHEESE = 20.00;
        final double MUSHROOM = 20.00;

        process.setOnClickListener(v -> {
            double pizzaPrice = 0;
            double toppingsPrice =0;

            if(ham.isChecked() ){
                if(sm.isChecked()) {
                    pizzaPrice = HAM_SMALL;
                } else if (med.isChecked()) {
                    pizzaPrice = HAM_MEDIUM;
                } else if (lar.isChecked()) {
                    pizzaPrice = HAM_LARGE;
                }
            } else if (italian.isChecked()) {
                if(sm.isChecked()) {
                    pizzaPrice = ITALIAN_SMALL;
                } else if (med.isChecked()) {
                    pizzaPrice = ITALIAN_MEDIUM;
                } else if (lar.isChecked()) {
                    pizzaPrice = ITALIAN_LARGE;
                }
            }

            double crustType = pizzaPrice;
            if(thick.isChecked()){
                crustType = pizzaPrice * 1.5;
            }


            if(onion.isChecked())
                toppingsPrice +=ONION;
            if (tom.isChecked())
                toppingsPrice += TOMATO;
            if(cheese.isChecked())
                toppingsPrice += CHEESE;
            if(mush.isChecked())
                toppingsPrice += MUSHROOM;
            if(pine.isChecked())
                toppingsPrice += PINEAPPLE;

            double totalPrice = crustType + toppingsPrice;

            Toast.makeText(MainActivity.this, "Total Price of the Pizza is: PHP " + totalPrice, Toast.LENGTH_SHORT).show();
        });
    }

}