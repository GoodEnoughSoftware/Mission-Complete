package com.goodenoughapps.missioncomplete;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addTasksFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwipeStack swipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new SwipeStackAdapter(mData));

        addTasksFAB = (FloatingActionButton) findViewById(R.id.add_task_fab);
        addTasksFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add Task FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
