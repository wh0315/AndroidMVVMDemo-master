package io.github.xuyushi.androidmvvmdemo.SimpleDemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by xuyushi on 16/3/5.
 */
public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(io.github.xuyushi.androidmvvmdemo.BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(io.github.xuyushi.androidmvvmdemo.BR.lastName);
    }
}