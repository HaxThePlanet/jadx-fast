package com.google.android.play.core.internal;

import java.io.InputStream;

/* loaded from: classes2.dex */
public final class m1 extends com.google.android.play.core.internal.l1 {

    private final com.google.android.play.core.internal.l1 a;
    private final long b;
    private final long c;
    public m1(com.google.android.play.core.internal.l1 l1, long l2, long l3) {
        super();
        this.a = l1;
        long obj1 = f(l2);
        this.b = obj1;
        this.c = f(obj1 += obj4);
    }

    private final long f(long l) {
        int obj4;
        int i = 0;
        if (Long.compare(l, i) < 0) {
            return i;
        }
        if (Long.compare(l, l2) > 0) {
            obj4 = this.a.a();
        }
        return obj4;
    }

    @Override // com.google.android.play.core.internal.l1
    public final long a() {
        return l -= l2;
    }

    @Override // com.google.android.play.core.internal.l1
    protected final InputStream c(long l, long l2) {
        long obj2 = f(this.b);
        return this.a.c(obj2, l2);
    }

    @Override // com.google.android.play.core.internal.l1
    public final void close() {
    }
}
