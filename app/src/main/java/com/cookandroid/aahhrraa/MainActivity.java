package com.cookandroid.aahhrraa;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀네비게이션 뷰
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Home fragment1;
    private List fragment2;
    private Like fragment3;
    private profile fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.swing_more);
        Button btn2= findViewById(R.id.frandimal_more);
        Button btn3= findViewById(R.id.cocomong_more);
        Button btn4= findViewById(R.id.redcar_more);
        Button btn5= findViewById(R.id.racingcar_more);
        Button btn6= findViewById(R.id.camera_more);
        Button btn7= findViewById(R.id.jazz_more);
        Button btn8= findViewById(R.id.basketball_more);
        Button btn9= findViewById(R.id.cut_fruit_more);
        Button btn10= findViewById(R.id.turtle_more);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","swing");
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","frandimal");
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","cocomong");
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","redcar");
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","racing_car");
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","camera");
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","jazz");
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","basketball");
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","cut_fruit");
                startActivity(intent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), subinfo.class);
                intent.putExtra("ibid","turtle");
                startActivity(intent);
            }
        });


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.list:
                        setFrag(1);
                        break;
                    case R.id.like:
                        setFrag(2);
                        break;
                    case R.id.profile:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });

        fragment1 = new Home();
        fragment2 = new List();
        fragment3 = new Like();
        fragment4 = new profile();

        setFrag(0); // 첫화면 설정
    }

    // 프래그먼트 교체가 일어나는 메서드
    private void setFrag(int n) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (n) {
            case 0:
                transaction.replace(R.id.frameLayout, fragment1);
                transaction.commit();
                break;
            case 1:
                transaction.replace(R.id.frameLayout, fragment2);
                transaction.commit();
                break;
            case 2:
                transaction.replace(R.id.frameLayout, fragment3);
                transaction.commit();
                break;
            case 3:
                transaction.replace(R.id.frameLayout, fragment4);
                transaction.commit();
                break;
        }
    }
}