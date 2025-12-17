package com.google.android.datatransport.runtime.backends;

/* loaded from: classes.dex */
public abstract class g {

    public static enum a {

        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD;
    }
    public static com.google.android.datatransport.runtime.backends.g a() {
        b bVar = new b(g.a.FATAL_ERROR, -1, obj3);
        return bVar;
    }

    public static com.google.android.datatransport.runtime.backends.g d() {
        b bVar = new b(g.a.INVALID_PAYLOAD, -1, obj3);
        return bVar;
    }

    public static com.google.android.datatransport.runtime.backends.g e(long l) {
        b bVar = new b(g.a.OK, l, obj3);
        return bVar;
    }

    public static com.google.android.datatransport.runtime.backends.g f() {
        b bVar = new b(g.a.TRANSIENT_ERROR, -1, obj3);
        return bVar;
    }

    public abstract long b();

    public abstract com.google.android.datatransport.runtime.backends.g.a c();
}
