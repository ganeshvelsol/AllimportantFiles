package gif.ganesh.pushnotififirebase.workingWithDrawing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import gif.ganesh.pushnotififirebase.R;
import android.view.MotionEvent;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class WorkingWithDrawing extends AppCompatActivity
{
    ImageView drawingImageview;
    Paint paint;
    Bitmap originalBitmap , image;
    //PaintView paintView;
    PaintView  paintView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        paintView=new PaintView(this);
        setContentView(paintView);





//        paintView = new PaintView(this);
//        setContentView(paintView);
//        paintView.requestFocus();
//        //setContentView(R.layout.activity_working_with_drawing);
//        //inintParams();
//
//        perfromDataLogics();
    }



    public void perfromDataLogics()
    {


        try
        {
            paintView.setDrawingCacheEnabled(true);
            //Bitmap bitmap = paintView.getDrawingCache();

            //code for reading the mage from the paint view and converting into bitmap
            Bitmap snapshot = Bitmap.createBitmap(paintView.getDrawingCache());


            //code for converting the bitmap image into string
//            ByteArrayOutputStream baos=new  ByteArrayOutputStream();
//            snapshot.compress(Bitmap.CompressFormat.PNG,100, baos);
//            byte [] b=baos.toByteArray();
//            String temp= Base64.encodeToString(b, Base64.DEFAULT);
//
//            Intent ss=new Intent(this,SecondImage.class);
//            ss.putExtra("strings",temp);
//            startActivity(ss);

            //code for converting the string value to bitmap

//                 byte [] encodeByte=Base64.decode(temp,Base64.DEFAULT);
//                 Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);



//                 File f = null;
//                 if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//                     File file = new File(Environment.getExternalStorageDirectory(),"TTImages_cache");
//                     if(!file.exists()){
//                         file.mkdirs();
//                     }
//                     f = new File(file.getAbsolutePath()+file.separator+ "filename"+".png");
//                 }
//                 FileOutputStream ostream = new FileOutputStream(f);
//                 bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
//                 ostream.close();

        }catch (Exception e)
        {


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
               // this.finish();
                paintView.setDrawingCacheEnabled(true);
                Bitmap snapshot = Bitmap.createBitmap(paintView.getDrawingCache());


                //code for converting the bitmap image into string
                ByteArrayOutputStream baos=new  ByteArrayOutputStream();
                snapshot.compress(Bitmap.CompressFormat.PNG,100, baos);
                byte [] b=baos.toByteArray();
                String temp= Base64.encodeToString(b, Base64.DEFAULT);
                Intent ss=new Intent(this,SecondImage.class);
                ss.putExtra("strings",temp);
                startActivity(ss);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inintParams()
    {
        drawingImageview=findViewById(R.id.drawing_imageview);

//to get screen width and hight
        DisplayMetrics displaymetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//dimentions x,y of device to create a scaled bitmap having similar dimentions to screen size
        int height1 = displaymetrics.heightPixels;
        int width1 = displaymetrics.widthPixels;
//paint object to define paint properties
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setTextSize(25);
//loading bitmap from drawable
        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ffff);
////scaling of bitmap
        originalBitmap =Bitmap.createScaledBitmap(originalBitmap, width1, height1, false);
//creating anoter copy of bitmap to be used for editing
        image = originalBitmap.copy(Bitmap.Config.RGB_565, true);


        drawingImageview.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                String user_text= "i";
                //et_sample.getText().toString();
                //gettin x,y cordinates on screen touch
                float scr_x=event.getRawX();
                float scr_y=event.getRawY();
                //funtion called to perform drawing
                createImage(scr_x,scr_y,user_text);
                return true;
            }
        });
    }

    public Bitmap createImage(float scr_x,float scr_y,String user_text)
    {
        //canvas object with bitmap image as constructor
        Canvas canvas = new Canvas(image);
        int viewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
//removing title bar hight
        scr_y=scr_y- viewTop;
//fuction to draw text on image. you can try more drawing funtions like oval,point,rect,etc...
        canvas.drawText(""+user_text, scr_x, scr_y, paint);
        drawingImageview.setImageBitmap(image);
        return image;
    }
}
