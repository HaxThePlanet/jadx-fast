package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import d.h.l.e0.c.a;
import d.h.l.e0.f;
import d.h.l.e0.f.a;
import d.h.l.u;
import d.j.b.c;
import d.j.b.c.c;

/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View>  extends CoordinatorLayout.c<V> {

    c a;
    com.google.android.material.behavior.SwipeDismissBehavior.c b;
    private boolean c;
    private float d = 0f;
    private boolean e;
    int f = 2;
    float g = 0.5f;
    float h = 0f;
    float i = 0.5f;
    private final c.c j;

    public interface c {
        public abstract void a(View view);

        public abstract void b(int i);
    }

    private class d implements Runnable {

        private final View a;
        private final boolean b;
        final com.google.android.material.behavior.SwipeDismissBehavior c;
        d(com.google.android.material.behavior.SwipeDismissBehavior swipeDismissBehavior, View view2, boolean z3) {
            this.c = swipeDismissBehavior;
            super();
            this.a = view2;
            this.b = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            boolean z;
            int i;
            cVar = swipeDismissBehavior.a;
            if (cVar != null && cVar.k(true)) {
                if (cVar.k(true)) {
                    u.d0(this.a, this);
                } else {
                    z = swipeDismissBehavior2.b;
                    if (this.b && z != null) {
                        z = swipeDismissBehavior2.b;
                        if (z != null) {
                            z.a(this.a);
                        }
                    }
                }
            } else {
            }
        }
    }

    class a extends c.c {

        private int a;
        private int b = -1;
        final com.google.android.material.behavior.SwipeDismissBehavior c;
        a(com.google.android.material.behavior.SwipeDismissBehavior swipeDismissBehavior) {
            this.c = swipeDismissBehavior;
            super();
            final int obj1 = -1;
        }

        private boolean n(View view, float f2) {
            int i;
            int obj7;
            int i2 = 0;
            final int cmp = Float.compare(f2, i2);
            final int i4 = 1;
            if (cmp != 0) {
                obj7 = u.B(view) == i4 ? i4 : i;
                int i5 = swipeDismissBehavior2.f;
                if (i5 == 2) {
                    return i4;
                }
                if (i5 == 0) {
                    if (obj7 != null) {
                        if (Float.compare(f2, i2) < 0) {
                            i = i4;
                        }
                    } else {
                        if (cmp > 0) {
                        }
                    }
                    return i;
                }
                if (i5 == i4) {
                    if (obj7 != null) {
                        if (cmp > 0) {
                            i = i4;
                        }
                    } else {
                        if (Float.compare(f2, i2) < 0) {
                        }
                    }
                }
                return i;
            }
            if (Math.abs(obj8 -= i3) >= Math.round(obj7 *= f)) {
                i = i4;
            }
            return i;
        }

        @Override // d.j.b.c$c
        public int a(View view, int i2, int i3) {
            int i;
            int obj3;
            int obj5;
            i = 1;
            obj5 = u.B(view) == i ? i : 0;
            int i4 = swipeDismissBehavior.f;
            if (i4 == 0) {
                if (obj5 != null) {
                    obj5 -= obj3;
                    obj3 = this.a;
                } else {
                    obj5 = this.a;
                    obj3 = view.getWidth();
                    obj3 += obj5;
                }
            } else {
            }
            return SwipeDismissBehavior.c(obj5, i2, obj3);
        }

        @Override // d.j.b.c$c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // d.j.b.c$c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // d.j.b.c$c
        public void i(View view, int i2) {
            int obj2;
            this.b = i2;
            this.a = view.getLeft();
            final ViewParent obj1 = view.getParent();
            if (obj1 != null) {
                obj1.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // d.j.b.c$c
        public void j(int i) {
            com.google.android.material.behavior.SwipeDismissBehavior.c cVar = swipeDismissBehavior.b;
            if (cVar != null) {
                cVar.b(i);
            }
        }

        @Override // d.j.b.c$c
        public void k(View view, int i2, int i3, int i4, int i5) {
            int i;
            float obj4;
            int obj7;
            obj5 += obj6;
            obj6 += obj7;
            obj4 = (float)i2;
            int i6 = 1065353216;
            if (Float.compare(obj4, obj5) <= 0) {
                view.setAlpha(i6);
            } else {
                i = 0;
                if (Float.compare(obj4, obj6) >= 0) {
                    view.setAlpha(i);
                } else {
                    view.setAlpha(SwipeDismissBehavior.b(i, i6 - obj4, i6));
                }
            }
        }

        @Override // d.j.b.c$c
        public void l(View view, float f2, float f3) {
            int i;
            int obj4;
            com.google.android.material.behavior.SwipeDismissBehavior.d obj5;
            this.b = -1;
            obj5 = view.getWidth();
            if (n(view, f2)) {
                int i2 = this.a;
                i = view.getLeft() < i2 ? i2 - obj5 : i2 + obj5;
                obj4 = 1;
            } else {
                i = this.a;
                obj4 = 0;
            }
            if (obj5.a.F(i, view.getTop())) {
                obj5 = new SwipeDismissBehavior.d(this.c, view, obj4);
                u.d0(view, obj5);
            } else {
                obj4 = obj4.b;
                if (obj4 != null && obj4 != null) {
                    obj4 = obj4.b;
                    if (obj4 != null) {
                        obj4.a(view);
                    }
                }
            }
        }

        @Override // d.j.b.c$c
        public boolean m(View view, int i2) {
            int obj3;
            int obj4;
            final int i = this.b;
            if (i != -1) {
                if (i == i2 && this.c.a(view)) {
                    obj3 = this.c.a(view) ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj3;
        }
    }

    class b implements f {

        final com.google.android.material.behavior.SwipeDismissBehavior a;
        b(com.google.android.material.behavior.SwipeDismissBehavior swipeDismissBehavior) {
            this.a = swipeDismissBehavior;
            super();
        }

        @Override // d.h.l.e0.f
        public boolean a(View view, f.a f$a2) {
            int i;
            int obj5;
            i = 0;
            if (this.a.a(view)) {
                final int i2 = 1;
                obj5 = u.B(view) == i2 ? i2 : i;
                int i3 = swipeDismissBehavior.f;
                if (i3 == 0) {
                    if (obj5 == null) {
                        if (i3 == i2 && obj5 == null) {
                            if (obj5 == null) {
                                i = i2;
                            }
                        }
                    } else {
                    }
                } else {
                }
                if (i != 0) {
                    obj5 = -obj5;
                }
                u.W(view, obj5);
                view.setAlpha(0);
                obj5 = obj5.b;
                if (obj5 != null) {
                    obj5.a(view);
                }
                return i2;
            }
            return i;
        }
    }
    public SwipeDismissBehavior() {
        super();
        int i = 0;
        int i2 = 2;
        int i3 = 1056964608;
        SwipeDismissBehavior.a aVar = new SwipeDismissBehavior.a(this);
        this.j = aVar;
    }

    static float b(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int c(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void d(ViewGroup viewGroup) {
        c.c cVar2;
        c.c cVar;
        c obj3;
        if (this.a == null) {
            if (this.e) {
                obj3 = c.l(viewGroup, this.d, this.j);
            } else {
                obj3 = c.m(viewGroup, this.j);
            }
            this.a = obj3;
        }
    }

    static float e(float f, float f2, float f3) {
        return obj2 /= obj1;
    }

    private void j(View view) {
        boolean z;
        int i;
        com.google.android.material.behavior.SwipeDismissBehavior.b bVar;
        u.f0(view, 1048576);
        if (a(view)) {
            bVar = new SwipeDismissBehavior.b(this);
            u.h0(view, c.a.j, 0, bVar);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public boolean a(View view) {
        return 1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void f(float f) {
        this.i = SwipeDismissBehavior.b(0, f, 1065353216);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void g(com.google.android.material.behavior.SwipeDismissBehavior.c swipeDismissBehavior$c) {
        this.b = c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void h(float f) {
        this.h = SwipeDismissBehavior.b(0, f, 1065353216);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
    public void i(int i) {
        this.f = i;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        boolean pointInChildBounds;
        int actionMasked;
        View obj5;
        pointInChildBounds = this.c;
        actionMasked = motionEvent3.getActionMasked();
        final int i2 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 3) {
                if (actionMasked != 3) {
                } else {
                    this.c = i2;
                }
            } else {
            }
        } else {
            this.c = coordinatorLayout.isPointInChildBounds(v2, (int)f, (int)f2);
        }
        if (pointInChildBounds) {
            d(coordinatorLayout);
            return this.a.G(motionEvent3);
        }
        return i2;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        int obj3;
        if (u.z(v2) == 0) {
            u.v0(v2, 1);
            j(v2);
        }
        return super.onLayoutChild(coordinatorLayout, v2, i3);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        c obj1 = this.a;
        if (obj1 != null) {
            obj1.z(motionEvent3);
            return 1;
        }
        return 0;
    }
}
