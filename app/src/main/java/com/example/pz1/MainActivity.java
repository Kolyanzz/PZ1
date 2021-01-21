package com.example.pz1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_TIME);
    }

    private final String KEY_CALCULYATOR = "Calculyator";
    private Calculyator calculyator = new Calculyator();
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonComma;
    private Button buttonEqual;
    private Button buttonChangeSing;
    private Button buttonClearAll;
    private Button buttonClearOne;
    private Button buttonUmn;
    private Button buttonDiv;
    private Button buttonPlus;
    private Button buttonMinus;
    private TextView textViewShowResult;
    private TextView textViewEnterNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_CALCULYATOR, calculyator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculyator = savedInstanceState.getParcelable(KEY_CALCULYATOR);
        setShowResultText();
    }


    private void initView() {
        findView();
//        setClicklisteners();
    }


    private void setClicklisteners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonChangeSing.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonClearOne.setOnClickListener(this);
        buttonUmn.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        textViewShowResult.setOnClickListener(this);
        textViewEnterNumbers.setOnClickListener(this);
    }

    private void findView() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonComma = findViewById(R.id.buttonComma);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonChangeSing = findViewById(R.id.buttonChangeSing);
        buttonClearAll = findViewById(R.id.buttonClearAll);
        buttonClearOne = findViewById(R.id.buttonClearOne);
        buttonUmn = findViewById(R.id.buttonUmn);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        textViewShowResult = findViewById(R.id.textViewShowResult);
        textViewEnterNumbers = findViewById(R.id.textViewEnterNumbers);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button0):
                setNumber(R.id.button0);
                break;
            case (R.id.button1):
                setNumber(R.id.button1);
                break;
            case (R.id.button2):
                setNumber(R.id.button2);
                break;
            case (R.id.button3):
                setNumber(R.id.button3);
                break;
            case (R.id.button4):
                setNumber(R.id.button4);
                break;
            case (R.id.button5):
                setNumber(R.id.button5);
                break;
            case (R.id.button6):
                setNumber(R.id.button6);
                break;
            case (R.id.button7):
                setNumber(R.id.button7);
                break;
            case (R.id.button8):
                setNumber(R.id.button8);
                break;
            case (R.id.button9):
                setNumber(R.id.button9);
                break;
            case (R.id.buttonComma):
                setNumber(R.id.buttonComma);
                break;
            case (R.id.buttonEqual):
                setNumber(R.id.buttonEqual);
                break;
            case (R.id.buttonChangeSing):
                setNumber(R.id.buttonChangeSing);
                break;
            case (R.id.buttonClearAll):
                setNumber(R.id.buttonClearAll);
                break;
            case (R.id.buttonClearOne):
                setNumber(R.id.buttonClearOne);
                break;
            case (R.id.buttonUmn):
                setNumber(R.id.buttonUmn);
                break;
            case (R.id.buttonDiv):
                setNumber(R.id.buttonDiv);
                break;
            case (R.id.buttonPlus):
                setNumber(R.id.buttonPlus);
                break;
            case (R.id.buttonMinus):
                setNumber(R.id.buttonMinus);
                break;
        }
    }

    private void setShowResultText() {
        textViewShowResult.setText(calculyator.getStringResult());
        textViewEnterNumbers.setText(calculyator.getStringFirstNumber());
    }

    String getViewText(int id) {
        if (id == R.id.button0) {
            return (String) button0.getText();
        } else if (id == R.id.button1) {
            return (String) button1.getText();
        } else if (id == R.id.button2) {
            return (String) button2.getText();
        } else if (id == R.id.button3) {
            return (String) button3.getText();
        } else if (id == R.id.button4) {
            return (String) button4.getText();
        } else if (id == R.id.button5) {
            return (String) button5.getText();
        } else if (id == R.id.button6) {
            return (String) button6.getText();
        } else if (id == R.id.button7) {
            return (String) button7.getText();
        } else if (id == R.id.button8) {
            return (String) button8.getText();
        } else if (id == R.id.button9) {
            return (String) button9.getText();
        } else if (id == R.id.buttonComma) {
            return (String) buttonComma.getText();
        } else if (id == R.id.buttonEqual) {
            return (String) buttonEqual.getText();
        } else if (id == R.id.buttonChangeSing) {
            return (String) buttonChangeSing.getText();
        } else if (id == R.id.buttonClearAll) {
            return (String) buttonClearAll.getText();
        } else if (id == R.id.buttonClearOne) {
            return (String) buttonClearOne.getText();
        } else if (id == R.id.buttonUmn) {
            return (String) buttonUmn.getText();
        } else if (id == R.id.buttonDiv) {
            return (String) buttonDiv.getText();
        } else if (id == R.id.buttonPlus) {
            return (String) buttonPlus.getText();
        } else if (id == R.id.buttonMinus) {
            return (String) buttonMinus.getText();
        } else {
            return "";
        }
    }

    private void setNumber(int buttonId) {
        calculyator.setNumber(getViewText(buttonId));
        setShowResultText();
    }

    private void setComma() {
        calculyator.setComma(true);
        setShowResultText();
    }

    private void setEqual() {
        calculyator.setEqual();
        setShowResultText();
    }

    private void setChangeSing() {
        calculyator.setChangeSing();
        setShowResultText();
    }

    private void cleatAll() {
        calculyator.cleatAll();
        setShowResultText();
    }

    private void clearOne() {
        calculyator.clearOne();
        setShowResultText();
    }

    private void setSing(int buttonId) {
        calculyator.setSign(getViewText(buttonId));
        setShowResultText();
    }
}