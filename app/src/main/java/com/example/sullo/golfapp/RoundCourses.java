package com.example.sullo.golfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Adaptor.MyAdapter;
import Model.CourseItem;

public class RoundCourses extends AppCompatActivity {

    TextView course;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<CourseItem> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        courses = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String json;
        try {
            InputStream is = getAssets().open("customTees.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            Log.d(json, "this is json");
            String testing;


            for (int i = 0; i < jsonArray.length(); i++) {
                CourseItem courseItem = new CourseItem();
                JSONObject obj = jsonArray.getJSONObject(i);
                courseItem.setCourseName(obj.getString("CourseName"));
                courseItem.setDescription(obj.getString("CourseDescription"));
                courseItem.setID(obj.getString("CourseID"));
                courses.add(courseItem);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


/* testing array to show courses that are hard coded */
//        CourseItem course1 = new CourseItem("Old Conna Golf Club", "Ferndale Road, Oldconnaught, Bray, Co. Wicklow");
//        CourseItem course2 = new CourseItem("Bray Golf Club", "Greystones Road, Bray, Co. Wicklow");
//        CourseItem course3 = new CourseItem("Dun Laoghaire Golf Club", "Ballyman Rd, Enniskerry, Co. Wicklow");


//        for (int i = 0; i < 5; i++) {
//            CourseItem item = new CourseItem(
//                    "Item" + (i+1),
//                    "Description"
//            );
//            courses.add(item);
//        }
//        courses.add(course1);
//        courses.add(course2);
//        courses.add(course3);


        adapter = new MyAdapter(this, courses);
        recyclerView.setAdapter(adapter);
    }
}
