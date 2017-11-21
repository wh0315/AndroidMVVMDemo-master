package io.github.xuyushi.androidmvvmdemo.RecycleDemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.xuyushi.androidmvvmdemo.R;
import io.github.xuyushi.androidmvvmdemo.databinding.ActivityRecycleBinding;

public class RecycleActivity extends AppCompatActivity {

    private ActivityRecycleBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycle);
        mBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_recycle);
        init();

    }

    private void init() {
        List<News> list = getNewsList();
        initRecyclerView(list);
    }

    private void initRecyclerView(final List<News> list) {
        //这里就是对view id 的直接引用,可以直接从id 获取 view 对象
        final RecyclerView recyclerView = mBinding.rvNewsList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final NewsAdapter adapter = new NewsAdapter(list);
        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id, News news) {
                Toast.makeText(RecycleActivity.this, "item"+id, Toast.LENGTH_SHORT).show();
                list.get(id).setContent(list.get(id).getContent()+"\nadd something");
            }

        });
        recyclerView.setAdapter(adapter);
    }

    private List<News> getNewsList() {
        List<News> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            News news = new News("title" + i, "content" + i);
            list.add(news);
        }
        return list;
    }
}
