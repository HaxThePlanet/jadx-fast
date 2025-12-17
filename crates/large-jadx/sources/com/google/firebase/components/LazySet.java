package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
class LazySet<T>  implements Provider<Set<T>> {

    private volatile Set<T> actualSet = null;
    private volatile Set<Provider<T>> providers;
    LazySet(Collection<Provider<T>> collection) {
        super();
        int i = 0;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.providers = Collections.newSetFromMap(concurrentHashMap);
        this.providers.addAll(collection);
    }

    static com.google.firebase.components.LazySet<?> fromCollection(Collection<Provider<?>> collection) {
        LazySet lazySet = new LazySet((Set)collection);
        return lazySet;
    }

    private void updateSet() {
        Object obj;
        Set actualSet;
        Iterator iterator = this.providers.iterator();
        synchronized (this) {
            try {
                for (Provider next2 : iterator) {
                    this.actualSet.add(next2.get());
                }
                this.actualSet.add((Provider)iterator.next().get());
                this.providers = 0;
                throw th;
            }
        }
    }

    void add(Provider<T> provider) {
        Set actualSet;
        Object obj2;
        synchronized (this) {
            try {
                this.providers.add(provider);
                this.actualSet.add(provider.get());
                throw provider;
            }
        }
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return get();
    }

    public Set<T> get() {
        Set setFromMap;
        if (this.actualSet == null && this.actualSet == null) {
            synchronized (this) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                this.actualSet = Collections.newSetFromMap(concurrentHashMap);
                updateSet();
            }
        }
        try {
            return Collections.unmodifiableSet(this.actualSet);
        }
    }
}
