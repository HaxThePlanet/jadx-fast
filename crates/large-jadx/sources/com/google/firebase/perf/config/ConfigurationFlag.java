package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
abstract class ConfigurationFlag<T>  {
    protected abstract T getDefault();

    String getDeviceCacheFlag() {
        return null;
    }

    String getMetadataFlag() {
        return null;
    }

    String getRemoteConfigFlag() {
        return null;
    }
}
