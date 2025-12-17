package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class GlideErrorListener_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.GlideErrorListener> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.display.internal.GlideErrorListener_Factory INSTANCE;
        static {
            GlideErrorListener_Factory glideErrorListener_Factory = new GlideErrorListener_Factory();
            GlideErrorListener_Factory.InstanceHolder.INSTANCE = glideErrorListener_Factory;
        }

        static com.google.firebase.inappmessaging.display.internal.GlideErrorListener_Factory access$000() {
            return GlideErrorListener_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.display.internal.GlideErrorListener_Factory create() {
        return GlideErrorListener_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.display.internal.GlideErrorListener newInstance() {
        GlideErrorListener glideErrorListener = new GlideErrorListener();
        return glideErrorListener;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.GlideErrorListener get() {
        return GlideErrorListener_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
