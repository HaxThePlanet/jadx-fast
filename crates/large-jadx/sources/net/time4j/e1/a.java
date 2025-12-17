package net.time4j.e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import net.time4j.android.spi.AndroidResourceLoader;
import net.time4j.f1.d;
import net.time4j.g0;
import net.time4j.g1.e;
import net.time4j.g1.z.c;
import net.time4j.h0;
import net.time4j.i0;
import net.time4j.p0;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.l.b;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
public class a {

    private static final AtomicBoolean a;
    private static final AtomicBoolean b;

    static class a {
    }

    private static class b implements Runnable {
        b(net.time4j.e1.a.a a$a) {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "]";
            final String str3 = "TIME4A";
            p pVar = p.u(offset /= 1000);
            Locale default2 = Locale.getDefault();
            k kVar = l.O().z();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("System time zone at start: [");
            stringBuilder2.append(kVar.a());
            stringBuilder2.append(str);
            Log.i(str3, stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("System locale at start: [");
            stringBuilder3.append(default2.toString());
            stringBuilder3.append(str);
            Log.i(str3, stringBuilder3.toString());
            e fULL = e.FULL;
            Log.i(str3, c.B(fULL, fULL, default2, kVar).l(p0.b()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Prefetch thread consumed (in ms): ");
            stringBuilder.append(i3 /= i);
            Log.i(str3, stringBuilder.toString());
        }
    }

    private static class c extends BroadcastReceiver {
        c(net.time4j.e1.a.a a$a) {
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            l.b.a();
            StringBuilder obj2 = new StringBuilder();
            obj2.append("Event ACTION_TIMEZONE_CHANGED received, system timezone changed to: [");
            obj2.append(l.O().z().a());
            obj2.append("]. Original tz-id reported by Android: [");
            obj2.append(intent2.getStringExtra("time-zone"));
            obj2.append("]");
            Log.i("TIME4A", obj2.toString());
        }
    }
    static {
        final int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        a.a = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i);
        a.b = atomicBoolean2;
    }

    public static void a(Context context, Runnable runnable2) {
        Object obj4;
        a.c(context, 0);
        a.d(context.getApplicationContext());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Starting Time4A (v4.8-2021a published on ");
        stringBuilder2.append(g0.K0(2021, 3, 27).r0(h0.H0()).h0());
        stringBuilder2.append(")");
        String str2 = "TIME4A";
        Log.i(str2, stringBuilder2.toString());
        if (runnable2 != null) {
            Executors.defaultThreadFactory().newThread(runnable2).start();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Main-Thread consumed in ms: ");
        stringBuilder.append(obj4 /= i);
        Log.i(str2, stringBuilder.toString());
    }

    public static void b(Context context, boolean z2) {
        int i;
        net.time4j.e1.a.b obj2;
        if (z2 != null) {
            obj2 = new a.b(0);
            i = obj2;
        }
        a.a(context, i);
    }

    public static void c(Context context, net.time4j.e1.b b2) {
        boolean andSet;
        int str;
        if (!a.a.getAndSet(true)) {
            System.setProperty("net.time4j.base.ResourceLoader", "net.time4j.android.spi.AndroidResourceLoader");
            (AndroidResourceLoader)d.c().j(context, b2);
        }
    }

    public static void d(Context context) {
        boolean andSet;
        int intentFilter;
        String str;
        if (context != null && !a.b.getAndSet(true)) {
            if (!a.b.getAndSet(true)) {
                System.setProperty("net.time4j.allow.system.tz.override", "true");
                andSet = new a.c(0);
                intentFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
                context.registerReceiver(andSet, intentFilter);
            }
        }
    }
}
