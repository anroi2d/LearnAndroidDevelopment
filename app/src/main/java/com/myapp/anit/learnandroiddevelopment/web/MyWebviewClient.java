package com.myapp.anit.learnandroiddevelopment.web;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MyWebviewClient extends WebViewClient {
    private EditText editText;
    public MyWebviewClient(EditText addressBar) {
        this.editText=addressBar;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i("MyLog","Click on any interlink on webview that time you got url :-" + url);
        editText.setText(url);
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.i("MyLog", "Your current url when webpage loading.." + url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Log.i("MyLog", "Your current url when webpage loading.. finish" + url);
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }
}
