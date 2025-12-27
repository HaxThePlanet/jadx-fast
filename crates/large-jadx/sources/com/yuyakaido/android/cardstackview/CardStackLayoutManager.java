package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.a0.b;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.w;
import com.yuyakaido.android.cardstackview.i.c;
import com.yuyakaido.android.cardstackview.i.d;
import com.yuyakaido.android.cardstackview.i.d.b;
import com.yuyakaido.android.cardstackview.i.f;
import com.yuyakaido.android.cardstackview.i.f.b;
import com.yuyakaido.android.cardstackview.i.g;
import java.util.List;

/* compiled from: CardStackLayoutManager.java */
/* loaded from: classes2.dex */
public class CardStackLayoutManager extends RecyclerView.p implements RecyclerView.a0.b {

    private final Context s;
    private a t;
    private c u;
    private f v;

    class a implements Runnable {

        final /* synthetic */ b a;
        final /* synthetic */ CardStackLayoutManager b;
        a(b bVar) {
            this.b = cardStackLayoutManager;
            this.a = bVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.t.c(this.a);
            if (this.b.o2() != null) {
                this.b.t.a(this.b.o2(), this.b.v.f);
            }
        }
    }

    static class b {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static {
            int[] iArr = new int[b.values().length];
            CardStackLayoutManager.b.c = iArr;
            int i2 = 1;
            try {
                iArr[b.Left.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i4 = 4;
                int[] iArr11 = new int[f.values().length];
                CardStackLayoutManager.b.b = iArr11;
                int i5 = 5;
                int i6 = 6;
                int i7 = 7;
                int[] iArr20 = new int[f.b.values().length];
                CardStackLayoutManager.b.a = iArr20;
                return;
            }
            int i = 2;
            try {
                CardStackLayoutManager.b.c[b.Right.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                i5 = 5;
                i6 = 6;
                i7 = 7;
                iArr20 = new int[f.b.values().length];
                CardStackLayoutManager.b.a = iArr20;
                return;
            }
        }
    }
    public CardStackLayoutManager(Context context) {
        this(context, a.a);
    }

    private void B2(int i) {
        this.v.h = 0.0f;
        this.v.g = i;
        final d dVar = new d(d.b.AutomaticSwipe, this);
        dVar.setTargetPosition(this.v.f);
        f2(dVar);
    }

    private void C2(int i) {
        if (this.v.f < i) {
            B2(i);
        } else {
            D2(i);
        }
    }

    private void D2(int i) {
        if (o2() != null) {
            this.t.e(o2(), this.v.f);
        }
        this.v.h = 0.0f;
        this.v.g = i;
        fVar.f--;
        d dVar = new d(d.b.AutomaticRewind, this);
        dVar.setTargetPosition(this.v.f);
        f2(dVar);
    }

    private void E2(RecyclerView.w wVar) {
        int i7;
        this.v.b = H0();
        this.v.c = t0();
        int i2 = 0;
        if (this.v.d()) {
            H1(o2(), wVar);
            this.v.e(fVar7.a.toAnimatedStatus());
            fVar8.f++;
            this.v.d = i2;
            this.v.e = i2;
            if (fVar8.f == fVar8.g) {
                int i4 = -1;
                this.v.g = i4;
            }
            new Handler().post(new CardStackLayoutManager.a(this, this.v.b()));
        }
        T(wVar);
        i8 = this.v.f + this.u.b;
        while (i7 < this.v.f + this.u.b) {
        }
        if (this.v.a.isDragging()) {
            this.t.d(this.v.b(), this.v.c());
        }
    }

    private void F2(View view) {
        View viewById = view.findViewById(d.b);
        float f = 0.0f;
        if (viewById != null) {
            viewById.setAlpha(0.0f);
        }
        View viewById2 = view.findViewById(d.c);
        if (viewById2 != null) {
            viewById2.setAlpha(0.0f);
        }
        View viewById3 = view.findViewById(d.d);
        if (viewById3 != null) {
            viewById3.setAlpha(0.0f);
        }
        final View viewById4 = view.findViewById(d.a);
        if (viewById4 != null) {
            viewById4.setAlpha(0.0f);
        }
        float interpolation = this.u.m.getInterpolation(this.v.c());
        int i3 = CardStackLayoutManager.b.c[this.v.b().ordinal()];
        if (this.v != 1) {
            int i = 2;
            if (this.v != 2) {
                i = 3;
                if (this.v != 3) {
                    i = 4;
                    if (this.v == 4) {
                        if (viewById4 != null) {
                            viewById4.setAlpha(interpolation);
                        }
                    }
                } else {
                    if (viewById3 != null) {
                        viewById3.setAlpha(interpolation);
                    }
                }
            } else {
                if (viewById2 != null) {
                    viewById2.setAlpha(interpolation);
                }
            }
        } else {
            if (viewById != null) {
                viewById.setAlpha(interpolation);
            }
        }
    }

