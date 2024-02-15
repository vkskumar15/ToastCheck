package com.services.toasty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.services.toastcheck.ToastCheck;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastCheck.simpleToast(this,"vikas");
    }
}