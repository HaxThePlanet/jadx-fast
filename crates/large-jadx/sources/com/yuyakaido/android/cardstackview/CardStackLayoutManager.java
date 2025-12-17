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

/* loaded from: classes2.dex */
public class CardStackLayoutManager extends RecyclerView.p implements RecyclerView.a0.b {

    private final Context s;
    private com.yuyakaido.android.cardstackview.a t;
    private c u;
    private f v;

    class a implements Runnable {

        final com.yuyakaido.android.cardstackview.b a;
        final com.yuyakaido.android.cardstackview.CardStackLayoutManager b;
        a(com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager, com.yuyakaido.android.cardstackview.b b2) {
            this.b = cardStackLayoutManager;
            this.a = b2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object view;
            Object bVar;
            int i;
            CardStackLayoutManager.i2(this.b).c(this.a);
            if (this.b.o2() != null) {
                CardStackLayoutManager.i2(this.b).a(this.b.o2(), fVar.f);
            }
        }
    }

    static class b {

        static final int[] a;
        static final int[] b;
        static final int[] c;
        static {
            int[] iArr = new int[values.length];
            CardStackLayoutManager.b.c = iArr;
            int i2 = 1;
            iArr[b.Left.ordinal()] = i2;
            int i = 2;
            CardStackLayoutManager.b.c[b.Right.ordinal()] = i;
            int i3 = 3;
            CardStackLayoutManager.b.c[b.Top.ordinal()] = i3;
            int i4 = 4;
            CardStackLayoutManager.b.c[b.Bottom.ordinal()] = i4;
            int[] iArr11 = new int[values2.length];
            CardStackLayoutManager.b.b = iArr11;
            iArr11[f.None.ordinal()] = i2;
            CardStackLayoutManager.b.b[f.Top.ordinal()] = i;
            CardStackLayoutManager.b.b[f.TopAndLeft.ordinal()] = i3;
            CardStackLayoutManager.b.b[f.TopAndRight.ordinal()] = i4;
            int i5 = 5;
            CardStackLayoutManager.b.b[f.Bottom.ordinal()] = i5;
            int i6 = 6;
            CardStackLayoutManager.b.b[f.BottomAndLeft.ordinal()] = i6;
            int i7 = 7;
            CardStackLayoutManager.b.b[f.BottomAndRight.ordinal()] = i7;
            CardStackLayoutManager.b.b[f.Left.ordinal()] = 8;
            CardStackLayoutManager.b.b[f.Right.ordinal()] = 9;
            int[] iArr20 = new int[values3.length];
            CardStackLayoutManager.b.a = iArr20;
            iArr20[f.b.Idle.ordinal()] = i2;
            CardStackLayoutManager.b.a[f.b.Dragging.ordinal()] = i;
            CardStackLayoutManager.b.a[f.b.RewindAnimating.ordinal()] = i3;
            CardStackLayoutManager.b.a[f.b.AutomaticSwipeAnimating.ordinal()] = i4;
            CardStackLayoutManager.b.a[f.b.AutomaticSwipeAnimated.ordinal()] = i5;
            CardStackLayoutManager.b.a[f.b.ManualSwipeAnimating.ordinal()] = i6;
            CardStackLayoutManager.b.a[f.b.ManualSwipeAnimated.ordinal()] = i7;
        }
    }
    public CardStackLayoutManager(Context context) {
        super(context, a.a);
    }

    public CardStackLayoutManager(Context context, com.yuyakaido.android.cardstackview.a a2) {
        super();
        this.t = a.a;
        c cVar = new c();
        this.u = cVar;
        f fVar = new f();
        this.v = fVar;
        this.s = context;
        this.t = a2;
    }

    private void B2(int i) {
        f fVar = this.v;
        fVar.h = 0;
        fVar.g = i;
        d obj3 = new d(d.b.AutomaticSwipe, this);
        obj3.setTargetPosition(fVar2.f);
        f2(obj3);
    }

    private void C2(int i) {
        if (fVar.f < i) {
            B2(i);
        } else {
            D2(i);
        }
    }

