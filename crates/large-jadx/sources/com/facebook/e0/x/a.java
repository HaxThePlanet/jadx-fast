package com.facebook.e0.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.e0.c;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0002J\u0008\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "()V", "ALLOWED_IMPLICIT_EVENTS", "", "", "isEventEligibleForOnDeviceProcessing", "", "event", "Lcom/facebook/appevents/AppEvent;", "isOnDeviceProcessingEnabled", "sendCustomEventAsync", "", "applicationId", "sendInstallEventAsync", "preferencesName", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final Set<String> a;
    public static final com.facebook.e0.x.a b;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final String a;
        final c b;
        a(String string, c c2) {
            this.a = string;
            this.b = c2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            c.c(this.a, p.b(this.b));
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final Context a;
        final String b;
        final String c;
        b(Context context, String string2, String string3) {
            this.a = context;
            this.b = string2;
            this.c = string3;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object sharedPreferences;
            int currentTimeMillis;
            if (a.d(this)) {
            }
            sharedPreferences = this.a.getSharedPreferences(this.b, 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append("pingForOnDevice");
            String string = stringBuilder.toString();
            int i2 = 0;
            if (Long.compare(long, i2) == 0) {
                c.e(this.c);
                sharedPreferences = sharedPreferences.edit();
                sharedPreferences.putLong(string, System.currentTimeMillis());
                sharedPreferences.apply();
            }
        }
    }
    static {
        a aVar = new a();
        a.b = aVar;
        a.a = q0.g(/* result */);
    }

    private final boolean a(c c) {
        int i2;
        boolean contains;
        int i;
        String str;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        final int i3 = 1;
        if (c.h() && a.a.contains(c.f())) {
            i2 = a.a.contains(c.f()) ? i3 : i;
        } else {
        }
        if (obj5 ^= i3 == 0) {
            if (i2 != 0) {
                try {
                    i = i3;
                    return i;
                    a.b(c, this);
                    return obj1;
                }
            }
        } else {
        }
    }

    public static final boolean b() {
        Class<com.facebook.e0.x.a> obj;
        int i2;
        boolean z;
        int i;
        i = 0;
        if (a.d(a.class)) {
            return i;
        }
        final int i3 = 1;
        if (!o.s(o.f()) && !b0.T()) {
            i2 = !b0.T() ? i3 : i;
        } else {
        }
        if (i2 != 0 && c.b()) {
            if (c.b()) {
                i = i3;
            }
        }
        return i;
    }

    public static final void c(String string, c c2) {
        boolean z;
        com.facebook.e0.x.a.a aVar;
        if (a.d(a.class)) {
        }
        n.f(string, "applicationId");
        n.f(c2, "event");
        if (a.b.a(c2)) {
            aVar = new a.a(string, c2);
            o.n().execute(aVar);
        }
    }

    public static final void d(String string, String string2) {
        Executor executor;
        com.facebook.e0.x.a.b bVar;
        if (a.d(a.class)) {
        }
        Context context = o.f();
        if (context != null && string != null && string2 != null) {
            if (string != null) {
                if (string2 != null) {
                    bVar = new a.b(context, string2, string);
                    o.n().execute(bVar);
                }
            }
        }
    }
}
