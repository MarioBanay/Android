package com.example.m.zadatak03;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView ivSlika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        ivSlika = (ImageView) findViewById(R.id.ivSlika);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet transparencyAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transparency_animator);
                transparencyAnimator.setTarget(ivSlika);



                transparencyAnimator.start();

            }
        });
    }
}
