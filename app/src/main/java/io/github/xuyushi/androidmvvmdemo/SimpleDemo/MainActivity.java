package io.github.xuyushi.androidmvvmdemo.SimpleDemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Date;

import io.github.xuyushi.androidmvvmdemo.R;
import io.github.xuyushi.androidmvvmdemo.RecycleDemo.RecycleActivity;
import io.github.xuyushi.androidmvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        mUser = new User("testFirst", "testLast");
        MyHandler myHandler = new MyHandler();
        binding.setHandler(myHandler);
        binding.setUser(mUser);
        binding.setTime(new Date());
    }


    public void changeName(View view) {
        mUser.setFirstName("new FirstName");
        mUser.setLastName("new lastName");
    }

    public void GoNext(View view) {
        Intent intent = new Intent(MainActivity.this, RecycleActivity.class);
        this.startActivity(intent);
    }
}
