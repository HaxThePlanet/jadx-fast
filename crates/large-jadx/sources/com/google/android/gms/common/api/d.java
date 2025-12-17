package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.q;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
@Deprecated
public abstract class d {

    private static final Set<com.google.android.gms.common.api.d> a;

    @Deprecated
    public interface a extends f {
    }

    @Deprecated
    public interface b extends m {
    }
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        d.a = Collections.newSetFromMap(weakHashMap);
    }

    public static Set<com.google.android.gms.common.api.d> c() {
        final Set set = d.a;
        return set;
        synchronized (set) {
            set = d.a;
            return set;
        }
    }

    public <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.i, T extends com.google.android.gms.common.api.internal.e<R, A>> T a(T t) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T b(T t) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public Looper d() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean e(q q) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public void f() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
