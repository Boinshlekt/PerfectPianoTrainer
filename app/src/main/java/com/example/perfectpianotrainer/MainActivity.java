package com.example.perfectpianotrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean changed;
    private ConstraintSet constraintSet1;
    private ConstraintSet constraintSet2;
    private ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changed = false;
        rootLayout = (ConstraintLayout) findViewById(R.id.main);
        constraintSet1 = new ConstraintSet();
        constraintSet1.clone(rootLayout);
        constraintSet2 = new ConstraintSet();
        constraintSet2.clone(rootLayout);
        constraintSet2.connect(R.id.cleff_wrap, ConstraintSet.BOTTOM, R.id.main, ConstraintSet.BOTTOM);

        Button switchView = findViewById(R.id.button1);
        switchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchView();
            }
        });

        boolean changed = false;

    }
    public void switchView() {
        TransitionManager.beginDelayedTransition(rootLayout);
        if(changed) {
            constraintSet1.applyTo(rootLayout);
        } else {
            constraintSet2.applyTo(rootLayout);
        }
        changed = !changed;
    }
}