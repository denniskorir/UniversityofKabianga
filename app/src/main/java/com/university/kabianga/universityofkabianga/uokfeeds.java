package com.university.kabianga.universityofkabianga;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class uokfeeds extends AppCompatActivity {
    private  WebView mWebview;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uokfeeds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgressBar = (ProgressBar) findViewById(R.id.feedsProgressBar);


        //final ProgressDialog pd= ProgressDialog.show(MainActivity.this, "", "Please wait, Loading Page..",true);
        mWebview=(WebView) findViewById(R.id.feedsWebview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://www.magazinereel.com/category/campus-life/kabianga/");
        mWebview.setWebViewClient(new kabuwebCllient());

    }
    private class  kabuwebCllient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mWebview.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressBar.setVisibility(View.GONE);
        }
    }



}
