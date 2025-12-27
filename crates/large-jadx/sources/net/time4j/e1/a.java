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

/* compiled from: ApplicationStarter.java */
/* loaded from: classes3.dex */
public class a {

    private static final AtomicBoolean a = new AtomicBoolean(0);
    private static final AtomicBoolean b = new AtomicBoolean(0);

    static class a {
    }

    private static class b implements Runnable {
        private b() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "]";
            final String str5 = "TIME4A";
            Locale _default2 = Locale.getDefault();
            try {
                k kVar = l.O().z();
                StringBuilder stringBuilder3 = new StringBuilder();
                String str10 = "System time zone at start: [";
                String str11 = kVar.a();
                str9 = str10 + str11 + str;
                Log.i(str5, str9);
                StringBuilder stringBuilder4 = new StringBuilder();
                String str12 = "System locale at start: [";
                String locale = _default2.toString();
                str2 = str12 + locale + str;
                Log.i(str5, str2);
                e fULL2 = e.FULL;
                Log.i(str5, c.B(fULL2, fULL2, _default2, kVar).l(p0.b()));
            } finally {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str7 = "Error on prefetch thread with: time zone=";
                str7 = obj.a();
                str7 = ", locale=";
                str7 = "!";
                stringBuilder2 = str7 + str7 + str7 + str8 + str7;
                Log.e(illegalStateException, stringBuilder2, th);
                String illegalStateException = new IllegalStateException(th);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) illegalStateException;
            }
            long l2 = (System.nanoTime() - System.nanoTime()) / 1000000L;
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "Prefetch thread consumed (in ms): ";
            str4 = str6 + l2;
            Log.i(str5, str4);
        }

        /* synthetic */ b(a.a aVar) {
            this();
        }
    }

    private static class c extends BroadcastReceiver {
        private c() {
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l.b.a();
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Event ACTION_TIMEZONE_CHANGED received, system timezone changed to: [";
            String str2 = l.O().z().a();
            String str3 = "]. Original tz-id reported by Android: [";
            String stringExtra = intent.getStringExtra("time-zone");
            String str6 = "]";
            str5 = str + str2 + str3 + stringExtra + str6;
            Log.i("TIME4A", str5);
        }

        /* synthetic */ c(a.a aVar) {
            this();
        }
    }

    public static void a(Context context, Runnable runnable) throws java.lang.IllegalThreadStateException {
        a.c(context, null);
        a.d(context.getApplicationContext());
        StringBuilder stringBuilder2 = new StringBuilder();
        String str4 = "Starting Time4A (v4.8-2021a published on ";
        g0 g0Var2 = g0.K0(2021, 3, 27).r0(h0.H0()).h0();
        String str5 = ")";
        str = str4 + g0Var2 + str5;
        String str3 = "TIME4A";
        Log.i(str3, str);
        if (runnable != null) {
            Executors.defaultThreadFactory().newThread(runnable).start();
        }
        long l2 = (System.nanoTime() - System.nanoTime()) / 1000000L;
        StringBuilder stringBuilder = new StringBuilder();
        final String str2 = "Main-Thread consumed in ms: ";
        str6 = str2 + l2;
        Log.i(str3, str6);
    }

    public static void b(Context context, boolean z) {
        Object obj = null;
        if (z) {
        }
        a.a(context, obj);
    }

    public static void c(Context context, b bVar) {
        boolean z = true;
        if (!a.a.getAndSet(z)) {
            System.setProperty("net.time4j.base.ResourceLoader", "net.time4j.android.spi.AndroidResourceLoader");
            (AndroidResourceLoader)d.c().j(context, bVar);
        }
    }

    public static void d(Context context) throws android.content.IntentFilter.MalformedMimeTypeException {
        if (context != null) {
            boolean z = true;
            if (!a.b.getAndSet(z)) {
                System.setProperty("net.time4j.allow.system.tz.override", "true");
                str = "android.intent.action.TIMEZONE_CHANGED";
                context.registerReceiver(new a.c(null), new IntentFilter(str));
            }
        }
    }
}
