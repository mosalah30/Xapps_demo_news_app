package com.example.xapps_demo_news_app.helper.base;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class BindingViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
    }

    public void bind(BaseAdapter adapter) {
        binding.setVariable(BR.adapter, adapter);
        binding.executePendingBindings();
    }

}