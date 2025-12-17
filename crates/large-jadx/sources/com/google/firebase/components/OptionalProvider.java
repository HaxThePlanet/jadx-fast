package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
class OptionalProvider<T>  implements Provider<T>, Deferred<T> {

    private static final Provider<Object> EMPTY_PROVIDER;
    private static final Deferred.DeferredHandler<Object> NOOP_HANDLER;
    private volatile Provider<T> delegate;
    private Deferred.DeferredHandler<T> handler;
    static {
        OptionalProvider.NOOP_HANDLER = m.a;
        OptionalProvider.EMPTY_PROVIDER = l.a;
    }

    private OptionalProvider(Deferred.DeferredHandler<T> deferred$DeferredHandler, Provider<T> provider2) {
        super();
        this.handler = deferredHandler;
        this.delegate = provider2;
    }

    static void a(Provider provider) {
    }

    static Object b() {
        return null;
    }

    static void c(Deferred.DeferredHandler deferred$DeferredHandler, Deferred.DeferredHandler deferred$DeferredHandler2, Provider provider3) {
        deferredHandler.handle(provider3);
        deferredHandler2.handle(provider3);
    }

    static <T> com.google.firebase.components.OptionalProvider<T> empty() {
        OptionalProvider optionalProvider = new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER);
        return optionalProvider;
    }

    static <T> com.google.firebase.components.OptionalProvider<T> of(Provider<T> provider) {
        OptionalProvider optionalProvider = new OptionalProvider(0, provider);
        return optionalProvider;
    }

    public T get() {
        return this.delegate.get();
    }

    void set(Provider<T> provider) {
        if (this.delegate != OptionalProvider.EMPTY_PROVIDER) {
        } else {
            this.handler = 0;
            this.delegate = provider;
            this.handler.handle(provider);
            return;
            synchronized (this) {
                this.handler = 0;
                this.delegate = provider;
                this.handler.handle(provider);
            }
        }
        IllegalStateException obj3 = new IllegalStateException("provide() can be called only once.");
        throw obj3;
    }

    public void whenAvailable(Deferred.DeferredHandler<T> deferred$DeferredHandler) {
        Provider i;
        Object eMPTY_PROVIDER;
        com.google.firebase.components.n nVar;
        Provider delegate = this.delegate;
        eMPTY_PROVIDER = OptionalProvider.EMPTY_PROVIDER;
        if (delegate != eMPTY_PROVIDER) {
            deferredHandler.handle(delegate);
        }
        i = 0;
        final Provider delegate2 = this.delegate;
        synchronized (this) {
            i = delegate2;
            if (i != null) {
            }
        }
        deferredHandler.handle(delegate2);
    }
}
