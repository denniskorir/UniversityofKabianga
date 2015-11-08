package com.university.kabianga.universityofkabianga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web_Activity extends AppCompatActivity {
    private  WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         mWebview=(WebView) findViewById(R.id.webKabianga);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://uokcu.org");
        mWebview.setWebViewClient(new kabuwebCllient());

    }
    private class  kabuwebCllient extends  WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mWebview.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if((keyCode==KeyEvent.KEYCODE_BACK)&& mWebview.canGoBack()){

           mWebview.goBack();
           return true;
       }
        return onKeyDown(keyCode, event);
    }
}
