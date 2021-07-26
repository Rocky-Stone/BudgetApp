package com.example.budget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //TODO: change this to be saveable
    private double balance = 965.21;
    private double foodBudget = 100.00;
    private double freeBudget = 75.00;
    private double foodBudgetDefualt = 100.00;
    private double freeBudgetDefualt = 75.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String balanceString = String.valueOf(balance);
//        String foodBudgetString = String.valueOf(foodBudget);
//        String freeBudgetString = String.valueOf(freeBudget);
        ((TextView) findViewById(R.id.balance_textView)).setText("Balance: $" + balance);
        ((TextView) findViewById(R.id.foodBudget_textView)).setText("Food Budget: $" + foodBudget);
        ((TextView) findViewById(R.id.freeBudget_textView)).setText("Free Budget: $" + freeBudget);
    }

    public void updateBalance(View view) {
        String input = ((EditText) findViewById(R.id.balance_textBox)).getText().toString();
        balance = Double.valueOf(input);
        ((TextView) findViewById(R.id.balance_textView)).setText("Balance: $" + balance);
        ((TextView) findViewById(R.id.balance_textBox)).setText("");
        Log.d("info", "balance successfully updated");
        Toast.makeText(this, "Balance Updated", Toast.LENGTH_LONG).show();
    }

    public void budgetAdd(View view) {
        switch(view.getId()) {
            case R.id.foodAdd_button:
                foodBudget += Double.valueOf(((EditText) findViewById(R.id.foodBudget_textBox)).getText().toString());
                ((TextView) findViewById(R.id.foodBudget_textView)).setText("Food Budget: $" + foodBudget);
                ((EditText) findViewById(R.id.foodBudget_textBox)).setText("");
                break;
            case R.id.freeAdd_button:
                freeBudget += Double.valueOf(((EditText) findViewById(R.id.freeBudget_textBox)).getText().toString());
                ((TextView) findViewById(R.id.freeBudget_textView)).setText("Free Budget: $" + freeBudget);
                ((EditText) findViewById(R.id.freeBudget_textBox)).setText("");
                break;
            default:
                Log.d("warning", "???");
        }
    }

    public void budgetExpense(View view) {
        switch(view.getId()) {
            case R.id.foodExpense_button:
                foodBudget -= Double.valueOf(((EditText) findViewById(R.id.foodBudget_textBox)).getText().toString());
                updateBudgets();
                ((EditText) findViewById(R.id.foodBudget_textBox)).setText("");
                break;
            case R.id.freeExpense_button:
                freeBudget -= Double.valueOf(((EditText) findViewById(R.id.freeBudget_textBox)).getText().toString());
                updateBudgets();
                ((EditText) findViewById(R.id.freeBudget_textBox)).setText("");
                break;
            default:
                Log.d("warning", "???");
        }
    }

    public void updateBudgets() {
        ((TextView) findViewById(R.id.freeBudget_textView)).setText("Free Budget: $" + freeBudget);
        ((TextView) findViewById(R.id.foodBudget_textView)).setText("Food Budget: $" + foodBudget);
    }

    public void save(View view) {
        //TODO
    }

    public void reset(View view) {
        foodBudget = foodBudgetDefualt;
        freeBudget = freeBudgetDefualt;
        updateBudgets();
    }
}