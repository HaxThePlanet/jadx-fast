package nl.dionsegijn.konfetti.c;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.w;
import nl.dionsegijn.konfetti.a;
import nl.dionsegijn.konfetti.e.a;
import nl.dionsegijn.konfetti.e.b;
import nl.dionsegijn.konfetti.e.b.b;
import nl.dionsegijn.konfetti.e.c;
import nl.dionsegijn.konfetti.e.d;
import nl.dionsegijn.konfetti.f.a;
import nl.dionsegijn.konfetti.f.b;

/* loaded from: classes3.dex */
public final class c {

    private boolean a;
    private final Random b;
    private d c;
    private final List<a> d;
    private final a e;
    private final b f;
    private final c[] g;
    private final b[] h;
    private final int[] i;
    private final a j;
    private final nl.dionsegijn.konfetti.c.b k;
    private final long l;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "l", "()V"}, k = 3, mv = {1, 4, 0})
    static final class a extends k implements a<w> {
        a(nl.dionsegijn.konfetti.c.c c) {
            super(0, c, c.class, "addConfetti", "addConfetti()V", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke() {
            l();
            return w.a;
        }

        @Override // kotlin.d0.d.k
        public final void l() {
            c.a((c)this.receiver);
        }
    }
    public c(a a, b b2, c[] c3Arr3, b[] b4Arr4, int[] i5Arr5, a a6, nl.dionsegijn.konfetti.c.b b7, long l8) {
        n.f(a, "location");
        n.f(b2, "velocity");
        n.f(c3Arr3, "sizes");
        n.f(b4Arr4, "shapes");
        n.f(i5Arr5, "colors");
        n.f(a6, "config");
        n.f(b7, "emitter");
        super();
        this.e = a;
        this.f = b2;
        this.g = c3Arr3;
        this.h = b4Arr4;
        this.i = i5Arr5;
        this.j = a6;
        this.k = b7;
        this.l = l8;
        this.a = true;
        Random obj2 = new Random();
        this.b = obj2;
        obj2 = new d(0, 1008981770);
        this.c = obj2;
        obj2 = new ArrayList();
        this.d = obj2;
        obj2 = new c.a(this);
        b7.d(obj2);
    }

    public c(a a, b b2, c[] c3Arr3, b[] b4Arr4, int[] i5Arr5, a a6, nl.dionsegijn.konfetti.c.b b7, long l8, int i9, g g10) {
        long currentTimeMillis;
        long l;
        if (i &= 128 != 0) {
            l = currentTimeMillis;
        } else {
            l = l8;
        }
        super(a, b2, c3Arr3, b4Arr4, i5Arr5, a6, b7, l, obj11);
    }

    public static final void a(nl.dionsegijn.konfetti.c.c c) {
        c.b();
    }

    private final void b() {
        final Object obj = this;
        d dVar = new d(obj.e.c(), obj.e.d());
        c[] objArr = obj.g;
        int[] iArr = obj.i;
        super(dVar, iArr[obj.b.nextInt(iArr.length)], objArr[obj.b.nextInt(objArr.length)], d(), obj.j.e(), obj8, obj.j.c(), 0, obj.f.e(), obj.j.d(), obj.j.a(), obj.f.a(), obj.f.c(), 64, 0);
        obj.d.add(aVar9);
    }

    private final b d() {
        b bVar;
        boolean constantState;
        int length;
        int i2;
        int i;
        b[] objArr = this.h;
        bVar = objArr[this.b.nextInt(objArr.length)];
        if (bVar instanceof b.b) {
            constantState = (b.b)bVar.d().getConstantState();
            constantState = constantState.newDrawable();
            if (constantState != null && constantState != null && constantState.mutate() != null) {
                constantState = constantState.newDrawable();
                if (constantState != null) {
                    if (constantState.mutate() != null) {
                    } else {
                        constantState = bVar.d();
                    }
                } else {
                }
            } else {
            }
            n.e(constantState, "shape.drawable.constantS…utate() ?: shape.drawable");
            bVar = b.b.c(bVar, constantState, false, 2, 0);
        }
        return bVar;
    }

    public final long c() {
        return this.l;
    }

    public final boolean e() {
        int i;
        int size;
        if (this.k.c()) {
            if (this.d.size() != 0) {
                if (!this.a && this.d.size() == 0) {
                    i = this.d.size() == 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final void f(Canvas canvas, float f2) {
        boolean z;
        int i;
        boolean z2;
        d dVar;
        n.f(canvas, "canvas");
        if (this.a) {
            this.k.a(f2);
        }
        size--;
        while (i >= 0) {
            Object obj = this.d.get(i);
            (a)obj.a(this.c);
            obj.e(canvas, f2);
            if (obj.d()) {
            }
            i--;
            this.d.remove(i);
        }
    }
}
