package com.incapp.androiduielements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {

    String url = "https://www.google.co.in";

    WebView webView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        button = findViewById(R.id.button);

        //WebView
        webView.setWebViewClient(new WebViewClient());  //For browser like settings.
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //Enable JavaScript settings.
        webSettings.setBuiltInZoomControls(true);   //Enable Zoom controls.
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.loadUrl(url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebViewActivity.this, DateTimeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
