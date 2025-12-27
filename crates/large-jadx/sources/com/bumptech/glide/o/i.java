package com.bumptech.glide.o;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* compiled from: FirstFrameAndAfterTrimMemoryWaiter.java */
/* loaded from: classes.dex */
final class i implements k, ComponentCallbacks2 {
    i() {
        super();
    }

    public void onLowMemory() {
        onTrimMemory(20);
    }

    public void a(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onTrimMemory(int i) {
    }
}
