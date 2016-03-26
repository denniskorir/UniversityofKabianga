package com.university.kabianga.universityofkabianga;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ChristianActivity extends AppCompatActivity {
    private  WebView mWebview;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christian);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = (ProgressBar) findViewById(R.id.portalProgressBar);
        mWebview=(WebView) findViewById(R.id.PortalView);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://portal.kabianga.ac.ke/");
        mWebview.setWebViewClient(new kabuwebCllient());


    }
    private class  kabuwebCllient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mWebview.loadUrl(url);
            progressBar.setVisibility(View.VISIBLE);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
    @Override
    public void  onBackPressed(){
        if(mWebview.canGoBack())
            mWebview.goBack();
        else
            super.onBackPressed();
    }
}
