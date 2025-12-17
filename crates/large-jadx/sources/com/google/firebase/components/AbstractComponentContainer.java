package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class AbstractComponentContainer implements com.google.firebase.components.ComponentContainer {
    public <T> T get(Class<T> class) {
        Provider obj1 = getProvider(class);
        if (obj1 == null) {
            return 0;
        }
        return obj1.get();
    }

    public <T> Set<T> setOf(Class<T> class) {
        return (Set)setOfProvider(class).get();
    }
}