    private void D2(int i) {
        Object view;
        View view2;
        int i2;
        if (o2() != null) {
            this.t.e(o2(), fVar3.f);
        }
        f fVar = this.v;
        fVar.h = 0;
        fVar.g = i;
        fVar.f = obj4--;
        d obj4 = new d(d.b.AutomaticRewind, this);
        obj4.setTargetPosition(fVar2.f);
        f2(obj4);
    }

    private void E2(RecyclerView.w recyclerView$w) {
        boolean z;
        int i;
        int i4;
        Handler handler;
        int i5;
        com.yuyakaido.android.cardstackview.CardStackLayoutManager.a aVar;
        int i7;
        int i3;
        int i8;
        int i6;
        int i2;
        int i9;
        int i11;
        int i10;
        int i12;
        View view;
        boolean obj14;
        fVar.b = H0();
        fVar2.c = t0();
        i4 = 0;
        H1(o2(), w);
        f fVar7 = this.v;
        fVar7.e(fVar7.a.toAnimatedStatus());
        f fVar8 = this.v;
        i16++;
        fVar8.f = i5;
        fVar8.d = i4;
        fVar8.e = i4;
        if (this.v.d() && i5 == fVar8.g) {
            H1(o2(), w);
            fVar7 = this.v;
            fVar7.e(fVar7.a.toAnimatedStatus());
            fVar8 = this.v;
            i16++;
            fVar8.f = i5;
            fVar8.d = i4;
            fVar8.e = i4;
            if (i5 == fVar8.g) {
                fVar8.g = -1;
            }
            handler = new Handler();
            aVar = new CardStackLayoutManager.a(this, this.v.b());
            handler.post(aVar);
        }
        T(w);
        i12 = i3;
        while (i12 < i21 += i22) {
            if (i12 < v0()) {
            }
            view = w.o(i12);
            B(view, i4);
            U0(view, i4, i4);
            this.T0(view, v(), u(), i17 -= i19, i20 - i6);
            s2(view);
            r2(view);
            q2(view);
            p2(view);
            i3 = fVar11.f;
            if (i12 == i3) {
            } else {
            }
            i3 = i12 - i3;
            K2(view, i3);
            I2(view, i3);
            q2(view);
            p2(view);
            i12++;
            J2(view);
            r2(view);
            H2(view);
            F2(view);
        }
        if (obj14.a.isDragging()) {
            this.t.d(this.v.b(), this.v.c());
        }
    }

