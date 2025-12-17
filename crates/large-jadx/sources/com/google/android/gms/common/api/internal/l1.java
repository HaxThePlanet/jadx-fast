package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.b;
import com.google.android.gms.tasks.k;
import d.e.a;
import d.e.g;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l1 {

    private final a<com.google.android.gms.common.api.internal.c<?>, b> a;
    private final a<com.google.android.gms.common.api.internal.c<?>, String> b;
    private final k<Map<com.google.android.gms.common.api.internal.c<?>, String>> c;
    private int d;
    private boolean e;
    public final Set<com.google.android.gms.common.api.internal.c<?>> a() {
        return this.a.keySet();
    }

    public final void b(com.google.android.gms.common.api.internal.c<?> c, b b2, String string3) {
        boolean obj2;
        Object obj3;
        this.a.put(c, b2);
        this.b.put(c, string3);
        this.d = obj2--;
        if (!b2.n2()) {
            this.e = true;
        }
        if (this.d == 0 && this.e) {
            if (this.e) {
                obj2 = new AvailabilityException(this.a);
                this.c.b(obj2);
            }
            this.c.c(this.b);
        }
    }
}
