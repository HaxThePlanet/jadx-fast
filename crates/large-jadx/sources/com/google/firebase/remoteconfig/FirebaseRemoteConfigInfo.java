package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public interface FirebaseRemoteConfigInfo {
    public abstract com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings getConfigSettings();

    public abstract long getFetchTimeMillis();

    public abstract int getLastFetchStatus();
}