    private void H2(View view) {
        view.setRotation((float)this.v.d * this.u.f / (float)H0() * this.v.h);
    }

    private void I2(View view, int i) {
        float f6 = 1f;
        float f13 = f6 - (float)i * (f6 - f4);
        f13 += f9;
        switch (CardStackLayoutManager.b.b[this.u.a.ordinal()]) {
            case 1: /* ordinal */
                view.setScaleX(f14);
                view.setScaleY(f14);
                break;
            case 2: /* ordinal */
                view.setScaleX(f14);
                break;
            case 3: /* ordinal */
                view.setScaleX(f14);
                break;
            case 4: /* ordinal */
                view.setScaleX(f14);
                break;
            case 5: /* ordinal */
                view.setScaleX(f14);
                break;
            case 6: /* ordinal */
                view.setScaleX(f14);
                break;
            case 7: /* ordinal */
                view.setScaleX(f14);
                break;
            case 8: /* ordinal */
                view.setScaleY(f14);
                break;
            case 9: /* ordinal */
                view.setScaleY(f14);
                break;
            default:
        }
    }

    private void J2(View view) {
        view.setTranslationX((float)this.v.d);
        view.setTranslationY((float)this.v.e);
    }

    private void K2(View view, int i) {
        int i6 = g.a(this.s, this.u.c);
        float f7 = (float)(i * i6);
        f = f7 - (f7 - (float)(i - 1) * i6) * this.v.c();
        switch (CardStackLayoutManager.b.b[this.u.a.ordinal()]) {
            case 2: /* ordinal */
                view.setTranslationY(-f);
                break;
            case 3: /* ordinal */
                int i11 = -f;
                view.setTranslationY(i11);
                view.setTranslationX(i11);
                break;
            case 4: /* ordinal */
                i3 = -f;
                view.setTranslationY(-f);
                view.setTranslationX(f);
                break;
            case 5: /* ordinal */
                view.setTranslationY(f);
                break;
            case 6: /* ordinal */
                view.setTranslationY(f);
                view.setTranslationX(-f);
                break;
            case 7: /* ordinal */
                view.setTranslationY(f);
                view.setTranslationX(f);
                break;
            case 8: /* ordinal */
                view.setTranslationX(-f);
                break;
            case 9: /* ordinal */
                view.setTranslationX(f);
                break;
            default:
        }
    }

    static /* synthetic */ a i2(CardStackLayoutManager cardStackLayoutManager) {
        return cardStackLayoutManager.t;
    }

    static /* synthetic */ f j2(CardStackLayoutManager cardStackLayoutManager) {
        return cardStackLayoutManager.v;
    }

    private void p2(View view) {
        View viewById = view.findViewById(d.b);
        final float f = 0.0f;
        if (viewById != null) {
            viewById.setAlpha(0.0f);
        }
        View viewById2 = view.findViewById(d.c);
        if (viewById2 != null) {
            viewById2.setAlpha(0.0f);
        }
        View viewById3 = view.findViewById(d.d);
        if (viewById3 != null) {
            viewById3.setAlpha(0.0f);
        }
        final View viewById4 = view.findViewById(d.a);
        if (viewById4 != null) {
            viewById4.setAlpha(0.0f);
        }
    }

    private void q2(View view) {
        view.setRotation(0.0f);
    }

    private void r2(View view) {
        final float f = 1f;
        view.setScaleX(f);
        view.setScaleY(f);
    }

