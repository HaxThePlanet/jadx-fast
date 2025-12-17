package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class s1 implements Handler.Callback {

    final com.google.android.gms.common.internal.t1 a;
    s1(com.google.android.gms.common.internal.t1 t1, com.google.android.gms.common.internal.q1 q12) {
        this.a = t1;
        super();
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        boolean componentName;
        String string;
        Exception exception;
        StringBuilder stringBuilder;
        Object obj8;
        int what = message.what;
        final int i = 1;
        if (what != 0 && what != i) {
            if (what != i) {
                return 0;
            }
            HashMap map2 = t1.f(this.a);
            obj8 = message.obj;
            Object obj2 = t1.f(this.a).get((p1)obj8);
            synchronized (map2) {
                if ((r1)obj2.f() == 3) {
                    String valueOf = String.valueOf(obj8);
                    stringBuilder = new StringBuilder(length += 47);
                    stringBuilder.append("Timeout waiting for ServiceConnection callback ");
                    stringBuilder.append(valueOf);
                    exception = new Exception();
                    Log.e("GmsClientSupervisor", stringBuilder.toString(), exception);
                    if (obj2.j() == null) {
                        componentName = obj8.b();
                    }
                    if (componentName == null) {
                        obj8 = obj8.a();
                        r.j(obj8);
                        componentName = new ComponentName(obj8, "unknown");
                    }
                    obj2.onServiceDisconnected(componentName);
                }
                return i;
            }
        }
        HashMap map = t1.f(this.a);
        obj8 = message.obj;
        obj = t1.f(this.a).get((p1)obj8);
        synchronized (map) {
            if ((r1)obj.h()) {
                if (obj.e()) {
                    obj.b("GmsClientSupervisor");
                }
                try {
                    t1.f(this.a).remove(obj8);
                    return i;
                    throw message;
                } catch (Throwable th) {
                }
            }
        }
    }
}
