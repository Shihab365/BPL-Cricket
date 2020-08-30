package com.bplt20cricket2019.asus.bplt20application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView txtday1,txthour1,txtmin1,txtsec1;
    Handler handler;
    Runnable runnable;
    Button btn1;
    Intent rateApp;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-1818607113375588/1147920820");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed() {
                                             Intent intent=new Intent(MainActivity.this,DirectoryActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

        btn1=(Button)findViewById(R.id.btnDownload);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnDownload)
                {
                    if(interstitialAd.isLoaded())
                    {
                        interstitialAd.show();
                    }
                    else
                    {
                        Intent intent=new Intent(MainActivity.this,DirectoryActivity.class);
                        startActivity(intent);
                        interstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });

        txtday1=(TextView) findViewById(R.id.txtdayid1);
        txthour1=(TextView) findViewById(R.id.txthourid1);
        txtmin1=(TextView) findViewById(R.id.txtminid1);
        txtsec1=(TextView) findViewById(R.id.txtsecid1);

        countDownStart();
    }
    public void countDownStart()
    {
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
                    Date futureDate = dateFormat.parse("2019-1-5");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long second = diff / 1000;
                        txtday1.setText("" + String.format("%02d", days));
                        txthour1.setText("" + String.format("%02d", hours));
                        txtmin1.setText("" + String.format("%02d", minutes));
                        txtsec1.setText("" + String.format("%02d", second));
                    } else {
                        txtday1.setText("00");
                        txthour1.setText("00");
                        txtmin1.setText("00");
                        txtsec1.setText("00");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,1*1000);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.shareid)
        {
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,"My new app https://play.google.com");
            startActivity(Intent.createChooser(i,"Share Via"));
            return true;
        }
        if(item.getItemId()==R.id.feedbackid)
        {
            rateApp.setData(Uri.parse("https://play.google.com"));
            startActivity(rateApp);
            return true;
        }
        if(item.getItemId()==R.id.aboutid)
        {
            Intent ab=new Intent(MainActivity.this,AboutActivity.class);
            startActivity(ab);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


