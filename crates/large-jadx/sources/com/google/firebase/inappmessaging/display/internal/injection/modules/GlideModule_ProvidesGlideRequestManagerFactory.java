package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.k;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import j.a.a;

/* loaded from: classes2.dex */
public final class GlideModule_ProvidesGlideRequestManagerFactory implements Factory<k> {

    private final a<Application> applicationProvider;
    private final a<GlideErrorListener> glideErrorListenerProvider;
    private final com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule module;
    public GlideModule_ProvidesGlideRequestManagerFactory(com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule glideModule, a<Application> a2, a<GlideErrorListener> a3) {
        super();
        this.module = glideModule;
        this.applicationProvider = a2;
        this.glideErrorListenerProvider = a3;
    }

    public static com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule_ProvidesGlideRequestManagerFactory create(com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule glideModule, a<Application> a2, a<GlideErrorListener> a3) {
        GlideModule_ProvidesGlideRequestManagerFactory glideModule_ProvidesGlideRequestManagerFactory = new GlideModule_ProvidesGlideRequestManagerFactory(glideModule, a2, a3);
        return glideModule_ProvidesGlideRequestManagerFactory;
    }

    public static k providesGlideRequestManager(com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule glideModule, Application application2, GlideErrorListener glideErrorListener3) {
        return (k)Preconditions.checkNotNull(glideModule.providesGlideRequestManager(application2, glideErrorListener3), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public k get() {
        return GlideModule_ProvidesGlideRequestManagerFactory.providesGlideRequestManager(this.module, (Application)this.applicationProvider.get(), (GlideErrorListener)this.glideErrorListenerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
