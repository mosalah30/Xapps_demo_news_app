package com.example.xapps_demo_news_app.news.view;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.example.xapps_demo_news_app.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import static com.example.xapps_demo_news_app.Constants.URL_KEY;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);
        intiToolbar();
        intiWebView();

    }

    private void intiToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.article);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }

    private void intiWebView() {
        WebView webView = findViewById(R.id.wv_news);
        if (getIntent().getExtras() != null) {
            String url = getIntent().getExtras().getString(URL_KEY);
            webView.setWebChromeClient(new WebChromeClient());
            webView.loadUrl(url);
        }
    }
}
