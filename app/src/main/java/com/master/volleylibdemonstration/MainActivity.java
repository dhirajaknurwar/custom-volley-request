package com.master.volleylibdemonstration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        Button mCustomApiCall = findViewById(R.id.customApiRequest);
        Button mLoadImageFromUrl = findViewById(R.id.loadImage);
        Button mJsonObjRequest = findViewById(R.id.jsonObjRequest);
        mCustomApiCall.setOnClickListener(this);
        mLoadImageFromUrl.setOnClickListener(this);
        mJsonObjRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customApiRequest:
                startActivity(new Intent(MainActivity.this, ShowCustomRequestResponseActivity.class));
                break;
            case R.id.loadImage:
                startActivity(new Intent(MainActivity.this, LoadImageFromURLActivity.class));
                break;
            case R.id.jsonObjRequest:
                startActivity(new Intent(MainActivity.this, JsonObjectRequestActivity.class));
                break;
            default:
                break;
        }
    }
}
