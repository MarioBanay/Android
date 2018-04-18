package com.example.tm.zadatak02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IView {

    EditText etTekst;
    Button btnInkrement, btnDekrement;

    IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTekst = (EditText)findViewById(R.id.etTekst);
        btnInkrement = (Button)findViewById(R.id.btnInkrement);
        btnDekrement = (Button)findViewById(R.id.btnDekrement);

        presenter = new Presenter(this);

        btnInkrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.increment(etTekst.getText().toString());
            }
        });

        btnDekrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.decrement(etTekst.getText().toString());
            }
        });
    }

    @Override
    public void showResult(String text) {
        etTekst.setText(text);
    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
