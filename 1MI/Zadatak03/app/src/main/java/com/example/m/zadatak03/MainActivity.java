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

/*        Jedan način s jednim xml-om u kojemu je set
            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator_set);
                animatorSet.setTarget(ivSlika);
                animatorSet.start();

            }
        });*/

//      Drugi način u kojemu svaki object set ima svoj xml

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                AnimatorSet transp = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transparency_animator);
                transp.setTarget(ivSlika);
                ObjectAnimator rot = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rot_animator);
                rot.setTarget(ivSlika);

                animatorSet2
                        .play(transp)
                        .with(rot);


                animatorSet2.start();

            }
        });

    }
}
