package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class r implements Iterator<String> {

    final Iterator<String> a;
    final com.google.android.gms.measurement.internal.s b;
    r(com.google.android.gms.measurement.internal.s s) {
        this.b = s;
        super();
        this.a = s.j2(s).keySet().iterator();
    }

    @Override // java.util.Iterator
    public final String b() {
        return (String)this.a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Remove not supported");
        throw unsupportedOperationException;
    }
}
