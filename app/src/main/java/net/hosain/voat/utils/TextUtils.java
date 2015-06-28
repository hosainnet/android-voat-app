package net.hosain.voat.utils;

import android.text.Html;

public class TextUtils {

    public static CharSequence FromHtmlTrimmed(String html) {
        return trim(Html.fromHtml(html));
    }

    private static CharSequence trim(CharSequence text) {

        while (text.charAt(text.length() - 1) == '\n') {
            text = text.subSequence(0, text.length() - 1);
        }
        return text;
    }
}
