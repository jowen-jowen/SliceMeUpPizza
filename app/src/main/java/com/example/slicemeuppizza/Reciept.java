package com.example.slicemeuppizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Reciept extends AppCompatActivity {
    Button back;
    TextView pizza, crust, toppings, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reciept);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back = findViewById(R.id.btnMakePurchase);

        pizza = findViewById(R.id.pizza);
        crust = findViewById(R.id.pizzaCrust);
        toppings = findViewById(R.id.toppings);
        price = findViewById(R.id.pizzaPrice);

        Intent fetch= getIntent();
        String receivedPizza = fetch.getStringExtra("selectedPizza");
        String receivedCrust = fetch.getStringExtra("selectedCrust");
        String receivedToppings = fetch.getStringExtra("selectedToppings");
        String receivedPrice = fetch.getStringExtra("totalPrice");

        price.setText(receivedPizza);
        crust.setText(receivedCrust);
        toppings.setText(receivedToppings);
        price.setText(receivedPrice);



    }
}