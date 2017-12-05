package com.example.radek.zaliczenie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText etWithMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        ViewGroup linearLayout = findViewById(R.id.llSecondActivity);
        Button bt = new Button(this);
        bt.setText(getString(R.string.btn_send));
        bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setOnClickListener(view -> OnButtonPressed());
        linearLayout.addView(bt);
        etWithMessage = findViewById(R.id.etWithMessage);
    }

    private void OnButtonPressed() {
        if (validate(etWithMessage.getText().toString())) {
            showFirstActivityWithResult();
        } else {
            etWithMessage.setError(getString(R.string.msg_erroe));
        }
    }

    private void showFirstActivityWithResult() {
        Intent intent = new Intent();
        intent.putExtra(Const.KEY_SEND_MESSAGE, etWithMessage.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private boolean validate(String s) {
        return s.length() != 0;
    }
}
