package com.example.kmu_regist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    EditText lecture_name, professor_name, limited_people, lecture_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        noticeList.add(new Notice("공지사항입니다.", "임다운", "2020-11-09"));
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);
        final Button add_lecture = (Button) findViewById(R.id.add_lec_btn);

        lecture_name=findViewById(R.id.lectur_name);
        lecture_time=findViewById(R.id.lecture_time);
        limited_people=findViewById(R.id.limited_people);
        professor_name=findViewById(R.id.professor_name);

//        add_lecture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addLec(createRequest());
//            }
//        });

        courseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CourseFragment());
                fragmentTransaction.commit();
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                fragmentTransaction.commit();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();
            }
        });
    }

    public AddlecDataSet createRequest(){
        AddlecDataSet addlecDataSet = new AddlecDataSet();
        addlecDataSet.setLecture_name(lecture_name.getText().toString());
        addlecDataSet.setLecture_time(lecture_time.getText().toString());
        addlecDataSet.setProfessor_name(professor_name.getText().toString());
        addlecDataSet.setLimited_people(limited_people.getText().toString());

        return addlecDataSet;
    }

    public void addLec(AddlecDataSet addlecDataSet) {
        Call<AddlecResponse> addlecResponseCall = LecClient.addlecture().addLec(addlecDataSet);
        addlecResponseCall.enqueue(new Callback<AddlecResponse>() {
            @Override
            public void onResponse(Call<AddlecResponse> call, Response<AddlecResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AddlecResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return;
        }
        Toast.makeText(this, " '뒤로' 버튼을 한번 더 눌러 종료합니다.", Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();
    }
}