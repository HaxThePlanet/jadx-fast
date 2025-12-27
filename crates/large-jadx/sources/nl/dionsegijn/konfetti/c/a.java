package nl.dionsegijn.konfetti.c;

import kotlin.d0.c.a;

/* compiled from: BurstEmitter.kt */
/* loaded from: classes3.dex */
public final class a extends b {

    private int b;
    private boolean c;
    private final void f(int i) {
        int i2;
        i2 = 1000;
        if (i > i2) {
        }
        this.b = i2;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public void a(float f) {
        a aVar;
        boolean z = true;
        if (!this.c) {
            z = true;
            this.c = z;
            if (z <= this.b) {
                aVar = b();
                while (aVar != null) {
                    Object invoke = aVar.invoke();
                }
            }
        }
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public boolean c() {
        return this.c;
    }

    @Override // nl.dionsegijn.konfetti.c.b
    public final b e(int i) {
        f(i);
        this.c = false;
        return this;
    }
}
