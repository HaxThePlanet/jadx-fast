package nl.dionsegijn.konfetti.c;

import java.util.Iterator;
import kotlin.d0.c.a;
import kotlin.h0.f;
import kotlin.y.h0;

/* compiled from: StreamEmitter.kt */
/* loaded from: classes3.dex */
public final class d extends b {

    public static final long h = -2L;
    private int b = -1;
    private int c;
    private long d;
    private float e;
    private float f;
    private float g;
    public d() {
        super();
    }

    public static /* synthetic */ d f(d dVar, int i, long j, int i2, int i3, Object object) {
        if (i3 & 2 != 0) {
            i = 0;
        }
        if (i3 & 4 != 0) {
            i3 = -1;
        }
        dVar.e(i, i, i3);
        return dVar;
    }

    private final void g() {
        if (i()) {
            return;
        }
        this.c++;
        a aVar = b();
        if (aVar != null) {
            Object invoke = aVar.invoke();
        }
    }

    private final boolean h() {
        boolean z = false;
        int i2 = 0;
        if (this.d != 0) {
            l2 = d.h;
            if (this.d != d.h) {
                float f = (float)l;
                if (this.e >= this.d) {
                    int i3 = 1;
                }
            }
        }
        return z;
    }

    private final boolean i() {
        boolean z = false;
        if (1 > this.b) {
            int i4 = 0;
        }
        return z;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public void a(float f) {
        this.g += f;
        if (this.g >= this.f && !this.h()) {
            int i = 1;
            Iterator it = new IntRange(i, (int)(this.g / this.f)).iterator();
            while (it.hasNext()) {
                (IntIterator)it.d();
                g();
            }
            this.g %= f2;
        }
        this.e += f13;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public boolean c() {
        int cmp;
        int i;
        int cmp2;
        boolean z = true;
        long l;
        int i3 = 1;
        if (this.d <= 0) {
            l = d.h;
            int r3 = 0;
        } else {
            float f = (float)l2;
            if (this.e < this.d) {
                int i4 = 0;
            }
        }
        return false;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public final d e(int i, long j, int i2) {
        this.b = i2;
        this.d = j;
        this.f = 1f / (float)i;
        return this;
    }

}
