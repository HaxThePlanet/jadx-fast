package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import d.h.l.d;
import d.h.l.u;
import d.r.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l extends androidx.recyclerview.widget.RecyclerView.o implements androidx.recyclerview.widget.RecyclerView.r {

    private androidx.recyclerview.widget.l.g A;
    private final androidx.recyclerview.widget.RecyclerView.t B;
    private Rect C;
    private long D;
    final List<View> a;
    private final float[] b;
    androidx.recyclerview.widget.RecyclerView.e0 c = null;
    float d;
    float e;
    private float f;
    private float g;
    float h;
    float i;
    private float j;
    private float k;
    int l = -1;
    androidx.recyclerview.widget.l.f m;
    private int n = 0;
    int o;
    List<androidx.recyclerview.widget.l.h> p;
    private int q;
    androidx.recyclerview.widget.RecyclerView r;
    final Runnable s;
    VelocityTracker t;
    private List<androidx.recyclerview.widget.RecyclerView.e0> u;
    private List<Integer> v;
    private androidx.recyclerview.widget.RecyclerView.k w = null;
    View x = null;
    int y = -1;
    d z;

    class a implements Runnable {

        final androidx.recyclerview.widget.l a;
        a(androidx.recyclerview.widget.l l) {
            this.a = l;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.l lVar;
            Object view;
            lVar = this.a;
            androidx.recyclerview.widget.l lVar2 = this.a;
            androidx.recyclerview.widget.RecyclerView.e0 view2 = lVar2.c;
            if (lVar.c != null && lVar.y() && view2 != null) {
                if (lVar.y()) {
                    lVar2 = this.a;
                    view2 = lVar2.c;
                    if (view2 != null) {
                        lVar2.t(view2);
                    }
                    androidx.recyclerview.widget.l lVar3 = this.a;
                    lVar3.r.removeCallbacks(lVar3.s);
                    u.d0(lVar4.r, this);
                }
            }
        }
    }

    class d implements Runnable {

        final androidx.recyclerview.widget.l.h a;
        final int b;
        final androidx.recyclerview.widget.l c;
        d(androidx.recyclerview.widget.l l, androidx.recyclerview.widget.l.h l$h2, int i3) {
            this.c = l;
            this.a = h2;
            this.b = i3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.RecyclerView absoluteAdapterPosition;
            androidx.recyclerview.widget.RecyclerView.m itemAnimator;
            boolean z;
            int i;
            absoluteAdapterPosition = lVar.r;
            absoluteAdapterPosition = this.a;
            if (absoluteAdapterPosition != null && absoluteAdapterPosition.isAttachedToWindow() && !absoluteAdapterPosition.k && absoluteAdapterPosition.e.getAbsoluteAdapterPosition() != -1) {
                if (absoluteAdapterPosition.isAttachedToWindow()) {
                    absoluteAdapterPosition = this.a;
                    if (!absoluteAdapterPosition.k) {
                        if (absoluteAdapterPosition.e.getAbsoluteAdapterPosition() != -1) {
                            itemAnimator = lVar2.r.getItemAnimator();
                            if (itemAnimator != null) {
                                if (!itemAnimator.isRunning(0) && !this.c.r()) {
                                    if (!this.c.r()) {
                                        lVar4.m.C(hVar.e, this.b);
                                    } else {
                                        lVar5.r.post(this);
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    }
                }
            }
        }
    }

    public static abstract class f {

        private static final Interpolator b;
        private static final Interpolator c;
        private int a = -1;
        static {
            l.f.a aVar = new l.f.a();
            l.f.b = aVar;
            l.f.b bVar = new l.f.b();
            l.f.c = bVar;
        }

        public f() {
            super();
            final int i = -1;
        }

        public static int e(int i, int i2) {
            int i3;
            int obj3;
            int obj4;
            final int i4 = 789516;
            i3 = i & i4;
            if (i3 == 0) {
                return i;
            }
            if (i2 == 0) {
                obj4 = i3 << 2;
            } else {
                obj4 = i3 << 1;
                obj3 |= i3;
                obj4 <<= 2;
            }
            return obj3 |= obj4;
        }

        public static androidx.recyclerview.widget.m i() {
            return n.a;
        }

        private int j(androidx.recyclerview.widget.RecyclerView recyclerView) {
            int i;
            int obj3;
            if (this.a == -1) {
                this.a = recyclerView.getResources().getDimensionPixelSize(b.d);
            }
            return this.a;
        }

        public static int t(int i, int i2) {
            return i2 << obj0;
        }

        public static int u(int i, int i2) {
            return obj2 |= obj3;
        }

        public void A(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e04, int i5, int i6, int i7) {
            boolean obj3;
            androidx.recyclerview.widget.RecyclerView.p obj4;
            Object obj5;
            int obj7;
            int obj8;
            obj4 = recyclerView.getLayoutManager();
            if (obj4 instanceof l.j) {
                (l.j)obj4.o(e02.itemView, e04.itemView, i6, i7);
            }
            if (obj4.H() && obj4.n0(e04.itemView) <= recyclerView.getPaddingLeft()) {
                if (obj4.n0(e04.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.q1(i5);
                }
                if (obj4.q0(e04.itemView) >= obj7 -= obj8) {
                    recyclerView.q1(i5);
                }
            }
            if (obj4.I() && obj4.r0(e04.itemView) <= recyclerView.getPaddingTop()) {
                if (obj4.r0(e04.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.q1(i5);
                }
                if (obj4.l0(e04.itemView) >= obj4 -= obj5) {
                    recyclerView.q1(i5);
                }
            }
        }

        public void B(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
            Object obj1;
            androidx.recyclerview.widget.m obj2;
            if (e0 != null) {
                n.a.b(e0.itemView);
            }
        }

        public abstract void C(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2);

        public boolean a(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03) {
            return 1;
        }

        public androidx.recyclerview.widget.RecyclerView.e0 b(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, List<androidx.recyclerview.widget.RecyclerView.e0> list2, int i3, int i4) {
            int i;
            int i2;
            int i6;
            Object obj3;
            Object obj;
            int i5;
            int bottom2;
            int bottom;
            final Object obj2 = e0;
            int i9 = i3 - left;
            int i10 = i4 - top;
            i = 0;
            i2 = -1;
            i6 = 0;
            while (i6 < list2.size()) {
                obj = list2.get(i6);
                right -= i7;
                i5 = Math.abs(i5);
                if (i9 > 0 && i5 < 0 && obj.itemView.getRight() > obj2.itemView.getRight() && i5 > i2) {
                }
                left2 -= i3;
                i5 = Math.abs(i5);
                if (i9 < 0 && i5 > 0 && obj.itemView.getLeft() < obj2.itemView.getLeft() && i5 > i2) {
                }
                top2 -= i4;
                i5 = Math.abs(i5);
                if (i10 < 0 && i5 > 0 && obj.itemView.getTop() < obj2.itemView.getTop() && i5 > i2) {
                }
                bottom3 -= i8;
                i5 = Math.abs(i5);
                if (i10 > 0 && i5 < 0 && obj.itemView.getBottom() > obj2.itemView.getBottom() && i5 > i2) {
                }
                i6++;
                bottom3 -= i8;
                if (i5 < 0) {
                }
                if (obj.itemView.getBottom() > obj2.itemView.getBottom()) {
                }
                i5 = Math.abs(i5);
                if (i5 > i2) {
                }
                i = obj;
                i2 = i5;
                top2 -= i4;
                if (i5 > 0) {
                }
                if (obj.itemView.getTop() < obj2.itemView.getTop()) {
                }
                i5 = Math.abs(i5);
                if (i5 > i2) {
                }
                i = obj;
                i2 = i5;
                left2 -= i3;
                if (i5 > 0) {
                }
                if (obj.itemView.getLeft() < obj2.itemView.getLeft()) {
                }
                i5 = Math.abs(i5);
                if (i5 > i2) {
                }
                i = obj;
                i2 = i5;
                right -= i7;
                if (i5 < 0) {
                }
                if (obj.itemView.getRight() > obj2.itemView.getRight()) {
                }
                i5 = Math.abs(i5);
                if (i5 > i2) {
                }
                i = obj;
                i2 = i5;
            }
            return i;
        }

        public void c(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            n.a.a(e02.itemView);
        }

        public int d(int i, int i2) {
            int i3;
            int obj4;
            int obj5;
            final int i4 = 3158064;
            i3 = i & i4;
            if (i3 == 0) {
                return i;
            }
            if (i2 == 0) {
                obj5 = i3 >> 2;
            } else {
                obj5 = i3 >> 1;
                obj4 |= i3;
                obj5 >>= 2;
            }
            return obj4 |= obj5;
        }

        final int f(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            return d(l(recyclerView, e02), u.B(recyclerView));
        }

        public long g(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, float f3, float f4) {
            long obj1;
            obj1 = recyclerView.getItemAnimator();
            final int obj3 = 8;
            if (obj1 == null) {
                obj1 = i2 == obj3 ? 200 : 250;
                return obj1;
            }
            if (i2 == obj3) {
                obj1 = obj1.getMoveDuration();
            } else {
                obj1 = obj1.getRemoveDuration();
            }
            return obj1;
        }

        public int h() {
            return 0;
        }

        public float k(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            return 1056964608;
        }

        public abstract int l(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02);

        public float m(float f) {
            return f;
        }

        public float n(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            return 1056964608;
        }

        public float o(float f) {
            return f;
        }

        boolean p(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            int obj1;
            obj1 = obj1 &= obj2 != 0 ? 1 : 0;
            return obj1;
        }

        public int q(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, int i4, long l5) {
            int i;
            int obj5;
            float obj6;
            int obj8;
            i = 1065353216;
            if (Long.compare(l5, i7) > 0) {
            } else {
                i = obj6 / obj8;
            }
            if ((int)obj5 == 0) {
                obj5 = i3 > 0 ? 1 : -1;
            }
            return obj5;
        }

        public boolean r() {
            return 1;
        }

        public boolean s() {
            return 1;
        }

        public void v(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03, float f4, float f5, int i6, boolean z7) {
            n.a.d(canvas, recyclerView2, e03.itemView, f4, f5, i6, z7);
        }

        public void w(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03, float f4, float f5, int i6, boolean z7) {
            n.a.c(canvas, recyclerView2, e03.itemView, f4, f5, i6, z7);
        }

        void x(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03, List<androidx.recyclerview.widget.l.h> list4, int i5, float f6, float f7) {
            int i2;
            Canvas canvas2;
            androidx.recyclerview.widget.RecyclerView view2;
            androidx.recyclerview.widget.RecyclerView.e0 view;
            float f;
            float f2;
            int i3;
            int i4;
            int size;
            int i;
            Object obj2;
            int save;
            final Canvas canvas3 = canvas;
            i = i2;
            while (i < list4.size()) {
                Object obj = list4.get(i);
                (l.h)obj.e();
                this.v(canvas, recyclerView2, obj.e, obj.i, obj.j, obj.f, false);
                canvas.restoreToCount(canvas.save());
                i++;
            }
            if (e03 != null) {
                this.v(canvas, recyclerView2, e03, f6, f7, i5, true);
                canvas.restoreToCount(canvas.save());
            }
        }

        void y(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03, List<androidx.recyclerview.widget.l.h> list4, int i5, float f6, float f7) {
            Object obj;
            Canvas canvas2;
            androidx.recyclerview.widget.RecyclerView view;
            androidx.recyclerview.widget.RecyclerView.e0 view2;
            float f;
            float f2;
            int i3;
            int i4;
            int i;
            int i2;
            int save2;
            int save;
            final Canvas canvas3 = canvas;
            final Object obj3 = list4;
            int size = list4.size();
            save2 = i2;
            while (save2 < size) {
                Object obj2 = obj3.get(save2);
                this.w(canvas, recyclerView2, obj2.e, obj2.i, obj2.j, obj2.f, false);
                canvas.restoreToCount(canvas.save());
                save2++;
            }
            if (e03 != null) {
                this.w(canvas, recyclerView2, e03, f6, f7, i5, true);
                canvas.restoreToCount(canvas.save());
            }
            int i6 = 1;
            size -= i6;
            while (i >= 0) {
                canvas2 = obj3.get(i);
                view = canvas2.l;
                if (view != null && !canvas2.h) {
                } else {
                }
                if (view == null) {
                }
                i--;
                i2 = i6;
                if (!canvas2.h) {
                } else {
                }
                obj3.remove(i);
            }
            if (i2 != 0) {
                recyclerView2.invalidate();
            }
        }

        public abstract boolean z(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03);
    }

    private class g extends GestureDetector.SimpleOnGestureListener {

        private boolean a = true;
        final androidx.recyclerview.widget.l b;
        g(androidx.recyclerview.widget.l l) {
            this.b = l;
            super();
            final int obj1 = 1;
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        void a() {
            this.a = false;
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return 1;
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Object view;
            androidx.recyclerview.widget.RecyclerView pointerId;
            int i;
            MotionEvent obj4;
            if (!this.a) {
            }
            view = this.b.n(motionEvent);
            view = lVar2.r.j0(view);
            androidx.recyclerview.widget.l lVar3 = this.b;
            if (view != null && view != null && !lVar3.m.p(lVar3.r, view)) {
                view = lVar2.r.j0(view);
                if (view != null) {
                    lVar3 = this.b;
                    if (!lVar3.m.p(lVar3.r, view)) {
                    }
                    i = lVar4.l;
                    int pointerIndex = motionEvent.findPointerIndex(i);
                    pointerId = this.b;
                    pointerId.d = motionEvent.getX(pointerIndex);
                    pointerId.e = motionEvent.getY(pointerIndex);
                    obj4 = 0;
                    pointerId.i = obj4;
                    pointerId.h = obj4;
                    if (motionEvent.getPointerId(0) == i && pointerId.m.s()) {
                        pointerIndex = motionEvent.findPointerIndex(i);
                        pointerId = this.b;
                        pointerId.d = motionEvent.getX(pointerIndex);
                        pointerId.e = motionEvent.getY(pointerIndex);
                        obj4 = 0;
                        pointerId.i = obj4;
                        pointerId.h = obj4;
                        if (pointerId.m.s()) {
                            this.b.z(view, 2);
                        }
                    }
                }
            }
        }
    }

    static class h implements Animator.AnimatorListener {

        final float a;
        final float b;
        final float c;
        final float d;
        final androidx.recyclerview.widget.RecyclerView.e0 e;
        final int f;
        final ValueAnimator g;
        boolean h;
        float i;
        float j;
        boolean k = false;
        boolean l = false;
        private float m;
        h(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, float f4, float f5, float f6, float f7) {
            super();
            int obj2 = 0;
            this.f = i3;
            this.e = e0;
            this.a = f4;
            this.b = f5;
            this.c = f6;
            this.d = f7;
            obj2 = new float[2];
            obj2 = new int[]{0, 1065353216};
            obj2 = ValueAnimator.ofFloat(obj2);
            this.g = obj2;
            l.h.a obj3 = new l.h.a(this);
            obj2.addUpdateListener(obj3);
            obj2.setTarget(e0.itemView);
            obj2.addListener(this);
            c(0);
        }

        @Override // android.animation.Animator$AnimatorListener
        public void a() {
            this.g.cancel();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void b(long l) {
            this.g.setDuration(l);
        }

        @Override // android.animation.Animator$AnimatorListener
        public void c(float f) {
            this.m = f;
        }

        @Override // android.animation.Animator$AnimatorListener
        public void d() {
            this.e.setIsRecyclable(false);
            this.g.start();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void e() {
            float translationX;
            int translationY;
            float f;
            int f2;
            int cmp;
            int cmp2;
            float f3 = this.a;
            f = this.c;
            if (Float.compare(f3, f) == 0) {
                this.i = view2.itemView.getTranslationX();
            } else {
                this.i = f3 += cmp;
            }
            float f4 = this.b;
            f2 = this.d;
            if (Float.compare(f4, f2) == 0) {
                this.j = view.itemView.getTranslationY();
            } else {
                this.j = f4 += cmp2;
            }
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1065353216);
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean obj2;
            final int i = 1;
            if (!this.l) {
                this.e.setIsRecyclable(i);
            }
            this.l = i;
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface j {
        public abstract void o(View view, View view2, int i3, int i4);
    }

    class b implements androidx.recyclerview.widget.RecyclerView.t {

        final androidx.recyclerview.widget.l a;
        b(androidx.recyclerview.widget.l l) {
            this.a = l;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$t
        public void a(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2) {
            int pointerId;
            int pointerIndex;
            androidx.recyclerview.widget.l lVar2;
            androidx.recyclerview.widget.l lVar;
            int i2;
            int i;
            int obj8;
            MotionEvent obj9;
            obj8.z.a(motionEvent2);
            obj8 = obj8.t;
            if (obj8 != null) {
                obj8.addMovement(motionEvent2);
            }
            pointerId = -1;
            if (obj8.l == pointerId) {
            }
            obj8 = motionEvent2.getActionMasked();
            pointerIndex = motionEvent2.findPointerIndex(lVar3.l);
            if (pointerIndex >= 0) {
                this.a.i(obj8, motionEvent2, pointerIndex);
            }
            lVar = this.a;
            final androidx.recyclerview.widget.RecyclerView.e0 view = lVar.c;
            if (view == null) {
            }
            final int i4 = 1;
            if (obj8 != i4) {
                if (obj8 != 2) {
                    if (obj8 != 3) {
                        if (obj8 != 6) {
                        } else {
                            obj8 = motionEvent2.getActionIndex();
                            pointerIndex = this.a;
                            if (motionEvent2.getPointerId(obj8) == pointerIndex.l && obj8 == null) {
                                if (obj8 == null) {
                                    i2 = i4;
                                }
                                pointerIndex.l = motionEvent2.getPointerId(i2);
                                pointerId = this.a;
                                pointerId.F(motionEvent2, pointerId.o, obj8);
                            }
                        }
                    } else {
                        obj8 = lVar.t;
                        if (obj8 != null) {
                            obj8.clear();
                        }
                        this.a.z(0, 0);
                        obj8.l = pointerId;
                    }
                } else {
                    if (pointerIndex >= 0) {
                        lVar.F(motionEvent2, lVar.o, pointerIndex);
                        this.a.t(view);
                        obj8 = this.a;
                        obj8.r.removeCallbacks(obj8.s);
                        obj8.s.run();
                        obj8.r.invalidate();
                    }
                }
            } else {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$t
        public boolean c(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2) {
            int i2;
            boolean remove;
            int pointerIndex;
            Object itemView;
            int i;
            float f;
            androidx.recyclerview.widget.l obj6;
            obj6.z.a(motionEvent2);
            obj6 = motionEvent2.getActionMasked();
            i2 = 1;
            final int i3 = 0;
            if (obj6 == null) {
                obj6.l = motionEvent2.getPointerId(i3);
                obj6.d = motionEvent2.getX();
                obj6.e = motionEvent2.getY();
                this.a.u();
                obj6 = this.a;
                obj6 = obj6.m(motionEvent2);
                androidx.recyclerview.widget.l lVar2 = this.a;
                lVar2.d = f4 -= f6;
                lVar2.e = f5 -= f;
                lVar2.l(obj6.e, i2);
                if (obj6.c == null && obj6 != null && lVar3.a.remove(view2.itemView)) {
                    obj6 = obj6.m(motionEvent2);
                    if (obj6 != null) {
                        lVar2 = this.a;
                        lVar2.d = f4 -= f6;
                        lVar2.e = f5 -= f;
                        lVar2.l(obj6.e, i2);
                        if (lVar3.a.remove(view2.itemView)) {
                            androidx.recyclerview.widget.l lVar4 = this.a;
                            lVar4.m.c(lVar4.r, obj6.e);
                        }
                        this.a.z(obj6.e, obj6.f);
                        obj6 = this.a;
                        obj6.F(motionEvent2, obj6.o, i3);
                    }
                }
            } else {
                i = -1;
                if (obj6 != 3) {
                    if (obj6 == i2) {
                        obj6 = this.a;
                        obj6.l = i;
                        obj6.z(0, i3);
                    } else {
                        pointerIndex = lVar.l;
                        pointerIndex = motionEvent2.findPointerIndex(pointerIndex);
                        if (pointerIndex != i && pointerIndex >= 0) {
                            pointerIndex = motionEvent2.findPointerIndex(pointerIndex);
                            if (pointerIndex >= 0) {
                                this.a.i(obj6, motionEvent2, pointerIndex);
                            }
                        }
                    }
                } else {
                }
            }
            obj6 = obj6.t;
            if (obj6 != null) {
                obj6.addMovement(motionEvent2);
            }
            if (obj6.c != null) {
            } else {
                i2 = i3;
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$t
        public void e(boolean z) {
            if (!z) {
            }
            this.a.z(0, 0);
        }
    }

    class c extends androidx.recyclerview.widget.l.h {

        final int n;
        final androidx.recyclerview.widget.RecyclerView.e0 o;
        final androidx.recyclerview.widget.l p;
        c(androidx.recyclerview.widget.l l, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, int i4, float f5, float f6, float f7, float f8, int i9, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e010) {
            final Object obj2 = this;
            obj2.p = l;
            obj2.n = i9;
            obj2.o = e010;
            super(e02, i3, i4, f5, f6, f7, f8);
        }

        @Override // androidx.recyclerview.widget.l$h
        public void onAnimationEnd(Animator animator) {
            Object itemView;
            androidx.recyclerview.widget.RecyclerView.e0 view;
            androidx.recyclerview.widget.RecyclerView obj3;
            super.onAnimationEnd(animator);
            if (this.k) {
            }
            if (this.n <= 0) {
                obj3 = this.p;
                obj3.m.c(obj3.r, this.o);
            } else {
                obj3.a.add(view3.itemView);
                this.h = true;
                obj3 = this.n;
                if (obj3 > 0) {
                    this.p.v(this, obj3);
                }
            }
            obj3 = this.p;
            View itemView2 = view4.itemView;
            if (obj3.x == itemView2) {
                obj3.x(itemView2);
            }
        }
    }

    class e implements androidx.recyclerview.widget.RecyclerView.k {

        final androidx.recyclerview.widget.l a;
        e(androidx.recyclerview.widget.l l) {
            this.a = l;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$k
        public int a(int i, int i2) {
            androidx.recyclerview.widget.l lVar;
            int indexOfChild;
            int obj6;
            lVar = this.a;
            final View view2 = lVar.x;
            if (view2 == null) {
                return i2;
            }
            if (lVar.y == -1) {
                lVar.y = lVar.r.indexOfChild(view2);
            }
            if (i2 == i--) {
                return indexOfChild;
            }
            if (i2 < indexOfChild) {
            } else {
                i2++;
            }
            return obj6;
        }
    }

    public static abstract class i extends androidx.recyclerview.widget.l.f {

        private int d;
        private int e;
        public i(int i, int i2) {
            super();
            this.d = i2;
            this.e = i;
        }

        @Override // androidx.recyclerview.widget.l$f
        public int D(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            return this.e;
        }

        @Override // androidx.recyclerview.widget.l$f
        public int E(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            return this.d;
        }

        @Override // androidx.recyclerview.widget.l$f
        public int l(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            return l.f.u(D(recyclerView, e02), E(recyclerView, e02));
        }
    }
    public l(androidx.recyclerview.widget.l.f l$f) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = new float[2];
        int i2 = 0;
        final int i3 = -1;
        int i4 = 0;
        ArrayList arrayList2 = new ArrayList();
        this.p = arrayList2;
        l.a aVar = new l.a(this);
        this.s = aVar;
        l.b bVar = new l.b(this);
        this.B = bVar;
        this.m = f;
    }

    private void A() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.h(this);
        this.r.k(this.B);
        this.r.j(this);
        C();
    }

    private void C() {
        l.g gVar = new l.g(this);
        this.A = gVar;
        d dVar = new d(this.r.getContext(), this.A);
        this.z = dVar;
    }

    private void D() {
        androidx.recyclerview.widget.l.g gVar = this.A;
        final int i = 0;
        if (gVar != null) {
            gVar.a();
            this.A = i;
        }
        if (this.z != null) {
            this.z = i;
        }
    }

    private int E(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int i;
        int i2;
        int obj6;
        final int i7 = 0;
        if (this.n == 2) {
            return i7;
        }
        int i4 = this.m.l(this.r, e0);
        int i13 = 65280;
        i10 >>= 8;
        if (i11 == 0) {
            return i7;
        }
        i5 >>= 8;
        if (Float.compare(f2, f4) > 0) {
            i2 = h(e0, i11);
            if (i2 > 0 && i6 & i2 == 0) {
                if (i6 & i2 == 0) {
                    return l.f.e(i2, u.B(this.r));
                }
                return i2;
            }
            obj6 = j(e0, i11);
            if (obj6 > 0) {
                return obj6;
            }
        } else {
            i2 = j(e0, i11);
            if (i2 > 0) {
                return i2;
            }
            obj6 = h(e0, i11);
            if (obj6 > 0 && i6 &= obj6 == 0) {
                if (i6 &= obj6 == 0) {
                    obj6 = l.f.e(obj6, u.B(this.r));
                }
                return obj6;
            }
        }
        return i7;
    }

    private void f() {
        androidx.recyclerview.widget.RecyclerView.k eVar;
        if (Build.VERSION.SDK_INT >= 21) {
        }
        if (this.w == null) {
            eVar = new l.e(this);
            this.w = eVar;
        }
        this.r.setChildDrawingOrderCallback(this.w);
    }

    private int h(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
        int i3;
        int i4;
        int cmp2;
        androidx.recyclerview.widget.l.f fVar;
        int i5;
        int cmp;
        VelocityTracker xVelocity;
        int yVelocity;
        int i;
        float f;
        androidx.recyclerview.widget.RecyclerView.e0 obj9;
        if (i2 & 12 != 0) {
            cmp2 = 0;
            cmp = 4;
            i3 = Float.compare(f2, cmp2) > 0 ? i5 : cmp;
            xVelocity = this.t;
            if (xVelocity != null && this.l > -1) {
                if (this.l > -1) {
                    f = this.g;
                    this.m.o(f);
                    xVelocity.computeCurrentVelocity(1000, f);
                    xVelocity = this.t.getXVelocity(this.l);
                    if (Float.compare(xVelocity, cmp2) > 0) {
                    } else {
                        i5 = cmp;
                    }
                    cmp2 = Math.abs(xVelocity);
                    xVelocity = this.f;
                    this.m.m(xVelocity);
                    if (i5 & i2 != 0 && i3 == i5 && Float.compare(cmp2, xVelocity) >= 0 && Float.compare(cmp2, cmp) > 0) {
                        if (i3 == i5) {
                            xVelocity = this.f;
                            this.m.m(xVelocity);
                            if (Float.compare(cmp2, xVelocity) >= 0) {
                                if (Float.compare(cmp2, cmp) > 0) {
                                    return i5;
                                }
                            }
                        }
                    }
                }
            }
            if (i2 & i3 != 0 && Float.compare(obj9, i4) > 0) {
                if (Float.compare(obj9, i4) > 0) {
                    return i3;
                }
            }
        }
        return 0;
    }

    private int j(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
        int i5;
        int i;
        int cmp;
        androidx.recyclerview.widget.l.f fVar;
        int i4;
        int cmp2;
        VelocityTracker xVelocity;
        int yVelocity;
        int i3;
        float f;
        androidx.recyclerview.widget.RecyclerView.e0 obj9;
        if (i2 & 3 != 0) {
            cmp = 0;
            cmp2 = 1;
            i5 = Float.compare(f2, cmp) > 0 ? i4 : cmp2;
            xVelocity = this.t;
            if (xVelocity != null && this.l > -1) {
                if (this.l > -1) {
                    f = this.g;
                    this.m.o(f);
                    xVelocity.computeCurrentVelocity(1000, f);
                    yVelocity = this.t.getYVelocity(this.l);
                    if (Float.compare(yVelocity, cmp) > 0) {
                    } else {
                        i4 = cmp2;
                    }
                    cmp = Math.abs(yVelocity);
                    yVelocity = this.f;
                    this.m.m(yVelocity);
                    if (i4 & i2 != 0 && i4 == i5 && Float.compare(cmp, yVelocity) >= 0 && Float.compare(cmp, cmp2) > 0) {
                        if (i4 == i5) {
                            yVelocity = this.f;
                            this.m.m(yVelocity);
                            if (Float.compare(cmp, yVelocity) >= 0) {
                                if (Float.compare(cmp, cmp2) > 0) {
                                    return i4;
                                }
                            }
                        }
                    }
                }
            }
            if (i2 & i5 != 0 && Float.compare(obj9, i) > 0) {
                if (Float.compare(obj9, i) > 0) {
                    return i5;
                }
            }
        }
        return 0;
    }

    private void k() {
        int i;
        androidx.recyclerview.widget.RecyclerView.t view2;
        androidx.recyclerview.widget.l.f fVar;
        androidx.recyclerview.widget.RecyclerView view;
        this.r.d1(this);
        this.r.g1(this.B);
        this.r.f1(this);
        size--;
        while (i >= 0) {
            Object obj = this.p.get(0);
            (l.h)obj.a();
            this.m.c(this.r, obj.e);
            i--;
        }
        this.p.clear();
        this.x = 0;
        this.y = -1;
        w();
        D();
    }

    private List<androidx.recyclerview.widget.RecyclerView.e0> o(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        Object intValue;
        Object arrayList;
        boolean valueOf;
        int i;
        View size;
        View itemView;
        androidx.recyclerview.widget.l.f fVar;
        androidx.recyclerview.widget.RecyclerView view;
        final Object obj = this;
        intValue = e0;
        List list4 = obj.u;
        if (list4 == null) {
            ArrayList arrayList2 = new ArrayList();
            obj.u = arrayList2;
            arrayList = new ArrayList();
            obj.v = arrayList;
        } else {
            list4.clear();
            obj.v.clear();
        }
        int i2 = obj.m.h();
        round -= i2;
        round2 -= i2;
        i2 *= 2;
        i10 += i3;
        i12 += i3;
        androidx.recyclerview.widget.RecyclerView.p layoutManager = obj.r.getLayoutManager();
        i = 0;
        while (i < layoutManager.g0()) {
            size = layoutManager.f0(i);
            if (size == intValue.itemView) {
            } else {
            }
            if (size.getBottom() >= i9 && size.getTop() <= i13 && size.getRight() >= i7) {
            }
            i++;
            intValue = e0;
            if (size.getTop() <= i13) {
            }
            if (size.getRight() >= i7) {
            }
            if (size.getLeft() > i11) {
            } else {
            }
            itemView = obj.r.j0(size);
            if (obj.m.a(obj.r, obj.c, itemView)) {
            }
            int i20 = Math.abs(i5 - i18);
            int i24 = Math.abs(i15 - i27);
            i21 += i25;
            fVar = 0;
            view = 0;
            while (fVar < obj.u.size()) {
                if (i22 > (Integer)obj.v.get(fVar).intValue()) {
                }
                view++;
                fVar++;
                intValue = e0;
            }
            obj.u.add(view, itemView);
            obj.v.add(view, Integer.valueOf(i22));
            if (i22 > (Integer)obj.v.get(fVar).intValue()) {
            }
            view++;
            fVar++;
            intValue = e0;
        }
        return obj.u;
    }

    private androidx.recyclerview.widget.RecyclerView.e0 p(MotionEvent motionEvent) {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int cmp;
        int cmp2;
        layoutManager = this.r.getLayoutManager();
        int i = this.l;
        final int i3 = 0;
        if (i == -1) {
            return i3;
        }
        int pointerIndex = motionEvent.findPointerIndex(i);
        float f4 = Math.abs(f3 -= f5);
        float f2 = Math.abs(f -= f6);
        cmp = this.q;
        if (Float.compare(f4, f8) < 0 && Float.compare(f2, f7) < 0) {
            if (Float.compare(f2, f7) < 0) {
                return i3;
            }
        }
        if (Float.compare(f4, f2) > 0 && layoutManager.H()) {
            if (layoutManager.H()) {
                return i3;
            }
        }
        if (Float.compare(f2, f4) > 0 && layoutManager.I()) {
            if (layoutManager.I()) {
                return i3;
            }
        }
        View obj7 = n(motionEvent);
        if (obj7 == null) {
            return i3;
        }
        return this.r.j0(obj7);
    }

    private void q(float[] fArr) {
        int translationX;
        float translationY;
        float f;
        int i7 = 0;
        if (i &= 12 != 0) {
            fArr[i7] = i6 -= f;
        } else {
            fArr[i7] = view2.itemView.getTranslationX();
        }
        int i8 = 1;
        if (i3 &= 3 != 0) {
            fArr[i8] = i5 -= f;
        } else {
            fArr[i8] = view.itemView.getTranslationY();
        }
    }

    private static boolean s(View view, float f2, float f3, float f4, float f5) {
        int cmp;
        int obj1;
        float obj2;
        float obj4;
        float obj5;
        if (Float.compare(f2, f4) >= 0 && Float.compare(f2, obj4) <= 0 && Float.compare(f3, f5) >= 0 && Float.compare(f3, obj5) <= 0) {
            if (Float.compare(f2, obj4) <= 0) {
                if (Float.compare(f3, f5) >= 0) {
                    obj1 = Float.compare(f3, obj5) <= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void w() {
        VelocityTracker velocityTracker;
        velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void B(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        String str = "ItemTouchHelper";
        if (!this.m.p(this.r, e0)) {
            Log.e(str, "Start drag has been called but dragging is not enabled");
        }
        if (e0.itemView.getParent() != this.r) {
            Log.e(str, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        }
        u();
        int i = 0;
        this.i = i;
        this.h = i;
        z(e0, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void F(MotionEvent motionEvent, int i2, int i3) {
        int obj2;
        f -= obj4;
        this.h = i;
        this.i = obj2 -= obj4;
        int obj4 = 0;
        if (i2 & 4 == 0) {
            this.h = Math.max(obj4, i);
        }
        if (i2 & 8 == 0) {
            this.h = Math.min(obj4, this.h);
        }
        if (i2 & 1 == 0) {
            this.i = Math.max(obj4, this.i);
        }
        if (i2 & 2 == 0) {
            this.i = Math.min(obj4, this.i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void b(View view) {
        androidx.recyclerview.widget.RecyclerView.e0 remove;
        int itemView;
        int obj3;
        x(view);
        obj3 = this.r.j0(view);
        if (obj3 == null) {
        }
        remove = this.c;
        itemView = 0;
        if (remove != null && obj3 == remove) {
            if (obj3 == remove) {
                z(0, itemView);
            } else {
                l(obj3, itemView);
                if (this.a.remove(obj3.itemView)) {
                    this.m.c(this.r, obj3);
                }
            }
        } else {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void d(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void g(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView view;
        androidx.recyclerview.widget.RecyclerView obj2;
        view = this.r;
        if (view == recyclerView) {
        }
        if (view != null) {
            k();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            obj2 = recyclerView.getResources();
            this.f = obj2.getDimension(b.f);
            this.g = obj2.getDimension(b.e);
            A();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, androidx.recyclerview.widget.RecyclerView recyclerView3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void i(int i, MotionEvent motionEvent2, int i3) {
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int i5;
        int i4;
        int cmp4;
        int cmp;
        int i2;
        int cmp3;
        int cmp2;
        int obj9;
        MotionEvent obj10;
        int obj11;
        view = 2;
        if (this.c == null && i == view && this.n != view) {
            view = 2;
            if (i == view) {
                if (this.n != view) {
                    if (!this.m.r()) {
                    } else {
                        i5 = 1;
                        if (this.r.getScrollState() == i5) {
                        }
                        obj9 = p(motionEvent2);
                        if (obj9 == null) {
                        }
                        i7 >>= 8;
                        if (i4 == 0) {
                        }
                        f -= f2;
                        obj11 -= f3;
                        float f4 = Math.abs(cmp4);
                        float f5 = Math.abs(obj11);
                        cmp3 = this.q;
                        if (Float.compare(f4, f7) < 0 && Float.compare(f5, f6) < 0) {
                            if (Float.compare(f5, f6) < 0) {
                            }
                        }
                        i2 = 0;
                        if (Float.compare(f4, f5) > 0) {
                            if (Float.compare(cmp4, i2) < 0 && i4 & 4 == 0) {
                                if (i4 & 4 == 0) {
                                }
                            }
                            if (Float.compare(cmp4, i2) > 0 && i4 & 8 == 0) {
                                if (i4 & 8 == 0) {
                                }
                            }
                        } else {
                            if (Float.compare(obj11, i2) < 0 && i4 & 1 == 0) {
                                if (i4 & 1 == 0) {
                                }
                            }
                            if (Float.compare(obj11, i2) > 0 && i4 & 2 == 0) {
                                if (i4 & 2 == 0) {
                                }
                            }
                        }
                        this.i = i2;
                        this.h = i2;
                        this.l = motionEvent2.getPointerId(0);
                        z(obj9, i5);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void l(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
        int i;
        Object obj;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        size--;
        while (i >= 0) {
            obj = this.p.get(i);
            i--;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    androidx.recyclerview.widget.l.h m(MotionEvent motionEvent) {
        int i;
        Object obj;
        View itemView;
        final int i2 = 0;
        if (this.p.isEmpty()) {
            return i2;
        }
        size--;
        while (i >= 0) {
            obj = this.p.get(i);
            i--;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    View n(MotionEvent motionEvent) {
        Object itemView2;
        int i;
        boolean z;
        int itemView;
        float f;
        final float f2 = motionEvent.getX();
        float obj6 = motionEvent.getY();
        itemView2 = this.c;
        itemView2 = itemView2.itemView;
        if (itemView2 != null && l.s(itemView2, f2, obj6, f4 += f5, f6 += f)) {
            itemView2 = itemView2.itemView;
            if (l.s(itemView2, f2, obj6, f4 += f5, f6 += f)) {
                return itemView2;
            }
        }
        size--;
        while (i >= 0) {
            Object obj = this.p.get(i);
            itemView = view2.itemView;
            i--;
        }
        return this.r.T(f2, obj6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDraw(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        float i;
        int i2;
        float f2;
        float f;
        float obj12;
        this.y = -1;
        if (this.c != null) {
            q(this.b);
            obj12 = this.b;
            f = obj12;
            f2 = i;
        } else {
            f = f2;
        }
        this.m.x(canvas, recyclerView2, this.c, this.p, this.n, f2, f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        float i;
        int i2;
        float f2;
        float f;
        float obj12;
        if (this.c != null) {
            q(this.b);
            obj12 = this.b;
            f = obj12;
            f2 = i;
        } else {
            f = f2;
        }
        this.m.y(canvas, recyclerView2, this.c, this.p, this.n, f2, f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    boolean r() {
        int i;
        boolean z;
        final int i3 = 0;
        i = i3;
        while (i < this.p.size()) {
            i++;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void t(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        float cmp2;
        int cmp;
        int i;
        androidx.recyclerview.widget.RecyclerView view;
        androidx.recyclerview.widget.RecyclerView.e0 view2;
        if (this.r.isLayoutRequested()) {
        }
        if (this.n != 2) {
        }
        cmp2 = this.m.k(e0);
        final int i10 = (int)i4;
        final int i11 = (int)i5;
        if (Float.compare(f3, i) < 0 && Float.compare(cmp, i) < 0) {
            if (Float.compare(cmp, i) < 0) {
            }
        }
        List list = o(e0);
        if (list.size() == 0) {
        }
        final androidx.recyclerview.widget.RecyclerView.e0 view5 = this.m.b(e0, list, i10, i11);
        if (view5 == null) {
            this.u.clear();
            this.v.clear();
        }
        if (this.m.z(this.r, e0, view5)) {
            this.m.A(this.r, e0, e0.getAbsoluteAdapterPosition(), view5, view5.getAbsoluteAdapterPosition(), i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void u() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void v(androidx.recyclerview.widget.l.h l$h, int i2) {
        l.d dVar = new l.d(this, h, i2);
        this.r.post(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void x(View view) {
        Object view2;
        View obj2;
        obj2 = 0;
        this.x = obj2;
        if (view == this.x && this.w != null) {
            obj2 = 0;
            this.x = obj2;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(obj2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    boolean y() {
        boolean z;
        int i5;
        Rect rect;
        int cmp;
        int paddingBottom;
        int height2;
        int i2;
        int i3;
        float paddingRight;
        int height;
        int i;
        int i4;
        final Object obj = this;
        int i11 = 0;
        final long l = Long.MIN_VALUE;
        if (obj.c == null) {
            obj.D = l;
            return i11;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        long l2 = obj.D;
        i5 = Long.compare(l2, l) == 0 ? 0 : currentTimeMillis - l2;
        androidx.recyclerview.widget.RecyclerView.p layoutManager = obj.r.getLayoutManager();
        if (obj.C == null) {
            rect = new Rect();
            obj.C = rect;
        }
        layoutManager.G(view4.itemView, obj.C);
        paddingBottom = 0;
        if (layoutManager.H()) {
            cmp = (int)i13;
            i16 -= paddingLeft;
            paddingRight = obj.h;
            if (Float.compare(paddingRight, paddingBottom) < 0 && height2 < 0) {
                if (height2 < 0) {
                    i2 = height2;
                } else {
                    i15 -= height2;
                    if (Float.compare(paddingRight, paddingBottom) > 0 && cmp > 0) {
                        i15 -= height2;
                        i2 = cmp > 0 ? cmp : i11;
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (layoutManager.I()) {
            z = (int)i8;
            i12 -= paddingTop;
            height2 = obj.i;
            if (Float.compare(height2, paddingBottom) < 0 && cmp < 0) {
                if (cmp < 0) {
                    z = cmp;
                } else {
                    if (Float.compare(height2, paddingBottom) > 0 && i10 -= cmp > 0) {
                        if (i10 -= cmp > 0) {
                        } else {
                            z = i11;
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            i2 = obj.m.q(obj.r, view9.itemView.getWidth(), i2, obj.r.getWidth(), i5);
        }
        i4 = i2;
        if (z != 0) {
            i3 = i7;
            z = i5;
        } else {
            i3 = i4;
        }
        if (i3 == 0 && z != 0) {
            if (z != 0) {
            }
            obj.D = l;
            return i11;
        }
        if (Long.compare(l3, l) == 0) {
            obj.D = currentTimeMillis;
        }
        obj.r.scrollBy(i3, z);
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    void z(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
        androidx.recyclerview.widget.RecyclerView.e0 view;
        long itemView2;
        Object obj2;
        int parent;
        int itemView;
        Object layoutManager;
        Object obj;
        int i9;
        int i;
        int i11;
        float f;
        float f3;
        int i14;
        int i4;
        int i8;
        int i5;
        int view3;
        androidx.recyclerview.widget.RecyclerView.e0 i3;
        androidx.recyclerview.widget.l.c i12;
        int i6;
        int i10;
        int i7;
        float f4;
        float f2;
        int i13;
        androidx.recyclerview.widget.RecyclerView.e0 view2;
        final Object obj3 = this;
        final androidx.recyclerview.widget.RecyclerView.e0 view12 = e0;
        final int i28 = i2;
        if (view12 == obj3.c && i28 == obj3.n) {
            if (i28 == obj3.n) {
            }
        }
        obj3.D = Long.MIN_VALUE;
        final int i25 = obj3.n;
        i12 = 1;
        obj3.l(view12, i12);
        obj3.n = i28;
        i6 = 2;
        if (i28 == i6) {
            if (view12 == null) {
            } else {
                obj3.x = view12.itemView;
                f();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must pass a ViewHolder when dragging");
            throw illegalArgumentException;
        }
        i3 = 8;
        view3 = obj3.c;
        int i26 = 0;
        if (view3 != null) {
            if (view3.itemView.getParent() != null) {
                if (i25 == i6) {
                    i8 = i26;
                } else {
                    i8 = parent;
                }
                w();
                int i17 = 4;
                int i21 = 0;
                if (i8 != i12 && i8 != i6) {
                    if (i8 != i6) {
                        if (i8 != i17 && i8 != i3 && i8 != 16 && i8 != 32) {
                            if (i8 != i3) {
                                if (i8 != 16) {
                                    if (i8 != 32) {
                                        i7 = i10;
                                    } else {
                                        i7 = i21;
                                        i10 = i;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        i10 = i21;
                        i7 = i;
                    }
                } else {
                }
                i14 = i25 == i6 ? i3 : i8 > 0 ? i6 : i17;
                obj3.q(obj3.b);
                float[] fArr2 = obj3.b;
                f4 = fArr2[i26];
                f2 = fArr2[i12];
                i12 = cVar2;
                i13 = i3;
                super(this, view3, i14, i25, f4, f2, i10, i7, i8, view3);
                obj = obj3.r;
                i12.b(obj3.m.g(obj, i14, i10 - f4, i7 - f2));
                obj3.p.add(i12);
                i12.d();
                i5 = 1;
            } else {
                obj2 = view3;
                i13 = i3;
                obj3.x(obj2.itemView);
                obj3.m.c(obj3.r, obj2);
                i5 = 0;
            }
            obj3.c = 0;
        } else {
            i13 = i3;
            i5 = 0;
        }
        obj3.o = i19 >>= obj;
        obj3.j = (float)left;
        obj3.k = (float)top;
        obj3.c = view12;
        if (view12 != null && i28 == 2) {
            obj3.o = i19 >>= obj;
            obj3.j = (float)left;
            obj3.k = (float)top;
            obj3.c = view12;
            if (i28 == 2) {
                view12.itemView.performHapticFeedback(0);
            } else {
                i9 = 0;
            }
        } else {
        }
        layoutManager = obj3.r.getParent();
        if (layoutManager != null) {
            i12 = obj3.c != null ? 1 : i9;
            layoutManager.requestDisallowInterceptTouchEvent(i12);
        }
        if (i5 == 0) {
            obj3.r.getLayoutManager().P1();
        }
        obj3.m.B(obj3.c, obj3.n);
        obj3.r.invalidate();
    }
}
