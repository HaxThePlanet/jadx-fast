package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.r;
import d.e.b;

/* loaded from: classes2.dex */
public final class y extends com.google.android.gms.common.api.internal.p1 {

    private final b<com.google.android.gms.common.api.internal.c<?>> w;
    private final com.google.android.gms.common.api.internal.g x;
    y(com.google.android.gms.common.api.internal.i i, com.google.android.gms.common.api.internal.g g2, e e3) {
        super(i, e3);
        b obj1 = new b();
        this.w = obj1;
        this.x = g2;
        this.mLifecycleFragment.q("ConnectionlessLifecycleHelper", this);
    }

    public static void i(Activity activity, com.google.android.gms.common.api.internal.g g2, com.google.android.gms.common.api.internal.c<?> c3) {
        com.google.android.gms.common.api.internal.LifecycleCallback yVar;
        Object str;
        com.google.android.gms.common.api.internal.i obj2 = LifecycleCallback.getFragment(activity);
        if ((y)obj2.i0("ConnectionlessLifecycleHelper", y.class) == null) {
            yVar = new y(obj2, g2, e.o());
        }
        r.k(c3, "ApiKey cannot be null");
        yVar.w.add(c3);
        g2.q(yVar);
    }

    private final void k() {
        boolean empty;
        if (!this.w.isEmpty()) {
            this.x.q(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.p1
    protected final void d(b b, int i2) {
        this.x.B(b, i2);
    }

    @Override // com.google.android.gms.common.api.internal.p1
    protected final void e() {
        this.x.t();
    }

    final b<com.google.android.gms.common.api.internal.c<?>> j() {
        return this.w;
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final void onResume() {
        super.onResume();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final void onStart() {
        super.onStart();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final void onStop() {
        super.onStop();
        this.x.r(this);
    }
}
