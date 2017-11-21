package io.github.xuyushi.androidmvvmdemo.SimpleDemo;

import android.databinding.BindingConversion;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuyushi on 16/3/7.
 */
public class ConvertUtil {
    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
