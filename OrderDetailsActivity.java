package com.example.slicemeuppizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {

    TextView OsPizzaType;
    TextView OsPizzaSize;
    TextView OsCrustType;
    TextView OsToppings;
    TextView OsTotal;
    TextView OsNum;
    Button bExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        OsPizzaType = findViewById(R.id.OsPizzaType);
        OsPizzaSize = findViewById(R.id.OsPizzaSize);
        OsCrustType = findViewById(R.id.OsCrustType);
        OsToppings = findViewById(R.id.OsToppings);
        OsTotal = findViewById(R.id.OsTotal);
        OsNum = findViewById(R.id.OsNum);
        bExit = findViewById(R.id.bExit);


        Intent intent = getIntent();


        String pizzaType = intent.getStringExtra("pizzaType");
        String pizzaSize = intent.getStringExtra("pizzaSize");
        String crustType = intent.getStringExtra("crustType");
        ArrayList<String> toppingsList = intent.getStringArrayListExtra("toppings");

        OsPizzaType.setText("Pizza Type: " + pizzaType);
        OsPizzaSize.setText("Size: " + pizzaSize);
        OsCrustType.setText("Crust: " + crustType);

        StringBuilder toppingsText = new StringBuilder("Toppings: ");
        if (toppingsList != null && !toppingsList.isEmpty()) {
            for (int i = 0; i < toppingsList.size(); i++) {
                toppingsText.append(toppingsList.get(i));
                if (i < toppingsList.size() - 1) {
                    toppingsText.append(", ");
                }
            }
        } else {
            toppingsText.append("None");
        }
        OsToppings.setText(toppingsText.toString());

        double total = calculateTotal(pizzaType, pizzaSize, crustType, toppingsList);
        String formattedTotal = String.format("₱%.2f", total);
        OsNum.setText(formattedTotal);
        OsTotal.setText("Total: ");


        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }


    private double calculateTotal(String pizzaType, String pizzaSize, String crustType, ArrayList<String> toppings) {
        double basePrice = 0;


        if (pizzaType.equalsIgnoreCase("Ham & Cheese")) {
            basePrice = 200.00;
        } else if (pizzaType.equalsIgnoreCase("Italian Pizza")) {
            basePrice = 250.00;
        }


        if (pizzaSize.equalsIgnoreCase("Small")) {
            basePrice += 50.00;
        } else if (pizzaSize.equalsIgnoreCase("Medium")) {
            basePrice += 100.00;
        } else if (pizzaSize.equalsIgnoreCase("Large")) {
            basePrice += 150.00;
        }

        if (crustType.equalsIgnoreCase("Thick")) {
            basePrice += 20.00;
        } else if (crustType.equalsIgnoreCase("Thin")) {
            basePrice += 15.00;
        }


        if (toppings != null) {
            basePrice += toppings.size() * 10.00;
        }

        return basePrice;
    }
}