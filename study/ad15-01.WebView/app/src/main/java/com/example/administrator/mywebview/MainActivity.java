package com.example.administrator.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edturl;
    private Button   btngo;
    private Button   btnprev;
    private WebView  webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 찾기
        edturl  = findViewById(R.id.edturl);
        btngo   = findViewById(R.id.btngo);
        btnprev = findViewById(R.id.btnprev);
        webview = findViewById(R.id.webview);

        //위젯설정

        //버튼 설정
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edturl.getText().toString();
                webview.loadUrl(url);
            }
        });
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.goBack();
            }
        });

        //webview
        //webviewClient 구현 클래스를 이용한 줌인 기능 추가.
        //webview.loadurl(): 사이트 열기
        //webview.goback() : 뒤로가기

        webview.setWebViewClient(new MyWebClient());
        WebSettings settings = webview.getSettings();
        settings.setBuiltInZoomControls(true);

    }
    private class MyWebClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
