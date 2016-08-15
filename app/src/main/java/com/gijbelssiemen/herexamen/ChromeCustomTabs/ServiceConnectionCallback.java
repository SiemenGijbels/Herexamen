package com.gijbelssiemen.herexamen.ChromeCustomTabs;

import android.support.customtabs.CustomTabsClient;

/**
 * Created by siemengijbels on 8/12/16.
 */

public interface ServiceConnectionCallback {
    /**
     * Called when the service is connected.
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected.
     */
    void onServiceDisconnected();
}
