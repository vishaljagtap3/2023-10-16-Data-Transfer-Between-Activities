package com.bitcodetech.datatransferapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mt("onCreate");

        initViews();

        btnStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //start an activity
                        Intent intent =
                                new Intent(MainActivity.this, InfoActivity.class);

                        intent.putExtra("info", edtInfo.getText().toString());
                        intent.putExtra("code", 1011);

                        //startActivity(intent);
                        startActivityForResult(intent, 1);
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mt("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mt("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    private void initViews() {
        setContentView(R.layout.main_activity);
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
        btnStart = findViewById(R.id.btnStart);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null) {
            Bundle bundle = data.getExtras();
            txtInfo.setText(bundle.getString("result") + " -- " + requestCode + " -- " + resultCode);
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
