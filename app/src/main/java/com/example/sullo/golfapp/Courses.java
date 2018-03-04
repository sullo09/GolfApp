package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Courses extends AppCompatActivity {

    TextView course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        course = (TextView) findViewById(R.id.course);


        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickCourse = new Intent(Courses.this, PlayRound.class);
                startActivity(pickCourse);
            }
        });
    }
}
