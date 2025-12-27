package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class m0 extends o {

    private static final String[] c0;
    private int b0 = 3;

    private static class c {

        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;
        c() {
            super();
        }
    }

    private static class b extends AnimatorListenerAdapter implements o.f, a.a {

        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;
        b(View view, int i, boolean z) {
            super();
            this.a = view;
            this.b = i;
            this.c = (ViewGroup)view.getParent();
            this.d = z;
            b(true);
        }

        private void a() {
            if (!this.f) {
                f0.h(this.a, this.b);
                if (this.c != null) {
                    this.c.invalidate();
                }
            }
            b(false);
        }

        private void b(boolean z) {
            if (this.d && this.e != z && this.c != null) {
                this.e = z;
                a0.c(this.c, z);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                f0.h(this.a, this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                int i = 0;
                f0.h(this.a, i);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionEnd(o oVar) {
            a();
            oVar.S(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionPause(o oVar) {
            b(false);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionResume(o oVar) {
            b(true);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionCancel(o oVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionStart(o oVar) {
        }
    }

    class a extends p {

        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;
        final /* synthetic */ m0 d;
        a(ViewGroup viewGroup, View view, View view2) {
            this.d = m0Var;
            this.a = viewGroup;
            this.b = view;
            this.c = view2;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            this.c.setTag(j.b, null);
            a0.a(this.a).d(this.b);
            oVar.S(this);
        }

        @Override // d.u.p
        public void onTransitionPause(o oVar) {
            a0.a(this.a).d(this.b);
        }

        @Override // d.u.p
        public void onTransitionResume(o oVar) {
            if (this.b.getParent() == null) {
                a0.a(this.a).c(this.b);
            } else {
                this.d.cancel();
            }
        }
    }
    static {
        m0.c0 = new String[] { "android:visibility:visibility", "android:visibility:parent" };
    }

    public m0() {
        super();
    }

    private void h0(u uVar) {
        uVar.a.put("android:visibility:visibility", Integer.valueOf(uVar.b.getVisibility()));
        uVar.a.put("android:visibility:parent", uVar.b.getParent());
        int[] iArr = new int[2];
        uVar.b.getLocationOnScreen(iArr);
        uVar.a.put("android:visibility:screenLocation", iArr);
    }

    private m0.c i0(u uVar, u uVar2) {
        Map map = null;
        int i = -1;
        boolean key;
        int i2;
        final d.u.m0.c cVar = new m0.c();
        final boolean z = false;
        cVar.a = z;
        cVar.b = z;
        String str = "android:visibility:parent";
        ViewGroup viewGroup = null;
        i = -1;
        final String str2 = "android:visibility:visibility";
        if (uVar != null) {
            if (uVar.a.containsKey(str2)) {
                cVar.c = (Integer)uVar.a.get(str2).intValue();
                cVar.e = (ViewGroup)uVar.a.get(str);
            } else {
                cVar.c = i;
                cVar.e = viewGroup;
            }
        }
        if (uVar2 != null) {
            if (uVar2.a.containsKey(str2)) {
                cVar.d = (Integer)uVar2.a.get(str2).intValue();
                cVar.f = (ViewGroup)uVar2.a.get(str);
            } else {
                cVar.d = i;
                cVar.f = viewGroup;
            }
        }
        boolean z2 = true;
        if (uVar == null || uVar2 == null) {
            if (cVar.d != null || cVar.d != 0) {
                if (uVar2 == null && cVar.c == 0) {
                    cVar.b = z;
                    cVar.a = z2;
                }
            } else {
                cVar.b = z2;
                cVar.a = z2;
            }
        } else {
            if (cVar.c == cVar.d && cVar.e == cVar.f) {
                return cVar;
            }
            if (cVar.c != cVar.d) {
                if (cVar.c == 0) {
                    cVar.b = z;
                    cVar.a = z2;
                } else {
                    if (cVar.d == 0) {
                        cVar.b = z2;
                        cVar.a = z2;
                    }
                }
            } else {
                if (cVar.f == null) {
                    cVar.b = z;
                    cVar.a = z2;
                } else {
                    if (cVar.e == null) {
                        cVar.b = z2;
                        cVar.a = z2;
                    }
                }
            }
        }
        return cVar;
    }

    @Override // d.u.o
    public String[] G() {
        return m0.c0;
    }

    @Override // d.u.o
    public boolean I(u uVar, u uVar2) {
        boolean z = false;
        d.u.m0.c cVar;
        z = false;
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.a.containsKey(str) != uVar.a.containsKey(str)) {
            return false;
        }
        cVar = i0(uVar, uVar2);
        if (cVar.a && cVar.c != 0 && cVar.d == 0) {
            int i = 1;
        }
        return z;
    }

    @Override // d.u.o
    public void f(u uVar) {
        h0(uVar);
    }

    @Override // d.u.o
    public void j(u uVar) {
        h0(uVar);
    }

    @Override // d.u.o
    public Animator m0(ViewGroup viewGroup, u uVar, int i, u uVar2, int i2) {
        i2 = 1;
        i = this.b0 & i2;
        final int i4 = 0;
        return null;
    }

    @Override // d.u.o
    public Animator n(ViewGroup viewGroup, u uVar, u uVar2) {
        d.u.m0.c cVar = i0(uVar, uVar2);
        if (cVar.a && cVar.e == null && cVar.f != null && cVar.b) {
            return this.m0(viewGroup, uVar, cVar.c, uVar2, cVar.d);
        }
        return null;
    }

    @Override // d.u.o
    public Animator o0(ViewGroup viewGroup, u uVar, int i, u uVar2, int i2) {
        View view2;
        Object tag;
        View view;
        int i4;
        int i6;
        final Object viewGroup3 = this;
        viewGroup2 = viewGroup;
        uVar22 = uVar;
        uVar42 = uVar2;
        i52 = i2;
        int top = 2;
        i = 0;
        if ((viewGroup3.b0 & top) != top) {
            return null;
        }
        if (uVar22 == null) {
            return i;
        }
        View r8 = uVar42 != null ? uVar42.b : i;
        final int i16 = j.b;
        i4 = 0;
        final boolean z2 = true;
        if ((View)uVar22.b.getTag(j.b) != null) {
            i4 = z2;
        } else {
            if (!(i != 0 || i.getParent() == null)) {
                if (i != 0) {
                } else {
                    i4 = z2;
                }
            }
            if (i4 == 0 || uVar22.b.getParent() == null) {
            } else {
            }
        }
        if (view != null && i4 == 0) {
            Object value = uVar22.a.get("android:visibility:screenLocation");
            int[] iArr = new int[top];
            viewGroup2.getLocationOnScreen(iArr);
            i = (value[i4] - iArr[i4]) - view.getLeft();
            view.offsetLeftAndRight(i);
            view.offsetTopAndBottom((value[z2] - iArr[z2]) - view.getTop());
            a0.a(viewGroup).c(view);
            Animator animator2 = viewGroup3.n0(viewGroup2, view, uVar22, uVar42);
            if (i4 == 0 && animator2 == null) {
                a0.a(viewGroup).d(view);
            }
            return animator2;
        }
        if (view2 != null) {
            f0.h(view2, i4);
            Animator animator = viewGroup3.n0(viewGroup2, view2, uVar22, uVar42);
            if (animator != null) {
                d.u.m0.b bVar = new m0.b(view2, i52, z2);
                animator.addListener(bVar);
                a.a(animator, bVar);
                viewGroup3.a(bVar);
            } else {
                f0.h(view2, view2.getVisibility());
            }
            return animator;
        }
        return i;
    }

    @Override // d.u.o
    public void p0(int i) {
        if (i & (-4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        } else {
            this.b0 = i;
            return;
        }
    }

    @Override // d.u.o
    public abstract Animator k0(ViewGroup viewGroup, View view, u uVar, u uVar2);

    @Override // d.u.o
    public abstract Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2);
}
