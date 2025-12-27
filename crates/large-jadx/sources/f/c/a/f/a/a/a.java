package f.c.a.f.a.a;

import android.app.PendingIntent;

/* compiled from: com.google.android.play:core@@1.10.2 */
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
    public static a e(String str, int i, int i2, int i3, Integer integer, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        a aVar = new a(str, i, i2, i3, integer, i4, j, l, j2, l2, j3, pendingIntent, j4, pendingIntent2, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
        return aVar;
    }

    private final boolean h(d dVar) {
        if (dVar.a()) {
            if (this.b <= this.c) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        if (d(d.c(i)) != null) {
            return true;
        }
        return false;
    }

    public boolean b(d dVar) {
        if (d(dVar) != null) {
            return true;
        }
        return false;
    }

    final PendingIntent d(d dVar) {
        final int i3 = 0;
        if (dVar.b() == 0 && this.e != null) {
            return this.e;
        }
        return dVar.b() == 1 && this.d != null ? pendingIntent : i3;
    }

    private a(String str, int i, int i2, int i3, Integer integer, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        final Object str2 = this;
        super();
        str2.h = false;
        str2.a = i2;
        str2.b = j3;
        str2.c = j4;
        str2.d = pendingIntent;
        str2.e = pendingIntent2;
        str2.f = pendingIntent3;
        str2.g = pendingIntent4;
    }

    public int c() {
        return this.a;
    }

    final void f() {
        this.h = true;
    }

    final boolean g() {
        return this.h;
    }
}
