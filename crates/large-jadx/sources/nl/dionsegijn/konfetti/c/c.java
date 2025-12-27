package nl.dionsegijn.konfetti.c;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.w;
import nl.dionsegijn.konfetti.e.b.b;
import nl.dionsegijn.konfetti.e.d;

/* compiled from: RenderSystem.kt */
/* loaded from: classes3.dex */
public final class c {

    private boolean a;
    private final Random b;
    private d c;
    private final List<nl.dionsegijn.konfetti.a> d;
    private final nl.dionsegijn.konfetti.f.a e;
    private final nl.dionsegijn.konfetti.f.b f;
    private final nl.dionsegijn.konfetti.e.c[] g;
    private final nl.dionsegijn.konfetti.e.b[] h;
    private final int[] i;
    private final nl.dionsegijn.konfetti.e.a j;
    private final b k;
    private final long l;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "l", "()V"}, k = 3, mv = {1, 4, 0})
    static final class a extends k implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.k
        public final void l() {
            (c)this.receiver.b();
        }

        a() {
            super(0, cVar, c.class, "addConfetti", "addConfetti()V", 0);
        }
    }
    public c(nl.dionsegijn.konfetti.f.a aVar, nl.dionsegijn.konfetti.f.b bVar, nl.dionsegijn.konfetti.e.c[] cVarArr, nl.dionsegijn.konfetti.e.b[] bVarArr, int[] iArr, nl.dionsegijn.konfetti.e.a aVar2, b bVar2, long j) {
        n.f(aVar, "location");
        n.f(bVar, "velocity");
        n.f(cVarArr, "sizes");
        n.f(bVarArr, "shapes");
        n.f(iArr, "colors");
        n.f(aVar2, "config");
        n.f(bVar2, "emitter");
        super();
        this.e = aVar;
        this.f = bVar;
        this.g = cVarArr;
        this.h = bVarArr;
        this.i = iArr;
        this.j = aVar2;
        this.k = bVar2;
        this.l = j;
        this.a = true;
        this.b = new Random();
        this.c = new d(0.0f, 0.01f);
        this.d = new ArrayList();
        bVar2.d(new c.a(this));
    }

    public static final /* synthetic */ void a(c cVar) {
        cVar.b();
    }

    private final void b() {
        final Object obj = this;
        a aVar = new a(new d(obj.e.c(), obj.e.d()), iArr[obj.b.nextInt(iArr.length)], objArr[obj.b.nextInt(objArr.length)], d(), obj.j.e(), z, obj.j.c(), null, obj.f.e(), obj.j.d(), obj.j.a(), obj.f.a(), obj.f.c(), 64, 0);
        obj.d.add(aVar);
    }

    private final nl.dionsegijn.konfetti.e.b d() {
        nl.dionsegijn.konfetti.e.b bVar;
        Drawable mutate;
        length = objArr.length;
        bVar = objArr[this.b.nextInt(length)];
        z = bVar instanceof b.b;
        if (bVar instanceof b.b) {
            Drawable.ConstantState constantState = bVar.d().getConstantState();
            if (constantState == null || drawable2 == null || drawable2.mutate() == null) {
                mutate = bVar.d();
            }
            n.e(mutate, "shape.drawable.constantS…utate() ?: shape.drawable");
            int i = 2;
            Object obj = null;
            b.b bVar2 = b.b.c(bVar, mutate, false, i, obj);
        }
        return bVar;
    }

    public final long c() {
        return this.l;
    }

    public final boolean e() {
        boolean z3 = true;
        if (this.k.c()) {
            if (this.d.size() == 0 || !this.a) {
                int i = 1;
            } else {
                int r0 = this.d.size() == 0 ? 1 : 0;
            }
        }
        return (this.d.size() == 0 ? 1 : 0);
    }

    public final void f(Canvas canvas, float f) {
        int i;
        boolean z2;
        n.f(canvas, "canvas");
        if (this.a) {
            this.k.a(f);
        }
        i = this.d.size() - 1;
        while (this.d >= 0) {
            Object item = this.d.get(i);
            item.a(this.c);
            item.e(canvas, f);
            i = i - 1;
        }
    }

    public /* synthetic */ c(nl.dionsegijn.konfetti.f.a aVar, nl.dionsegijn.konfetti.f.b bVar, nl.dionsegijn.konfetti.e.c[] cVarArr, nl.dionsegijn.konfetti.e.b[] bVarArr, int[] iArr, nl.dionsegijn.konfetti.e.a aVar2, b bVar2, long j, int i, g gVar) {
        long j82;
        j82 = i & 128 != 0 ? j82 : j;
        this(aVar, bVar, cVarArr, bVarArr, iArr, aVar2, bVar2, j82, obj);
    }
}
