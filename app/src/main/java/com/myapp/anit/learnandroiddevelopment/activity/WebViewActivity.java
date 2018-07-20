package com.myapp.anit.learnandroiddevelopment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;
import com.myapp.anit.learnandroiddevelopment.web.MyWebviewClient;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {
    WebView webView;
    EditText editText;
    Button btnStaticContent,btnGo,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView= (WebView) findViewById(R.id.web_view);
        editText= (EditText) findViewById(R.id.edit_text_web);
        btnStaticContent= (Button) findViewById(R.id.btn_static);
        btnGo= (Button) findViewById(R.id.btn_go);
        btnClear= (Button) findViewById(R.id.btn_clear);
        btnStaticContent.setOnClickListener(this);
        btnGo.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        webView.setWebViewClient(new MyWebviewClient(editText));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_static:
                StaticContent();
                break;
            case R.id.btn_go:
                GoUrl();
                break;
            case R.id.btn_clear:
                editText.setText("");
                break;
        }
    }

    private void GoUrl() {
        String url = editText.getText().toString().trim();
        if(url.isEmpty())  {
            Toast.makeText(this,"Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private void StaticContent() {
        String staticContent="<h2>Select web page</h2>"
                + "<ul><li><a href='https://developer.android.com/studio/'>Android Studio</a></li>"
                +"<li><a href='http://google.com'>Google</a></li></ul>";
        webView.loadData(staticContent, "text/html", "UTF-8");
    }
}
