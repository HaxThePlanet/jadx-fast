package nl.dionsegijn.konfetti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import kotlin.d0.d.n;
import nl.dionsegijn.konfetti.c.a;
import nl.dionsegijn.konfetti.c.b;
import nl.dionsegijn.konfetti.c.c;
import nl.dionsegijn.konfetti.c.d;
import nl.dionsegijn.konfetti.e.a;
import nl.dionsegijn.konfetti.e.b;
import nl.dionsegijn.konfetti.e.b.c;
import nl.dionsegijn.konfetti.e.c;
import nl.dionsegijn.konfetti.f.a;
import nl.dionsegijn.konfetti.f.b;

/* loaded from: classes3.dex */
public final class b {

    private final Random a;
    private a b;
    private b c;
    private int[] d;
    private c[] e;
    private b[] f;
    private a g;
    public c h;
    private final nl.dionsegijn.konfetti.KonfettiView i;
    public b(nl.dionsegijn.konfetti.KonfettiView konfettiView) {
        n.f(konfettiView, "konfettiView");
        super();
        this.i = konfettiView;
        Random obj14 = new Random();
        this.a = obj14;
        a aVar = new a(obj14);
        this.b = aVar;
        b bVar = new b(obj14);
        this.c = bVar;
        obj14 = 1;
        int[] iArr = new int[obj14];
        final int i2 = 0;
        iArr[i2] = -65536;
        this.d = iArr;
        c[] arr = new c[obj14];
        final int i8 = 0;
        c cVar2 = new c(16, 0, 2, i8);
        arr[i2] = cVar2;
        this.e = arr;
        obj14 = new b[obj14];
        obj14[i2] = b.c.b;
        this.f = obj14;
        super(0, 0, i8, 0, 0, 0, obj10, 31, 0);
        this.g = obj14;
    }

    private final void m() {
        this.i.b(this);
    }

    private final void n(b b) {
        super(this.b, this.c, this.e, this.f, this.d, this.g, b, 0, obj9, 128, 0);
        this.h = cVar2;
        m();
    }

    public final nl.dionsegijn.konfetti.b a(int... iArr) {
        n.f(iArr, "colors");
        this.d = iArr;
        return this;
    }

    public final nl.dionsegijn.konfetti.b b(b... bArr) {
        int i;
        Object obj;
        boolean z;
        n.f(bArr, "shapes");
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        i = i2;
        while (i < bArr.length) {
            obj = bArr[i];
            if (obj instanceof b) {
            }
            i++;
            arrayList.add(obj);
        }
        Object[] obj7 = arrayList.toArray(new b[i2]);
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Array<T>");
        this.f = (b[])obj7;
        return this;
    }

    public final nl.dionsegijn.konfetti.b c(c... cArr) {
        int i;
        Object obj;
        boolean z;
        n.f(cArr, "possibleSizes");
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        i = i2;
        while (i < cArr.length) {
            obj = cArr[i];
            if (obj instanceof c) {
            }
            i++;
            arrayList.add(obj);
        }
        Object[] obj7 = arrayList.toArray(new c[i2]);
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Array<T>");
        this.e = (c[])obj7;
        return this;
    }

    public final void d(int i) {
        a aVar = new a();
        aVar.e(i);
        n(aVar);
    }

    public final boolean e() {
        c cVar = this.h;
        if (cVar == null) {
        } else {
            return cVar.e();
        }
        n.w("renderSystem");
        throw 0;
    }

    public final long f() {
        return this.g.b();
    }

    public final c g() {
        c cVar = this.h;
        if (cVar == null) {
        } else {
            return cVar;
        }
        n.w("renderSystem");
        throw 0;
    }

    public final nl.dionsegijn.konfetti.b h(double d, double d2) {
        this.c.h(Math.toRadians(d));
        this.c.f(Double.valueOf(Math.toRadians(obj4)));
        return this;
    }

    public final nl.dionsegijn.konfetti.b i(boolean z) {
        this.g.f(z);
        return this;
    }

    public final nl.dionsegijn.konfetti.b j(float f, Float float2, float f3, Float float4) {
        this.b.a(f, float2);
        this.b.b(f3, float4);
        return this;
    }

    public final nl.dionsegijn.konfetti.b k(float f, float f2) {
        this.c.i(f);
        this.c.g(Float.valueOf(f2));
        return this;
    }

    public final nl.dionsegijn.konfetti.b l(long l) {
        this.g.g(l);
        return this;
    }

    public final void o(int i, long l2) {
        d dVar3 = new d();
        d.f(dVar3, i, l2, obj3, 0, 4);
        n(dVar3);
    }
}
