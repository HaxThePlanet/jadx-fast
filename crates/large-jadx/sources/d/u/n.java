package d.u;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;
import java.util.Map;

/* compiled from: Slide.java */
/* loaded from: classes.dex */
public class n extends m0 {

    private static final TimeInterpolator e0 = new DecelerateInterpolator();
    private static final TimeInterpolator f0 = new AccelerateInterpolator();
    private static final n.g g0 = new n$a();
    private static final n.g h0 = new n$b();
    private static final n.g i0 = new n$c();
    private static final n.g j0 = new n$d();
    private static final n.g k0 = new n$e();
    private static final n.g l0 = new n$f();
    private n.g d0;

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements n.g {
        private h() {
            super();
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ h(n.a aVar) {
            this();
        }
    }

    private static abstract class i implements n.g {
        private i() {
            super();
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ i(n.a aVar) {
            this();
        }
    }

    static class a extends n.h {
        a() {
            super(null);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - (float)viewGroup.getWidth();
        }
    }

    static class b extends n.h {
        b() {
            super(null);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view) {
            int i = 1;
            float f2;
            i = 1;
            if (u.B(viewGroup) != 1) {
                i = 0;
            }
            if (i != 0) {
                f = (float)viewGroup.getWidth();
                f2 = view.getTranslationX() + f;
            } else {
                f = (float)viewGroup.getWidth();
                f2 = view.getTranslationX() - f;
            }
            return f2;
        }
    }

    static class c extends n.i {
        c() {
            super(null);
        }

        @Override // d.u.n$i
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - (float)viewGroup.getHeight();
        }
    }

    static class d extends n.h {
        d() {
            super(null);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + (float)viewGroup.getWidth();
        }
    }

    static class e extends n.h {
        e() {
            super(null);
        }

        @Override // d.u.n$h
        public float b(ViewGroup viewGroup, View view) {
            int i = 1;
            float f2;
            i = 1;
            if (u.B(viewGroup) != 1) {
                i = 0;
            }
            if (i != 0) {
                f = (float)viewGroup.getWidth();
                f2 = view.getTranslationX() - f;
            } else {
                f = (float)viewGroup.getWidth();
                f2 = view.getTranslationX() + f;
            }
            return f2;
        }
    }

    static class f extends n.i {
        f() {
            super(null);
        }

        @Override // d.u.n$i
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + (float)viewGroup.getHeight();
        }
    }

    public n(int i) {
        super();
        this.d0 = n.l0;
        q0(i);
    }

    private void h0(u uVar) {
        int[] iArr = new int[2];
        uVar.b.getLocationOnScreen(iArr);
        uVar.a.put("android:slide:screenPosition", iArr);
    }

    @Override // d.u.m0
    public void f(u uVar) {
        super.f(uVar);
        h0(uVar);
    }

    @Override // d.u.m0
    public void j(u uVar) {
        super.j(uVar);
        h0(uVar);
    }

    @Override // d.u.m0
    public Animator k0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar2 == null) {
            return null;
        }
        Object value = uVar2.a.get("android:slide:screenPosition");
        return w.a(view, uVar2, value[0], value[1], this.d0.b(viewGroup, view), this.d0.a(viewGroup, view), view.getTranslationX(), view.getTranslationY(), n.e0, this);
    }

    @Override // d.u.m0
    public Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar == null) {
            return null;
        }
        Object value = uVar.a.get("android:slide:screenPosition");
        return w.a(view, uVar, value[0], value[1], view.getTranslationX(), view.getTranslationY(), this.d0.b(viewGroup, view), this.d0.a(viewGroup, view), n.f0, this);
    }

    @Override // d.u.m0
    public void q0(int i) {
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i != 8388611) {
                            if (i != 8388613) {
                                throw new IllegalArgumentException("Invalid slide direction");
                            } else {
                                this.d0 = n.k0;
                            }
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
        d.u.m mVar = new m();
        mVar.j(i);
        c0(mVar);
    }
}
