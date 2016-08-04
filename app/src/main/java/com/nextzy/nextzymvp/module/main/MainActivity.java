package com.nextzy.nextzymvp.module.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nextzy.nextzymvp.R;
import com.nextzy.nextzymvp.common.NextzyMvpActivity;

public class MainActivity extends NextzyMvpActivity<MainContractor.Presenter> implements MainContractor.View, View.OnClickListener {
    public static String KEY_MESSAGE = "key_message";

    private Button btnOk;
    private Button btnSave;
    private EditText etMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void createPresenter() {
        MainPresenter.createPresenter(this);
    }

    @Override
    public void bindView() {
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnSave = (Button) findViewById(R.id.btn_save);
        etMessage = (EditText) findViewById(R.id.et_message);
    }

    @Override
    public void setupView() {
        btnOk.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }


    @Override
    public void restoreArgument(Bundle bundle) {
    }

    @Override
    public void initialize() {

    }

    @Override
    public void restoreInstanceState(Bundle savedInstanceState) {
        getPresenter().setMessage(savedInstanceState.getString(KEY_MESSAGE));
    }

    @Override
    public void restoreView() {

    }

    @Override
    public void saveInstanceState(Bundle outState) {
        outState.putString(KEY_MESSAGE, getPresenter().getMessage());
    }

    @Override
    public void onClick(View view) {
        if (view == btnOk) {
            getPresenter().onButtonOkClicked();
        } else if (view == btnSave) {
            String message = etMessage.getText().toString();
            getPresenter().onButtonSaveClicked(message);
        }
    }

    @Override
    public void showToastMessage() {

    }

    @Override
    public void showSavedMessage(String message) {
        Toast.makeText(MainActivity.this, "Message : " + message, Toast.LENGTH_SHORT).show();
    }
}
