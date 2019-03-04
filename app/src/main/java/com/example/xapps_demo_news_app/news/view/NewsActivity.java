package com.example.xapps_demo_news_app.news.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.xapps_demo_news_app.R;
import com.example.xapps_demo_news_app.databinding.ActivityNewsAppBinding;
import com.example.xapps_demo_news_app.news.viewmodel.NewsViewModel;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import static com.example.xapps_demo_news_app.Constants.URL_KEY;

public class NewsActivity extends AppCompatActivity {
    private ActivityNewsAppBinding binding;
    private NewsViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_app);
        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.getNewsList();
        navigateToWebViewActivity();
        subscribeForMessagesError();

    }

    private void navigateToWebViewActivity() {
        viewModel.getArticleSingleLiveEvent().observe(this, article -> {
            if (article != null) {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(URL_KEY, article.getUrl());
                startActivity(intent);
            }
        });
    }

    private void subscribeForMessagesError() {
        viewModel.getErrorMessageEvent().observe(this, messageText -> Toast.makeText(this, messageText, Toast.LENGTH_LONG).show());

    }
}