    private void s2(View view) {
        final float f = 0.0f;
        view.setTranslationX(f);
        view.setTranslationY(f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void A2(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("VisibleCount must be greater than 0.");
        } else {
            this.u.b = i;
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void G2(float f, float f2) {
        if (n2() < v0()) {
            View view = Z(n2());
            if (view != null) {
                float f5 = (float)t0() / 2f;
                f3 = (f2 - f5) - (float)view.getTop();
                this.v.h = -f3 / f5;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean H() {
        boolean z = false;
        if (this.u.j.canSwipe()) {
            int r0 = this.u.h ? 1 : 0;
        }
        return (this.u.h ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean I() {
        boolean z = false;
        if (this.u.j.canSwipe()) {
            int r0 = this.u.i ? 1 : 0;
        }
        return (this.u.i ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R1(int i, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        final int i16 = 0;
        if (this.v.f == v0()) {
            return i16;
        }
        int i3 = CardStackLayoutManager.b.a[this.v.a.ordinal()];
        int i2 = 1;
        if (CardStackLayoutManager.b.a != 1) {
            i2 = 2;
            if (CardStackLayoutManager.b.a != 2) {
                if (CardStackLayoutManager.b.a != 3 && CardStackLayoutManager.b.a != 4) {
                    i2 = 6;
                    if (CardStackLayoutManager.b.a == 6) {
                        if (this.u.j.canSwipeManually()) {
                            fVar4.d -= i;
                            E2(wVar);
                            return i;
                        }
                    }
                }
                fVar3.d -= i;
                E2(wVar);
                return i;
            }
            if (this.u.j.canSwipeManually()) {
                fVar6.d -= i;
                E2(wVar);
                return i;
            }
        } else {
            if (this.u.j.canSwipeManually()) {
                fVar7.d -= i;
                E2(wVar);
                return i;
            }
        }
        return i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void S1(int i) {
        if (this.u.j.canSwipeAutomatically()) {
            if (this.v.a(i, v0())) {
                this.v.f = i;
                O1();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int T1(int i, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        final int i16 = 0;
        if (this.v.f == v0()) {
            return i16;
        }
        int i3 = CardStackLayoutManager.b.a[this.v.a.ordinal()];
        int i2 = 1;
        if (this.v != 1) {
            i2 = 2;
            if (this.v != 2) {
                if (this.v != 3 && this.v != 4) {
                    i2 = 6;
                    if (this.v == 6) {
                        if (this.u.j.canSwipeManually()) {
                            fVar4.e -= i;
                            E2(wVar);
                            return i;
                        }
                    }
                }
                fVar3.e -= i;
                E2(wVar);
                return i;
            }
            if (this.u.j.canSwipeManually()) {
                fVar6.e -= i;
                E2(wVar);
                return i;
            }
        } else {
            if (this.u.j.canSwipeManually()) {
                fVar7.e -= i;
                E2(wVar);
                return i;
            }
        }
        return i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public RecyclerView.q a0() {
        final int i = -1;
        return new RecyclerView.q(i, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e2(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i) {
        if (this.u.j.canSwipeAutomatically()) {
            if (this.v.a(i, v0())) {
                C2(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public a k2() {
        return this.t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public c l2() {
        return this.u;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public f m2() {
        return this.v;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int n2() {
        return this.v.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View o2() {
        return Z(this.v.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void r1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        E2(wVar);
        if (b0Var.b() && this.o2() != null) {
            this.t.a(o2(), this.v.f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void t2(List<b> list) {
        this.u.g = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void u2(float f) {
        if (f < 0) {
            throw new IllegalArgumentException("ScaleInterval must be greater than or equal 0.0f.");
        } else {
            this.u.d = f;
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void v2(f fVar) {
        this.u.a = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void w2(g gVar) {
        this.u.k = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void x2(h hVar) {
        this.u.j = hVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void y1(int i) {
        if (i != 0) {
            int i2 = 1;
            if (i == 1) {
                if (this.u.j.canSwipeManually()) {
                    this.v.e(f.b.Dragging);
                }
            }
        } else {
            int i3 = -1;
            if (fVar.g == i3) {
                this.v.e(f.b.Idle);
                this.v.g = i3;
            } else {
                if (fVar.f == fVar.g) {
                    this.v.e(f.b.Idle);
                    this.v.g = i3;
                } else {
                    if (fVar.f < fVar.g) {
                        B2(fVar.g);
                    } else {
                        D2(fVar.g);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void y2(int i) {
        this.v.f = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void z2(float f) {
        if (f < 0) {
            throw new IllegalArgumentException("TranslationInterval must be greater than or equal 0.0f");
        } else {
            this.u.c = f;
            return;
        }
    }

    public CardStackLayoutManager(Context context, a aVar) {
        super();
        this.t = a.a;
        this.u = new c();
        this.v = new f();
        this.s = context;
        this.t = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public PointF d(int i) {
        return null;
    }
}
