package nl.dionsegijn.konfetti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import kotlin.d0.d.n;
import nl.dionsegijn.konfetti.c.d;
import nl.dionsegijn.konfetti.e.b.c;

/* compiled from: ParticleSystem.kt */
/* loaded from: classes3.dex */
public final class b {

    private final Random a = new Random();
    private nl.dionsegijn.konfetti.f.a b = new a();
    private nl.dionsegijn.konfetti.f.b c = new b();
    private int[] d;
    private nl.dionsegijn.konfetti.e.c[] e;
    private nl.dionsegijn.konfetti.e.b[] f;
    private nl.dionsegijn.konfetti.e.a g;
    public nl.dionsegijn.konfetti.c.c h;
    private final KonfettiView i;
    public b(KonfettiView konfettiView) {
        n.f(konfettiView, "konfettiView");
        super();
        this.i = konfettiView;
        Random random = new Random();
        nl.dionsegijn.konfetti.f.a aVar = new a(random);
        nl.dionsegijn.konfetti.f.b bVar = new b(random);
        int i13 = 1;
        int[] iArr = new int[i13];
        final int i2 = 0;
        iArr[i2] = -65536;
        this.d = iArr;
        nl.dionsegijn.konfetti.e.c[] arr = new c[i13];
        final kotlin.d0.d.g gVar = null;
        arr[i2] = new c(16, 0.0f, 2, gVar);
        this.e = arr;
        nl.dionsegijn.konfetti.e.b[] arr2 = new b[i13];
        arr2[i2] = b.c.b;
        this.f = arr2;
        super(false, 0L, gVar, false, 0L, 0, gVar2, 31, 0);
        this.g = konfettiView2;
    }

    private final void m() {
        this.i.b(this);
    }

    private final void n(nl.dionsegijn.konfetti.c.b bVar) {
        c cVar = new c(this.b, this.c, this.e, this.f, this.d, this.g, bVar, 0L, i2, 128, 0);
        this.h = cVar;
        m();
    }

    public final b a(int... iArr) {
        n.f(iArr, "colors");
        this.d = iArr;
        return this;
    }

    public final b b(nl.dionsegijn.konfetti.e.b... bVarArr) {
        int i;
        n.f(bVarArr, "shapes");
        ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : bVarArr) {
            z = obj instanceof b;
        }
        Object[] array = arrayList.toArray(new b[i]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.f = array;
        return this;
    }

    public final b c(nl.dionsegijn.konfetti.e.c... cVarArr) {
        int i;
        n.f(cVarArr, "possibleSizes");
        ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : cVarArr) {
            z = obj instanceof c;
        }
        Object[] array = arrayList.toArray(new c[i]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.e = array;
        return this;
    }

    public final void d(int i) {
        final nl.dionsegijn.konfetti.c.a aVar = new a();
        aVar.e(i);
        n(aVar);
    }

    public final boolean e() {
        if (this.h == null) {
            n.w("renderSystem");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.h.e();
        }
    }

    public final long f() {
        return this.g.b();
    }

    public final nl.dionsegijn.konfetti.c.c g() {
        if (this.h == null) {
            n.w("renderSystem");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.h;
        }
    }

    public final b h(double d, double d2) {
        this.c.h(Math.toRadians(d));
        this.c.f(Double.valueOf(Math.toRadians(d2)));
        return this;
    }

    public final b i(boolean z) {
        this.g.f(z);
        return this;
    }

    public final b j(float f, Float float, float f2, Float float2) {
        this.b.a(f, float);
        this.b.b(f2, float2);
        return this;
    }

    public final b k(float f, float f2) {
        this.c.i(f);
        this.c.g(Float.valueOf(f2));
        return this;
    }

    public final b l(long j) {
        this.g.g(j);
        return this;
    }

    public final void o(int i, long j) {
        final d dVar = new d();
        d.f(dVar, i, j, 0, 4, null);
        n(dVar);
    }
}
