package com.example.radek.zaliczenie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;
    private TextView tvShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvShowMessage = findViewById(R.id.tvShowMessage);
        Button btnGetMessage = findViewById(R.id.btnGetMessage);
        btnGetMessage.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_RESULT_CODE && resultCode == RESULT_OK) {
            showMessage(data);
        }
    }

    private void showMessage(@NonNull Intent data) {
        tvShowMessage.setText(data.getStringExtra(Const.KEY_SEND_MESSAGE));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetMessage:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
                break;
        }
    }
}
