package f.c.a.d.f;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.m.a;
import com.google.android.gms.common.m.a.a;
import com.google.android.gms.common.n.b;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.n;
import com.google.android.gms.common.util.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class a {

    private static ScheduledExecutorService l;
    private final Object a;
    private final PowerManager.WakeLock b;
    private WorkSource c;
    private final int d;
    private final String e;
    private final String f;
    private final Context g;
    private boolean h;
    private final Map<String, Integer[]> i;
    private int j;
    private AtomicInteger k;
    public a(Context context, int i, String str) {
        if (context == null) {
            i = 0;
        } else {
            String packageName = context.getPackageName();
        }
        this(context, i, str, null, i);
    }

    private final String d(String str) {
        if (this.h && !TextUtils.isEmpty(str)) {
            return str;
        }
        return this.f;
    }

    private final List<String> e() {
        return p.b(this.c);
    }

    private final void f(int i) {
        Class obj;
        Class<RuntimeException> obj3;
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e) {
                Class concatenated = e.getClass();
                Class<RuntimeException> str = RuntimeException.class;
                concatenated = concatenated.equals(str);
            }
            this.b.isHeld();
        }
    }

    static /* synthetic */ void g(a aVar, int i) {
        aVar.f(0);
    }

    public void a(long j) {
        Map map;
        int i;
        int i2 = 0;
        Context context;
        Integer[] arr;
        Integer num;
        this.k.incrementAndGet();
        final String str4 = d(null);
        synchronized (obj2) {
            try {
                i2 = 0;
                if (!this.i.isEmpty() || this.j > 0) {
                    if (!this.b.isHeld()) {
                        this.i.clear();
                        this.j = i2;
                    }
                }
                i2 = 1;
                if (this.h) {
                    Object value = this.i.get(str4);
                    if (value == null) {
                        arr = new Integer[i2];
                        this.i.put(str4, new Integer[] { 1 });
                    } else {
                        value[i2] = Integer.valueOf(value[i2].intValue() + i2);
                    }
                    if (i2 != 0 || !this.h || this.j == 0) {
                        int i3 = 7;
                        String str3 = null;
                        c.a().c(this.g, b.a(this.b, str4), i3, this.e, str4, str3, this.d, e(), j);
                        this.j += i2;
                    }
                }
            } catch (Throwable th) {
            }
        }
        this.b.acquire();
        if (th > 0) {
            a.l.schedule(new b(this), th, TimeUnit.MILLISECONDS);
        }
    }

    public void b() {
        int i;
        String str;
        int value;
        if (this.k.decrementAndGet() < 0) {
            str = " release without a matched acquire!";
            Log.e("WakeLock", String.valueOf(this.e).concat(str));
        }
        final String str8 = d(null);
        synchronized (obj2) {
            try {
                i = 1;
                i = 0;
                if (this.h) {
                    Object value2 = this.i.get(str8);
                    Throwable th = i;
                    if (this.h != 0 || !this.h || this.j == i) {
                        int i2 = 8;
                        String str4 = null;
                        c.a().b(this.g, b.a(this.b, str8), i2, this.e, str8, str4, this.d, e());
                        this.j -= i;
                    }
                }
            } catch (Throwable th) {
            }
        }
        f(i);
    }

    public void c(boolean z) {
        this.b.setReferenceCounted(z);
        this.h = z;
    }

    private a(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, null, str3, null);
    }

    private a(Context context, int i, String str, String str2, String str3, String str4) throws java.io.UnsupportedEncodingException {
        String concatenated;
        String packageName;
        super();
        this.a = this;
        this.h = true;
        this.i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.k = new AtomicInteger(0);
        r.k(context, "WakeLock: context must not be null");
        r.g(str, "WakeLock: wakeLockName must not be empty");
        this.d = i;
        this.f = null;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        concatenated = "com.google.android.gms";
        if (!concatenated.equals(context.getPackageName())) {
            String str8 = "*gcore*:";
            concatenated = String.valueOf(str);
            if (concatenated.length() != 0) {
                concatenated = str8.concat(concatenated);
            } else {
            }
            this.e = concatenated;
        } else {
            this.e = str;
        }
        PowerManager.WakeLock wakeLock = (PowerManager)context.getSystemService("power").newWakeLock(i, str);
        this.b = wakeLock;
        if (p.c(context) && n.b(str3)) {
            packageName = context.getPackageName();
            WorkSource workSource = p.a(context, packageName);
            this.c = workSource;
            if (workSource != null && p.c(applicationContext)) {
                if (this.c != null) {
                    this.c.add(workSource);
                } else {
                    this.c = workSource;
                }
                try {
                    wakeLock.setWorkSource(this.c);
                } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds) {
                } catch (java.lang.IllegalArgumentException iae1) {
                }
            }
        }
        if (a.l == null) {
            a.l = a.a().a();
        }
    }

}
