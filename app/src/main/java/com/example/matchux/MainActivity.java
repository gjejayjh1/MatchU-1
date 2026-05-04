package com.example.matchux;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ListView studyListView;
    Button createButton;

    String[] studies = {
            "첫번째 스터디 방",
            "두번째 스터디 방"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyListView = findViewById(R.id.studyListView);
        createButton = findViewById(R.id.createButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                studies
        );
        studyListView.setAdapter(adapter);

        createButton.setOnClickListener(v -> {
            Toast.makeText(this, "스터디방 생성", Toast.LENGTH_SHORT).show();
        });

        // 하단 네비게이션 바
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(R.id.nav_home); // 현재 홈 선택 상태

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true; // 현재 화면이므로 그냥 유지
            } else if (id == R.id.nav_my_meeting) {
                startActivity(new Intent(this, MyMeetingActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }
}
