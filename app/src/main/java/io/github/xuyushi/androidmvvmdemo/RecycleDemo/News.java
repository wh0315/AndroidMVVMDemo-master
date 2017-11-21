package io.github.xuyushi.androidmvvmdemo.RecycleDemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import io.github.xuyushi.androidmvvmdemo.BR;

/**
 * Created by xuyushi on 16/3/6.
 */
public class News extends BaseObservable {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
}
