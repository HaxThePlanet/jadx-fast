package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import d.g.a;
import d.g.b;
import d.g.c;
import d.h.k.c;
import d.h.k.f;
import d.h.k.h;
import d.h.l.d0;
import d.h.l.e;
import d.h.l.m;
import d.h.l.n;
import d.h.l.p;
import d.h.l.q;
import d.h.l.u;
import d.j.a.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements m, n {

    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    static final String WIDGET_PACKAGE_NAME = null;
    static final java.lang.ThreadLocal<Map<String, Constructor<androidx.coordinatorlayout.widget.CoordinatorLayout.c>>> sConstructors;
    private static final f<Rect> sRectPool;
    private q mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final androidx.coordinatorlayout.widget.a<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private d0 mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final p mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface b {
        public abstract androidx.coordinatorlayout.widget.CoordinatorLayout.c getBehavior();
    }

    public static abstract class c {
        public c(Context context, AttributeSet attributeSet2) {
            super();
        }

        public static Object getTag(View view) {
            return obj0.r;
        }

        public static void setTag(View view, Object object2) {
            obj0.r = object2;
        }

        public boolean blocksInteractionBelow(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2) {
            int obj1;
            obj1 = Float.compare(obj1, obj2) > 0 ? 1 : 0;
            return obj1;
        }

        public boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, Rect rect3) {
            return 0;
        }

        public int getScrimColor(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2) {
            return -16777216;
        }

        public float getScrimOpacity(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2) {
            return 0;
        }

        public boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3) {
            return 0;
        }

        public d0 onApplyWindowInsets(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, d0 d03) {
            return d03;
        }

        public void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.CoordinatorLayout.f coordinatorLayout$f) {
        }

        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3) {
            return 0;
        }

        public void onDependentViewRemoved(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
            return 0;
        }

        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, int i3) {
            return 0;
        }

        public boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, int i3, int i4, int i5, int i6) {
            return 0;
        }

        public boolean onNestedFling(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, float f4, float f5, boolean z6) {
            return 0;
        }

        public boolean onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, float f4, float f5) {
            return 0;
        }

        @Deprecated
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int[] i6Arr6) {
        }

        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int[] i6Arr6, int i7) {
            if (i7 == 0) {
                onNestedPreScroll(coordinatorLayout, v2, view3, i4, i5, i6Arr6);
            }
        }

        @Deprecated
        public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int i6, int i7) {
        }

        @Deprecated
        public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int i6, int i7, int i8) {
            if (i8 == 0) {
                onNestedScroll(coordinatorLayout, v2, view3, i4, i5, i6, i7);
            }
        }

        public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4, int i5, int i6, int i7, int i8, int[] i9Arr9) {
            int i = 0;
            i9Arr9[i] = i3 += i6;
            int i2 = 1;
            i9Arr9[i2] = i10 += i7;
            onNestedScroll(coordinatorLayout, v2, view3, i4, i5, i6, i7, i8);
        }

        @Deprecated
        public void onNestedScrollAccepted(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5) {
        }

        public void onNestedScrollAccepted(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5, int i6) {
            if (i6 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v2, view3, view4, i5);
            }
        }

        public boolean onRequestChildRectangleOnScreen(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, Rect rect3, boolean z4) {
            return 0;
        }

        public void onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable3) {
        }

        public Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5) {
            return 0;
        }

        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, View view4, int i5, int i6) {
            if (i6 == 0) {
                return onStartNestedScroll(coordinatorLayout, v2, view3, view4, i5);
            }
            return 0;
        }

        @Deprecated
        public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3) {
        }

        public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, View view3, int i4) {
            if (i4 == 0) {
                onStopNestedScroll(coordinatorLayout, v2, view3);
            }
        }

        public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent3) {
            return 0;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        public abstract Class<? extends androidx.coordinatorlayout.widget.CoordinatorLayout.c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {

        final androidx.coordinatorlayout.widget.CoordinatorLayout a;
        e(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
            this.a = coordinatorLayout;
            super();
        }

        @Override // android.view.ViewGroup$OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener = coordinatorLayout.mOnHierarchyChangeListener;
            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup$OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            this.a.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener = coordinatorLayout2.mOnHierarchyChangeListener;
            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        androidx.coordinatorlayout.widget.CoordinatorLayout.c a;
        boolean b = false;
        public int c = 0;
        public int d = 0;
        public int e = -1;
        int f = -1;
        public int g = 0;
        public int h = 0;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;
        public f(int i, int i2) {
            super(i, i2);
            int obj1 = 0;
            final int obj2 = -1;
            obj1 = new Rect();
            this.q = obj1;
        }

        f(Context context, AttributeSet attributeSet2) {
            int string;
            Object obj5;
            super(context, attributeSet2);
            int i = 0;
            int i2 = -1;
            Rect rect = new Rect();
            this.q = rect;
            TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, c.d);
            this.c = styledAttributes.getInteger(c.e, i);
            this.f = styledAttributes.getResourceId(c.f, i2);
            this.d = styledAttributes.getInteger(c.g, i);
            this.e = styledAttributes.getInteger(c.k, i2);
            this.g = styledAttributes.getInt(c.j, i);
            this.h = styledAttributes.getInt(c.i, i);
            string = c.h;
            boolean value = styledAttributes.hasValue(string);
            this.b = value;
            if (value != null) {
                this.a = CoordinatorLayout.parseBehavior(context, attributeSet2, styledAttributes.getString(string));
            }
            styledAttributes.recycle();
            obj5 = this.a;
            if (obj5 != null) {
                obj5.onAttachedToLayoutParams(this);
            }
        }

        public f(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            int obj2 = 0;
            final int i = -1;
            obj2 = new Rect();
            this.q = obj2;
        }

        public f(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
            int obj2 = 0;
            final int i = -1;
            obj2 = new Rect();
            this.q = obj2;
        }

        public f(androidx.coordinatorlayout.widget.CoordinatorLayout.f coordinatorLayout$f) {
            super(f);
            int obj2 = 0;
            final int i = -1;
            obj2 = new Rect();
            this.q = obj2;
        }

        private void n(View view, androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout2) {
            View viewById;
            ViewParent parent;
            boolean z;
            viewById = coordinatorLayout2.findViewById(this.f);
            this.k = viewById;
            int i2 = 0;
            if (viewById != null && viewById == coordinatorLayout2) {
                if (viewById == coordinatorLayout2) {
                    if (!coordinatorLayout2.isInEditMode()) {
                    } else {
                        this.l = i2;
                        this.k = i2;
                    }
                    IllegalStateException obj5 = new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    throw obj5;
                }
                parent = viewById.getParent();
                while (parent != coordinatorLayout2) {
                    if (parent instanceof View != null) {
                    }
                    parent = parent.getParent();
                    viewById = parent;
                }
                this.l = viewById;
            }
            if (!coordinatorLayout2.isInEditMode()) {
            } else {
                this.l = i2;
                this.k = i2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
            stringBuilder.append(coordinatorLayout2.getResources().getResourceName(this.f));
            stringBuilder.append(" to anchor view ");
            stringBuilder.append(view);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        private boolean s(View view, int i2) {
            int i;
            int obj2;
            int obj3;
            obj2 = e.b(obj2.g, i2);
            if (obj2 != null && obj3 &= obj2 == obj2) {
                obj2 = obj3 &= obj2 == obj2 ? 1 : 0;
            } else {
            }
            return obj2;
        }

        private boolean t(View view, androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout2) {
            View view2;
            ViewParent parent;
            boolean z;
            final int i2 = 0;
            if (this.k.getId() != this.f) {
                return i2;
            }
            parent = this.k.getParent();
            while (parent != coordinatorLayout2) {
                if (parent instanceof View != null) {
                }
                parent = parent.getParent();
                view2 = parent;
            }
            this.l = view2;
            return 1;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean a() {
            View view;
            int i;
            int i2;
            if (this.k == null && this.f != -1) {
                i = this.f != -1 ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, View view2, View view3) {
            Object view;
            int obj2;
            if (view3 != this.l && !s(view3, u.B(coordinatorLayout))) {
                if (!s(view3, u.B(coordinatorLayout))) {
                    view = this.a;
                    if (view != null && view.layoutDependsOn(coordinatorLayout, view2, view3)) {
                        if (view.layoutDependsOn(coordinatorLayout, view2, view3)) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean c() {
            androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        View d(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, View view2) {
            boolean view;
            if (this.f == -1) {
                int obj3 = 0;
                this.l = obj3;
                this.k = obj3;
                return obj3;
            }
            if (this.k != null) {
                if (!t(view2, coordinatorLayout)) {
                    n(view2, coordinatorLayout);
                }
            } else {
            }
            return this.k;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public int e() {
            return this.f;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public androidx.coordinatorlayout.widget.CoordinatorLayout.c f() {
            return this.a;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean g() {
            return this.p;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        Rect h() {
            return this.q;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean i(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, View view2) {
            boolean obj3;
            final boolean z = this.m;
            if (z) {
                return 1;
            }
            final androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar = this.a;
            if (cVar != null) {
                obj3 = cVar.blocksInteractionBelow(coordinatorLayout, view2);
            } else {
                obj3 = 0;
            }
            obj3 |= z;
            this.m = obj3;
            return obj3;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        boolean j(int i) {
            if (i != 0 && i != 1) {
                if (i != 1) {
                    return 0;
                }
                return this.o;
            }
            return this.n;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void k() {
            this.p = false;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void l(int i) {
            r(i, false);
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void m() {
            this.m = false;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        public void o(androidx.coordinatorlayout.widget.CoordinatorLayout.c coordinatorLayout$c) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
            cVar = this.a;
            if (cVar != c && cVar != null) {
                if (cVar != null) {
                    cVar.onDetachedFromLayoutParams();
                }
                this.a = c;
                this.r = 0;
                this.b = true;
                if (c != null) {
                    c.onAttachedToLayoutParams(this);
                }
            }
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void p(boolean z) {
            this.p = z;
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void q(Rect rect) {
            this.q.set(rect);
        }

        @Override // android.view.ViewGroup$MarginLayoutParams
        void r(int i, boolean z2) {
            int i2;
            if (i != 0) {
                if (i != 1) {
                } else {
                    this.o = z2;
                }
            } else {
                this.n = z2;
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {

        final androidx.coordinatorlayout.widget.CoordinatorLayout a;
        g(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
            this.a = coordinatorLayout;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public boolean onPreDraw() {
            this.a.onChildViewsChanged(0);
            return 1;
        }
    }

    static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public int a(View view, View view2) {
            float obj2 = u.L(view);
            final float obj3 = u.L(view2);
            if (Float.compare(obj2, obj3) > 0) {
                return -1;
            }
            if (Float.compare(obj2, obj3) < 0) {
                return 1;
            }
            return 0;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((View)object, (View)object2);
        }
    }

    class a implements q {

        final androidx.coordinatorlayout.widget.CoordinatorLayout a;
        a(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
            this.a = coordinatorLayout;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            return this.a.setWindowInsets(d02);
        }
    }

    protected static class h extends a {

        public static final Parcelable.Creator<androidx.coordinatorlayout.widget.CoordinatorLayout.h> CREATOR;
        SparseArray<Parcelable> c;
        static {
            CoordinatorLayout.h.a aVar = new CoordinatorLayout.h.a();
            CoordinatorLayout.h.CREATOR = aVar;
        }

        public h(Parcel parcel, java.lang.ClassLoader classLoader2) {
            SparseArray sparseArray;
            int i;
            Parcelable parcelable;
            int obj7;
            super(parcel, classLoader2);
            final int int = parcel.readInt();
            final int[] iArr = new int[int];
            parcel.readIntArray(iArr);
            obj7 = new SparseArray(int);
            this.c = obj7;
            obj7 = 0;
            while (obj7 < int) {
                this.c.append(iArr[obj7], parcel.readParcelableArray(classLoader2)[obj7]);
                obj7++;
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            int size;
            int i;
            Object valueAt;
            super.writeToParcel(parcel, i2);
            SparseArray sparseArray = this.c;
            if (sparseArray != null) {
                size = sparseArray.size();
            } else {
                size = i;
            }
            parcel.writeInt(size);
            final int[] iArr = new int[size];
            final Parcelable[] arr = new Parcelable[size];
            while (i < size) {
                iArr[i] = this.c.keyAt(i);
                arr[i] = (Parcelable)this.c.valueAt(i);
                i++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(arr, i2);
        }
    }
    static {
        java.lang.Package package = CoordinatorLayout.class.getPackage();
        if (package != null) {
            String name = package.getName();
        }
        int i = i3;
        CoordinatorLayout.i iVar = new CoordinatorLayout.i();
        CoordinatorLayout.TOP_SORTED_CHILDREN_COMPARATOR = iVar;
        Class[] arr = new Class[2];
        CoordinatorLayout.CONSTRUCTOR_PARAMS = arr;
        ThreadLocal threadLocal = new ThreadLocal();
        CoordinatorLayout.sConstructors = threadLocal;
        h hVar = new h(12);
        CoordinatorLayout.sRectPool = hVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.a);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet2, int i3) {
        int i;
        TypedArray styledAttributes;
        int i5;
        int sDK_INT;
        int i6;
        int[] iArr;
        AttributeSet set;
        TypedArray typedArray;
        int i2;
        int i4;
        Context obj10;
        int obj11;
        int obj12;
        super(context, attributeSet2, i3);
        ArrayList arrayList = new ArrayList();
        this.mDependencySortedChildren = arrayList;
        a aVar = new a();
        this.mChildDag = aVar;
        ArrayList arrayList2 = new ArrayList();
        this.mTempList1 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.mTempDependenciesList = arrayList3;
        int i7 = 2;
        this.mBehaviorConsumed = new int[i7];
        this.mNestedScrollingV2ConsumedCompat = new int[i7];
        p pVar = new p(this);
        this.mNestedScrollingParentHelper = pVar;
        i = 0;
        if (i3 == 0) {
            styledAttributes = context.obtainStyledAttributes(attributeSet2, c.a, i, b.a);
        } else {
            styledAttributes = context.obtainStyledAttributes(attributeSet2, c.a, i3, i);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i3 == 0) {
                this.saveAttributeDataForStyleable(context, c.a, attributeSet2, styledAttributes, 0, b.a);
            } else {
                this.saveAttributeDataForStyleable(context, c.a, attributeSet2, styledAttributes, i3, 0);
            }
        }
        obj11 = styledAttributes.getResourceId(c.b, i);
        if (obj11 != null) {
            obj10 = context.getResources();
            this.mKeylines = obj10.getIntArray(obj11);
            while (i < obj11.length) {
                obj12 = this.mKeylines;
                obj12[i] = (int)i9;
                i++;
            }
        }
        this.mStatusBarBackground = styledAttributes.getDrawable(c.c);
        styledAttributes.recycle();
        setupForInsets();
        obj10 = new CoordinatorLayout.e(this);
        super.setOnHierarchyChangeListener(obj10);
        if (u.z(this) == 0) {
            u.v0(this, 1);
        }
    }

    private static Rect acquireTempRect() {
        Object rect;
        if ((Rect)CoordinatorLayout.sRectPool.b() == null) {
            rect = new Rect();
        }
        return rect;
    }

    private static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        if (i > i3) {
            return i3;
        }
        return i;
    }

    private void constrainChildRect(androidx.coordinatorlayout.widget.CoordinatorLayout.f coordinatorLayout$f, Rect rect2, int i3, int i4) {
        int i7 = Math.max(paddingLeft += leftMargin, Math.min(rect2.left, i2 -= rightMargin));
        int obj6 = Math.max(paddingTop += topMargin, Math.min(rect2.top, i9 -= obj6));
        rect2.set(i7, obj6, i3 += i7, i4 += obj6);
    }

    private d0 dispatchApplyWindowInsetsToBehaviors(d0 d0) {
        int i;
        View childAt;
        boolean z;
        d0 obj5;
        if (d0.o()) {
            return d0;
        }
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            if (u.y(childAt)) {
                break;
            } else {
            }
            i++;
            z = (CoordinatorLayout.f)childAt.getLayoutParams().f();
            if (z != null) {
                break;
            } else {
            }
            if (z.onApplyWindowInsets(this, childAt, obj5).o()) {
                break;
            } else {
            }
        }
        return obj5;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i2, Rect rect3, Rect rect4, androidx.coordinatorlayout.widget.CoordinatorLayout.f coordinatorLayout$f5, int i6, int i7) {
        int right;
        int i;
        int obj6;
        int obj7;
        Object obj8;
        obj6 = e.b(CoordinatorLayout.resolveAnchoredChildGravity(f5.c), i2);
        obj7 = e.b(CoordinatorLayout.resolveGravity(f5.d), i2);
        int obj10 = obj6 & 7;
        obj6 &= 112;
        int i3 = obj7 & 7;
        obj7 &= 112;
        final int i4 = 5;
        final int i5 = 1;
        if (i3 != i5) {
            right = i3 != i4 ? rect3.left : rect3.right;
        } else {
            left += i;
        }
        int i8 = 80;
        final int i9 = 16;
        if (obj7 != i9) {
            obj7 = obj7 != i8 ? rect3.top : rect3.bottom;
        } else {
            obj7 += obj8;
        }
        if (obj10 != i5) {
            if (obj10 != i4) {
                right -= i6;
            }
        } else {
            right -= obj8;
        }
        if (obj6 != i9) {
            if (obj6 != i8) {
                obj7 -= i7;
            }
        } else {
            obj7 -= obj6;
        }
        rect4.set(right, obj7, i6 += right, i7 += obj7);
    }

    private int getKeyline(int i) {
        int length;
        int[] mKeylines = this.mKeylines;
        final int i2 = 0;
        final String str = "CoordinatorLayout";
        if (mKeylines == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(i);
            Log.e(str, stringBuilder.toString());
            return i2;
        }
        if (i >= 0 && i >= mKeylines.length) {
            if (i >= mKeylines.length) {
            }
            return mKeylines[i];
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Keyline index ");
        stringBuilder2.append(i);
        stringBuilder2.append(" out of range for ");
        stringBuilder2.append(this);
        Log.e(str, stringBuilder2.toString());
        return i2;
    }

    private void getTopSortedChildren(List<View> list) {
        int i;
        View childAt;
        int childDrawingOrder;
        list.clear();
        final int childCount = getChildCount();
        i = childCount + -1;
        while (i >= 0) {
            if (isChildrenDrawingOrderEnabled()) {
            } else {
            }
            childDrawingOrder = i;
            list.add(getChildAt(childDrawingOrder));
            i--;
            childDrawingOrder = getChildDrawingOrder(childCount, i);
        }
        Comparator tOP_SORTED_CHILDREN_COMPARATOR = CoordinatorLayout.TOP_SORTED_CHILDREN_COMPARATOR;
        if (tOP_SORTED_CHILDREN_COMPARATOR != null) {
            Collections.sort(list, tOP_SORTED_CHILDREN_COMPARATOR);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.j(view);
    }

    private void layoutChild(View view, int i2) {
        d0 mLastInsets;
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final Rect tempRect = CoordinatorLayout.acquireTempRect();
        tempRect.set(paddingLeft += leftMargin, paddingTop += topMargin, i11 -= rightMargin, i13 -= bottomMargin);
        if (this.mLastInsets != null && u.y(this) && !u.y(view)) {
            if (u.y(this)) {
                if (!u.y(view)) {
                    tempRect.left = left += i8;
                    tempRect.top = top2 += i9;
                    tempRect.right = right -= i10;
                    tempRect.bottom = bottom -= i;
                }
            }
        }
        final Rect tempRect2 = CoordinatorLayout.acquireTempRect();
        e.a(CoordinatorLayout.resolveGravity(layoutParams.c), view.getMeasuredWidth(), view.getMeasuredHeight(), tempRect, tempRect2, i2);
        view.layout(tempRect2.left, tempRect2.top, tempRect2.right, tempRect2.bottom);
        CoordinatorLayout.releaseTempRect(tempRect);
        CoordinatorLayout.releaseTempRect(tempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i3) {
        final Rect tempRect = CoordinatorLayout.acquireTempRect();
        final Rect tempRect2 = CoordinatorLayout.acquireTempRect();
        getDescendantRect(view2, tempRect);
        getDesiredAnchoredChildRect(view, i3, tempRect, tempRect2);
        view.layout(tempRect2.left, tempRect2.top, tempRect2.right, tempRect2.bottom);
        CoordinatorLayout.releaseTempRect(tempRect);
        CoordinatorLayout.releaseTempRect(tempRect2);
    }

    private void layoutChildWithKeyline(View view, int i2, int i3) {
        int i4;
        int i6;
        int i;
        int i5;
        int obj10;
        int obj11;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i8 = e.b(CoordinatorLayout.resolveKeylineGravity(layoutParams.c), i3);
        i6 = i8 & 7;
        i8 &= 112;
        int width = getWidth();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        i5 = 1;
        if (i3 == i5) {
            obj10 = width - i2;
        }
        obj10 -= measuredWidth;
        if (i6 != i5) {
            if (i6 != 5) {
            } else {
                obj10 += measuredWidth;
            }
        } else {
            obj10 += i6;
        }
        if (i4 != 16) {
            if (i4 != 80) {
            } else {
                obj11 = measuredHeight + 0;
            }
        } else {
            obj11 += i4;
        }
        obj10 = Math.max(paddingLeft += leftMargin, Math.min(obj10, i12 -= rightMargin));
        obj11 = Math.max(paddingTop += topMargin, Math.min(obj11, i15 -= bottomMargin));
        view.layout(obj10, obj11, measuredWidth += obj10, measuredHeight += obj11);
    }

    private void offsetChildByInset(View view, Rect rect2, int i3) {
        int layoutParams;
        boolean insetDodgeRect;
        int i7;
        int i8;
        int i2;
        int i6;
        Rect tempRect;
        int top;
        int i5;
        int left;
        int rightMargin;
        int i4;
        int i;
        int bottom;
        int bottom2;
        int obj10;
        int obj11;
        if (!u.R(view)) {
        }
        if (view.getWidth() > 0) {
            if (view.getHeight() <= 0) {
            } else {
                layoutParams = view.getLayoutParams();
                insetDodgeRect = (CoordinatorLayout.f)layoutParams.f();
                tempRect = CoordinatorLayout.acquireTempRect();
                Rect tempRect2 = CoordinatorLayout.acquireTempRect();
                tempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (insetDodgeRect != null && insetDodgeRect.getInsetDodgeRect(this, view, tempRect)) {
                    if (insetDodgeRect.getInsetDodgeRect(this, view, tempRect)) {
                        if (!tempRect2.contains(tempRect)) {
                        } else {
                            CoordinatorLayout.releaseTempRect(tempRect2);
                            if (tempRect.isEmpty()) {
                                CoordinatorLayout.releaseTempRect(tempRect);
                            }
                            obj11 = e.b(layoutParams.h, i3);
                            i4 = 1;
                            i = 0;
                            i10 -= i12;
                            top = rect2.top;
                            if (obj11 & 48 == 48 && i6 < top) {
                                i10 -= i12;
                                top = rect2.top;
                                if (i6 < top) {
                                    setInsetOffsetY(view, top -= i6);
                                    i7 = i4;
                                } else {
                                    i7 = i;
                                }
                            } else {
                            }
                            i14 += i16;
                            bottom = rect2.bottom;
                            if (obj11 & 80 == 80 && i5 < bottom) {
                                i14 += i16;
                                bottom = rect2.bottom;
                                if (i5 < bottom) {
                                    setInsetOffsetY(view, i5 -= bottom);
                                    i7 = i4;
                                }
                            }
                            if (i7 == 0) {
                                setInsetOffsetY(view, i);
                            }
                            i11 -= i15;
                            left = rect2.left;
                            if (obj11 & 3 == 3 && i8 < left) {
                                i11 -= i15;
                                left = rect2.left;
                                if (i8 < left) {
                                    setInsetOffsetX(view, left -= i8);
                                    i2 = i4;
                                } else {
                                    i2 = i;
                                }
                            } else {
                            }
                            rightMargin = 5;
                            obj11 += layoutParams;
                            obj10 = rect2.right;
                            if (obj11 &= rightMargin == rightMargin && obj11 < obj10) {
                                obj11 += layoutParams;
                                obj10 = rect2.right;
                                if (obj11 < obj10) {
                                    setInsetOffsetX(view, obj11 -= obj10);
                                } else {
                                    i4 = i2;
                                }
                            } else {
                            }
                            if (i4 == 0) {
                                setInsetOffsetX(view, i);
                            }
                            CoordinatorLayout.releaseTempRect(tempRect);
                        }
                        obj10 = new StringBuilder();
                        obj10.append("Rect should be within the child's bounds. Rect:");
                        obj10.append(tempRect.toShortString());
                        obj10.append(" | Bounds:");
                        obj10.append(tempRect2.toShortString());
                        IllegalArgumentException obj9 = new IllegalArgumentException(obj10.toString());
                        throw obj9;
                    }
                }
                tempRect.set(tempRect2);
            }
        }
    }

    static androidx.coordinatorlayout.widget.CoordinatorLayout.c parseBehavior(Context context, AttributeSet attributeSet2, String string3) {
        StringBuilder stringBuilder2;
        Object constructor;
        String wIDGET_PACKAGE_NAME;
        Object hashMap;
        boolean stringBuilder;
        Class[] cONSTRUCTOR_PARAMS;
        Object obj7;
        if (TextUtils.isEmpty(string3)) {
            return null;
        }
        if (string3.startsWith(".")) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getPackageName());
            stringBuilder2.append(string3);
            obj7 = stringBuilder2.toString();
        } else {
            stringBuilder2 = 46;
            if (string3.indexOf(stringBuilder2) >= 0) {
            } else {
                wIDGET_PACKAGE_NAME = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                if (!TextUtils.isEmpty(wIDGET_PACKAGE_NAME)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(wIDGET_PACKAGE_NAME);
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(string3);
                    obj7 = stringBuilder.toString();
                }
            }
        }
        java.lang.ThreadLocal sConstructors = CoordinatorLayout.sConstructors;
        if ((Map)sConstructors.get() == null) {
            hashMap = new HashMap();
            sConstructors.set(hashMap);
        }
        int i2 = 1;
        final int i3 = 0;
        if ((Constructor)hashMap.get(obj7) == null) {
            constructor = Class.forName(obj7, i3, context.getClassLoader()).getConstructor(CoordinatorLayout.CONSTRUCTOR_PARAMS);
            constructor.setAccessible(i2);
            hashMap.put(obj7, constructor);
        }
        Object[] arr = new Object[2];
        arr[i3] = context;
        arr[i2] = attributeSet2;
        return (CoordinatorLayout.c)constructor.newInstance(arr);
    }

    private boolean performIntercept(MotionEvent motionEvent, int i2) {
        int obtain;
        int i;
        int onInterceptTouchEvent;
        int i7;
        Object obj;
        ViewGroup.LayoutParams layoutParams;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        int i5;
        long l;
        long uptimeMillis;
        int i3;
        int i4;
        int i8;
        int i6;
        final Object obj2 = this;
        final MotionEvent motionEvent2 = motionEvent;
        final int i9 = i2;
        final List mTempList1 = obj2.mTempList1;
        obj2.getTopSortedChildren(mTempList1);
        final int i10 = 0;
        obtain = 0;
        i7 = onInterceptTouchEvent;
        while (i < mTempList1.size()) {
            obj = mTempList1.get(i);
            layoutParams = (View)obj.getLayoutParams();
            cVar = (CoordinatorLayout.f)layoutParams.f();
            i5 = 1;
            if (onInterceptTouchEvent == 0 && cVar != null) {
            }
            obj = layoutParams.i(obj2, obj);
            if (obj != null && !layoutParams.c()) {
            } else {
            }
            i7 = i10;
            if (obj != null) {
                break;
            } else {
            }
            i++;
            if (i7 == 0) {
                break;
            } else {
            }
            if (!layoutParams.c()) {
            } else {
            }
            i7 = i5;
            if (cVar != null) {
            }
            if (i9 != 0) {
            } else {
            }
            onInterceptTouchEvent = cVar.onInterceptTouchEvent(obj2, obj, motionEvent2);
            if (onInterceptTouchEvent) {
            }
            obj2.mBehaviorTouchView = obj;
            if (i9 != i5) {
            } else {
            }
            onInterceptTouchEvent = cVar.onTouchEvent(obj2, obj, motionEvent2);
            if (cVar != null && obtain == 0) {
            }
            if (obtain == 0) {
            }
            if (i9 != 0) {
            } else {
            }
            cVar.onInterceptTouchEvent(obj2, obj, obtain);
            if (i9 != i5) {
            } else {
            }
            cVar.onTouchEvent(obj2, obj, obtain);
            uptimeMillis = SystemClock.uptimeMillis();
            obtain = MotionEvent.obtain(uptimeMillis, obj16, uptimeMillis, obj18, 3, 0);
        }
        mTempList1.clear();
        return onInterceptTouchEvent;
    }

    private void prepareChildren() {
        int i;
        View childAt2;
        androidx.coordinatorlayout.widget.CoordinatorLayout.f resolvedLayoutParams;
        int i2;
        View childAt;
        boolean mChildDag;
        boolean mChildDag2;
        this.mDependencySortedChildren.clear();
        this.mChildDag.c();
        int childCount = getChildCount();
        int i3 = 0;
        i = i3;
        while (i < childCount) {
            childAt2 = getChildAt(i);
            resolvedLayoutParams = getResolvedLayoutParams(childAt2);
            resolvedLayoutParams.d(this, childAt2);
            this.mChildDag.b(childAt2);
            i2 = i3;
            while (i2 < childCount) {
                if (i2 == i) {
                } else {
                }
                childAt = getChildAt(i2);
                if (resolvedLayoutParams.b(this, childAt2, childAt) && !this.mChildDag.d(childAt)) {
                }
                i2++;
                if (!this.mChildDag.d(childAt)) {
                }
                this.mChildDag.a(childAt, childAt2);
                this.mChildDag.b(childAt);
            }
            i++;
            if (i2 == i) {
            } else {
            }
            childAt = getChildAt(i2);
            if (resolvedLayoutParams.b(this, childAt2, childAt) && !this.mChildDag.d(childAt)) {
            }
            i2++;
            if (!this.mChildDag.d(childAt)) {
            }
            this.mChildDag.a(childAt, childAt2);
            this.mChildDag.b(childAt);
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.i());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        CoordinatorLayout.sRectPool.a(rect);
    }

    private void resetTouchBehaviors(boolean z) {
        int layoutParams;
        View childAt;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        MotionEvent obtain;
        long uptimeMillis;
        int i3;
        int i4;
        int i;
        int i2;
        int obj14;
        final int childCount = getChildCount();
        final int i5 = 0;
        layoutParams = i5;
        while (layoutParams < childCount) {
            childAt = getChildAt(layoutParams);
            cVar = (CoordinatorLayout.f)childAt.getLayoutParams().f();
            if (cVar != null) {
            }
            layoutParams++;
            uptimeMillis = SystemClock.uptimeMillis();
            obtain = MotionEvent.obtain(uptimeMillis, obj6, uptimeMillis, obj8, 3, 0);
            if (z) {
            } else {
            }
            cVar.onTouchEvent(this, childAt, obtain);
            obtain.recycle();
            cVar.onInterceptTouchEvent(this, childAt, obtain);
        }
        obj14 = i5;
        while (obj14 < childCount) {
            (CoordinatorLayout.f)getChildAt(obj14).getLayoutParams().m();
            obj14++;
        }
        this.mBehaviorTouchView = 0;
        this.mDisallowInterceptReset = i5;
    }

    private static int resolveAnchoredChildGravity(int i) {
        int obj0;
        if (i == 0) {
            obj0 = 17;
        }
        return obj0;
    }

    private static int resolveGravity(int i) {
        int i2;
        int obj1;
        if (i & 7 == 0) {
            i |= i2;
        }
        if (obj1 & 112 == 0) {
            obj1 |= 48;
        }
        return obj1;
    }

    private static int resolveKeylineGravity(int i) {
        int obj0;
        if (i == 0) {
            obj0 = 8388661;
        }
        return obj0;
    }

    private void setInsetOffsetX(View view, int i2) {
        int i;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        i = layoutParams.i;
        if (i != i2) {
            u.W(view, i2 - i);
            layoutParams.i = i2;
        }
    }

    private void setInsetOffsetY(View view, int i2) {
        int i;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        i = layoutParams.j;
        if (i != i2) {
            u.X(view, i2 - i);
            layoutParams.j = i2;
        }
    }

    private void setupForInsets() {
        int i;
        q mApplyWindowInsetsListener;
        if (Build.VERSION.SDK_INT < 21) {
        }
        if (u.y(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                mApplyWindowInsetsListener = new CoordinatorLayout.a(this);
                this.mApplyWindowInsetsListener = mApplyWindowInsetsListener;
            }
            u.x0(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
        } else {
            u.x0(this, 0);
        }
    }

    @Override // android.view.ViewGroup
    void addPreDrawListener() {
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener;
        boolean mIsAttachedToWindow;
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener2;
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener == null) {
            if (this.mOnPreDrawListener == null) {
                mOnPreDrawListener = new CoordinatorLayout.g(this);
                this.mOnPreDrawListener = mOnPreDrawListener;
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        Object obj2;
        if (layoutParams instanceof CoordinatorLayout.f && super.checkLayoutParams(layoutParams)) {
            obj2 = super.checkLayoutParams(layoutParams) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public void dispatchDependentViewsChanged(View view) {
        boolean empty;
        int size;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        List list = this.mChildDag.g(view);
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                empty = 0;
                while (empty < list.size()) {
                    size = list.get(empty);
                    cVar = (CoordinatorLayout.f)(View)size.getLayoutParams().f();
                    if (cVar != null) {
                    }
                    empty++;
                    cVar.onDependentViewChanged(this, size, view);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view2, long l3) {
        ViewGroup.LayoutParams layoutParams;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c scrimOpacity;
        boolean opaque;
        int cmp;
        Paint mScrimPaint2;
        int i2;
        float f4;
        int i;
        float f;
        float f3;
        float f2;
        Object mScrimPaint;
        layoutParams = view2.getLayoutParams();
        scrimOpacity = layoutParams.a;
        scrimOpacity = scrimOpacity.getScrimOpacity(this, view2);
        if (scrimOpacity != null && Float.compare(scrimOpacity, i5) > 0 && this.mScrimPaint == null) {
            scrimOpacity = scrimOpacity.getScrimOpacity(this, view2);
            if (Float.compare(scrimOpacity, i5) > 0) {
                if (this.mScrimPaint == null) {
                    mScrimPaint2 = new Paint();
                    this.mScrimPaint = mScrimPaint2;
                }
                this.mScrimPaint.setColor(layoutParams.a.getScrimColor(this, view2));
                this.mScrimPaint.setAlpha(CoordinatorLayout.clamp(Math.round(scrimOpacity *= i6), 0, 255));
                if (view2.isOpaque()) {
                    canvas.clipRect((float)left, (float)top, (float)right, (float)opaque, Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float)paddingLeft, (float)paddingTop, (float)i4, (float)scrimOpacity, this.mScrimPaint);
                canvas.restoreToCount(canvas.save());
            }
        }
        return super.drawChild(canvas, view2, l3);
    }

    @Override // android.view.ViewGroup
    protected void drawableStateChanged() {
        int[] drawableState;
        int i;
        boolean stateful;
        super.drawableStateChanged();
        final Drawable mStatusBarBackground = this.mStatusBarBackground;
        if (mStatusBarBackground != null && mStatusBarBackground.isStateful()) {
            if (mStatusBarBackground.isStateful()) {
                i |= drawableState;
            }
        }
        if (i != 0) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    void ensurePreDrawListener() {
        int i2;
        int i;
        boolean dependencies;
        i = i2;
        while (i < getChildCount()) {
            if (hasDependencies(getChildAt(i))) {
                break;
            } else {
            }
            i++;
        }
        if (i2 != this.mNeedsPreDrawListener) {
            if (i2 != 0) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected androidx.coordinatorlayout.widget.CoordinatorLayout.f generateDefaultLayoutParams() {
        final int i = -2;
        CoordinatorLayout.f fVar = new CoordinatorLayout.f(i, i);
        return fVar;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public androidx.coordinatorlayout.widget.CoordinatorLayout.f generateLayoutParams(AttributeSet attributeSet) {
        CoordinatorLayout.f fVar = new CoordinatorLayout.f(getContext(), attributeSet);
        return fVar;
    }

    @Override // android.view.ViewGroup
    protected androidx.coordinatorlayout.widget.CoordinatorLayout.f generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.f fVar = new CoordinatorLayout.f((CoordinatorLayout.f)layoutParams);
            return fVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            CoordinatorLayout.f fVar2 = new CoordinatorLayout.f((ViewGroup.MarginLayoutParams)layoutParams);
            return fVar2;
        }
        CoordinatorLayout.f fVar3 = new CoordinatorLayout.f(layoutParams);
        return fVar3;
    }

    @Override // android.view.ViewGroup
    void getChildRect(View view, boolean z2, Rect rect3) {
        boolean layoutRequested;
        int right;
        int obj3;
        int obj4;
        if (!view.isLayoutRequested()) {
            if (view.getVisibility() == 8) {
            } else {
                if (z2 != 0) {
                    getDescendantRect(view, rect3);
                } else {
                    rect3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
            }
        }
        rect3.setEmpty();
    }

    public List<View> getDependencies(View view) {
        List mTempDependenciesList;
        List obj2 = this.mChildDag.h(view);
        this.mTempDependenciesList.clear();
        if (obj2 != null) {
            this.mTempDependenciesList.addAll(obj2);
        }
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List mTempDependenciesList;
        List obj2 = this.mChildDag.g(view);
        this.mTempDependenciesList.clear();
        if (obj2 != null) {
            this.mTempDependenciesList.addAll(obj2);
        }
        return this.mTempDependenciesList;
    }

    @Override // android.view.ViewGroup
    void getDescendantRect(View view, Rect rect2) {
        b.a(this, view, rect2);
    }

    @Override // android.view.ViewGroup
    void getDesiredAnchoredChildRect(View view, int i2, Rect rect3, Rect rect4) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        this.getDesiredAnchoredChildRectWithoutConstraints(view, i2, rect3, rect4, (CoordinatorLayout.f)layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect4, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup
    void getLastChildRect(View view, Rect rect2) {
        rect2.set((CoordinatorLayout.f)view.getLayoutParams().h());
    }

    @Override // android.view.ViewGroup
    public final d0 getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    @Override // android.view.ViewGroup
    androidx.coordinatorlayout.widget.CoordinatorLayout.f getResolvedLayoutParams(View view) {
        boolean annotation;
        String str;
        int i;
        StringBuilder stringBuilder;
        String str2;
        Object obj7;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!layoutParams.b) {
            i = 1;
            if (view instanceof CoordinatorLayout.b) {
                obj7 = (CoordinatorLayout.b)view.getBehavior();
                if (obj7 == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                (CoordinatorLayout.f)layoutParams.o(obj7);
                layoutParams.b = i;
            } else {
                obj7 = view.getClass();
                annotation = 0;
                while (obj7 != null) {
                    if ((CoordinatorLayout.d)obj7.getAnnotation(CoordinatorLayout.d.class) == 0) {
                    }
                    obj7 = obj7.getSuperclass();
                }
                if (annotation != null) {
                    int i2 = 0;
                    layoutParams.o((CoordinatorLayout.c)annotation.value().getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]));
                }
                layoutParams.b = i;
            }
        }
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), paddingTop += paddingBottom);
    }

    @Override // android.view.ViewGroup
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), paddingLeft += paddingRight);
    }

    @Override // android.view.ViewGroup
    public boolean isPointInChildBounds(View view, int i2, int i3) {
        final Rect tempRect = CoordinatorLayout.acquireTempRect();
        getDescendantRect(view, tempRect);
        CoordinatorLayout.releaseTempRect(tempRect);
        return tempRect.contains(i2, i3);
    }

    @Override // android.view.ViewGroup
    void offsetChildToAnchor(View view, int i2) {
        int left2;
        int view2;
        int left;
        int i;
        int top;
        Rect rect;
        Rect rect2;
        ViewGroup.LayoutParams view3;
        int i4;
        int measuredHeight;
        Rect tempRect2;
        Rect tempRect3;
        Rect tempRect;
        int i3;
        int measuredWidth;
        int obj18;
        final androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout2 = this;
        final View view6 = view;
        final ViewGroup.LayoutParams view7 = layoutParams;
        if (view7.k != null) {
            tempRect2 = CoordinatorLayout.acquireTempRect();
            tempRect3 = CoordinatorLayout.acquireTempRect();
            tempRect = CoordinatorLayout.acquireTempRect();
            coordinatorLayout2.getDescendantRect(view7.k, tempRect2);
            coordinatorLayout2.getChildRect(view6, false, tempRect3);
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            this.getDesiredAnchoredChildRectWithoutConstraints(view, i2, tempRect2, tempRect, (CoordinatorLayout.f)view7, measuredWidth, measuredHeight);
            if (tempRect.left == tempRect3.left) {
                if (tempRect.top != tempRect3.top) {
                    i3 = 1;
                }
            } else {
            }
            coordinatorLayout2.constrainChildRect(view7, tempRect, measuredWidth, measuredHeight);
            left3 -= left4;
            top2 -= top;
            if (view2 != null) {
                u.W(view6, view2);
            }
            if (i != 0) {
                u.X(view6, i);
            }
            view2 = view7.f();
            if (i3 != 0 && view2 != null) {
                view2 = view7.f();
                if (view2 != null) {
                    view2.onDependentViewChanged(coordinatorLayout2, view6, view7.k);
                }
            }
            CoordinatorLayout.releaseTempRect(tempRect2);
            CoordinatorLayout.releaseTempRect(tempRect3);
            CoordinatorLayout.releaseTempRect(tempRect);
        }
    }

    @Override // android.view.ViewGroup
    public void onAttachedToWindow() {
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener;
        boolean mNeedsPreDrawListener;
        d0 mLastInsets;
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener2;
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener != null && this.mOnPreDrawListener == null) {
            if (this.mOnPreDrawListener == null) {
                mOnPreDrawListener = new CoordinatorLayout.g(this);
                this.mOnPreDrawListener = mOnPreDrawListener;
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && u.y(this)) {
            if (u.y(this)) {
                u.i0(this);
            }
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup
    final void onChildViewsChanged(int i) {
        int i4;
        Object obj;
        ViewGroup.LayoutParams layoutParams;
        int visibility;
        int visibility2;
        int i3;
        int equals;
        int onDependentViewChanged;
        int i2;
        int layoutParams2;
        int top;
        boolean layoutDependsOn;
        final Object obj2 = this;
        final int i5 = i;
        final int i6 = u.B(this);
        int size = obj2.mDependencySortedChildren.size();
        final Rect tempRect = CoordinatorLayout.acquireTempRect();
        final Rect tempRect2 = CoordinatorLayout.acquireTempRect();
        final Rect tempRect3 = CoordinatorLayout.acquireTempRect();
        final int i7 = 0;
        i4 = i7;
        while (i4 < size) {
            obj = obj2.mDependencySortedChildren.get(i4);
            layoutParams = (View)obj.getLayoutParams();
            if (i5 == 0 && obj.getVisibility() == 8) {
            } else {
            }
            i3 = i7;
            while (i3 < i4) {
                if (layoutParams.l == (View)obj2.mDependencySortedChildren.get(i3)) {
                }
                i3++;
                obj2.offsetChildToAnchor(obj, i6);
            }
            visibility2 = 1;
            obj2.getChildRect(obj, visibility2, tempRect2);
            if (layoutParams.g != 0 && !tempRect2.isEmpty()) {
            }
            if (layoutParams.h != 0 && obj.getVisibility() == 0) {
            }
            layoutParams = 2;
            if (i5 != layoutParams) {
            } else {
            }
            equals = i4 + 1;
            while (equals < size) {
                onDependentViewChanged = obj2.mDependencySortedChildren.get(equals);
                layoutParams2 = (View)onDependentViewChanged.getLayoutParams();
                top = (CoordinatorLayout.f)layoutParams2.f();
                if (top != 0 && top.layoutDependsOn(obj2, onDependentViewChanged, obj)) {
                }
                equals++;
                if (top.layoutDependsOn(obj2, onDependentViewChanged, obj)) {
                }
                if (i5 == 0 && layoutParams2.g()) {
                } else {
                }
                if (i5 != layoutParams) {
                } else {
                }
                top.onDependentViewRemoved(obj2, onDependentViewChanged, obj);
                onDependentViewChanged = visibility2;
                if (i5 == visibility2) {
                }
                layoutParams2.p(onDependentViewChanged);
                onDependentViewChanged = top.onDependentViewChanged(obj2, onDependentViewChanged, obj);
                if (layoutParams2.g()) {
                } else {
                }
                layoutParams2.k();
            }
            i4++;
            onDependentViewChanged = obj2.mDependencySortedChildren.get(equals);
            layoutParams2 = (View)onDependentViewChanged.getLayoutParams();
            top = (CoordinatorLayout.f)layoutParams2.f();
            if (top != 0 && top.layoutDependsOn(obj2, onDependentViewChanged, obj)) {
            }
            equals++;
            if (top.layoutDependsOn(obj2, onDependentViewChanged, obj)) {
            }
            if (i5 == 0 && layoutParams2.g()) {
            } else {
            }
            if (i5 != layoutParams) {
            } else {
            }
            top.onDependentViewRemoved(obj2, onDependentViewChanged, obj);
            onDependentViewChanged = visibility2;
            if (i5 == visibility2) {
            }
            layoutParams2.p(onDependentViewChanged);
            onDependentViewChanged = top.onDependentViewChanged(obj2, onDependentViewChanged, obj);
            if (layoutParams2.g()) {
            } else {
            }
            layoutParams2.k();
            obj2.getLastChildRect(obj, tempRect3);
            if (tempRect3.equals(tempRect2)) {
            } else {
            }
            obj2.recordLastChildRect(obj, tempRect2);
            if (obj.getVisibility() == 0) {
            }
            obj2.offsetChildByInset(obj, tempRect, i6);
            if (!tempRect2.isEmpty()) {
            }
            int i9 = e.b(layoutParams.g, i6);
            i2 = i9 & 112;
            if (i2 != 48) {
            } else {
            }
            tempRect.top = Math.max(tempRect.top, tempRect2.bottom);
            i9 &= 7;
            if (equals != 3) {
            } else {
            }
            tempRect.left = Math.max(tempRect.left, tempRect2.right);
            if (equals != 5) {
            } else {
            }
            tempRect.right = Math.max(tempRect.right, width -= layoutParams2);
            if (i2 != 80) {
            } else {
            }
            tempRect.bottom = Math.max(tempRect.bottom, height -= top);
            if (layoutParams.l == (View)obj2.mDependencySortedChildren.get(i3)) {
            }
            i3++;
            obj2.offsetChildToAnchor(obj, i6);
            if (obj.getVisibility() == 8) {
            } else {
            }
        }
        CoordinatorLayout.releaseTempRect(tempRect);
        CoordinatorLayout.releaseTempRect(tempRect2);
        CoordinatorLayout.releaseTempRect(tempRect3);
    }

    @Override // android.view.ViewGroup
    public void onDetachedFromWindow() {
        boolean mNeedsPreDrawListener;
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener;
        super.onDetachedFromWindow();
        final int i = 0;
        resetTouchBehaviors(i);
        if (this.mNeedsPreDrawListener != null && this.mOnPreDrawListener != null) {
            if (this.mOnPreDrawListener != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            }
        }
        View mNestedScrollingTarget = this.mNestedScrollingTarget;
        if (mNestedScrollingTarget != null) {
            onStopNestedScroll(mNestedScrollingTarget);
        }
        this.mIsAttachedToWindow = i;
    }

    @Override // android.view.ViewGroup
    public void onDraw(Canvas canvas) {
        boolean mDrawStatusBarBackground;
        int i;
        Drawable mStatusBarBackground;
        int width;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            if (this.mStatusBarBackground != null) {
                d0 mLastInsets = this.mLastInsets;
                i = 0;
                if (mLastInsets != null) {
                    mDrawStatusBarBackground = mLastInsets.l();
                } else {
                    mDrawStatusBarBackground = i;
                }
                if (mDrawStatusBarBackground > 0) {
                    this.mStatusBarBackground.setBounds(i, i, getWidth(), mDrawStatusBarBackground);
                    this.mStatusBarBackground.draw(canvas);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        final int actionMasked = motionEvent.getActionMasked();
        final int i2 = 1;
        if (actionMasked == 0) {
            resetTouchBehaviors(i2);
        }
        if (actionMasked != i2) {
            if (actionMasked == 3) {
                resetTouchBehaviors(i2);
            }
        } else {
        }
        return performIntercept(motionEvent, 0);
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        int obj4;
        Object obj5;
        int obj6;
        final int obj2 = u.B(this);
        obj4 = 0;
        while (obj4 < this.mDependencySortedChildren.size()) {
            obj5 = this.mDependencySortedChildren.get(obj4);
            if ((View)obj5.getVisibility() == 8) {
            } else {
            }
            obj6 = (CoordinatorLayout.f)obj5.getLayoutParams().f();
            if (obj6 != null) {
            } else {
            }
            onLayoutChild(obj5, obj2);
            obj4++;
            if (!obj6.onLayoutChild(this, obj5, obj2)) {
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onLayoutChild(View view, int i2) {
        int layoutParams;
        layoutParams = view.getLayoutParams();
        if ((CoordinatorLayout.f)layoutParams.a()) {
        } else {
            View view2 = layoutParams.k;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i2);
            } else {
                layoutParams = layoutParams.e;
                if (layoutParams >= 0) {
                    layoutChildWithKeyline(view, layoutParams, i2);
                } else {
                    layoutChild(view, i2);
                }
            }
        }
        IllegalStateException obj3 = new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        throw obj3;
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth;
        int measureSpec;
        boolean onMeasureChild;
        int suggestedMinimumHeight;
        Object view2;
        int combineMeasuredStates;
        d0 mLastInsets;
        int topMargin;
        int i12;
        int i5;
        int size;
        int paddingLeft;
        int i11;
        int i7;
        int i8;
        int i14;
        int i3;
        Object obj;
        int i10;
        int i13;
        int i18;
        int i15;
        int i16;
        int i17;
        ViewGroup.LayoutParams view;
        int i4;
        int i6;
        int i9;
        final Object obj3 = this;
        prepareChildren();
        ensurePreDrawListener();
        final int paddingRight = getPaddingRight();
        final int i44 = u.B(this);
        int i30 = 1;
        i14 = i44 == i30 ? i30 : 0;
        final int mode = View.MeasureSpec.getMode(i);
        final int size2 = View.MeasureSpec.getSize(i);
        if (obj3.mLastInsets != null && u.y(this)) {
            i3 = u.y(this) ? i30 : 0;
        } else {
        }
        size = obj3.mDependencySortedChildren.size();
        i5 = suggestedMinimumWidth;
        i12 = suggestedMinimumHeight;
        combineMeasuredStates = 0;
        topMargin = 0;
        while (topMargin < size) {
            obj = obj2;
            if ((View)obj.getVisibility() == 8) {
            } else {
            }
            view2 = layoutParams;
            measureSpec = view2.e;
            if (measureSpec >= 0 && mode != 0) {
            } else {
            }
            i18 = combineMeasuredStates;
            i10 = i7;
            if (i3 != 0 && !u.y(obj)) {
            } else {
            }
            i8 = i;
            i15 = i2;
            onMeasureChild = (CoordinatorLayout.f)view2.f();
            if (onMeasureChild != null) {
            } else {
            }
            view = view2;
            i4 = i12;
            i9 = size;
            i6 = paddingLeft;
            i17 = i18;
            i13 = topMargin;
            paddingLeft = i5;
            this.onMeasureChild(obj, i8, i10, i15, 0);
            ViewGroup.LayoutParams view3 = view;
            combineMeasuredStates = View.combineMeasuredStates(i17, obj.getMeasuredState());
            i5 = suggestedMinimumWidth;
            i12 = suggestedMinimumHeight;
            topMargin = i13 + 1;
            paddingLeft = i6;
            size = i9;
            view = view4;
            i17 = i18;
            i13 = topMargin;
            i4 = i12;
            i6 = paddingLeft;
            paddingLeft = i5;
            i9 = size;
            if (!onMeasureChild.onMeasureChild(this, obj, i8, i10, i15, 0)) {
            }
            if (!u.y(obj)) {
            } else {
            }
            i8 = measureSpec;
            i15 = combineMeasuredStates;
            if (mode != 0) {
            } else {
            }
            measureSpec = obj3.getKeyline(measureSpec);
            i47 &= 7;
            i18 = combineMeasuredStates;
            if (i11 == 3) {
            } else {
            }
            combineMeasuredStates = 5;
            if (i11 == combineMeasuredStates && i14 != 0) {
            } else {
            }
            if (i11 == combineMeasuredStates) {
            } else {
            }
            if (i11 == 3 && i14 != 0) {
            } else {
            }
            if (i14 != 0) {
            } else {
            }
            i10 = measureSpec;
            if (i14 != 0) {
            } else {
            }
            if (i14 != 0) {
            } else {
            }
            measureSpec = 0;
            i7 = measureSpec;
            i10 = combineMeasuredStates;
            if (i14 != 0) {
            } else {
            }
            i13 = topMargin;
            i9 = size;
            i6 = paddingLeft;
        }
        int i48 = combineMeasuredStates;
        obj3.setMeasuredDimension(View.resolveSizeAndState(i5, i, i26 &= i48), View.resolveSizeAndState(i12, i2, i48 << 16));
    }

    @Override // android.view.ViewGroup
    public void onMeasureChild(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean onNestedFling(View view, float f2, float f3, boolean z4) {
        int i2;
        int i;
        int onNestedFling;
        int i3;
        View childAt;
        View view2;
        float f;
        float f4;
        boolean z;
        int obj12;
        final int i4 = 0;
        i = i2;
        while (i2 < getChildCount()) {
            childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            onNestedFling = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)onNestedFling.j(i4)) {
            } else {
            }
            onNestedFling = onNestedFling.f();
            if (onNestedFling != null) {
            }
            i2++;
            i |= onNestedFling;
        }
        if (i != 0) {
            onChildViewsChanged(1);
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int i;
        int i2;
        int onNestedPreFling;
        int i3;
        View childAt;
        View view2;
        float f4;
        float f;
        final int i4 = 0;
        i2 = i;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            onNestedPreFling = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)onNestedPreFling.j(i4)) {
            } else {
            }
            onNestedPreFling = onNestedPreFling.f();
            if (onNestedPreFling != null) {
            }
            i++;
            i2 |= onNestedPreFling;
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4) {
        this.onNestedPreScroll(view, i2, i3, i4Arr4, 0);
    }

    @Override // android.view.ViewGroup
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5) {
        int i13;
        int i;
        int i8;
        int layoutParams;
        View childAt;
        int i4;
        int i14;
        int i10;
        int[] mBehaviorConsumed;
        int i9;
        int i15;
        int i11;
        int i6;
        int i12;
        int i7;
        final Object obj = this;
        final int i20 = 0;
        i6 = i11;
        i12 = 1;
        while (i15 < getChildCount()) {
            childAt = obj.getChildAt(i15);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            layoutParams = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)layoutParams.j(i5)) {
            } else {
            }
            layoutParams = layoutParams.f();
            if (layoutParams != null) {
            }
            i15++;
            i12 = 1;
            mBehaviorConsumed = obj.mBehaviorConsumed;
            mBehaviorConsumed[i20] = i20;
            mBehaviorConsumed[i12] = i20;
            layoutParams.onNestedPreScroll(this, childAt, view, i2, i3, mBehaviorConsumed, i5);
            int[] mBehaviorConsumed2 = obj.mBehaviorConsumed;
            if (i2 > 0) {
            } else {
            }
            i = Math.min(i11, mBehaviorConsumed2[i20]);
            i11 = i;
            int[] mBehaviorConsumed3 = obj.mBehaviorConsumed;
            if (i3 > 0) {
            } else {
            }
            i8 = Math.min(i6, mBehaviorConsumed3[i12]);
            i6 = i8;
            i13 = i12;
            i8 = Math.max(i6, mBehaviorConsumed3[i12]);
            i = Math.max(i11, mBehaviorConsumed2[i20]);
            i7 = i5;
        }
        i4Arr4[i20] = i11;
        i4Arr4[i12] = i6;
        if (i13 != 0) {
            obj.onChildViewsChanged(i12);
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.onNestedScroll(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        this.onNestedScroll(view, i2, i3, i4, i5, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // android.view.ViewGroup
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] i7Arr7) {
        int i;
        int i15;
        int i7;
        int layoutParams;
        View childAt;
        int i18;
        int i17;
        int i13;
        int i12;
        int i16;
        int i9;
        int i8;
        int i10;
        int i11;
        int i14;
        int[] iArr;
        final Object obj = this;
        final int i28 = 0;
        i14 = i11;
        i8 = 1;
        while (i10 < getChildCount()) {
            childAt = obj.getChildAt(i10);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            layoutParams = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)layoutParams.j(i6)) {
            } else {
            }
            layoutParams = layoutParams.f();
            if (layoutParams != null) {
            }
            i10++;
            i8 = 1;
            int[] mBehaviorConsumed4 = obj.mBehaviorConsumed;
            mBehaviorConsumed4[i28] = i28;
            mBehaviorConsumed4[i8] = i28;
            layoutParams.onNestedScroll(this, childAt, view, i2, i3, i4, i5, i6, mBehaviorConsumed4);
            int[] mBehaviorConsumed = obj.mBehaviorConsumed;
            if (i4 > 0) {
            } else {
            }
            i15 = Math.min(i11, mBehaviorConsumed[i28]);
            i11 = i15;
            if (i5 > 0) {
            } else {
            }
            i7 = Math.min(i14, obj.mBehaviorConsumed[1]);
            i14 = i7;
            i = layoutParams;
            i7 = Math.max(i14, obj.mBehaviorConsumed[1]);
            i15 = Math.max(i11, mBehaviorConsumed[i28]);
        }
        int i23 = i8;
        i7Arr7[i28] = i24 += i11;
        i7Arr7[i23] = i26 += i14;
        if (i != 0) {
            obj.onChildViewsChanged(i23);
        }
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup
    public void onNestedScrollAccepted(View view, View view2, int i3, int i4) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        View childAt;
        View view3;
        View view4;
        int i5;
        int i2;
        this.mNestedScrollingParentHelper.c(view, view2, i3, i4);
        this.mNestedScrollingTarget = view2;
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            layoutParams = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)layoutParams.j(i4)) {
            } else {
            }
            layoutParams = layoutParams.f();
            if (layoutParams != null) {
            }
            i++;
            layoutParams.onNestedScrollAccepted(this, childAt, view, view2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i3;
        View childAt;
        int i;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        int i2;
        if (!parcelable instanceof CoordinatorLayout.h) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((CoordinatorLayout.h)parcelable.a());
        i3 = 0;
        while (i3 < getChildCount()) {
            childAt = getChildAt(i3);
            i = childAt.getId();
            cVar = getResolvedLayoutParams(childAt).f();
            i = parcelable.c.get(i);
            if (i != -1 && cVar != null && (Parcelable)i != null) {
            }
            i3++;
            if (cVar != null) {
            }
            i = obj7.get(i);
            if ((Parcelable)(Parcelable)i != null) {
            }
            cVar.onRestoreInstanceState(this, childAt, (Parcelable)(Parcelable)i);
        }
    }

    @Override // android.view.ViewGroup
    protected Parcelable onSaveInstanceState() {
        int i;
        View onSaveInstanceState;
        int i2;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        int i3;
        CoordinatorLayout.h hVar = new CoordinatorLayout.h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        i = 0;
        while (i < getChildCount()) {
            onSaveInstanceState = getChildAt(i);
            i2 = onSaveInstanceState.getId();
            cVar = (CoordinatorLayout.f)onSaveInstanceState.getLayoutParams().f();
            onSaveInstanceState = cVar.onSaveInstanceState(this, onSaveInstanceState);
            if (i2 != -1 && cVar != null && onSaveInstanceState != null) {
            }
            i++;
            if (cVar != null) {
            }
            onSaveInstanceState = cVar.onSaveInstanceState(this, onSaveInstanceState);
            if (onSaveInstanceState != null) {
            }
            sparseArray.append(i2, onSaveInstanceState);
        }
        hVar.c = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup
    public boolean onStartNestedScroll(View view, View view2, int i3, int i4) {
        int onStartNestedScroll;
        int i;
        View childAt;
        View view4;
        View view3;
        int i6;
        int i7;
        int i2;
        int i5;
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout;
        ViewGroup.LayoutParams view5;
        final int i8 = i4;
        final int i9 = 0;
        i5 = i2;
        while (i2 < getChildCount()) {
            coordinatorLayout = this;
            childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            view5 = layoutParams;
            onStartNestedScroll = (CoordinatorLayout.f)view5.f();
            if (onStartNestedScroll != null) {
            } else {
            }
            view5.r(i8, i9);
            i2++;
            onStartNestedScroll = onStartNestedScroll.onStartNestedScroll(this, childAt, view, view2, i3, i4);
            i5 |= onStartNestedScroll;
            view5.r(i8, onStartNestedScroll);
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout2 = this;
        return i5;
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void onStopNestedScroll(View view, int i2) {
        int i;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        this.mNestedScrollingParentHelper.e(view, i2);
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            layoutParams = childAt.getLayoutParams();
            if (!(CoordinatorLayout.f)layoutParams.j(i2)) {
            } else {
            }
            z = layoutParams.f();
            if (z != null) {
            }
            layoutParams.l(i2);
            layoutParams.k();
            i++;
            z.onStopNestedScroll(this, childAt, view, i2);
        }
        this.mNestedScrollingTarget = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent onTouchEvent2;
        boolean intercept;
        androidx.coordinatorlayout.widget.CoordinatorLayout.c cVar;
        int onTouchEvent;
        View mBehaviorTouchView;
        int obtain;
        long l;
        long uptimeMillis;
        int i2;
        int i3;
        int i;
        int i4;
        final Object obj = this;
        onTouchEvent2 = motionEvent;
        final int actionMasked = motionEvent.getActionMasked();
        final int i5 = 1;
        final int i6 = 0;
        if (obj.mBehaviorTouchView == null) {
            if (obj.performIntercept(onTouchEvent2, i5)) {
                cVar = (CoordinatorLayout.f)obj.mBehaviorTouchView.getLayoutParams().f();
                if (cVar != null) {
                    onTouchEvent = cVar.onTouchEvent(obj, obj.mBehaviorTouchView, onTouchEvent2);
                } else {
                    onTouchEvent = i6;
                }
            } else {
            }
        } else {
            intercept = i6;
        }
        obtain = 0;
        if (obj.mBehaviorTouchView == null) {
            onTouchEvent |= onTouchEvent2;
        } else {
            if (intercept) {
                uptimeMillis = SystemClock.uptimeMillis();
                super.onTouchEvent(MotionEvent.obtain(uptimeMillis, obj10, uptimeMillis, obj12, 3, 0));
            }
        }
        if (obtain != 0) {
            obtain.recycle();
        }
        if (actionMasked != i5) {
            if (actionMasked == 3) {
                obj.resetTouchBehaviors(i6);
            }
        } else {
        }
        return onTouchEvent;
    }

    @Override // android.view.ViewGroup
    void recordLastChildRect(View view, Rect rect2) {
        (CoordinatorLayout.f)view.getLayoutParams().q(rect2);
    }

    @Override // android.view.ViewGroup
    void removePreDrawListener() {
        boolean mIsAttachedToWindow;
        androidx.coordinatorlayout.widget.CoordinatorLayout.g mOnPreDrawListener;
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            if (this.mOnPreDrawListener != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            }
        }
        this.mNeedsPreDrawListener = false;
    }

    @Override // android.view.ViewGroup
    public boolean requestChildRectangleOnScreen(View view, Rect rect2, boolean z3) {
        androidx.coordinatorlayout.widget.CoordinatorLayout.c onRequestChildRectangleOnScreen;
        onRequestChildRectangleOnScreen = (CoordinatorLayout.f)view.getLayoutParams().f();
        if (onRequestChildRectangleOnScreen != null && onRequestChildRectangleOnScreen.onRequestChildRectangleOnScreen(this, view, rect2, z3)) {
            if (onRequestChildRectangleOnScreen.onRequestChildRectangleOnScreen(this, view, rect2, z3)) {
                return 1;
            }
        }
        return super.requestChildRectangleOnScreen(view, rect2, z3);
    }

    @Override // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        boolean obj1;
        super.requestDisallowInterceptTouchEvent(z);
        if (z && this.mDisallowInterceptReset == null) {
            if (this.mDisallowInterceptReset == null) {
                resetTouchBehaviors(false);
                this.mDisallowInterceptReset = true;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setStatusBarBackground(Drawable drawable) {
        Drawable mStatusBarBackground;
        int mutate;
        Drawable obj3;
        mStatusBarBackground = this.mStatusBarBackground;
        if (mStatusBarBackground != drawable && mStatusBarBackground != null) {
            if (mStatusBarBackground != null) {
                mStatusBarBackground.setCallback(0);
            }
            if (drawable != null) {
                mutate = drawable.mutate();
            }
            this.mStatusBarBackground = mutate;
            if (mutate != 0 && mutate.isStateful()) {
                if (mutate.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                a.m(this.mStatusBarBackground, u.B(this));
                mutate = 0;
                mStatusBarBackground = getVisibility() == 0 ? 1 : mutate;
                this.mStatusBarBackground.setVisible(mStatusBarBackground, mutate);
                this.mStatusBarBackground.setCallback(this);
            }
            u.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public void setStatusBarBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        setStatusBarBackground(colorDrawable);
    }

    @Override // android.view.ViewGroup
    public void setStatusBarBackgroundResource(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.f(getContext(), i);
        } else {
            obj2 = 0;
        }
        setStatusBarBackground(obj2);
    }

    @Override // android.view.ViewGroup
    public void setVisibility(int i) {
        Drawable mStatusBarBackground;
        int obj3;
        super.setVisibility(i);
        final int i2 = 0;
        obj3 = i == 0 ? 1 : i2;
        mStatusBarBackground = this.mStatusBarBackground;
        if (mStatusBarBackground != null && mStatusBarBackground.isVisible() != obj3) {
            if (mStatusBarBackground.isVisible() != obj3) {
                this.mStatusBarBackground.setVisible(obj3, i2);
            }
        }
    }

    @Override // android.view.ViewGroup
    final d0 setWindowInsets(d0 d0) {
        boolean z;
        int i;
        Drawable background;
        Object obj4;
        if (!c.a(this.mLastInsets, d0)) {
            this.mLastInsets = d0;
            i = 0;
            if (d0 != null && d0.l() > 0) {
                background = d0.l() > 0 ? z : i;
            } else {
            }
            this.mDrawStatusBarBackground = background;
            if (background == 0 && getBackground() == null) {
                if (getBackground() == null) {
                } else {
                    z = i;
                }
            } else {
            }
            setWillNotDraw(z);
            obj4 = dispatchApplyWindowInsetsToBehaviors(d0);
            requestLayout();
        }
        return obj4;
    }

    @Override // android.view.ViewGroup
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable mStatusBarBackground;
        int obj2;
        if (!super.verifyDrawable(drawable)) {
            if (drawable == this.mStatusBarBackground) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
