package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class b1 extends com.google.android.gms.internal.measurement.h1 {

    private final AtomicReference<Bundle> a;
    private boolean b;
    public b1() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
    }

    public static final <T> T p2(Bundle bundle, Class<T> class2) {
        int cast;
        int arr;
        Object obj3;
        cast = 0;
        obj3 = bundle.get("r");
        if (bundle != null && obj3 != null) {
            obj3 = bundle.get("r");
            if (obj3 != null) {
                cast = class2.cast(obj3);
            }
        }
        return cast;
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final void c(Bundle bundle) {
        final AtomicReference atomicReference = this.a;
        this.a.set(bundle);
        this.b = true;
        this.a.notify();
        return;
        synchronized (atomicReference) {
            atomicReference = this.a;
            this.a.set(bundle);
            this.b = true;
            this.a.notify();
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final Bundle m(long l) {
        boolean z;
        final AtomicReference atomicReference = this.a;
        synchronized (atomicReference) {
            this.a.wait(l);
            try {
                return (Bundle)this.a.get();
                throw l;
            } catch (java.lang.InterruptedException interrupted) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.h1
    public final String n(long l) {
        return (String)b1.p2(m(l), String.class);
    }
}
