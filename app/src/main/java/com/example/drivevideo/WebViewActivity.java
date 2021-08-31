package com.example.drivevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView wv_drive;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wv_drive = findViewById(R.id.wv_drive);
        String frameVideo = "https://drive.google.com/file/d/1CJwyboPZGTS28kyaaiSaj7-molVtyqRo";
        wv_drive.loadUrl(frameVideo);
        wv_drive.setWebViewClient(new Client());

        WebSettings webSettings = wv_drive.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Add this
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        wv_drive.clearCache(true);
        wv_drive.clearHistory();
        wv_drive.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                DownloadManager.Request dm=new DownloadManager.Request(Uri.parse(s));
                dm.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
            }
        });

    }

    private static class Client extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);


        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {
            view.loadUrl(request);
            return true;

        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
