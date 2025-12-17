package com.bumptech.glide.o;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* loaded from: classes.dex */
final class i implements com.bumptech.glide.o.k, ComponentCallbacks2 {
    @Override // com.bumptech.glide.o.k
    public void a(Activity activity) {
    }

    @Override // com.bumptech.glide.o.k
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.o.k
    public void onLowMemory() {
        onTrimMemory(20);
    }

    @Override // com.bumptech.glide.o.k
    public void onTrimMemory(int i) {
    }
}
