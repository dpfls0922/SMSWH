package com.cookandroid.aahhrraa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class profile extends Fragment implements View.OnClickListener {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button button = view.findViewById(R.id.button_logout);
        button.setOnClickListener(this);
        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_logout:
            {
                Intent intent = new Intent(getActivity(), login.class);
                startActivity(intent);
            }
        }
    }

    public class sublogin extends AppCompatActivity {

        public ArrayList<lloogin> lloginArrayList;

        private void initLoadDB(){
            DataLoginAdapter mDbloginHelper = new DataLoginAdapter(getApplicationContext());
            mDbloginHelper.createDatabase();
            mDbloginHelper.open();

            lloginArrayList = mDbloginHelper.getTableData();

            mDbloginHelper.close();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_profile);

            TextView textname = findViewById(R.id.profile_name);
            TextView textadd = findViewById(R.id.profile_address);
            TextView textpho = findViewById(R.id.profile_phone);

            Intent intent = getIntent();
            String name1 = intent.getExtras().getString("ibib");//ibib

            initLoadDB();

            for(int i=0;i<10;i++){
                if(name1.equals(lloginArrayList.get(i).getLloogin_name())) {
                    textname.setText(lloginArrayList.get(i).getLloogin_name());
                    textadd.setText(lloginArrayList.get(i).getLloogin_address());
                    textpho.setText(lloginArrayList.get(i).getLloogin_phone());

                }
            }
        }

    }

}

