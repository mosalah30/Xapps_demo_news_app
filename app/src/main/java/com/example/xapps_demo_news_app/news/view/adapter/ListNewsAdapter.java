package com.example.xapps_demo_news_app.news.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.xapps_demo_news_app.R;
import com.example.xapps_demo_news_app.helper.base.BaseAdapter;
import com.example.xapps_demo_news_app.helper.base.BindingViewHolder;
import com.example.xapps_demo_news_app.news.CustomItemClickListener;
import com.example.xapps_demo_news_app.news.model.Articles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.NonNull;

public class ListNewsAdapter extends BaseAdapter {

    private List<Articles> articlesList;
    private CustomItemClickListener<Articles> onItemClickListener;

    public ListNewsAdapter(List<Articles> articlesList, CustomItemClickListener<Articles> onItemclickListener) {
        this.articlesList = articlesList;
        this.onItemClickListener = onItemclickListener;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Articles articles = articlesList.get(position);
        TextView textView = holder.itemView.findViewById(R.id.tv_time);
        String s=articles.getPublishedat().replace('Z',' ');
        String timeFormat = setDateFormat(s);
       textView.setText(timeFormat);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    protected Object getObjForPosition(int position) {
        return articlesList.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_news;
    }

    public void onItemClicked(View v, Articles articles) {
        onItemClickListener.onItemClick(v, articles);
    }

    @Override
    public int getItemCount() {
        return articlesList == null ? 0 : articlesList.size();
    }

    private  String setDateFormat(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
                Locale.getDefault());
        try {
            Date startDate = format.parse(dateString);

            format = new SimpleDateFormat("HH:mm a", Locale.getDefault());
            return format.format(startDate);

        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

}
