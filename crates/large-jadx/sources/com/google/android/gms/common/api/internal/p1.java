package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import f.c.a.d.b.e.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class p1 extends com.google.android.gms.common.api.internal.LifecycleCallback implements DialogInterface.OnCancelListener {

    protected volatile boolean a;
    protected final AtomicReference<com.google.android.gms.common.api.internal.m1> b;
    private final Handler c;
    protected final e v;
    p1(com.google.android.gms.common.api.internal.i i, e e2) {
        super(i);
        AtomicReference obj2 = new AtomicReference(0);
        this.b = obj2;
        obj2 = new e(Looper.getMainLooper());
        this.c = obj2;
        this.v = e2;
    }

    private final void a() {
        this.b.set(0);
        e();
    }

    private final void b(b b, int i2) {
        this.b.set(0);
        d(b, i2);
    }

    private static final int c(com.google.android.gms.common.api.internal.m1 m1) {
        if (m1 == null) {
            return -1;
        }
        return m1.a();
    }

    static void g(com.google.android.gms.common.api.internal.p1 p1) {
        p1.a();
    }

    static void h(com.google.android.gms.common.api.internal.p1 p1, b b2, int i3) {
        p1.b(b2, i3);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    protected abstract void d(b b, int i2);

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    protected abstract void e();

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(b b, int i2) {
        boolean obj2;
        int obj3;
        m1 m1Var = new m1(b, i2);
        if (this.b.compareAndSet(0, m1Var)) {
            obj3 = new o1(this, m1Var);
            this.c.post(obj3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i2, Intent intent3) {
        int obj3;
        int obj4;
        int obj5;
        Object obj = this.b.get();
        if (i != 1) {
            if (i != 2) {
            } else {
                obj3 = this.v.g(getActivity());
                if (obj3 == null) {
                    a();
                }
                if ((m1)obj == null) {
                }
                obj5 = 18;
                if ((m1)obj.b().j2() == obj5 && obj3 == obj5) {
                    if (obj3 == obj5) {
                    }
                }
            }
        } else {
            if (i2 == -1) {
                a();
            }
            if (i2 == 0 && obj == null) {
                if (obj == null) {
                }
                if (intent3 != null) {
                    obj3 = intent3.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                obj4 = new b(obj3, 0, obj.b().toString());
                b(obj4, p1.c(obj));
            }
        }
        if (obj != null) {
            b(obj.b(), obj.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCancel(DialogInterface dialogInterface) {
        b obj3 = new b(13, 0);
        b(obj3, p1.c((m1)this.b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        AtomicReference atomicReference;
        boolean bVar;
        int m1Var;
        String str;
        Bundle obj5;
        super.onCreate(bundle);
        if (bundle != null) {
            if (bundle.getBoolean("resolving_error", false)) {
                bVar = new b(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
                m1Var = new m1(bVar, bundle.getInt("failed_client_id", -1));
            } else {
                m1Var = 0;
            }
            this.b.set(m1Var);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Object obj = this.b.get();
        if ((m1)obj == null) {
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", (m1)obj.a());
        bundle.putInt("failed_status", obj.b().j2());
        bundle.putParcelable("failed_resolution", obj.b().l2());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.a = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.a = false;
    }
}
