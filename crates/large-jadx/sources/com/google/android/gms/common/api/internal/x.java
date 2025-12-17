package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class x {

    private final Map<com.google.android.gms.common.api.internal.BasePendingResult<?>, Boolean> a;
    private final Map<k<?>, Boolean> b;
    public x() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.a = Collections.synchronizedMap(weakHashMap);
        WeakHashMap weakHashMap2 = new WeakHashMap();
        this.b = Collections.synchronizedMap(weakHashMap2);
    }

    static Map f(com.google.android.gms.common.api.internal.x x) {
        return x.a;
    }

    static Map g(com.google.android.gms.common.api.internal.x x) {
        return x.b;
    }

    private final void h(boolean z, Status status2) {
        Iterator iterator;
        Map next;
        boolean apiException;
        Map booleanValue;
        Map map = this.a;
        HashMap hashMap2 = new HashMap(this.a);
        next = this.b;
        HashMap hashMap = new HashMap(this.b);
        iterator = hashMap2.entrySet().iterator();
        synchronized (map) {
            map = this.a;
            hashMap2 = new HashMap(this.a);
            next = this.b;
            hashMap = new HashMap(this.b);
            iterator = hashMap2.entrySet().iterator();
        }
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z == null) {
            } else {
            }
            (BasePendingResult)(Map.Entry)next.getKey().d(status2);
            if ((Boolean)next.getValue().booleanValue() != null) {
            }
        }
        Iterator iterator2 = hashMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            iterator = iterator2.next();
            if (z == null) {
            } else {
            }
            apiException = new ApiException(status2);
            (k)(Map.Entry)iterator.getKey().d(apiException);
            if ((Boolean)iterator.getValue().booleanValue()) {
            }
        }
    }

    final void a(com.google.android.gms.common.api.internal.BasePendingResult<? extends i> basePendingResult, boolean z2) {
        this.a.put(basePendingResult, Boolean.valueOf(z2));
        s1 obj3 = new s1(this, basePendingResult);
        basePendingResult.a(obj3);
    }

    final <TResult> void b(k<TResult> k, boolean z2) {
        this.b.put(k, Boolean.valueOf(z2));
        t1 t1Var = new t1(this, k);
        k.a().addOnCompleteListener(t1Var);
    }

    final boolean c() {
        boolean empty;
        if (this.a.isEmpty() && !this.b.isEmpty()) {
            if (!this.b.isEmpty()) {
            }
            return 0;
        }
        return 1;
    }

    public final void d() {
        h(false, g.J);
    }

    final void e(int i, String string2) {
        int i2;
        String obj4;
        StringBuilder stringBuilder = new StringBuilder("The connection to Google Play services was lost");
        int i3 = 1;
        if (i == i3) {
            stringBuilder.append(" due to service disconnection.");
        } else {
            if (i == 3) {
                stringBuilder.append(" due to dead object exception.");
            }
        }
        if (string2 != null) {
            stringBuilder.append(" Last reason for disconnect: ");
            stringBuilder.append(string2);
        }
        obj4 = new Status(20, stringBuilder.toString());
        h(i3, obj4);
    }
}
