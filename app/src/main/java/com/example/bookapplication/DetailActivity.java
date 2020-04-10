package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG="Description";
    private Context context;
    private Bundle extras;
private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context=DetailActivity.this;
         webView=findViewById(R.id.webview);
         extras=getIntent().getExtras();
         if (extras!=null){
             String data=extras.getString("titles");
             Log.d(TAG,"OnCreate: the coming data is"+data);
             String url="file:///android_asset/"+data+".html";
             webView.loadUrl(url);
             WebSettings webSettings=webView.getSettings();
             webSettings.setBuiltInZoomControls(true);
             webSettings.setDisplayZoomControls(false);

         }
    }
}
