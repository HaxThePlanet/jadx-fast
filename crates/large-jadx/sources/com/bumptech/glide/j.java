package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.r.b;
import com.bumptech.glide.r.d;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class j<TranscodeType> extends com.bumptech.glide.r.a<j<TranscodeType>> implements java.lang.Cloneable {

    private final Context S;
    private final k T;
    private final Class<TranscodeType> U;
    private final e V;
    private l<?, ? super TranscodeType> W;
    private Object X;
    private List<f<TranscodeType>> Y;
    private j<TranscodeType> Z;
    private j<TranscodeType> a0;
    private Float b0;
    private boolean c0 = true;
    private boolean d0;
    private boolean e0;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[h.values().length];
            j.a.b = iArr;
            int i2 = 1;
            try {
                iArr[h.LOW.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i8 = 4;
                int[] iArr12 = new int[ImageView.ScaleType.values().length];
                j.a.a = iArr12;
                return;
            }
            int i = 2;
            try {
                j.a.b[h.NORMAL.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
    }

    protected j(c cVar, k kVar, Class<TranscodeType> cls, Context context) {
        super();
        this.T = kVar;
        this.U = cls;
        this.S = context;
        this.W = kVar.h(cls);
        this.V = cVar.i();
        y0(kVar.f());
        r0(kVar.g());
    }

    private <Y extends h<TranscodeType>> Y A0(Y y, f<TranscodeType> fVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        k.d(y);
        if (!this.d0) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        } else {
            d dVar = s0(y, fVar, aVar, executor);
            final d executor42 = y.getRequest();
            if (dVar.e(executor42) && !this.D0(aVar, executor42)) {
                k.d(executor42);
                if (!(d)executor42.isRunning()) {
                    executor42.i();
                }
                return y;
            }
            this.T.e(y);
            y.setRequest(dVar);
            this.T.s(y, dVar);
            return y;
        }
    }

    private boolean D0(com.bumptech.glide.r.a<?> aVar, d dVar) {
        boolean z2 = false;
        aVar = !aVar.J() && dVar.k() ? 1 : 0;
        return (!aVar.J() && dVar.k() ? 1 : 0);
    }

    private j<TranscodeType> L0(Object object) {
        if (I()) {
            return w0().L0(object);
        }
        this.X = object;
        this.d0 = true;
        e0();
        return (j)this;
    }

    private d M0(Object object, h<TranscodeType> hVar, f<TranscodeType> fVar, com.bumptech.glide.r.a<?> aVar, com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar2, int i, int i2, Executor executor) {
        final Object object3 = this;
        return i.z(object3.S, object3.V, object, object3.X, object3.U, aVar, i, i2, hVar2, hVar, fVar, object3.Y, eVar, object3.V.f(), lVar.b(), executor);
    }

    private d s0(h<TranscodeType> hVar, f<TranscodeType> fVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        return this.u0(new Object(), hVar, fVar, null, this.W, aVar.A(), aVar.x(), aVar.w(), aVar, executor);
    }

    private d u0(Object object, h<TranscodeType> hVar, f<TranscodeType> fVar, com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar2, int i, int i2, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        int i3;
        com.bumptech.glide.r.e eVar42;
        final Object object3 = this;
        if (object3.a0 != null) {
        } else {
            object2 = object;
            i = 0;
        }
        d dVar = this.v0(object, hVar, fVar, eVar42, lVar, hVar2, i, i2, aVar, executor);
        if (i == 0) {
            return dVar;
        }
        i2 = object3.a0.x();
        i3 = object3.a0.w();
        if (l.t(i, i2)) {
            if (!object3.a0.R()) {
                i2 = aVar.x();
                i3 = aVar.w();
            }
        }
        i.q(dVar, object3.a0.u0(object, hVar, fVar, i, lVar, object3.a0.A(), i2, i3, jVar, executor));
        return i;
    }

    private d v0(Object object, h<TranscodeType> hVar, f<TranscodeType> fVar, com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar2, int i, int i2, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        com.bumptech.glide.l lVar52;
        final Object object3 = this;
        Object object2 = object;
        com.bumptech.glide.r.e eVar42 = eVar;
        com.bumptech.glide.h hVar62 = hVar2;
        if (object3.Z != null) {
            if (object3.e0) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            } else {
                com.bumptech.glide.l r14 = jVar4.c0 ? lVar : jVar4.W;
                if (object3.Z.K()) {
                    hVar = object3.Z.A();
                } else {
                    hVar = object3.x0(hVar62);
                }
                i = object3.Z.x();
                i2 = object3.Z.w();
                if (l.t(i, i2)) {
                    if (!object3.Z.R()) {
                        i = aVar.x();
                        i2 = aVar.w();
                    }
                }
                com.bumptech.glide.r.j jVar2 = new j(object2, eVar42);
                object2 = object;
                h hVar22 = hVar;
                f fVar32 = fVar;
                object3.e0 = true;
                object3.e0 = false;
                jVar2.p(dVar, jVar.u0(object2, hVar22, fVar32, jVar2, lVar52, hVar, i, i2, object3.Z, executor));
                return jVar2;
            }
        }
        if (object3.b0 != null) {
            com.bumptech.glide.r.j jVar3 = new j(object2, eVar42);
            hVar22 = hVar;
            fVar32 = fVar;
            lVar52 = lVar;
            int i72 = i;
            int i82 = i2;
            Executor executor102 = executor;
            jVar3.p(this.M0(object, hVar22, fVar32, aVar, jVar3, lVar52, hVar2, i72, i82, executor102), this.M0(object, hVar22, fVar32, aVar.d().h0(object3.b0.floatValue()), jVar3, lVar52, object3.x0(hVar62), i72, i82, executor102));
            return jVar3;
        }
        return this.M0(object, hVar, fVar, aVar, eVar, lVar, hVar2, i, i2, executor);
    }

    private h x0(h hVar) {
        int i4 = j.a.b[hVar.ordinal()];
        if (i4 != 1 && i4 != 2) {
            int i = 3;
            return h.IMMEDIATE;
        }
        return h.NORMAL;
    }

    private void y0(List<f<Object>> list) {
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            q0((f)it.next());
        }
    }

    @Override // com.bumptech.glide.r.a
    <Y extends h<TranscodeType>> Y B0(Y y, f<TranscodeType> fVar, Executor executor) {
        A0(y, fVar, this, executor);
        return y;
    }

    @Override // com.bumptech.glide.r.a
    public com.bumptech.glide.r.k.i<ImageView, TranscodeType> C0(ImageView imageView) {
        com.bumptech.glide.r.a aVar;
        int ordinal;
        l.a();
        k.d(imageView);
        if (!Q() && this.O() && imageView.getScaleType() != null) {
            switch (j.a.a[imageView.getScaleType().ordinal()]) {
                case 1: /* ordinal */
                    aVar = this.d().T();
                    break;
                case 2: /* ordinal */
                    aVar = this.d().U();
                    break;
                case 3: /* ordinal */
                    aVar = this.d().V();
                    break;
                case 4: /* ordinal */
                    aVar = this.d().U();
                    break;
                default:
                    aVar = this;
            }
        }
        final com.bumptech.glide.r.k.i iVar = this.V.a(imageView, this.U);
        A0(iVar, null, aVar, e.b());
        return iVar;
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> E0(f<TranscodeType> fVar) {
        if (I()) {
            return w0().E0(fVar);
        }
        this.Y = null;
        return q0(fVar);
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> F0(Drawable drawable) {
        return L0(drawable).r0(g.s0(j.a));
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> G0(Uri uri) {
        return L0(uri);
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> H0(Integer integer) {
        return L0(integer).r0(g.u0(a.c(this.S)));
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> I0(Object object) {
        return L0(object);
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> K0(String str) {
        return L0(str);
    }

    @Deprecated
    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> O0(float f) {
        if (I()) {
            return w0().O0(f);
        }
        if (f < 0) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        } else {
            if (f <= 1065353216) {
                this.b0 = Float.valueOf(f);
                e0();
                return (j)this;
            }
        }
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> P0(l<?, ? super TranscodeType> lVar) {
        if (I()) {
            return w0().P0(lVar);
        }
        k.d(lVar);
        this.W = lVar;
        this.c0 = false;
        e0();
        return (j)this;
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> q0(f<TranscodeType> fVar) {
        if (I()) {
            return w0().q0(fVar);
        }
        if (fVar != null && this.Y == null) {
            this.Y = new ArrayList();
            this.Y.add(fVar);
        }
        e0();
        return (j)this;
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> r0(com.bumptech.glide.r.a<?> aVar) {
        k.d(aVar);
        return (j)super.a(aVar);
    }

    @Override // com.bumptech.glide.r.a
    public j<TranscodeType> w0() {
        final com.bumptech.glide.r.a aVar = super.d();
        aVar.W = aVar.W.a();
        if (aVar.Y != null) {
            aVar.Y = new ArrayList(aVar.Y);
        }
        if (aVar.Z != null) {
            aVar.Z = aVar.Z.w0();
        }
        if (aVar.a0 != null) {
            aVar.a0 = aVar.a0.w0();
        }
        return aVar;
    }

    @Override // com.bumptech.glide.r.a
    public <Y extends h<TranscodeType>> Y z0(Y y) {
        B0(y, null, e.b());
        return y;
    }
}
