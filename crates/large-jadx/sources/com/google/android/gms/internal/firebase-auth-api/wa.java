package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
abstract class wa<T>  implements Iterator<T> {

    private T a;
    private int b = 2;
    protected wa() {
        super();
        final int i = 2;
    }

    protected abstract T b();

    protected final T c() {
        this.b = 3;
        return 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.b;
        i = 4;
        if (i3 == i) {
        } else {
            i2 = i3 + -1;
            if (i3 == 0) {
            } else {
                int i4 = 1;
                this.b = i;
                this.a = b();
                if (i2 != 0 && i2 != 2 && this.b != 3) {
                    if (i2 != 2) {
                        this.b = i;
                        this.a = b();
                        if (this.b != 3) {
                            this.b = i4;
                            return i4;
                        }
                    }
                    return 0;
                }
                return i4;
            }
            throw 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public final T next() {
        if (!hasNext()) {
        } else {
            this.b = 2;
            this.a = 0;
            return this.a;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.Iterator
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
