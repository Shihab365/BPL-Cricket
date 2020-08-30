package com.bplt20cricket2019.asus.bplt20application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ShareActionProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamActivity extends AppCompatActivity {

    public ShareActionProvider shareActionProvider;
    Intent rateApp;

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        rateApp=new Intent(Intent.ACTION_VIEW);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView=(ExpandableListView) findViewById(R.id.explistid);
        initData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listMap);
        listView.setAdapter(listAdapter);
    }
    private void initData()
    {
        listDataHeader=new ArrayList<>();
        listMap=new HashMap<>();

        listDataHeader.add("এক নজরে");
        listDataHeader.add("২০১২ মৌসুম");
        listDataHeader.add("২০১২-১৩ মৌসুম");
        listDataHeader.add("২০১৫-১৬ মৌসুম");
        listDataHeader.add("২০১৬-১৭ মৌসুম");
        listDataHeader.add("২০১৭-১৮ মৌসুম");

        List<String> t1=new ArrayList<>();
        t1.add("প্রথম আসর - ২০১২");
        t1.add("শেষ আসর - ২০১৭");
        t1.add("বর্তমান চ্যাম্পিয়ন - রংপুর রাইডারস");
        t1.add("সর্বোচ্চ রান - মাহমুদুল্লাহ রিয়াদ (১৪০০ রান)");
        t1.add("সর্বোচ্চ উইকেট - সাকিব আল হাসান (৮৩ উইকেট)");

        List<String> t2=new ArrayList<>();
        t2.add("চ্যাম্পিয়ন - ঢাকা গ্ল্যাডিয়েটর");
        t2.add("রানার্স আপ - বরিশাল বার্নারস");
        t2.add("আসরের সেরা খেলোয়াড় - সাকিব আল হাসান (বাংলাদেশ)");

        List<String> t3=new ArrayList<>();
        t3.add("চ্যাম্পিয়ন - ঢাকা গ্ল্যাডিয়েটর");
        t3.add("রানার্স আপ - চিটাগাং কিংস");
        t3.add("আসরের সেরা খেলোয়াড় - সাকিব আল হাসান (বাংলাদেশ)");

        List<String> t4=new ArrayList<>();
        t4.add("চ্যাম্পিয়ন - কুমিল্লা ভিক্টরিয়ান্স");
        t4.add("রানার্স আপ - বরিশাল বুলস");
        t4.add("আসরের সেরা খেলোয়াড় - আসার জাইদি (ইংল্যান্ড)");

        List<String> t5=new ArrayList<>();
        t5.add("চ্যাম্পিয়ন - ঢাকা ডাইনামাইটস");
        t5.add("রানার্স আপ - রাজশাহী কিংস");
        t5.add("আসরের সেরা খেলোয়াড় - মাহমুদুল্লাহ রিয়াদ (বাংলাদেশ)");

        List<String> t6=new ArrayList<>();
        t6.add("চ্যাম্পিয়ন - রংপুর রাইডারস");
        t6.add("রানার্স আপ - ঢাকা ডাইনামাইটস");
        t6.add("আসরের সেরা খেলোয়াড় - ক্রিস গেইল (ওয়েস্ট ইন্ডিজ)");

        listMap.put(listDataHeader.get(0),t1);
        listMap.put(listDataHeader.get(1),t2);
        listMap.put(listDataHeader.get(2),t3);
        listMap.put(listDataHeader.get(3),t4);
        listMap.put(listDataHeader.get(4),t5);
        listMap.put(listDataHeader.get(5),t6);
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
            Intent ab=new Intent(TeamActivity.this,AboutActivity.class);
            startActivity(ab);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
