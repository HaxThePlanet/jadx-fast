package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class g1<TListener>  {

    private TListener a;
    private boolean b = false;
    final com.google.android.gms.common.internal.c c;
    public g1(com.google.android.gms.common.internal.c c, Object object2) {
        this.c = c;
        super();
        this.a = object2;
        final int obj1 = 0;
    }

    protected abstract void a();

    protected abstract void b(TListener tlistener);

    public final void c() {
        boolean str;
        String string;
        String str2;
        StringBuilder stringBuilder;
        Object obj = this.a;
        synchronized (this) {
            try {
                String valueOf = String.valueOf(this);
                stringBuilder = new StringBuilder(length += 47);
                stringBuilder.append("Callback proxy ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" being reused. This is not safe.");
                Log.w("GmsClient", stringBuilder.toString());
                if (obj != null) {
                }
                b(obj);
                throw th;
                this.b = true;
                d();
                throw th;
                throw th;
            } catch (RuntimeException e) {
            }
        }
    }

    public final void d() {
        e();
        ArrayList list = c.zzm(this.c);
        c.zzm(this.c).remove(this);
        return;
        synchronized (list) {
            e();
            list = c.zzm(this.c);
            c.zzm(this.c).remove(this);
        }
    }

    public final void e() {
        this.a = 0;
        return;
        synchronized (this) {
            this.a = 0;
        }
    }
}
