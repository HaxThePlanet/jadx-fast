package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class b3<V>  {

    private static final Object h;
    private final String a;
    private final com.google.android.gms.measurement.internal.y2<V> b;
    private final V c;
    private final V d;
    private final Object e;
    private volatile V f = 0;
    private volatile V g = 0;
    static {
        Object object = new Object();
        b3.h = object;
    }

    b3(String string, Object object2, Object object3, com.google.android.gms.measurement.internal.y2 y24, com.google.android.gms.measurement.internal.a3 a35) {
        super();
        Object obj5 = new Object();
        this.e = obj5;
        obj5 = 0;
        this.a = string;
        this.c = object2;
        this.d = object3;
        this.b = y24;
    }

    public final V a(V v) {
        Object obj2;
        boolean next;
        int i;
        Object obj;
        Object obj3 = this.e;
        synchronized (obj3) {
            obj3 = this.e;
        }
        return v;
    }

    public final String b() {
        return this.a;
    }
}
