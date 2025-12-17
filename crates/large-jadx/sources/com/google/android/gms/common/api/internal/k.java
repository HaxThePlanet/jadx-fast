package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class k {
    public static <L> com.google.android.gms.common.api.internal.j<L> a(L l, Looper looper2, String string3) {
        r.k(l, "Listener must not be null");
        r.k(looper2, "Looper must not be null");
        r.k(string3, "Listener type must not be null");
        j jVar = new j(looper2, l, string3);
        return jVar;
    }
}
