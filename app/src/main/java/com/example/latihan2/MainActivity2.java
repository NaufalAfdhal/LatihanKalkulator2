package com.example.latihan2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {




    private EditText editTextNumber1, editTextNumber2;
    private Spinner spinnerOperation;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi objek
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        spinnerOperation = findViewById(R.id.spinnerOperation);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Adapter untuk spinner operator
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operator_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperation.setAdapter(adapter);

        // Listener untuk tombol Calculate
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            // Ambil nilai dari EditText
            double number1 = Double.parseDouble(editTextNumber1.getText().toString());
            double number2 = Double.parseDouble(editTextNumber2.getText().toString());

            // Ambil operator yang dipilih dari spinner
            String operator = spinnerOperation.getSelectedItem().toString();

            // Hitung hasil
            double result = 0;
            switch (operator) {
                case "Add":
                    result = number1 + number2;
                    break;
                case "Subtract":
                    result = number1 - number2;
                    break;
                case "Multiply":
                    result = number1 * number2;
                    break;
                case "Divide":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        textViewResult.setText(getString(R.string.error_division_by_zero));
                        return;
                    }
                    break;
                // Tambah operasi tambah, kurang, kali, dan bagi
                case "Tambah":
                    result = number1 + number2;
                    break;
                case "Kurang":
                    result = number1 - number2;
                    break;
                case "Kali":
                    result = number1 * number2;
                    break;
                case "Bagi":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        textViewResult.setText(getString(R.string.error_division_by_zero));
                        return;
                    }
                    break;
            }

            // Tampilkan hasil
            textViewResult.setText(getString(R.string.result, result));
        } catch (NumberFormatException e) {
            textViewResult.setText(getString(R.string.error_invalid_input));
        }
    }

}





