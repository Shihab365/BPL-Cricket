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
import android.widget.ShareActionProvider;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class PlayerListActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    public ShareActionProvider shareActionProvider;
    Intent rateApp;
    InterstitialAd interstitialAd1,interstitialAd2,interstitialAd3,interstitialAd4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        rateApp=new Intent(Intent.ACTION_VIEW);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn1=(Button) findViewById(R.id.dhkid);
        btn2=(Button) findViewById(R.id.comid);
        btn3=(Button) findViewById(R.id.rngid);
        btn4=(Button) findViewById(R.id.sylid);
        btn5=(Button) findViewById(R.id.ctgid);
        btn6=(Button) findViewById(R.id.rajid);
        btn7=(Button) findViewById(R.id.titid);

        interstitialAd1=new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-1818607113375588/9895272408");
        interstitialAd1.loadAd(new AdRequest.Builder().build());
        interstitialAd1.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(PlayerListActivity.this,DhakaActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd2=new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-1818607113375588/1967599356");
        interstitialAd2.loadAd(new AdRequest.Builder().build());
        interstitialAd2.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(PlayerListActivity.this,ComillaActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd3=new InterstitialAd(this);
        interstitialAd3.setAdUnitId("ca-app-pub-1818607113375588/7637485162");
        interstitialAd3.loadAd(new AdRequest.Builder().build());
        interstitialAd3.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(PlayerListActivity.this,RangpurActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        interstitialAd4=new InterstitialAd(this);
        interstitialAd4.setAdUnitId("ca-app-pub-1818607113375588/3506668468");
        interstitialAd4.loadAd(new AdRequest.Builder().build());
        interstitialAd4.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent=new Intent(PlayerListActivity.this,SylhetActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.dhkid)
                {
                    if(interstitialAd1.isLoaded())
                    {
                        interstitialAd1.show();
                    }
                    else
                    {
                        Intent intent=new Intent(PlayerListActivity.this,DhakaActivity.class);
                        startActivity(intent);
                        interstitialAd1.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.comid)
                {
                    if(interstitialAd2.isLoaded())
                    {
                        interstitialAd2.show();
                    }
                    else
                    {
                        Intent intent=new Intent(PlayerListActivity.this,ComillaActivity.class);
                        startActivity(intent);
                        interstitialAd2.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.rngid)
                {
                    if(interstitialAd3.isLoaded())
                    {
                        interstitialAd3.show();
                    }
                    else
                    {
                        Intent intent=new Intent(PlayerListActivity.this,RangpurActivity.class);
                        startActivity(intent);
                        interstitialAd3.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.sylid)
                {
                    if(interstitialAd4.isLoaded())
                    {
                        interstitialAd4.show();
                    }
                    else
                    {
                        Intent intent=new Intent(PlayerListActivity.this,SylhetActivity.class);
                        startActivity(intent);
                        interstitialAd4.loadAd(new AdRequest.Builder().build());
                    }
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayerListActivity.this,ChittagongActivity.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayerListActivity.this,RajshahiActivity.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayerListActivity.this,TitansActivity.class);
                startActivity(intent);
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
            Intent ab=new Intent(PlayerListActivity.this,AboutActivity.class);
            startActivity(ab);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
