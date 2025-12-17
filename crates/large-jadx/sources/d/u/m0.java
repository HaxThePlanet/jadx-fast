package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class m0 extends d.u.o {

    private static final String[] c0;
    private int b0 = 3;

    private static class c {

        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;
    }

    private static class b extends AnimatorListenerAdapter implements d.u.o.f, d.u.a.a {

        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;
        b(View view, int i2, boolean z3) {
            super();
            final int i = 0;
            this.a = view;
            this.b = i2;
            this.c = (ViewGroup)view.getParent();
            this.d = z3;
            b(true);
        }

        private void a() {
            boolean z;
            int i;
            f0.h(this.a, this.b);
            z = this.c;
            if (!this.f && z != null) {
                f0.h(this.a, this.b);
                z = this.c;
                if (z != null) {
                    z.invalidate();
                }
            }
            b(false);
        }

        private void b(boolean z) {
            boolean z2;
            z2 = this.c;
            if (this.d && this.e != z && z2 != null) {
                if (this.e != z) {
                    z2 = this.c;
                    if (z2 != null) {
                        this.e = z;
                        a0.c(z2, z);
                    }
                }
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
            int i;
            boolean obj2;
            if (!this.f) {
                f0.h(this.a, this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationResume(Animator animator) {
            int i;
            boolean obj2;
            if (!this.f) {
                f0.h(this.a, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionCancel(d.u.o o) {
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionEnd(d.u.o o) {
            a();
            o.S(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionPause(d.u.o o) {
            b(false);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionResume(d.u.o o) {
            b(true);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onTransitionStart(d.u.o o) {
        }
    }

    class a extends d.u.p {

        final ViewGroup a;
        final View b;
        final View c;
        final d.u.m0 d;
        a(d.u.m0 m0, ViewGroup viewGroup2, View view3, View view4) {
            this.d = m0;
            this.a = viewGroup2;
            this.b = view3;
            this.c = view4;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            this.c.setTag(j.b, 0);
            a0.a(this.a).d(this.b);
            o.S(this);
        }

        @Override // d.u.p
        public void onTransitionPause(d.u.o o) {
            a0.a(this.a).d(this.b);
        }

        @Override // d.u.p
        public void onTransitionResume(d.u.o o) {
            View view;
            Object obj2;
            if (this.b.getParent() == null) {
                a0.a(this.a).c(this.b);
            } else {
                this.d.cancel();
            }
        }
    }
    static {
        m0.c0 = /* result */;
    }

    public m0() {
        super();
        final int i = 3;
    }

    private void h0(d.u.u u) {
        u.a.put("android:visibility:visibility", Integer.valueOf(u.b.getVisibility()));
        u.a.put("android:visibility:parent", u.b.getParent());
        int[] iArr = new int[2];
        u.b.getLocationOnScreen(iArr);
        u.a.put("android:visibility:screenLocation", iArr);
    }

    private d.u.m0.c i0(d.u.u u, d.u.u u2) {
        Object str;
        Map i2;
        int i;
        boolean key;
        Object obj8;
        Object obj9;
        m0.c cVar = new m0.c();
        final int i3 = 0;
        cVar.a = i3;
        cVar.b = i3;
        str = "android:visibility:parent";
        i2 = 0;
        i = -1;
        final String str2 = "android:visibility:visibility";
        if (u != null && u.a.containsKey(str2)) {
            if (u.a.containsKey(str2)) {
                cVar.c = (Integer)u.a.get(str2).intValue();
                cVar.e = (ViewGroup)u.a.get(str);
            } else {
                cVar.c = i;
                cVar.e = i2;
            }
        } else {
        }
        if (u2 != null && u2.a.containsKey(str2)) {
            if (u2.a.containsKey(str2)) {
                cVar.d = (Integer)u2.a.get(str2).intValue();
                cVar.f = (ViewGroup)u2.a.get(str);
            } else {
                cVar.d = i;
                cVar.f = i2;
            }
        } else {
        }
        int i4 = 1;
        if (u != null && u2 != null) {
            if (u2 != null) {
                obj8 = cVar.c;
                obj9 = cVar.d;
                if (obj8 == obj9 && cVar.e == cVar.f) {
                    if (cVar.e == cVar.f) {
                        return cVar;
                    }
                }
                if (obj8 != obj9) {
                    if (obj8 == null) {
                        cVar.b = i3;
                        cVar.a = i4;
                    } else {
                        if (obj9 == null) {
                            cVar.b = i4;
                            cVar.a = i4;
                        }
                    }
                } else {
                    if (cVar.f == null) {
                        cVar.b = i3;
                        cVar.a = i4;
                    } else {
                        if (cVar.e == null) {
                            cVar.b = i4;
                            cVar.a = i4;
                        }
                    }
                }
            } else {
                if (u == null && cVar.d == 0) {
                    if (cVar.d == 0) {
                        cVar.b = i4;
                        cVar.a = i4;
                    } else {
                        if (u2 == null && cVar.c == 0) {
                            if (cVar.c == 0) {
                                cVar.b = i3;
                                cVar.a = i4;
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return cVar;
    }

    @Override // d.u.o
    public String[] G() {
        return m0.c0;
    }

    @Override // d.u.o
    public boolean I(d.u.u u, d.u.u u2) {
        int i;
        boolean key;
        boolean key2;
        Map map;
        d.u.m0.c obj5;
        boolean obj6;
        i = 0;
        if (u == null && u2 == null) {
            if (u2 == null) {
                return i;
            }
        }
        String str = "android:visibility:visibility";
        if (u != null && u2 != null && u2.a.containsKey(str) != u.a.containsKey(str)) {
            if (u2 != null) {
                str = "android:visibility:visibility";
                if (u2.a.containsKey(str) != u.a.containsKey(str)) {
                    return i;
                }
            }
        }
        obj5 = i0(u, u2);
        if (obj5.a) {
            if (obj5.c != 0) {
                if (obj5.d == 0) {
                    i = 1;
                }
            } else {
            }
        }
        return i;
    }

    @Override // d.u.o
    public void f(d.u.u u) {
        h0(u);
    }

    @Override // d.u.o
    public void j(d.u.u u) {
        h0(u);
    }

    @Override // d.u.o
    public abstract Animator k0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4);

    @Override // d.u.o
    public Animator m0(ViewGroup viewGroup, d.u.u u2, int i3, d.u.u u4, int i5) {
        d.u.u uVar;
        int obj5;
        int obj7;
        obj7 = 1;
        final int i = 0;
        if (obj5 &= obj7 == obj7) {
            if (u4 == null) {
            } else {
                obj5 = u4.b.getParent();
                obj7 = 0;
                if (u2 == null && obj5.a) {
                    obj5 = u4.b.getParent();
                    obj7 = 0;
                    if (obj5.a) {
                        return i;
                    }
                }
            }
            return k0(viewGroup, u4.b, u2, u4);
        }
        return i;
    }

    @Override // d.u.o
    public Animator n(ViewGroup viewGroup, d.u.u u2, d.u.u u3) {
        ViewGroup z;
        d.u.m0.c cVar = i0(u2, u3);
        if (cVar.a) {
            if (cVar.e == null) {
                if (cVar.f != null && cVar.b) {
                    if (cVar.b) {
                        return this.m0(viewGroup, u2, cVar.c, u3, cVar.d);
                    }
                }
            } else {
            }
            return this.o0(viewGroup, u2, cVar.c, u3, cVar.d);
        }
        return null;
    }

    @Override // d.u.o
    public abstract Animator n0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4);

    @Override // d.u.o
    public Animator o0(ViewGroup viewGroup, d.u.u u2, int i3, d.u.u u4, int i5) {
        Object view;
        Object bVar;
        Object aVar;
        int i6;
        int top;
        int i;
        int i2;
        int left;
        int parent;
        int i9;
        int viewById;
        int i8;
        int i7;
        d.u.u uVar;
        int i4;
        final Object obj = this;
        view = viewGroup;
        bVar = u2;
        aVar = u4;
        i6 = i5;
        top = 2;
        i = 0;
        if (i13 &= top != top) {
            return i;
        }
        if (bVar == null) {
            return i;
        }
        View view2 = bVar.b;
        i2 = aVar != null ? aVar.b : i;
        final int i19 = j.b;
        final int i20 = 0;
        final int i21 = 1;
        if ((View)view2.getTag(i19) != null) {
            left = i;
            i8 = i21;
        } else {
            if (i2 != 0) {
                if (i2.getParent() == null) {
                    if (i2 != 0) {
                        i9 = i;
                        viewById = i20;
                    } else {
                        i9 = i2;
                        viewById = i21;
                    }
                } else {
                    if (i6 == 4) {
                        i9 = i2;
                        viewById = i20;
                        i2 = i;
                    } else {
                        if (view2 == i2) {
                        } else {
                        }
                    }
                }
            } else {
            }
            if (viewById != 0) {
                if (view2.getParent() == null) {
                    left = i9;
                    i8 = i20;
                    parent = view2;
                } else {
                    if (parent2 instanceof View != null) {
                        viewById = view2.getParent();
                        if (!cVar.a) {
                            i2 = t.a(view, view2, viewById);
                            i8 = i20;
                            parent = i2;
                            left = i4;
                        } else {
                            i7 = viewById.getId();
                            if (viewById.getParent() == null && i7 != -1 && view.findViewById(i7) != null && obj.N) {
                                if (i7 != -1) {
                                    if (view.findViewById(i7) != null) {
                                        if (obj.N) {
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        if (parent != 0 && i8 == 0) {
            if (i8 == 0) {
                Object obj2 = bVar.a.get("android:visibility:screenLocation");
                int[] iArr = new int[top];
                view.getLocationOnScreen(iArr);
                parent.offsetLeftAndRight(i17 -= left);
                parent.offsetTopAndBottom(i11 -= top);
                a0.a(viewGroup).c(parent);
            }
            Animator animator2 = obj.n0(view, parent, bVar, aVar);
            if (i8 == 0) {
                if (animator2 == null) {
                    a0.a(viewGroup).d(parent);
                } else {
                    view2.setTag(i19, parent);
                    aVar = new m0.a(obj, view, parent, view2);
                    obj.a(aVar);
                }
            }
            return animator2;
        }
        if (left != 0) {
            f0.h(left, i20);
            Animator animator = obj.n0(view, left, bVar, aVar);
            if (animator != null) {
                bVar = new m0.b(left, i6, i21);
                animator.addListener(bVar);
                a.a(animator, bVar);
                obj.a(bVar);
            } else {
                f0.h(left, left.getVisibility());
            }
            return animator;
        }
        return i;
    }

    @Override // d.u.o
    public void p0(int i) {
        if (i & -4 != 0) {
        } else {
            this.b0 = i;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        throw obj2;
    }
}
