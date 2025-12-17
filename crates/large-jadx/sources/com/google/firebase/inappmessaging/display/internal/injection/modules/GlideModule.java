package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.c;
import com.bumptech.glide.k;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

/* loaded from: classes2.dex */
@Module
public class GlideModule {
    @Provides
    k providesGlideRequestManager(Application application, GlideErrorListener glideErrorListener2) {
        return c.t(application).a(glideErrorListener2);
    }
}
