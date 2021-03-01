package com.tom.exercise20210301activiryforresult;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView info3;
    private TextView info4;
    private EditText user2;
    private EditText pw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info3 = findViewById(R.id.tv_info3);
        info4 = findViewById(R.id.tv_info4);
        user2 = findViewById(R.id.ed_user2);
        pw2 = findViewById(R.id.ed_pw2);


        Bundle bundle = getIntent().getExtras();
        String msg1 = bundle.getString("user1", "error & miss user1");
        String msg2 = bundle.getString("pw1", "error & miss pw1");
        info3.setText(msg1);
        info4.setText(msg2);
//        bundle.putString("text2",user2.getText().toString());
        /*bundle不可放在此處*/

        Button btnA2 = findViewById(R.id.btn_a2toa1);
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                savedInstanceState.putString("user2",user2.getText().toString());
                savedInstanceState.putString("pw2",pw2.getText().toString());
                Intent intent2 = new Intent();
                intent2.putExtras(bundle2);
                錯誤
                */

                /*
                Bundle bundle2 = new Bundle();
                bundle2.putString("text2",user2.getText().toString());
                Intent intent2 = new Intent();
                intent2.putExtras(bundle2);
                錯誤
                */
                /*
                intent 必須使用從MainActivity傳過來的getIntent()
                bundle也必須使用從MainActivity傳過來的getIntent().getExtras()
                MainActivity2回傳資料給MainActivity時，也必須使用上述兩個原本的intent和bundle
                */
                bundle.putString("user2", user2.getText().toString());
                bundle.putString("pw2", pw2.getText().toString());
                getIntent().putExtras(bundle);
                setResult(Activity.RESULT_OK, getIntent());
                finish();
            }
        });
    }
}