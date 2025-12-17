package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class pa {

    private static final Iterator<Object> a;
    private static final Iterable<Object> b;
    static {
        na naVar = new na();
        pa.a = naVar;
        oa oaVar = new oa();
        pa.b = oaVar;
    }

    static <T> Iterable<T> a() {
        return pa.b;
    }

    static Iterator b() {
        return pa.a;
    }
}
