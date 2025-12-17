package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.h.l.u;

/* loaded from: classes2.dex */
abstract class a<V extends View>  extends com.google.android.material.appbar.c<V> {

    private Runnable a;
    OverScroller b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    private class a implements Runnable {

        private final CoordinatorLayout a;
        private final V b;
        final com.google.android.material.appbar.a c;
        a(com.google.android.material.appbar.a a, CoordinatorLayout coordinatorLayout2, View view3) {
            this.c = a;
            super();
            this.a = coordinatorLayout2;
            this.b = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object view;
            CoordinatorLayout coordinatorLayout;
            View view2;
            int currY;
            view = aVar.b;
            if (this.b != null && view != null) {
                view = aVar.b;
                if (view != null) {
                    if (view.computeScrollOffset()) {
                        com.google.android.material.appbar.a aVar2 = this.c;
                        aVar2.i(this.a, this.b, aVar2.b.getCurrY());
                        u.d0(this.b, this);
                    } else {
                        this.c.g(this.a, this.b);
                    }
                }
            }
        }
    }
    public a() {
        super();
        final int i = -1;
    }

    public a(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj1 = -1;
    }

    private void b() {
        VelocityTracker obtain;
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    abstract boolean a(V v);

    final boolean c(CoordinatorLayout coordinatorLayout, V v2, int i3, int i4, float f5) {
        Runnable runnable;
        OverScroller overScroller;
        Context context;
        final Object obj = this;
        View view = v2;
        runnable = obj.a;
        if (runnable != null) {
            v2.removeCallbacks(runnable);
            obj.a = 0;
        }
        if (obj.b == null) {
            overScroller = new OverScroller(v2.getContext());
            obj.b = overScroller;
        }
        obj.b.fling(0, getTopAndBottomOffset(), 0, Math.round(f5), 0, 0, i3, i4);
        if (obj.b.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            a.a aVar = new a.a(this, coordinatorLayout, v2);
            obj.a = aVar;
            u.d0(v2, aVar);
            return 1;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        g(coordinatorLayout, v2);
        return 0;
    }

    abstract int d(V v);

    abstract int e(V v);

    @Override // com.google.android.material.appbar.c
    abstract int f();

    abstract void g(CoordinatorLayout coordinatorLayout, V v2);

    final int h(CoordinatorLayout coordinatorLayout, V v2, int i3, int i4, int i5) {
        return this.j(coordinatorLayout, v2, i - i3, i4, i5);
    }

    int i(CoordinatorLayout coordinatorLayout, V v2, int i3) {
        return this.j(coordinatorLayout, v2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int j(CoordinatorLayout coordinatorLayout, V v2, int i3, int i4, int i5);

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        int scaledTouchSlop;
        int actionMasked;
        int actionMasked2;
        int i3;
        int i;
        int i2;
        boolean obj7;
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        final int i7 = 1;
        i = -1;
        final int i8 = 0;
        int i4 = this.d;
        if (motionEvent3.getActionMasked() == 2 && this.c && i4 == i) {
            if (this.c) {
                i4 = this.d;
                if (i4 == i) {
                    return i8;
                }
                int pointerIndex = motionEvent3.findPointerIndex(i4);
                if (pointerIndex == i) {
                    return i8;
                }
                actionMasked = (int)f;
                if (Math.abs(actionMasked - i5) > this.f) {
                    this.e = actionMasked;
                    return i7;
                }
            }
        }
        if (motionEvent3.getActionMasked() == 0) {
            this.d = i;
            i3 = (int)f3;
            if (a(v2) && coordinatorLayout.isPointInChildBounds(v2, (int)f2, i3)) {
                obj7 = coordinatorLayout.isPointInChildBounds(v2, actionMasked2, i3) ? i7 : i8;
            } else {
            }
            this.c = obj7;
            this.e = i3;
            this.d = motionEvent3.getPointerId(i8);
            b();
            obj7 = this.b;
            if (obj7 != null && obj7 != null && !obj7.isFinished()) {
                this.e = i3;
                this.d = motionEvent3.getPointerId(i8);
                b();
                obj7 = this.b;
                if (obj7 != null) {
                    if (!obj7.isFinished()) {
                        this.b.abortAnimation();
                        return i7;
                    }
                }
            }
        }
        obj7 = this.g;
        if (obj7 != null) {
            obj7.addMovement(motionEvent3);
        }
        return i8;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
        int actionMasked;
        int i;
        int i2;
        Object i5;
        CoordinatorLayout coordinatorLayout2;
        View view;
        int i6;
        int i4;
        int i3;
        float yVelocity;
        int obj12;
        View obj13;
        actionMasked = motionEvent3.getActionMasked();
        i = -1;
        i2 = 1;
        final int i8 = 0;
        if (actionMasked != i2) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                    } else {
                        obj12 = motionEvent3.getActionIndex() == 0 ? i2 : i8;
                        this.d = motionEvent3.getPointerId(obj12);
                        this.e = (int)obj12;
                    }
                    obj12 = i8;
                } else {
                    obj12 = i8;
                    this.c = i8;
                    this.d = i;
                    obj13 = this.g;
                    if (obj13 != null) {
                        obj13.recycle();
                        this.g = 0;
                    }
                }
            } else {
                int pointerIndex = motionEvent3.findPointerIndex(this.d);
                if (pointerIndex == i) {
                    return i8;
                }
                actionMasked = (int)f;
                this.e = actionMasked;
                this.h(coordinatorLayout, v2, i - actionMasked, d(v2), 0);
            }
        } else {
            actionMasked = this.g;
            if (actionMasked != null) {
                actionMasked.addMovement(motionEvent3);
                this.g.computeCurrentVelocity(1000);
                this.c(coordinatorLayout, v2, -actionMasked, 0, this.g.getYVelocity(this.d));
                obj12 = i2;
            } else {
            }
        }
        obj13 = this.g;
        if (obj13 != null) {
            obj13.addMovement(motionEvent3);
        }
        if (!this.c) {
            if (obj12 != null) {
            } else {
                i2 = i8;
            }
        }
        return i2;
    }
}
