package nl.dionsegijn.konfetti.c;

import java.util.Iterator;
import kotlin.d0.c.a;
import kotlin.h0.f;
import kotlin.y.h0;

/* loaded from: classes3.dex */
public final class d extends nl.dionsegijn.konfetti.c.b {

    public static final long h = -2L;
    private int b = -1;
    private int c;
    private long d;
    private float e;
    private float f;
    private float g;
    static {
    }

    public d() {
        super();
        final int i = -1;
    }

    public static nl.dionsegijn.konfetti.c.d f(nl.dionsegijn.konfetti.c.d d, int i2, long l3, int i4, int i5, Object object6) {
        int obj2;
        int obj4;
        if (object6 & 2 != 0) {
            obj2 = 0;
        }
        if (object6 &= 4 != 0) {
            obj4 = -1;
        }
        d.e(i2, obj2, i4);
        return d;
    }

    private final void g() {
        Object invoke;
        if (i()) {
        }
        this.c = i++;
        invoke = b();
        if (invoke != null) {
            invoke = invoke.invoke();
        }
    }

    private final boolean h() {
        long cmp;
        int cmp2;
        int i;
        long l;
        cmp = this.d;
        i = 0;
        if (Long.compare(cmp, i2) == 0) {
        } else {
            if (Long.compare(cmp, l) == 0) {
            } else {
                if (Float.compare(cmp2, f) >= 0) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private final boolean i() {
        int i;
        final int i3 = this.b;
        if (1 > i3) {
            i = 0;
        } else {
            if (this.c >= i3) {
            } else {
            }
        }
        return i;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public void a(float f) {
        int cmp;
        int i;
        float f2;
        f fVar;
        f3 += f;
        this.g = i2;
        if (Float.compare(i2, f2) >= 0 && !h()) {
            if (!h()) {
                fVar = new f(1, (int)i3);
                Iterator iterator = fVar.iterator();
                while (iterator.hasNext()) {
                    (h0)iterator.d();
                    g();
                }
                this.g = f5 %= f2;
            }
        }
        this.e = f6 += obj4;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public boolean c() {
        int cmp;
        int i;
        int cmp2;
        int i2;
        long l;
        long l2 = this.d;
        i2 = 1;
        if (Long.compare(l2, i3) > 0) {
            if (Float.compare(cmp2, f) >= 0) {
            } else {
                i2 = i4;
            }
        } else {
            if (Long.compare(l2, l) == 0) {
            } else {
            }
        }
        return i2;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public final nl.dionsegijn.konfetti.c.d e(int i, long l2, int i3) {
        this.b = obj4;
        this.d = l2;
        this.f = obj2 /= obj1;
        return this;
    }
}
