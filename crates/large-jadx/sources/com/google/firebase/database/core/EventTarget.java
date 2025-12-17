package com.google.firebase.database.core;

/* loaded from: classes2.dex */
public interface EventTarget {
    public abstract void postEvent(Runnable runnable);

    public abstract void restart();

    public abstract void shutdown();
}
