package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes2.dex */
public interface ComponentContainer {
    public abstract <T> T get(Class<T> class);

    public abstract <T> Deferred<T> getDeferred(Class<T> class);

    public abstract <T> Provider<T> getProvider(Class<T> class);

    public abstract <T> Set<T> setOf(Class<T> class);

    public abstract <T> Provider<Set<T>> setOfProvider(Class<T> class);
}
