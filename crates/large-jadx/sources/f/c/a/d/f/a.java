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
    static {
    }

    public a(Context context, int i2, String string3) {
        int packageName;
        if (context == null) {
            packageName = 0;
        } else {
            packageName = context.getPackageName();
        }
        super(context, i2, string3, 0, packageName);
    }

    private a(Context context, int i2, String string3, String string4, String string5) {
        super(context, i2, string3, 0, string5, 0);
    }

    private a(Context context, int i2, String string3, String string4, String string5, String string6) {
        String valueOf;
        int length;
        Object obj3;
        PowerManager.WakeLock obj4;
        boolean obj5;
        String obj7;
        String obj8;
        super();
        this.a = this;
        this.h = true;
        HashMap obj6 = new HashMap();
        this.i = obj6;
        obj6 = new HashSet();
        Collections.synchronizedSet(obj6);
        obj6 = new AtomicInteger(0);
        this.k = obj6;
        r.k(context, "WakeLock: context must not be null");
        r.g(string3, "WakeLock: wakeLockName must not be empty");
        this.d = i2;
        this.f = 0;
        obj6 = context.getApplicationContext();
        this.g = obj6;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            obj8 = "*gcore*:";
            valueOf = String.valueOf(string3);
            if (valueOf.length() != 0) {
                obj8 = obj8.concat(valueOf);
            } else {
                valueOf = new String(obj8);
                obj8 = valueOf;
            }
            this.e = obj8;
        } else {
            this.e = string3;
        }
        obj4 = (PowerManager)context.getSystemService("power").newWakeLock(i2, string3);
        this.b = obj4;
        if (p.c(context) && n.b(string5)) {
            if (n.b(string5)) {
                obj7 = context.getPackageName();
            }
            obj3 = p.a(context, obj7);
            this.c = obj3;
            if (obj3 != null && p.c(obj6)) {
                if (p.c(obj6)) {
                    obj5 = this.c;
                    if (obj5 != null) {
                        obj5.add(obj3);
                    } else {
                        this.c = obj3;
                    }
                    obj4.setWorkSource(this.c);
                }
            }
        }
        if (a.l == null) {
            a.l = a.a().a();
        }
    }

    private final String d(String string) {
        if (this.h && !TextUtils.isEmpty(string)) {
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return this.f;
        }
        return this.f;
    }

    private final List<String> e() {
        return p.b(this.c);
    }

    private final void f(int i) {
        Class concat;
        Class<RuntimeException> str;
        boolean obj3;
        if (this.b.isHeld()) {
            this.b.release();
            this.b.isHeld();
        }
    }

    static void g(f.c.a.d.f.a a, int i2) {
        a.f(0);
    }

    public void a(long l) {
        int cmp;
        int empty;
        int bVar;
        int mILLISECONDS;
        Integer[] valueOf;
        Integer valueOf2;
        String str;
        int i;
        int i2;
        List list;
        long l2;
        this.k.incrementAndGet();
        final String str2 = d(0);
        Object obj = this.a;
        mILLISECONDS = 0;
        synchronized (obj) {
            if (this.j > 0 && !this.b.isHeld()) {
                if (!this.b.isHeld()) {
                    this.i.clear();
                    this.j = mILLISECONDS;
                }
            }
            final int i7 = 1;
            if (this.h) {
                bVar = this.i.get(str2);
                if ((Integer[])bVar == null) {
                    valueOf = new Integer[i7];
                    valueOf[mILLISECONDS] = Integer.valueOf(i7);
                    this.i.put(str2, valueOf);
                    mILLISECONDS = i7;
                } else {
                    bVar[mILLISECONDS] = Integer.valueOf(intValue += i7);
                }
                if (mILLISECONDS == 0) {
                    if (!this.h && this.j == 0) {
                        if (this.j == 0) {
                            c.a().c(this.g, b.a(this.b, str2), 7, this.e, str2, 0, this.d, e(), l);
                            this.j = i5 += i7;
                        }
                    }
                } else {
                }
            } else {
            }
            this.b.acquire();
            if (Long.compare(l, i4) > 0) {
            }
        }
        try {
            bVar = new b(this);
            a.l.schedule(bVar, l, obj15);
            throw l;
        }
    }

    public void b() {
        int decrementAndGet;
        Object concat;
        int z;
        String intValue;
        String str;
        int i2;
        String str2;
        int i;
        int i3;
        List list;
        if (this.k.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.e).concat(" release without a matched acquire!"));
        }
        final String str4 = d(0);
        Object obj = this.a;
        final int i7 = 1;
        final int i8 = 0;
        synchronized (obj) {
            Object obj2 = this.i.get(str4);
            if ((Integer[])obj2 == null) {
                z = i8;
            } else {
            }
            if (z == 0) {
                if (!this.h && this.j == i7) {
                    if (this.j == i7) {
                        c.a().b(this.g, b.a(this.b, str4), 8, this.e, str4, 0, this.d, e());
                        this.j = i5 -= i7;
                    }
                }
            } else {
            }
            f(i8);
        }
    }

    public void c(boolean z) {
        this.b.setReferenceCounted(z);
        this.h = z;
    }
}
