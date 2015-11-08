package com.university.kabianga.universityofkabianga;

import android.os.Bundle;
import android.os.UserHandle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class About_AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__author);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    //@Override
    public void sendMessage(View view) {
        Intent ln =new Intent(this, licenseActivity.class);
        startActivity(ln);
    }
}
