package com.gijbelssiemen.herexamen.ChromeCustomTabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by siemengijbels on 8/12/16.
 */

public class WebViewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }
}
