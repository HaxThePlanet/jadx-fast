package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class t0 implements Iterator<Map.Entry> {

    private int a = -1;
    private boolean b;
    private Iterator<Map.Entry> c;
    final com.google.android.gms.internal.firebase-auth-api.v0 v;
    t0(com.google.android.gms.internal.firebase-auth-api.v0 v0, com.google.android.gms.internal.firebase-auth-api.o0 o02) {
        this.v = v0;
        super();
        final int obj1 = -1;
    }

    private final Iterator<Map.Entry> b() {
        Iterator iterator;
        if (this.c == null) {
            this.c = v0.i(this.v).entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int empty;
        int i;
        final int i3 = 0;
        if (i2 += i >= v0.g(this.v).size() && !v0.i(this.v).isEmpty() && b().hasNext()) {
            if (!v0.i(this.v).isEmpty()) {
                if (b().hasNext()) {
                }
                return i3;
            }
            i = i3;
        }
        return i;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next;
        int i;
        int i2 = 1;
        this.b = i2;
        i3 += i2;
        this.a = i;
        if (i < v0.g(this.v).size()) {
            next = v0.g(this.v).get(this.a);
        } else {
            next = b().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
        } else {
            this.b = false;
            v0.j(this.v);
            if (this.a < v0.g(this.v).size()) {
                int i3 = this.a;
                this.a = i3 + -1;
                v0.e(this.v, i3);
            }
            b().remove();
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}
