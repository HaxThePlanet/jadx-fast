package f.c.a.f.a.a;

import android.app.PendingIntent;

/* loaded from: classes2.dex */
public class a {

    private final int a;
    private final long b;
    private final long c;
    private final PendingIntent d;
    private final PendingIntent e;
    private final PendingIntent f;
    private final PendingIntent g;
    private boolean h;
    private a(String string, int i2, int i3, int i4, Integer integer5, int i6, long l7, long l8, long l9, long l10, PendingIntent pendingIntent11, PendingIntent pendingIntent12, PendingIntent pendingIntent13, PendingIntent pendingIntent14) {
        final Object obj = this;
        super();
        obj.h = false;
        obj.a = i3;
        obj.b = pendingIntent11;
        obj.c = pendingIntent13;
        obj.d = obj18;
        obj.e = obj19;
        obj.f = obj20;
        obj.g = obj21;
    }

    public static f.c.a.f.a.a.a e(String string, int i2, int i3, int i4, Integer integer5, int i6, long l7, long l8, long l9, long l10, PendingIntent pendingIntent11, PendingIntent pendingIntent12, PendingIntent pendingIntent13, PendingIntent pendingIntent14) {
        super(string, i2, i3, i4, integer5, i6, l7, obj8, l9, obj10, pendingIntent11, obj12, pendingIntent13, obj14, obj34, obj35, obj36, obj37);
        return aVar2;
    }

    private final boolean h(f.c.a.f.a.a.d d) {
        long l;
        long l2;
        boolean obj5;
        if (d.a() && Long.compare(l, l2) <= 0) {
            if (Long.compare(l, l2) <= 0) {
                return 1;
            }
        }
        return 0;
    }

    public boolean a(int i) {
        if (d(d.c(i)) != null) {
            return 1;
        }
        return 0;
    }

    public boolean b(f.c.a.f.a.a.d d) {
        if (d(d) != null) {
            return 1;
        }
        return 0;
    }

    public int c() {
        return this.a;
    }

    final PendingIntent d(f.c.a.f.a.a.d d) {
        int i;
        f.c.a.f.a.a.d obj4;
        final int i3 = 0;
        PendingIntent intent = this.e;
        if (d.b() == 0 && intent != null) {
            intent = this.e;
            if (intent != null) {
                return intent;
            }
            if (h(d)) {
                return this.g;
            }
            return i3;
        }
        i = this.d;
        if (d.b() == 1 && i != null) {
            i = this.d;
            if (i != null) {
                return i;
            }
            if (h(d)) {
                return this.f;
            }
        }
        return i3;
    }

    final void f() {
        this.h = true;
    }

    final boolean g() {
        return this.h;
    }
}
