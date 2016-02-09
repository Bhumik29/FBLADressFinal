package com.example.bhumika29.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.File;


public class Main2Activity extends Activity {




    Button button;
    ImageView imageView;
    static final int CAM_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) (findViewById(R.id.camera));
        imageView = (ImageView) (findViewById(R.id.photphot));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_Intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_Intent, CAM_REQUEST);


            }
        });}


    private File getFile()
        {
            File folder = new File("sdcard/camera_app");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File image_file = new File(folder, "cam_image.jpg");
            return image_file;
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path= "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}

