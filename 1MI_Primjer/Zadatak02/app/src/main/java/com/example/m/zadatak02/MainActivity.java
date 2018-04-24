package com.example.m.zadatak02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IView {

    EditText etTekst;
    TextView tvTekst;
    Button btnProvjeri;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTekst = findViewById(R.id.etTekst);
        tvTekst = findViewById(R.id.tvTekst);
        btnProvjeri = findViewById(R.id.btnProvjeri);

        presenter = new Presenter(this);

        btnProvjeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.provjeri(etTekst.getText().toString());
            }
        });
    }

    @Override
    public void showResult(String s) {
        tvTekst.setText(s);

    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
