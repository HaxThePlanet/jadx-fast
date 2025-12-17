package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.o;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class p extends com.google.android.play.core.assetpacks.l<Void> {

    final com.google.android.play.core.assetpacks.t c;
    p(com.google.android.play.core.assetpacks.t t, o o2) {
        this.c = t;
        super(t, o2);
    }

    @Override // com.google.android.play.core.assetpacks.l
    public final void Q1(Bundle bundle, Bundle bundle2) {
        int arr;
        int str;
        boolean obj3;
        boolean obj4;
        super.Q1(bundle, bundle2);
        str = 0;
        if (!t.w(this.c).compareAndSet(true, str)) {
            t.q().e("Expected keepingAlive to be true, but was false.", new Object[str]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.c();
        }
    }
}
