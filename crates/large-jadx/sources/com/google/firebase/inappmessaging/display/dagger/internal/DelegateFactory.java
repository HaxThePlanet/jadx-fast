package com.google.firebase.inappmessaging.display.dagger.internal;

import j.a.a;

/* loaded from: classes2.dex */
public final class DelegateFactory<T>  implements com.google.firebase.inappmessaging.display.dagger.internal.Factory<T> {

    private a<T> delegate;
    public static <T> void setDelegate(a<T> a, a<T> a2) {
        Preconditions.checkNotNull(a2);
        if (a.delegate != null) {
        } else {
            a.delegate = a2;
        }
        IllegalStateException obj1 = new IllegalStateException();
        throw obj1;
    }

    public T get() {
        a delegate = this.delegate;
        if (delegate == null) {
        } else {
            return delegate.get();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    a<T> getDelegate() {
        return (a)Preconditions.checkNotNull(this.delegate);
    }

    @Deprecated
    public void setDelegatedProvider(a<T> a) {
        DelegateFactory.setDelegate(this, a);
    }
}
