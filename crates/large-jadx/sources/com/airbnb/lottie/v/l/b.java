package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.y.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b extends a {

    private final List<a> A = new ArrayList<>();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private Paint D = new Paint();
    private a<Float, Float> z = null;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[d.b.values().length];
            b.a.a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[d.b.INVERT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public b(f fVar, d dVar, List<d> list, com.airbnb.lottie.d dVar2) {
        int i2;
        int i;
        int i3 = 0;
        int ordinal = 2;
        Object item;
        long l;
        long l2;
        super(fVar, dVar);
        ArrayList arrayList = new ArrayList();
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        Paint paint = new Paint();
        b bVar2 = dVar.s();
        i = 0;
        a aVar2 = bVar2.j();
        this.z = aVar2;
        i(aVar2);
        this.z.a(this);
        d.e.d dVar3 = new d(dVar2.j().size());
        final int i4 = 1;
        i2 = list.size() - i4;
        i3 = 0;
        while (i2 >= 0) {
            item = list.get(i2);
            com.airbnb.lottie.v.l.a aVar = a.u(item, fVar, dVar2);
            i2 = i2 - 1;
        }
        while (i3 < dVar3.n()) {
            Object obj = dVar3.f(dVar3.j(i3));
            i3 = i3 + 1;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    protected void D(e eVar, int i, List<e> list, e eVar2) {
        i = 0;
        while (i < this.A.size()) {
            (a)this.A.get(i).c(eVar, i, list, eVar2);
            i = i + 1;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void F(boolean z) {
        super.F(z);
        Iterator it = this.A.iterator();
        while (it.hasNext()) {
            (a)it.next().F(z);
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void H(float f) {
        int i;
        float f5;
        super.H(f);
        if (this.z != null) {
            f2 = (Float)this.z.h().floatValue() * this.o.a().h() - this.o.a().o();
            f5 = f2 / (this.n.o().e() + 0.01f);
        }
        if (this.z == null) {
            f5 = f5 - this.o.p();
        }
        float f7 = this.o.t();
        float f3 = 0.0f;
        if (f7 != 0.0f) {
            f5 = f5 / this.o.t();
        }
        i = this.A.size() - 1;
        while (this.A >= 0) {
            (a)this.A.get(i).H(f5);
            i = i - 1;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix, boolean z) {
        int i;
        super.d(rectF, matrix, z);
        final int i2 = 1;
        i = this.A.size() - i2;
        while (this.A >= 0) {
            float f = 0.0f;
            this.B.set(f, f, f, f);
            (a)this.A.get(i).d(this.B, this.m, true);
            rectF.union(this.B);
            i = i - 1;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        super.g(t, cVar);
        if (this.z == k.C && cVar == null && this.z != null) {
            cVar = null;
            this.z.n(cVar);
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix, int i) {
        int i2;
        final String str = "CompositionLayer#draw";
        c.a(str);
        float f3 = 0.0f;
        this.C.set(f3, f3, (float)this.o.j(), (float)this.o.i());
        matrix.mapRect(this.C);
        i = 255;
        i = 1;
        if (this.n.H()) {
            int r1 = this.A.size() > i && i != i ? i : 0;
        }
        if (this.A != 0) {
            this.D.setAlpha(i);
            h.m(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (this.A != 0) {
        }
        i2 = this.A.size() - i;
        while (this.A >= 0) {
            i2 = i2 - 1;
        }
        canvas.restore();
        c.b(str);
    }
}
