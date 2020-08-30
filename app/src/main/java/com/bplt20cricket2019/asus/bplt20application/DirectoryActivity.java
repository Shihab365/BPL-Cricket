package com.bplt20cricket2019.asus.bplt20application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class DirectoryActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    Intent rateApp;
    InterstitialAd interstitialAd1,interstitialAd2,interstitialAd3,interstitialAd4,interstitialAd5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        btn1=(Button) findViewById(R.id.teambuttonid);
        btn2=(Button) findViewById(R.id.schedulebuttonid);
        btn3=(Button) findViewById(R.id.todaybuttonid);
        btn4=(Button) findViewById(R.id.listbuttonid);
        btn5=(Button) findViewById(R.id.livebuttonid);

        interstitialAd1=new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-1818607113375588/8418539203");
        interstitialAd1.loadAd(new AdRequest.Builder().build());
        interstitialAd1.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(DirectoryActivity.this,TeamActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd2=new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-1818607113375588/9146131665");
        interstitialAd2.loadAd(new AdRequest.Builder().build());
        interstitialAd2.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(DirectoryActivity.this,FixtureActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd3=new InterstitialAd(this);
        interstitialAd3.setAdUnitId("ca-app-pub-1818607113375588/2389151620");
        interstitialAd3.loadAd(new AdRequest.Builder().build());
        interstitialAd3.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(DirectoryActivity.this,PredictionActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd4=new InterstitialAd(this);
        interstitialAd4.setAdUnitId("ca-app-pub-1818607113375588/4285930493");
        interstitialAd4.loadAd(new AdRequest.Builder().build());
        interstitialAd4.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(DirectoryActivity.this,PlayerListActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd5=new InterstitialAd(this);
        interstitialAd5.setAdUnitId("ca-app-pub-1818607113375588/1431293172");
        interstitialAd5.loadAd(new AdRequest.Builder().build());
        interstitialAd5.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(DirectoryActivity.this,LivescoreActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.teambuttonid)
                {
                    if(interstitialAd1.isLoaded())
                    {
                        interstitialAd1.show();
                    }
                    else
                    {
                        Intent intent=new Intent(DirectoryActivity.this,TeamActivity.class);
                        startActivity(intent);
                        interstitialAd1.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.schedulebuttonid)
                {
                    if(interstitialAd2.isLoaded())
                    {
                        interstitialAd2.show();
                    }
                    else
                    {
                        Intent intent=new Intent(DirectoryActivity.this,FixtureActivity.class);
                        startActivity(intent);
                        interstitialAd2.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.todaybuttonid)
                {
                    if(interstitialAd3.isLoaded())
                    {
                        interstitialAd3.show();
                    }
                    else
                    {
                        Intent intent=new Intent(DirectoryActivity.this,PredictionActivity.class);
                        startActivity(intent);
                        interstitialAd3.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.listbuttonid)
                {
                    if(interstitialAd4.isLoaded())
                    {
                        interstitialAd4.show();
                    }
                    else
                    {
                        Intent intent=new Intent(DirectoryActivity.this,PlayerListActivity.class);
                        startActivity(intent);
                        interstitialAd4.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.livebuttonid)
                {
                    if(interstitialAd5.isLoaded())
                    {
                        interstitialAd5.show();
                    }
                    else
                    {
                        Intent intent=new Intent(DirectoryActivity.this,LivescoreActivity.class);
                        startActivity(intent);
                        interstitialAd5.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
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
            Intent ab=new Intent(DirectoryActivity.this,AboutActivity.class);
            startActivity(ab);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
