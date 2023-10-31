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

public class InfoActivity extends Activity {

    private String info;
    private int code;

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnSetResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent targetIntent = getIntent();
        Bundle input = targetIntent.getExtras();
        info = input.getString("info");
        code = input.getInt("code", -1);

        Toast.makeText(this, info + " " + code, Toast.LENGTH_LONG).show();

        initViews();

        txtInfo.setText(info + " " + code);

        btnSetResult.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("result", edtInfo.getText().toString());
                        setResult(2, intent);
                        finish();
                    }
                }
        );
    }

    private void initViews() {
        setContentView(R.layout.info_activity);
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
        btnSetResult = findViewById(R.id.btnSetResult);
    }
}
