package com.google.firebase.inject;

import com.google.firebase.annotations.DeferredApi;

/* loaded from: classes2.dex */
public interface Deferred<T>  {

    public interface DeferredHandler {
        public abstract void handle(com.google.firebase.inject.Provider<T> provider);
    }
    public abstract void whenAvailable(com.google.firebase.inject.Deferred.DeferredHandler<T> deferred$DeferredHandler);
}
