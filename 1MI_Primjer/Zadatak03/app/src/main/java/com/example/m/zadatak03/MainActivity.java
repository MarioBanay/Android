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

        btn = findViewById(R.id.btn);
        ivSlika = findViewById(R.id.ivPic);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AnimatorSet animatorSet = new AnimatorSet();
                AnimatorSet diagon = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.diagonal_animator);
                diagon.setTarget(ivSlika);

                ObjectAnimator hide = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.hide_animator);
                hide.setTarget(btn);

                ObjectAnimator show = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.show_animator);
                show.setTarget(btn);

                animatorSet
                        .play(diagon)
                        .with(hide)
                        .before(show);

                animatorSet.start();

            }
        });

    }
}
