package com.inihood.grandmusic;

import android.app.Application;
import android.os.Build;

import com.inihood.grandmusic.R;
import com.inihood.grandmusic.appshortcuts.DynamicShortcutManager;
import com.kabouzeid.appthemehelper.ThemeStore;

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        // default theme
        if (!ThemeStore.isConfigured(this, 1)) {
            ThemeStore.editTheme(this)
                    .primaryColorRes(R.color.md_blue_grey_700)
                    .accentColorRes(R.color.md_teal_A700)
                    .commit();
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }
    }

    public static App getInstance() {
        return app;
    }
}
