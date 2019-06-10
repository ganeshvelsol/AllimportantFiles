package gif.ganesh.pushnotififirebase.workingWithDrawing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import gif.ganesh.pushnotififirebase.R;

public class SecondImage extends AppCompatActivity
{
    ImageView image_view;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_image);

        image_view=findViewById(R.id.image_view);

        b=getIntent().getExtras();
        String ss=b.getString("strings");
        byte [] encodeByte= Base64.decode(ss, Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        image_view.setImageBitmap(bitmap);
    }
}
