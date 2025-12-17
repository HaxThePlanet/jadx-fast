package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import d.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.v.l.a {

    private final List<com.airbnb.lottie.v.l.a> A;
    private final RectF B;
    private final RectF C;
    private Paint D;
    private a<Float, Float> z = null;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[d.b.ADD.ordinal()] = 1;
            b.a.a[d.b.INVERT.ordinal()] = 2;
        }
    }
    public b(f f, com.airbnb.lottie.v.l.d d2, List<com.airbnb.lottie.v.l.d> list3, d d4) {
        int i;
        int i3;
        int i2;
        Object ordinal;
        com.airbnb.lottie.v.l.a aVar;
        long l;
        f obj10;
        long obj12;
        super(f, d2);
        ArrayList arrayList = new ArrayList();
        this.A = arrayList;
        RectF rectF = new RectF();
        this.B = rectF;
        RectF rectF2 = new RectF();
        this.C = rectF2;
        Paint paint = new Paint();
        this.D = paint;
        b obj11 = d2.s();
        int i4 = 0;
        obj11 = obj11.j();
        this.z = obj11;
        i(obj11);
        this.z.a(this);
        obj11 = new d(d4.j().size());
        final int i5 = 1;
        size2 -= i5;
        i3 = i4;
        while (i >= 0) {
            ordinal = list3.get(i);
            aVar = a.u((d)ordinal, f, d4);
            if (aVar == null) {
            } else {
            }
            obj11.k(aVar.v().b(), obj8);
            if (i3 != 0) {
            } else {
            }
            this.A.add(0, aVar);
            i2 = b.a.a[ordinal.f().ordinal()];
            if (i2 != i5 && i2 != 2) {
            } else {
            }
            i3 = aVar;
            i--;
            if (i2 != 2) {
            } else {
            }
            i3.E(aVar);
            i3 = i4;
        }
        while (i2 < obj11.n()) {
            obj10 = obj11.f(obj11.j(i2));
            if ((a)obj10 == null) {
            } else {
            }
            obj12 = obj11.f((a)obj10.v().h());
            if ((a)obj12 != null) {
            }
            i2++;
            obj10.G((a)obj12);
        }
    }

    protected void D(e e, int i2, List<e> list3, e e4) {
        int i;
        Object obj;
        i = 0;
        while (i < this.A.size()) {
            (a)this.A.get(i).c(e, i2, list3, e4);
            i++;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void F(boolean z) {
        Object next;
        super.F(z);
        Iterator iterator = this.A.iterator();
        for (a next : iterator) {
            next.F(z);
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void H(float f) {
        a aVar2;
        a aVar;
        int cmp;
        int i3;
        int i2;
        int i;
        float f2;
        float obj4;
        super.H(f);
        if (this.z != null) {
            obj4 = i2 / obj4;
        }
        if (this.z == null) {
            obj4 -= aVar;
        }
        if (Float.compare(f3, i) != 0) {
            obj4 /= cmp;
        }
        size--;
        while (i3 >= 0) {
            (a)this.A.get(i3).H(obj4);
            i3--;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        RectF rectF2;
        RectF rectF3;
        Matrix matrix;
        int obj5;
        super.d(rectF, matrix2, z3);
        final int obj6 = 1;
        obj5 -= obj6;
        while (obj5 >= 0) {
            int i = 0;
            this.B.set(i, i, i, i);
            (a)this.A.get(obj5).d(this.B, this.m, obj6);
            rectF.union(this.B);
            obj5--;
        }
    }

    public <T> void g(T t, c<T> c2) {
        Object obj2;
        c obj3;
        super.g(t, c2);
        if (t == k.C) {
            if (c2 == null) {
                obj2 = this.z;
                if (obj2 != null) {
                    obj2.n(0);
                }
            } else {
                obj2 = new p(c2);
                this.z = obj2;
                obj2.a(this);
                i(this.z);
            }
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix2, int i3) {
        boolean size;
        int i;
        int i4;
        int clipRect;
        RectF i2;
        Paint paint;
        int obj9;
        final String str = "CompositionLayer#draw";
        c.a(str);
        i2 = 0;
        this.C.set(i2, i2, (float)i5, (float)i6);
        matrix2.mapRect(this.C);
        clipRect = 255;
        int i7 = 1;
        if (this.n.H() && this.A.size() > i7 && i3 != clipRect) {
            if (this.A.size() > i7) {
                i = i3 != clipRect ? i7 : 0;
            } else {
            }
        } else {
        }
        if (i != 0) {
            this.D.setAlpha(i3);
            h.m(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (i != 0) {
            obj9 = clipRect;
        }
        size2 -= i7;
        while (i4 >= 0) {
            if (!this.C.isEmpty()) {
            } else {
            }
            clipRect = i7;
            if (clipRect != 0) {
            }
            i4--;
            (a)this.A.get(i4).f(canvas, matrix2, obj9);
            clipRect = canvas.clipRect(this.C);
        }
        canvas.restore();
        c.b(str);
    }
}
