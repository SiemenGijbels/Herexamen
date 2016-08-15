package com.gijbelssiemen.herexamen.TabFragments;

/**
 * Created by siemengijbels on 8/11/16.
 */

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gijbelssiemen.herexamen.ChromeCustomTabs.CustomTabActivityHelper;
import com.gijbelssiemen.herexamen.ChromeCustomTabs.WebViewFallback;
import com.gijbelssiemen.herexamen.R;

public class TabFragment4 extends Fragment {

    private final String url = "http://subbacultcha.be/signup/";
    private CustomTabsClient mClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_fragment_4, container, false);

        if (mClient != null) {
            mClient.warmup(0);
            CustomTabsSession customTabsSession = getSession();
            customTabsSession.mayLaunchUrl(Uri.parse(url), null, null);
        }

        Button button = (Button) rootView.findViewById(R.id.memberButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                intentBuilder.setToolbarColor(getResources().getColor(R.color.colorLightPrimary));
                intentBuilder.setShowTitle(true);
                intentBuilder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back_black_24dp));
                intentBuilder.setStartAnimations(getActivity(), R.anim.slide_in_right, R.anim.slide_out_left);
                intentBuilder.setExitAnimations(getActivity(), android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                CustomTabActivityHelper.openCustomTab(getActivity(), intentBuilder.build(), Uri.parse(url), new WebViewFallback());
            }
        });

        return rootView;

    }

    private CustomTabsSession getSession() {
        return mClient.newSession(new CustomTabsCallback() {
            @Override
            public void onNavigationEvent(int navigationEvent, Bundle extras) {
                super.onNavigationEvent(navigationEvent, extras);
            }
        });
    }
}
