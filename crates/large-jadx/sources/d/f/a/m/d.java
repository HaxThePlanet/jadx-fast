package d.f.a.m;

import android.app.ActivityManager.ProcessErrorStateInfo;
import d.f.a.c;
import d.f.a.i.a;
import d.f.a.m.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class d {

    private HashSet<d> a = null;
    private int b;
    private boolean c;
    public final e d;
    public final d.b e;
    public d f;
    public int g = 0;
    int h = Integer.MIN_VALUE;
    d.f.a.i i;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[d.b.values().length];
            d.a.a = iArr;
            try {
                iArr[d.b.CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.LEFT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.TOP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.BOTTOM.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.BASELINE.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.CENTER_X.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                d.a.a[d.b.NONE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        BASELINE,
        BOTTOM,
        CENTER,
        CENTER_X,
        CENTER_Y,
        LEFT,
        NONE,
        RIGHT,
        TOP;
    }
    public d(e eVar, d.b bVar) {
        super();
        this.d = eVar;
        this.e = bVar;
    }

    public boolean a(d dVar, int i, int i2, boolean z) {
        final boolean z2 = true;
        if (dVar == null) {
            p();
            return true;
        }
        if (!z && !this.o(dVar)) {
            return false;
        }
        this.f = dVar;
        if (dVar.a == null) {
            dVar.a = new HashSet();
        }
        if (this.f.a != null) {
            this.f.a.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public void b(int i, ArrayList<o> arrayList, o oVar) {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                i.a((d)it.next().d, i, arrayList, oVar);
            }
        }
    }

    public HashSet<d> c() {
        return this.a;
    }

    public int d() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public int e() {
        final int i6 = 8;
        if (this.d.Q() == i6) {
            return 0;
        }
        if (this.h != -2147483648 && this.f != null) {
            if (dVar.d.Q() == i6) {
                return this.h;
            }
        }
        return this.g;
    }

    public final d f() {
        switch (d.a.a[this.e.ordinal()]) {
            case 1: /* ordinal */
                return null;
            case 2: /* ordinal */
                return this.d.M;
            case 3: /* ordinal */
                return this.d.K;
            case 4: /* ordinal */
                return this.d.N;
            case 5: /* ordinal */
                return this.d.L;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public e g() {
        return this.d;
    }

    public d.f.a.i h() {
        return this.i;
    }

    public d i() {
        return this.f;
    }

    public d.b j() {
        return this.e;
    }

    public boolean k() {
        final boolean z2 = false;
        if (this.a == null) {
            return false;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if ((d)it.next().f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        boolean z = false;
        z = false;
        if (this.a == null) {
            return false;
        }
        if (this.a.size() > 0) {
            int i = 1;
        }
        return z;
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        boolean z = true;
        int r0 = this.f != null ? 1 : 0;
        return (this.f != null ? 1 : 0);
    }

    public boolean o(d dVar) {
        int i = 0;
        boolean z4 = false;
        boolean z5;
        boolean z6;
        d.f.a.m.d.b cENTER_X2;
        boolean z2;
        boolean z3;
        i = 0;
        if (dVar == null) {
            return false;
        }
        d.f.a.m.d.b bVar2 = dVar.j();
        i = 1;
        if (bVar2 == this.e) {
            if (this.e == d.b.BASELINE) {
                if (dVar.g().U()) {
                    return !g().U() ? i : i;
                }
            }
        }
        switch (d.a.a[this.e.ordinal()]) {
            case 1: /* ordinal */
                return z4;
            case 2: /* ordinal */
                z2 = d.b.CENTER_Y.g() instanceof g;
                return z5;
            case 3: /* ordinal */
                z3 = d.b.CENTER_Y.g() instanceof g;
                return z6;
            case 4: /* ordinal */
                return true;
            case 5: /* ordinal */
                return false;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public void p() {
        HashSet set3 = null;
        if (this.f != null && dVar.a != null) {
            dVar.a.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = set3;
            }
        }
        this.a = set3;
        this.f = set3;
        int i = 0;
        this.g = i;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = i;
    }

    public void q() {
        final boolean z = false;
        this.c = z;
        this.b = z;
    }

    public void r(c cVar) {
        if (this.i == null) {
            String str = null;
            this.i = new i(i.a.UNRESTRICTED, str);
        } else {
            this.i.i();
        }
    }

    public void s(int i) {
        this.b = i;
        this.c = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = this.d.r();
        String str3 = ":";
        String obj = this.e.toString();
        str = str2 + str3 + obj;
        return str;
    }
}
