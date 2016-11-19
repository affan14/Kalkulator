package com.calc.affanmohammad.kalkulator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlus, btnMinus, btnMultiple, btnDivision, btnEquals, btnComma, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Button btnClear;
    private EditText edtResult;
    private static float hasil = 0.0f;
    private HashMap<Integer, Integer> mapAngka;
    private int lastOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // binding dari xml ke java
        edtResult = (EditText) findViewById(R.id.edtBox);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiple = (Button) findViewById(R.id.btnMulti);
        btnDivision = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnComma = (Button) findViewById(R.id.btnComma);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnClear = (Button) findViewById(R.id.btnClear);

        //Action
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiple.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnComma.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);

        edtResult.setText("");

        mapAngka = new HashMap<Integer, Integer>();
        mapAngka.put(R.id.btnOne, 1);
        mapAngka.put(R.id.btnTwo, 2);
        mapAngka.put(R.id.btnThree, 3);
        mapAngka.put(R.id.btnFour, 4);
        mapAngka.put(R.id.btnFive, 5);
        mapAngka.put(R.id.btnSix, 6);
        mapAngka.put(R.id.btnSeven, 7);
        mapAngka.put(R.id.btnEight, 8);
        mapAngka.put(R.id.btnNine, 9);
        mapAngka.put(R.id.btnZero, 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEight:
            case R.id.btnNine:
            case R.id.btnZero:
                displayNumber(view.getId());
                break;
            case R.id.btnPlus:
            case R.id.btnMinus:
            case R.id.btnMulti:
            case R.id.btnDivide:
                doOperation(view.getId());
                break;
            case R.id.btnEquals:
                showResult();
                break;
            case R.id.btnClear:
                edtResult.setText("");
                hasil = 0;
                break;
        }
    }

    private void displayNumber(int id) {
        edtResult.append(String.valueOf(mapAngka.get(id)));
    }

    private void doOperation(int opId) {
        if (opId == R.id.btnPlus) {
            hasil += Float.parseFloat(edtResult.getText().toString());
        } else if (opId == R.id.btnMinus) {
            hasil -= Float.parseFloat(edtResult.getText().toString());
        } else if (opId == R.id.btnMulti) {
            if (hasil == 0)
                hasil = Float.parseFloat(edtResult.getText().toString());
            else
                hasil *= Float.parseFloat(edtResult.getText().toString());
        } else if (opId == R.id.btnDivide) {
            if (hasil == 0 || hasil == 0.0f)
                hasil = Float.parseFloat(edtResult.getText().toString());
            else
                hasil /= Float.parseFloat(edtResult.getText().toString());
        }
        lastOperation = opId;
        edtResult.setText("");
    }

    private void showResult() {
        try {
            if (lastOperation == R.id.btnPlus) {
                hasil += Float.parseFloat(edtResult.getText().toString());
            } else if (lastOperation == R.id.btnMinus) {
                hasil -= Float.parseFloat(edtResult.getText().toString());
            } else if (lastOperation == R.id.btnMulti) {
                hasil *= Float.parseFloat(edtResult.getText().toString());
            } else if (lastOperation == R.id.btnDivide) {
                hasil /= Float.parseFloat(edtResult.getText().toString());
            }
            edtResult.setText(hasil + "");
        } catch (ArithmeticException ex1) {
            new AlertDialog.Builder(this).setMessage("Tidak dapat membagi dengan 0").setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        } catch (Exception ex) {
            new AlertDialog.Builder(this).setMessage("Anda belum melakukan operasi").setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

}
