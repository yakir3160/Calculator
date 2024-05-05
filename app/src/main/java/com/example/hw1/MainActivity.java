package com.example.hw1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hw1.R;

public class MainActivity extends AppCompatActivity {
    Spinner Operation;
    EditText Number1, Number2;
    Button Calculate;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operation = findViewById(R.id.Operation);
        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        Calculate = findViewById(R.id.Calculate);
        Result = findViewById(R.id.textViewResult);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculateResult() {
        try {
            int num1 = Integer.parseInt(Number1.getText().toString());
            int num2 = Integer.parseInt(Number2.getText().toString());
            double result = 0;

            String operation = Operation.getSelectedItem().toString();

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = (double) num1 / num2;
                    break;
                case "^":
                    result = (int) Math.pow(num1, num2);
                    break;
            }
            if (result % 1 == 0)
                Result.setText("Result: " + (int) result);
            else
                Result.setText("Result: " + String.format("%.3f", result));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Only whole numbers should be entered", Toast.LENGTH_SHORT).show();
        }
    }
}
