package d.u;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import d.h.l.u;
import java.util.Map;

/* loaded from: classes.dex */
public class n extends d.u.m0 {

    private static final TimeInterpolator e0;
    private static final TimeInterpolator f0;
    private static final d.u.n.g g0;
    private static final d.u.n.g h0;
    private static final d.u.n.g i0;
    private static final d.u.n.g j0;
    private static final d.u.n.g k0;
    private static final d.u.n.g l0;
    private d.u.n.g d0;

    private interface g {
        public abstract float a(ViewGroup viewGroup, View view2);

        public abstract float b(ViewGroup viewGroup, View view2);
    }

    private static abstract class h implements d.u.n.g {
        h(d.u.n.a n$a) {
            super();
        }

        @Override // d.u.n$g
        public float a(ViewGroup viewGroup, View view2) {
            return view2.getTranslationY();
        }
    }

    private static abstract class i implements d.u.n.g {
        i(d.u.n.a n$a) {
            super();
        }

        @Override // d.u.n$g
        public float b(ViewGroup viewGroup, View view2) {
            return view2.getTranslationX();
        }
    }

    static class a extends d.u.n.h {
        a() {
            super(0);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view2) {
            return obj2 -= obj1;
        }
    }

    static class b extends d.u.n.h {
        b() {
            super(0);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view2) {
            int i;
            float obj3;
            int obj4;
            if (u.B(viewGroup) == 1) {
            } else {
                i = 0;
            }
            if (i != 0) {
                obj4 += obj3;
            } else {
                obj4 -= obj3;
            }
            return obj4;
        }
    }

    static class c extends d.u.n.i {
        c() {
            super(0);
        }

        @Override // d.u.n$i
        public float a(ViewGroup viewGroup, View view2) {
            return obj2 -= obj1;
        }
    }

    static class d extends d.u.n.h {
        d() {
            super(0);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view2) {
            return obj2 += obj1;
        }
    }

    static class e extends d.u.n.h {
        e() {
            super(0);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view2) {
            int i;
            float obj3;
            int obj4;
            if (u.B(viewGroup) == 1) {
            } else {
                i = 0;
            }
            if (i != 0) {
                obj4 -= obj3;
            } else {
                obj4 += obj3;
            }
            return obj4;
        }
    }

    static class f extends d.u.n.i {
        f() {
            super(0);
        }

        @Override // d.u.n$i
        public float a(ViewGroup viewGroup, View view2) {
            return obj2 += obj1;
        }
    }
    static {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        n.e0 = decelerateInterpolator;
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        n.f0 = accelerateInterpolator;
        n.a aVar = new n.a();
        n.g0 = aVar;
        n.b bVar = new n.b();
        n.h0 = bVar;
        n.c cVar = new n.c();
        n.i0 = cVar;
        n.d dVar = new n.d();
        n.j0 = dVar;
        n.e eVar = new n.e();
        n.k0 = eVar;
        n.f fVar = new n.f();
        n.l0 = fVar;
    }

    public n(int i) {
        super();
        this.d0 = n.l0;
        q0(i);
    }

    private void h0(d.u.u u) {
        int[] iArr = new int[2];
        u.b.getLocationOnScreen(iArr);
        u.a.put("android:slide:screenPosition", iArr);
    }

    @Override // d.u.m0
    public void f(d.u.u u) {
        super.f(u);
        h0(u);
    }

    @Override // d.u.m0
    public void j(d.u.u u) {
        super.j(u);
        h0(u);
    }

    @Override // d.u.m0
    public Animator k0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4) {
        if (u4 == null) {
            return null;
        }
        Object obj13 = u4.a.get("android:slide:screenPosition");
        return w.a(view2, u4, (int[])obj13[0], obj13[1], this.d0.b(viewGroup, view2), this.d0.a(viewGroup, view2), view2.getTranslationX(), view2.getTranslationY(), n.e0, this);
    }

    @Override // d.u.m0
    public Animator n0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4) {
        if (u3 == null) {
            return null;
        }
        Object obj14 = u3.a.get("android:slide:screenPosition");
        return w.a(view2, u3, (int[])obj14[0], obj14[1], view2.getTranslationX(), view2.getTranslationY(), this.d0.b(viewGroup, view2), this.d0.a(viewGroup, view2), n.f0, this);
    }

    @Override // d.u.m0
    public void q0(int i) {
        d.u.n.g gVar;
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i != 8388613) {
                            } else {
                                this.d0 = n.k0;
                            }
                            IllegalArgumentException obj2 = new IllegalArgumentException("Invalid slide direction");
                            throw obj2;
                        }
                        this.d0 = n.h0;
                    } else {
                        this.d0 = n.l0;
                    }
                } else {
                    this.d0 = n.i0;
                }
            } else {
                this.d0 = n.j0;
            }
        } else {
            this.d0 = n.g0;
        }
        m mVar = new m();
        mVar.j(i);
        c0(mVar);
    }
}
