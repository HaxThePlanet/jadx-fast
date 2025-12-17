package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class ra implements Iterator<Map.Entry> {

    private int a = -1;
    private boolean b;
    private Iterator<Map.Entry> c;
    final com.google.android.gms.internal.measurement.ta v;
    ra(com.google.android.gms.internal.measurement.ta ta, com.google.android.gms.internal.measurement.ma ma2) {
        this.v = ta;
        super();
        final int obj1 = -1;
    }

    private final Iterator<Map.Entry> b() {
        Iterator iterator;
        if (this.c == null) {
            this.c = ta.i(this.v).entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int empty;
        int i;
        final int i3 = 0;
        if (i2 += i >= ta.g(this.v).size() && !ta.i(this.v).isEmpty() && b().hasNext()) {
            if (!ta.i(this.v).isEmpty()) {
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
        if (i < ta.g(this.v).size()) {
            next = ta.g(this.v).get(this.a);
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
            ta.j(this.v);
            if (this.a < ta.g(this.v).size()) {
                int i3 = this.a;
                this.a = i3 + -1;
                ta.e(this.v, i3);
            }
            b().remove();
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        throw illegalStateException;
    }
}