    private void F2(View view) {
        int viewById;
        viewById = view.findViewById(d.b);
        int i2 = 0;
        if (viewById != null) {
            viewById.setAlpha(i2);
        }
        View viewById2 = view.findViewById(d.c);
        if (viewById2 != null) {
            viewById2.setAlpha(i2);
        }
        View viewById3 = view.findViewById(d.d);
        if (viewById3 != null) {
            viewById3.setAlpha(i2);
        }
        final View obj7 = view.findViewById(d.a);
        if (obj7 != null) {
            obj7.setAlpha(i2);
        }
        float interpolation = cVar.m.getInterpolation(this.v.c());
        int i3 = CardStackLayoutManager.b.c[this.v.b().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                    } else {
                        if (obj7 != null) {
                            obj7.setAlpha(interpolation);
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
        view.setRotation(i3 *= f4);
    }

    private void I2(View view, int i2) {
        float f3 = cVar.d;
        int i6 = 1065353216;
        int obj6 = i6 - obj6;
        obj6 += i9;
        switch (i4) {
            case 1:
                view.setScaleX(obj6);
                view.setScaleY(obj6);
                break;
            case 2:
                view.setScaleX(obj6);
                break;
            case 3:
                view.setScaleX(obj6);
                break;
            case 4:
                view.setScaleX(obj6);
                break;
            case 5:
                view.setScaleX(obj6);
                break;
            case 6:
                view.setScaleX(obj6);
                break;
            case 7:
                view.setScaleX(obj6);
                break;
            case 8:
                view.setScaleY(obj6);
                break;
            case 9:
                view.setScaleY(obj6);
                break;
            default:
        }
    }

    private void J2(View view) {
        view.setTranslationX((float)i);
        view.setTranslationY((float)i2);
    }

    private void K2(View view, int i2) {
        int i;
        int obj5;
        int i8 = g.a(this.s, cVar2.c);
        obj5 = (float)obj5;
        obj5 -= i7;
        switch (i) {
            case 2:
                view.setTranslationY(-obj5);
                break;
            case 3:
                obj5 = -obj5;
                view.setTranslationY(obj5);
                view.setTranslationX(obj5);
                break;
            case 4:
                view.setTranslationY(-obj5);
                view.setTranslationX(obj5);
                break;
            case 5:
                view.setTranslationY(obj5);
                break;
            case 6:
                view.setTranslationY(obj5);
                view.setTranslationX(-obj5);
                break;
            case 7:
                view.setTranslationY(obj5);
                view.setTranslationX(obj5);
                break;
            case 8:
                view.setTranslationX(-obj5);
                break;
            case 9:
                view.setTranslationX(obj5);
                break;
            default:
        }
    }

    static com.yuyakaido.android.cardstackview.a i2(com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager) {
        return cardStackLayoutManager.t;
    }

    static f j2(com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager) {
        return cardStackLayoutManager.v;
    }

    private void p2(View view) {
        View viewById = view.findViewById(d.b);
        final int i5 = 0;
        if (viewById != null) {
            viewById.setAlpha(i5);
        }
        View viewById2 = view.findViewById(d.c);
        if (viewById2 != null) {
            viewById2.setAlpha(i5);
        }
        View viewById3 = view.findViewById(d.d);
        if (viewById3 != null) {
            viewById3.setAlpha(i5);
        }
        final View obj3 = view.findViewById(d.a);
        if (obj3 != null) {
            obj3.setAlpha(i5);
        }
    }

    private void q2(View view) {
        view.setRotation(0);
    }

    private void r2(View view) {
        final int i = 1065353216;
        view.setScaleX(i);
        view.setScaleY(i);
    }

    private void s2(View view) {
        final int i = 0;
        view.setTranslationX(i);
        view.setTranslationY(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void A2(int i) {
        if (i < 1) {
        } else {
            cVar.b = i;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("VisibleCount must be greater than 0.");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void G2(float f, float f2) {
        int i;
        f fVar;
        int obj3;
        int obj4;
        obj3 = Z(n2());
        if (n2() < v0() && obj3 != null) {
            obj3 = Z(n2());
            if (obj3 != null) {
                f3 /= i3;
                fVar.h = obj3 /= i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean H() {
        boolean swipe;
        int i;
        if (cVar.j.canSwipe() && cVar2.h) {
            i = cVar2.h ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean I() {
        boolean swipe;
        int i;
        if (cVar.j.canSwipe() && cVar2.i) {
            i = cVar2.i ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R1(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03) {
        int i2;
        int obj5;
        final int i15 = 0;
        if (obj5.f == v0()) {
            return i15;
        }
        obj5 = CardStackLayoutManager.b.a[fVar.a.ordinal()];
        if (obj5 != 1) {
            if (obj5 != 2 && obj5 != 3) {
                if (obj5 != 3) {
                    if (obj5 != 4) {
                        if (obj5 != 6) {
                        } else {
                            if (obj5.j.canSwipeManually()) {
                                obj5 = this.v;
                                obj5.d = i7 -= i;
                                E2(w2);
                                return i;
                            }
                        }
                    } else {
                        if (obj5.j.canSwipeAutomatically()) {
                            obj5 = this.v;
                            obj5.d = i9 -= i;
                            E2(w2);
                            return i;
                        }
                    }
                }
                obj5 = this.v;
                obj5.d = i5 -= i;
                E2(w2);
                return i;
            }
            if (obj5.j.canSwipeManually()) {
                obj5 = this.v;
                obj5.d = i11 -= i;
                E2(w2);
                return i;
            }
        } else {
            if (obj5.j.canSwipeManually()) {
                obj5 = this.v;
                obj5.d = i13 -= i;
                E2(w2);
                return i;
            }
        }
        return i15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void S1(int i) {
        boolean swipeAutomatically;
        int i2;
        if (cVar.j.canSwipeAutomatically() && this.v.a(i, v0())) {
            if (this.v.a(i, v0())) {
                swipeAutomatically.f = i;
                O1();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int T1(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03) {
        int i2;
        int obj5;
        final int i15 = 0;
        if (obj5.f == v0()) {
            return i15;
        }
        obj5 = CardStackLayoutManager.b.a[fVar.a.ordinal()];
        if (obj5 != 1) {
            if (obj5 != 2 && obj5 != 3) {
                if (obj5 != 3) {
                    if (obj5 != 4) {
                        if (obj5 != 6) {
                        } else {
                            if (obj5.j.canSwipeManually()) {
                                obj5 = this.v;
                                obj5.e = i7 -= i;
                                E2(w2);
                                return i;
                            }
                        }
                    } else {
                        if (obj5.j.canSwipeAutomatically()) {
                            obj5 = this.v;
                            obj5.e = i9 -= i;
                            E2(w2);
                            return i;
                        }
                    }
                }
                obj5 = this.v;
                obj5.e = i5 -= i;
                E2(w2);
                return i;
            }
            if (obj5.j.canSwipeManually()) {
                obj5 = this.v;
                obj5.e = i11 -= i;
                E2(w2);
                return i;
            }
        } else {
            if (obj5.j.canSwipeManually()) {
                obj5 = this.v;
                obj5.e = i13 -= i;
                E2(w2);
                return i;
            }
        }
        return i15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public RecyclerView.q a0() {
        final int i = -1;
        RecyclerView.q qVar = new RecyclerView.q(i, i);
        return qVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public PointF d(int i) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e2(RecyclerView recyclerView, RecyclerView.b0 recyclerView$b02, int i3) {
        boolean obj1;
        int obj2;
        if (obj1.j.canSwipeAutomatically() && this.v.a(i3, v0())) {
            if (this.v.a(i3, v0())) {
                C2(i3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public com.yuyakaido.android.cardstackview.a k2() {
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
        return fVar.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View o2() {
        return Z(fVar.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void r1(RecyclerView.w recyclerView$w, RecyclerView.b0 recyclerView$b02) {
        int i;
        boolean obj2;
        View obj3;
        E2(w);
        if (b02.b() && o2() != null) {
            if (o2() != null) {
                this.t.a(o2(), fVar.f);
            }
        }
    }

    public void t2(List<com.yuyakaido.android.cardstackview.b> list) {
        cVar.g = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void u2(float f) {
        if (Float.compare(f, i) < 0) {
        } else {
            cVar.d = f;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("ScaleInterval must be greater than or equal 0.0f.");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void v2(com.yuyakaido.android.cardstackview.f f) {
        cVar.a = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void w2(com.yuyakaido.android.cardstackview.g g) {
        cVar.k = g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void x2(com.yuyakaido.android.cardstackview.h h) {
        cVar.j = h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void y1(int i) {
        int dragging;
        int i2;
        int i3;
        f obj4;
        if (i != 0) {
            if (i != 1) {
            } else {
                if (obj4.j.canSwipeManually()) {
                    this.v.e(f.b.Dragging);
                }
            }
        } else {
            obj4 = this.v;
            dragging = obj4.g;
            i2 = -1;
            if (dragging == i2) {
                obj4.e(f.b.Idle);
                obj4.g = i2;
            } else {
                i3 = obj4.f;
                if (i3 == dragging) {
                    obj4.e(f.b.Idle);
                    obj4.g = i2;
                } else {
                    if (i3 < dragging) {
                        B2(dragging);
                    } else {
                        D2(dragging);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void y2(int i) {
        fVar.f = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void z2(float f) {
        if (Float.compare(f, i) < 0) {
        } else {
            cVar.c = f;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("TranslationInterval must be greater than or equal 0.0f");
        throw obj2;
    }
}
