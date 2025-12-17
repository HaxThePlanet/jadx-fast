package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.a;
import d.h.l.a;
import d.h.l.d0;
import d.h.l.e0.c;
import d.h.l.q;
import d.h.l.u;
import d.j.a.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    private static final androidx.viewpager.widget.ViewPager.o A0;
    static final int[] x0;
    private static final Comparator<androidx.viewpager.widget.ViewPager.f> y0;
    private static final Interpolator z0;
    private java.lang.ClassLoader A = null;
    private Scroller B;
    private boolean C;
    private androidx.viewpager.widget.ViewPager.l D;
    private int E;
    private Drawable F;
    private int G;
    private int H;
    private float I = -340282350000000000000000000000000000000f;
    private float J = 340282350000000000000000000000000000000f;
    private int K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int O = 1;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private float U;
    private float V;
    private float W;
    private int a;
    private float a0;
    private final ArrayList<androidx.viewpager.widget.ViewPager.f> b;
    private int b0 = -1;
    private final androidx.viewpager.widget.ViewPager.f c;
    private VelocityTracker c0;
    private int d0;
    private int e0;
    private int f0;
    private int g0;
    private boolean h0;
    private EdgeEffect i0;
    private EdgeEffect j0;
    private boolean k0 = true;
    private boolean l0;
    private int m0;
    private List<androidx.viewpager.widget.ViewPager.j> n0;
    private androidx.viewpager.widget.ViewPager.j o0;
    private androidx.viewpager.widget.ViewPager.j p0;
    private List<androidx.viewpager.widget.ViewPager.i> q0;
    private androidx.viewpager.widget.ViewPager.k r0;
    private int s0;
    private int t0;
    private ArrayList<View> u0;
    private final Rect v;
    private final Runnable v0;
    androidx.viewpager.widget.a w;
    private int w0 = 0;
    int x;
    private int y = -1;
    private Parcelable z = null;

    static class a implements Comparator<androidx.viewpager.widget.ViewPager.f> {
        @Override // java.util.Comparator
        public int a(androidx.viewpager.widget.ViewPager.f viewPager$f, androidx.viewpager.widget.ViewPager.f viewPager$f2) {
            return obj1 -= obj2;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((ViewPager.f)object, (ViewPager.f)object2);
        }
    }

    static class b implements Interpolator {
        @Override // android.view.animation.Interpolator
        public float getInterpolation(float f) {
            final int i = 1065353216;
            f -= i;
            return i5 += i;
        }
    }

    class c implements Runnable {

        final androidx.viewpager.widget.ViewPager a;
        c(androidx.viewpager.widget.ViewPager viewPager) {
            this.a = viewPager;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setScrollState(0);
            this.a.E();
        }
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface e {
    }

    static class f {

        Object a;
        int b;
        boolean c;
        float d;
        float e;
    }

    public static class g extends ViewGroup.LayoutParams {

        public boolean a;
        public int b;
        float c = 0f;
        boolean d;
        int e;
        int f;
        public g() {
            int i = -1;
            super(i, i);
            int i2 = 0;
        }

        public g(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            int i = 0;
            final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, ViewPager.x0);
            this.b = obj2.getInteger(0, 48);
            obj2.recycle();
        }
    }

    public interface i {
        public abstract void a(androidx.viewpager.widget.ViewPager viewPager, androidx.viewpager.widget.a a2, androidx.viewpager.widget.a a3);
    }

    public interface j {
        public abstract void onPageScrollStateChanged(int i);

        public abstract void onPageScrolled(int i, float f2, int i3);

        public abstract void onPageSelected(int i);
    }

    public interface k {
        public abstract void a(View view, float f2);
    }

    private class l extends DataSetObserver {

        final androidx.viewpager.widget.ViewPager a;
        l(androidx.viewpager.widget.ViewPager viewPager) {
            this.a = viewPager;
            super();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.a.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.h();
        }
    }

    static class o implements Comparator<View> {
        @Override // java.util.Comparator
        public int a(View view, View view2) {
            int obj3;
            obj3 = view.getLayoutParams();
            ViewGroup.LayoutParams obj4 = view2.getLayoutParams();
            final boolean z = obj3.a;
            if (z != obj4.a) {
                obj3 = z ? 1 : -1;
                return obj3;
            }
            return obj3 -= obj4;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((View)object, (View)object2);
        }
    }

    class d implements q {

        private final Rect a;
        final androidx.viewpager.widget.ViewPager b;
        d(androidx.viewpager.widget.ViewPager viewPager) {
            this.b = viewPager;
            super();
            Rect obj1 = new Rect();
            this.a = obj1;
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            int i;
            int i2;
            int bottom;
            int right;
            d0 obj6 = u.Y(view, d02);
            if (obj6.o()) {
                return obj6;
            }
            Rect obj7 = this.a;
            obj7.left = obj6.j();
            obj7.top = obj6.l();
            obj7.right = obj6.k();
            obj7.bottom = obj6.i();
            i = 0;
            while (i < this.b.getChildCount()) {
                d0 d0Var = u.h(this.b.getChildAt(i), obj6);
                obj7.left = Math.min(d0Var.j(), obj7.left);
                obj7.top = Math.min(d0Var.l(), obj7.top);
                obj7.right = Math.min(d0Var.k(), obj7.right);
                obj7.bottom = Math.min(d0Var.i(), obj7.bottom);
                i++;
            }
            return obj6.p(obj7.left, obj7.top, obj7.right, obj7.bottom);
        }
    }

    class h extends a {

        final androidx.viewpager.widget.ViewPager d;
        h(androidx.viewpager.widget.ViewPager viewPager) {
            this.d = viewPager;
            super();
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar;
            int i;
            aVar = view.w;
            if (aVar != null && aVar.d() > 1) {
                if (aVar.d() > 1) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // d.h.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent2) {
            int obj2;
            super.f(view, accessibilityEvent2);
            accessibilityEvent2.setClassName(ViewPager.class.getName());
            accessibilityEvent2.setScrollable(n());
            obj2 = obj2.w;
            if (accessibilityEvent2.getEventType() == 4096 && obj2 != null) {
                obj2 = obj2.w;
                if (obj2 != null) {
                    accessibilityEvent2.setItemCount(obj2.d());
                    accessibilityEvent2.setFromIndex(obj2.x);
                    accessibilityEvent2.setToIndex(obj2.x);
                }
            }
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            boolean obj2;
            super.g(view, c2);
            c2.X(ViewPager.class.getName());
            c2.q0(n());
            if (this.d.canScrollHorizontally(1)) {
                c2.a(4096);
            }
            if (this.d.canScrollHorizontally(-1)) {
                c2.a(8192);
            }
        }

        @Override // d.h.l.a
        public boolean j(View view, int i2, Bundle bundle3) {
            final int obj4 = 1;
            if (super.j(view, i2, bundle3)) {
                return obj4;
            }
            final int i = 0;
            if (i2 != 4096 && i2 != 8192) {
                if (i2 != 8192) {
                    return i;
                }
                if (this.d.canScrollHorizontally(-1)) {
                    androidx.viewpager.widget.ViewPager obj2 = this.d;
                    obj2.setCurrentItem(obj3 -= obj4);
                    return obj4;
                }
                return i;
            }
            if (this.d.canScrollHorizontally(obj4)) {
                obj2 = this.d;
                obj2.setCurrentItem(obj3 += obj4);
                return obj4;
            }
            return i;
        }
    }

    public static class m extends a {

        public static final Parcelable.Creator<androidx.viewpager.widget.ViewPager.m> CREATOR;
        int c;
        Parcelable v;
        java.lang.ClassLoader w;
        static {
            ViewPager.m.a aVar = new ViewPager.m.a();
            ViewPager.m.CREATOR = aVar;
        }

        m(Parcel parcel, java.lang.ClassLoader classLoader2) {
            java.lang.ClassLoader obj3;
            super(parcel, classLoader2);
            if (classLoader2 == null) {
                obj3 = ViewPager.m.class.getClassLoader();
            }
            this.c = parcel.readInt();
            this.v = parcel.readParcelable(obj3);
            this.w = obj3;
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.c);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.v, i2);
        }
    }

    public static class n implements androidx.viewpager.widget.ViewPager.j {
        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageScrolled(int i, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageSelected(int i) {
        }
    }
    static {
        int[] iArr = new int[1];
        ViewPager.x0 = iArr;
        ViewPager.a aVar = new ViewPager.a();
        ViewPager.y0 = aVar;
        ViewPager.b bVar = new ViewPager.b();
        ViewPager.z0 = bVar;
        ViewPager.o oVar = new ViewPager.o();
        ViewPager.A0 = oVar;
    }

    public ViewPager(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList obj1 = new ArrayList();
        this.b = obj1;
        obj1 = new ViewPager.f();
        this.c = obj1;
        obj1 = new Rect();
        this.v = obj1;
        obj1 = -1;
        int obj2 = 0;
        obj2 = -8388609;
        obj2 = 2139095039;
        obj2 = 1;
        obj1 = new ViewPager.c(this);
        this.v0 = obj1;
        obj1 = 0;
        v();
    }

    private boolean C(int i) {
        final String str = "onPageScrolled did not call superclass implementation";
        final int i5 = 0;
        if (this.b.size() == 0 && this.k0) {
            if (this.k0) {
                return i5;
            }
            this.l0 = i5;
            y(i5, 0, i5);
            if (!this.l0) {
            } else {
                return i5;
            }
            IllegalStateException obj8 = new IllegalStateException(str);
            throw obj8;
        }
        androidx.viewpager.widget.ViewPager.f view = t();
        int clientWidth = getClientWidth();
        int i6 = this.E;
        float f3 = (float)clientWidth;
        obj8 /= i2;
        this.l0 = i5;
        y(view.b, obj8, (int)i3);
        if (!this.l0) {
        } else {
            return 1;
        }
        obj8 = new IllegalStateException(str);
        throw obj8;
    }

    private boolean D(float f) {
        int cmp;
        int i3;
        int i;
        int i2;
        int i4;
        int obj10;
        this.U = f;
        obj10 += i5;
        float f3 = (float)clientWidth;
        f5 *= f3;
        f7 *= f3;
        i2 = 0;
        Object obj = this.b.get(i2);
        ArrayList list2 = this.b;
        final int i11 = 1;
        Object obj2 = list2.get(size -= i11);
        if (obj.b != 0) {
            f6 *= f3;
            i = i2;
        } else {
            i = i11;
        }
        if (obj2.b != i12 -= i11) {
            f9 *= f3;
            i4 = i2;
        } else {
            i4 = i11;
        }
        if (Float.compare(obj10, cmp) < 0) {
            if (i != 0) {
                this.i0.onPull(obj10 /= f3);
                i2 = i11;
            }
            obj10 = cmp;
        } else {
            if (Float.compare(obj10, i3) > 0 && i4 != 0) {
                if (i4 != 0) {
                    this.j0.onPull(obj10 /= f3);
                    i2 = i11;
                }
                obj10 = i3;
            }
        }
        int i7 = (int)obj10;
        this.U = f4 += obj10;
        scrollTo(i7, getScrollY());
        C(i7);
        return i2;
    }

    private void G(int i, int i2, int i3, int i4) {
        boolean paddingRight;
        int obj2;
        int obj3;
        int obj4;
        if (i2 > 0 && !this.b.isEmpty()) {
            if (!this.b.isEmpty()) {
                if (!this.B.isFinished()) {
                    this.B.setFinalX(obj3 *= obj4);
                } else {
                    scrollTo((int)obj4, getScrollY());
                }
            } else {
                obj3 = u(this.x);
                if (obj3 != null) {
                    obj3 = Math.min(obj3.e, this.J);
                } else {
                    obj3 = 0;
                }
                obj2 = (int)obj3;
                if (obj2 != getScrollX()) {
                    g(false);
                    scrollTo(obj2, getScrollY());
                }
            }
        } else {
        }
    }

    private void H() {
        int i;
        boolean z;
        i = 0;
        while (i < getChildCount()) {
            if (!layoutParams.a) {
            }
            i++;
            removeViewAt(i);
            i--;
        }
    }

    private void K(boolean z) {
        final ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean L() {
        int i;
        boolean finished;
        this.b0 = -1;
        o();
        this.i0.onRelease();
        this.j0.onRelease();
        if (!this.i0.isFinished()) {
            if (this.j0.isFinished()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private void M(int i, boolean z2, int i3, boolean z4) {
        int i2;
        int i4;
        float f;
        float f2;
        androidx.viewpager.widget.ViewPager.f view = u(i);
        final int i5 = 0;
        if (view != null) {
            i2 = (int)i4;
        } else {
            i2 = i5;
        }
        if (z2) {
            S(i2, i5, i3);
            if (z4) {
                k(i);
            }
        } else {
            if (z4) {
                k(i);
            }
            g(i5);
            scrollTo(i2, i5);
            C(i2);
        }
    }

    private void T() {
        ArrayList arrayList;
        int i2;
        int i;
        androidx.viewpager.widget.ViewPager.o view;
        View childAt;
        ArrayList list;
        if (this.t0 != 0) {
            arrayList = this.u0;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.u0 = arrayList;
            } else {
                arrayList.clear();
            }
            i = 0;
            while (i < getChildCount()) {
                this.u0.add(getChildAt(i));
                i++;
            }
            Collections.sort(this.u0, ViewPager.A0);
        }
    }

    private void e(androidx.viewpager.widget.ViewPager.f viewPager$f, int i2, androidx.viewpager.widget.ViewPager.f viewPager$f3) {
        int clientWidth;
        float f2;
        int i8;
        int i;
        int i7;
        int i6;
        int i10;
        float f4;
        Object obj;
        int i3;
        int i11;
        int i4;
        Object obj2;
        int i5;
        int i9;
        int obj10;
        int obj11;
        float obj12;
        clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f6 /= clientWidth;
        } else {
            i = 0;
        }
        if (f3 != null) {
            clientWidth = f3.b;
            i7 = f.b;
            if (clientWidth < i7) {
                i7 = 0;
                i18 += i;
                clientWidth++;
                while (clientWidth <= f.b) {
                    if (i7 < this.b.size()) {
                    }
                    obj12 = this.b.get(i7);
                    while (clientWidth > obj12.b) {
                        if (i7 < size2--) {
                        }
                        obj12 = this.b.get(i7++);
                    }
                    while (clientWidth < obj12.b) {
                        obj += i11;
                        clientWidth++;
                    }
                    obj12.e = obj;
                    obj += obj12;
                    clientWidth++;
                    obj += i11;
                    clientWidth++;
                    if (i7 < size2--) {
                    }
                    obj12 = this.b.get(i7++);
                }
            } else {
                if (clientWidth > i7) {
                    size--;
                    obj12 = f3.e;
                    clientWidth--;
                    while (clientWidth >= f.b) {
                        if (i7 >= 0) {
                        }
                        obj = this.b.get(i7);
                        while (clientWidth < obj.b) {
                            if (i7 > 0) {
                            }
                            obj = this.b.get(i7--);
                        }
                        while (clientWidth > obj.b) {
                            obj12 -= i11;
                            clientWidth--;
                        }
                        obj.e = obj12 -= i11;
                        clientWidth--;
                        obj12 -= i11;
                        clientWidth--;
                        if (i7 > 0) {
                        }
                        obj = this.b.get(i7--);
                    }
                }
            }
        }
        f2 = f.e;
        int i16 = f.b;
        i3 = i16 + -1;
        i4 = i16 == 0 ? f2 : -8388609;
        this.I = i4;
        i12--;
        int i22 = 1065353216;
        if (i16 == i13) {
            i17 -= i22;
        } else {
            i6 = 2139095039;
        }
        this.J = i6;
        i10 = i2 + -1;
        while (i10 >= 0) {
            obj2 = this.b.get(i10);
            i5 = obj2.b;
            while (i3 > i5) {
                f2 -= i19;
                i3 = i9;
                i5 = obj2.b;
            }
            f2 -= i9;
            obj2.e = f2;
            if (i5 == 0) {
            }
            i10--;
            i3--;
            this.I = f2;
            f2 -= i19;
            i3 = i9;
        }
        i14 += i;
        obj10++;
        i2++;
        while (obj11 < this.b.size()) {
            Object obj3 = this.b.get(obj11);
            i3 = obj3.b;
            while (obj10 < i3) {
                i8 += obj10;
                obj10 = obj2;
                i3 = obj3.b;
            }
            if (i3 == i13) {
            }
            obj3.e = i8;
            i8 += f4;
            obj11++;
            obj10++;
            this.J = i20 -= i22;
            i8 += obj10;
            obj10 = obj2;
        }
    }

    private void g(boolean z) {
        int i;
        int scrollX;
        int i2;
        int scrollY;
        int currX;
        int currY;
        Runnable obj8;
        final int i4 = 1;
        final int i5 = 0;
        i = this.w0 == 2 ? i4 : i5;
        setScrollingCacheEnabled(i5);
        if (i != 0 && finished ^= i4 != 0) {
            setScrollingCacheEnabled(i5);
            if (finished ^= i4 != 0) {
                this.B.abortAnimation();
                scrollX = getScrollX();
                currX = this.B.getCurrX();
                currY = this.B.getCurrY();
                if (scrollX == currX) {
                    scrollTo(currX, currY);
                    if (getScrollY() != currY && currX != scrollX) {
                        scrollTo(currX, currY);
                        if (currX != scrollX) {
                            C(currX);
                        }
                    }
                } else {
                }
            }
        }
        this.N = i5;
        i2 = i5;
        while (i2 < this.b.size()) {
            scrollY = this.b.get(i2);
            if (scrollY.c != 0) {
            }
            i2++;
            scrollY.c = i5;
            i = i4;
        }
        if (i != 0) {
            if (z != null) {
                u.d0(this, this.v0);
            } else {
                this.v0.run();
            }
        }
    }

    private int getClientWidth() {
        return i -= paddingRight;
    }

    private int i(int i, float f2, int i3, int i4) {
        int i2;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        if (Math.abs(i4) > this.f0 && Math.abs(i3) > this.d0) {
            if (Math.abs(i3) > this.d0) {
                if (i3 > 0) {
                } else {
                    i++;
                }
            } else {
                obj4 = i >= this.x ? 1053609165 : 1058642330;
                i += obj3;
            }
        } else {
        }
        if (this.b.size() > 0) {
            obj4 = this.b;
            obj2 = Math.max(obj3.b, Math.min(obj2, obj4.b));
        }
        return obj2;
    }

    private void j(int i, float f2, int i3) {
        List size;
        int i2;
        Object obj;
        androidx.viewpager.widget.ViewPager.j view = this.o0;
        if (view != null) {
            view.onPageScrolled(i, f2, i3);
        }
        size = this.n0;
        if (size != null) {
            i2 = 0;
            while (i2 < size.size()) {
                obj = this.n0.get(i2);
                if ((ViewPager.j)obj != null) {
                }
                i2++;
                (ViewPager.j)obj.onPageScrolled(i, f2, i3);
            }
        }
        androidx.viewpager.widget.ViewPager.j view2 = this.p0;
        if (view2 != null) {
            view2.onPageScrolled(i, f2, i3);
        }
    }

    private void k(int i) {
        List size;
        int i2;
        Object obj;
        androidx.viewpager.widget.ViewPager.j view = this.o0;
        if (view != null) {
            view.onPageSelected(i);
        }
        size = this.n0;
        if (size != null) {
            i2 = 0;
            while (i2 < size.size()) {
                obj = this.n0.get(i2);
                if ((ViewPager.j)obj != null) {
                }
                i2++;
                (ViewPager.j)obj.onPageSelected(i);
            }
        }
        androidx.viewpager.widget.ViewPager.j view2 = this.p0;
        if (view2 != null) {
            view2.onPageSelected(i);
        }
    }

    private void l(int i) {
        List size;
        int i2;
        Object obj;
        androidx.viewpager.widget.ViewPager.j view = this.o0;
        if (view != null) {
            view.onPageScrollStateChanged(i);
        }
        size = this.n0;
        if (size != null) {
            i2 = 0;
            while (i2 < size.size()) {
                obj = this.n0.get(i2);
                if ((ViewPager.j)obj != null) {
                }
                i2++;
                (ViewPager.j)obj.onPageScrollStateChanged(i);
            }
        }
        androidx.viewpager.widget.ViewPager.j view2 = this.p0;
        if (view2 != null) {
            view2.onPageScrollStateChanged(i);
        }
    }

    private void n(boolean z) {
        int i2;
        int i;
        View childAt;
        int i3;
        final int i4 = 0;
        i2 = i4;
        while (i2 < getChildCount()) {
            if (z) {
            } else {
            }
            i = i4;
            getChildAt(i2).setLayerType(i, 0);
            i2++;
            i = this.s0;
        }
    }

    private void o() {
        VelocityTracker velocityTracker;
        int i = 0;
        this.P = i;
        this.Q = i;
        velocityTracker = this.c0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.c0 = 0;
        }
    }

    private Rect q(Rect rect, View view2) {
        int bottom;
        int bottom2;
        Rect obj3;
        ViewParent obj4;
        if (rect == null) {
            obj3 = new Rect();
        }
        if (view2 == null) {
            obj4 = 0;
            obj3.set(obj4, obj4, obj4, obj4);
            return obj3;
        }
        obj3.left = view2.getLeft();
        obj3.right = view2.getRight();
        obj3.top = view2.getTop();
        obj3.bottom = view2.getBottom();
        obj4 = view2.getParent();
        while (obj4 instanceof ViewGroup) {
            if (obj4 != this) {
            }
            obj3.left = left2 += left3;
            obj3.right = right2 += right3;
            obj3.top = top2 += top3;
            obj3.bottom = bottom3 += bottom2;
            obj4 = obj4.getParent();
        }
        return obj3;
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.M != z) {
            this.M = z;
        }
    }

    private androidx.viewpager.widget.ViewPager.f t() {
        float clientWidth;
        int i4;
        int cmp;
        int i7;
        int i6;
        float f;
        int i8;
        int i;
        int cmp2;
        int i2;
        int i3;
        Object obj;
        int i5;
        clientWidth = getClientWidth();
        i7 = 0;
        if (clientWidth > 0) {
            f2 /= f;
        } else {
            i6 = i7;
        }
        if (clientWidth > 0) {
            f3 /= clientWidth;
        } else {
            i8 = i7;
        }
        i4 = 0;
        final int i12 = 0;
        final int i16 = 1;
        i2 = i12;
        cmp2 = i13;
        i3 = i16;
        i = i7;
        while (i2 < this.b.size()) {
            cmp2 += i16;
            if (i3 == 0 && obj.b != cmp2) {
            }
            i7 = obj.e;
            cmp2 = obj.b;
            i = obj.d;
            i2++;
            i3 = i12;
            i4 = obj;
            cmp2 += i16;
            if (obj.b != cmp2) {
            }
            obj = this.c;
            obj.e = i9 += i8;
            obj.b = cmp2;
            obj.d = this.w.g(cmp2);
            i2--;
        }
        return i4;
    }

    private static boolean w(View view) {
        int obj1;
        obj1 = view.getClass().getAnnotation(ViewPager.e.class) != null ? 1 : 0;
        return obj1;
    }

    private boolean x(float f, float f2) {
        int cmp;
        int i;
        int obj4;
        final int i4 = 0;
        if (Float.compare(f, f3) < 0) {
            if (Float.compare(f2, i4) <= 0) {
                if (Float.compare(f, cmp) > 0 && Float.compare(f2, i4) < 0) {
                    obj4 = Float.compare(f2, i4) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj4;
    }

    private void z(MotionEvent motionEvent) {
        int actionIndex;
        int pointerId;
        VelocityTracker obj4;
        actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.b0) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.U = motionEvent.getX(actionIndex);
            this.b0 = motionEvent.getPointerId(actionIndex);
            obj4 = this.c0;
            if (obj4 != null) {
                obj4.clear();
            }
        }
    }

    @Override // android.view.ViewGroup
    boolean A() {
        int i = this.x;
        if (i > 0) {
            final int i4 = 1;
            N(i -= i4, i4);
            return i4;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    boolean B() {
        androidx.viewpager.widget.a aVar;
        int i;
        int i2;
        aVar = this.w;
        i2 = 1;
        if (aVar != null && this.x < i4 -= i2) {
            i2 = 1;
            if (this.x < i4 -= i2) {
                N(i5 += i2, i2);
                return i2;
            }
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    void E() {
        F(this.x);
    }

    @Override // android.view.ViewGroup
    void F(int i) {
        String resourceName;
        int i5;
        View requestFocus;
        int i6;
        int i9;
        Object childAt;
        int i10;
        float f;
        int layoutParams;
        int cmp2;
        Object obj;
        float f2;
        int size2;
        int i11;
        int size;
        int i4;
        int i8;
        int i2;
        int clientWidth;
        int i7;
        int i12;
        int i3;
        int cmp;
        final Object obj2 = this;
        int i13 = i;
        int i15 = obj2.x;
        if (i15 != i13) {
            i6 = obj2.u(i15);
            obj2.x = i13;
        } else {
            i6 = 0;
        }
        if (obj2.w == null) {
            T();
        }
        if (obj2.N) {
            T();
        }
        if (getWindowToken() == null) {
        }
        obj2.w.r(obj2);
        int i14 = obj2.O;
        cmp2 = 0;
        int i21 = obj2.w.d();
        if (i21 == obj2.a) {
            i11 = cmp2;
            while (i11 < obj2.b.size()) {
                i4 = size.b;
                i8 = obj2.x;
                i11++;
            }
            size = 0;
            if (size == 0 && i21 > 0) {
                if (i21 > 0) {
                    size = obj2.a(obj2.x, i11);
                }
            }
            int i26 = 0;
            if (size != 0) {
                i8 = i11 + -1;
                if (i8 >= 0) {
                    i2 = obj2.b.get(i8);
                } else {
                    i2 = 0;
                }
                clientWidth = getClientWidth();
                i7 = 1073741824;
                if (clientWidth <= 0) {
                    i12 = i26;
                } else {
                    i28 += i3;
                }
                i16--;
                i3 = i26;
                while (i10 >= 0) {
                    if (Float.compare(i3, i12) >= 0) {
                        break;
                    } else {
                    }
                    if (i2 != 0 && i10 == i2.b) {
                    } else {
                    }
                    i3 += f2;
                    i11++;
                    if (i8 >= 0) {
                    } else {
                    }
                    obj = 0;
                    i2 = obj;
                    i10--;
                    cmp2 = 0;
                    obj = obj2.b.get(i8);
                    if (i10 == i2.b) {
                    } else {
                    }
                    i3 += f2;
                    i8--;
                    if (i8 >= 0) {
                    } else {
                    }
                    obj = obj2.b.get(i8);
                    if (i10 < Math.max(cmp2, i17 -= i14)) {
                        break;
                    } else {
                    }
                    if (i2 == 0) {
                        break;
                    } else {
                    }
                    if (i10 == i2.b && !i2.c) {
                    }
                    if (!i2.c) {
                    }
                    obj2.b.remove(i8);
                    obj2.w.a(obj2, i10, i2.a);
                    i8--;
                    i11--;
                    if (i8 >= 0) {
                    } else {
                    }
                    obj = obj2.b.get(i8);
                }
                layoutParams = i11 + 1;
                if (Float.compare(f, i7) < 0) {
                    if (layoutParams < obj2.b.size()) {
                        cmp2 = obj2.b.get(layoutParams);
                    } else {
                        cmp2 = 0;
                    }
                    if (clientWidth <= 0) {
                        i8 = i26;
                    } else {
                        i27 += i7;
                    }
                    i2 = obj2.x;
                    i2++;
                    while (i2 < i21) {
                        if (Float.compare(f, i8) >= 0) {
                            break;
                        } else {
                        }
                        if (cmp2 != 0) {
                        } else {
                        }
                        layoutParams++;
                        f += f4;
                        if (layoutParams < obj2.b.size()) {
                        } else {
                        }
                        cmp2 = 0;
                        i2++;
                        cmp2 = obj2.b.get(layoutParams);
                        if (i2 == cmp2.b) {
                        } else {
                        }
                        f += f5;
                        layoutParams++;
                        if (layoutParams < obj2.b.size()) {
                        } else {
                        }
                        cmp2 = obj2.b.get(layoutParams);
                        if (i2 > Math.min(i21 + -1, i24 += i14)) {
                            break;
                        } else {
                        }
                        if (cmp2 == 0) {
                            break;
                        } else {
                        }
                        if (i2 == cmp2.b && !cmp2.c) {
                        }
                        if (!cmp2.c) {
                        }
                        obj2.b.remove(layoutParams);
                        obj2.w.a(obj2, i2, cmp2.a);
                        if (layoutParams < obj2.b.size()) {
                        } else {
                        }
                        cmp2 = obj2.b.get(layoutParams);
                    }
                }
                obj2.e(size, i11, i6);
                obj2.w.o(obj2, obj2.x, size.a);
            }
            obj2.w.c(obj2);
            i9 = 0;
            while (i9 < getChildCount()) {
                childAt = obj2.getChildAt(i9);
                layoutParams = childAt.getLayoutParams();
                layoutParams.f = i9;
                childAt = obj2.s(childAt);
                if (!layoutParams.a && Float.compare(f3, i26) == 0 && childAt != null) {
                }
                i9++;
                if (Float.compare(f3, i26) == 0) {
                }
                childAt = obj2.s(childAt);
                if (childAt != null) {
                }
                layoutParams.c = childAt.d;
                layoutParams.e = childAt.b;
            }
            T();
            if (hasFocus()) {
                requestFocus = findFocus();
                if (requestFocus != null) {
                    childAt = obj2.r(requestFocus);
                } else {
                    childAt = 0;
                }
                if (childAt != null) {
                    if (childAt.b != obj2.x) {
                        cmp2 = 0;
                        while (cmp2 < getChildCount()) {
                            requestFocus = obj2.getChildAt(cmp2);
                            i9 = obj2.s(requestFocus);
                            if (i9 != null) {
                                break;
                            } else {
                            }
                            cmp2++;
                            if (i9.b == obj2.x) {
                                break;
                            } else {
                            }
                            if (requestFocus.requestFocus(2)) {
                                break;
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        }
        resourceName = getResources().getResourceName(getId());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        stringBuilder.append(obj2.a);
        stringBuilder.append(", found: ");
        stringBuilder.append(i21);
        stringBuilder.append(" Pager id: ");
        stringBuilder.append(resourceName);
        stringBuilder.append(" Pager class: ");
        stringBuilder.append(getClass());
        stringBuilder.append(" Problematic adapter: ");
        stringBuilder.append(obj2.w.getClass());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.view.ViewGroup
    public void I(androidx.viewpager.widget.ViewPager.i viewPager$i) {
        final List list = this.q0;
        if (list != null) {
            list.remove(i);
        }
    }

    @Override // android.view.ViewGroup
    public void J(androidx.viewpager.widget.ViewPager.j viewPager$j) {
        final List list = this.n0;
        if (list != null) {
            list.remove(j);
        }
    }

    @Override // android.view.ViewGroup
    public void N(int i, boolean z2) {
        final int i2 = 0;
        this.N = i2;
        O(i, z2, i2);
    }

    @Override // android.view.ViewGroup
    void O(int i, boolean z2, boolean z3) {
        P(i, z2, z3, 0);
    }

    @Override // android.view.ViewGroup
    void P(int i, boolean z2, boolean z3, int i4) {
        int aVar;
        int i3;
        int i2;
        int size;
        int obj5;
        int obj7;
        aVar = this.w;
        i2 = 0;
        if (aVar != null) {
            if (aVar.d() <= 0) {
            } else {
                if (z3 == 0 && this.x == i && this.b.size() != 0) {
                    if (this.x == i) {
                        if (this.b.size() != 0) {
                            setScrollingCacheEnabled(i2);
                        }
                    }
                }
                obj7 = 1;
                if (i < 0) {
                    obj5 = i2;
                } else {
                    if (i >= this.w.d()) {
                        obj5 -= obj7;
                    }
                }
                i3 = this.O;
                size = this.x;
                if (obj5 <= size + i3) {
                    if (obj5 < size -= i3) {
                        i3 = i2;
                        while (i3 < this.b.size()) {
                            size.c = obj7;
                            i3++;
                        }
                    }
                } else {
                }
                if (this.x != obj5) {
                    i2 = obj7;
                }
                if (this.k0) {
                    this.x = obj5;
                    if (i2 != 0) {
                        k(obj5);
                    }
                    requestLayout();
                } else {
                    F(obj5);
                    M(obj5, z2, i4, i2);
                }
            }
        }
        setScrollingCacheEnabled(i2);
    }

    @Override // android.view.ViewGroup
    public void Q(boolean z, androidx.viewpager.widget.ViewPager.k viewPager$k2) {
        R(z, k2, 2);
    }

    @Override // android.view.ViewGroup
    public void R(boolean z, androidx.viewpager.widget.ViewPager.k viewPager$k2, int i3) {
        int i4;
        int i;
        int i5;
        int i2;
        i4 = 1;
        final int i6 = 0;
        i = k2 != null ? i4 : i6;
        i5 = this.r0 != null ? i4 : i6;
        i2 = i != i5 ? i4 : i6;
        this.r0 = k2;
        setChildrenDrawingOrderEnabled(i);
        if (i != 0) {
            if (z) {
                i4 = 2;
            }
            this.t0 = i4;
            this.s0 = i3;
        } else {
            this.t0 = i6;
        }
        if (i2 != 0) {
            E();
        }
    }

    @Override // android.view.ViewGroup
    void S(int i, int i2, int i3) {
        int i4;
        int scrollX;
        Scroller finished;
        Scroller scroller;
        int obj10;
        int obj11;
        float obj12;
        final int i9 = 0;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(i9);
        }
        finished = this.B;
        int i10 = 1;
        if (finished != null && !finished.isFinished()) {
            i4 = !finished.isFinished() ? i10 : i9;
        } else {
        }
        if (i4 != 0) {
            if (this.C) {
                scrollX = this.B.getCurrX();
            } else {
                scrollX = this.B.getStartX();
            }
            this.B.abortAnimation();
            setScrollingCacheEnabled(i9);
        } else {
            scrollX = getScrollX();
        }
        final int i12 = scrollX;
        final int scrollY = getScrollY();
        final int i13 = i - i12;
        final int i14 = i2 - scrollY;
        if (i13 == 0 && i14 == 0) {
            if (i14 == 0) {
                g(i9);
                E();
                setScrollState(i9);
            }
        }
        setScrollingCacheEnabled(i10);
        setScrollState(2);
        obj10 = getClientWidth();
        int i11 = 1065353216;
        obj10 = (float)obj10;
        obj11 = (float)obj11;
        obj12 = Math.abs(i3);
        if (obj12 > 0) {
            obj10 *= 4;
        } else {
            obj10 = (int)obj11;
        }
        this.C = i9;
        this.B.startScroll(i12, scrollY, i13, i14, Math.min(obj10, 600));
        u.c0(this);
    }

    @Override // android.view.ViewGroup
    androidx.viewpager.widget.ViewPager.f a(int i, int i2) {
        ArrayList obj3;
        ViewPager.f fVar = new ViewPager.f();
        fVar.b = i;
        fVar.a = this.w.h(this, i);
        fVar.d = this.w.g(i);
        if (i2 >= 0) {
            if (i2 >= this.b.size()) {
                this.b.add(fVar);
            } else {
                this.b.add(i2, fVar);
            }
        } else {
        }
        return fVar;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int i4;
        View childCount;
        int visibility;
        int i;
        int obj8;
        int obj9;
        final int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            i4 = 0;
            while (i4 < getChildCount()) {
                childCount = getChildAt(i4);
                visibility = s(childCount);
                if (childCount.getVisibility() == 0 && visibility != null && visibility.b == this.x) {
                }
                i4++;
                visibility = s(childCount);
                if (visibility != null) {
                }
                if (visibility.b == this.x) {
                }
                childCount.addFocusables(arrayList, i2, i3);
            }
        }
        if (descendantFocusability == 262144) {
            if (arrayList.size() == arrayList.size() && !isFocusable()) {
                if (!isFocusable()) {
                }
                obj8 = 1;
                if (i3 &= obj8 == obj8 && isInTouchMode() && !isFocusableInTouchMode()) {
                    if (isInTouchMode()) {
                        if (!isFocusableInTouchMode()) {
                        }
                    }
                }
                if (arrayList != null) {
                    arrayList.add(this);
                }
            }
        } else {
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int i;
        View childAt;
        int visibility;
        int i2;
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            visibility = s(childAt);
            if (childAt.getVisibility() == 0 && visibility != null && visibility.b == this.x) {
            }
            i++;
            visibility = s(childAt);
            if (visibility != null) {
            }
            if (visibility.b == this.x) {
            }
            childAt.addTouchables(arrayList);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        int i;
        ViewGroup.LayoutParams obj6;
        if (!checkLayoutParams(layoutParams3)) {
            obj6 = generateLayoutParams(layoutParams3);
        }
        ViewGroup.LayoutParams view2 = obj6;
        z |= z2;
        view2.a = i;
        if (this.L) {
            if ((ViewPager.g)view2 != null) {
                if (i != 0) {
                } else {
                }
                IllegalStateException obj4 = new IllegalStateException("Cannot add pager decor view during layout");
                throw obj4;
            }
            view2.d = true;
            addViewInLayout(view, i2, obj6);
        } else {
            super.addView(view, i2, obj6);
        }
    }

    @Override // android.view.ViewGroup
    public void b(androidx.viewpager.widget.ViewPager.i viewPager$i) {
        Object arrayList;
        if (this.q0 == null) {
            arrayList = new ArrayList();
            this.q0 = arrayList;
        }
        this.q0.add(i);
    }

    @Override // android.view.ViewGroup
    public void c(androidx.viewpager.widget.ViewPager.j viewPager$j) {
        Object arrayList;
        if (this.n0 == null) {
            arrayList = new ArrayList();
            this.n0 = arrayList;
        }
        this.n0.add(j);
    }

    @Override // android.view.ViewGroup
    public boolean canScrollHorizontally(int i) {
        int clientWidth;
        int i2;
        int obj5;
        if (this.w == null) {
            return 0;
        }
        clientWidth = getClientWidth();
        final int scrollX = getScrollX();
        final int i3 = 1;
        if (i < 0 && scrollX > (int)obj5) {
            if (scrollX > (int)obj5) {
                i2 = i3;
            }
            return i2;
        }
        if (i > 0 && scrollX < (int)obj5) {
            if (scrollX < (int)obj5) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        Object obj2;
        if (layoutParams instanceof ViewPager.g && super.checkLayoutParams(layoutParams)) {
            obj2 = super.checkLayoutParams(layoutParams) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public void computeScroll() {
        int scrollX;
        boolean scrollOffset;
        int i = 1;
        this.C = i;
        if (!this.B.isFinished() && this.B.computeScrollOffset()) {
            if (this.B.computeScrollOffset()) {
                int currX = this.B.getCurrX();
                int currY = this.B.getCurrY();
                if (getScrollX() == currX) {
                    scrollTo(currX, currY);
                    if (getScrollY() != currY && !C(currX)) {
                        scrollTo(currX, currY);
                        if (!C(currX)) {
                            this.B.abortAnimation();
                            scrollTo(0, currY);
                        }
                    }
                } else {
                }
                u.c0(this);
            }
        }
        g(i);
    }

    @Override // android.view.ViewGroup
    public boolean d(int i) {
        ViewParent parent2;
        View requestFocus;
        int left2;
        int i2;
        int left;
        ViewParent parent;
        int str;
        boolean str2;
        String simpleName;
        int obj7;
        requestFocus = findFocus();
        left2 = 1;
        if (requestFocus == this) {
            requestFocus = i3;
        } else {
            if (requestFocus != null) {
                parent = requestFocus.getParent();
                while (parent instanceof ViewGroup) {
                    parent = parent.getParent();
                }
                str = i2;
                if (str == null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(requestFocus.getClass().getSimpleName());
                    parent2 = requestFocus.getParent();
                    while (parent2 instanceof ViewGroup) {
                        stringBuilder2.append(" => ");
                        stringBuilder2.append(parent2.getClass().getSimpleName());
                        parent2 = parent2.getParent();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("arrowScroll tried to find focus based on non-child current focused view ");
                    stringBuilder.append(stringBuilder2.toString());
                    Log.e("ViewPager", stringBuilder.toString());
                }
            }
        }
        View nextFocus = FocusFinder.getInstance().findNextFocus(this, requestFocus, i);
        int i4 = 66;
        int i5 = 17;
        if (nextFocus != null && nextFocus != requestFocus) {
            if (nextFocus != requestFocus) {
                if (i == i5) {
                    if (requestFocus != null && rect4.left >= rect8.left) {
                        if (rect4.left >= rect8.left) {
                            requestFocus = A();
                        } else {
                            requestFocus = nextFocus.requestFocus();
                        }
                    } else {
                    }
                    i2 = requestFocus;
                } else {
                }
            } else {
                if (i != i5) {
                    if (i == left2) {
                        i2 = A();
                    } else {
                        if (i != i4) {
                            if (i == 2) {
                                i2 = B();
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        if (i2 != 0) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int obj2;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (p(keyEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        View dispatchPopulateAccessibilityEvent;
        int visibility;
        int i2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int i4 = 0;
        i = i4;
        while (i < getChildCount()) {
            dispatchPopulateAccessibilityEvent = getChildAt(i);
            i++;
            visibility = s(dispatchPopulateAccessibilityEvent);
        }
        return i4;
    }

    @Override // android.view.ViewGroup
    public void draw(Canvas canvas) {
        boolean overScrollMode;
        boolean finished;
        int i;
        int draw;
        int width;
        EdgeEffect edgeEffect;
        int i2;
        float f;
        Object obj8;
        super.draw(canvas);
        overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            draw = 1;
            overScrollMode = this.w;
            if (overScrollMode == draw && overScrollMode != null && overScrollMode.d() > draw) {
                overScrollMode = this.w;
                if (overScrollMode != null) {
                    if (overScrollMode.d() > draw) {
                        if (!this.i0.isFinished()) {
                            i3 -= paddingBottom;
                            width = getWidth();
                            canvas.rotate(1132920832);
                            canvas.translate((float)i8, f4 *= f);
                            this.i0.setSize(i4, width);
                            i |= draw;
                            canvas.restoreToCount(canvas.save());
                        }
                        if (!this.j0.isFinished()) {
                            int width2 = getWidth();
                            canvas.rotate(1119092736);
                            canvas.translate((float)i10, i12 *= f);
                            this.j0.setSize(i5 -= paddingBottom2, width2);
                            i |= draw;
                            canvas.restoreToCount(canvas.save());
                        }
                    } else {
                        this.i0.finish();
                        this.j0.finish();
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            u.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    protected void drawableStateChanged() {
        boolean drawableState;
        super.drawableStateChanged();
        final Drawable drawable = this.F;
        if (drawable != null && drawable.isStateful()) {
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean f(View view, boolean z2, int i3, int i4, int i5) {
        boolean scrollHorizontally;
        boolean obj;
        int i;
        int scrollX;
        int scrollY;
        int i8;
        int i7;
        View childAt;
        int right;
        int bottom;
        int i6;
        int i2;
        scrollHorizontally = view;
        i = 1;
        if (scrollHorizontally instanceof ViewGroup) {
            obj = scrollHorizontally;
            childCount -= i;
            while (i8 >= 0) {
                childAt = obj.getChildAt(i8);
                i7 = i4 + scrollX;
                i8--;
                right = i5 + scrollY;
            }
        }
        if (z2 && view.canScrollHorizontally(-i9)) {
            if (view.canScrollHorizontally(-i9)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewPager.g gVar = new ViewPager.g();
        return gVar;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewPager.g gVar = new ViewPager.g(getContext(), attributeSet);
        return gVar;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public androidx.viewpager.widget.a getAdapter() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int obj3;
        int obj4;
        if (this.t0 == 2) {
            obj4 = obj3 - i2;
        }
        return obj3.f;
    }

    @Override // android.view.ViewGroup
    public int getCurrentItem() {
        return this.x;
    }

    @Override // android.view.ViewGroup
    public int getOffscreenPageLimit() {
        return this.O;
    }

    @Override // android.view.ViewGroup
    public int getPageMargin() {
        return this.E;
    }

    @Override // android.view.ViewGroup
    void h() {
        int i5;
        ArrayList childCount;
        int size;
        int i6;
        Object list;
        int i4;
        int i2;
        int i3;
        Comparator layoutParams;
        int i;
        Object obj;
        int i7;
        Object obj2;
        i5 = this.w.d();
        this.a = i5;
        final int i13 = 1;
        final int i14 = 0;
        if (this.b.size() < i10 += i13 && this.b.size() < i5) {
            i6 = this.b.size() < i5 ? i13 : i14;
        } else {
        }
        i2 = this.x;
        i = i3;
        while (i3 < this.b.size()) {
            obj = this.b.get(i3);
            i7 = this.w.e(obj.a);
            if (i7 == -1) {
            } else {
            }
            if (i7 == -2) {
            } else {
            }
            obj2 = obj.b;
            if (obj2 != i7) {
            }
            i3 += i13;
            if (obj2 == this.x) {
            }
            obj.b = i7;
            i6 = i13;
            i2 = i7;
            this.b.remove(i3);
            i3--;
            if (i == 0) {
            }
            this.w.a(this, obj.b, obj.a);
            i4 = this.x;
            if (i4 == obj.b) {
            }
            i2 = i4;
            this.w.r(this);
            i = i13;
        }
        if (i != 0) {
            this.w.c(this);
        }
        Collections.sort(this.b, ViewPager.y0);
        if (i6 != 0) {
            i6 = i14;
            while (i6 < getChildCount()) {
                layoutParams = getChildAt(i6).getLayoutParams();
                if (!layoutParams.a) {
                }
                i6++;
                layoutParams.c = 0;
            }
            O(i2, i14, i13);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    float m(float f) {
        return (float)d2;
    }

    @Override // android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k0 = true;
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        Scroller finished;
        removeCallbacks(this.v0);
        finished = this.B;
        if (finished != null && !finished.isFinished()) {
            if (!finished.isFinished()) {
                this.B.abortAnimation();
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    protected void onDraw(Canvas canvas) {
        int scrollX;
        int width;
        int cmp;
        float f;
        Object obj;
        int i2;
        float f2;
        int size;
        int i3;
        int i7;
        int i;
        int i8;
        int i5;
        float round;
        int i6;
        int round2;
        int i4;
        final Object obj2 = this;
        super.onDraw(canvas);
        if (obj2.E > 0 && obj2.F != null && obj2.b.size() > 0 && obj2.w != null) {
            if (obj2.F != null) {
                if (obj2.b.size() > 0) {
                    if (obj2.w != null) {
                        scrollX = getScrollX();
                        width = getWidth();
                        f = (float)width;
                        f3 /= f;
                        obj = obj2.b.get(0);
                        f2 = obj.e;
                        size = obj2.b.size();
                        i3 = obj.b;
                        while (i3 < obj3.b) {
                            i = obj.b;
                            while (i3 > i) {
                                if (i2 < size) {
                                }
                                obj = obj2.b.get(i2++);
                                i = obj.b;
                            }
                            if (i3 == i) {
                            } else {
                            }
                            float f6 = obj2.w.g(i3);
                            i15 *= f;
                            f2 += i8;
                            if (Float.compare(i14, round) > 0) {
                            } else {
                            }
                            i = canvas;
                            i4 = cmp;
                            if (Float.compare(i5, f4) > 0) {
                                break;
                            } else {
                            }
                            i3++;
                            cmp = i4;
                            i4 = cmp;
                            obj2.F.setBounds(Math.round(i5), obj2.G, Math.round(f8 += i5), obj2.H);
                            obj2.F.draw(canvas);
                            float f5 = obj.e;
                            i8 = obj.d;
                            i16 *= f;
                            i12 += cmp;
                            if (i2 < size) {
                            }
                            obj = obj2.b.get(i2++);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        int cmp;
        int i3;
        VelocityTracker obtain;
        int i8;
        int i5;
        int cmp3;
        int i4;
        int i9;
        int i7;
        int i6;
        int i2;
        float f4;
        float f3;
        float f;
        float f2;
        int cmp2;
        final Object obj = this;
        final MotionEvent motionEvent2 = motionEvent;
        action &= 255;
        final int i15 = 0;
        if (i3 != 3) {
            i2 = 1;
            if (i3 == i2) {
            } else {
                if (i3 != 0 && obj.P) {
                    if (obj.P) {
                        return i2;
                    }
                    if (obj.Q) {
                        return i15;
                    }
                }
                cmp3 = 2;
                if (i3 != 0) {
                    if (i3 != cmp3) {
                        if (i3 != 6) {
                        } else {
                            z(motionEvent);
                        }
                    } else {
                        i3 = obj.b0;
                        if (i3 == -1) {
                        } else {
                            int pointerIndex = motionEvent2.findPointerIndex(i3);
                            f4 = motionEvent2.getX(pointerIndex);
                            i5 = f4 - f11;
                            f3 = Math.abs(i5);
                            f = motionEvent2.getY(pointerIndex);
                            f2 = Math.abs(f - f5);
                            cmp2 = Float.compare(i5, i);
                            if (cmp2 != 0 && !x(obj.U, i5) && this.f(this, false, (int)i5, (int)f4, (int)f)) {
                                if (!x(obj.U, i5)) {
                                    if (this.f(this, false, (int)i5, (int)f4, (int)f)) {
                                        obj.U = f4;
                                        obj.V = f;
                                        obj.Q = i2;
                                        return i15;
                                    }
                                }
                            }
                            int i11 = obj.T;
                            if (Float.compare(f3, f12) > 0 && Float.compare(f3, f2) > 0) {
                                if (Float.compare(f3, f2) > 0) {
                                    obj.P = i2;
                                    K(i2);
                                    setScrollState(i2);
                                    float f8 = obj.W;
                                    cmp3 = (float)i14;
                                    cmp = cmp2 > 0 ? f8 + cmp3 : f8 - cmp3;
                                    obj.U = cmp;
                                    obj.V = f;
                                    setScrollingCacheEnabled(i2);
                                } else {
                                    if (Float.compare(f2, f7) > 0) {
                                        obj.Q = i2;
                                    }
                                }
                            } else {
                            }
                            if (obj.P && D(f4)) {
                                if (D(f4)) {
                                    u.c0(this);
                                }
                            }
                        }
                    }
                } else {
                    float f9 = motionEvent.getX();
                    obj.W = f9;
                    obj.U = f9;
                    float f10 = motionEvent.getY();
                    obj.a0 = f10;
                    obj.V = f10;
                    obj.b0 = motionEvent2.getPointerId(i15);
                    obj.Q = i15;
                    obj.C = i2;
                    obj.B.computeScrollOffset();
                    if (obj.w0 == cmp3 && Math.abs(finalX -= currX) > obj.g0) {
                        if (Math.abs(finalX -= currX) > obj.g0) {
                            obj.B.abortAnimation();
                            obj.N = i15;
                            E();
                            obj.P = i2;
                            K(i2);
                            setScrollState(i2);
                        } else {
                            g(i15);
                            obj.P = i15;
                        }
                    } else {
                    }
                }
                if (obj.c0 == null) {
                    obj.c0 = VelocityTracker.obtain();
                }
            }
            obj.c0.addMovement(motionEvent2);
            return obj.P;
        }
        L();
        return i15;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i11;
        int paddingLeft;
        int paddingTop;
        int paddingRight;
        int i8;
        int paddingBottom;
        int scrollX;
        int layoutParams2;
        int i9;
        int i;
        int layoutParams;
        int i10;
        View childAt;
        float measureSpec;
        int visibility;
        int i12;
        int i7;
        int measuredWidth;
        int measuredHeight2;
        int measuredHeight;
        int i6;
        final Object obj = this;
        int childCount = getChildCount();
        int i13 = i4 - i2;
        int i16 = i5 - i3;
        paddingLeft = getPaddingLeft();
        paddingTop = getPaddingTop();
        paddingRight = getPaddingRight();
        paddingBottom = getPaddingBottom();
        i9 = 0;
        i = 0;
        layoutParams = 8;
        while (i9 < childCount) {
            childAt = obj.getChildAt(i9);
            layoutParams = childAt.getLayoutParams();
            if (childAt.getVisibility() != layoutParams && layoutParams.a) {
            }
            i9++;
            layoutParams = 8;
            layoutParams = childAt.getLayoutParams();
            if (layoutParams.a) {
            }
            int i22 = layoutParams.b;
            int i31 = i22 & 7;
            i22 &= 112;
            if (i31 != 1) {
            } else {
            }
            i12 = Math.max(i33 /= 2, paddingLeft);
            visibility = paddingLeft;
            paddingLeft = i6;
            if (i23 != 16) {
            } else {
            }
            i10 = Math.max(i24 /= 2, paddingTop);
            layoutParams = paddingTop;
            paddingTop = i6;
            paddingLeft += scrollX;
            childAt.layout(i18, paddingTop, measuredWidth5 += i18, paddingTop + measuredHeight);
            i++;
            paddingTop = layoutParams;
            paddingLeft = visibility;
            if (i23 != 48) {
            } else {
            }
            measuredHeight4 += paddingTop;
            if (i23 != 80) {
            } else {
            }
            i26 -= measuredHeight6;
            paddingBottom += measuredHeight2;
            layoutParams = paddingTop;
            if (i31 != 3) {
            } else {
            }
            measuredWidth3 += paddingLeft;
            if (i31 != 5) {
            } else {
            }
            i32 -= measuredWidth6;
            paddingRight += measuredWidth;
            visibility = paddingLeft;
        }
        i8 = 0;
        while (i8 < childCount) {
            scrollX = obj.getChildAt(i8);
            layoutParams2 = scrollX.getLayoutParams();
            i9 = obj.s(scrollX);
            measureSpec = (float)i15;
            i21 += paddingLeft;
            if (scrollX.getVisibility() != layoutParams && !layoutParams2.a && i9 != null && layoutParams2.d) {
            }
            i8++;
            layoutParams2 = scrollX.getLayoutParams();
            if (!layoutParams2.a) {
            }
            i9 = obj.s(scrollX);
            if (i9 != null) {
            }
            measureSpec = (float)i15;
            i21 += paddingLeft;
            if (layoutParams2.d) {
            }
            scrollX.layout(i9, paddingTop, measuredWidth2 += i9, measuredHeight5 += paddingTop);
            layoutParams2.d = false;
            int i28 = 1073741824;
            scrollX.measure(View.MeasureSpec.makeMeasureSpec((int)i27, i28), View.MeasureSpec.makeMeasureSpec(i30 -= paddingBottom, i28));
        }
        obj.G = paddingTop;
        obj.H = i16 -= paddingBottom;
        obj.m0 = i;
        if (obj.k0) {
            i11 = 0;
            obj.M(obj.x, i11, i11, i11);
        } else {
            i11 = 0;
        }
        obj.k0 = i11;
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int i5;
        int childCount;
        int layoutParams;
        int measuredHeight;
        int height;
        int i7;
        int i9;
        View childAt;
        int visibility;
        int measureSpec;
        int i8;
        int i11;
        int i3;
        int i6;
        int width;
        int i10;
        int i4;
        int obj14;
        int obj15;
        i5 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(i5, i), ViewGroup.getDefaultSize(i5, i2));
        obj14 = getMeasuredWidth();
        this.S = Math.min(obj14 / 10, this.R);
        obj14 -= obj15;
        obj15 -= paddingBottom;
        layoutParams = i5;
        measuredHeight = 8;
        i7 = 1;
        i9 = 1073741824;
        while (layoutParams < getChildCount()) {
            childAt = getChildAt(layoutParams);
            measuredHeight = childAt.getLayoutParams();
            if (childAt.getVisibility() != measuredHeight && (ViewPager.g)measuredHeight != null && measuredHeight.a) {
            }
            layoutParams++;
            measuredHeight = 8;
            i7 = 1;
            i9 = 1073741824;
            measuredHeight = childAt.getLayoutParams();
            if ((ViewPager.g)(ViewPager.g)measuredHeight != null) {
            }
            if (measuredHeight.a) {
            }
            int i15 = measuredHeight.b;
            int i17 = i15 & 7;
            i15 &= 112;
            if (i16 != 48) {
            } else {
            }
            visibility = i7;
            if (i17 != 3) {
            }
            i8 = Integer.MIN_VALUE;
            if (visibility != 0) {
            } else {
            }
            if (i7 != 0) {
            } else {
            }
            i11 = i8;
            width = measuredHeight.width;
            i10 = -1;
            i4 = -2;
            if (width != i4) {
            } else {
            }
            width = obj14;
            height = measuredHeight.height;
            if (height != i4) {
            } else {
            }
            height = obj15;
            i9 = i11;
            childAt.measure(View.MeasureSpec.makeMeasureSpec(width, i8), View.MeasureSpec.makeMeasureSpec(height, i9));
            if (visibility != 0) {
            } else {
            }
            if (i7 != 0) {
            }
            obj14 -= measuredHeight;
            obj15 -= measuredHeight;
            if (height != i10) {
            } else {
            }
            height = obj15;
            if (width != i10) {
            } else {
            }
            width = obj14;
            i8 = i9;
            i11 = i9;
            i11 = i8;
            i8 = i9;
            if (i17 == 5) {
            } else {
            }
            i7 = i5;
            if (i16 == 80) {
            } else {
            }
            visibility = i5;
        }
        View.MeasureSpec.makeMeasureSpec(obj14, i9);
        this.K = View.MeasureSpec.makeMeasureSpec(obj15, i9);
        this.L = i7;
        E();
        this.L = i5;
        while (i5 < getChildCount()) {
            childCount = getChildAt(i5);
            if (childCount.getVisibility() != measuredHeight) {
            }
            i5++;
            layoutParams = childCount.getLayoutParams();
            if ((ViewPager.g)layoutParams != null) {
            } else {
            }
            childCount.measure(View.MeasureSpec.makeMeasureSpec((int)i14, i9), this.K);
            if (!layoutParams.a) {
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect2) {
        int i5;
        int i2;
        int i4;
        View requestFocus;
        int visibility;
        int i3;
        int childCount = getChildCount();
        final int i7 = 0;
        final int i8 = 1;
        if (i & 2 != 0) {
            i4 = childCount;
            i5 = i7;
            i2 = i8;
        } else {
            childCount--;
            i2 = i4;
        }
        while (i5 != i4) {
            requestFocus = getChildAt(i5);
            i5 += i2;
            visibility = s(requestFocus);
        }
        return i7;
    }

    @Override // android.view.ViewGroup
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        int i2;
        java.lang.ClassLoader cls;
        int obj4;
        if (!parcelable instanceof ViewPager.m) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((ViewPager.m)parcelable.a());
        androidx.viewpager.widget.a aVar = this.w;
        if (aVar != null) {
            aVar.l(parcelable.v, parcelable.w);
            O(parcelable.c, false, true);
        } else {
            this.y = parcelable.c;
            this.z = parcelable.v;
            this.A = parcelable.w;
        }
    }

    @Override // android.view.ViewGroup
    public Parcelable onSaveInstanceState() {
        Object aVar;
        ViewPager.m mVar = new ViewPager.m(super.onSaveInstanceState());
        mVar.c = this.x;
        aVar = this.w;
        if (aVar != null) {
            mVar.v = aVar.m();
        }
        return mVar;
    }

    @Override // android.view.ViewGroup
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int obj2;
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            obj2 = this.E;
            G(i, i3, obj2, obj2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int edgeFlags;
        VelocityTracker obtain;
        boolean parent;
        int pointerIndex;
        androidx.viewpager.widget.a aVar;
        boolean i2;
        float i;
        int cmp;
        float f;
        int cmp2;
        MotionEvent obj8;
        final int i6 = 1;
        if (this.h0) {
            return i6;
        }
        i2 = 0;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            if (motionEvent.getEdgeFlags() != 0) {
                return i2;
            }
        }
        aVar = this.w;
        if (aVar != null) {
            if (aVar.d() == 0) {
            } else {
                if (this.c0 == null) {
                    this.c0 = VelocityTracker.obtain();
                }
                this.c0.addMovement(motionEvent);
                action &= 255;
                if (pointerIndex != 0) {
                    if (pointerIndex != i6) {
                        if (pointerIndex != 2) {
                            if (pointerIndex != 3) {
                                if (pointerIndex != 5) {
                                    if (pointerIndex != 6) {
                                    } else {
                                        z(motionEvent);
                                        this.U = motionEvent.getX(motionEvent.findPointerIndex(this.b0));
                                    }
                                } else {
                                    pointerIndex = motionEvent.getActionIndex();
                                    this.U = motionEvent.getX(pointerIndex);
                                    this.b0 = motionEvent.getPointerId(pointerIndex);
                                }
                            } else {
                                if (this.P) {
                                    M(this.x, i6, i2, i2);
                                    i2 = L();
                                }
                            }
                        } else {
                            if (!this.P) {
                                pointerIndex = motionEvent.findPointerIndex(this.b0);
                                if (pointerIndex == -1) {
                                    i2 = L();
                                } else {
                                    i = motionEvent.getX(pointerIndex);
                                    cmp = Math.abs(i - f9);
                                    parent = motionEvent.getY(pointerIndex);
                                    if (Float.compare(cmp, f13) > 0 && Float.compare(cmp, f) > 0) {
                                        if (Float.compare(cmp, f) > 0) {
                                            this.P = i6;
                                            K(i6);
                                            float f10 = this.W;
                                            if (Float.compare(i11, f) > 0) {
                                                f10 += i;
                                            } else {
                                                f10 -= i;
                                            }
                                            this.U = cmp;
                                            this.V = parent;
                                            setScrollState(i6);
                                            setScrollingCacheEnabled(i6);
                                            parent = getParent();
                                            if (parent != null) {
                                                parent.requestDisallowInterceptTouchEvent(i6);
                                            }
                                        }
                                    }
                                    if (this.P) {
                                        i2 |= obj8;
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                        if (this.P) {
                            VelocityTracker velocityTracker2 = this.c0;
                            velocityTracker2.computeCurrentVelocity(1000, (float)i15);
                            pointerIndex = (int)xVelocity;
                            this.N = i6;
                            cmp = t();
                            float f3 = (float)clientWidth;
                            P(i(cmp.b, i17 /= i9, pointerIndex, (int)obj8), i6, i6, pointerIndex);
                            i2 = L();
                        }
                    }
                } else {
                    this.B.abortAnimation();
                    this.N = i2;
                    E();
                    float f2 = motionEvent.getX();
                    this.W = f2;
                    this.U = f2;
                    pointerIndex = motionEvent.getY();
                    this.a0 = pointerIndex;
                    this.V = pointerIndex;
                    this.b0 = motionEvent.getPointerId(i2);
                }
                if (i2) {
                    u.c0(this);
                }
            }
            return i6;
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public boolean p(KeyEvent keyEvent) {
        int noModifiers;
        int i2;
        int i;
        boolean obj4;
        if (keyEvent.getAction() == 0) {
            noModifiers = keyEvent.getKeyCode();
            i = 2;
            if (noModifiers != 21) {
                if (noModifiers != 22) {
                    if (noModifiers != 61) {
                        obj4 = 0;
                    } else {
                        if (keyEvent.hasNoModifiers()) {
                            obj4 = d(i);
                        } else {
                            noModifiers = 1;
                            if (keyEvent.hasModifiers(noModifiers)) {
                                obj4 = d(noModifiers);
                            } else {
                            }
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(i)) {
                        obj4 = B();
                    } else {
                        obj4 = d(66);
                    }
                }
            } else {
                if (keyEvent.hasModifiers(i)) {
                    obj4 = A();
                } else {
                    obj4 = d(17);
                }
            }
        } else {
        }
        return obj4;
    }

    @Override // android.view.ViewGroup
    androidx.viewpager.widget.ViewPager.f r(View view) {
        boolean obj2;
        final ViewParent parent = view.getParent();
        while (parent != this) {
            obj2 = parent;
            parent = view.getParent();
        }
        return s(view);
    }

    @Override // android.view.ViewGroup
    public void removeView(View view) {
        if (this.L) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    androidx.viewpager.widget.ViewPager.f s(View view) {
        int i;
        Object obj;
        boolean z;
        Object obj2;
        i = 0;
        while (i < this.b.size()) {
            obj = this.b.get(i);
            i++;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public void setAdapter(androidx.viewpager.widget.a a) {
        int i3;
        Object aVar2;
        List empty;
        int i2;
        Object size;
        androidx.viewpager.widget.ViewPager.l lVar;
        androidx.viewpager.widget.a aVar;
        int i;
        java.lang.ClassLoader cls;
        aVar2 = this.w;
        int i4 = 0;
        i2 = 0;
        if (aVar2 != null) {
            aVar2.p(i4);
            this.w.r(this);
            i3 = i2;
            while (i3 < this.b.size()) {
                Object obj = this.b.get(i3);
                this.w.a(this, obj.b, obj.a);
                i3++;
            }
            this.w.c(this);
            this.b.clear();
            H();
            this.x = i2;
            scrollTo(i2, i2);
        }
        this.w = a;
        this.a = i2;
        if (a != null && this.D == null) {
            if (this.D == null) {
                lVar = new ViewPager.l(this);
                this.D = lVar;
            }
            this.w.p(this.D);
            this.N = i2;
            aVar = 1;
            this.k0 = aVar;
            this.a = this.w.d();
            if (this.y >= 0) {
                this.w.l(this.z, this.A);
                O(this.y, i2, aVar);
                this.y = -1;
                this.z = i4;
                this.A = i4;
            } else {
                if (!this.k0) {
                    E();
                } else {
                    requestLayout();
                }
            }
        }
        empty = this.q0;
        if (empty != null && !empty.isEmpty()) {
            if (!empty.isEmpty()) {
                while (i2 < this.q0.size()) {
                    (ViewPager.i)this.q0.get(i2).a(this, this.w, a);
                    i2++;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setCurrentItem(int i) {
        final int i2 = 0;
        this.N = i2;
        O(i, z ^= 1, i2);
    }

    @Override // android.view.ViewGroup
    public void setOffscreenPageLimit(int i) {
        String str2;
        String str;
        int obj4;
        int i2 = 1;
        if (i < i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested offscreen page limit ");
            stringBuilder.append(i);
            stringBuilder.append(" too small; defaulting to ");
            stringBuilder.append(i2);
            Log.w("ViewPager", stringBuilder.toString());
            obj4 = i2;
        }
        if (obj4 != this.O) {
            this.O = obj4;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(androidx.viewpager.widget.ViewPager.j viewPager$j) {
        this.o0 = j;
    }

    @Override // android.view.ViewGroup
    public void setPageMargin(int i) {
        this.E = i;
        final int width = getWidth();
        G(width, width, i, this.E);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(a.f(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public void setPageMarginDrawable(Drawable drawable) {
        int obj1;
        this.F = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        obj1 = drawable == null ? 1 : 0;
        setWillNotDraw(obj1);
        invalidate();
    }

    @Override // android.view.ViewGroup
    void setScrollState(int i) {
        androidx.viewpager.widget.ViewPager.k view;
        if (this.w0 == i) {
        }
        this.w0 = i;
        if (this.r0 != null) {
            view = i != 0 ? 1 : 0;
            n(view);
        }
        l(i);
    }

    @Override // android.view.ViewGroup
    androidx.viewpager.widget.ViewPager.f u(int i) {
        int i3;
        Object obj;
        int i2;
        i3 = 0;
        while (i3 < this.b.size()) {
            obj = this.b.get(i3);
            i3++;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        int i3 = 1;
        setFocusable(i3);
        Context context = getContext();
        Scroller scroller = new Scroller(context, ViewPager.z0);
        this.B = scroller;
        ViewConfiguration view = ViewConfiguration.get(context);
        float density = displayMetrics.density;
        this.T = view.getScaledPagingTouchSlop();
        this.d0 = (int)i15;
        this.e0 = view.getScaledMaximumFlingVelocity();
        EdgeEffect edgeEffect = new EdgeEffect(context);
        this.i0 = edgeEffect;
        EdgeEffect edgeEffect2 = new EdgeEffect(context);
        this.j0 = edgeEffect2;
        this.f0 = (int)i5;
        this.g0 = (int)i8;
        this.R = (int)i13;
        ViewPager.h hVar = new ViewPager.h(this);
        u.l0(this, hVar);
        if (u.z(this) == 0) {
            u.v0(this, i3);
        }
        ViewPager.d dVar = new ViewPager.d(this);
        u.x0(this, dVar);
    }

    @Override // android.view.ViewGroup
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable verifyDrawable;
        int obj2;
        if (!super.verifyDrawable(drawable)) {
            if (drawable == this.F) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    protected void y(int i, float f2, int i3) {
        int scrollX;
        int i4;
        int paddingLeft;
        int paddingRight;
        int width;
        int childCount;
        int i2;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        int i5;
        boolean measuredWidth;
        int i6;
        androidx.viewpager.widget.ViewPager.k obj13;
        float obj14;
        int obj15;
        final int i8 = 1;
        if (this.m0 > 0) {
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            width = getWidth();
            i2 = i4;
            while (i2 < getChildCount()) {
                childAt = getChildAt(i2);
                layoutParams = childAt.getLayoutParams();
                if (!layoutParams.a) {
                } else {
                }
                i11 &= 7;
                if (i12 != i8) {
                } else {
                }
                i5 = Math.max(i13 /= 2, paddingLeft);
                layoutParams = paddingLeft;
                paddingLeft = i6;
                i9 -= measuredWidth;
                if (i10 != 0) {
                }
                paddingLeft = layoutParams;
                i2++;
                childAt.offsetLeftAndRight(i10);
                if (i12 != 3) {
                } else {
                }
                width2 += paddingLeft;
                if (i12 != 5) {
                } else {
                }
                i15 -= measuredWidth3;
                paddingRight += measuredWidth;
                layoutParams = paddingLeft;
            }
        }
        j(i, f2, i3);
        if (this.r0 != null) {
            while (i4 < getChildCount()) {
                obj15 = getChildAt(i4);
                if (layoutParams2.a) {
                } else {
                }
                this.r0.a(obj15, f /= f3);
                i4++;
            }
        }
        this.l0 = i8;
    }
}
