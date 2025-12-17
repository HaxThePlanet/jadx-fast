package nl.dionsegijn.konfetti.c;

import kotlin.d0.c.a;

/* loaded from: classes3.dex */
public final class a extends nl.dionsegijn.konfetti.c.b {

    private int b;
    private boolean c;
    private final void f(int i) {
        int obj2;
        final int i2 = 1000;
        if (i > i2) {
            obj2 = i2;
        }
        this.b = obj2;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public void a(float f) {
        int i;
        a invoke;
        int obj3;
        obj3 = 1;
        this.c = obj3;
        i = this.b;
        if (!this.c && obj3 <= i) {
            obj3 = 1;
            this.c = obj3;
            i = this.b;
            if (obj3 <= i) {
            }
        }
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public boolean c() {
        return this.c;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public final nl.dionsegijn.konfetti.c.b e(int i) {
        f(i);
        this.c = false;
        return this;
    }
}
