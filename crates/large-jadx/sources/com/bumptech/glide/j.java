package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.b;
import com.bumptech.glide.r.d;
import com.bumptech.glide.r.e;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.i;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.r.k.i;
import com.bumptech.glide.s.a;
import com.bumptech.glide.t.e;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class j<TranscodeType>  extends a<com.bumptech.glide.j<TranscodeType>> implements java.lang.Cloneable {

    private final Context S;
    private final com.bumptech.glide.k T;
    private final Class<TranscodeType> U;
    private final com.bumptech.glide.e V;
    private com.bumptech.glide.l<?, ? super TranscodeType> W;
    private Object X;
    private List<f<TranscodeType>> Y;
    private com.bumptech.glide.j<TranscodeType> Z;
    private com.bumptech.glide.j<TranscodeType> a0;
    private Float b0;
    private boolean c0 = true;
    private boolean d0;
    private boolean e0;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            j.a.b = iArr;
            int i2 = 1;
            iArr[h.LOW.ordinal()] = i2;
            int i = 2;
            j.a.b[h.NORMAL.ordinal()] = i;
            int i3 = 3;
            j.a.b[h.HIGH.ordinal()] = i3;
            int i8 = 4;
            j.a.b[h.IMMEDIATE.ordinal()] = i8;
            int[] iArr12 = new int[values2.length];
            j.a.a = iArr12;
            iArr12[ImageView.ScaleType.CENTER_CROP.ordinal()] = i2;
            j.a.a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = i;
            j.a.a[ImageView.ScaleType.FIT_CENTER.ordinal()] = i3;
            j.a.a[ImageView.ScaleType.FIT_START.ordinal()] = i8;
            j.a.a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            j.a.a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            j.a.a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            j.a.a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
        }
    }
    static {
        g gVar = new g();
        a aVar3 = (g)(g)gVar.f(j.b).b0(h.LOW).i0(true);
    }

    protected j(com.bumptech.glide.c c, com.bumptech.glide.k k2, Class<TranscodeType> class3, Context context4) {
        super();
        final int i = 1;
        this.T = k2;
        this.U = class3;
        this.S = context4;
        this.W = k2.h(class3);
        this.V = c.i();
        y0(k2.f());
        r0(k2.g());
    }

    private <Y extends h<TranscodeType>> Y A0(Y y, f<TranscodeType> f2, a<?> a3, Executor executor4) {
        a obj4;
        k.d(y);
        if (!this.d0) {
        } else {
            d obj3 = s0(y, f2, a3, executor4);
            final d obj5 = y.getRequest();
            k.d(obj5);
            if (obj3.e(obj5) && !D0(a3, obj5) && !(d)obj5.isRunning()) {
                if (!D0(a3, obj5)) {
                    k.d(obj5);
                    if (!(d)obj5.isRunning()) {
                        obj5.i();
                    }
                    return y;
                }
            }
            this.T.e(y);
            y.setRequest(obj3);
            this.T.s(y, obj3);
            return y;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("You must call #load() before calling #into()");
        throw obj2;
    }

    private boolean D0(a<?> a, d d2) {
        boolean obj1;
        if (!a.J() && d2.k()) {
            obj1 = d2.k() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private com.bumptech.glide.j<TranscodeType> L0(Object object) {
        if (I()) {
            return w0().L0(object);
        }
        this.X = object;
        this.d0 = true;
        e0();
        return (j)this;
    }

    private d M0(Object object, h<TranscodeType> h2, f<TranscodeType> f3, a<?> a4, e e5, com.bumptech.glide.l<?, ? super TranscodeType> l6, com.bumptech.glide.h h7, int i8, int i9, Executor executor10) {
        final Object obj = this;
        final com.bumptech.glide.e eVar = obj.V;
        return i.z(obj.S, eVar, object, obj.X, obj.U, a4, i8, i9, h7, h2, f3, obj.Y, e5, eVar.f(), l6.b(), executor10);
    }

    private d s0(h<TranscodeType> h, f<TranscodeType> f2, a<?> a3, Executor executor4) {
        Object object = new Object();
        return this.u0(object, h, f2, 0, this.W, a3.A(), a3.x(), a3.w(), a3, executor4);
    }

    private d u0(Object object, h<TranscodeType> h2, f<TranscodeType> f3, e e4, com.bumptech.glide.l<?, ? super TranscodeType> l5, com.bumptech.glide.h h6, int i7, int i8, a<?> a9, Executor executor10) {
        int bVar;
        e eVar2;
        int i3;
        int i;
        boolean z;
        e eVar;
        Object obj;
        int i2;
        final Object obj4 = this;
        if (obj4.a0 != null) {
            bVar = new b(object, e4);
            i2 = eVar;
        } else {
            obj = object;
            i2 = bVar;
            eVar = eVar2;
        }
        d dVar = this.v0(object, h2, f3, eVar, l5, h6, i7, i8, a9, executor10);
        if (i2 == 0) {
            return dVar;
        }
        i3 = obj4.a0.x();
        i = obj4.a0.w();
        if (l.t(i7, i8) && !obj4.a0.R()) {
            if (!obj4.a0.R()) {
                i3 = a9.x();
                i = a9.w();
            }
        }
        final com.bumptech.glide.j jVar6 = obj4.a0;
        int i4 = i2;
        i4.q(dVar, jVar6.u0(object, h2, f3, i4, jVar6.W, jVar6.A(), i3, i, obj4.a0, executor10));
        return i4;
    }

    private d v0(Object object, h<TranscodeType> h2, f<TranscodeType> f3, e e4, com.bumptech.glide.l<?, ? super TranscodeType> l5, com.bumptech.glide.h h6, int i7, int i8, a<?> a9, Executor executor10) {
        com.bumptech.glide.h hVar;
        int i2;
        int i;
        boolean z;
        com.bumptech.glide.l lVar;
        final Object obj9 = this;
        Object obj10 = object;
        e eVar = e4;
        com.bumptech.glide.h hVar10 = h6;
        com.bumptech.glide.j jVar = obj9.Z;
        if (jVar != null) {
            if (obj9.e0) {
            } else {
                lVar = jVar.c0 ? l5 : lVar2;
                if (jVar.K()) {
                    hVar = obj9.Z.A();
                } else {
                    hVar = obj9.x0(hVar10);
                }
                i2 = obj9.Z.x();
                i = obj9.Z.w();
                if (l.t(i7, i8) && !obj9.Z.R()) {
                    if (!obj9.Z.R()) {
                        i2 = a9.x();
                        i = a9.w();
                    }
                }
                j jVar11 = new j(obj10, eVar);
                Object obj5 = object;
                h hVar2 = h2;
                f fVar = f3;
                j jVar12 = jVar11;
                obj9.e0 = true;
                com.bumptech.glide.j jVar10 = obj9.Z;
                obj9.e0 = false;
                jVar12.p(this.M0(obj5, hVar2, fVar, a9, jVar11, l5, h6, i7, i8, executor10), jVar10.u0(obj5, hVar2, fVar, jVar12, lVar, hVar, i2, i, jVar10, executor10));
                return jVar12;
            }
            IllegalStateException illegalStateException = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            throw illegalStateException;
        }
        if (obj9.b0 != null) {
            j jVar13 = new j(obj10, eVar);
            h hVar3 = h2;
            f fVar2 = f3;
            j jVar9 = jVar13;
            com.bumptech.glide.l lVar5 = l5;
            int i10 = i7;
            int i13 = i8;
            Executor executor3 = executor10;
            jVar13.p(this.M0(object, hVar3, fVar2, a9, jVar9, lVar5, h6, i10, i13, executor3), this.M0(object, hVar3, fVar2, a9.d().h0(obj9.b0.floatValue()), jVar9, lVar5, obj9.x0(hVar10), i10, i13, executor3));
            return jVar13;
        }
        return this.M0(object, h2, f3, a9, e4, l5, h6, i7, i8, executor10);
    }

    private com.bumptech.glide.h x0(com.bumptech.glide.h h) {
        int i;
        int obj3 = j.a.b[h.ordinal()];
        if (obj3 != 1 && obj3 != 2 && obj3 != 3) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    if (obj3 != 4) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unknown priority: ");
                    stringBuilder.append(A());
                    obj3 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj3;
                }
                return h.IMMEDIATE;
            }
            return h.HIGH;
        }
        return h.NORMAL;
    }

    private void y0(List<f<Object>> list) {
        Object next;
        final Iterator obj2 = list.iterator();
        for (f next : obj2) {
            q0(next);
        }
    }

    <Y extends h<TranscodeType>> Y B0(Y y, f<TranscodeType> f2, Executor executor3) {
        A0(y, f2, this, executor3);
        return y;
    }

    public i<ImageView, TranscodeType> C0(ImageView imageView) {
        Object obj;
        boolean scaleType;
        int ordinal;
        l.a();
        k.d(imageView);
        if (!Q() && O() && imageView.getScaleType() != null) {
            if (O()) {
                if (imageView.getScaleType() != null) {
                    switch (scaleType) {
                        case 1:
                            obj = d().T();
                            break;
                        case 2:
                            obj = d().U();
                            break;
                        case 3:
                            obj = d().V();
                            break;
                        case 4:
                            obj = d().U();
                            break;
                        default:
                            obj = this;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        final i obj4 = this.V.a(imageView, this.U);
        A0(obj4, 0, obj, e.b());
        return (i)obj4;
    }

    public com.bumptech.glide.j<TranscodeType> E0(f<TranscodeType> f) {
        if (I()) {
            return w0().E0(f);
        }
        this.Y = 0;
        return q0(f);
    }

    public com.bumptech.glide.j<TranscodeType> F0(Drawable drawable) {
        return L0(drawable).r0(g.s0(j.a));
    }

    public com.bumptech.glide.j<TranscodeType> G0(Uri uri) {
        return L0(uri);
    }

    public com.bumptech.glide.j<TranscodeType> H0(Integer integer) {
        return L0(integer).r0(g.u0(a.c(this.S)));
    }

    public com.bumptech.glide.j<TranscodeType> I0(Object object) {
        return L0(object);
    }

    public com.bumptech.glide.j<TranscodeType> K0(String string) {
        return L0(string);
    }

    @Deprecated
    public com.bumptech.glide.j<TranscodeType> O0(float f) {
        int cmp;
        if (I()) {
            return w0().O0(f);
        }
        if (Float.compare(f, i) < 0) {
        } else {
            if (Float.compare(f, i2) > 0) {
            } else {
                this.b0 = Float.valueOf(f);
                e0();
                return (j)this;
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        throw obj2;
    }

    public com.bumptech.glide.j<TranscodeType> P0(com.bumptech.glide.l<?, ? super TranscodeType> l) {
        if (I()) {
            return w0().P0(l);
        }
        k.d(l);
        this.W = (l)l;
        this.c0 = false;
        e0();
        return (j)this;
    }

    @Override // com.bumptech.glide.r.a
    public a a(a a) {
        return r0(a);
    }

    @Override // com.bumptech.glide.r.a
    public Object clone() {
        return w0();
    }

    @Override // com.bumptech.glide.r.a
    public a d() {
        return w0();
    }

    public com.bumptech.glide.j<TranscodeType> q0(f<TranscodeType> f) {
        Object arrayList;
        boolean z;
        if (I()) {
            return w0().q0(f);
        }
        if (f != null && this.Y == null) {
            if (this.Y == null) {
                arrayList = new ArrayList();
                this.Y = arrayList;
            }
            this.Y.add(f);
        }
        e0();
        return (j)this;
    }

    public com.bumptech.glide.j<TranscodeType> r0(a<?> a) {
        k.d(a);
        return (j)super.a(a);
    }

    public com.bumptech.glide.j<TranscodeType> w0() {
        Object arrayList;
        com.bumptech.glide.j jVar2;
        com.bumptech.glide.j jVar;
        List list;
        final a aVar = super.d();
        aVar.W = aVar.W.a();
        if (aVar.Y != null) {
            arrayList = new ArrayList(aVar.Y);
            aVar.Y = arrayList;
        }
        jVar2 = aVar.Z;
        if (jVar2 != null) {
            aVar.Z = jVar2.w0();
        }
        jVar = aVar.a0;
        if (jVar != null) {
            aVar.a0 = jVar.w0();
        }
        return (j)aVar;
    }

    public <Y extends h<TranscodeType>> Y z0(Y y) {
        B0(y, 0, e.b());
        return y;
    }
}
