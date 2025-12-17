package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.w;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.y;
import androidx.viewpager2.adapter.c;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.c.b;
import d.h.l.e0.f;
import d.h.l.u;
import d.w.a;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    static boolean M = true;
    private Parcelable A;
    RecyclerView B;
    private u C;
    androidx.viewpager2.widget.e D;
    private androidx.viewpager2.widget.b E;
    private androidx.viewpager2.widget.c F;
    private androidx.viewpager2.widget.d G;
    private RecyclerView.m H = null;
    private boolean I = false;
    private boolean J = true;
    private int K = -1;
    androidx.viewpager2.widget.ViewPager2.e L;
    private final Rect a;
    private final Rect b;
    private androidx.viewpager2.widget.b c;
    int v;
    boolean w = false;
    private RecyclerView.j x;
    private LinearLayoutManager y;
    private int z = -1;

    private abstract class e {
        private e(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            super();
        }

        e(androidx.viewpager2.widget.ViewPager2 viewPager2, androidx.viewpager2.widget.ViewPager2.a viewPager2$a2) {
            super(viewPager2);
        }

        boolean a() {
            return 0;
        }

        boolean b(int i) {
            return 0;
        }

        boolean c(int i, Bundle bundle2) {
            return 0;
        }

        boolean d() {
            return 0;
        }

        void e(RecyclerView.h<?> recyclerView$h) {
        }

        void f(RecyclerView.h<?> recyclerView$h) {
        }

        String g() {
            IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
            throw illegalStateException;
        }

        void h(androidx.viewpager2.widget.b b, RecyclerView recyclerView2) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(c c) {
        }

        boolean k(int i) {
            IllegalStateException obj2 = new IllegalStateException("Not implemented.");
            throw obj2;
        }

        boolean l(int i, Bundle bundle2) {
            IllegalStateException obj1 = new IllegalStateException("Not implemented.");
            throw obj1;
        }

        void m() {
        }

        java.lang.CharSequence n() {
            IllegalStateException illegalStateException = new IllegalStateException("Not implemented.");
            throw illegalStateException;
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }
    }

    public static abstract class i {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f2, int i3) {
        }

        public void onPageSelected(int i) {
        }
    }

    public interface k {
        public abstract void a(View view, float f2);
    }

    static class n extends View.BaseSavedState {

        public static final Parcelable.Creator<androidx.viewpager2.widget.ViewPager2.n> CREATOR;
        int a;
        int b;
        Parcelable c;
        static {
            ViewPager2.n.a aVar = new ViewPager2.n.a();
            ViewPager2.n.CREATOR = aVar;
        }

        n(Parcel parcel) {
            super(parcel);
            a(parcel, 0);
        }

        n(Parcel parcel, java.lang.ClassLoader classLoader2) {
            super(parcel, classLoader2);
            a(parcel, classLoader2);
        }

        n(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, java.lang.ClassLoader classLoader2) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader2);
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i2);
        }
    }

    private static class o implements Runnable {

        private final int a;
        private final RecyclerView b;
        o(int i, RecyclerView recyclerView2) {
            super();
            this.a = i;
            this.b = recyclerView2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.y1(this.a);
        }
    }

    class b extends androidx.viewpager2.widget.ViewPager2.i {

        final androidx.viewpager2.widget.ViewPager2 a;
        b(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.a = viewPager2;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            androidx.viewpager2.widget.ViewPager2 obj1;
            if (i == null) {
                this.a.o();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int obj3;
            final androidx.viewpager2.widget.ViewPager2 view = this.a;
            if (view.v != i) {
                view.v = i;
                view.L.q();
            }
        }
    }

    class c extends androidx.viewpager2.widget.ViewPager2.i {

        final androidx.viewpager2.widget.ViewPager2 a;
        c(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.a = viewPager2;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int i2;
            boolean obj2;
            this.a.clearFocus();
            if (this.a.hasFocus()) {
                obj2.B.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.r {
        d(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$r
        public void b(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView$r
        public void d(View view) {
            ViewGroup.LayoutParams obj3;
            obj3 = view.getLayoutParams();
            final int i = -1;
            if (obj3.width != i) {
            } else {
                if (obj3.height != i) {
                } else {
                }
            }
            obj3 = new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            throw obj3;
        }
    }

    class f extends androidx.viewpager2.widget.ViewPager2.e {

        final androidx.viewpager2.widget.ViewPager2 a;
        f(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.a = viewPager2;
            super(viewPager2, 0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean b(int i) {
            int i2;
            int obj2;
            if (i != 8192) {
                if (i == 4096 && !this.a.f()) {
                    obj2 = !this.a.f() ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean d() {
            return 1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void j(c c) {
            boolean z;
            if (!this.a.f()) {
                c.P(c.a.g);
                c.P(c.a.f);
                c.q0(false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean k(int i) {
            if (!b(i)) {
            } else {
                return 0;
            }
            IllegalStateException obj1 = new IllegalStateException();
            throw obj1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public java.lang.CharSequence n() {
            if (!d()) {
            } else {
                return "androidx.viewpager.widget.ViewPager";
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    private static abstract class g extends RecyclerView.j {
        g(androidx.viewpager2.widget.ViewPager2.a viewPager2$a) {
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public final void onItemRangeChanged(int i, int i2, Object object3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }
    }

    class j extends androidx.viewpager2.widget.ViewPager2.e {

        private final f a;
        private final f b;
        private RecyclerView.j c;
        final androidx.viewpager2.widget.ViewPager2 d;
        j(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.d = viewPager2;
            super(viewPager2, 0);
            ViewPager2.j.a obj2 = new ViewPager2.j.a(this);
            this.a = obj2;
            obj2 = new ViewPager2.j.b(this);
            this.b = obj2;
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int i;
            final int i2 = 0;
            if (this.d.getAdapter() != null) {
                if (this.d.getOrientation() == 1) {
                    itemCount = this.d.getAdapter().getItemCount();
                    i = i2;
                } else {
                    i = itemCount2;
                    itemCount = i2;
                }
            } else {
                i = itemCount;
            }
            c.y0(accessibilityNodeInfo).Z(c.b.a(itemCount, i, i2, i2));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int i;
            int z;
            int i2;
            RecyclerView.h adapter = this.d.getAdapter();
            if (adapter == null) {
            }
            itemCount = adapter.getItemCount();
            if (itemCount != 0) {
                if (!this.d.f()) {
                } else {
                    if (view3.v > 0) {
                        accessibilityNodeInfo.addAction(8192);
                    }
                    i2 = 1;
                    if (view4.v < itemCount -= i2) {
                        accessibilityNodeInfo.addAction(4096);
                    }
                    accessibilityNodeInfo.setScrollable(i2);
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean a() {
            return 1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean c(int i, Bundle bundle2) {
            int obj1;
            int obj2;
            if (i != 8192) {
                if (i == 4096) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }

        public void e(RecyclerView.h<?> recyclerView$h) {
            RecyclerView.j view;
            w();
            if (h != null) {
                h.registerAdapterDataObserver(this.c);
            }
        }

        public void f(RecyclerView.h<?> recyclerView$h) {
            RecyclerView.j view;
            if (h != null) {
                h.unregisterAdapterDataObserver(this.c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public String g() {
            if (!a()) {
            } else {
                return "androidx.viewpager.widget.ViewPager";
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void h(androidx.viewpager2.widget.b b, RecyclerView recyclerView2) {
            int obj1;
            View obj2;
            u.v0(recyclerView2, 2);
            obj1 = new ViewPager2.j.c(this);
            this.c = obj1;
            if (u.z(this.d) == 0) {
                u.v0(this.d, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                u(accessibilityNodeInfo);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public boolean l(int i, Bundle bundle2) {
            int obj2;
            if (!c(i, bundle2)) {
            } else {
                final int i2 = 1;
                if (i == 8192) {
                    obj2 -= i2;
                } else {
                    obj2 += i2;
                }
                v(obj2);
                return i2;
            }
            obj2 = new IllegalStateException();
            throw obj2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(this.d);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        public void s() {
            int sDK_INT;
            int i;
            w();
            if (Build.VERSION.SDK_INT < 21) {
                this.d.sendAccessibilityEvent(2048);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        void v(int i) {
            boolean z;
            int i2;
            if (this.d.f()) {
                this.d.l(i, true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$e
        void w() {
            int aVar;
            int aVar4;
            int aVar3;
            int aVar2;
            boolean i2;
            int i;
            int i3;
            final androidx.viewpager2.widget.ViewPager2 view = this.d;
            aVar = 16908360;
            u.f0(view, aVar);
            aVar3 = 16908361;
            u.f0(view, aVar3);
            i2 = 16908358;
            u.f0(view, i2);
            i = 16908359;
            u.f0(view, i);
            if (this.d.getAdapter() == null) {
            }
            int itemCount = this.d.getAdapter().getItemCount();
            if (itemCount == 0) {
            }
            if (!this.d.f()) {
            }
            final int i4 = 0;
            if (this.d.getOrientation() == 0) {
                i2 = this.d.e();
                i = i2 ? aVar : aVar3;
                if (i2) {
                    aVar = aVar3;
                }
                if (view4.v < itemCount--) {
                    aVar2 = new c.a(i, i4);
                    u.h0(view, aVar2, i4, this.a);
                }
                if (view5.v > 0) {
                    aVar3 = new c.a(aVar, i4);
                    u.h0(view, aVar3, i4, this.b);
                }
            } else {
                if (view2.v < itemCount--) {
                    aVar4 = new c.a(i, i4);
                    u.h0(view, aVar4, i4, this.a);
                }
                if (view3.v > 0) {
                    aVar = new c.a(i2, i4);
                    u.h0(view, aVar, i4, this.b);
                }
            }
        }
    }

    class a extends androidx.viewpager2.widget.ViewPager2.g {

        final androidx.viewpager2.widget.ViewPager2 a;
        a(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.a = viewPager2;
            super(0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2$g
        public void onChanged() {
            androidx.viewpager2.widget.ViewPager2 view = this.a;
            view.w = true;
            view.D.j();
        }
    }

    private class h extends LinearLayoutManager {

        final androidx.viewpager2.widget.ViewPager2 I;
        h(androidx.viewpager2.widget.ViewPager2 viewPager2, Context context2) {
            this.I = viewPager2;
            super(context2);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public boolean B1(RecyclerView.w recyclerView$w, RecyclerView.b0 recyclerView$b02, int i3, Bundle bundle4) {
            if (view.L.b(i3)) {
                return obj2.L.k(i3);
            }
            return super.B1(w, b02, i3, bundle4);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public boolean N1(RecyclerView recyclerView, View view2, Rect rect3, boolean z4, boolean z5) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void h1(RecyclerView.w recyclerView$w, RecyclerView.b0 recyclerView$b02, c c3) {
            super.h1(w, b02, c3);
            obj1.L.j(c3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void i2(RecyclerView.b0 recyclerView$b0, int[] i2Arr2) {
            int offscreenPageLimit = this.I.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.i2(b0, i2Arr2);
            }
            obj3 *= offscreenPageLimit;
            i2Arr2[0] = obj3;
            i2Arr2[1] = obj3;
        }
    }

    private class m extends RecyclerView {

        final androidx.viewpager2.widget.ViewPager2 d1;
        m(androidx.viewpager2.widget.ViewPager2 viewPager2, Context context2) {
            this.d1 = viewPager2;
            super(context2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public java.lang.CharSequence getAccessibilityClassName() {
            if (view.L.d()) {
                return view3.L.n();
            }
            return super.getAccessibilityClassName();
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(view.v);
            accessibilityEvent.setToIndex(view2.v);
            view3.L.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            MotionEvent obj2;
            if (this.d1.f() && super.onInterceptTouchEvent(motionEvent)) {
                obj2 = super.onInterceptTouchEvent(motionEvent) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean onTouchEvent(MotionEvent motionEvent) {
            MotionEvent obj2;
            if (this.d1.f() && super.onTouchEvent(motionEvent)) {
                obj2 = super.onTouchEvent(motionEvent) ? 1 : 0;
            } else {
            }
            return obj2;
        }
    }

    private class l extends u {

        final androidx.viewpager2.widget.ViewPager2 e;
        l(androidx.viewpager2.widget.ViewPager2 viewPager2) {
            this.e = viewPager2;
            super();
        }

        @Override // androidx.recyclerview.widget.u
        public View g(RecyclerView.p recyclerView$p) {
            int obj2;
            if (this.e.d()) {
                obj2 = 0;
            } else {
                obj2 = super.g(p);
            }
            return obj2;
        }
    }
    static {
    }

    public ViewPager2(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Rect rect = new Rect();
        this.a = rect;
        Rect rect2 = new Rect();
        this.b = rect2;
        b bVar = new b(3);
        this.c = bVar;
        int i = 0;
        ViewPager2.a aVar = new ViewPager2.a(this);
        this.x = aVar;
        int i4 = -1;
        final int i5 = 0;
        int i2 = 1;
        c(context, attributeSet2);
    }

    private RecyclerView.r b() {
        ViewPager2.d dVar = new ViewPager2.d(this);
        return dVar;
    }

    private void c(Context context, AttributeSet attributeSet2) {
        androidx.viewpager2.widget.ViewPager2.e jVar;
        if (ViewPager2.M) {
            jVar = new ViewPager2.j(this);
        } else {
            jVar = new ViewPager2.f(this);
        }
        this.L = jVar;
        ViewPager2.m mVar = new ViewPager2.m(this, context);
        this.B = mVar;
        mVar.setId(u.k());
        this.B.setDescendantFocusability(131072);
        ViewPager2.h hVar = new ViewPager2.h(this, context);
        this.y = hVar;
        this.B.setLayoutManager(hVar);
        this.B.setScrollingTouchSlop(1);
        m(context, attributeSet2);
        int i = -1;
        ViewGroup.LayoutParams obj4 = new ViewGroup.LayoutParams(i, i);
        this.B.setLayoutParams(obj4);
        this.B.j(b());
        e obj3 = new e(this);
        this.D = obj3;
        obj4 = new c(this, obj3, this.B);
        this.F = obj4;
        obj3 = new ViewPager2.l(this);
        this.C = obj3;
        obj3.b(this.B);
        this.B.l(this.D);
        obj3 = new b(3);
        this.E = obj3;
        this.D.m(obj3);
        obj3 = new ViewPager2.b(this);
        obj4 = new ViewPager2.c(this);
        this.E.a(obj3);
        this.E.a(obj4);
        this.L.h(this.E, this.B);
        this.E.a(this.c);
        obj3 = new d(this.y);
        this.G = obj3;
        this.E.a(obj3);
        obj3 = this.B;
        attachViewToParent(obj3, 0, obj3.getLayoutParams());
    }

    private void g(RecyclerView.h<?> recyclerView$h) {
        RecyclerView.j view;
        if (h != null) {
            h.registerAdapterDataObserver(this.x);
        }
    }

    private void j() {
        Parcelable parcelable;
        boolean z;
        int i5 = -1;
        if (this.z == i5) {
        }
        RecyclerView.h adapter = getAdapter();
        if (adapter == null) {
        }
        parcelable = this.A;
        if (parcelable != null && adapter instanceof c) {
            if (adapter instanceof c) {
                (c)adapter.b(parcelable);
            }
            this.A = 0;
        }
        int i4 = Math.max(0, Math.min(this.z, itemCount--));
        this.v = i4;
        this.z = i5;
        this.B.q1(i4);
        this.L.m();
    }

    private void m(Context context, AttributeSet attributeSet2) {
        int sDK_INT;
        int i;
        AttributeSet set;
        TypedArray typedArray;
        int i3;
        int i2;
        final int[] iArr = a.a;
        final TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            this.saveAttributeDataForStyleable(context, iArr, attributeSet2, styledAttributes, 0, 0);
        }
        setOrientation(styledAttributes.getInt(a.b, 0));
        styledAttributes.recycle();
    }

    private void n(RecyclerView.h<?> recyclerView$h) {
        RecyclerView.j view;
        if (h != null) {
            h.unregisterAdapterDataObserver(this.x);
        }
    }

    @Override // android.view.ViewGroup
    public void a(RecyclerView.o recyclerView$o) {
        this.B.h(o);
    }

    @Override // android.view.ViewGroup
    public boolean canScrollHorizontally(int i) {
        return this.B.canScrollHorizontally(i);
    }

    @Override // android.view.ViewGroup
    public boolean canScrollVertically(int i) {
        return this.B.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup
    public boolean d() {
        return this.F.a();
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Object obj;
        boolean z;
        Object obj2;
        obj = sparseArray.get(getId());
        if (obj instanceof ViewPager2.n) {
            obj = obj.a;
            sparseArray.put(this.B.getId(), sparseArray.get(obj));
            sparseArray.remove(obj);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        j();
    }

    @Override // android.view.ViewGroup
    boolean e() {
        int i;
        if (this.y.w0() == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean f() {
        return this.J;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getAccessibilityClassName() {
        if (this.L.a()) {
            return this.L.g();
        }
        return super.getAccessibilityClassName();
    }

    @Override // android.view.ViewGroup
    public RecyclerView.h getAdapter() {
        return this.B.getAdapter();
    }

    @Override // android.view.ViewGroup
    public int getCurrentItem() {
        return this.v;
    }

    @Override // android.view.ViewGroup
    public int getItemDecorationCount() {
        return this.B.getItemDecorationCount();
    }

    @Override // android.view.ViewGroup
    public int getOffscreenPageLimit() {
        return this.K;
    }

    @Override // android.view.ViewGroup
    public int getOrientation() {
        return this.y.J2();
    }

    @Override // android.view.ViewGroup
    int getPageSize() {
        int paddingBottom;
        int i;
        int paddingLeft;
        RecyclerView view = this.B;
        if (getOrientation() == 0) {
            width -= paddingLeft;
            paddingBottom = view.getPaddingRight();
        } else {
            height -= paddingLeft;
            paddingBottom = view.getPaddingBottom();
        }
        return i -= paddingBottom;
    }

    @Override // android.view.ViewGroup
    public int getScrollState() {
        return this.D.f();
    }

    @Override // android.view.ViewGroup
    public void h(androidx.viewpager2.widget.ViewPager2.i viewPager2$i) {
        this.c.a(i);
    }

    @Override // android.view.ViewGroup
    public void i() {
        if (this.G.a() == null) {
        }
        double d = this.D.e();
        final int i3 = (int)d;
        float f = (float)i;
        this.G.onPageScrolled(i3, f, Math.round(f2 *= f));
    }

    @Override // android.view.ViewGroup
    public void k(int i, boolean z2) {
        if (d()) {
        } else {
            l(i, z2);
        }
        IllegalStateException obj2 = new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        throw obj2;
    }

    @Override // android.view.ViewGroup
    void l(int i, boolean z2) {
        int i3;
        double oVar;
        int i2;
        int obj9;
        RecyclerView obj10;
        RecyclerView.h adapter = getAdapter();
        final int i7 = 0;
        if (adapter == null && this.z != -1) {
            if (this.z != -1) {
                this.z = Math.max(i, i7);
            }
        }
        if (adapter.getItemCount() <= 0) {
        }
        obj9 = Math.min(Math.max(i, i7), itemCount--);
        if (obj9 == this.v && this.D.h()) {
            if (this.D.h()) {
            }
        }
        int i6 = this.v;
        if (obj9 == i6 && z2) {
            if (z2) {
            }
        }
        oVar = (double)i6;
        this.v = obj9;
        this.L.q();
        if (!this.D.h()) {
            oVar = this.D.e();
        }
        this.D.k(obj9, z2);
        if (!z2) {
            this.B.q1(obj9);
        }
        double d = (double)obj9;
        if (Double.compare(d2, l) > 0) {
            i2 = Double.compare(d, oVar) > 0 ? obj9 + -3 : obj9 + 3;
            this.B.q1(i2);
            obj10 = this.B;
            oVar = new ViewPager2.o(obj9, obj10);
            obj10.post(oVar);
        } else {
            this.B.y1(obj9);
        }
    }

    @Override // android.view.ViewGroup
    void o() {
        int scrollState;
        u uVar = this.C;
        if (uVar == null) {
        } else {
            View view = uVar.g(this.y);
            if (view == null) {
            }
            int i = this.y.A0(view);
            if (i != this.v && getScrollState() == 0) {
                if (getScrollState() == 0) {
                    this.E.onPageSelected(i);
                }
            }
            this.w = false;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Design assumption violated.");
        throw illegalStateException;
    }

    @Override // android.view.ViewGroup
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.L.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        rect.left = getPaddingLeft();
        rect2.right = obj7 -= obj5;
        obj5.top = getPaddingTop();
        obj5.bottom = obj8 -= obj6;
        Gravity.apply(8388659, this.B.getMeasuredWidth(), this.B.getMeasuredHeight(), this.a, this.b);
        Rect obj5 = this.b;
        this.B.layout(obj5.left, obj5.top, obj5.right, obj5.bottom);
        if (this.w) {
            o();
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        measureChild(this.B, i, i2);
        int measuredState = this.B.getMeasuredState();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(measuredWidth += i8, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(measuredHeight += i9, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.ViewGroup
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof ViewPager2.n) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((ViewPager2.n)parcelable.getSuperState());
        this.z = parcelable.b;
        this.A = parcelable.c;
    }

    @Override // android.view.ViewGroup
    protected Parcelable onSaveInstanceState() {
        int i2;
        Object adapter;
        int i;
        ViewPager2.n nVar = new ViewPager2.n(super.onSaveInstanceState());
        nVar.a = this.B.getId();
        if (this.z == -1) {
            i2 = this.v;
        }
        nVar.b = i2;
        adapter = this.A;
        if (adapter != null) {
            nVar.c = adapter;
        } else {
            adapter = this.B.getAdapter();
            if (adapter instanceof c) {
                nVar.c = (c)adapter.a();
            }
        }
        return nVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ViewPager2.class.getSimpleName());
        stringBuilder.append(" does not support direct child views");
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
        throw obj3;
    }

    @Override // android.view.ViewGroup
    public boolean performAccessibilityAction(int i, Bundle bundle2) {
        if (this.L.c(i, bundle2)) {
            return this.L.l(i, bundle2);
        }
        return super.performAccessibilityAction(i, bundle2);
    }

    @Override // android.view.ViewGroup
    public void setAdapter(RecyclerView.h recyclerView$h) {
        RecyclerView.h adapter = this.B.getAdapter();
        this.L.f(adapter);
        n(adapter);
        this.B.setAdapter(h);
        this.v = 0;
        j();
        this.L.e(h);
        g(h);
    }

    @Override // android.view.ViewGroup
    public void setCurrentItem(int i) {
        k(i, true);
    }

    @Override // android.view.ViewGroup
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.L.p();
    }

    @Override // android.view.ViewGroup
    public void setOffscreenPageLimit(int i) {
        int i2;
        if (i < 1) {
            if (i != -1) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
            throw obj2;
        }
        this.K = i;
        this.B.requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setOrientation(int i) {
        this.y.X2(i);
        this.L.r();
    }

    @Override // android.view.ViewGroup
    public void setPageTransformer(androidx.viewpager2.widget.ViewPager2.k viewPager2$k) {
        int i;
        RecyclerView view2;
        boolean z;
        RecyclerView.m view;
        i = 0;
        if (k != null) {
            if (!this.I) {
                this.H = this.B.getItemAnimator();
                this.I = true;
            }
            this.B.setItemAnimator(i);
        } else {
            if (this.I) {
                this.B.setItemAnimator(this.H);
                this.H = i;
                this.I = false;
            }
        }
        if (k == this.G.a()) {
        }
        this.G.b(k);
        i();
    }

    @Override // android.view.ViewGroup
    public void setUserInputEnabled(boolean z) {
        this.J = z;
        this.L.s();
    }
}
