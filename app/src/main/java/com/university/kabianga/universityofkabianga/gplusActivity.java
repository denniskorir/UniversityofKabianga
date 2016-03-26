package com.university.kabianga.universityofkabianga;

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

public class gplusActivity extends AppCompatActivity {
    private  WebView mWebview;
    ProgressBar mprogressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gplus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mprogressBar= (ProgressBar) findViewById(R.id.gplusProgressBar);

        mWebview=(WebView) findViewById(R.id.gplusWebview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("https://plus.google.com/communities/102083884560519923546");
        mWebview.setWebViewClient(new kabuwebCllient());


    }
    private class  kabuwebCllient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mprogressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mWebview.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mprogressBar.setVisibility(View.GONE);
        }
    }


}
