package com.university.kabianga.universityofkabianga;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList={"Website","Student Portal","Calendar","Time Table","Events","Contacts","Feedbak","Campus News","Social Media","Map"};
    public static int [] prgmImages={
            R.drawable.school1,
            R.drawable.university,
            R.drawable.calendar,
            R.drawable.school,
            R.drawable.events,
            R.drawable.contacts,
            R.drawable.three115,
            R.drawable.test1,
            R.drawable.users6,
            R.drawable.university2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        gv=(GridView) findViewById(R.id.gridMain);
        gv.setAdapter(new CustomGrid(this, prgmNameList, prgmImages));



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent myIntent = null;
                if (position == 0) {
                    myIntent = new Intent(v.getContext(), web_Activity.class);
                }
                if (position == 1) {
                    myIntent = new Intent(v.getContext(), ChristianActivity.class);
                }
                if (position == 2) {
                    myIntent = new Intent(v.getContext(), gplusActivity.class);
                }
                if (position == 3) {
                        myIntent =new Intent(v.getContext(),LoginActivity.class);


                }
                if (position == 4) {
                    myIntent = new Intent(v.getContext(), instagram2Activity.class);
                }
                if (position == 5) {
                    myIntent = new Intent(v.getContext(), contactsActivity.class);
                }
                if (position == 6) {
                    myIntent = new Intent(v.getContext(), instagram2Activity.class);
                }
                if (position == 7) {
                    myIntent = new Intent(v.getContext(), Campus_newsActivity.class);
                }
                if (position == 8) {
                    myIntent = new Intent(v.getContext(), SocialMediaActivity.class);
                }
                if (position == 9) {
                    myIntent = new Intent(v.getContext(), MapsActivity.class);
                }

                startActivity(myIntent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Log in", Snackbar.LENGTH_LONG)
                //     .setAction("Action", null).show();

                Intent logintent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logintent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_timeTable) {
            //
        } else if (id == R.id.nav_grades) {

        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_news) {
            // opening the news
            Intent social_intent= new Intent(MainActivity.this,Campus_newsActivity.class);
            startActivity(social_intent);

        }
        else if (id == R.id.nav_contacts) {

        }
        else if (id == R.id.nav_website) {
            // opening the university website
            Intent uokWebsite= new Intent(MainActivity.this, web_Activity.class);
            startActivity(uokWebsite);


        }
        else if (id == R.id.nav_social) {
            // opening the social media links activity
            Intent social_intent= new Intent(MainActivity.this,SocialMediaActivity.class);
            startActivity(social_intent);

        }
        else if (id == R.id.nav_map) {
            // opening the location of kabianga activity
            Intent map_intent= new Intent(MainActivity.this, MapsActivity.class);
            startActivity(map_intent);

        }
        else if (id == R.id.nav_reset_password) {

        }
        else if (id == R.id.nav_feedback) {

        }else if (id == R.id.nav_about) {

           // opening about the author activity
            Intent intent= new Intent(MainActivity.this, About_AuthorActivity.class);
            startActivity(intent);



        } else if (id == R.id.nav_login) {
            // opening the login activity
            Intent log_intent= new Intent(MainActivity.this, LoginActivity.class);
            startActivity(log_intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
