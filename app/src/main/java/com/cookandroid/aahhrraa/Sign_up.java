package com.cookandroid.aahhrraa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(),

                "DEMO_SQLITE.db", null, 1);

        final TextView result = (TextView) findViewById(R.id.result);
        final EditText etName = (EditText) findViewById(R.id.name);
        final EditText etAddress = (EditText) findViewById(R.id.address);
        final EditText etPhone = (EditText) findViewById(R.id.phone);

        // DB에 데이터 추가
        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener(){ // 회원가입
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();

                if (name.length() == 0 ||

                        address.length() == 0 ||

                        phone.length() == 0) {
                    Toast.makeText(getApplicationContext(), "모든 데이터를 입력하세요.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //DB 삽입 -> 결과 출력 -> 입력필드 초기화
                    dbHelper.insert(name, address, phone);
                    Toast.makeText(getApplicationContext(), "데이터 생성",

                            Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etAddress.setText(null);
                    etPhone.setText(null);
                }
            }
        });

    }
}