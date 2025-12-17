package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class x1 extends com.google.android.exoplayer2.q0 {

    private final int e = 0;
    private final int f = 0;
    private final int[] g;
    private final int[] h;
    private final com.google.android.exoplayer2.g2[] i;
    private final Object[] j;
    private final HashMap<Object, Integer> k;
    public x1(Collection<? extends com.google.android.exoplayer2.r1> collection, h0 h02) {
        int i;
        int i2;
        HashMap map;
        Object obj;
        int i3;
        int obj7;
        i = 0;
        super(i, h02);
        obj7 = collection.size();
        this.g = new int[obj7];
        this.h = new int[obj7];
        this.i = new g2[obj7];
        this.j = new Object[obj7];
        obj7 = new HashMap();
        this.k = obj7;
        final Iterator obj6 = collection.iterator();
        i2 = obj7;
        while (true) {
            Object next2 = obj6.next();
            this.i[i2] = (r1)next2.a();
            this.h[i2] = i;
            this.g[i2] = obj7;
            i += i4;
            obj7 += i5;
            this.j[i2] = next2.getUid();
            this.k.put(this.j[i2], Integer.valueOf(i2));
            i2 = i3;
        }
    }

    @Override // com.google.android.exoplayer2.q0
    protected int A(int i) {
        return this.h[i];
    }

    @Override // com.google.android.exoplayer2.q0
    protected com.google.android.exoplayer2.g2 D(int i) {
        return this.i[i];
    }

    List<com.google.android.exoplayer2.g2> E() {
        return Arrays.asList(this.i);
    }

    @Override // com.google.android.exoplayer2.q0
    public int i() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.q0
    public int p() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.q0
    protected int s(Object object) {
        int obj2;
        obj2 = this.k.get(object);
        if ((Integer)obj2 == null) {
            obj2 = -1;
        } else {
            obj2 = (Integer)obj2.intValue();
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.q0
    protected int t(int i) {
        final int i2 = 0;
        return p0.g(this.g, i++, i2, i2);
    }

    @Override // com.google.android.exoplayer2.q0
    protected int u(int i) {
        final int i2 = 0;
        return p0.g(this.h, i++, i2, i2);
    }

    @Override // com.google.android.exoplayer2.q0
    protected Object x(int i) {
        return this.j[i];
    }

    @Override // com.google.android.exoplayer2.q0
    protected int z(int i) {
        return this.g[i];
    }
}
