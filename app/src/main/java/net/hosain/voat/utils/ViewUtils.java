package net.hosain.voat.utils;

import android.content.res.Resources;


public class ViewUtils {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
