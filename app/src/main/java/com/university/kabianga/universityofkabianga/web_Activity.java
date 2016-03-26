package com.university.kabianga.universityofkabianga;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class web_Activity extends AppCompatActivity {
    private  WebView mWebview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

         mWebview=(WebView) findViewById(R.id.webKabianga);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://www.kabianga.ac.ke/main%20campus");
        mWebview.setWebViewClient(new kabuwebCllient());

    }
    private class  kabuwebCllient extends  WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
           // progressBar.setVisibility(View.VISIBLE);
          //view.loadUrl(url);
           mWebview.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
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
