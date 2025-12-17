package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

/* loaded from: classes2.dex */
public class h implements Comparable<com.google.android.exoplayer2.upstream.cache.h> {

    public final String a;
    public final long b;
    public final long c;
    public final boolean v = false;
    public final File w;
    public final long x;
    public h(String string, long l2, long l3, long l4, File file5) {
        super();
        this.a = string;
        this.b = l2;
        this.c = l4;
        int obj1 = obj8 != null ? 1 : obj1;
        obj1 = 0;
        this.w = obj8;
        this.x = obj6;
    }

    @Override // java.lang.Comparable
    public int a(com.google.android.exoplayer2.upstream.cache.h h) {
        int obj5;
        if (!this.a.equals(h.a)) {
            return this.a.compareTo(h.a);
        }
        obj5 = Long.compare(i, i2);
        obj5 = obj5 == null ? 0 : obj5 < 0 ? -1 : 1;
        return obj5;
    }

    @Override // java.lang.Comparable
    public boolean c() {
        return z ^= 1;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((h)object);
    }

    @Override // java.lang.Comparable
    public boolean e() {
        int i;
        i = Long.compare(l, i2) == 0 ? 1 : 0;
        return i;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(44);
        stringBuilder.append("[");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append(this.c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
