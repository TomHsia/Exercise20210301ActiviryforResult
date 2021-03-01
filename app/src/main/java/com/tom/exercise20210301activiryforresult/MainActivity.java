package com.tom.exercise20210301activiryforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 2031;
    private TextView info2;
    private TextView info1;
    private EditText user1;
    private Button btnA1;
    private Button btnA1finish;
    private View.OnClickListener myListerner;
    private EditText pw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user1 = findViewById(R.id.ed_user1);
        pw1 = findViewById(R.id.ed_pw1);
        info1 = findViewById(R.id.tv_info1);
        info2 = findViewById(R.id.tv_info2);


        btnA1 = findViewById(R.id.btn_a1toa2);
        btnA1finish = findViewById(R.id.btn_a1finish);
        Bundle bundle = new Bundle();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        myListerner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_a1toa2:
                        bundle.putString("user1", user1.getText().toString());
                        bundle.putString("pw1", pw1.getText().toString());
                        intent.putExtras(bundle);
                        startActivityForResult(intent, REQUEST_CODE);
                        break;
                    case R.id.btn_a1finish:
                        finish();
                        break;
                }

            }
        };

        btnA1.setOnClickListener(myListerner);
        btnA1finish.setOnClickListener(myListerner);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String msg3 = bundle.getString("user2", "error & miss user2");
            String msg4 = bundle.getString("pw2", "error & miss pw2");
            info1.setText(msg3);
            info2.setText(msg4);
        }
    }

}