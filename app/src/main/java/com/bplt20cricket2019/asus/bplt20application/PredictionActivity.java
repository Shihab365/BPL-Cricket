package com.bplt20cricket2019.asus.bplt20application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class PredictionActivity extends AppCompatActivity {

    public ShareActionProvider shareActionProvider;
    Intent rateApp;
    Button btn1;
    EditText editText1;
    TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn1=(Button) findViewById(R.id.checkbuttonid);
        editText1=(EditText) findViewById(R.id.edittextid);
        textView1=(TextView) findViewById(R.id.resultid);
        textView2=(TextView) findViewById(R.id.viewtextid);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().equals(""))
                {
                    Toast.makeText(PredictionActivity.this, "আপনার পছন্দের দলের নাম লিখুন", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    textView2.setText(editText1.getText());
                    textView1.setText(generateString(2)+""+"%");
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
            Intent ab=new Intent(PredictionActivity.this,AboutActivity.class);
            startActivity(ab);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private String generateString(int length)
    {
        char[] chars="১২৩৪৫৬৭৮৯০".toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<length;i++)
        {
            char c=chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
