package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
abstract class u<T>  {

    final int a;
    final k<T> b;
    final int c;
    final Bundle d;
    u(int i, int i2, Bundle bundle3) {
        super();
        k kVar = new k();
        this.b = kVar;
        this.a = i;
        this.c = i2;
        this.d = bundle3;
    }

    abstract void a(Bundle bundle);

    abstract boolean b();

    final void c(com.google.android.gms.cloudmessaging.zzq zzq) {
        boolean loggable;
        String valueOf;
        String str;
        int length;
        StringBuilder stringBuilder;
        String str2 = "MessengerIpcClient";
        if (Log.isLoggable(str2, 3)) {
            String valueOf2 = String.valueOf(this);
            valueOf = String.valueOf(zzq);
            stringBuilder = new StringBuilder(i2 += length);
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf2);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf);
            Log.d(str2, stringBuilder.toString());
        }
        this.b.b(zzq);
    }

    final void d(T t) {
        boolean loggable;
        String valueOf;
        String str;
        int length;
        StringBuilder stringBuilder;
        String str2 = "MessengerIpcClient";
        if (Log.isLoggable(str2, 3)) {
            String valueOf2 = String.valueOf(this);
            valueOf = String.valueOf(t);
            stringBuilder = new StringBuilder(i2 += length);
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf2);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf);
            Log.d(str2, stringBuilder.toString());
        }
        this.b.c(t);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(this.c);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(b());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
