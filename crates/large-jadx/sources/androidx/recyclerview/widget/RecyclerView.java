package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.i;
import androidx.core.widget.f;
import d.h.k.i;
import d.h.l.e0.b;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.j;
import d.h.l.k;
import d.h.l.l;
import d.h.l.u;
import d.h.l.v;
import d.j.a.a;
import d.r.a;
import d.r.b;
import d.r.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements k {

    private static final int[] U0;
    static final boolean V0 = true;
    static final boolean W0 = false;
    static final boolean X0 = false;
    static final boolean Y0 = false;
    private static final boolean Z0 = false;
    private static final boolean a1 = false;
    private static final Class<?>[] b1;
    static final Interpolator c1;
    final Rect A;
    final androidx.recyclerview.widget.RecyclerView.b0 A0;
    private final Rect B;
    private androidx.recyclerview.widget.RecyclerView.u B0;
    final RectF C;
    private List<androidx.recyclerview.widget.RecyclerView.u> C0;
    androidx.recyclerview.widget.RecyclerView.h D;
    boolean D0;
    androidx.recyclerview.widget.RecyclerView.p E;
    boolean E0;
    androidx.recyclerview.widget.RecyclerView.x F;
    private androidx.recyclerview.widget.RecyclerView.m.b F0;
    final List<androidx.recyclerview.widget.RecyclerView.x> G;
    boolean G0;
    final ArrayList<androidx.recyclerview.widget.RecyclerView.o> H;
    androidx.recyclerview.widget.v H0;
    private final ArrayList<androidx.recyclerview.widget.RecyclerView.t> I;
    private androidx.recyclerview.widget.RecyclerView.k I0;
    private androidx.recyclerview.widget.RecyclerView.t J;
    private final int[] J0;
    boolean K;
    private l K0;
    boolean L;
    private final int[] L0;
    boolean M;
    private final int[] M0;
    boolean N;
    final int[] N0;
    private int O;
    final List<androidx.recyclerview.widget.RecyclerView.e0> O0;
    boolean P;
    private Runnable P0;
    boolean Q;
    private boolean Q0;
    private boolean R;
    private int R0;
    private int S;
    private int S0;
    boolean T;
    private final androidx.recyclerview.widget.b0.b T0;
    private final AccessibilityManager U;
    private List<androidx.recyclerview.widget.RecyclerView.r> V;
    boolean W;
    private final androidx.recyclerview.widget.RecyclerView.y a;
    boolean a0;
    final androidx.recyclerview.widget.RecyclerView.w b;
    private int b0;
    androidx.recyclerview.widget.RecyclerView.z c;
    private int c0;
    private androidx.recyclerview.widget.RecyclerView.l d0;
    private EdgeEffect e0;
    private EdgeEffect f0;
    private EdgeEffect g0;
    private EdgeEffect h0;
    androidx.recyclerview.widget.RecyclerView.m i0;
    private int j0;
    private int k0;
    private VelocityTracker l0;
    private int m0;
    private int n0;
    private int o0;
    private int p0;
    private int q0;
    private androidx.recyclerview.widget.RecyclerView.s r0;
    private final int s0;
    private final int t0;
    private float u0;
    androidx.recyclerview.widget.a v;
    private float v0;
    androidx.recyclerview.widget.f w;
    private boolean w0;
    final androidx.recyclerview.widget.b0 x;
    final androidx.recyclerview.widget.RecyclerView.d0 x0;
    boolean y;
    androidx.recyclerview.widget.k y0;
    final Runnable z;
    androidx.recyclerview.widget.k.b z0;

    public static abstract class a0 {

        private androidx.recyclerview.widget.RecyclerView.p mLayoutManager;
        private boolean mPendingInitialRun;
        private androidx.recyclerview.widget.RecyclerView mRecyclerView;
        private final androidx.recyclerview.widget.RecyclerView.a0.a mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;
        public a0() {
            super();
            int i = -1;
            final int i2 = 0;
            RecyclerView.a0.a aVar = new RecyclerView.a0.a(i2, i2);
            this.mRecyclingAction = aVar;
        }

        public PointF computeScrollVectorForPosition(int i) {
            androidx.recyclerview.widget.RecyclerView.p layoutManager = getLayoutManager();
            if (layoutManager instanceof RecyclerView.a0.b) {
                return (RecyclerView.a0.b)layoutManager.d(i);
            }
            StringBuilder obj3 = new StringBuilder();
            obj3.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            obj3.append(RecyclerView.a0.b.class.getCanonicalName());
            Log.w("RecyclerView", obj3.toString());
            return null;
        }

        public View findViewByPosition(int i) {
            return mRecyclerView.E.Z(i);
        }

        public int getChildCount() {
            return mRecyclerView.E.g0();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.h0(view);
        }

        public androidx.recyclerview.widget.RecyclerView.p getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.q1(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        protected void normalize(PointF pointF) {
            float f = pointF.x;
            float f3 = pointF.y;
            f3 *= f3;
            float f2 = (float)sqrt;
            pointF.x = f4 /= f2;
            pointF.y = f5 /= f2;
        }

        void onAnimation(int i, int i2) {
            boolean scrollVectorForPosition;
            Object mRecyclingAction;
            boolean mRunning;
            int mRecyclingAction2;
            int mRecyclingAction3;
            int cmp;
            int cmp2;
            int obj7;
            int obj8;
            final androidx.recyclerview.widget.RecyclerView mRecyclerView = this.mRecyclerView;
            if (this.mTargetPosition != -1) {
                if (mRecyclerView == null) {
                    stop();
                }
            } else {
            }
            mRecyclingAction2 = 0;
            scrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition);
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && scrollVectorForPosition != null) {
                if (this.mTargetView == null) {
                    if (this.mLayoutManager != null) {
                        scrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition);
                        if (scrollVectorForPosition != null) {
                            mRecyclingAction3 = scrollVectorForPosition.x;
                            cmp = 0;
                            if (Float.compare(mRecyclingAction3, cmp) == 0) {
                                if (Float.compare(cmp2, cmp) != 0) {
                                    mRecyclerView.p1((int)signum2, (int)signum, mRecyclingAction2);
                                }
                            } else {
                            }
                        }
                    }
                }
            }
            this.mPendingInitialRun = false;
            mRecyclingAction = this.mTargetView;
            if (mRecyclingAction != null) {
                if (getChildPosition(mRecyclingAction) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, mRecyclerView.A0, this.mRecyclingAction);
                    this.mRecyclingAction.c(mRecyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = mRecyclingAction2;
                }
            }
            onSeekTargetStep(i, i2, mRecyclerView.A0, this.mRecyclingAction);
            this.mRecyclingAction.c(mRecyclerView);
            if (this.mRunning && this.mRecyclingAction.a() && this.mRunning) {
                onSeekTargetStep(i, i2, mRecyclerView.A0, this.mRecyclingAction);
                this.mRecyclingAction.c(mRecyclerView);
                if (this.mRecyclingAction.a()) {
                    if (this.mRunning) {
                        this.mPendingInitialRun = true;
                        mRecyclerView.x0.d();
                    }
                }
            }
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int i, int i2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a4);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a3);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        void start(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.p recyclerView$p2) {
            boolean mStarted;
            String str;
            recyclerView.x0.f();
            if (this.mStarted) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("An instance of ");
                stringBuilder.append(getClass().getSimpleName());
                stringBuilder.append(" was started more than once. Each instance of");
                stringBuilder.append(getClass().getSimpleName());
                stringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", stringBuilder.toString());
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = p2;
            int obj4 = this.mTargetPosition;
            if (obj4 == -1) {
            } else {
                obj3.a = obj4;
                int obj3 = 1;
                this.mRunning = obj3;
                this.mPendingInitialRun = obj3;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                obj4.x0.d();
                this.mStarted = obj3;
            }
            obj3 = new IllegalArgumentException("Invalid target position");
            throw obj3;
        }

        protected final void stop() {
            if (!this.mRunning) {
            }
            int i = 0;
            this.mRunning = i;
            onStop();
            final int i3 = -1;
            a0.a = i3;
            int i2 = 0;
            this.mTargetView = i2;
            this.mTargetPosition = i3;
            this.mPendingInitialRun = i;
            this.mLayoutManager.z1(this);
            this.mLayoutManager = i2;
            this.mRecyclerView = i2;
        }
    }

    class a implements Runnable {

        final androidx.recyclerview.widget.RecyclerView a;
        a(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.RecyclerView layoutRequested;
            boolean z;
            layoutRequested = this.a;
            if (layoutRequested.N) {
                if (layoutRequested.isLayoutRequested()) {
                } else {
                    layoutRequested = this.a;
                    if (!layoutRequested.K) {
                        layoutRequested.requestLayout();
                    }
                    if (layoutRequested.Q) {
                        layoutRequested.P = true;
                    }
                    layoutRequested.w();
                }
            }
        }
    }

    public static class b0 {

        int a = -1;
        private SparseArray<Object> b;
        int c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;
        int m;
        long n;
        int o;
        int p;
        int q;
        public b0() {
            super();
            int i = -1;
            int i2 = 0;
            final int i3 = 1;
        }

        void a(int i) {
            if (i2 &= i == 0) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Layout state should be one of ");
            stringBuilder.append(Integer.toBinaryString(i));
            stringBuilder.append(" but it is ");
            stringBuilder.append(Integer.toBinaryString(this.e));
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        public boolean b() {
            return this.g;
        }

        public int c() {
            int i;
            int i2;
            if (this.h) {
                i3 -= i2;
            } else {
                i = this.f;
            }
            return i;
        }

        public int d() {
            return this.a;
        }

        public boolean e() {
            int i;
            i = this.a != -1 ? 1 : 0;
            return i;
        }

        public boolean f() {
            return this.h;
        }

        void g(androidx.recyclerview.widget.RecyclerView.h recyclerView$h) {
            this.e = 1;
            this.f = h.getItemCount();
            int obj2 = 0;
            this.h = obj2;
            this.i = obj2;
            this.j = obj2;
        }

        public boolean h() {
            return this.l;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("State{mTargetPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mData=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mItemCount=");
            stringBuilder.append(this.f);
            stringBuilder.append(", mIsMeasuring=");
            stringBuilder.append(this.j);
            stringBuilder.append(", mPreviousLayoutItemCount=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mStructureChanged=");
            stringBuilder.append(this.g);
            stringBuilder.append(", mInPreLayout=");
            stringBuilder.append(this.h);
            stringBuilder.append(", mRunSimpleAnimations=");
            stringBuilder.append(this.k);
            stringBuilder.append(", mRunPredictiveAnimations=");
            stringBuilder.append(this.l);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    class b implements Runnable {

        final androidx.recyclerview.widget.RecyclerView a;
        b(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.RecyclerView.m view2 = view.i0;
            if (view2 != null) {
                view2.runPendingAnimations();
            }
            view3.G0 = false;
        }
    }

    public static abstract class c0 {
        public abstract View a(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2, int i3);
    }

    class c implements Interpolator {
        @Override // android.view.animation.Interpolator
        public float getInterpolation(float f) {
            final int i = 1065353216;
            f -= i;
            return i5 += i;
        }
    }

    class d0 implements Runnable {

        private int a;
        private int b;
        OverScroller c;
        Interpolator v;
        private boolean w = false;
        private boolean x = false;
        final androidx.recyclerview.widget.RecyclerView y;
        d0(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.y = recyclerView;
            super();
            final Interpolator interpolator = RecyclerView.c1;
            this.v = interpolator;
            int i = 0;
            OverScroller overScroller = new OverScroller(recyclerView.getContext(), interpolator);
            this.c = overScroller;
        }

        private int a(int i, int i2) {
            int i3;
            int height;
            int obj3;
            int obj4 = Math.abs(i2);
            i3 = Math.abs(i) > obj4 ? 1 : 0;
            androidx.recyclerview.widget.RecyclerView view = this.y;
            if (i3 != 0) {
                height = view.getWidth();
            } else {
                height = view.getHeight();
            }
            if (i3 != 0) {
            } else {
                obj3 = obj4;
            }
            return Math.min((int)obj3, 2000);
        }

        private void c() {
            this.y.removeCallbacks(this);
            u.d0(this.y, this);
        }

        @Override // java.lang.Runnable
        public void b(int i, int i2) {
            Object overScroller;
            Context context;
            this.y.setScrollState(2);
            int i3 = 0;
            this.b = i3;
            this.a = i3;
            Interpolator interpolator = RecyclerView.c1;
            if (this.v != interpolator) {
                this.v = interpolator;
                overScroller = new OverScroller(this.y.getContext(), interpolator);
                this.c = overScroller;
            }
            this.c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        @Override // java.lang.Runnable
        void d() {
            int z;
            if (this.w) {
                this.x = true;
            } else {
                c();
            }
        }

        @Override // java.lang.Runnable
        public void e(int i, int i2, int i3, Interpolator interpolator4) {
            int context;
            int obj7;
            int obj9;
            Interpolator obj10;
            if (i3 == Integer.MIN_VALUE) {
                obj9 = a(i, i2);
            }
            if (interpolator4 == null) {
                obj10 = RecyclerView.c1;
            }
            if (this.v != obj10) {
                this.v = obj10;
                obj9 = new OverScroller(this.y.getContext(), obj10);
                this.c = obj9;
            }
            obj9 = 0;
            this.b = obj9;
            this.a = obj9;
            this.y.setScrollState(2);
            this.c.startScroll(0, 0, i, i2, obj9);
            if (Build.VERSION.SDK_INT < 23) {
                this.c.computeScrollOffset();
            }
            d();
        }

        @Override // java.lang.Runnable
        public void f() {
            this.y.removeCallbacks(this);
            this.c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            androidx.recyclerview.widget.RecyclerView z2;
            boolean pendingInitialRun;
            boolean z3;
            int overScrollMode;
            Object view;
            boolean empty;
            boolean z;
            int i6;
            int i7;
            int i5;
            int currY;
            int i13;
            int i;
            int i14;
            int i8;
            int i9;
            int pendingInitialRun3;
            int i18;
            androidx.recyclerview.widget.RecyclerView.a0 pendingInitialRun2;
            boolean finished;
            int[] targetPosition;
            int i4;
            int i10;
            int i16;
            int i17;
            androidx.recyclerview.widget.RecyclerView view2;
            int i15;
            int i11;
            int i19;
            int i12;
            int i2;
            int i3;
            int[] iArr;
            final Object obj = this;
            androidx.recyclerview.widget.RecyclerView view3 = obj.y;
            if (view3.E == null) {
                f();
            }
            int i20 = 0;
            obj.x = i20;
            final int i21 = 1;
            obj.w = i21;
            view3.w();
            overScroller = obj.c;
            int currX = overScroller.getCurrX();
            currY = overScroller.getCurrY();
            i = currX - i22;
            i17 = currY - i23;
            obj.a = currX;
            obj.b = currY;
            androidx.recyclerview.widget.RecyclerView view18 = obj.y;
            targetPosition = view18.N0;
            targetPosition[i20] = i20;
            targetPosition[i21] = i20;
            if (overScroller.computeScrollOffset() && view18.H(i, i17, targetPosition, 0, 1)) {
                currX = overScroller.getCurrX();
                currY = overScroller.getCurrY();
                i = currX - i22;
                i17 = currY - i23;
                obj.a = currX;
                obj.b = currY;
                view18 = obj.y;
                targetPosition = view18.N0;
                targetPosition[i20] = i20;
                targetPosition[i21] = i20;
                if (view18.H(i, i17, targetPosition, 0, 1)) {
                    int[] n02 = view17.N0;
                    i -= currY;
                    i17 -= z3;
                }
                i5 = 2;
                if (obj.y.getOverScrollMode() != i5) {
                    obj.y.v(i, i17);
                }
                view = obj.y;
                if (view.D != null) {
                    int[] n03 = view.N0;
                    n03[i20] = i20;
                    n03[i21] = i20;
                    view.p1(i, i17, n03);
                    androidx.recyclerview.widget.RecyclerView view15 = obj.y;
                    int[] n04 = view15.N0;
                    i8 = n04[i20];
                    i14 = n04[i21];
                    i -= i8;
                    i17 -= i14;
                    view = view16.g;
                    if (view != null && !view.isPendingInitialRun() && view.isRunning()) {
                        if (!view.isPendingInitialRun()) {
                            if (view.isRunning()) {
                                pendingInitialRun3 = view22.A0.c();
                                if (pendingInitialRun3 == 0) {
                                    view.stop();
                                } else {
                                    if (view.getTargetPosition() >= pendingInitialRun3) {
                                        view.setTargetPosition(pendingInitialRun3 -= i21);
                                        view.onAnimation(i8, i14);
                                    } else {
                                        view.onAnimation(i8, i14);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    i8 = i14;
                }
                if (!view11.H.isEmpty()) {
                    obj.y.invalidate();
                }
                view2 = obj.y;
                int[] n0 = view2.N0;
                n0[i20] = i20;
                n0[i21] = i20;
                view2.I(i8, i14, i, i17, 0, 1, n0);
                androidx.recyclerview.widget.RecyclerView view12 = obj.y;
                int[] n05 = view12.N0;
                i -= i26;
                i17 -= i25;
                if (i8 == 0) {
                    if (i14 != 0) {
                        view12.K(i8, i14);
                    }
                } else {
                }
                if (!RecyclerView.e(obj.y)) {
                    obj.y.invalidate();
                }
                i6 = overScroller.getCurrX() == overScroller.getFinalX() ? i21 : i20;
                i18 = overScroller.getCurrY() == overScroller.getFinalY() ? i21 : i20;
                if (!overScroller.isFinished()) {
                    if (i6 == 0) {
                        if (i13 != 0) {
                            if (i18 == 0) {
                                if (i16 != 0) {
                                    i7 = i21;
                                } else {
                                    i7 = i20;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                pendingInitialRun2 = view21.g;
                if (pendingInitialRun2 != null && pendingInitialRun2.isPendingInitialRun()) {
                    i9 = pendingInitialRun2.isPendingInitialRun() ? i21 : i20;
                } else {
                }
                if (i9 == 0 && i7 != 0) {
                    if (i7 != 0) {
                        if (obj.y.getOverScrollMode() != i5) {
                            overScroller = (int)currVelocity;
                            pendingInitialRun = i13 < 0 ? -overScroller : i13 > 0 ? overScroller : i20;
                            if (i16 < 0) {
                                overScroller = -overScroller;
                            } else {
                                if (i16 > 0) {
                                } else {
                                    overScroller = i20;
                                }
                            }
                            obj.y.a(pendingInitialRun, overScroller);
                        }
                        if (RecyclerView.Y0) {
                            view8.z0.b();
                        }
                    } else {
                        d();
                        overScroller = obj.y;
                        pendingInitialRun = overScroller.y0;
                        if (pendingInitialRun != null) {
                            pendingInitialRun.f(overScroller, i8, i14);
                        }
                    }
                } else {
                }
            }
            androidx.recyclerview.widget.RecyclerView.a0 view6 = view5.g;
            if (view6 != null && view6.isPendingInitialRun()) {
                if (view6.isPendingInitialRun()) {
                    view6.onAnimation(i20, i20);
                }
            }
            obj.w = i20;
            if (obj.x) {
                c();
            } else {
                obj.y.setScrollState(i20);
                obj.y.C1(i21);
            }
        }
    }

    public static abstract class e0 {

        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = null;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        androidx.recyclerview.widget.RecyclerView.h<? extends androidx.recyclerview.widget.RecyclerView.e0> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<androidx.recyclerview.widget.RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        androidx.recyclerview.widget.RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        androidx.recyclerview.widget.RecyclerView.w mScrapContainer = null;
        androidx.recyclerview.widget.RecyclerView.e0 mShadowedHolder = null;
        androidx.recyclerview.widget.RecyclerView.e0 mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        static {
            RecyclerView.e0.FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public e0(View view) {
            super();
            int i = -1;
            int i2 = -1;
            int i3 = 0;
            final int i4 = 0;
            if (view == null) {
            } else {
                this.itemView = view;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("itemView may not be null");
            throw obj4;
        }

        private void createPayloadsIfNeeded() {
            List unmodifiableList;
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object object) {
            int mPayloads;
            int mFlags;
            mPayloads = 1024;
            if (object == null) {
                addFlags(mPayloads);
            } else {
                if (mPayloads &= mFlags == 0) {
                    createPayloadsIfNeeded();
                    this.mPayloads.add(object);
                }
            }
        }

        void addFlags(int i) {
            this.mFlags = i |= mFlags;
        }

        void clearOldPosition() {
            final int i = -1;
            this.mOldPosition = i;
            this.mPreLayoutPosition = i;
        }

        void clearPayload() {
            List mPayloads = this.mPayloads;
            if (mPayloads != null) {
                mPayloads.clear();
            }
            this.mFlags = mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags = mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags = mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            int i;
            int i2;
            if (mFlags &= 16 == 0 && u.O(this.itemView)) {
                i2 = u.O(this.itemView) ? 1 : 0;
            } else {
            }
            return i2;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z3) {
            addFlags(8);
            offsetPosition(i2, z3);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            androidx.recyclerview.widget.RecyclerView mOwnerRecyclerView = this.mOwnerRecyclerView;
            if (mOwnerRecyclerView == null) {
                return -1;
            }
            return mOwnerRecyclerView.e0(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final androidx.recyclerview.widget.RecyclerView.h<? extends androidx.recyclerview.widget.RecyclerView.e0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            int i = -1;
            if (this.mBindingAdapter == null) {
                return i;
            }
            androidx.recyclerview.widget.RecyclerView mOwnerRecyclerView = this.mOwnerRecyclerView;
            if (mOwnerRecyclerView == null) {
                return i;
            }
            androidx.recyclerview.widget.RecyclerView.h adapter = mOwnerRecyclerView.getAdapter();
            if (adapter == null) {
                return i;
            }
            int i2 = this.mOwnerRecyclerView.e0(this);
            if (i2 == i) {
                return i;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, i2);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int mPreLayoutPosition;
            if (this.mPreLayoutPosition == -1) {
                mPreLayoutPosition = this.mPosition;
            }
            return mPreLayoutPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int mPreLayoutPosition;
            if (this.mPreLayoutPosition == -1) {
                mPreLayoutPosition = this.mPosition;
            }
            return mPreLayoutPosition;
        }

        List<Object> getUnmodifiedPayloads() {
            List mPayloads;
            mPayloads = this.mPayloads;
            if (mFlags &= 1024 == 0 && mPayloads != null && mPayloads.size() == 0) {
                mPayloads = this.mPayloads;
                if (mPayloads != null) {
                    if (mPayloads.size() == 0) {
                    }
                    return this.mUnmodifiedPayloads;
                }
                return RecyclerView.e0.FULLUPDATE_PAYLOADS;
            }
            return RecyclerView.e0.FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int i) {
            int obj2;
            obj2 = i &= mFlags != 0 ? 1 : 0;
            return obj2;
        }

        boolean isAdapterPositionUnknown() {
            int i;
            int invalid;
            if (mFlags &= 512 == 0) {
                if (isInvalid()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        boolean isAttachedToTransitionOverlay() {
            ViewParent parent;
            int i;
            androidx.recyclerview.widget.RecyclerView mOwnerRecyclerView;
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                i = this.itemView.getParent() != this.mOwnerRecyclerView ? 1 : 0;
            } else {
            }
            return i;
        }

        boolean isBound() {
            int i;
            if (mFlags &= i != 0) {
            } else {
                i = 0;
            }
            return i;
        }

        boolean isInvalid() {
            int i;
            i = mFlags &= 4 != 0 ? 1 : 0;
            return i;
        }

        public final boolean isRecyclable() {
            int i;
            int i2;
            if (mFlags &= 16 == 0 && !u.O(this.itemView)) {
                i2 = !u.O(this.itemView) ? 1 : 0;
            } else {
            }
            return i2;
        }

        boolean isRemoved() {
            int i;
            i = mFlags &= 8 != 0 ? 1 : 0;
            return i;
        }

        boolean isScrap() {
            int i;
            i = this.mScrapContainer != null ? 1 : 0;
            return i;
        }

        boolean isTmpDetached() {
            int i;
            i = mFlags &= 256 != 0 ? 1 : 0;
            return i;
        }

        boolean isUpdated() {
            int i;
            i = mFlags &= 2 != 0 ? 1 : 0;
            return i;
        }

        boolean needsUpdate() {
            int i;
            i = mFlags &= 2 != 0 ? 1 : 0;
            return i;
        }

        void offsetPosition(int i, boolean z2) {
            int mOldPosition;
            int mPreLayoutPosition;
            ViewGroup.LayoutParams obj3;
            int obj4;
            final int i2 = -1;
            if (this.mOldPosition == i2) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == i2) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z2 != 0) {
                this.mPreLayoutPosition = obj4 += i;
            }
            this.mPosition = obj4 += i;
            if (this.itemView.getLayoutParams() != null) {
                obj3.c = true;
            }
        }

        void onEnteredHiddenState(androidx.recyclerview.widget.RecyclerView recyclerView) {
            int mPendingAccessibilityState;
            mPendingAccessibilityState = this.mPendingAccessibilityState;
            if (mPendingAccessibilityState != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = mPendingAccessibilityState;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = u.z(this.itemView);
            }
            recyclerView.s1(this, 4);
        }

        void onLeftHiddenState(androidx.recyclerview.widget.RecyclerView recyclerView) {
            recyclerView.s1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            final int i = 0;
            this.mFlags = i;
            final int i2 = -1;
            this.mPosition = i2;
            this.mOldPosition = i2;
            this.mItemId = -1;
            this.mPreLayoutPosition = i2;
            this.mIsRecyclableCount = i;
            int i4 = 0;
            this.mShadowedHolder = i4;
            this.mShadowingHolder = i4;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = i;
            this.mPendingAccessibilityState = i2;
            RecyclerView.s(this);
        }

        void saveOldPosition() {
            int mOldPosition;
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i, int i2) {
            this.mFlags = obj3 |= i3;
        }

        public final void setIsRecyclable(boolean z) {
            int str;
            int i;
            int obj3;
            str = 1;
            int mIsRecyclableCount = this.mIsRecyclableCount;
            i = z != 0 ? mIsRecyclableCount - str : mIsRecyclableCount + str;
            this.mIsRecyclableCount = i;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                obj3 = new StringBuilder();
                obj3.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                obj3.append(this);
                Log.e("View", obj3.toString());
            } else {
                if (z == 0 && i == str) {
                    if (i == str) {
                        this.mFlags = obj3 |= 16;
                    } else {
                        if (z != 0 && i == 0) {
                            if (i == 0) {
                                this.mFlags = obj3 &= -17;
                            }
                        }
                    }
                } else {
                }
            }
        }

        void setScrapContainer(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, boolean z2) {
            this.mScrapContainer = w;
            this.mInChangeScrap = z2;
        }

        boolean shouldBeKeptAsChild() {
            int i;
            i = mFlags &= 16 != 0 ? 1 : 0;
            return i;
        }

        boolean shouldIgnore() {
            int i;
            i = mFlags &= 128 != 0 ? 1 : 0;
            return i;
        }

        void stopIgnoring() {
            this.mFlags = mFlags &= -129;
        }

        public String toString() {
            String simpleName;
            String scrap;
            boolean invalid;
            boolean bound;
            boolean needsUpdate;
            boolean removed;
            boolean ignore;
            boolean tmpDetached;
            boolean recyclable;
            boolean adapterPositionUnknown;
            Object parent;
            Object stringBuilder;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append("{");
            stringBuilder.append(Integer.toHexString(hashCode()));
            stringBuilder.append(" position=");
            stringBuilder.append(this.mPosition);
            stringBuilder.append(" id=");
            stringBuilder.append(this.mItemId);
            stringBuilder.append(", oldPos=");
            stringBuilder.append(this.mOldPosition);
            stringBuilder.append(", pLpos:");
            stringBuilder.append(this.mPreLayoutPosition);
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder.toString());
            if (isScrap()) {
                stringBuilder3.append(" scrap ");
                scrap = this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]";
                stringBuilder3.append(scrap);
            }
            if (isInvalid()) {
                stringBuilder3.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder3.append(" unbound");
            }
            if (needsUpdate()) {
                stringBuilder3.append(" update");
            }
            if (isRemoved()) {
                stringBuilder3.append(" removed");
            }
            if (shouldIgnore()) {
                stringBuilder3.append(" ignored");
            }
            if (isTmpDetached()) {
                stringBuilder3.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(" not recyclable(");
                stringBuilder2.append(this.mIsRecyclableCount);
                stringBuilder2.append(")");
                stringBuilder3.append(stringBuilder2.toString());
            }
            if (isAdapterPositionUnknown()) {
                stringBuilder3.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                stringBuilder3.append(" no parent");
            }
            stringBuilder3.append("}");
            return stringBuilder3.toString();
        }

        void unScrap() {
            this.mScrapContainer.J(this);
        }

        boolean wasReturnedFromScrap() {
            int i;
            i = mFlags &= 32 != 0 ? 1 : 0;
            return i;
        }
    }

    static class g {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            RecyclerView.g.a = iArr;
            iArr[RecyclerView.h.a.PREVENT.ordinal()] = 1;
            RecyclerView.g.a[RecyclerView.h.a.PREVENT_WHEN_EMPTY.ordinal()] = 2;
        }
    }

    public static abstract class h {

        private boolean mHasStableIds = false;
        private final androidx.recyclerview.widget.RecyclerView.i mObservable;
        private androidx.recyclerview.widget.RecyclerView.h.a mStateRestorationPolicy = null;
        public h() {
            super();
            RecyclerView.i iVar = new RecyclerView.i();
            this.mObservable = iVar;
            int i = 0;
            androidx.recyclerview.widget.RecyclerView.h.a aLLOW = RecyclerView.h.a.ALLOW;
        }

        public final void bindViewHolder(VH vh, int i2) {
            int i;
            String str;
            boolean stableIds;
            Object obj5;
            int obj6;
            final int i3 = 1;
            i = vh.mBindingAdapter == null ? i3 : 0;
            vh.mPosition = i2;
            if (i != 0 && hasStableIds()) {
                vh.mPosition = i2;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i2);
                }
                vh.setFlags(i3, 519);
                i.a("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            obj5 = vh.itemView.getLayoutParams();
            if (i != 0 && obj5 instanceof RecyclerView.q) {
                vh.clearPayload();
                obj5 = vh.itemView.getLayoutParams();
                if (obj5 instanceof RecyclerView.q) {
                    obj5.c = i3;
                }
                i.b();
            }
        }

        boolean canRestoreState() {
            int itemCount;
            int i2;
            int i;
            itemCount = RecyclerView.g.a[this.mStateRestorationPolicy.ordinal()];
            i2 = 0;
            final int i3 = 1;
            if (itemCount != i3 && itemCount != 2) {
                if (itemCount != 2) {
                    return i3;
                }
                if (getItemCount() > 0) {
                    i2 = i3;
                }
            }
            return i2;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                i.a("RV CreateView");
                androidx.recyclerview.widget.RecyclerView.e0 obj2 = onCreateViewHolder(viewGroup, i2);
                if (obj2.itemView.getParent() != null) {
                } else {
                }
                obj2.mItemViewType = i2;
                i.b();
                return obj2;
                obj2 = new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                throw obj2;
                i.b();
                throw viewGroup;
            }
        }

        public int findRelativeAdapterPositionIn(androidx.recyclerview.widget.RecyclerView.h<? extends androidx.recyclerview.widget.RecyclerView.e0> recyclerView$h, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3) {
            if (h == this) {
                return i3;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final androidx.recyclerview.widget.RecyclerView.h.a getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.d(i, 1);
        }

        public final void notifyItemChanged(int i, Object object2) {
            this.mObservable.e(i, 1, object2);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.f(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.d(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object object3) {
            this.mObservable.e(i, i2, object3);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.f(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.g(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.g(i, 1);
        }

        public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list3) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return 0;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.j recyclerView$j) {
            this.mObservable.registerObserver(j);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
            } else {
                this.mHasStableIds = z;
            }
            IllegalStateException obj2 = new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            throw obj2;
        }

        public void setStateRestorationPolicy(androidx.recyclerview.widget.RecyclerView.h.a recyclerView$h$a) {
            this.mStateRestorationPolicy = a;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.j recyclerView$j) {
            this.mObservable.unregisterObserver(j);
        }
    }

    static class i extends Observable<androidx.recyclerview.widget.RecyclerView.j> {
        @Override // android.database.Observable
        public boolean a() {
            return empty ^= 1;
        }

        @Override // android.database.Observable
        public void b() {
            int i;
            Object obj;
            size--;
            while (i >= 0) {
                (RecyclerView.j)this.mObservers.get(i).onChanged();
                i--;
            }
        }

        @Override // android.database.Observable
        public void c(int i, int i2) {
            int i3;
            Object obj;
            final int i4 = 1;
            size -= i4;
            while (i3 >= 0) {
                (RecyclerView.j)this.mObservers.get(i3).onItemRangeMoved(i, i2, i4);
                i3--;
            }
        }

        @Override // android.database.Observable
        public void d(int i, int i2) {
            e(i, i2, 0);
        }

        @Override // android.database.Observable
        public void e(int i, int i2, Object object3) {
            int i3;
            Object obj;
            size--;
            while (i3 >= 0) {
                (RecyclerView.j)this.mObservers.get(i3).onItemRangeChanged(i, i2, object3);
                i3--;
            }
        }

        @Override // android.database.Observable
        public void f(int i, int i2) {
            int i3;
            Object obj;
            size--;
            while (i3 >= 0) {
                (RecyclerView.j)this.mObservers.get(i3).onItemRangeInserted(i, i2);
                i3--;
            }
        }

        @Override // android.database.Observable
        public void g(int i, int i2) {
            int i3;
            Object obj;
            size--;
            while (i3 >= 0) {
                (RecyclerView.j)this.mObservers.get(i3).onItemRangeRemoved(i, i2);
                i3--;
            }
        }

        @Override // android.database.Observable
        public void h() {
            int i;
            Object obj;
            size--;
            while (i >= 0) {
                (RecyclerView.j)this.mObservers.get(i).onStateRestorationPolicyChanged();
                i--;
            }
        }
    }

    public static abstract class j {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object object3) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    public interface k {
        public abstract int a(int i, int i2);
    }

    public static class l {
        protected EdgeEffect a(androidx.recyclerview.widget.RecyclerView recyclerView, int i2) {
            EdgeEffect obj2 = new EdgeEffect(recyclerView.getContext());
            return obj2;
        }
    }

    public static abstract class m {

        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<androidx.recyclerview.widget.RecyclerView.m.a> mFinishedListeners;
        private androidx.recyclerview.widget.RecyclerView.m.b mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;
        public m() {
            super();
            int i = 0;
            ArrayList arrayList = new ArrayList();
            this.mFinishedListeners = arrayList;
            int i2 = 120;
            int i3 = 250;
        }

        static int buildAdapterChangeFlagsForAnimations(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            int i;
            int oldPosition;
            int i2;
            Object obj3;
            mFlags &= 14;
            if (e0.isInvalid()) {
                return 4;
            }
            oldPosition = e0.getOldPosition();
            obj3 = e0.getAbsoluteAdapterPosition();
            i2 = -1;
            if (i & 4 == 0 && oldPosition != i2 && obj3 != i2 && oldPosition != obj3) {
                oldPosition = e0.getOldPosition();
                obj3 = e0.getAbsoluteAdapterPosition();
                i2 = -1;
                if (oldPosition != i2) {
                    if (obj3 != i2) {
                        if (oldPosition != obj3) {
                            i |= 2048;
                        }
                    }
                }
            }
            return i;
        }

        public abstract boolean animateAppearance(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);

        public abstract boolean animateChange(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c4);

        public abstract boolean animateDisappearance(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);

        public abstract boolean animatePersistence(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);

        public abstract boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);

        public boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, List<Object> list2) {
            return canReuseUpdatedViewHolder(e0);
        }

        public final void dispatchAnimationFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            onAnimationFinished(e0);
            final androidx.recyclerview.widget.RecyclerView.m.b mListener = this.mListener;
            if (mListener != null) {
                mListener.a(e0);
            }
        }

        public final void dispatchAnimationStarted(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            onAnimationStarted(e0);
        }

        public final void dispatchAnimationsFinished() {
            int i;
            Object obj;
            i = 0;
            while (i < this.mFinishedListeners.size()) {
                (RecyclerView.m.a)this.mFinishedListeners.get(i).a();
                i++;
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(androidx.recyclerview.widget.RecyclerView.m.a recyclerView$m$a) {
            ArrayList mFinishedListeners;
            final boolean running = isRunning();
            if (a != null) {
                if (!running) {
                    a.a();
                } else {
                    this.mFinishedListeners.add(a);
                }
            }
            return running;
        }

        public androidx.recyclerview.widget.RecyclerView.m.c obtainHolderInfo() {
            RecyclerView.m.c cVar = new RecyclerView.m.c();
            return cVar;
        }

        public void onAnimationFinished(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        }

        public void onAnimationStarted(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        }

        public androidx.recyclerview.widget.RecyclerView.m.c recordPostLayoutInformation(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            final androidx.recyclerview.widget.RecyclerView.m.c obj1 = obtainHolderInfo();
            obj1.a(e02);
            return obj1;
        }

        public androidx.recyclerview.widget.RecyclerView.m.c recordPreLayoutInformation(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, List<Object> list4) {
            final androidx.recyclerview.widget.RecyclerView.m.c obj1 = obtainHolderInfo();
            obj1.a(e02);
            return obj1;
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long l) {
            this.mAddDuration = l;
        }

        public void setChangeDuration(long l) {
            this.mChangeDuration = l;
        }

        void setListener(androidx.recyclerview.widget.RecyclerView.m.b recyclerView$m$b) {
            this.mListener = b;
        }

        public void setMoveDuration(long l) {
            this.mMoveDuration = l;
        }

        public void setRemoveDuration(long l) {
            this.mRemoveDuration = l;
        }
    }

    public static abstract class o {
        @Deprecated
        public void getItemOffsets(Rect rect, int i2, androidx.recyclerview.widget.RecyclerView recyclerView3) {
            final int obj2 = 0;
            rect.set(obj2, obj2, obj2, obj2);
        }

        public void getItemOffsets(Rect rect, View view2, androidx.recyclerview.widget.RecyclerView recyclerView3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
            getItemOffsets(rect, (RecyclerView.q)view2.getLayoutParams().a(), recyclerView3);
        }

        @Deprecated
        public void onDraw(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2) {
        }

        public void onDraw(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
            onDraw(canvas, recyclerView2);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2) {
        }

        public void onDrawOver(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
            onDrawOver(canvas, recyclerView2);
        }
    }

    public static abstract class p {

        androidx.recyclerview.widget.f a;
        androidx.recyclerview.widget.RecyclerView b;
        private final androidx.recyclerview.widget.a0.b c;
        private final androidx.recyclerview.widget.a0.b d;
        androidx.recyclerview.widget.a0 e;
        androidx.recyclerview.widget.a0 f;
        androidx.recyclerview.widget.RecyclerView.a0 g;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;
        public p() {
            super();
            RecyclerView.p.a aVar = new RecyclerView.p.a(this);
            this.c = aVar;
            RecyclerView.p.b bVar = new RecyclerView.p.b(this);
            this.d = bVar;
            a0 a0Var2 = new a0(aVar);
            this.e = a0Var2;
            a0 a0Var = new a0(bVar);
            this.f = a0Var;
            int i = 0;
            int i2 = 1;
        }

        public static androidx.recyclerview.widget.RecyclerView.p.d B0(Context context, AttributeSet attributeSet2, int i3, int i4) {
            RecyclerView.p.d dVar = new RecyclerView.p.d();
            final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, d.a, i3, i4);
            int obj4 = 1;
            dVar.a = obj2.getInt(d.b, obj4);
            dVar.b = obj2.getInt(d.l, obj4);
            obj4 = 0;
            dVar.c = obj2.getBoolean(d.k, obj4);
            dVar.d = obj2.getBoolean(d.m, obj4);
            obj2.recycle();
            return dVar;
        }

        private void C(View view, int i2, boolean z3) {
            int i;
            boolean returnedFromScrap;
            int layoutParams;
            Object obj5;
            int obj6;
            boolean obj7;
            androidx.recyclerview.widget.RecyclerView.e0 view2 = RecyclerView.k0(view);
            if (!z3) {
                if (view2.isRemoved()) {
                    obj7.x.b(view2);
                } else {
                    obj7.x.p(view2);
                }
            } else {
            }
            obj7 = view.getLayoutParams();
            final int i3 = 0;
            if (!view2.wasReturnedFromScrap()) {
                if (view2.isScrap()) {
                    if (view2.isScrap()) {
                        view2.unScrap();
                    } else {
                        view2.clearReturnedFromScrapFlag();
                    }
                    this.a.c(view, i2, view.getLayoutParams(), i3);
                } else {
                    i = this.a.m(view);
                    layoutParams = -1;
                    if (view.getParent() == this.b && i2 == layoutParams) {
                        i = this.a.m(view);
                        layoutParams = -1;
                        if (i2 == layoutParams) {
                            obj6 = this.a.g();
                        }
                        if (i == layoutParams) {
                        } else {
                            if (i != obj6) {
                                obj5.E.V0(i, obj6);
                            }
                        }
                        obj7 = new StringBuilder();
                        obj7.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        obj7.append(this.b.indexOfChild(view));
                        obj7.append(this.b.R());
                        obj6 = new IllegalStateException(obj7.toString());
                        throw obj6;
                    }
                    this.a.a(view, i2, i3);
                    obj7.c = true;
                    obj6 = this.g;
                    if (obj6 != null && obj6.isRunning()) {
                        if (obj6.isRunning()) {
                            this.g.onChildAttachedToWindow(view);
                        }
                    }
                }
            } else {
            }
            if (obj7.v) {
                view2.itemView.invalidate();
                obj7.v = i3;
            }
        }

        public static int K(int i, int i2, int i3) {
            int obj2;
            final int mode = View.MeasureSpec.getMode(i);
            if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                if (mode != 1073741824) {
                    obj2 = Math.max(i2, i3);
                }
                return obj2;
            }
            return Math.min(View.MeasureSpec.getSize(i), Math.max(i2, i3));
        }

        private boolean M0(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
            int obj7;
            obj7 = recyclerView.getFocusedChild();
            final int i = 0;
            if (obj7 == null) {
                return i;
            }
            Rect rect = view.A;
            m0(obj7, rect);
            if (obj7 -= i2 < i6 -= i8 && obj7 -= i2 > v() && obj7 -= i3 < i9 -= i11 && obj7 -= i3 <= u()) {
                if (obj7 -= i2 > v()) {
                    if (obj7 -= i3 < i9 -= i11) {
                        if (obj7 -= i3 <= u()) {
                        }
                        return 1;
                    }
                }
            }
            return i;
        }

        private static boolean Q0(int i, int i2, int i3) {
            int i4;
            final int mode = View.MeasureSpec.getMode(i2);
            final int obj4 = View.MeasureSpec.getSize(i2);
            i4 = 0;
            if (i3 > 0 && i != i3) {
                if (i != i3) {
                    return i4;
                }
            }
            final int i5 = 1;
            if (mode != Integer.MIN_VALUE && mode != 0 && mode != 1073741824) {
                if (mode != 0) {
                    if (mode != 1073741824) {
                        return i4;
                    }
                    if (obj4 == i) {
                        i4 = i5;
                    }
                    return i4;
                }
                return i5;
            }
            if (obj4 >= i) {
                i4 = i5;
            }
            return i4;
        }

        private void Q1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2, View view3) {
            boolean stableIds;
            androidx.recyclerview.widget.b0 obj3;
            final androidx.recyclerview.widget.RecyclerView.e0 view = RecyclerView.k0(view3);
            if (view.shouldIgnore()) {
            }
            if (view.isInvalid() && !view.isRemoved() && !view2.D.hasStableIds()) {
                if (!view.isRemoved()) {
                    if (!view2.D.hasStableIds()) {
                        L1(i2);
                        w.C(view);
                    } else {
                        U(i2);
                        w.D(view3);
                        obj3.x.k(view);
                    }
                } else {
                }
            } else {
            }
        }

        private void V(int i, View view2) {
            this.a.d(i);
        }

        public static int h0(int i, int i2, int i3, int i4, boolean z5) {
            int obj5;
            int obj7;
            final int obj6 = 0;
            int obj4 = Math.max(obj6, i -= i3);
            final int i6 = -1;
            final int i7 = Integer.MIN_VALUE;
            final int i8 = 1073741824;
            if (z5) {
                if (i4 >= 0) {
                    obj5 = i8;
                } else {
                    if (i4 == i6) {
                        if (i2 != i7) {
                            if (i2 != 0) {
                                if (i2 != i8) {
                                    obj7 = obj5;
                                } else {
                                    obj7 = obj4;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
                if (i4 >= 0) {
                } else {
                    if (i4 == i6) {
                    } else {
                        if (i4 == -2) {
                            if (i2 != i7) {
                                if (i2 == i8) {
                                    obj7 = obj4;
                                    obj5 = i7;
                                } else {
                                    obj7 = obj4;
                                    obj5 = obj6;
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(obj7, obj5);
        }

        private int[] i0(View view, Rect rect2) {
            int i2;
            int i3;
            int i;
            int[] iArr = new int[2];
            i15 -= scrollX;
            i18 -= obj10;
            i16 -= i5;
            int i6 = 0;
            i = Math.min(i6, i17);
            i19 -= i7;
            obj10 -= i9;
            i3 = Math.max(i6, obj10);
            final int i21 = 1;
            if (w0() == i21) {
                if (i3 != 0) {
                } else {
                    i3 = Math.max(i, obj10);
                }
            } else {
                if (i != 0) {
                } else {
                    i = Math.min(i17, i3);
                }
                i3 = i;
            }
            if (Math.min(i6, i20) != 0) {
            } else {
                i2 = Math.min(i20, Math.max(i6, obj11 -= i12));
            }
            iArr[i6] = i3;
            iArr[i21] = i2;
            return iArr;
        }

        public void A(View view) {
            B(view, -1);
        }

        public int A0(View view) {
            return (RecyclerView.q)view.getLayoutParams().a();
        }

        boolean A1(int i, Bundle bundle2) {
            androidx.recyclerview.widget.RecyclerView view = this.b;
            return B1(view.b, view.A0, i, bundle2);
        }

        public void B(View view, int i2) {
            C(view, i2, false);
        }

        public boolean B1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3, Bundle bundle4) {
            int i;
            int i2;
            int obj8;
            int obj10;
            int obj11;
            obj8 = this.b;
            final int obj9 = 0;
            if (obj8 == null) {
                return obj9;
            }
            final int i4 = 1;
            if (i3 != 4096) {
                if (i3 != 8192) {
                    i2 = i;
                } else {
                    obj10 = -1;
                    if (obj8.canScrollVertically(obj10)) {
                        obj8 = -obj8;
                    } else {
                        obj8 = obj9;
                    }
                    if (this.b.canScrollHorizontally(obj10)) {
                        obj10 = -obj10;
                        i2 = obj8;
                        i = obj10;
                    } else {
                        i2 = obj8;
                        i = obj9;
                    }
                }
            } else {
                if (obj8.canScrollVertically(i4)) {
                    obj8 -= obj10;
                } else {
                    obj8 = obj9;
                }
                if (this.b.canScrollHorizontally(i4)) {
                    obj10 -= obj11;
                } else {
                }
            }
            if (i2 == 0 && i == 0) {
                if (i == 0) {
                    return obj9;
                }
            }
            this.b.x1(i, i2, 0, Integer.MIN_VALUE, true);
            return i4;
        }

        public int C0(View view) {
            return obj1.right;
        }

        boolean C1(View view, int i2, Bundle bundle3) {
            final androidx.recyclerview.widget.RecyclerView view2 = this.b;
            return this.D1(view2.b, view2.A0, view, i2, bundle3);
        }

        public void D(String string) {
            final androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                view.p(string);
            }
        }

        public int D0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            return -1;
        }

        public boolean D1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, View view3, int i4, Bundle bundle5) {
            return 0;
        }

        public void E(View view, int i2) {
            F(view, i2, (RecyclerView.q)view.getLayoutParams());
        }

        public int E0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            return 0;
        }

        public void E1() {
            int i;
            androidx.recyclerview.widget.f fVar;
            i2--;
            while (i >= 0) {
                this.a.q(i);
                i--;
            }
        }

        public void F(View view, int i2, androidx.recyclerview.widget.RecyclerView.q recyclerView$q3) {
            androidx.recyclerview.widget.b0 b0Var;
            androidx.recyclerview.widget.RecyclerView.e0 view2 = RecyclerView.k0(view);
            if (view2.isRemoved()) {
                view3.x.b(view2);
            } else {
                view4.x.p(view2);
            }
            this.a.c(view, i2, q3, view2.isRemoved());
        }

        public int F0(View view) {
            return obj1.top;
        }

        public void F1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w) {
            int i;
            boolean ignore;
            i2--;
            while (i >= 0) {
                if (!RecyclerView.k0(f0(i)).shouldIgnore()) {
                }
                i--;
                I1(i, w);
            }
        }

        public void G(View view, Rect rect2) {
            final androidx.recyclerview.widget.RecyclerView view2 = this.b;
            if (view2 == null) {
                int obj2 = 0;
                rect2.set(obj2, obj2, obj2, obj2);
            }
            rect2.set(view2.p0(view));
        }

        public void G0(View view, boolean z2, Rect rect3) {
            int identity;
            int i;
            int i2;
            int ceil;
            int obj7;
            if (z2) {
                obj7 = obj7.b;
                rect3.set(-left, -top2, width += right2, height += obj7);
            } else {
                i = 0;
                rect3.set(i, i, view.getWidth(), view.getHeight());
            }
            obj7 = view.getMatrix();
            if (this.b != null && obj7 != null && !obj7.isIdentity()) {
                obj7 = view.getMatrix();
                if (obj7 != null) {
                    if (!obj7.isIdentity()) {
                        RectF rectF = view2.C;
                        rectF.set(rect3);
                        obj7.mapRect(rectF);
                        rect3.set((int)floor, (int)floor2, (int)ceil2, (int)ceil);
                    }
                }
            }
            rect3.offset(view.getLeft(), view.getTop());
        }

        void G1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w) {
            int i;
            View view2;
            androidx.recyclerview.widget.RecyclerView.e0 view;
            boolean ignore;
            boolean tmpDetached;
            androidx.recyclerview.widget.RecyclerView obj7;
            final int i2 = w.j();
            i = i2 + -1;
            while (i >= 0) {
                view2 = w.n(i);
                view = RecyclerView.k0(view2);
                if (view.shouldIgnore()) {
                } else {
                }
                int i3 = 0;
                view.setIsRecyclable(i3);
                if (view.isTmpDetached()) {
                }
                androidx.recyclerview.widget.RecyclerView.m view4 = view3.i0;
                if (view4 != null) {
                }
                view.setIsRecyclable(true);
                w.y(view2);
                i--;
                view4.endAnimation(view);
                this.b.removeDetachedView(view2, i3);
            }
            w.e();
            if (i2 > 0) {
                this.b.invalidate();
            }
        }

        public boolean H() {
            return 0;
        }

        public int H0() {
            return this.q;
        }

        public void H1(View view, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
            K1(view);
            w2.B(view);
        }

        public boolean I() {
            return 0;
        }

        public int I0() {
            return this.o;
        }

        public void I1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
            L1(i);
            w2.B(f0(i));
        }

        public boolean J(androidx.recyclerview.widget.RecyclerView.q recyclerView$q) {
            int obj1;
            obj1 = q != null ? 1 : 0;
            return obj1;
        }

        boolean J0() {
            int i;
            ViewGroup.LayoutParams layoutParams;
            int width;
            final int i4 = 0;
            i = i4;
            while (i < g0()) {
                layoutParams = f0(i).getLayoutParams();
                i++;
            }
            return i4;
        }

        public boolean J1(Runnable runnable) {
            final androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                return view.removeCallbacks(runnable);
            }
            return 0;
        }

        public boolean K0() {
            return this.i;
        }

        public void K1(View view) {
            this.a.p(view);
        }

        public void L(int i, int i2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c4) {
        }

        public boolean L0() {
            return this.j;
        }

        public void L1(int i) {
            Object view;
            if (f0(i) != null) {
                this.a.q(i);
            }
        }

        public void M(int i, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c2) {
        }

        public boolean M1(androidx.recyclerview.widget.RecyclerView recyclerView, View view2, Rect rect3, boolean z4) {
            return this.N1(recyclerView, view2, rect3, z4, false);
        }

        public int N(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public final boolean N0() {
            return this.l;
        }

        public boolean N1(androidx.recyclerview.widget.RecyclerView recyclerView, View view2, Rect rect3, boolean z4, boolean z5) {
            boolean obj7;
            int[] obj4 = i0(view2, rect3);
            final int obj5 = 0;
            final int i = obj4[obj5];
            final int i2 = 1;
            obj4 = obj4[i2];
            if (z5) {
                if (M0(recyclerView, i, obj4) && i == 0 && obj4 != null) {
                    if (i == 0) {
                        if (obj4 != null) {
                        }
                    }
                }
                return obj5;
            } else {
            }
            if (z4) {
                recyclerView.scrollBy(i, obj4);
            } else {
                recyclerView.u1(i, obj4);
            }
            return i2;
        }

        public int O(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public boolean O0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            return 0;
        }

        public void O1() {
            final androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                view.requestLayout();
            }
        }

        public int P(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public boolean P0() {
            return this.k;
        }

        public void P1() {
            this.h = true;
        }

        public int Q(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public int R(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public boolean R0() {
            androidx.recyclerview.widget.RecyclerView.a0 running;
            int i;
            running = this.g;
            if (running != null && running.isRunning()) {
                i = running.isRunning() ? 1 : 0;
            } else {
            }
            return i;
        }

        public int R1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
            return 0;
        }

        public int S(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            return 0;
        }

        public boolean S0(View view, boolean z2, boolean z3) {
            View obj3;
            boolean obj5;
            final int i = 24579;
            final int i2 = 1;
            if (this.e.b(view, i) && this.f.b(view, i)) {
                obj3 = this.f.b(view, i) ? i2 : 0;
            } else {
            }
            if (z2) {
                return obj3;
            }
            return obj3 ^= i2;
        }

        public void S1(int i) {
        }

        public void T(androidx.recyclerview.widget.RecyclerView.w recyclerView$w) {
            int i;
            View view;
            i2--;
            while (i >= 0) {
                Q1(w, i, f0(i));
                i--;
            }
        }

        public void T0(View view, int i2, int i3, int i4, int i5) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Rect rect = layoutParams.b;
            view.layout(obj5 += leftMargin, obj6 += topMargin, obj7 -= rightMargin, obj8 -= bottomMargin);
        }

        public int T1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
            return 0;
        }

        public void U(int i) {
            V(i, f0(i));
        }

        public void U0(View view, int i2, int i3) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Rect rect = this.b.p0(view);
            int obj7 = RecyclerView.p.h0(H0(), I0(), i12 += obj7, layoutParams.width, H());
            int obj8 = RecyclerView.p.h0(t0(), u0(), i17 += obj8, layoutParams.height, I());
            if (b2(view, obj7, obj8, (RecyclerView.q)layoutParams)) {
                view.measure(obj7, obj8);
            }
        }

        @Deprecated
        public void U1(boolean z) {
            this.j = z;
        }

        public void V0(int i, int i2) {
            View view = f0(i);
            if (view == null) {
            } else {
                U(i);
                E(view, i2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot move a child from non-existing index:");
            stringBuilder.append(i);
            stringBuilder.append(this.b.toString());
            IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
            throw obj4;
        }

        void V1(androidx.recyclerview.widget.RecyclerView recyclerView) {
            final int i = 1073741824;
            W1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), i), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), i));
        }

        void W(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.i = true;
            a1(recyclerView);
        }

        public void W0(int i) {
            final androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                view.G0(i);
            }
        }

        void W1(int i, int i2) {
            int obj2;
            this.q = View.MeasureSpec.getSize(i);
            obj2 = View.MeasureSpec.getMode(i);
            this.o = obj2;
            int i3 = 0;
            if (obj2 == null && !RecyclerView.W0) {
                if (!RecyclerView.W0) {
                    this.q = i3;
                }
            }
            this.r = View.MeasureSpec.getSize(i2);
            obj2 = View.MeasureSpec.getMode(i2);
            this.p = obj2;
            if (obj2 == null && !RecyclerView.W0) {
                if (!RecyclerView.W0) {
                    this.r = i3;
                }
            }
        }

        void X(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
            this.i = false;
            c1(recyclerView, w2);
        }

        public void X0(int i) {
            final androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                view.H0(i);
            }
        }

        public void X1(int i, int i2) {
            RecyclerView.f(this.b, i, i2);
        }

        public View Y(View view) {
            androidx.recyclerview.widget.RecyclerView view2 = this.b;
            final int i = 0;
            if (view2 == null) {
                return i;
            }
            final View obj3 = view2.U(view);
            if (obj3 == null) {
                return i;
            }
            if (this.a.n(obj3)) {
                return i;
            }
            return obj3;
        }

        public void Y0(androidx.recyclerview.widget.RecyclerView.h recyclerView$h, androidx.recyclerview.widget.RecyclerView.h recyclerView$h2) {
        }

        public void Y1(Rect rect, int i2, int i3) {
            X1(RecyclerView.p.K(i2, i += i7, z0()), RecyclerView.p.K(i3, obj3 += i9, y0()));
        }

        public View Z(int i) {
            int i2;
            View view;
            androidx.recyclerview.widget.RecyclerView.e0 removed;
            int layoutPosition;
            i2 = 0;
            while (i2 < g0()) {
                view = f0(i2);
                removed = RecyclerView.k0(view);
                i2++;
            }
            return null;
        }

        public boolean Z0(androidx.recyclerview.widget.RecyclerView recyclerView, ArrayList<View> arrayList2, int i3, int i4) {
            return 0;
        }

        void Z1(int i, int i2) {
            int i3;
            int i4;
            int i6;
            int i7;
            int i5;
            int bottom;
            Rect rect;
            int i8 = g0();
            if (i8 == 0) {
                this.b.y(i, i2);
            }
            i3 = 0;
            i5 = i7;
            i6 = i4;
            while (i3 < i8) {
                rect = view5.A;
                m0(f0(i3), rect);
                int left = rect.left;
                if (left < i7) {
                }
                int right = rect.right;
                if (right > i4) {
                }
                int top = rect.top;
                if (top < i5) {
                }
                bottom = rect.bottom;
                if (bottom > i6) {
                }
                i3++;
                i6 = bottom;
                i5 = top;
                i4 = right;
                i7 = left;
            }
            view.A.set(i7, i5, i4, i6);
            Y1(view2.A, i, i2);
        }

        public int a() {
            int paddingBottom;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                paddingBottom = view.getPaddingBottom();
            } else {
                paddingBottom = 0;
            }
            return paddingBottom;
        }

        public abstract androidx.recyclerview.widget.RecyclerView.q a0();

        public void a1(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        void a2(androidx.recyclerview.widget.RecyclerView recyclerView) {
            int width;
            int obj2;
            if (recyclerView == null) {
                obj2 = 0;
                this.b = obj2;
                this.a = obj2;
                obj2 = 0;
                this.q = obj2;
                this.r = obj2;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.w;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            obj2 = 1073741824;
            this.o = obj2;
            this.p = obj2;
        }

        public int b() {
            int i;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                i = u.F(view);
            } else {
                i = 0;
            }
            return i;
        }

        public androidx.recyclerview.widget.RecyclerView.q b0(Context context, AttributeSet attributeSet2) {
            RecyclerView.q qVar = new RecyclerView.q(context, attributeSet2);
            return qVar;
        }

        @Deprecated
        public void b1(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        boolean b2(View view, int i2, int i3, androidx.recyclerview.widget.RecyclerView.q recyclerView$q4) {
            boolean layoutRequested;
            int width;
            int obj3;
            int obj4;
            if (!view.isLayoutRequested() && this.k && RecyclerView.p.Q0(view.getWidth(), i2, q4.width)) {
                if (this.k) {
                    if (RecyclerView.p.Q0(view.getWidth(), i2, q4.width)) {
                        if (!RecyclerView.p.Q0(view.getHeight(), i3, q4.height)) {
                            obj3 = 1;
                        } else {
                            obj3 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        public androidx.recyclerview.widget.RecyclerView.q c0(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            if (layoutParams instanceof RecyclerView.q) {
                RecyclerView.q qVar = new RecyclerView.q((RecyclerView.q)layoutParams);
                return qVar;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                RecyclerView.q qVar2 = new RecyclerView.q((ViewGroup.MarginLayoutParams)layoutParams);
                return qVar2;
            }
            RecyclerView.q qVar3 = new RecyclerView.q(layoutParams);
            return qVar3;
        }

        public void c1(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
            b1(recyclerView);
        }

        boolean c2() {
            return 0;
        }

        public int d0() {
            return -1;
        }

        public View d1(View view, int i2, androidx.recyclerview.widget.RecyclerView.w recyclerView$w3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
            return null;
        }

        boolean d2(View view, int i2, int i3, androidx.recyclerview.widget.RecyclerView.q recyclerView$q4) {
            boolean measuredWidth;
            int width;
            boolean obj3;
            int obj4;
            if (this.k && RecyclerView.p.Q0(view.getMeasuredWidth(), i2, q4.width)) {
                if (RecyclerView.p.Q0(view.getMeasuredWidth(), i2, q4.width)) {
                    if (!RecyclerView.p.Q0(view.getMeasuredHeight(), i3, q4.height)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        public int e0(View view) {
            return obj1.bottom;
        }

        public void e1(AccessibilityEvent accessibilityEvent) {
            androidx.recyclerview.widget.RecyclerView view = this.b;
            f1(view.b, view.A0, accessibilityEvent);
        }

        public void e2(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public View f0(int i) {
            View obj2;
            final androidx.recyclerview.widget.f fVar = this.a;
            if (fVar != null) {
                obj2 = fVar.f(i);
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        public void f1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, AccessibilityEvent accessibilityEvent3) {
            int i;
            androidx.recyclerview.widget.RecyclerView obj2;
            int obj3;
            obj2 = this.b;
            if (obj2 != null) {
                if (accessibilityEvent3 == null) {
                } else {
                    obj3 = 1;
                    i = -1;
                    if (!obj2.canScrollVertically(obj3) && !this.b.canScrollVertically(i) && !this.b.canScrollHorizontally(i)) {
                        i = -1;
                        if (!this.b.canScrollVertically(i)) {
                            if (!this.b.canScrollHorizontally(i)) {
                                if (this.b.canScrollHorizontally(obj3)) {
                                } else {
                                    obj3 = 0;
                                }
                            }
                        }
                    }
                    accessibilityEvent3.setScrollable(obj3);
                    obj2 = obj2.D;
                    if (obj2 != null) {
                        accessibilityEvent3.setItemCount(obj2.getItemCount());
                    }
                }
            }
        }

        public void f2(androidx.recyclerview.widget.RecyclerView.a0 recyclerView$a0) {
            androidx.recyclerview.widget.RecyclerView.a0 running;
            running = this.g;
            if (running != null && a0 != running && running.isRunning()) {
                if (a0 != running) {
                    if (running.isRunning()) {
                        this.g.stop();
                    }
                }
            }
            this.g = a0;
            a0.start(this.b, this);
        }

        public int g0() {
            int i;
            androidx.recyclerview.widget.f fVar = this.a;
            if (fVar != null) {
                i = fVar.g();
            } else {
                i = 0;
            }
            return i;
        }

        void g1(c c) {
            androidx.recyclerview.widget.RecyclerView view = this.b;
            h1(view.b, view.A0, c);
        }

        void g2() {
            final androidx.recyclerview.widget.RecyclerView.a0 view = this.g;
            if (view != null) {
                view.stop();
            }
        }

        public void h1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, c c3) {
            boolean scrollHorizontally;
            boolean scrollHorizontally2;
            int i2 = -1;
            int i4 = 1;
            if (!this.b.canScrollVertically(i2)) {
                if (this.b.canScrollHorizontally(i2)) {
                    c3.a(8192);
                    c3.q0(i4);
                }
            } else {
            }
            if (!this.b.canScrollVertically(i4)) {
                if (this.b.canScrollHorizontally(i4)) {
                    c3.a(4096);
                    c3.q0(i4);
                }
            } else {
            }
            c3.Z(c.b.a(D0(w, b02), k0(w, b02), O0(w, b02), E0(w, b02)));
        }

        public boolean h2() {
            return 0;
        }

        void i1(View view, c c2) {
            androidx.recyclerview.widget.RecyclerView.e0 view2;
            boolean removed;
            view2 = RecyclerView.k0(view);
            if (view2 != null && !view2.isRemoved() && !this.a.n(view2.itemView)) {
                if (!view2.isRemoved()) {
                    if (!this.a.n(view2.itemView)) {
                        androidx.recyclerview.widget.RecyclerView view3 = this.b;
                        j1(view3.b, view3.A0, view, c2);
                    }
                }
            }
        }

        public boolean j0() {
            androidx.recyclerview.widget.RecyclerView view;
            int i;
            view = this.b;
            if (view != null && view.y) {
                i = view.y ? 1 : 0;
            } else {
            }
            return i;
        }

        public void j1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, View view3, c c4) {
        }

        public int k0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            return -1;
        }

        public View k1(View view, int i2) {
            return null;
        }

        public int l0(View view) {
            return bottom += obj2;
        }

        public void l1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        }

        public void m0(View view, Rect rect2) {
            RecyclerView.m0(view, rect2);
        }

        public void m1(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public int n0(View view) {
            return left -= obj2;
        }

        public void n1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int o0(View view) {
            Rect rect = layoutParams.b;
            return obj3 += bottom;
        }

        public void o1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        }

        public int p() {
            int paddingRight;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                paddingRight = view.getPaddingRight();
            } else {
                paddingRight = 0;
            }
            return paddingRight;
        }

        public int p0(View view) {
            Rect rect = layoutParams.b;
            return obj3 += right;
        }

        public void p1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        }

        public int q0(View view) {
            return right += obj2;
        }

        public void q1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, Object object4) {
            p1(recyclerView, i2, i3);
        }

        public int r0(View view) {
            return top -= obj2;
        }

        public void r1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public View s0() {
            boolean z;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            final int i = 0;
            if (view == null) {
                return i;
            }
            View focusedChild = view.getFocusedChild();
            if (focusedChild != null && this.a.n(focusedChild)) {
                if (this.a.n(focusedChild)) {
                }
                return focusedChild;
            }
            return i;
        }

        public void s1(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        }

        public int t() {
            int i;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                i = u.G(view);
            } else {
                i = 0;
            }
            return i;
        }

        public int t0() {
            return this.r;
        }

        public void t1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3, int i4) {
            this.b.y(i3, i4);
        }

        public int u() {
            int paddingTop;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                paddingTop = view.getPaddingTop();
            } else {
                paddingTop = 0;
            }
            return paddingTop;
        }

        public int u0() {
            return this.p;
        }

        @Deprecated
        public boolean u1(androidx.recyclerview.widget.RecyclerView recyclerView, View view2, View view3) {
            int obj1;
            if (!R0()) {
                if (recyclerView.A0()) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }

        public int v() {
            int paddingLeft;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                paddingLeft = view.getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            return paddingLeft;
        }

        public int v0() {
            androidx.recyclerview.widget.RecyclerView.h adapter;
            int itemCount;
            androidx.recyclerview.widget.RecyclerView view = this.b;
            if (view != null) {
                adapter = view.getAdapter();
            } else {
                adapter = 0;
            }
            if (adapter != null) {
                itemCount = adapter.getItemCount();
            } else {
                itemCount = 0;
            }
            return itemCount;
        }

        public boolean v1(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, View view3, View view4) {
            return u1(recyclerView, view3, view4);
        }

        public int w0() {
            return u.B(this.b);
        }

        public void w1(Parcelable parcelable) {
        }

        public int x0(View view) {
            return obj1.left;
        }

        public Parcelable x1() {
            return null;
        }

        public void y(View view) {
            z(view, -1);
        }

        public int y0() {
            return u.C(this.b);
        }

        public void y1(int i) {
        }

        public void z(View view, int i2) {
            C(view, i2, true);
        }

        public int z0() {
            return u.D(this.b);
        }

        void z1(androidx.recyclerview.widget.RecyclerView.a0 recyclerView$a0) {
            androidx.recyclerview.widget.RecyclerView.a0 obj2;
            if (this.g == a0) {
                this.g = 0;
            }
        }
    }

    public static class q extends ViewGroup.MarginLayoutParams {

        androidx.recyclerview.widget.RecyclerView.e0 a;
        final Rect b;
        boolean c = true;
        boolean v = false;
        public q(int i, int i2) {
            super(i, i2);
            Rect obj1 = new Rect();
            this.b = obj1;
            obj1 = 1;
            obj1 = 0;
        }

        public q(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            Rect obj1 = new Rect();
            this.b = obj1;
            obj1 = 1;
            obj1 = 0;
        }

        public q(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            Rect obj1 = new Rect();
            this.b = obj1;
            obj1 = 1;
            obj1 = 0;
        }

        public q(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
            Rect obj1 = new Rect();
            this.b = obj1;
            obj1 = 1;
            obj1 = 0;
        }

        public q(androidx.recyclerview.widget.RecyclerView.q recyclerView$q) {
            super(q);
            Rect obj1 = new Rect();
            this.b = obj1;
            obj1 = 1;
            obj1 = 0;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public int a() {
            return this.a.getLayoutPosition();
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public boolean b() {
            return this.a.isUpdated();
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public boolean c() {
            return this.a.isRemoved();
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public boolean d() {
            return this.a.isInvalid();
        }
    }

    public interface r {
        public abstract void b(View view);

        public abstract void d(View view);
    }

    public static abstract class s {
        public abstract boolean a(int i, int i2);
    }

    public interface t {
        public abstract void a(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2);

        public abstract boolean c(androidx.recyclerview.widget.RecyclerView recyclerView, MotionEvent motionEvent2);

        public abstract void e(boolean z);
    }

    public static abstract class u {
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class v {

        SparseArray<androidx.recyclerview.widget.RecyclerView.v.a> a;
        private int b = 0;
        public v() {
            super();
            SparseArray sparseArray = new SparseArray();
            this.a = sparseArray;
            int i = 0;
        }

        private androidx.recyclerview.widget.RecyclerView.v.a g(int i) {
            Object aVar;
            SparseArray sparseArray;
            if ((RecyclerView.v.a)this.a.get(i) == null) {
                aVar = new RecyclerView.v.a();
                this.a.put(i, aVar);
            }
            return aVar;
        }

        void a() {
            this.b = i++;
        }

        public void b() {
            int i;
            ArrayList list;
            i = 0;
            while (i < this.a.size()) {
                valueAt.a.clear();
                i++;
            }
        }

        void c() {
            this.b = i--;
        }

        void d(int i, long l2) {
            final androidx.recyclerview.widget.RecyclerView.v.a obj3 = g(i);
            obj3.d = j(obj3.d, obj1);
        }

        void e(int i, long l2) {
            final androidx.recyclerview.widget.RecyclerView.v.a obj3 = g(i);
            obj3.c = j(obj3.c, obj1);
        }

        public androidx.recyclerview.widget.RecyclerView.e0 f(int i) {
            SparseArray empty;
            boolean attachedToTransitionOverlay;
            Object obj3;
            obj3 = this.a.get(i);
            if ((RecyclerView.v.a)obj3 != null && !obj3.a.isEmpty()) {
                if (!obj3.a.isEmpty()) {
                    obj3 = obj3.a;
                    size--;
                    while (empty >= 0) {
                        empty--;
                    }
                }
            }
            return null;
        }

        void h(androidx.recyclerview.widget.RecyclerView.h recyclerView$h, androidx.recyclerview.widget.RecyclerView.h recyclerView$h2, boolean z3) {
            int obj1;
            if (h != 0) {
                c();
            }
            if (!z3 && this.b == 0) {
                if (this.b == 0) {
                    b();
                }
            }
            if (h2 != null) {
                a();
            }
        }

        public void i(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            int itemViewType = e0.getItemViewType();
            ArrayList list = view.a;
            if (obj.b <= list.size()) {
            }
            e0.resetInternal();
            list.add(e0);
        }

        long j(long l, long l2) {
            if (Long.compare(l, i) == 0) {
                return obj7;
            }
            int i2 = 4;
            return obj5 += obj7;
        }

        public void k(int i, int i2) {
            int i3;
            androidx.recyclerview.widget.RecyclerView.v.a obj2 = g(i);
            obj2.b = i2;
            obj2 = obj2.a;
            while (obj2.size() > i2) {
                obj2.remove(size2--);
            }
        }

        boolean l(int i, long l2, long l3) {
            int obj5;
            int obj6;
            final long l = obj5.d;
            if (Long.compare(l, i2) != 0) {
                if (Long.compare(obj6, obj8) < 0) {
                    obj5 = 1;
                } else {
                    obj5 = 0;
                }
            } else {
            }
            return obj5;
        }

        boolean m(int i, long l2, long l3) {
            int obj5;
            int obj6;
            final long l = obj5.c;
            if (Long.compare(l, i2) != 0) {
                if (Long.compare(obj6, obj8) < 0) {
                    obj5 = 1;
                } else {
                    obj5 = 0;
                }
            } else {
            }
            return obj5;
        }
    }

    public final class w {

        final ArrayList<androidx.recyclerview.widget.RecyclerView.e0> a;
        ArrayList<androidx.recyclerview.widget.RecyclerView.e0> b = null;
        final ArrayList<androidx.recyclerview.widget.RecyclerView.e0> c;
        private final List<androidx.recyclerview.widget.RecyclerView.e0> d;
        private int e = 2;
        int f = 2;
        androidx.recyclerview.widget.RecyclerView.v g;
        private androidx.recyclerview.widget.RecyclerView.c0 h;
        final androidx.recyclerview.widget.RecyclerView i;
        public w(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.i = recyclerView;
            super();
            ArrayList obj2 = new ArrayList();
            this.a = obj2;
            int i = 0;
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.d = Collections.unmodifiableList(obj2);
            obj2 = 2;
        }

        private boolean H(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, long l4) {
            androidx.recyclerview.widget.RecyclerView.v view;
            long l;
            long l2;
            long obj13;
            e0.mBindingAdapter = 0;
            e0.mOwnerRecyclerView = this.i;
            final long nanoTime = this.i.getNanoTime();
            if (Long.compare(l4, l3) != 0 && !this.g.l(e0.getItemViewType(), nanoTime, obj4)) {
                if (!this.g.l(itemViewType2, nanoTime, obj4)) {
                    return 0;
                }
            }
            obj13.D.bindViewHolder(e0, i2);
            this.g.d(e0.getItemViewType(), obj13 -= nanoTime);
            b(e0);
            if (obj11.A0.f()) {
                e0.mPreLayoutPosition = i3;
            }
            return 1;
        }

        private void b(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            int i;
            boolean z;
            boolean z2;
            Object obj3;
            obj3 = e0.itemView;
            if (this.i.z0() && u.z(obj3) == 0) {
                obj3 = e0.itemView;
                if (u.z(obj3) == 0) {
                    u.v0(obj3, 1);
                }
                androidx.recyclerview.widget.v h0 = view2.H0;
                if (h0 == null) {
                }
                z = h0.n();
                if (z instanceof v.a) {
                    (v.a)z.o(obj3);
                }
                u.l0(obj3, z);
            }
        }

        private void q(ViewGroup viewGroup, boolean z2) {
            int i;
            View childAt;
            boolean z;
            int obj6;
            final int i3 = 1;
            childCount -= i3;
            while (i >= 0) {
                childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                }
                i--;
                q((ViewGroup)childAt, i3);
            }
            if (!z2) {
            }
            int i2 = 4;
            if (viewGroup.getVisibility() == i2) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(i2);
            } else {
                viewGroup.setVisibility(i2);
                viewGroup.setVisibility(viewGroup.getVisibility());
            }
        }

        private void r(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            boolean z;
            final View obj2 = e0.itemView;
            if (obj2 instanceof ViewGroup) {
                q((ViewGroup)obj2, false);
            }
        }

        void A(int i) {
            a((RecyclerView.e0)this.c.get(i), true);
            this.c.remove(i);
        }

        public void B(View view) {
            boolean tmpDetached;
            int i;
            boolean obj4;
            final androidx.recyclerview.widget.RecyclerView.e0 view2 = RecyclerView.k0(view);
            if (view2.isTmpDetached()) {
                this.i.removeDetachedView(view, false);
            }
            if (view2.isScrap()) {
                view2.unScrap();
            } else {
                if (view2.wasReturnedFromScrap()) {
                    view2.clearReturnedFromScrapFlag();
                }
            }
            C(view2);
            if (obj4.i0 != null && !view2.isRecyclable()) {
                if (!view2.isRecyclable()) {
                    obj4.i0.endAnimation(view2);
                }
            }
        }

        void C(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            boolean transientStatePreventRecycling;
            boolean parent;
            int i;
            int i2;
            androidx.recyclerview.widget.RecyclerView.h onFailedToRecycleView;
            int recyclable;
            int size;
            int i3;
            int anyOfTheFlags;
            ArrayList list;
            boolean z;
            int mPosition;
            i = 0;
            i2 = 1;
            if (!e0.isScrap()) {
                if (e0.itemView.getParent() != null) {
                } else {
                    if (e0.isTmpDetached()) {
                    } else {
                        if (e0.shouldIgnore()) {
                        } else {
                            transientStatePreventRecycling = e0.doesTransientStatePreventRecycling();
                            onFailedToRecycleView = view2.D;
                            if (onFailedToRecycleView != null && transientStatePreventRecycling && onFailedToRecycleView.onFailedToRecycleView(e0)) {
                                if (transientStatePreventRecycling) {
                                    recyclable = onFailedToRecycleView.onFailedToRecycleView(e0) ? i2 : i;
                                } else {
                                }
                            } else {
                            }
                            if (recyclable == 0) {
                                if (e0.isRecyclable()) {
                                    if (this.f > 0 && !e0.hasAnyOfTheFlags(526)) {
                                        if (!e0.hasAnyOfTheFlags(526)) {
                                            size = this.c.size();
                                            if (size >= this.f && size > 0) {
                                                if (size > 0) {
                                                    A(i);
                                                    size--;
                                                }
                                            }
                                            if (RecyclerView.Y0 && size > 0 && !view4.z0.d(e0.mPosition)) {
                                                if (size > 0) {
                                                    if (!view4.z0.d(e0.mPosition)) {
                                                        size--;
                                                        while (i3 >= 0) {
                                                            if (!view5.z0.d(obj.mPosition)) {
                                                                break;
                                                            } else {
                                                            }
                                                            i3--;
                                                        }
                                                        i3 += i2;
                                                    }
                                                }
                                            }
                                            this.c.add(size, e0);
                                            recyclable = i2;
                                        } else {
                                            recyclable = i;
                                        }
                                    } else {
                                    }
                                    if (recyclable == 0) {
                                        a(e0, i2);
                                    } else {
                                        i2 = i;
                                    }
                                    i = recyclable;
                                } else {
                                    i2 = i;
                                }
                            } else {
                            }
                            view3.x.q(e0);
                            if (i == 0 && i2 == 0 && transientStatePreventRecycling) {
                                if (i2 == 0) {
                                    if (transientStatePreventRecycling) {
                                        transientStatePreventRecycling = 0;
                                        e0.mBindingAdapter = transientStatePreventRecycling;
                                        e0.mOwnerRecyclerView = transientStatePreventRecycling;
                                    }
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                        stringBuilder.append(this.i.R());
                        IllegalArgumentException obj7 = new IllegalArgumentException(stringBuilder.toString());
                        throw obj7;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                stringBuilder2.append(e0);
                stringBuilder2.append(this.i.R());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Scrapped or attached views may not be recycled. isScrap:");
            stringBuilder3.append(e0.isScrap());
            stringBuilder3.append(" isAttached:");
            if (e0.itemView.getParent() == null) {
            } else {
                i = i2;
            }
            stringBuilder3.append(i);
            stringBuilder3.append(this.i.R());
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder3.toString());
            throw illegalArgumentException2;
        }

        void D(View view) {
            boolean anyOfTheFlags;
            boolean stableIds;
            ArrayList list;
            ArrayList arrayList;
            androidx.recyclerview.widget.RecyclerView.e0 obj3 = RecyclerView.k0(view);
            if (!obj3.hasAnyOfTheFlags(12) && obj3.isUpdated()) {
                if (obj3.isUpdated()) {
                    if (this.i.q(obj3)) {
                        if (obj3.isInvalid() && !obj3.isRemoved()) {
                            if (!obj3.isRemoved()) {
                                if (!view2.D.hasStableIds()) {
                                } else {
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                                stringBuilder.append(this.i.R());
                                obj3 = new IllegalArgumentException(stringBuilder.toString());
                                throw obj3;
                            }
                        }
                        obj3.setScrapContainer(this, false);
                        this.a.add(obj3);
                    } else {
                        if (this.b == null) {
                            arrayList = new ArrayList();
                            this.b = arrayList;
                        }
                        obj3.setScrapContainer(this, true);
                        this.b.add(obj3);
                    }
                } else {
                }
            } else {
            }
        }

        void E(androidx.recyclerview.widget.RecyclerView.v recyclerView$v) {
            Object obj2;
            final androidx.recyclerview.widget.RecyclerView.v view = this.g;
            if (view != null) {
                view.c();
            }
            this.g = v;
            if (v != null && this.i.getAdapter() != null) {
                if (this.i.getAdapter() != null) {
                    this.g.a();
                }
            }
        }

        void F(androidx.recyclerview.widget.RecyclerView.c0 recyclerView$c0) {
        }

        public void G(int i) {
            this.e = i;
            K();
        }

        androidx.recyclerview.widget.RecyclerView.e0 I(int i, boolean z2, long l3) {
            androidx.recyclerview.widget.RecyclerView.c0 recordPreLayoutInformation;
            boolean needsUpdate;
            boolean z;
            int i2;
            int anyOfTheFlags;
            ViewGroup.LayoutParams defaultLayoutParams;
            int viewHolder;
            View checkLayoutParams;
            int i3;
            int unmodifiedPayloads;
            boolean returnedFromScrap;
            int cmp;
            boolean z3;
            int i6;
            View itemViewType;
            int i4;
            boolean stableIds;
            long weakReference;
            int i5;
            long l;
            long l2;
            final Object obj2 = this;
            i3 = i;
            recordPreLayoutInformation = z2;
            if (i3 < 0) {
            } else {
                if (i3 >= view7.A0.c()) {
                } else {
                    viewHolder = 0;
                    i6 = 1;
                    final int i11 = 0;
                    if (view8.A0.f()) {
                        unmodifiedPayloads = h(i) != null ? i6 : i11;
                    } else {
                        anyOfTheFlags = viewHolder;
                    }
                    anyOfTheFlags = m(i, z2);
                    if (anyOfTheFlags == 0 && anyOfTheFlags != null) {
                        anyOfTheFlags = m(i, z2);
                        if (anyOfTheFlags != null) {
                            if (!obj2.L(anyOfTheFlags)) {
                                if (!recordPreLayoutInformation) {
                                    anyOfTheFlags.addFlags(4);
                                    if (anyOfTheFlags.isScrap()) {
                                        obj2.i.removeDetachedView(anyOfTheFlags.itemView, i11);
                                        anyOfTheFlags.unScrap();
                                    } else {
                                        if (anyOfTheFlags.wasReturnedFromScrap()) {
                                            anyOfTheFlags.clearReturnedFromScrapFlag();
                                        }
                                    }
                                    obj2.C(anyOfTheFlags);
                                }
                                anyOfTheFlags = viewHolder;
                            } else {
                                unmodifiedPayloads = i6;
                            }
                        }
                    }
                    if (anyOfTheFlags == 0) {
                        returnedFromScrap = view23.v.m(i3);
                        if (returnedFromScrap < 0) {
                        } else {
                            if (returnedFromScrap >= view26.D.getItemCount()) {
                            } else {
                                itemViewType = view28.D.getItemViewType(returnedFromScrap);
                                anyOfTheFlags = obj2.l(view12.D.getItemId(returnedFromScrap), obj11, itemViewType);
                                if (view30.D.hasStableIds() && anyOfTheFlags != null) {
                                    anyOfTheFlags = obj2.l(view12.D.getItemId(returnedFromScrap), obj11, itemViewType);
                                    if (anyOfTheFlags != null) {
                                        anyOfTheFlags.mPosition = returnedFromScrap;
                                        unmodifiedPayloads = i6;
                                    }
                                }
                                recordPreLayoutInformation = obj2.h;
                                recordPreLayoutInformation = recordPreLayoutInformation.a(obj2, i3, itemViewType);
                                if (anyOfTheFlags == 0 && recordPreLayoutInformation != null && recordPreLayoutInformation != null) {
                                    recordPreLayoutInformation = obj2.h;
                                    if (recordPreLayoutInformation != null) {
                                        recordPreLayoutInformation = recordPreLayoutInformation.a(obj2, i3, itemViewType);
                                        if (recordPreLayoutInformation != null) {
                                            anyOfTheFlags = obj2.i.j0(recordPreLayoutInformation);
                                            if (anyOfTheFlags == null) {
                                            } else {
                                                if (anyOfTheFlags.shouldIgnore()) {
                                                } else {
                                                }
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                                stringBuilder3.append(obj2.i.R());
                                                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder3.toString());
                                                throw illegalArgumentException2;
                                            }
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                            stringBuilder2.append(obj2.i.R());
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                                            throw illegalArgumentException;
                                        }
                                    }
                                }
                                recordPreLayoutInformation = i().f(itemViewType);
                                recordPreLayoutInformation.resetInternal();
                                if (anyOfTheFlags == 0 && recordPreLayoutInformation != null && RecyclerView.V0) {
                                    recordPreLayoutInformation = i().f(itemViewType);
                                    if (recordPreLayoutInformation != null) {
                                        recordPreLayoutInformation.resetInternal();
                                        if (RecyclerView.V0) {
                                            obj2.r(recordPreLayoutInformation);
                                        }
                                    }
                                    anyOfTheFlags = recordPreLayoutInformation;
                                }
                                if (anyOfTheFlags == 0) {
                                    recordPreLayoutInformation = obj2.i.getNanoTime();
                                    if (Long.compare(l3, weakReference) != 0 && !obj2.g.m(itemViewType, recordPreLayoutInformation, obj13)) {
                                        if (!obj2.g.m(itemViewType, recordPreLayoutInformation, obj13)) {
                                            return viewHolder;
                                        }
                                    }
                                    androidx.recyclerview.widget.RecyclerView view20 = obj2.i;
                                    viewHolder = view20.D.createViewHolder(view20, itemViewType);
                                    z3 = RecyclerView.Y(viewHolder.itemView);
                                    if (RecyclerView.Y0 && z3 != null) {
                                        z3 = RecyclerView.Y(viewHolder.itemView);
                                        if (z3 != null) {
                                            weakReference = new WeakReference(z3);
                                            viewHolder.mNestedRecyclerView = weakReference;
                                        }
                                    }
                                    obj2.g.e(itemViewType, nanoTime -= recordPreLayoutInformation);
                                    i4 = viewHolder;
                                } else {
                                }
                                int i12 = unmodifiedPayloads;
                                recordPreLayoutInformation = 8192;
                                i4.setFlags(i11, recordPreLayoutInformation);
                                if (i12 != 0 && !view.A0.f() && i4.hasAnyOfTheFlags(recordPreLayoutInformation) && a02.k) {
                                    if (!view.A0.f()) {
                                        recordPreLayoutInformation = 8192;
                                        if (i4.hasAnyOfTheFlags(recordPreLayoutInformation)) {
                                            i4.setFlags(i11, recordPreLayoutInformation);
                                            if (a02.k) {
                                                androidx.recyclerview.widget.RecyclerView view9 = obj2.i;
                                                obj2.i.Y0(i4, view9.i0.recordPreLayoutInformation(view9.A0, i4, adapterChangeFlagsForAnimations |= 4096, i4.getUnmodifiedPayloads()));
                                            }
                                        }
                                    }
                                }
                                if (view3.A0.f() && i4.isBound()) {
                                    if (i4.isBound()) {
                                        i4.mPreLayoutPosition = i3;
                                        z = i11;
                                    } else {
                                        if (i4.isBound() && !i4.needsUpdate()) {
                                            if (!i4.needsUpdate()) {
                                                if (i4.isInvalid()) {
                                                    z = this.H(i4, view4.v.m(i3), i, l3);
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                                defaultLayoutParams = i4.itemView.getLayoutParams();
                                if (defaultLayoutParams == null) {
                                    i4.itemView.setLayoutParams((RecyclerView.q)obj2.i.generateDefaultLayoutParams());
                                } else {
                                    if (!obj2.i.checkLayoutParams(defaultLayoutParams)) {
                                        i4.itemView.setLayoutParams((RecyclerView.q)obj2.i.generateLayoutParams(defaultLayoutParams));
                                    } else {
                                    }
                                }
                                defaultLayoutParams.a = i4;
                                if (i12 != 0 && z) {
                                    if (z) {
                                    } else {
                                        i6 = i11;
                                    }
                                } else {
                                }
                                defaultLayoutParams.v = i6;
                                return i4;
                            }
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Inconsistency detected. Invalid item position ");
                        stringBuilder4.append(i3);
                        stringBuilder4.append("(offset:");
                        stringBuilder4.append(returnedFromScrap);
                        stringBuilder4.append(").state:");
                        stringBuilder4.append(view21.A0.c());
                        stringBuilder4.append(obj2.i.R());
                        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder4.toString());
                        throw indexOutOfBoundsException2;
                    }
                    i4 = anyOfTheFlags;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid item position ");
            stringBuilder.append(i3);
            stringBuilder.append("(");
            stringBuilder.append(i3);
            stringBuilder.append("). Item count:");
            stringBuilder.append(view14.A0.c());
            stringBuilder.append(obj2.i.R());
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
        }

        void J(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            ArrayList list;
            if (e0.mInChangeScrap) {
                this.b.remove(e0);
            } else {
                this.a.remove(e0);
            }
            e0.mScrapContainer = 0;
            e0.mInChangeScrap = false;
            e0.clearReturnedFromScrapFlag();
        }

        void K() {
            int i2;
            int i;
            int size;
            int i3;
            androidx.recyclerview.widget.RecyclerView.p view2 = view.E;
            i2 = view2 != null ? view2.m : 0;
            this.f = i4 += i2;
            size2--;
            while (i >= 0) {
                if (this.c.size() > this.f) {
                }
                A(i);
                i--;
            }
        }

        boolean L(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            boolean itemViewType;
            int i;
            int itemCount;
            int itemViewType2;
            if (e0.isRemoved()) {
                return obj8.A0.f();
            }
            int mPosition = e0.mPosition;
            if (mPosition < 0) {
            } else {
                if (mPosition >= view8.D.getItemCount()) {
                } else {
                    if (!view.A0.f() && view6.D.getItemViewType(e0.mPosition) != e0.getItemViewType()) {
                        if (view6.D.getItemViewType(e0.mPosition) != e0.getItemViewType()) {
                            return 0;
                        }
                    }
                    int i2 = 1;
                    if (view2.D.hasStableIds() && Long.compare(itemId, itemId2) == 0) {
                        if (Long.compare(itemId, itemId2) == 0) {
                            i = i2;
                        }
                        return i;
                    }
                    return i2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
            stringBuilder.append(e0);
            stringBuilder.append(this.i.R());
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
        }

        void M(int i, int i2) {
            int i3;
            Object obj;
            int mPosition;
            size--;
            while (i3 >= 0) {
                obj = this.c.get(i3);
                if ((RecyclerView.e0)obj == null) {
                } else {
                }
                mPosition = obj.mPosition;
                if (mPosition >= i && mPosition < i2 += i) {
                }
                i3--;
                if (mPosition < i2 += i) {
                }
                (RecyclerView.e0)obj.addFlags(2);
                A(i3);
            }
        }

        void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, boolean z2) {
            androidx.recyclerview.widget.v vVar;
            boolean z;
            RecyclerView.s(e0);
            final View itemView = e0.itemView;
            vVar = view.H0;
            final int i = 0;
            if (vVar != null) {
                d.h.l.a aVar = vVar.n();
                if (aVar instanceof v.a) {
                    vVar = (v.a)aVar.n(itemView);
                } else {
                    vVar = i;
                }
                u.l0(itemView, vVar);
            }
            if (z2) {
                g(e0);
            }
            e0.mBindingAdapter = i;
            e0.mOwnerRecyclerView = i;
            i().i(e0);
        }

        public void c() {
            this.a.clear();
            z();
        }

        void d() {
            ArrayList size;
            int i2;
            int i;
            int i3;
            Object obj;
            i2 = 0;
            i = i2;
            while (i < this.c.size()) {
                (RecyclerView.e0)this.c.get(i).clearOldPosition();
                i++;
            }
            i3 = i2;
            while (i3 < this.a.size()) {
                (RecyclerView.e0)this.a.get(i3).clearOldPosition();
                i3++;
            }
            size = this.b;
            if (size != null) {
                while (i2 < size.size()) {
                    (RecyclerView.e0)this.b.get(i2).clearOldPosition();
                    i2++;
                }
            }
        }

        void e() {
            this.a.clear();
            ArrayList list2 = this.b;
            if (list2 != null) {
                list2.clear();
            }
        }

        public int f(int i) {
            int i2;
            if (i < 0) {
            } else {
                if (i >= view.A0.c()) {
                } else {
                    if (!view2.A0.f()) {
                        return i;
                    }
                    return view3.v.m(i);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid position ");
            stringBuilder.append(i);
            stringBuilder.append(". State item count is ");
            stringBuilder.append(obj4.A0.c());
            stringBuilder.append(this.i.R());
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
        }

        void g(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            Object view;
            int i;
            Object obj;
            androidx.recyclerview.widget.RecyclerView.x view3 = view2.F;
            if (view3 != null) {
                view3.a(e0);
            }
            i = 0;
            while (i < view4.G.size()) {
                (RecyclerView.x)view7.G.get(i).a(e0);
                i++;
            }
            androidx.recyclerview.widget.RecyclerView.h view6 = view5.D;
            if (view6 != null) {
                view6.onViewRecycled(e0);
            }
            view = this.i;
            if (view.A0 != null) {
                view.x.q(e0);
            }
        }

        androidx.recyclerview.widget.RecyclerView.e0 h(int i) {
            ArrayList size;
            int i4;
            int i2;
            androidx.recyclerview.widget.RecyclerView.h returnedFromScrap2;
            int i3;
            long itemId;
            boolean returnedFromScrap;
            long itemId2;
            int obj10;
            size = this.b;
            if (size != null) {
                size = size.size();
                if (size == 0) {
                } else {
                    i2 = i4;
                    i3 = 32;
                    while (i2 < size) {
                        itemId = this.b.get(i2);
                        i2++;
                        i3 = 32;
                    }
                    obj10 = view3.v.m(i);
                    if (view.D.hasStableIds() && obj10 > 0 && obj10 < view4.D.getItemCount()) {
                        obj10 = view3.v.m(i);
                        if (obj10 > 0) {
                            if (obj10 < view4.D.getItemCount()) {
                                while (i4 < size) {
                                    obj10 = this.b.get(i4);
                                    i4++;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        androidx.recyclerview.widget.RecyclerView.v i() {
            androidx.recyclerview.widget.RecyclerView.v vVar;
            if (this.g == null) {
                vVar = new RecyclerView.v();
                this.g = vVar;
            }
            return this.g;
        }

        int j() {
            return this.a.size();
        }

        public List<androidx.recyclerview.widget.RecyclerView.e0> k() {
            return this.d;
        }

        androidx.recyclerview.widget.RecyclerView.e0 l(long l, int i2, boolean z3) {
            int i3;
            int i;
            Object itemView;
            int returnedFromScrap;
            View attachedToTransitionOverlay;
            int i4;
            long obj6;
            int obj7;
            size--;
            while (i3 >= 0) {
                itemView = this.a.get(i3);
                i3--;
                if (obj9 == null) {
                }
                this.a.remove(i3);
                this.i.removeDetachedView(itemView.itemView, false);
                y(itemView.itemView);
            }
            size2--;
            itemView = 0;
            while (i >= 0) {
                returnedFromScrap = this.c.get(i);
                i--;
                itemView = 0;
            }
            return itemView;
        }

        androidx.recyclerview.widget.RecyclerView.e0 m(int i, boolean z2) {
            int size;
            int i3;
            int i2;
            Object attachedToTransitionOverlay;
            boolean returnedFromScrap;
            int obj6;
            i2 = i3;
            while (i2 < this.a.size()) {
                attachedToTransitionOverlay = this.a.get(i2);
                i2++;
            }
            size = view.w.e(i);
            if (!z2 && size != null) {
                size = view.w.e(i);
                if (size != null) {
                    obj6 = RecyclerView.k0(size);
                    obj7.w.s(size);
                    int obj7 = obj7.w.m(size);
                    if (obj7 == -1) {
                    } else {
                        view2.w.d(obj7);
                        D(size);
                        obj6.addFlags(8224);
                        return obj6;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("layout index should not be -1 after unhiding a view:");
                    stringBuilder.append(obj6);
                    stringBuilder.append(this.i.R());
                    obj7 = new IllegalStateException(stringBuilder.toString());
                    throw obj7;
                }
            }
            while (i3 < this.c.size()) {
                i2 = this.c.get(i3);
                i3++;
            }
            return null;
        }

        View n(int i) {
            return obj2.itemView;
        }

        public View o(int i) {
            return p(i, false);
        }

        View p(int i, boolean z2) {
            return obj3.itemView;
        }

        void s() {
            int i;
            ViewGroup.LayoutParams layoutParams;
            int i2;
            i = 0;
            while (i < this.c.size()) {
                layoutParams = obj.itemView.getLayoutParams();
                if ((RecyclerView.q)layoutParams != null) {
                }
                i++;
                layoutParams.c = true;
            }
        }

        void t() {
            androidx.recyclerview.widget.RecyclerView.h stableIds;
            int i2;
            Object obj;
            int i;
            i2 = 0;
            while (i2 < this.c.size()) {
                obj = this.c.get(i2);
                if ((RecyclerView.e0)obj != null) {
                }
                i2++;
                (RecyclerView.e0)obj.addFlags(6);
                obj.addChangePayload(0);
            }
            stableIds = view.D;
            if (stableIds != null) {
                if (!stableIds.hasStableIds()) {
                    z();
                }
            } else {
            }
        }

        void u(int i, int i2) {
            int i3;
            Object obj;
            int mPosition;
            final int i4 = 0;
            i3 = i4;
            while (i3 < this.c.size()) {
                obj = this.c.get(i3);
                if ((RecyclerView.e0)obj != null && obj.mPosition >= i) {
                }
                i3++;
                if (obj.mPosition >= i) {
                }
                (RecyclerView.e0)obj.offsetPosition(i2, i4);
            }
        }

        void v(int i, int i2) {
            int i6;
            int i3;
            int i4;
            int i5;
            Object obj;
            int mPosition;
            if (i < i2) {
                i6 = -1;
                i3 = i;
                i4 = i2;
            } else {
                i6 = 1;
                i4 = i;
                i3 = i2;
            }
            final int i7 = 0;
            i5 = i7;
            while (i5 < this.c.size()) {
                obj = this.c.get(i5);
                mPosition = obj.mPosition;
                if ((RecyclerView.e0)obj != null && mPosition >= i3) {
                }
                i5++;
                mPosition = obj.mPosition;
                if (mPosition >= i3) {
                }
                if (mPosition > i4) {
                } else {
                }
                if (mPosition == i) {
                } else {
                }
                (RecyclerView.e0)obj.offsetPosition(i6, i7);
                obj.offsetPosition(i2 - i, i7);
            }
        }

        void w(int i, int i2, boolean z3) {
            int i3;
            Object obj;
            int mPosition;
            size--;
            while (i3 >= 0) {
                obj = this.c.get(i3);
                if ((RecyclerView.e0)obj != null) {
                }
                i3--;
                mPosition = obj.mPosition;
                if (mPosition >= i + i2) {
                } else {
                }
                if (mPosition >= i) {
                }
                (RecyclerView.e0)obj.addFlags(8);
                A(i3);
                obj.offsetPosition(-i2, z3);
            }
        }

        void x(androidx.recyclerview.widget.RecyclerView.h recyclerView$h, androidx.recyclerview.widget.RecyclerView.h recyclerView$h2, boolean z3) {
            c();
            i().h(h, h2, z3);
        }

        void y(View view) {
            final androidx.recyclerview.widget.RecyclerView.e0 obj2 = RecyclerView.k0(view);
            obj2.mScrapContainer = 0;
            obj2.mInChangeScrap = false;
            obj2.clearReturnedFromScrapFlag();
            C(obj2);
        }

        void z() {
            int i;
            boolean z;
            size--;
            while (i >= 0) {
                A(i);
                i--;
            }
            this.c.clear();
            if (RecyclerView.Y0) {
                view.z0.b();
            }
        }
    }

    public interface x {
        public abstract void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);
    }

    class d implements androidx.recyclerview.widget.b0.b {

        final androidx.recyclerview.widget.RecyclerView a;
        d(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // androidx.recyclerview.widget.b0$b
        public void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            androidx.recyclerview.widget.RecyclerView view = this.a;
            view.E.H1(e0.itemView, view.b);
        }

        @Override // androidx.recyclerview.widget.b0$b
        public void b(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
            this.a.m(e0, c2, c3);
        }

        @Override // androidx.recyclerview.widget.b0$b
        public void c(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
            view.b.J(e0);
            this.a.o(e0, c2, c3);
        }

        @Override // androidx.recyclerview.widget.b0$b
        public void d(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
            androidx.recyclerview.widget.RecyclerView.m view;
            boolean obj3;
            e0.setIsRecyclable(false);
            androidx.recyclerview.widget.RecyclerView view2 = this.a;
            if (view2.W) {
                if (view2.i0.animateChange(e0, e0, c2, c3)) {
                    this.a.T0();
                }
            } else {
                if (view2.i0.animatePersistence(e0, c2, c3)) {
                    this.a.T0();
                }
            }
        }
    }

    class e implements androidx.recyclerview.widget.f.b {

        final androidx.recyclerview.widget.RecyclerView a;
        e(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // androidx.recyclerview.widget.f$b
        public View a(int i) {
            return this.a.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.f$b
        public void b(View view) {
            androidx.recyclerview.widget.RecyclerView view2;
            final androidx.recyclerview.widget.RecyclerView.e0 obj2 = RecyclerView.k0(view);
            if (obj2 != null) {
                obj2.onEnteredHiddenState(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.f$b
        public void c() {
            int i;
            View view;
            androidx.recyclerview.widget.RecyclerView view2;
            i = 0;
            while (i < getChildCount()) {
                view = a(i);
                this.a.B(view);
                view.clearAnimation();
                i++;
            }
            this.a.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.f$b
        public int d(View view) {
            return this.a.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.f$b
        public androidx.recyclerview.widget.RecyclerView.e0 e(View view) {
            return RecyclerView.k0(view);
        }

        @Override // androidx.recyclerview.widget.f$b
        public void f(int i) {
            Object view;
            int i2;
            boolean tmpDetached;
            view = a(i);
            view = RecyclerView.k0(view);
            if (view != null && view != null && view.isTmpDetached()) {
                view = RecyclerView.k0(view);
                if (view != null) {
                    if (view.isTmpDetached()) {
                        if (!view.shouldIgnore()) {
                        } else {
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("called detach on an already detached child ");
                        stringBuilder.append(view);
                        stringBuilder.append(this.a.R());
                        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
                        throw obj4;
                    }
                    view.addFlags(256);
                }
            }
            RecyclerView.d(this.a, i);
        }

        @Override // androidx.recyclerview.widget.f$b
        public void g(View view) {
            androidx.recyclerview.widget.RecyclerView view2;
            final androidx.recyclerview.widget.RecyclerView.e0 obj2 = RecyclerView.k0(view);
            if (obj2 != null) {
                obj2.onLeftHiddenState(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.f$b
        public int getChildCount() {
            return this.a.getChildCount();
        }

        @Override // androidx.recyclerview.widget.f$b
        public void h(View view, int i2) {
            this.a.addView(view, i2);
            this.a.A(view);
        }

        @Override // androidx.recyclerview.widget.f$b
        public void i(int i) {
            androidx.recyclerview.widget.RecyclerView view;
            View childAt = this.a.getChildAt(i);
            if (childAt != null) {
                this.a.B(childAt);
                childAt.clearAnimation();
            }
            this.a.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.f$b
        public void j(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
            boolean tmpDetached;
            androidx.recyclerview.widget.RecyclerView.e0 view2 = RecyclerView.k0(view);
            if (view2 != null && !view2.isTmpDetached()) {
                if (!view2.isTmpDetached()) {
                    if (!view2.shouldIgnore()) {
                    } else {
                    }
                    StringBuilder obj4 = new StringBuilder();
                    obj4.append("Called attach on a child which is not detached: ");
                    obj4.append(view2);
                    obj4.append(this.a.R());
                    IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
                    throw obj3;
                }
                view2.clearTmpDetachFlag();
            }
            RecyclerView.c(this.a, view, i2, layoutParams3);
        }
    }

    class f implements androidx.recyclerview.widget.a.a {

        final androidx.recyclerview.widget.RecyclerView a;
        f(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // androidx.recyclerview.widget.a$a
        public void a(int i, int i2) {
            this.a.J0(i, i2);
            obj2.D0 = true;
        }

        @Override // androidx.recyclerview.widget.a$a
        public void b(androidx.recyclerview.widget.a.b a$b) {
            i(b);
        }

        @Override // androidx.recyclerview.widget.a$a
        public void c(int i, int i2, Object object3) {
            this.a.F1(i, i2, object3);
            obj2.E0 = true;
        }

        @Override // androidx.recyclerview.widget.a$a
        public void d(androidx.recyclerview.widget.a.b a$b) {
            i(b);
        }

        @Override // androidx.recyclerview.widget.a$a
        public androidx.recyclerview.widget.RecyclerView.e0 e(int i) {
            final androidx.recyclerview.widget.RecyclerView.e0 obj4 = this.a.c0(i, true);
            int i2 = 0;
            if (obj4 == null) {
                return i2;
            }
            if (view2.w.n(obj4.itemView)) {
                return i2;
            }
            return obj4;
        }

        @Override // androidx.recyclerview.widget.a$a
        public void f(int i, int i2) {
            this.a.K0(i, i2, false);
            obj3.D0 = true;
        }

        @Override // androidx.recyclerview.widget.a$a
        public void g(int i, int i2) {
            this.a.I0(i, i2);
            obj2.D0 = true;
        }

        @Override // androidx.recyclerview.widget.a$a
        public void h(int i, int i2) {
            final int i5 = 1;
            this.a.K0(i, i2, i5);
            androidx.recyclerview.widget.RecyclerView obj3 = this.a;
            obj3.D0 = i5;
            obj3 = obj3.A0;
            obj3.d = i3 += i2;
        }

        @Override // androidx.recyclerview.widget.a$a
        void i(androidx.recyclerview.widget.a.b a$b) {
            androidx.recyclerview.widget.RecyclerView i;
            androidx.recyclerview.widget.RecyclerView.p i3;
            int i4;
            int i2;
            int obj5;
            i = b.a;
            i3 = 1;
            if (i != i3) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                        } else {
                            i = this.a;
                            i.E.n1(i, b.b, b.d, i3);
                        }
                    } else {
                        i = this.a;
                        i.E.q1(i, b.b, b.d, b.c);
                    }
                } else {
                    i = this.a;
                    i.E.o1(i, b.b, b.d);
                }
            } else {
                i = this.a;
                i.E.l1(i, b.b, b.d);
            }
        }
    }

    private class n implements androidx.recyclerview.widget.RecyclerView.m.b {

        final androidx.recyclerview.widget.RecyclerView a;
        n(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$m$b
        public void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
            androidx.recyclerview.widget.RecyclerView.e0 mShadowingHolder;
            boolean beKeptAsChild;
            int itemView;
            Object obj3;
            e0.setIsRecyclable(true);
            itemView = 0;
            if (e0.mShadowedHolder != null && e0.mShadowingHolder == null) {
                if (e0.mShadowingHolder == null) {
                    e0.mShadowedHolder = itemView;
                }
            }
            e0.mShadowingHolder = itemView;
            if (!e0.shouldBeKeptAsChild() && !this.a.c1(e0.itemView) && e0.isTmpDetached()) {
                if (!this.a.c1(e0.itemView)) {
                    if (e0.isTmpDetached()) {
                        this.a.removeDetachedView(e0.itemView, false);
                    }
                }
            }
        }
    }

    private class y extends androidx.recyclerview.widget.RecyclerView.j {

        final androidx.recyclerview.widget.RecyclerView a;
        y(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = recyclerView;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        void a() {
            androidx.recyclerview.widget.RecyclerView view;
            Runnable runnable;
            boolean z;
            view = this.a;
            if (RecyclerView.X0 && view.L && view.K) {
                view = this.a;
                if (view.L) {
                    if (view.K) {
                        u.d0(view, view.z);
                    } else {
                        view = this.a;
                        view.T = true;
                        view.requestLayout();
                    }
                } else {
                }
            } else {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onChanged() {
            boolean z;
            this.a.p(0);
            androidx.recyclerview.widget.RecyclerView view2 = this.a;
            final int i2 = 1;
            a0.g = i2;
            view2.W0(i2);
            if (!view3.v.p()) {
                this.a.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeChanged(int i, int i2, Object object3) {
            this.a.p(0);
            if (view2.v.r(i, i2, object3)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeInserted(int i, int i2) {
            this.a.p(0);
            if (view2.v.s(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeMoved(int i, int i2, int i3) {
            this.a.p(0);
            if (view2.v.t(i, i2, i3)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeRemoved(int i, int i2) {
            this.a.p(0);
            if (view2.v.u(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onStateRestorationPolicyChanged() {
            androidx.recyclerview.widget.RecyclerView.h restoreState;
            androidx.recyclerview.widget.RecyclerView view = this.a;
            if (view.c == null) {
            }
            restoreState = view.D;
            if (restoreState != null && restoreState.canRestoreState()) {
                if (restoreState.canRestoreState()) {
                    this.a.requestLayout();
                }
            }
        }
    }

    public static class z extends a {

        public static final Parcelable.Creator<androidx.recyclerview.widget.RecyclerView.z> CREATOR;
        Parcelable c;
        static {
            RecyclerView.z.a aVar = new RecyclerView.z.a();
            RecyclerView.z.CREATOR = aVar;
        }

        z(Parcel parcel, java.lang.ClassLoader classLoader2) {
            java.lang.ClassLoader obj2;
            super(parcel, classLoader2);
            if (classLoader2 != null) {
            } else {
                obj2 = RecyclerView.p.class.getClassLoader();
            }
            this.c = parcel.readParcelable(obj2);
        }

        z(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        void b(androidx.recyclerview.widget.RecyclerView.z recyclerView$z) {
            this.c = z.c;
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.c, 0);
        }
    }
    static {
        int i;
        int i2 = 1;
        int[] iArr = new int[i2];
        final int i21 = 0;
        iArr[i21] = 16843830;
        RecyclerView.U0 = iArr;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT != 18 && sDK_INT != 19 && sDK_INT == 20) {
            if (sDK_INT != 19) {
                if (sDK_INT != 20) {
                    int i9 = i21;
                }
            }
        }
        int i10 = i2;
        if (sDK_INT >= 23) {
            int i12 = i2;
        }
        int i13 = i21;
        if (sDK_INT >= 16) {
            int i20 = i2;
        }
        int i15 = i21;
        if (sDK_INT >= 21) {
            int i19 = i2;
        }
        int i17 = i21;
        int i18 = 15;
        if (sDK_INT <= i18) {
            int i22 = i2;
        }
        int i23 = i21;
        if (sDK_INT <= i18) {
            int i5 = i2;
        }
        int i6 = i21;
        Class[] arr = new Class[4];
        arr[i21] = Context.class;
        arr[i2] = AttributeSet.class;
        Class tYPE = Integer.TYPE;
        arr[2] = tYPE;
        arr[3] = tYPE;
        RecyclerView.b1 = arr;
        RecyclerView.c cVar = new RecyclerView.c();
        RecyclerView.c1 = cVar;
    }

    public RecyclerView(Context context) {
        super(context, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet2, int i3) {
        int i4;
        boolean drawable3;
        int styledAttributes;
        int boolean;
        androidx.recyclerview.widget.k.b bVar;
        int i2;
        int drawable4;
        Object drawable2;
        Object view;
        int[] drawable;
        Context context2;
        Object string;
        Object set;
        int i;
        int i5;
        super(context, attributeSet2, i3);
        RecyclerView.y yVar = new RecyclerView.y(this);
        this.a = yVar;
        RecyclerView.w wVar = new RecyclerView.w(this);
        this.b = wVar;
        b0 b0Var = new b0();
        this.x = b0Var;
        RecyclerView.a aVar = new RecyclerView.a(this);
        this.z = aVar;
        Rect rect = new Rect();
        this.A = rect;
        Rect rect2 = new Rect();
        this.B = rect2;
        RectF rectF = new RectF();
        this.C = rectF;
        ArrayList arrayList = new ArrayList();
        this.G = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.H = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.I = arrayList3;
        int i6 = 0;
        this.O = i6;
        this.W = i6;
        this.a0 = i6;
        this.b0 = i6;
        this.c0 = i6;
        RecyclerView.l lVar = new RecyclerView.l();
        this.d0 = lVar;
        g gVar = new g();
        this.i0 = gVar;
        this.j0 = i6;
        i4 = -1;
        this.k0 = i4;
        int i10 = 1;
        this.u0 = i10;
        this.v0 = i10;
        boolean = 1;
        this.w0 = boolean;
        RecyclerView.d0 d0Var = new RecyclerView.d0(this);
        this.x0 = d0Var;
        if (RecyclerView.Y0) {
            bVar = new k.b();
        } else {
            bVar = 0;
        }
        this.z0 = bVar;
        RecyclerView.b0 b0Var2 = new RecyclerView.b0();
        this.A0 = b0Var2;
        this.D0 = i6;
        this.E0 = i6;
        RecyclerView.n nVar = new RecyclerView.n(this);
        this.F0 = nVar;
        this.G0 = i6;
        int i11 = 2;
        this.J0 = new int[i11];
        this.L0 = new int[i11];
        this.M0 = new int[i11];
        this.N0 = new int[i11];
        ArrayList arrayList4 = new ArrayList();
        this.O0 = arrayList4;
        RecyclerView.b bVar2 = new RecyclerView.b(this);
        this.P0 = bVar2;
        this.R0 = i6;
        this.S0 = i6;
        RecyclerView.d dVar = new RecyclerView.d(this);
        this.T0 = dVar;
        setScrollContainer(boolean);
        setFocusableInTouchMode(boolean);
        ViewConfiguration view3 = ViewConfiguration.get(context);
        this.q0 = view3.getScaledTouchSlop();
        this.u0 = v.b(view3, context);
        this.v0 = v.d(view3, context);
        this.s0 = view3.getScaledMinimumFlingVelocity();
        this.t0 = view3.getScaledMaximumFlingVelocity();
        i2 = getOverScrollMode() == i11 ? boolean : i6;
        setWillNotDraw(i2);
        this.i0.setListener(this.F0);
        u0();
        w0();
        v0();
        if (u.z(this) == 0) {
            u.v0(this, boolean);
        }
        this.U = (AccessibilityManager)getContext().getSystemService("accessibility");
        v vVar = new v(this);
        setAccessibilityDelegateCompat(vVar);
        drawable = d.a;
        TypedArray styledAttributes2 = context.obtainStyledAttributes(attributeSet2, drawable, i3, i6);
        u.j0(this, context, drawable, attributeSet2, styledAttributes2, i3, 0);
        if (styledAttributes2.getInt(d.d, i4) == i4) {
            setDescendantFocusability(262144);
        }
        this.y = styledAttributes2.getBoolean(d.c, boolean);
        drawable3 = styledAttributes2.getBoolean(d.e, i6);
        this.M = drawable3;
        if (drawable3 != null) {
            x0((StateListDrawable)styledAttributes2.getDrawable(d.h), styledAttributes2.getDrawable(d.i), (StateListDrawable)styledAttributes2.getDrawable(d.f), styledAttributes2.getDrawable(d.g));
        }
        styledAttributes2.recycle();
        this.x(context, styledAttributes2.getString(d.j), attributeSet2, i3, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            context2 = RecyclerView.U0;
            styledAttributes = context.obtainStyledAttributes(attributeSet2, context2, i3, i6);
            u.j0(this, context, context2, attributeSet2, styledAttributes, i3, 0);
            boolean = styledAttributes.getBoolean(i6, boolean);
            styledAttributes.recycle();
        }
        setNestedScrollingEnabled(boolean);
    }

    private boolean B0(View view, View view2, int i3) {
        int i4;
        int i2;
        Rect bottom;
        int i;
        Rect bottom2;
        int top;
        int right;
        int bottom4;
        int bottom3;
        View obj10;
        View obj11;
        i4 = 0;
        if (view2 != null && view2 != this) {
            if (view2 != this) {
                if (view2 == view) {
                } else {
                    if (U(view2) == null) {
                        return i4;
                    }
                    i2 = 1;
                    if (view == null) {
                        return i2;
                    }
                    if (U(view) == null) {
                        return i2;
                    }
                    this.A.set(i4, i4, view.getWidth(), view.getHeight());
                    this.B.set(i4, i4, view2.getWidth(), view2.getHeight());
                    offsetDescendantRectToMyCoords(view, this.A);
                    offsetDescendantRectToMyCoords(view2, this.B);
                    obj11 = -1;
                    obj10 = this.E.w0() == i2 ? obj11 : i2;
                    bottom = this.A;
                    int left = bottom.left;
                    bottom2 = this.B;
                    int left2 = bottom2.left;
                    if (left >= left2) {
                        if (bottom.right <= left2 && bottom.right < bottom2.right) {
                            if (bottom.right < bottom2.right) {
                                i = i2;
                            } else {
                                bottom4 = bottom2.right;
                                if (bottom.right <= bottom4) {
                                    if (left >= bottom4 && left > left2) {
                                        i = left > left2 ? obj11 : i4;
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    top = bottom.top;
                    right = bottom2.top;
                    if (top >= right) {
                        if (bottom.bottom <= right && bottom.bottom < bottom2.bottom) {
                            if (bottom.bottom < bottom2.bottom) {
                                obj11 = i2;
                            } else {
                                bottom2 = bottom2.bottom;
                                if (bottom.bottom <= bottom2) {
                                    if (top >= bottom2 && top > right) {
                                        if (top > right) {
                                        } else {
                                            obj11 = i4;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i3 != i2 && i3 != 2 && i3 != 17 && i3 != 33 && i3 != 66) {
                        if (i3 != 2) {
                            if (i3 != 17) {
                                if (i3 != 33) {
                                    if (i3 != 66) {
                                        if (i3 != 130) {
                                        } else {
                                            if (obj11 > 0) {
                                                i4 = i2;
                                            }
                                            return i4;
                                        }
                                        obj11 = new StringBuilder();
                                        obj11.append("Invalid direction: ");
                                        obj11.append(i3);
                                        obj11.append(R());
                                        obj10 = new IllegalArgumentException(obj11.toString());
                                        throw obj10;
                                    }
                                    if (i > 0) {
                                        i4 = i2;
                                    }
                                    return i4;
                                }
                                if (obj11 < 0) {
                                    i4 = i2;
                                }
                                return i4;
                            }
                            if (i < 0) {
                                i4 = i2;
                            }
                            return i4;
                        }
                        if (obj11 <= 0) {
                            if (obj11 == null && i *= obj10 > 0) {
                                if (i *= obj10 > 0) {
                                    i4 = i2;
                                }
                            }
                        } else {
                        }
                        return i4;
                    }
                    if (obj11 >= 0) {
                        if (obj11 == null && i *= obj10 < 0) {
                            if (i *= obj10 < 0) {
                                i4 = i2;
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return i4;
    }

    private void C() {
        int obtain;
        int i;
        final int i2 = this.S;
        this.S = 0;
        if (i2 != 0 && z0()) {
            if (z0()) {
                obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                b.b(obtain, i2);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    private void E() {
        boolean z;
        boolean z2;
        int i;
        int itemCount;
        boolean z3;
        boolean recordPreLayoutInformation;
        int adapterChangeFlagsForAnimations;
        boolean anyOfTheFlags;
        androidx.recyclerview.widget.b0 b0Var;
        int adapterChangeFlagsForAnimations2;
        List unmodifiedPayloads;
        this.A0.a(1);
        S(this.A0);
        final int i3 = 0;
        a03.j = i3;
        z1();
        this.x.f();
        N0();
        V0();
        m1();
        androidx.recyclerview.widget.RecyclerView.b0 a04 = this.A0;
        if (a04.k && this.E0) {
            if (this.E0) {
            } else {
                i = i3;
            }
        } else {
        }
        a04.i = i;
        this.E0 = i3;
        this.D0 = i3;
        a04.h = a04.l;
        a04.f = this.D.getItemCount();
        X(this.J0);
        if (a05.k) {
            itemCount = i3;
            while (itemCount < this.w.g()) {
                recordPreLayoutInformation = RecyclerView.k0(this.w.f(itemCount));
                if (!recordPreLayoutInformation.shouldIgnore()) {
                }
                itemCount++;
                if (recordPreLayoutInformation.isInvalid() && !this.D.hasStableIds()) {
                } else {
                }
                b0Var = this.x;
                b0Var.e(recordPreLayoutInformation, this.i0.recordPreLayoutInformation(this.A0, recordPreLayoutInformation, RecyclerView.m.buildAdapterChangeFlagsForAnimations(recordPreLayoutInformation), recordPreLayoutInformation.getUnmodifiedPayloads()));
                if (a010.i && recordPreLayoutInformation.isUpdated() && !recordPreLayoutInformation.isRemoved() && !recordPreLayoutInformation.shouldIgnore() && !recordPreLayoutInformation.isInvalid()) {
                }
                if (recordPreLayoutInformation.isUpdated()) {
                }
                if (!recordPreLayoutInformation.isRemoved()) {
                }
                if (!recordPreLayoutInformation.shouldIgnore()) {
                }
                if (!recordPreLayoutInformation.isInvalid()) {
                }
                this.x.c(f0(recordPreLayoutInformation), b0Var);
                if (!this.D.hasStableIds()) {
                } else {
                }
            }
        }
        if (a06.l) {
            n1();
            androidx.recyclerview.widget.RecyclerView.b0 a08 = this.A0;
            a08.g = i3;
            this.E.r1(this.b, a08);
            a09.g = a08.g;
            z2 = i3;
            while (z2 < this.w.g()) {
                z3 = RecyclerView.k0(this.w.f(z2));
                if (z3.shouldIgnore()) {
                } else {
                }
                anyOfTheFlags = z3.hasAnyOfTheFlags(8192);
                if (!this.x.i(z3) && !anyOfTheFlags) {
                }
                z2++;
                anyOfTheFlags = z3.hasAnyOfTheFlags(8192);
                if (!anyOfTheFlags) {
                }
                recordPreLayoutInformation = this.i0.recordPreLayoutInformation(this.A0, z3, adapterChangeFlagsForAnimations, z3.getUnmodifiedPayloads());
                if (anyOfTheFlags) {
                } else {
                }
                this.x.a(z3, recordPreLayoutInformation);
                Y0(z3, recordPreLayoutInformation);
                adapterChangeFlagsForAnimations |= 4096;
            }
            t();
        } else {
            t();
        }
        O0();
        B1(i3);
        a07.e = 2;
    }

    private void E1() {
        this.x0.f();
        androidx.recyclerview.widget.RecyclerView.p view2 = this.E;
        if (view2 != null) {
            view2.g2();
        }
    }

    private void F() {
        androidx.recyclerview.widget.RecyclerView.z restoreState;
        androidx.recyclerview.widget.RecyclerView.p view;
        int i;
        boolean z;
        z1();
        N0();
        this.A0.a(6);
        this.v.j();
        a02.f = this.D.getItemCount();
        int i3 = 0;
        a03.d = i3;
        Parcelable parcelable = view3.c;
        if (this.c != null && this.D.canRestoreState() && parcelable != null) {
            if (this.D.canRestoreState()) {
                parcelable = view3.c;
                if (parcelable != null) {
                    this.E.w1(parcelable);
                }
                this.c = 0;
            }
        }
        androidx.recyclerview.widget.RecyclerView.b0 a04 = this.A0;
        a04.h = i3;
        this.E.r1(this.b, a04);
        androidx.recyclerview.widget.RecyclerView.b0 a05 = this.A0;
        a05.g = i3;
        if (a05.k && this.i0 != null) {
            i = this.i0 != null ? 1 : i3;
        } else {
        }
        a05.k = i;
        a05.e = 4;
        O0();
        B1(i3);
    }

    private void F0(int i, int i2, MotionEvent motionEvent3, int i4) {
        int i6;
        int i8;
        int i9;
        int i5;
        boolean z;
        Object obj;
        int i7;
        int i3;
        int obj12;
        int obj13;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        if (this.Q) {
        }
        int[] n0 = this.N0;
        i8 = 0;
        n0[i8] = i8;
        i9 = 1;
        n0[i9] = i8;
        boolean z2 = view.H();
        boolean z4 = this.E.I();
        i5 = z2 ? i9 : i8;
        if (z4) {
            i5 |= 2;
        }
        A1(i5, i4);
        i7 = z2 ? i : i8;
        i3 = z4 ? i2 : i8;
        if (this.H(i7, i3, this.N0, this.L0, i4)) {
            z = this.N0;
            i -= obj;
            i2 -= i9;
        }
        i6 = z2 ? obj12 : i8;
        if (z4) {
            i8 = obj13;
        }
        o1(i6, i8, motionEvent3, i4);
        final androidx.recyclerview.widget.k obj14 = this.y0;
        if (obj14 != null) {
            if (obj12 == null) {
                if (obj13 != null) {
                    obj14.f(this, obj12, obj13);
                }
            } else {
            }
        }
        C1(i4);
    }

    private void G() {
        int i;
        boolean z2;
        Object view4;
        boolean ignore;
        androidx.recyclerview.widget.RecyclerView.e0 view5;
        androidx.recyclerview.widget.b0 recordPostLayoutInformation;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        androidx.recyclerview.widget.RecyclerView.e0 view2;
        androidx.recyclerview.widget.RecyclerView.m.c ignore2;
        boolean z;
        boolean z3;
        androidx.recyclerview.widget.RecyclerView.m.c view3;
        this.A0.a(4);
        z1();
        N0();
        androidx.recyclerview.widget.RecyclerView.b0 a02 = this.A0;
        int i5 = 1;
        a02.e = i5;
        if (a02.k) {
            i2 -= i5;
            while (i >= 0) {
                view = RecyclerView.k0(this.w.f(i));
                if (view.shouldIgnore()) {
                } else {
                }
                ignore = f0(view);
                recordPostLayoutInformation = this.i0.recordPostLayoutInformation(this.A0, view);
                view2 = this.x.g(ignore);
                if (view2 != null && !view2.shouldIgnore()) {
                } else {
                }
                this.x.d(view, recordPostLayoutInformation);
                i--;
                if (!view2.shouldIgnore()) {
                } else {
                }
                z = this.x.h(view2);
                if (z && view2 == view) {
                } else {
                }
                ignore2 = this.x.n(view2);
                this.x.d(view, recordPostLayoutInformation);
                if (ignore2 == null) {
                } else {
                }
                this.n(view2, view, ignore2, this.x.m(view), z, this.x.h(view));
                r0(ignore, view5, view);
                if (view2 == view) {
                } else {
                }
                this.x.d(view, recordPostLayoutInformation);
            }
            this.x.o(this.T0);
        }
        this.E.G1(this.b);
        androidx.recyclerview.widget.RecyclerView.b0 a03 = this.A0;
        a03.c = a03.f;
        int i7 = 0;
        this.W = i7;
        this.a0 = i7;
        a03.k = i7;
        a03.l = i7;
        view7.h = i7;
        ArrayList list = view8.b;
        if (list != null) {
            list.clear();
        }
        view4 = this.E;
        if (view4.n) {
            view4.m = i7;
            view4.n = i7;
            this.b.K();
        }
        this.E.s1(this.A0);
        O0();
        B1(i7);
        this.x.f();
        int[] j0 = this.J0;
        if (z(j0[i7], j0[i5])) {
            K(i7, i7);
        }
        Z0();
        k1();
    }

    private boolean M(MotionEvent motionEvent) {
        int obj3;
        androidx.recyclerview.widget.RecyclerView.t view = this.J;
        if (view == null && motionEvent.getAction() == 0) {
            if (motionEvent.getAction() == 0) {
                return 0;
            }
            return W(motionEvent);
        }
        view.a(this, motionEvent);
        obj3 = motionEvent.getAction();
        final int i2 = 1;
        if (obj3 != 3) {
            if (obj3 == i2) {
                this.J = 0;
            }
        } else {
        }
        return i2;
    }

    private void Q0(MotionEvent motionEvent) {
        int actionIndex;
        int pointerId;
        int i;
        int obj4;
        actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.k0) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.k0 = motionEvent.getPointerId(actionIndex);
            i = 1056964608;
            pointerId = (int)i2;
            this.o0 = pointerId;
            this.m0 = pointerId;
            obj4 = (int)obj4;
            this.p0 = obj4;
            this.n0 = obj4;
        }
    }

    private boolean U0() {
        androidx.recyclerview.widget.RecyclerView.m view;
        int i;
        if (this.i0 != null && this.E.h2()) {
            i = this.E.h2() ? 1 : 0;
        } else {
        }
        return i;
    }

    private void V0() {
        boolean z2;
        androidx.recyclerview.widget.a aVar;
        int i2;
        boolean z;
        int i;
        int i3;
        boolean stableIds;
        boolean z3;
        this.v.y();
        if (this.W && this.a0) {
            this.v.y();
            if (this.a0) {
                this.E.m1(this);
            }
        }
        if (U0()) {
            this.v.w();
        } else {
            this.v.j();
        }
        i = 0;
        final int i4 = 1;
        if (!this.D0) {
            if (this.E0) {
                i2 = i4;
            } else {
                i2 = i;
            }
        } else {
        }
        if (this.N && this.i0 != null) {
            if (this.i0 != null) {
                stableIds = this.W;
                if (!stableIds && i2 == 0) {
                    if (i2 == 0) {
                        if (view2.h) {
                            if (stableIds) {
                                i3 = this.D.hasStableIds() ? i4 : i;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        a0.k = i3;
        androidx.recyclerview.widget.RecyclerView.b0 a02 = this.A0;
        if (a02.k && i2 != 0 && !this.W && U0()) {
            if (i2 != 0) {
                if (!this.W) {
                    if (U0()) {
                        i = i4;
                    }
                }
            }
        }
        a02.l = i;
    }

    private boolean W(MotionEvent motionEvent) {
        int i;
        Object obj;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < this.I.size()) {
            obj = this.I.get(i);
            i++;
        }
        return i2;
    }

    private void X(int[] iArr) {
        int i;
        int i2;
        int i3;
        int layoutPosition;
        boolean ignore;
        int i4 = this.w.g();
        final int i6 = 1;
        final int i7 = 0;
        if (i4 == 0) {
            int i5 = -1;
            iArr[i7] = i5;
            iArr[i6] = i5;
        }
        i = Integer.MAX_VALUE;
        i2 = Integer.MIN_VALUE;
        i3 = i7;
        while (i3 < i4) {
            layoutPosition = RecyclerView.k0(this.w.f(i3));
            if (layoutPosition.shouldIgnore()) {
            } else {
            }
            layoutPosition = layoutPosition.getLayoutPosition();
            if (layoutPosition < i) {
            }
            if (layoutPosition > i2) {
            }
            i3++;
            i2 = layoutPosition;
            i = layoutPosition;
        }
        iArr[i7] = i;
        iArr[i6] = i2;
    }

    private void X0(float f, float f2, float f3, float f4) {
        int cmp2;
        int cmp;
        float i;
        int i2;
        int i3;
        float f5;
        int obj7;
        int obj9;
        final int i4 = 0;
        i = 1065353216;
        if (Float.compare(f2, i4) < 0) {
            O();
            f.a(this.e0, i6 /= f9, i - obj9);
            obj9 = i2;
        } else {
        }
        if (Float.compare(f4, i4) < 0) {
            Q();
            f.a(this.f0, i5 /= f7, f /= i);
        } else {
            if (Float.compare(f4, i4) > 0) {
                N();
                f.a(this.h0, f4 / f6, i -= obj7);
            } else {
                i2 = obj9;
            }
        }
        if (i2 == 0 && Float.compare(f2, i4) == 0) {
            if (Float.compare(f2, i4) == 0) {
                if (Float.compare(f4, i4) != 0) {
                    u.c0(this);
                }
            } else {
            }
        } else {
        }
    }

    static androidx.recyclerview.widget.RecyclerView Y(View view) {
        int i;
        androidx.recyclerview.widget.RecyclerView view2;
        final int i2 = 0;
        if (!view instanceof ViewGroup) {
            return i2;
        }
        if (view instanceof RecyclerView != null) {
            return (RecyclerView)view;
        }
        i = 0;
        while (i < (ViewGroup)view.getChildCount()) {
            view2 = RecyclerView.Y(view.getChildAt(i));
            i++;
        }
        return i2;
    }

    private View Z() {
        int i2;
        int focusable2;
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean focusable;
        androidx.recyclerview.widget.RecyclerView.b0 a0 = this.A0;
        if (a0.m != -1) {
        } else {
            focusable2 = 0;
        }
        int i3 = a0.c();
        i = focusable2;
        while (i < i3) {
            view = a0(i);
            i++;
        }
        i4--;
        int i5 = 0;
        while (i2 >= 0) {
            i = a0(i2);
            i2--;
            i5 = 0;
        }
        return i5;
    }

    private void Z0() {
        int descendantFocusability;
        boolean focused;
        int stableIds;
        int itemView2;
        int focusable;
        long focusable2;
        View itemView;
        if (this.w0 && this.D != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (this.D != null) {
                if (hasFocus()) {
                    if (getDescendantFocusability() != 393216) {
                        if (getDescendantFocusability() == 131072 && isFocused()) {
                            if (isFocused()) {
                            } else {
                                if (!isFocused()) {
                                    View focusedChild = getFocusedChild();
                                    if (RecyclerView.a1) {
                                        if (focusedChild.getParent() != null) {
                                            if (!focusedChild.hasFocus()) {
                                                if (this.w.g() == 0) {
                                                    requestFocus();
                                                }
                                            } else {
                                                if (!this.w.n(focusedChild)) {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                }
                                focusable = -1;
                                if (Long.compare(l, focusable) != 0 && this.D.hasStableIds()) {
                                    if (this.D.hasStableIds()) {
                                        descendantFocusability = b0(a02.n);
                                    } else {
                                        descendantFocusability = itemView2;
                                    }
                                } else {
                                }
                                if (descendantFocusability != 0 && !this.w.n(descendantFocusability.itemView)) {
                                    if (!this.w.n(descendantFocusability.itemView)) {
                                        if (!descendantFocusability.itemView.hasFocusable()) {
                                            if (this.w.g() > 0) {
                                                itemView2 = Z();
                                            }
                                        } else {
                                            itemView2 = descendantFocusability.itemView;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                                descendantFocusability = a03.o;
                                descendantFocusability = itemView2.findViewById(descendantFocusability);
                                if (itemView2 != 0 && Long.compare(focusable2, focusable) != 0 && descendantFocusability != null && descendantFocusability.isFocusable()) {
                                    descendantFocusability = a03.o;
                                    if (Long.compare(focusable2, focusable) != 0) {
                                        descendantFocusability = itemView2.findViewById(descendantFocusability);
                                        if (descendantFocusability != null) {
                                            if (descendantFocusability.isFocusable()) {
                                                itemView2 = descendantFocusability;
                                            }
                                        }
                                    }
                                    itemView2.requestFocus();
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
    }

    private void a1() {
        int finished2;
        EdgeEffect finished3;
        EdgeEffect finished;
        EdgeEffect finished4;
        EdgeEffect edgeEffect = this.e0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            finished2 = this.e0.isFinished();
        } else {
            finished2 = 0;
        }
        finished3 = this.f0;
        if (finished3 != null) {
            finished3.onRelease();
            finished2 |= finished3;
        }
        finished = this.g0;
        if (finished != null) {
            finished.onRelease();
            finished2 |= finished;
        }
        finished4 = this.h0;
        if (finished4 != null) {
            finished4.onRelease();
            finished2 |= finished4;
        }
        if (finished2 != 0) {
            u.c0(this);
        }
    }

    static void c(androidx.recyclerview.widget.RecyclerView recyclerView, View view2, int i3, ViewGroup.LayoutParams viewGroup$LayoutParams4) {
        recyclerView.attachViewToParent(view2, i3, layoutParams4);
    }

    static void d(androidx.recyclerview.widget.RecyclerView recyclerView, int i2) {
        recyclerView.detachViewFromParent(i2);
    }

    static boolean e(androidx.recyclerview.widget.RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    static void f(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        recyclerView.setMeasuredDimension(i2, i3);
    }

    private void g(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int i;
        Object layoutParams;
        androidx.recyclerview.widget.f obj6;
        final View itemView = e0.itemView;
        final int i2 = 1;
        i = itemView.getParent() == this ? i2 : 0;
        this.b.J(j0(itemView));
        if (e0.isTmpDetached()) {
            this.w.c(itemView, -1, itemView.getLayoutParams(), i2);
        } else {
            if (i == 0) {
                this.w.b(itemView, i2);
            } else {
                this.w.k(itemView);
            }
        }
    }

    private l getScrollingChildHelper() {
        l lVar;
        if (this.K0 == null) {
            lVar = new l(this);
            this.K0 = lVar;
        }
        return this.K0;
    }

    private void j1(View view, View view2) {
        View view3;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        int width;
        int height;
        int i;
        view3 = view2 != null ? view2 : view;
        final int i6 = 0;
        this.A.set(i6, i6, view3.getWidth(), view3.getHeight());
        layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof RecyclerView.q && !layoutParams.c) {
            if (!layoutParams.c) {
                Rect rect2 = layoutParams.b;
                z = this.A;
                z.left = left -= left2;
                z.right = right += right2;
                z.top = top -= height;
                z.bottom = bottom += layoutParams;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.A);
            offsetRectIntoDescendantCoords(view, this.A);
        }
        i = view2 == null ? i2 : i6;
        this.E.N1(this, view, this.A, z2 ^ 1, i);
    }

    static androidx.recyclerview.widget.RecyclerView.e0 k0(View view) {
        if (view == null) {
            return null;
        }
        return obj0.a;
    }

    private void k1() {
        final androidx.recyclerview.widget.RecyclerView.b0 a0 = this.A0;
        a0.n = -1;
        int i2 = -1;
        a0.m = i2;
        a0.o = i2;
    }

    private void l1() {
        VelocityTracker velocityTracker = this.l0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        C1(0);
        a1();
    }

    static void m0(View view, Rect rect2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Rect rect = layoutParams.b;
        rect2.set(i -= leftMargin, i3 -= topMargin, i5 += rightMargin, obj6 += bottomMargin);
    }

    private void m1() {
        boolean focus;
        View focusedChild;
        int i;
        long itemId;
        int absoluteAdapterPosition;
        if (this.w0 && hasFocus() && this.D != null) {
            if (hasFocus()) {
                if (this.D != null) {
                    focusedChild = getFocusedChild();
                } else {
                    focusedChild = i;
                }
            } else {
            }
        } else {
        }
        if (focusedChild == null) {
        } else {
            i = V(focusedChild);
        }
        if (i == 0) {
            k1();
        } else {
            if (this.D.hasStableIds()) {
                itemId = i.getItemId();
            } else {
                itemId = -1;
            }
            a0.n = itemId;
            if (this.W) {
                absoluteAdapterPosition = -1;
            } else {
                if (i.isRemoved()) {
                    absoluteAdapterPosition = i.mOldPosition;
                } else {
                    absoluteAdapterPosition = i.getAbsoluteAdapterPosition();
                }
            }
            a02.m = absoluteAdapterPosition;
            focusedChild.o = n0(i.itemView);
        }
    }

    private void n(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c4, boolean z5, boolean z6) {
        androidx.recyclerview.widget.RecyclerView.w obj6;
        final int i = 0;
        e0.setIsRecyclable(i);
        if (z5 != null) {
            g(e0);
        }
        if (e0 != e02 && z6) {
            if (z6) {
                g(e02);
            }
            e0.mShadowedHolder = e02;
            g(e0);
            this.b.J(e0);
            e02.setIsRecyclable(i);
            e02.mShadowingHolder = e0;
        }
        if (this.i0.animateChange(e0, e02, c3, c4)) {
            T0();
        }
    }

    private int n0(View view) {
        int i3;
        int i;
        boolean focused;
        int i2;
        Object obj4;
        i3 = view.getId();
        while (!obj4.isFocused()) {
            if (obj4 instanceof ViewGroup) {
            }
            if (obj4.hasFocus()) {
            }
            obj4 = (ViewGroup)obj4.getFocusedChild();
            if (obj4.getId() != -1) {
            }
            i3 = obj4.getId();
        }
        return i3;
    }

    private String o0(Context context, String string2) {
        final int i2 = 46;
        if (string2.charAt(0) == i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        if (string2.contains(".")) {
            return string2;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append(RecyclerView.class.getPackage().getName());
        obj3.append(i2);
        obj3.append(string2);
        return obj3.toString();
    }

    private void r() {
        l1();
        setScrollState(0);
    }

    private void r0(long l, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e03) {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int cmp;
        androidx.recyclerview.widget.RecyclerView.h obj6;
        i = 0;
        while (i < this.w.g()) {
            view = RecyclerView.k0(this.w.f(i));
            i++;
        }
        obj6 = new StringBuilder();
        obj6.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        obj6.append(obj9);
        obj6.append(" cannot be found but it is necessary for ");
        obj6.append(e03);
        obj6.append(R());
        Log.e("RecyclerView", obj6.toString());
    }

    private void r1(androidx.recyclerview.widget.RecyclerView.h recyclerView$h, boolean z2, boolean z3) {
        androidx.recyclerview.widget.RecyclerView.h view2;
        androidx.recyclerview.widget.RecyclerView.y view;
        view2 = this.D;
        if (view2 != null) {
            view2.unregisterAdapterDataObserver(this.a);
            this.D.onDetachedFromRecyclerView(this);
        }
        if (z2) {
            if (z3) {
                b1();
            }
        } else {
        }
        this.v.y();
        androidx.recyclerview.widget.RecyclerView.h obj5 = this.D;
        this.D = h;
        if (h != null) {
            h.registerAdapterDataObserver(this.a);
            h.onAttachedToRecyclerView(this);
        }
        androidx.recyclerview.widget.RecyclerView.p obj3 = this.E;
        if (obj3 != null) {
            obj3.Y0(obj5, this.D);
        }
        this.b.x(obj5, this.D, z2);
        obj3.g = true;
    }

    static void s(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        Object mNestedRecyclerView;
        int i;
        boolean z;
        mNestedRecyclerView = e0.mNestedRecyclerView;
        if (mNestedRecyclerView != null) {
            mNestedRecyclerView = mNestedRecyclerView.get();
            i = 0;
            while (mNestedRecyclerView != null) {
                if (mNestedRecyclerView instanceof View != null) {
                } else {
                }
                mNestedRecyclerView = i;
                i = 0;
            }
            e0.mNestedRecyclerView = i;
        }
    }

    private boolean t0() {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 updated;
        boolean ignore;
        final int i4 = 0;
        i = i4;
        while (i < this.w.g()) {
            updated = RecyclerView.k0(this.w.f(i));
            i++;
        }
        return i4;
    }

    private void v0() {
        int i;
        if (u.A(this) == 0) {
            u.w0(this, 8);
        }
    }

    private void w0() {
        RecyclerView.e eVar = new RecyclerView.e(this);
        f fVar = new f(eVar);
        this.w = fVar;
    }

    private void x(Context context, String string2, AttributeSet attributeSet3, int i4, int i5) {
        String subclass;
        java.lang.ClassLoader classLoader;
        int i;
        Object[] objArr;
        int i2;
        Constructor constructor;
        Object[] arr;
        Object obj8;
        String obj9;
        int obj11;
        final String str = ": Could not instantiate the LayoutManager: ";
        obj9 = string2.trim();
        if (string2 != null && !obj9.isEmpty()) {
            obj9 = string2.trim();
            if (!obj9.isEmpty()) {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                i = 0;
                int i3 = 0;
                i2 = 1;
                constructor = Class.forName(o0(context, obj9), i, classLoader).asSubclass(RecyclerView.p.class).getConstructor(RecyclerView.b1);
                arr = new Object[4];
                arr[i] = context;
                arr[i2] = attributeSet3;
                arr[2] = Integer.valueOf(i4);
                arr[3] = Integer.valueOf(i5);
                constructor.setAccessible(i2);
                setLayoutManager((RecyclerView.p)constructor.newInstance(arr));
            }
        }
    }

    private boolean z(int i, int i2) {
        int i3;
        int obj5;
        X(this.J0);
        int[] j02 = this.J0;
        final int i5 = 1;
        if (j02[0] == i) {
            if (j02[i5] != i2) {
                i3 = i5;
            }
        } else {
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    void A(View view) {
        List list;
        androidx.recyclerview.widget.RecyclerView.h view2;
        androidx.recyclerview.widget.RecyclerView.e0 view3 = RecyclerView.k0(view);
        L0(view);
        view2 = this.D;
        if (view2 != null && view3 != null) {
            if (view3 != null) {
                view2.onViewAttachedToWindow(view3);
            }
        }
        list = this.V;
        if (list != null) {
            size--;
            while (list >= 0) {
                (RecyclerView.r)this.V.get(list).d(view);
                list--;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean A0() {
        int i;
        i = this.b0 > 0 ? 1 : 0;
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean A1(int i, int i2) {
        return getScrollingChildHelper().p(i, i2);
    }

    @Override // android.view.ViewGroup
    void B(View view) {
        List list;
        androidx.recyclerview.widget.RecyclerView.h view2;
        androidx.recyclerview.widget.RecyclerView.e0 view3 = RecyclerView.k0(view);
        M0(view);
        view2 = this.D;
        if (view2 != null && view3 != null) {
            if (view3 != null) {
                view2.onViewDetachedFromWindow(view3);
            }
        }
        list = this.V;
        if (list != null) {
            size--;
            while (list >= 0) {
                (RecyclerView.r)this.V.get(list).b(view);
                list--;
            }
        }
    }

    @Override // android.view.ViewGroup
    void B1(boolean z) {
        boolean z2;
        boolean obj4;
        final int i3 = 1;
        if (this.O < i3) {
            this.O = i3;
        }
        int i2 = 0;
        if (!z && !this.Q) {
            if (!this.Q) {
                this.P = i2;
            }
        }
        if (this.O == i3 && z && this.P && !this.Q && this.E != null && this.D != null) {
            if (z) {
                if (this.P) {
                    if (!this.Q) {
                        if (this.E != null) {
                            if (this.D != null) {
                                D();
                            }
                        }
                    }
                }
            }
            if (!this.Q) {
                this.P = i2;
            }
        }
        this.O = obj4 -= i3;
    }

    @Override // android.view.ViewGroup
    void C0(int i) {
        if (this.E == null) {
        }
        setScrollState(2);
        this.E.S1(i);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup
    public void C1(int i) {
        getScrollingChildHelper().r(i);
    }

    @Override // android.view.ViewGroup
    void D() {
        int i;
        androidx.recyclerview.widget.RecyclerView.p view;
        int i2;
        boolean height;
        int height2;
        String str3 = "RecyclerView";
        if (this.D == null) {
            Log.w(str3, "No adapter attached; skipping layout");
        }
        if (this.E == null) {
            Log.e(str3, "No layout manager attached; skipping layout");
        }
        int i3 = 0;
        a0.j = i3;
        final int i4 = 1;
        if (this.Q0) {
            if (this.R0 == getWidth()) {
                i = this.S0 != getHeight() ? i4 : i3;
            } else {
            }
        } else {
        }
        this.R0 = i3;
        this.S0 = i3;
        this.Q0 = i3;
        if (a02.e == i4) {
            E();
            this.E.V1(this);
            F();
        } else {
            if (!this.v.q() && i == 0 && this.E.H0() == getWidth()) {
                if (i == 0) {
                    if (this.E.H0() == getWidth()) {
                        if (this.E.t0() != getHeight()) {
                            this.E.V1(this);
                            F();
                        } else {
                            this.E.V1(this);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        G();
    }

    @Override // android.view.ViewGroup
    void D0() {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        int i;
        i2 = 0;
        while (i2 < this.w.j()) {
            layoutParams.c = true;
            i2++;
        }
        this.b.s();
    }

    @Override // android.view.ViewGroup
    public void D1() {
        setScrollState(0);
        E1();
    }

    @Override // android.view.ViewGroup
    void E0() {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean ignore;
        i = 0;
        while (i < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i));
            if (view != null && !view.shouldIgnore()) {
            }
            i++;
            if (!view.shouldIgnore()) {
            }
            view.addFlags(6);
        }
        D0();
        this.b.t();
    }

    @Override // android.view.ViewGroup
    void F1(int i, int i2, Object object3) {
        int i3;
        View layoutParams;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int mPosition;
        i3 = 0;
        while (i3 < this.w.j()) {
            layoutParams = this.w.i(i3);
            view = RecyclerView.k0(layoutParams);
            if (view != null) {
            }
            i3++;
            if (view.shouldIgnore()) {
            } else {
            }
            mPosition = view.mPosition;
            if (mPosition >= i && mPosition < i + i2) {
            }
            if (mPosition < i + i2) {
            }
            view.addFlags(2);
            view.addChangePayload(object3);
            layoutParams.c = true;
        }
        this.b.M(i, i2);
    }

    @Override // android.view.ViewGroup
    public void G0(int i) {
        int i2;
        View view;
        i2 = 0;
        while (i2 < this.w.g()) {
            this.w.f(i2).offsetLeftAndRight(i);
            i2++;
        }
    }

    @Override // android.view.ViewGroup
    public boolean H(int i, int i2, int[] i3Arr3, int[] i4Arr4, int i5) {
        return getScrollingChildHelper().d(i, i2, i3Arr3, i4Arr4, i5);
    }

    @Override // android.view.ViewGroup
    public void H0(int i) {
        int i2;
        View view;
        i2 = 0;
        while (i2 < this.w.g()) {
            this.w.f(i2).offsetTopAndBottom(i);
            i2++;
        }
    }

    @Override // android.view.ViewGroup
    public final void I(int i, int i2, int i3, int i4, int[] i5Arr5, int i6, int[] i7Arr7) {
        getScrollingChildHelper().e(i, i2, i3, i4, i5Arr5, i6, i7Arr7);
    }

    @Override // android.view.ViewGroup
    void I0(int i, int i2) {
        int i3;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean mPosition;
        final int i5 = 0;
        i3 = i5;
        while (i3 < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i3));
            if (view != null && !view.shouldIgnore() && view.mPosition >= i) {
            }
            i3++;
            if (!view.shouldIgnore()) {
            }
            if (view.mPosition >= i) {
            }
            view.offsetPosition(i2, i5);
            view.g = true;
        }
        this.b.u(i, i2);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    void J(int i) {
        int i2;
        Object obj;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view != null) {
            view.y1(i);
        }
        R0(i);
        androidx.recyclerview.widget.RecyclerView.u b0 = this.B0;
        if (b0 != null) {
            b0.onScrollStateChanged(this, i);
        }
        i2 = this.C0;
        if (i2 != null) {
            size--;
            while (i2 >= 0) {
                (RecyclerView.u)this.C0.get(i2).onScrollStateChanged(this, i);
                i2--;
            }
        }
    }

    @Override // android.view.ViewGroup
    void J0(int i, int i2) {
        int i4;
        int i3;
        int i5;
        int i6;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int mPosition;
        final int i8 = 1;
        if (i < i2) {
            i4 = -1;
            i3 = i;
            i5 = i2;
        } else {
            i5 = i;
            i3 = i2;
            i4 = i8;
        }
        final int i9 = 0;
        i6 = i9;
        while (i6 < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i6));
            mPosition = view.mPosition;
            if (view != null && mPosition >= i3) {
            }
            i6++;
            mPosition = view.mPosition;
            if (mPosition >= i3) {
            }
            if (mPosition > i5) {
            } else {
            }
            if (mPosition == i) {
            } else {
            }
            view.offsetPosition(i4, i9);
            view.g = i8;
            view.offsetPosition(i2 - i, i9);
        }
        this.b.v(i, i2);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    void K(int i, int i2) {
        int i3;
        int scrollY;
        this.c0 = i4++;
        int scrollX = getScrollX();
        scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        S0(i, i2);
        androidx.recyclerview.widget.RecyclerView.u b0 = this.B0;
        if (b0 != null) {
            b0.onScrolled(this, i, i2);
        }
        i3 = this.C0;
        if (i3 != null) {
            size--;
            while (i3 >= 0) {
                (RecyclerView.u)this.C0.get(i3).onScrolled(this, i, i2);
                i3--;
            }
        }
        this.c0 = obj5--;
    }

    @Override // android.view.ViewGroup
    void K0(int i, int i2, boolean z3) {
        int i4;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean mPosition;
        int i5;
        int i3;
        i4 = 0;
        while (i4 < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i4));
            if (view != null && !view.shouldIgnore()) {
            }
            i4++;
            if (!view.shouldIgnore()) {
            }
            mPosition = view.mPosition;
            i5 = 1;
            if (mPosition >= i + i2) {
            } else {
            }
            if (mPosition >= i) {
            }
            view.flagRemovedAndOffsetPosition(i + -1, -i2, z3);
            view.g = i5;
            view.offsetPosition(-i2, z3);
            view.g = i5;
        }
        this.b.w(i, i2, z3);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    void L() {
        int i;
        Object obj;
        ViewParent mPendingAccessibilityState;
        int i2;
        View itemView;
        size--;
        while (i >= 0) {
            obj = this.O0.get(i);
            if (obj.itemView.getParent() == this) {
            }
            i--;
            if ((RecyclerView.e0)obj.shouldIgnore()) {
            } else {
            }
            mPendingAccessibilityState = obj.mPendingAccessibilityState;
            i2 = -1;
            if (mPendingAccessibilityState != i2) {
            }
            u.v0(obj.itemView, mPendingAccessibilityState);
            obj.mPendingAccessibilityState = i2;
        }
        this.O0.clear();
    }

    @Override // android.view.ViewGroup
    public void L0(View view) {
    }

    @Override // android.view.ViewGroup
    public void M0(View view) {
    }

    @Override // android.view.ViewGroup
    void N() {
        int measuredWidth;
        int measuredHeight;
        int paddingBottom;
        if (this.h0 != null) {
        }
        EdgeEffect edgeEffect2 = this.d0.a(this, 3);
        this.h0 = edgeEffect2;
        if (this.y) {
            edgeEffect2.setSize(i2 -= paddingRight, i3 -= paddingBottom);
        } else {
            edgeEffect2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    void N0() {
        this.b0 = i++;
    }

    @Override // android.view.ViewGroup
    void O() {
        int measuredHeight;
        int measuredWidth;
        int paddingRight;
        if (this.e0 != null) {
        }
        EdgeEffect edgeEffect2 = this.d0.a(this, 0);
        this.e0 = edgeEffect2;
        if (this.y) {
            edgeEffect2.setSize(i2 -= paddingBottom, i3 -= paddingRight);
        } else {
            edgeEffect2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.ViewGroup
    void O0() {
        P0(true);
    }

    @Override // android.view.ViewGroup
    void P() {
        int measuredHeight;
        int measuredWidth;
        int paddingRight;
        if (this.g0 != null) {
        }
        EdgeEffect edgeEffect2 = this.d0.a(this, 2);
        this.g0 = edgeEffect2;
        if (this.y) {
            edgeEffect2.setSize(i2 -= paddingBottom, i3 -= paddingRight);
        } else {
            edgeEffect2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.ViewGroup
    void P0(boolean z) {
        int i;
        final int i3 = 1;
        i2 -= i3;
        this.b0 = i;
        this.b0 = 0;
        if (i < i3 && z) {
            this.b0 = 0;
            if (z) {
                C();
                L();
            }
        }
    }

    @Override // android.view.ViewGroup
    void Q() {
        int measuredWidth;
        int measuredHeight;
        int paddingBottom;
        if (this.f0 != null) {
        }
        EdgeEffect edgeEffect2 = this.d0.a(this, 1);
        this.f0 = edgeEffect2;
        if (this.y) {
            edgeEffect2.setSize(i2 -= paddingRight, i3 -= paddingBottom);
        } else {
            edgeEffect2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    String R() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.D);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.E);
        stringBuilder.append(", context:");
        stringBuilder.append(getContext());
        return stringBuilder.toString();
    }

    @Override // android.view.ViewGroup
    public void R0(int i) {
    }

    @Override // android.view.ViewGroup
    final void S(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        int currY;
        int i;
        int currX;
        if (getScrollState() == 2) {
            OverScroller overScroller = view.c;
            b0.p = finalX -= currX;
            b0.q = finalY -= currY;
        } else {
            currY = 0;
            b0.p = currY;
            b0.q = currY;
        }
    }

    @Override // android.view.ViewGroup
    public void S0(int i, int i2) {
    }

    @Override // android.view.ViewGroup
    public View T(float f, float f2) {
        int i;
        View view;
        float translationX;
        float translationY;
        int cmp;
        i2--;
        while (i >= 0) {
            view = this.w.f(i);
            translationX = view.getTranslationX();
            translationY = view.getTranslationY();
            i--;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    void T0() {
        boolean z;
        if (!this.G0 && this.K) {
            if (this.K) {
                u.d0(this, this.P0);
                this.G0 = true;
            }
        }
    }

    @Override // android.view.ViewGroup
    public View U(View view) {
        ViewParent parent;
        boolean z;
        int obj3;
        parent = view.getParent();
        while (parent != null) {
            if (parent != this) {
            }
            if (parent instanceof View != null) {
            }
            parent = (View)parent.getParent();
        }
        if (parent == this) {
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.e0 V(View view) {
        int obj1;
        obj1 = U(view);
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = j0(obj1);
        }
        return obj1;
    }

    @Override // android.view.ViewGroup
    void W0(boolean z) {
        this.a0 = z |= z2;
        this.W = true;
        E0();
    }

    @Override // android.view.ViewGroup
    void Y0(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2) {
        boolean updated;
        androidx.recyclerview.widget.b0 b0Var;
        final int i2 = 8192;
        e0.setFlags(0, i2);
        if (a0.i && e0.isUpdated() && !e0.isRemoved() && !e0.shouldIgnore()) {
            if (e0.isUpdated()) {
                if (!e0.isRemoved()) {
                    if (!e0.shouldIgnore()) {
                        this.x.c(f0(e0), i2);
                    }
                }
            }
        }
        this.x.e(e0, c2);
    }

    @Override // android.view.ViewGroup
    void a(int i, int i2) {
        boolean finished;
        int i3;
        if (i < 0) {
            O();
            if (this.e0.isFinished()) {
                this.e0.onAbsorb(-i);
            }
        } else {
            P();
            if (i > 0 && this.g0.isFinished()) {
                P();
                if (this.g0.isFinished()) {
                    this.g0.onAbsorb(i);
                }
            }
        }
        if (i2 < 0) {
            Q();
            if (this.f0.isFinished()) {
                this.f0.onAbsorb(-i2);
            }
        } else {
            N();
            if (i2 > 0 && this.h0.isFinished()) {
                N();
                if (this.h0.isFinished()) {
                    this.h0.onAbsorb(i2);
                }
            }
        }
        if (i == 0) {
            if (i2 != 0) {
                u.c0(this);
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.e0 a0(int i) {
        int i2;
        int i3;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean itemView;
        if (this.W) {
            return null;
        }
        i3 = 0;
        while (i3 < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i3));
            i3++;
            i2 = view;
        }
        return i2;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        boolean view;
        view = this.E;
        if (view != null) {
            if (!view.Z0(this, arrayList, i2, i3)) {
                super.addFocusables(arrayList, i2, i3);
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.e0 b0(long l) {
        androidx.recyclerview.widget.RecyclerView.h stableIds;
        int i2;
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean itemView;
        stableIds = this.D;
        i2 = 0;
        if (stableIds != null) {
            if (!stableIds.hasStableIds()) {
            } else {
                i = 0;
                while (i < this.w.j()) {
                    view = RecyclerView.k0(this.w.i(i));
                    i++;
                    i2 = view;
                }
            }
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    void b1() {
        androidx.recyclerview.widget.RecyclerView.p view;
        androidx.recyclerview.widget.RecyclerView.w view2;
        androidx.recyclerview.widget.RecyclerView.m view3 = this.i0;
        if (view3 != null) {
            view3.endAnimations();
        }
        view = this.E;
        if (view != null) {
            view.F1(this.b);
            this.E.G1(this.b);
        }
        this.b.c();
    }

    @Override // android.view.ViewGroup
    androidx.recyclerview.widget.RecyclerView.e0 c0(int i, boolean z2) {
        int i2;
        int i3;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean layoutPosition;
        i2 = 0;
        i3 = 0;
        while (i3 < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i3));
            i3++;
            i2 = view;
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    boolean c1(View view) {
        androidx.recyclerview.widget.RecyclerView.w view2;
        Object obj3;
        z1();
        boolean z = this.w.r(view);
        if (z) {
            obj3 = RecyclerView.k0(view);
            this.b.J(obj3);
            this.b.C(obj3);
        }
        B1(z ^ 1);
        return z;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        boolean z;
        Object obj2;
        if (layoutParams instanceof RecyclerView.q && this.E.J((RecyclerView.q)layoutParams)) {
            obj2 = this.E.J((RecyclerView.q)layoutParams) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public int computeHorizontalScrollExtent() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.H()) {
            i = this.E.N(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int computeHorizontalScrollOffset() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.H()) {
            i = this.E.O(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int computeHorizontalScrollRange() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.H()) {
            i = this.E.P(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int computeVerticalScrollExtent() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.I()) {
            i = this.E.Q(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int computeVerticalScrollOffset() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.I()) {
            i = this.E.R(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int computeVerticalScrollRange() {
        boolean z;
        int i;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return 0;
        }
        if (view.I()) {
            i = this.E.S(this.A0);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean d0(int i, int i2) {
        int i5;
        int i6;
        float f;
        int i3;
        boolean dispatchNestedPreFling;
        int i4;
        int obj8;
        int obj9;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        i5 = 0;
        if (view == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return i5;
        }
        if (this.Q) {
            return i5;
        }
        boolean z = view.H();
        boolean z3 = this.E.I();
        if (z) {
            if (Math.abs(i) < this.s0) {
                obj8 = i5;
            }
        } else {
        }
        if (z3) {
            if (Math.abs(i2) < this.s0) {
                obj9 = i5;
            }
        } else {
        }
        if (obj8 == null && obj9 == null) {
            if (obj9 == null) {
                return i5;
            }
        }
        f = (float)obj8;
        float f2 = (float)obj9;
        if (!dispatchNestedPreFling(f, f2)) {
            dispatchNestedPreFling = 1;
            if (!z) {
                if (z3) {
                    i4 = dispatchNestedPreFling;
                } else {
                    i4 = i5;
                }
            } else {
            }
            dispatchNestedFling(f, f2, i4);
            f = this.r0;
            if (f != null && f.a(obj8, obj9)) {
                if (f.a(obj8, obj9)) {
                    return dispatchNestedPreFling;
                }
            }
            if (i4 != 0 && z) {
                if (z) {
                    i5 = dispatchNestedPreFling;
                }
                if (z3) {
                    i5 |= 2;
                }
                A1(i5, dispatchNestedPreFling);
                int i7 = this.t0;
                int i8 = this.t0;
                this.x0.b(Math.max(-i7, Math.min(obj8, i7)), Math.max(-i8, Math.min(obj9, i8)));
                return dispatchNestedPreFling;
            }
        }
        return i5;
    }

    @Override // android.view.ViewGroup
    public void d1(androidx.recyclerview.widget.RecyclerView.o recyclerView$o) {
        ArrayList list;
        String str;
        boolean obj3;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view != null) {
            view.D("Cannot remove item decoration during a scroll  or layout");
        }
        this.H.remove(o);
        if (this.H.isEmpty()) {
            obj3 = getOverScrollMode() == 2 ? 1 : 0;
            setWillNotDraw(obj3);
        }
        D0();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedFling(float f, float f2, boolean z3) {
        return getScrollingChildHelper().a(f, f2, z3);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().b(f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedPreScroll(int i, int i2, int[] i3Arr3, int[] i4Arr4) {
        return getScrollingChildHelper().c(i, i2, i3Arr3, i4Arr4);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] i5Arr5) {
        return getScrollingChildHelper().f(i, i2, i3, i4, i5Arr5);
    }

    @Override // android.view.ViewGroup
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return 1;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup
    public void draw(Canvas canvas) {
        int finished2;
        EdgeEffect finished4;
        EdgeEffect finished3;
        EdgeEffect finished;
        int i3;
        int i4;
        int i2;
        Object obj;
        int i;
        int paddingBottom2;
        EdgeEffect draw;
        int draw4;
        boolean z;
        EdgeEffect draw3;
        EdgeEffect draw2;
        float f2;
        float f;
        int paddingTop;
        int paddingBottom;
        Canvas obj8;
        super.draw(canvas);
        i3 = 0;
        i4 = i3;
        while (i4 < this.H.size()) {
            (RecyclerView.o)this.H.get(i4).onDrawOver(canvas, this, this.A0);
            i4++;
        }
        finished2 = this.e0;
        i2 = 1;
        if (finished2 != null && !finished2.isFinished()) {
            if (!finished2.isFinished()) {
                if (this.y) {
                    paddingBottom2 = getPaddingBottom();
                } else {
                    paddingBottom2 = i3;
                }
                canvas.rotate(1132920832);
                canvas.translate((float)i12, 0);
                draw = this.e0;
                if (draw != null && draw.draw(canvas)) {
                    i = draw.draw(canvas) ? i2 : i3;
                } else {
                }
                canvas.restoreToCount(canvas.save());
            } else {
                i = i3;
            }
        } else {
        }
        finished4 = this.f0;
        if (finished4 != null && !finished4.isFinished() && this.y) {
            if (!finished4.isFinished()) {
                if (this.y) {
                    canvas.translate((float)paddingLeft, (float)paddingTop2);
                }
                draw3 = this.f0;
                if (draw3 != null && draw3.draw(canvas)) {
                    draw4 = draw3.draw(canvas) ? i2 : i3;
                } else {
                }
                i |= draw4;
                canvas.restoreToCount(canvas.save());
            }
        }
        finished3 = this.g0;
        if (finished3 != null && !finished3.isFinished()) {
            if (!finished3.isFinished()) {
                if (this.y) {
                    paddingTop = getPaddingTop();
                } else {
                    paddingTop = i3;
                }
                canvas.rotate(1119092736);
                canvas.translate((float)paddingTop, (float)i5);
                draw2 = this.g0;
                if (draw2 != null && draw2.draw(canvas)) {
                    draw4 = draw2.draw(canvas) ? i2 : i3;
                } else {
                }
                i |= draw4;
                canvas.restoreToCount(canvas.save());
            }
        }
        finished = this.h0;
        if (finished != null && !finished.isFinished()) {
            if (!finished.isFinished()) {
                canvas.rotate(1127481344);
                if (this.y) {
                    canvas.translate((float)i9, (float)i15);
                } else {
                    canvas.translate((float)i7, (float)i13);
                }
                draw4 = this.h0;
                if (draw4 != null && draw4.draw(canvas)) {
                    if (draw4.draw(canvas)) {
                        i3 = i2;
                    }
                }
                i |= i3;
                canvas.restoreToCount(canvas.save());
            }
        }
        if (i == 0 && this.i0 != null && this.H.size() > 0 && this.i0.isRunning()) {
            if (this.i0 != null) {
                if (this.H.size() > 0) {
                    if (this.i0.isRunning()) {
                    } else {
                        i2 = i;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            u.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long l3) {
        return super.drawChild(canvas, view2, l3);
    }

    @Override // android.view.ViewGroup
    int e0(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        boolean anyOfTheFlags;
        if (!e0.hasAnyOfTheFlags(524) && !e0.isBound()) {
            if (!e0.isBound()) {
            }
            return this.v.e(e0.mPosition);
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public void e1(int i) {
        final int itemDecorationCount = getItemDecorationCount();
        if (i < 0) {
        } else {
            if (i >= itemDecorationCount) {
            } else {
                d1(q0(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(itemDecorationCount);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // android.view.ViewGroup
    long f0(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        long itemId;
        Object obj3;
        if (this.D.hasStableIds()) {
            itemId = e0.getItemId();
        } else {
            itemId = (long)obj3;
        }
        return itemId;
    }

    @Override // android.view.ViewGroup
    public void f1(androidx.recyclerview.widget.RecyclerView.r recyclerView$r) {
        final List list = this.V;
        if (list == null) {
        }
        list.remove(r);
    }

    @Override // android.view.ViewGroup
    public View focusSearch(View view, int i2) {
        int i4;
        View focusSearch;
        int z2;
        int i;
        androidx.recyclerview.widget.RecyclerView.h view2;
        androidx.recyclerview.widget.RecyclerView.w nextFocus;
        Object instance;
        int i5;
        int i3;
        int i6;
        boolean z;
        int obj10;
        View view4 = this.E.k1(view, i2);
        if (view4 != null) {
            return view4;
        }
        nextFocus = 1;
        final int i9 = 0;
        if (this.D != null && this.E != null && !A0() && !this.Q) {
            if (this.E != null) {
                if (!A0()) {
                    i4 = !this.Q ? nextFocus : i9;
                } else {
                }
            } else {
            }
        } else {
        }
        instance = FocusFinder.getInstance();
        final int i10 = 0;
        if (i4 != 0) {
            i5 = 2;
            if (i2 != i5) {
                if (i2 == nextFocus) {
                    if (this.E.I()) {
                        z2 = i2 == i5 ? 130 : 33;
                        i6 = instance.findNextFocus(this, view, z2) == null ? nextFocus : i9;
                        if (RecyclerView.Z0) {
                            obj10 = z2;
                        }
                    } else {
                        i6 = i9;
                    }
                    if (i6 == 0 && this.E.H()) {
                        if (this.E.H()) {
                            i = this.E.w0() == nextFocus ? nextFocus : i9;
                            i3 = obj10 == i5 ? nextFocus : i9;
                            z2 = i ^= i3 != 0 ? 66 : 17;
                            if (instance.findNextFocus(this, view, z2) == null) {
                            } else {
                                nextFocus = i9;
                            }
                            if (RecyclerView.Z0) {
                                obj10 = z2;
                            }
                            i6 = nextFocus;
                        }
                    }
                    w();
                    if (i6 != 0 && U(view) == null) {
                        w();
                        if (U(view) == null) {
                            return i10;
                        }
                        z1();
                        this.E.d1(view, obj10, this.b, this.A0);
                        B1(i9);
                    }
                    focusSearch = instance.findNextFocus(this, view, obj10);
                } else {
                    nextFocus = instance.findNextFocus(this, view, i2);
                    if (nextFocus == null && i4 != 0) {
                        if (i4 != 0) {
                            w();
                            if (U(view) == null) {
                                return i10;
                            }
                            z1();
                            focusSearch = this.E.d1(view, i2, this.b, this.A0);
                            B1(i9);
                        } else {
                            focusSearch = nextFocus;
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (focusSearch != null && !focusSearch.hasFocusable() && getFocusedChild() == null) {
            if (!focusSearch.hasFocusable()) {
                if (getFocusedChild() == null) {
                    return super.focusSearch(view, obj10);
                }
                j1(focusSearch, i10);
                return view;
            }
        }
        if (B0(view, focusSearch, obj10)) {
        } else {
            focusSearch = super.focusSearch(view, obj10);
        }
        return focusSearch;
    }

    @Override // android.view.ViewGroup
    public int g0(View view) {
        int obj1;
        obj1 = RecyclerView.k0(view);
        if (obj1 != null) {
            obj1 = obj1.getAbsoluteAdapterPosition();
        } else {
            obj1 = -1;
        }
        return obj1;
    }

    @Override // android.view.ViewGroup
    public void g1(androidx.recyclerview.widget.RecyclerView.t recyclerView$t) {
        Object obj2;
        this.I.remove(t);
        if (this.J == t) {
            this.J = 0;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
        } else {
            return view.a0();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(R());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
        } else {
            return view.b0(getContext(), attributeSet);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(R());
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
        throw obj3;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
        } else {
            return view.c0(layoutParams);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(R());
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
        throw obj3;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.h getAdapter() {
        return this.D;
    }

    @Override // android.view.ViewGroup
    public int getBaseline() {
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view != null) {
            return view.d0();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        final androidx.recyclerview.widget.RecyclerView.k i0 = this.I0;
        if (i0 == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return i0.a(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.v getCompatAccessibilityDelegate() {
        return this.H0;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.l getEdgeEffectFactory() {
        return this.d0;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.m getItemAnimator() {
        return this.i0;
    }

    @Override // android.view.ViewGroup
    public int getItemDecorationCount() {
        return this.H.size();
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.p getLayoutManager() {
        return this.E;
    }

    @Override // android.view.ViewGroup
    public int getMaxFlingVelocity() {
        return this.t0;
    }

    @Override // android.view.ViewGroup
    public int getMinFlingVelocity() {
        return this.s0;
    }

    @Override // android.view.ViewGroup
    long getNanoTime() {
        if (RecyclerView.Y0) {
            return System.nanoTime();
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.s getOnFlingListener() {
        return this.r0;
    }

    @Override // android.view.ViewGroup
    public boolean getPreserveFocusAfterLayout() {
        return this.w0;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.v getRecycledViewPool() {
        return this.b.i();
    }

    @Override // android.view.ViewGroup
    public int getScrollState() {
        return this.j0;
    }

    @Override // android.view.ViewGroup
    public void h(androidx.recyclerview.widget.RecyclerView.o recyclerView$o) {
        i(o, -1);
    }

    @Override // android.view.ViewGroup
    public int h0(View view) {
        int obj1;
        obj1 = RecyclerView.k0(view);
        if (obj1 != null) {
            obj1 = obj1.getLayoutPosition();
        } else {
            obj1 = -1;
        }
        return obj1;
    }

    @Override // android.view.ViewGroup
    public void h1(androidx.recyclerview.widget.RecyclerView.u recyclerView$u) {
        final List c0 = this.C0;
        if (c0 != null) {
            c0.remove(u);
        }
    }

    @Override // android.view.ViewGroup
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    @Override // android.view.ViewGroup
    public void i(androidx.recyclerview.widget.RecyclerView.o recyclerView$o, int i2) {
        boolean empty;
        String str;
        int obj4;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view != null) {
            view.D("Cannot add item decoration during a scroll  or layout");
        }
        if (this.H.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.H.add(o);
        } else {
            this.H.add(i2, o);
        }
        D0();
        requestLayout();
    }

    @Deprecated
    public int i0(View view) {
        return g0(view);
    }

    @Override // android.view.ViewGroup
    void i1() {
        int i;
        View top;
        androidx.recyclerview.widget.RecyclerView.e0 mShadowingHolder;
        int left;
        int left2;
        int i2;
        i = 0;
        while (i < this.w.g()) {
            top = this.w.f(i);
            mShadowingHolder = j0(top);
            mShadowingHolder = mShadowingHolder.mShadowingHolder;
            if (mShadowingHolder != null && mShadowingHolder != null) {
            }
            i++;
            mShadowingHolder = mShadowingHolder.mShadowingHolder;
            if (mShadowingHolder != null) {
            }
            mShadowingHolder = mShadowingHolder.itemView;
            left = top.getLeft();
            top = top.getTop();
            if (left == mShadowingHolder.getLeft()) {
            } else {
            }
            mShadowingHolder.layout(left, top, width += left, height += top);
            if (top != mShadowingHolder.getTop()) {
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean isAttachedToWindow() {
        return this.K;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.Q;
    }

    @Override // android.view.ViewGroup
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    @Override // android.view.ViewGroup
    public void j(androidx.recyclerview.widget.RecyclerView.r recyclerView$r) {
        Object arrayList;
        if (this.V == null) {
            arrayList = new ArrayList();
            this.V = arrayList;
        }
        this.V.add(r);
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.e0 j0(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            if (parent != this) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a direct child of ");
            stringBuilder.append(this);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return RecyclerView.k0(view);
    }

    @Override // android.view.ViewGroup
    public void k(androidx.recyclerview.widget.RecyclerView.t recyclerView$t) {
        this.I.add(t);
    }

    @Override // android.view.ViewGroup
    public void l(androidx.recyclerview.widget.RecyclerView.u recyclerView$u) {
        Object arrayList;
        if (this.C0 == null) {
            arrayList = new ArrayList();
            this.C0 = arrayList;
        }
        this.C0.add(u);
    }

    @Override // android.view.ViewGroup
    public void l0(View view, Rect rect2) {
        RecyclerView.m0(view, rect2);
    }

    @Override // android.view.ViewGroup
    void m(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
        e0.setIsRecyclable(false);
        if (this.i0.animateAppearance(e0, c2, c3)) {
            T0();
        }
    }

    @Override // android.view.ViewGroup
    void n1() {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean ignore;
        i = 0;
        while (i < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i));
            if (!view.shouldIgnore()) {
            }
            i++;
            view.saveOldPosition();
        }
    }

    @Override // android.view.ViewGroup
    void o(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3) {
        g(e0);
        e0.setIsRecyclable(false);
        if (this.i0.animateDisappearance(e0, c2, c3)) {
            T0();
        }
    }

    @Override // android.view.ViewGroup
    boolean o1(int i, int i2, MotionEvent motionEvent3, int i4) {
        int view;
        int[] i11;
        int i9;
        int i14;
        int i3;
        int i6;
        int i13;
        int i5;
        int overScrollMode;
        int i10;
        int i12;
        int i7;
        int i16;
        int i8;
        int i15;
        final Object obj2 = this;
        final int i38 = i;
        final int i39 = i2;
        final MotionEvent motionEvent = motionEvent3;
        w();
        i12 = 1;
        final int i40 = 0;
        if (obj2.D != null) {
            int[] n0 = obj2.N0;
            n0[i40] = i40;
            n0[i12] = i40;
            obj2.p1(i38, i39, n0);
            int[] n02 = obj2.N0;
            i14 = n02[i40];
            view = n02[i12];
            i7 = view;
            i16 = i14;
            i8 = i6;
            i15 = i5;
        } else {
            i15 = i8;
        }
        if (!obj2.H.isEmpty()) {
            invalidate();
        }
        final int[] n03 = obj2.N0;
        n03[i40] = i40;
        n03[i12] = i40;
        this.I(i16, i7, i8, i15, obj2.L0, i4, n03);
        i11 = obj2.N0;
        if (i11[i40] == 0) {
            if (i11[i12] != 0) {
                i9 = i12;
            } else {
                i9 = i40;
            }
        } else {
        }
        int[] l0 = obj2.L0;
        obj2.o0 = i23 -= i30;
        obj2.p0 = i25 -= i31;
        int[] m0 = obj2.M0;
        m0[i40] = i32 += i37;
        m0[i12] = i34 += i29;
        if (getOverScrollMode() != 2 && motionEvent != null && !j.a(motionEvent, 8194)) {
            if (motionEvent != null) {
                if (!j.a(motionEvent, 8194)) {
                    obj2.X0(motionEvent3.getX(), (float)i3, motionEvent3.getY(), (float)i13);
                }
            }
            v(i, i2);
        }
        if (i16 == 0) {
            if (i7 != 0) {
                obj2.K(i16, i7);
            }
        } else {
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i9 == 0 && i16 == 0) {
            if (i16 == 0) {
                if (i7 != 0) {
                } else {
                    i12 = i40;
                }
            }
        }
        return i12;
    }

    @Override // android.view.ViewGroup
    protected void onAttachedToWindow() {
        boolean z;
        int i;
        Object view;
        Display refreshRate;
        boolean layoutRequested;
        int i2;
        int i3;
        boolean inEditMode;
        super.onAttachedToWindow();
        int i4 = 0;
        this.b0 = i4;
        this.K = true;
        if (this.N && !isLayoutRequested()) {
            if (!isLayoutRequested()) {
            } else {
                i = i4;
            }
        } else {
        }
        this.N = i;
        view = this.E;
        if (view != null) {
            view.W(this);
        }
        this.G0 = i4;
        java.lang.ThreadLocal threadLocal = k.w;
        view = threadLocal.get();
        this.y0 = (k)view;
        k kVar = new k();
        this.y0 = kVar;
        refreshRate = u.v(this);
        i2 = 1114636288;
        refreshRate = refreshRate.getRefreshRate();
        if (RecyclerView.Y0 && view == null && !isInEditMode() && refreshRate != null && Float.compare(refreshRate, i5) >= 0) {
            threadLocal = k.w;
            view = threadLocal.get();
            this.y0 = (k)view;
            if (view == null) {
                kVar = new k();
                this.y0 = kVar;
                refreshRate = u.v(this);
                i2 = 1114636288;
                if (!isInEditMode()) {
                    if (refreshRate != null) {
                        refreshRate = refreshRate.getRefreshRate();
                        if (Float.compare(refreshRate, i5) >= 0) {
                            i2 = refreshRate;
                        }
                    }
                }
                view = this.y0;
                view.c = (long)i3;
                threadLocal.set(view);
            }
            this.y0.a(this);
        }
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        boolean z;
        androidx.recyclerview.widget.RecyclerView.w view;
        super.onDetachedFromWindow();
        androidx.recyclerview.widget.RecyclerView.m view2 = this.i0;
        if (view2 != null) {
            view2.endAnimations();
        }
        D1();
        this.K = false;
        androidx.recyclerview.widget.RecyclerView.p view3 = this.E;
        if (view3 != null) {
            view3.X(this, this.b);
        }
        this.O0.clear();
        removeCallbacks(this.P0);
        this.x.j();
        z = this.y0;
        if (RecyclerView.Y0 && z != null) {
            z = this.y0;
            if (z != null) {
                z.j(this);
                this.y0 = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onDraw(Canvas canvas) {
        int i;
        Object obj;
        androidx.recyclerview.widget.RecyclerView.b0 view;
        super.onDraw(canvas);
        i = 0;
        while (i < this.H.size()) {
            (RecyclerView.o)this.H.get(i).onDraw(canvas, this, this.A0);
            i++;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int action;
        int axisValue2;
        int cmp2;
        int axisValue;
        boolean z;
        int i;
        int cmp;
        final int i6 = 0;
        if (this.E == null) {
            return i6;
        }
        if (this.Q) {
            return i6;
        }
        if (motionEvent.getAction() == 8) {
            cmp2 = 0;
            if (source &= 2 != 0) {
                if (this.E.I()) {
                    action = -axisValue3;
                } else {
                    action = cmp2;
                }
                if (this.E.H()) {
                    axisValue = motionEvent.getAxisValue(10);
                } else {
                    axisValue = cmp2;
                }
            } else {
            }
            if (Float.compare(action, cmp2) == 0) {
                if (Float.compare(axisValue, cmp2) != 0) {
                    F0((int)i8, (int)i5, motionEvent, 1);
                }
            } else {
            }
        }
        return i6;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int z;
        int i;
        boolean z2;
        VelocityTracker obtain;
        int actionMasked;
        int actionIndex;
        int i2;
        int obj9;
        i = 0;
        if (this.Q) {
            return i;
        }
        this.J = 0;
        final int i7 = 1;
        if (W(motionEvent)) {
            r();
            return i7;
        }
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            return i;
        }
        z = view.H();
        z2 = this.E.I();
        if (this.l0 == null) {
            this.l0 = VelocityTracker.obtain();
        }
        this.l0.addMovement(motionEvent);
        actionMasked = motionEvent.getActionMasked();
        actionIndex = motionEvent.getActionIndex();
        i2 = 2;
        final int i13 = 1056964608;
        if (actionMasked != 0) {
            if (actionMasked != i7) {
                if (actionMasked != i2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                            } else {
                                Q0(motionEvent);
                            }
                        } else {
                            this.k0 = motionEvent.getPointerId(actionIndex);
                            z = (int)i6;
                            this.o0 = z;
                            this.m0 = z;
                            obj9 = (int)obj9;
                            this.p0 = obj9;
                            this.n0 = obj9;
                        }
                    } else {
                        r();
                    }
                } else {
                    int pointerIndex = motionEvent.findPointerIndex(this.k0);
                    if (pointerIndex < 0) {
                        obj9 = new StringBuilder();
                        obj9.append("Error processing scroll; pointer index for id ");
                        obj9.append(this.k0);
                        obj9.append(" not found. Did any MotionEvents get skipped?");
                        Log.e("RecyclerView", obj9.toString());
                        return i;
                    }
                    actionIndex = (int)i11;
                    obj9 = (int)obj9;
                    if (this.j0 != i7) {
                        if (z && Math.abs(actionIndex - i9) > this.q0) {
                            z = Math.abs(actionMasked) > this.q0 ? i7 : i;
                        } else {
                        }
                        if (z2 && Math.abs(obj9 - i12) > this.q0) {
                            if (Math.abs(i2) > this.q0) {
                                this.p0 = obj9;
                                z = i7;
                            }
                        }
                        if (z != 0) {
                            setScrollState(i7);
                        }
                    }
                }
            } else {
                this.l0.clear();
                C1(i);
            }
        } else {
            if (this.R) {
                this.R = i;
            }
            this.k0 = motionEvent.getPointerId(i);
            actionMasked = (int)i10;
            this.o0 = actionMasked;
            this.m0 = actionMasked;
            obj9 = (int)obj9;
            this.p0 = obj9;
            this.n0 = obj9;
            if (this.j0 == i2) {
                getParent().requestDisallowInterceptTouchEvent(i7);
                setScrollState(i7);
                C1(i7);
            }
            obj9 = this.M0;
            obj9[i7] = i;
            obj9[i] = i;
            if (z2) {
                z |= 2;
            }
            A1(z, i);
        }
        if (this.j0 == i7) {
            i = i7;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        i.a("RV OnLayout");
        D();
        i.b();
        this.N = true;
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int mode;
        boolean z;
        androidx.recyclerview.widget.RecyclerView.b0 z3;
        int itemCount;
        int i3;
        int measureSpec;
        int measureSpec2;
        boolean z2;
        int i4;
        androidx.recyclerview.widget.RecyclerView.w view2;
        androidx.recyclerview.widget.RecyclerView.b0 view;
        int obj8;
        androidx.recyclerview.widget.RecyclerView.p view3 = this.E;
        if (view3 == null) {
            y(i, i2);
        }
        i3 = 1;
        measureSpec = 0;
        this.E.t1(this.b, this.A0, i, i2);
        i4 = 1073741824;
        if (view3.L0() && View.MeasureSpec.getMode(i) == i4 && View.MeasureSpec.getMode(i2) == i4) {
            this.E.t1(this.b, this.A0, i, i2);
            i4 = 1073741824;
            if (View.MeasureSpec.getMode(i) == i4) {
                if (View.MeasureSpec.getMode(i2) == i4) {
                    measureSpec = i3;
                }
            }
            this.Q0 = measureSpec;
            if (measureSpec == 0 && this.D == null) {
                if (this.D == null) {
                }
                if (a0.e == i3) {
                    E();
                }
                this.E.W1(i, i2);
                a02.j = i3;
                F();
                this.E.Z1(i, i2);
                if (this.E.c2()) {
                    this.E.W1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), i4), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), i4));
                    a03.j = i3;
                    F();
                    this.E.Z1(i, i2);
                }
                this.R0 = getMeasuredWidth();
                this.S0 = getMeasuredHeight();
            }
        }
        if (this.L) {
            this.E.t1(this.b, this.A0, i, i2);
        }
        if (this.T) {
            z1();
            N0();
            V0();
            O0();
            z3 = this.A0;
            if (z3.l) {
                z3.h = i3;
            } else {
                this.v.j();
                z3.h = measureSpec;
            }
            this.T = measureSpec;
            B1(measureSpec);
        } else {
            if (a04.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            }
        }
        androidx.recyclerview.widget.RecyclerView.h view8 = this.D;
        if (view8 != null) {
            i3.f = view8.getItemCount();
        } else {
            itemCount.f = measureSpec;
        }
        z1();
        this.E.t1(this.b, this.A0, i, i2);
        B1(measureSpec);
        obj8.h = measureSpec;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect2) {
        if (A0()) {
            return 0;
        }
        return super.onRequestFocusInDescendants(i, rect2);
    }

    @Override // android.view.ViewGroup
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof RecyclerView.z) {
            super.onRestoreInstanceState(parcelable);
        }
        this.c = (RecyclerView.z)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        requestLayout();
    }

    @Override // android.view.ViewGroup
    protected Parcelable onSaveInstanceState() {
        androidx.recyclerview.widget.RecyclerView.z view;
        RecyclerView.z zVar = new RecyclerView.z(super.onSaveInstanceState());
        view = this.c;
        if (view != null) {
            zVar.b(view);
        } else {
            androidx.recyclerview.widget.RecyclerView.p view2 = this.E;
            if (view2 != null) {
                zVar.c = view2.x1();
            } else {
                zVar.c = 0;
            }
        }
        return zVar;
    }

    @Override // android.view.ViewGroup
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3) {
            if (i2 != i4) {
                y0();
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        VelocityTracker obtain;
        boolean actionMasked;
        int i4;
        boolean parent2;
        int actionIndex;
        int i9;
        int i12;
        boolean parent;
        int[] iArr2;
        float i2;
        int i10;
        int i11;
        float cmp;
        int[] iArr;
        int i3;
        int i;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        final Object obj2 = this;
        final MotionEvent motionEvent2 = motionEvent;
        i = 0;
        if (!obj2.Q) {
            if (obj2.R) {
            } else {
                final int i41 = 1;
                if (M(motionEvent)) {
                    r();
                    return i41;
                }
                androidx.recyclerview.widget.RecyclerView.p view = obj2.E;
                if (view == null) {
                    return i;
                }
                z = view.H();
                final boolean z4 = obj2.E.I();
                if (obj2.l0 == null) {
                    obj2.l0 = VelocityTracker.obtain();
                }
                actionMasked = motionEvent.getActionMasked();
                actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    iArr2 = obj2.M0;
                    iArr2[i41] = i;
                    iArr2[i] = i;
                }
                final MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                int[] m02 = obj2.M0;
                obtain2.offsetLocation((float)i40, (float)i37);
                i10 = 1056964608;
                if (actionMasked != 0) {
                    if (actionMasked != i41) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked != 5) {
                                    if (actionMasked != 6) {
                                    } else {
                                        Q0(motionEvent);
                                    }
                                } else {
                                    obj2.k0 = motionEvent2.getPointerId(actionIndex);
                                    int i21 = (int)i20;
                                    obj2.o0 = i21;
                                    obj2.m0 = i21;
                                    actionMasked = (int)i22;
                                    obj2.p0 = actionMasked;
                                    obj2.n0 = actionMasked;
                                }
                            } else {
                                r();
                            }
                        } else {
                            int pointerIndex = motionEvent2.findPointerIndex(obj2.k0);
                            if (pointerIndex < 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Error processing scroll; pointer index for id ");
                                stringBuilder.append(obj2.k0);
                                stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                                Log.e("RecyclerView", stringBuilder.toString());
                                return i;
                            }
                            i5 = (int)i27;
                            i6 = (int)i15;
                            i16 -= i5;
                            i28 -= i6;
                            if (obj2.j0 != i41) {
                                if (z) {
                                    if (i4 > 0) {
                                        i4 = Math.max(i, i4 -= i10);
                                    } else {
                                        i4 = Math.min(i, i4 += i10);
                                    }
                                    i10 = i4 != 0 ? i41 : i;
                                } else {
                                }
                                if (z4) {
                                    if (actionIndex > 0) {
                                        actionIndex = Math.max(i, actionIndex -= cmp);
                                    } else {
                                        actionIndex = Math.min(i, actionIndex += cmp);
                                    }
                                    if (actionIndex != 0) {
                                        i10 = i41;
                                    }
                                }
                                if (i10 != 0) {
                                    obj2.setScrollState(i41);
                                }
                            }
                            i7 = i4;
                            i8 = actionIndex;
                            if (obj2.j0 == i41) {
                                cmp = obj2.N0;
                                cmp[i] = i;
                                cmp[i41] = i;
                                i9 = z ? i7 : i;
                                i11 = z4 ? i8 : i;
                                if (this.H(i9, i11, cmp, obj2.L0, 0)) {
                                    int[] n0 = obj2.N0;
                                    i7 -= i32;
                                    i8 -= i19;
                                    int[] m0 = obj2.M0;
                                    int[] l02 = obj2.L0;
                                    m0[i] = i33 += cmp;
                                    m0[i41] = i35 += i11;
                                    getParent().requestDisallowInterceptTouchEvent(i41);
                                }
                                actionMasked = i8;
                                int[] l0 = obj2.L0;
                                obj2.o0 = i5 -= i39;
                                obj2.p0 = i6 -= i31;
                                i12 = z ? i7 : i;
                                i10 = z4 ? actionMasked : i;
                                if (obj2.o1(i12, i10, motionEvent2, i)) {
                                    getParent().requestDisallowInterceptTouchEvent(i41);
                                }
                                actionIndex = obj2.y0;
                                if (actionIndex != null) {
                                    if (i7 == 0) {
                                        if (actionMasked != 0) {
                                            actionIndex.f(obj2, i7, actionMasked);
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    } else {
                        obj2.l0.addMovement(obtain2);
                        obj2.l0.computeCurrentVelocity(1000, (float)i38);
                        actionMasked = 0;
                        if (z) {
                            actionIndex = -xVelocity;
                        } else {
                            actionIndex = actionMasked;
                        }
                        if (z4) {
                            i10 = -yVelocity;
                        } else {
                            i10 = actionMasked;
                        }
                        if (Float.compare(actionIndex, actionMasked) == 0) {
                            if (Float.compare(i10, actionMasked) != 0) {
                                if (!obj2.d0((int)actionIndex, (int)i10)) {
                                    obj2.setScrollState(i);
                                }
                            } else {
                            }
                        } else {
                        }
                        l1();
                        i = i41;
                    }
                } else {
                    obj2.k0 = motionEvent2.getPointerId(i);
                    int i24 = (int)i23;
                    obj2.o0 = i24;
                    obj2.m0 = i24;
                    actionMasked = (int)i25;
                    obj2.p0 = actionMasked;
                    obj2.n0 = actionMasked;
                    if (z4) {
                        z |= 2;
                    }
                    obj2.A1(z, i);
                }
                if (i == 0) {
                    obj2.l0.addMovement(obtain2);
                }
            }
            obtain2.recycle();
            return i41;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    void p(String string) {
        boolean str;
        String str2;
        int obj3;
        if (A0() && string == null) {
            if (string == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                stringBuilder.append(R());
                obj3 = new IllegalStateException(stringBuilder.toString());
                throw obj3;
            }
            IllegalStateException illegalStateException = new IllegalStateException(string);
            throw illegalStateException;
        }
        if (this.c0 > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(R());
            obj3 = new IllegalStateException(stringBuilder2.toString());
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", obj3);
        }
    }

    @Override // android.view.ViewGroup
    Rect p0(View view) {
        boolean z;
        int i;
        int i2;
        int bottom;
        int right;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.b;
        }
        if (this.A0.f() && !(RecyclerView.q)layoutParams.b() && layoutParams.d()) {
            if (!layoutParams.b()) {
                if (layoutParams.d()) {
                }
            }
            return layoutParams.b;
        }
        Rect rect = layoutParams.b;
        final int i3 = 0;
        rect.set(i3, i3, i3, i3);
        i = i3;
        while (i < this.H.size()) {
            this.A.set(i3, i3, i3, i3);
            (RecyclerView.o)this.H.get(i).getItemOffsets(this.A, view, this, this.A0);
            Rect rect4 = this.A;
            rect.left = left += left2;
            rect.top = top += top2;
            rect.right = right2 += right;
            rect.bottom = bottom2 += bottom;
            i++;
        }
        layoutParams.c = i3;
        return rect;
    }

    @Override // android.view.ViewGroup
    void p1(int i, int i2, int[] i3Arr3) {
        androidx.recyclerview.widget.RecyclerView.p view3;
        androidx.recyclerview.widget.RecyclerView.w view;
        androidx.recyclerview.widget.RecyclerView.b0 view2;
        int obj5;
        int obj6;
        z1();
        N0();
        i.a("RV Scroll");
        S(this.A0);
        int i3 = 0;
        if (i != 0) {
            obj5 = this.E.R1(i, this.b, this.A0);
        } else {
            obj5 = i3;
        }
        if (i2 != 0) {
            obj6 = this.E.T1(i2, this.b, this.A0);
        } else {
            obj6 = i3;
        }
        i.b();
        i1();
        O0();
        B1(i3);
        if (i3Arr3 != null) {
            i3Arr3[i3] = obj5;
            i3Arr3[1] = obj6;
        }
    }

    @Override // android.view.ViewGroup
    boolean q(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        List unmodifiedPayloads;
        int obj3;
        final androidx.recyclerview.widget.RecyclerView.m view = this.i0;
        if (view != null) {
            if (view.canReuseUpdatedViewHolder(e0, e0.getUnmodifiedPayloads())) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    @Override // android.view.ViewGroup
    public androidx.recyclerview.widget.RecyclerView.o q0(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0) {
        } else {
            if (i >= itemDecorationCount) {
            } else {
                return (RecyclerView.o)this.H.get(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(itemDecorationCount);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // android.view.ViewGroup
    public void q1(int i) {
        if (this.Q) {
        }
        D1();
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        view.S1(i);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        boolean tmpDetached;
        androidx.recyclerview.widget.RecyclerView.e0 view2 = RecyclerView.k0(view);
        if (view2 != null) {
            if (view2.isTmpDetached()) {
                view2.clearTmpDetachFlag();
            } else {
                if (!view2.shouldIgnore()) {
                } else {
                }
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
            obj4.append(view2);
            obj4.append(R());
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
        }
        view.clearAnimation();
        B(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup
    public void requestChildFocus(View view, View view2) {
        if (!this.E.v1(this, this.A0, view, view2) && view2 != null) {
            if (view2 != null) {
                j1(view, view2);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    public boolean requestChildRectangleOnScreen(View view, Rect rect2, boolean z3) {
        return this.E.M1(this, view, rect2, z3);
    }

    @Override // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int i;
        Object obj;
        i = 0;
        while (i < this.I.size()) {
            (RecyclerView.t)this.I.get(i).e(z);
            i++;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public void requestLayout() {
        int i;
        if (this.O == 0 && !this.Q) {
            if (!this.Q) {
                super.requestLayout();
            } else {
                this.P = true;
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public boolean s0() {
        boolean z;
        int i;
        if (this.N && !this.W) {
            if (!this.W) {
                if (this.v.p()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    boolean s1(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
        if (A0()) {
            e0.mPendingAccessibilityState = i2;
            this.O0.add(e0);
            return 0;
        }
        u.v0(e0.itemView, i2);
        return 1;
    }

    @Override // android.view.ViewGroup
    public void scrollBy(int i, int i2) {
        int z;
        int i3;
        int obj4;
        int obj5;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        if (this.Q) {
        }
        z = view.H();
        boolean z3 = this.E.I();
        if (!z) {
            if (z3) {
                i3 = 0;
                if (z) {
                } else {
                    obj4 = i3;
                }
                if (z3) {
                } else {
                    obj5 = i3;
                }
                o1(obj4, obj5, 0, i3);
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.ViewGroup
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (t1(accessibilityEvent)) {
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.v v) {
        this.H0 = v;
        u.l0(this, v);
    }

    @Override // android.view.ViewGroup
    public void setAdapter(androidx.recyclerview.widget.RecyclerView.h recyclerView$h) {
        final int i = 0;
        setLayoutFrozen(i);
        r1(h, i, true);
        W0(i);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setChildDrawingOrderCallback(androidx.recyclerview.widget.RecyclerView.k recyclerView$k) {
        int obj2;
        if (k == this.I0) {
        }
        this.I0 = k;
        obj2 = k != null ? 1 : 0;
        setChildrenDrawingOrderEnabled(obj2);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.y) {
            y0();
        }
        this.y = z;
        super.setClipToPadding(z);
        if (this.N) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setEdgeEffectFactory(androidx.recyclerview.widget.RecyclerView.l recyclerView$l) {
        i.c(l);
        this.d0 = l;
        y0();
    }

    @Override // android.view.ViewGroup
    public void setHasFixedSize(boolean z) {
        this.L = z;
    }

    @Override // android.view.ViewGroup
    public void setItemAnimator(androidx.recyclerview.widget.RecyclerView.m recyclerView$m) {
        androidx.recyclerview.widget.RecyclerView.m view;
        int i;
        view = this.i0;
        if (view != null) {
            view.endAnimations();
            this.i0.setListener(0);
        }
        this.i0 = m;
        if (m != null) {
            m.setListener(this.F0);
        }
    }

    @Override // android.view.ViewGroup
    public void setItemViewCacheSize(int i) {
        this.b.G(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Override // android.view.ViewGroup
    public void setLayoutManager(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        boolean z;
        Object view2;
        Object fVar;
        androidx.recyclerview.widget.RecyclerView.w view;
        int i;
        androidx.recyclerview.widget.RecyclerView.p obj4;
        if (p == this.E) {
        }
        D1();
        if (this.E != null) {
            androidx.recyclerview.widget.RecyclerView.m view5 = this.i0;
            if (view5 != null) {
                view5.endAnimations();
            }
            this.E.F1(this.b);
            this.E.G1(this.b);
            this.b.c();
            if (this.K) {
                this.E.X(this, this.b);
            }
            i = 0;
            this.E.a2(i);
            this.E = i;
        } else {
            this.b.c();
        }
        this.w.o();
        this.E = p;
        if (p != null) {
            if (p.b != null) {
            } else {
                p.a2(this);
                if (this.K) {
                    this.E.W(this);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LayoutManager ");
            stringBuilder.append(p);
            stringBuilder.append(" is already attached to a RecyclerView:");
            stringBuilder.append(p.b.R());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        this.b.K();
        requestLayout();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        int sDK_INT;
        int animator2;
        android.animation.Animator animator;
        int i = 0;
        if (Build.VERSION.SDK_INT < 18 && layoutTransition == null) {
            i = 0;
            if (layoutTransition == null) {
                suppressLayout(i);
            }
            sDK_INT = 1;
            if (layoutTransition.getAnimator(i) == null && layoutTransition.getAnimator(sDK_INT) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                sDK_INT = 1;
                if (layoutTransition.getAnimator(sDK_INT) == null) {
                    if (layoutTransition.getAnimator(2) == null) {
                        if (layoutTransition.getAnimator(3) == null) {
                            if (layoutTransition.getAnimator(animator2) == null) {
                                suppressLayout(sDK_INT);
                            }
                        }
                    }
                }
            }
        }
        if (layoutTransition != null) {
        } else {
            super.setLayoutTransition(0);
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        throw obj4;
    }

    @Override // android.view.ViewGroup
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m(z);
    }

    @Override // android.view.ViewGroup
    public void setOnFlingListener(androidx.recyclerview.widget.RecyclerView.s recyclerView$s) {
        this.r0 = s;
    }

    @Deprecated
    public void setOnScrollListener(androidx.recyclerview.widget.RecyclerView.u recyclerView$u) {
        this.B0 = u;
    }

    @Override // android.view.ViewGroup
    public void setPreserveFocusAfterLayout(boolean z) {
        this.w0 = z;
    }

    @Override // android.view.ViewGroup
    public void setRecycledViewPool(androidx.recyclerview.widget.RecyclerView.v recyclerView$v) {
        this.b.E(v);
    }

    @Deprecated
    public void setRecyclerListener(androidx.recyclerview.widget.RecyclerView.x recyclerView$x) {
        this.F = x;
    }

    @Override // android.view.ViewGroup
    void setScrollState(int i) {
        if (i == this.j0) {
        }
        this.j0 = i;
        if (i != 2) {
            E1();
        }
        J(i);
    }

    @Override // android.view.ViewGroup
    public void setScrollingTouchSlop(int i) {
        int str2;
        String str;
        int obj4;
        ViewConfiguration view = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
                stringBuilder.append(i);
                stringBuilder.append("; using default value");
                Log.w("RecyclerView", stringBuilder.toString());
                this.q0 = view.getScaledTouchSlop();
            } else {
                this.q0 = view.getScaledPagingTouchSlop();
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    public void setViewCacheExtension(androidx.recyclerview.widget.RecyclerView.c0 recyclerView$c0) {
        this.b.F(c0);
    }

    @Override // android.view.ViewGroup
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().o(i);
    }

    @Override // android.view.ViewGroup
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        boolean str;
        long l;
        long uptimeMillis;
        int i2;
        int i;
        int i3;
        int i4;
        boolean obj10;
        if (z != this.Q) {
            p("Do not suppressLayout in layout or scroll");
            if (!z) {
                obj10 = 0;
                this.Q = obj10;
                if (this.P && this.E != null && this.D != null) {
                    if (this.E != null) {
                        if (this.D != null) {
                            requestLayout();
                        }
                    }
                }
                this.P = obj10;
            } else {
                uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, obj2, uptimeMillis, obj4, 3, 0));
                obj10 = 1;
                this.Q = obj10;
                this.R = obj10;
                D1();
            }
        }
    }

    @Override // android.view.ViewGroup
    void t() {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        boolean ignore;
        i = 0;
        while (i < this.w.j()) {
            view = RecyclerView.k0(this.w.i(i));
            if (!view.shouldIgnore()) {
            }
            i++;
            view.clearOldPosition();
        }
        this.b.d();
    }

    @Override // android.view.ViewGroup
    boolean t1(AccessibilityEvent accessibilityEvent) {
        int i;
        int obj3;
        i = 0;
        if (A0()) {
            if (accessibilityEvent != null) {
                obj3 = b.a(accessibilityEvent);
            } else {
                obj3 = i;
            }
            if (obj3 == null) {
            } else {
                i = obj3;
            }
            this.S = obj3 |= i;
            return 1;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void u() {
        final List c0 = this.C0;
        if (c0 != null) {
            c0.clear();
        }
    }

    @Override // android.view.ViewGroup
    void u0() {
        RecyclerView.f fVar = new RecyclerView.f(this);
        a aVar = new a(fVar);
        this.v = aVar;
    }

    @Override // android.view.ViewGroup
    public void u1(int i, int i2) {
        v1(i, i2, 0);
    }

    @Override // android.view.ViewGroup
    void v(int i, int i2) {
        EdgeEffect finished2;
        boolean finished;
        EdgeEffect finished3;
        int obj3;
        finished2 = this.e0;
        if (finished2 != null && !finished2.isFinished() && i > 0) {
            if (!finished2.isFinished()) {
                if (i > 0) {
                    this.e0.onRelease();
                    finished = this.e0.isFinished();
                } else {
                    finished = 0;
                }
            } else {
            }
        } else {
        }
        finished3 = this.g0;
        if (finished3 != null && !finished3.isFinished() && i < 0) {
            if (!finished3.isFinished()) {
                if (i < 0) {
                    this.g0.onRelease();
                    finished |= obj3;
                }
            }
        }
        obj3 = this.f0;
        if (obj3 != null && !obj3.isFinished() && i2 > 0) {
            if (!obj3.isFinished()) {
                if (i2 > 0) {
                    this.f0.onRelease();
                    finished |= obj3;
                }
            }
        }
        obj3 = this.h0;
        if (obj3 != null && !obj3.isFinished() && i2 < 0) {
            if (!obj3.isFinished()) {
                if (i2 < 0) {
                    this.h0.onRelease();
                    finished |= obj3;
                }
            }
        }
        if (finished) {
            u.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public void v1(int i, int i2, Interpolator interpolator3) {
        w1(i, i2, interpolator3, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup
    void w() {
        int i;
        boolean z;
        boolean z3;
        boolean z2;
        int i2;
        final String str2 = "RV FullInvalidate";
        if (this.N) {
            if (this.W) {
            } else {
                if (!this.v.p()) {
                }
                if (this.v.o(4) && !this.v.o(11)) {
                    if (!this.v.o(11)) {
                        i.a("RV PartialInvalidate");
                        z1();
                        N0();
                        this.v.w();
                        if (!this.P) {
                            if (t0()) {
                                D();
                            } else {
                                this.v.i();
                            }
                        }
                        B1(true);
                        O0();
                        i.b();
                    } else {
                        if (this.v.p()) {
                            i.a(str2);
                            D();
                            i.b();
                        }
                    }
                } else {
                }
            }
        }
        i.a(str2);
        D();
        i.b();
    }

    @Override // android.view.ViewGroup
    public void w1(int i, int i2, Interpolator interpolator3, int i4) {
        this.x1(i, i2, interpolator3, i4, false);
    }

    @Override // android.view.ViewGroup
    void x0(StateListDrawable stateListDrawable, Drawable drawable2, StateListDrawable stateListDrawable3, Drawable drawable4) {
        if (stateListDrawable == null) {
        } else {
            if (drawable2 == null) {
            } else {
                if (stateListDrawable3 == null) {
                } else {
                    if (drawable4 == null) {
                    } else {
                        Resources resources = getContext().getResources();
                        j jVar = new j(this, stateListDrawable, drawable2, stateListDrawable3, drawable4, resources.getDimensionPixelSize(b.a), resources.getDimensionPixelSize(b.c), resources.getDimensionPixelOffset(b.b));
                    }
                }
            }
        }
        StringBuilder obj12 = new StringBuilder();
        obj12.append("Trying to set fast scroller without both required drawables.");
        obj12.append(R());
        IllegalArgumentException obj11 = new IllegalArgumentException(obj12.toString());
        throw obj11;
    }

    @Override // android.view.ViewGroup
    void x1(int i, int i2, Interpolator interpolator3, int i4, boolean z5) {
        int z;
        int i3;
        int i5;
        int obj4;
        int obj5;
        androidx.recyclerview.widget.RecyclerView.d0 obj8;
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        if (this.Q) {
        }
        i3 = 0;
        if (!view.H()) {
            obj4 = i3;
        }
        if (!this.E.I()) {
            obj5 = i3;
        }
        if (obj4 == null) {
            if (obj5 != null) {
                i5 = 1;
                if (i4 != Integer.MIN_VALUE) {
                    if (i4 > 0) {
                        z = i5;
                    } else {
                        z = i3;
                    }
                } else {
                }
                if (z != 0) {
                    if (z5 != null && obj4 != null) {
                        if (obj4 != null) {
                            i3 = i5;
                        }
                        if (obj5 != null) {
                            i3 |= 2;
                        }
                        A1(i3, i5);
                    }
                    this.x0.e(obj4, obj5, i4, interpolator3);
                } else {
                    scrollBy(obj4, obj5);
                }
            }
        } else {
        }
    }

    @Override // android.view.ViewGroup
    void y(int i, int i2) {
        setMeasuredDimension(RecyclerView.p.K(i, paddingLeft += paddingRight, u.D(this)), RecyclerView.p.K(i2, paddingTop += paddingBottom, u.C(this)));
    }

    @Override // android.view.ViewGroup
    void y0() {
        final int i = 0;
        this.h0 = i;
        this.f0 = i;
        this.g0 = i;
        this.e0 = i;
    }

    @Override // android.view.ViewGroup
    public void y1(int i) {
        if (this.Q) {
        }
        androidx.recyclerview.widget.RecyclerView.p view = this.E;
        if (view == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        view.e2(this, this.A0, i);
    }

    @Override // android.view.ViewGroup
    boolean z0() {
        AccessibilityManager enabled;
        int i;
        enabled = this.U;
        if (enabled != null && enabled.isEnabled()) {
            i = enabled.isEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    void z1() {
        int i;
        final int i3 = 1;
        i2 += i3;
        this.O = i;
        if (i == i3 && !this.Q) {
            if (!this.Q) {
                this.P = false;
            }
        }
    }
}
