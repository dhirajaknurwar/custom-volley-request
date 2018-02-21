package com.master.volleylibdemonstration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class LoadImageFromURLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_image_from_url_activity);
        initViewAndLoadImage();
    }

    private void initViewAndLoadImage() {
        final NetworkImageView mMyPicImageView = findViewById(R.id.myPicImageView);
        ImageLoader mImageLoader = RequestQueueSingleton.getInstance(getApplicationContext()).getImageLoader();

        mImageLoader.get(ApiConstants.MY_PIC_IMAGE_URL, ImageLoader.getImageListener(mMyPicImageView,
                R.mipmap.ic_launcher, android.R.drawable
                        .ic_dialog_alert));
        mMyPicImageView.setImageUrl(ApiConstants.MY_PIC_IMAGE_URL, mImageLoader);
    }
}
