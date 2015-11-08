package com.university.kabianga.universityofkabianga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.os.Handler;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SocialMediaActivity extends AppCompatActivity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList={"Facebook","Twitter","Google +","Youtube","Instagram","Uok News feeds"};
    public static int [] prgmImages={
                                        R.drawable.facebook,
                                        R.drawable.twitter,
                                        R.drawable.gplus,
                                        R.drawable.youtube,
                                        R.drawable.istagram,
                                        R.drawable.feeds};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gv=(GridView) findViewById(R.id.gridSocial);
        gv.setAdapter(new CustomGrid(this, prgmNameList, prgmImages));



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Send intent to SingleViewActivity
                //Intent i = new Intent(getApplicationContext(), SocialMediaActivity.class);

                // Pass image index
                //i.putExtra("id", position);
                // startActivity(i);
                Intent myIntent = null;
                if (position == 0) {
                    myIntent = new Intent(v.getContext(), facebooActivity.class);
                }
                if (position == 1) {
                    myIntent = new Intent(v.getContext(), twitterActivity.class);
                }
                if (position == 2) {
                    myIntent = new Intent(v.getContext(), gplusActivity.class);
                }
                if (position == 3) {
                    myIntent = new Intent(v.getContext(), youtubeActivity.class);
                }
                if (position == 4) {
                    myIntent = new Intent(v.getContext(), instagram2Activity.class);
                }
                if (position == 5) {
                    myIntent = new Intent(v.getContext(), uokfeeds.class);
                }
                startActivity(myIntent);
            }
        });

    }






}
