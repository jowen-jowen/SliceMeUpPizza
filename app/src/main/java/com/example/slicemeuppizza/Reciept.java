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
    TextView pizza, crust, toppings, price, toppingsPrice, pizzaPrice;
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
        pizzaPrice = findViewById(R.id.pizzaPrice);
        crust = findViewById(R.id.pizzaCrust);
        toppings = findViewById(R.id.toppings);
        toppingsPrice = findViewById(R.id.toppingsPrice);
        price = findViewById(R.id.totalPrice);

        Intent fetch= getIntent();
        String receivedPizza = fetch.getStringExtra("selectedPizza");
        String receivedPizzaPrice = fetch.getStringExtra("pizzaPrice");
        String receivedCrust = fetch.getStringExtra("selectedCrust");
        String receivedToppings = fetch.getStringExtra("selectedToppings");
        String receivedToppingsPrice = fetch.getStringExtra("toppingsPrice");
        String receivedPrice = fetch.getStringExtra("totalPrice");

        pizza.setText("Pizza Type: " + receivedPizza);
        pizzaPrice.setText("Pizza Price: " + receivedPizzaPrice);
        crust.setText("Type of Crust: " + receivedCrust);
        toppings.setText("Toppings:\n" + receivedToppings);
        toppingsPrice.setText("Total Toppings Price: " + receivedToppingsPrice);
        price.setText("Total Price: " + receivedPrice);



        back.setOnClickListener(v -> {
            Intent intent = new Intent(Reciept.this, MainActivity.class);
            startActivity(intent);
            finish();
        });



    }
}