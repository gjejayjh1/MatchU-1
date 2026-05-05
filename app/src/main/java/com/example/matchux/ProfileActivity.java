package com.example.matchux;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvNickname, tvEmail, tvBirthdate, tvSex, tvInterests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // 뷰 연결
        tvNickname  = findViewById(R.id.tvNickname);
        tvEmail     = findViewById(R.id.tvEmail);
        tvBirthdate = findViewById(R.id.tvBirthdate);
        tvSex       = findViewById(R.id.tvSex);
        tvInterests = findViewById(R.id.tvInterests);

        // 임시 더미 데이터 (나중에 DB/로그인 연동으로 교체)
        tvNickname.setText("홍길동");
        tvEmail.setText("hong@example.com");
        tvBirthdate.setText("1999-01-01");
        tvSex.setText("남");
        tvInterests.setText("Android, Java, 스터디");

        // 하단 네비게이션
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(R.id.nav_profile);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_my_meeting) {
                startActivity(new Intent(this, MyMeetingActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                return true;
            }
            return false;
        });
    }
}
