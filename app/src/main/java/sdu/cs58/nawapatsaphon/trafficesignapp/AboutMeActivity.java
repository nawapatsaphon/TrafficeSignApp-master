package sdu.cs58.nawapatsaphon.trafficesignapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMeActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }//end onCreate method

    public void clickBack(View view) {
        finish();
    }

    public void playSound(View view) {
        if (mediaPlayer != null) //ตรวสอบว่ามี Obj. mediaplayer เล่นอยู่หรือไม่
        {
            mediaPlayer.stop();//ถ้ามี obj เล่นอยู่ให้หยุดเล่น
            mediaPlayer.release();//คืน resource ที่ mediaplayer เดิมให้กับระบบ
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.koko);
        mediaPlayer.start();
    }

    public void clickFacebook(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/nawapatsaphon.letsitthithaphanya"));
        startActivity(fbIntent);
    }

    public void clickMobile(View view) {
        Intent mobileIntent = new Intent(Intent.ACTION_DIAL);
        mobileIntent.setData(Uri.parse("tel:0908877944"));
        startActivity(mobileIntent);
    }

    public void clickMap(View view) {
        String lat="3.776233";
        String lng="100.510757";
        String label = "มหาวิทยาลัยสวนดุสิต";

        Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:" + lat + "," + lng + "(" + label + ")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        //mapIntent.setPackage("com.google.android.apps.maps");//ใช้เทสบน จีนีโมชั่นไม่ได้
        startActivity(mapIntent);

    }
}//end class
