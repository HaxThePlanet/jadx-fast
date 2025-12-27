package d.h.l;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import d.h.l.e0.c.a;
import d.h.l.e0.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class u {

    private static final AtomicInteger a = new AtomicInteger(1);
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static WeakHashMap<View, z> g;
    private static Field h;
    private static boolean i;
    private static java.lang.ThreadLocal<Rect> j;
    private static final int[] k;

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        private WeakHashMap<View, Boolean> a = new WeakHashMap<>();
        e() {
            super();
            final WeakHashMap weakHashMap = new WeakHashMap();
        }

        private void a(View view, boolean z) {
            int i = 32;
            int r0 = view.getVisibility() == 0 ? 1 : 0;
            if (z != z && z) {
                i = 16;
                u.V(view, i);
                this.a.put(view, Boolean.valueOf(z));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            Object key;
            int i = 28;
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    a((View)item.getKey(), (Boolean)item.getValue().booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        private final int a;
        private final Class<T> b;
        private final int c;
        private final int d;
        f(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        private boolean b() {
            boolean z = true;
            int r0 = Build.VERSION.SDK_INT >= 19 ? 1 : 0;
            return (Build.VERSION.SDK_INT >= 19 ? 1 : 0);
        }

        private boolean c() {
            boolean z = true;
            int r0 = Build.VERSION.SDK_INT >= this.c ? 1 : 0;
            return (Build.VERSION.SDK_INT >= this.c ? 1 : 0);
        }

        boolean a(Boolean boolean, Boolean boolean2) {
            boolean z = false;
            boolean booleanValue;
            boolean booleanValue2;
            int i = 0;
            if (boolean == null) {
            } else {
                booleanValue = boolean.booleanValue();
            }
            if (boolean2 == null) {
            } else {
                booleanValue2 = boolean2.booleanValue();
            }
            if (booleanValue == booleanValue2) {
                int i2 = 1;
            }
            return z;
        }

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (b()) {
                Object tag = view.getTag(this.a);
                if (this.b.isInstance(tag)) {
                    return tag;
                }
            }
            return null;
        }

        void g(View view, T t) {
            if (c()) {
                e(view, t);
            } else {
                if (b()) {
                    if (h(f(view), t)) {
                        u.E(view);
                        view.setTag(this.a, t);
                        u.V(view, this.d);
                    }
                }
            }
        }

        f(int i, Class<T> cls, int i2, int i3) {
            super();
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }

        abstract T d(View view);

        abstract void e(View view, T t);

        abstract boolean h(T t, T t2);
    }

    private static class g {
        static void a(WindowInsets windowInsets, View view) {
            Object tag = view.getTag(c.R);
            if (tag != null) {
                tag.onApplyWindowInsets(view, windowInsets);
            }
        }

        static d0 b(View view, d0 d0Var, Rect rect) {
            final WindowInsets windowInsets = d0Var.u();
            if (windowInsets != null) {
                return d0.w(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return d0Var;
        }

        public static d0 c(View view) {
            return d0.a.a(view);
        }

        static void d(View view, q qVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(c.L, qVar);
            }
            if (qVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)view.getTag(c.R));
                return;
            }
            view.setOnApplyWindowInsetsListener(new u.g.a(view, qVar));
        }
    }

    private static class h {
        public static d0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            d.h.l.d0 d0Var = d0.v(rootWindowInsets);
            d0Var.s(d0Var);
            d0Var.d(view.getRootView());
            return d0Var;
        }
    }

    private static class i {
        static void a(View view, Context context, int[] iArr, AttributeSet set, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, set, typedArray, i, i2);
        }
    }

    public interface j {
        boolean a(View view, KeyEvent keyEvent);
    }

    static class k {

        private static final ArrayList<WeakReference<View>> d = new ArrayList<>();
        private WeakHashMap<View, Boolean> a = null;
        private SparseArray<WeakReference<View>> b = null;
        private WeakReference<KeyEvent> c = null;

        k() {
            super();
        }

        static u.k a(View view) {
            Object tag;
            final int i = c.P;
            if ((u.k)view.getTag(i) == null) {
                view.setTag(c.P, new u.k());
            }
            return tag;
        }

        private View c(View view, KeyEvent keyEvent) {
            boolean z;
            int i;
            View view3;
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.b == null) {
                this.b = new SparseArray();
            }
            return this.b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int i;
            boolean z;
            Object tag = view.getTag(c.Q);
            if (tag != null) {
                int i2 = 1;
                i = tag.size() - i2;
                while (i >= 0) {
                    if ((u.j)tag.get(i).a(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void g() {
            int i;
            ViewParent parent;
            boolean z;
            Boolean tRUE2;
            Boolean tRUE22;
            if (this.a != null) {
                this.a.clear();
            }
            ArrayList list = u.k.d;
            if (list.isEmpty()) {
                return;
            }
            synchronized (list) {
                try {
                    if (this.a == null) {
                        this.a = new WeakHashMap();
                    }
                    i = u.k.d.size() - 1;
                    while (this.a >= 0) {
                        ArrayList list2 = u.k.d;
                        Object obj = (WeakReference)list2.get(i).get();
                        if (obj == null) {
                            u.k.d.remove(i);
                        } else {
                            this.a.put(obj, Boolean.TRUE);
                            parent = obj.getParent();
                            z = parent instanceof View;
                            while (parent instanceof View) {
                                this.a.put((View)parent, Boolean.TRUE);
                                parent = parent.getParent();
                                z = parent instanceof View;
                            }
                        }
                        i = i - 1;
                    }
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            boolean z = true;
            if (keyEvent.getAction() == 0) {
                g();
            }
            View view2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0 && view2 != null && !KeyEvent.isModifierKey(keyCode)) {
                d().put(keyCode, new WeakReference(view2));
            }
            view = view2 != null ? 1 : 0;
            return (view2 != null ? 1 : 0);
        }

        boolean f(KeyEvent keyEvent) {
            int i = 0;
            int i2 = 0;
            if (this.c != null && this.c.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference(keyEvent);
            i = 0;
            final SparseArray sparseArray = d();
            final int i3 = 1;
            if (keyEvent.getAction() == i3 && indexOfKey >= 0) {
                Object valueAt = sparseArray.valueAt(indexOfKey);
                sparseArray.removeAt(indexOfKey);
            }
            if (this.c == 0) {
                Object obj = sparseArray.get(keyEvent.getKeyCode());
            }
            if (this.c != 0) {
                Object obj2 = i.get();
                if (obj2 != null && u.Q(obj2)) {
                    e(obj2, keyEvent);
                }
                return true;
            }
            return false;
        }
    }

    class a extends u.f<Boolean> {
        a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // d.h.l.u$f
        Boolean i(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // d.h.l.u$f
        void j(View view, Boolean boolean) {
            view.setScreenReaderFocusable(boolean.booleanValue());
        }

        @Override // d.h.l.u$f
        boolean k(Boolean boolean, Boolean boolean2) {
            return !(a(boolean, boolean2));
        }
    }

    class b extends u.f<java.lang.CharSequence> {
        b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // d.h.l.u$f
        java.lang.CharSequence i(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // d.h.l.u$f
        void j(View view, java.lang.CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @Override // d.h.l.u$f
        boolean k(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return !(TextUtils.equals(charSequence, charSequence2));
        }
    }

    class c extends u.f<java.lang.CharSequence> {
        c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // d.h.l.u$f
        java.lang.CharSequence i(View view) {
            return view.getStateDescription();
        }

        @Override // d.h.l.u$f
        void j(View view, java.lang.CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        @Override // d.h.l.u$f
        boolean k(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return !(TextUtils.equals(charSequence, charSequence2));
        }
    }

    class d extends u.f<Boolean> {
        d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // d.h.l.u$f
        Boolean i(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // d.h.l.u$f
        void j(View view, Boolean boolean) {
            view.setAccessibilityHeading(boolean.booleanValue());
        }

        @Override // d.h.l.u$f
        boolean k(Boolean boolean, Boolean boolean2) {
            return !(a(boolean, boolean2));
        }
    }
    static {
        u.g = null;
        boolean z = false;
        u.i = z;
        int[] iArr = new int[32];
        iArr[z] = c.b;
        iArr[1] = c.c;
        iArr[2] = c.n;
        iArr[3] = c.y;
        iArr[4] = c.B;
        iArr[5] = c.C;
        iArr[6] = c.D;
        iArr[7] = c.E;
        iArr[8] = c.F;
        iArr[9] = c.G;
        iArr[10] = c.d;
        iArr[11] = c.e;
        iArr[12] = c.f;
        iArr[13] = c.g;
        iArr[14] = c.h;
        iArr[15] = c.i;
        iArr[16] = c.j;
        iArr[17] = c.k;
        iArr[18] = c.l;
        iArr[19] = c.m;
        iArr[20] = c.o;
        iArr[21] = c.p;
        iArr[22] = c.q;
        iArr[23] = c.r;
        iArr[24] = c.s;
        iArr[25] = c.t;
        iArr[26] = c.u;
        iArr[27] = c.v;
        iArr[28] = c.w;
        iArr[29] = c.x;
        iArr[30] = c.z;
        iArr[31] = c.A;
        u.k = iArr;
        d.h.l.u.e eVar = new u.e();
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void A0(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void B0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
        } else {
            if (u.f == null) {
                u.f = new WeakHashMap();
            }
            u.f.put(view, str);
        }
    }

    public static int C(View view) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
        int i = 16;
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!u.e) {
            boolean z = true;
            try {
                str = "mMinHeight";
                Field declaredField = View.class.getDeclaredField(str);
                u.d = declaredField;
                declaredField.setAccessible(z);
            } catch (Exception unused) {
                return 0;
            }
            u.e = z;
        }
        Field field = u.d;
        if (u.d != null) {
            try {
            } catch (Exception unused) {
                return 0;
            }
            return (Integer)u.d.get(view).intValue();
        }
    }

    private static void C0(View view) {
        ViewParent parent;
        int i3 = 4;
        if (u.z(view) == 0) {
            int i = 1;
            u.v0(view, i);
        }
        parent = view.getParent();
        z = parent instanceof View;
        while (parent instanceof View) {
            i3 = 4;
            if (u.z((View)parent) == 4) {
                u.v0(view, 2);
            }
        }
    }

    public static int D(View view) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        int i = 16;
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!u.c) {
            boolean z = true;
            try {
                str = "mMinWidth";
                Field declaredField = View.class.getDeclaredField(str);
                u.b = declaredField;
                declaredField.setAccessible(z);
            } catch (Exception unused) {
                return 0;
            }
            u.c = z;
        }
        Field field = u.b;
        if (u.b != null) {
            try {
            } catch (Exception unused) {
                return 0;
            }
            return (Integer)u.b.get(view).intValue();
        }
    }

    private static u.f<java.lang.CharSequence> D0() {
        return new u.c(c.N, CharSequence.class, 64, 30);
    }

    static a E(View view) {
        d.h.l.a aVar;
        if (u.l(view) == null) {
            aVar = new a();
        }
        u.l0(view, aVar);
        return aVar;
    }

    public static void E0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else {
            if (view instanceof k) {
                view.stopNestedScroll();
            }
        }
    }

    public static int F(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    private static void F0(View view) {
        final float translationY = view.getTranslationY();
        view.setTranslationY(1f + translationY);
        view.setTranslationY(translationY);
    }

    public static int G(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static d0 H(View view) {
        final int sDK_INT2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            return u.h.a(view);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return u.g.c(view);
        }
        return null;
    }

    public static final java.lang.CharSequence I(View view) {
        return (CharSequence)u.D0().f(view);
    }

    public static String J(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap weakHashMap = u.f;
        if (u.f == null) {
            return null;
        }
        return (String)u.f.get(view);
    }

    public static int K(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float L(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0;
    }

    public static boolean M(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean P(View view) {
        boolean booleanValue = false;
        Object obj = u.a().f(view);
        if (obj == null) {
            int i = 0;
        } else {
            booleanValue = obj.booleanValue();
        }
        return booleanValue;
    }

    public static boolean Q(View view) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        view = view.getWindowToken() != null ? 1 : 0;
        return (view.getWindowToken() != null ? 1 : 0);
    }

    public static boolean R(View view) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        view = view.getWidth() > 0 && view.getHeight() > 0 ? 1 : 0;
        return (view.getWidth() > 0 && view.getHeight() > 0 ? 1 : 0);
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof k) {
            return view.isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean U(View view) {
        boolean booleanValue = false;
        Object obj = u.k0().f(view);
        if (obj == null) {
            int i = 0;
        } else {
            booleanValue = obj.booleanValue();
        }
        return booleanValue;
    }

    static void V(View view, int i) {
        int i3 = 2048;
        List text;
        Object systemService = view.getContext().getSystemService("accessibility");
        if (!systemService.isEnabled()) {
            return;
        }
        int r1 = u.p(view) != null && view.getVisibility() == 0 ? 1 : 0;
        i3 = 32;
        if (u.o(view) != 0 || i != 0) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            if (i == 0) {
                i3 = 2048;
            }
            obtain.setEventType(i3);
            obtain.setContentChangeTypes(i);
            if (i != 0) {
                obtain.getText().add(u.p(view));
                u.C0(view);
            }
            view.sendAccessibilityEventUnchecked(obtain);
        }
    }

    public static void W(View view, int i) {
        int top = 0;
        boolean z;
        int right;
        int bottom;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        top = 23;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
        } else {
            top = 21;
            if (Build.VERSION.SDK_INT >= 21) {
                Rect rect = u.x();
                top = 0;
                ViewParent parent = view.getParent();
                z = parent instanceof View;
                if (parent instanceof View) {
                    rect.set(parent.getLeft(), parent.getTop(), parent.getRight(), parent.getBottom());
                    top = !(rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
                u.e(view, i);
                if (top != 0) {
                    if (rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                        parent.invalidate(rect);
                    }
                }
            } else {
                u.e(view, i);
            }
        }
    }

    public static void X(View view, int i) {
        int top = 0;
        boolean z;
        int right;
        int bottom;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        top = 23;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
        } else {
            top = 21;
            if (Build.VERSION.SDK_INT >= 21) {
                Rect rect = u.x();
                top = 0;
                ViewParent parent = view.getParent();
                z = parent instanceof View;
                if (parent instanceof View) {
                    rect.set(parent.getLeft(), parent.getTop(), parent.getRight(), parent.getBottom());
                    top = !(rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
                u.f(view, i);
                if (top != 0) {
                    if (rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                        parent.invalidate(rect);
                    }
                }
            } else {
                u.f(view, i);
            }
        }
    }

    public static d0 Y(View view, d0 d0Var) {
        int i = 21;
        if (Build.VERSION.SDK_INT >= 21 && windowInsets != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return d0.w(onApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    public static void Z(View view, d.h.l.e0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.x0());
    }

    private static u.f<Boolean> a() {
        return new u.d(c.J, Boolean.class, 28);
    }

    private static u.f<java.lang.CharSequence> a0() {
        return new u.b(c.K, CharSequence.class, 8, 28);
    }

    public static int b(View view, java.lang.CharSequence charSequence, f fVar) {
        final int i2 = u.r(view, charSequence);
        int i = -1;
        if (i2 != -1) {
            u.c(view, new c.a(i2, charSequence, fVar));
        }
        return i2;
    }

    public static boolean b0(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    private static void c(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            u.E(view);
            u.g0(aVar.b(), view);
            u.q(view).add(aVar);
            int i = 0;
            u.V(view, i);
        }
    }

    public static void c0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static z d(View view) {
        Object value;
        if (u.g == null) {
            u.g = new WeakHashMap();
        }
        if ((z)u.g.get(view) == null) {
            u.g.put(view, new z(view));
        }
        return value;
    }

    public static void d0(View view, Runnable runnable) {
        final int i = 16;
        if (Build.VERSION.SDK_INT >= i) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    private static void e(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            u.F0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                u.F0(parent);
            }
        }
    }

    public static void e0(View view, Runnable runnable, long j) {
        final int i = 16;
        if (Build.VERSION.SDK_INT >= i) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    private static void f(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            u.F0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                u.F0(parent);
            }
        }
    }

    public static void f0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            u.g0(i, view);
            i = 0;
            u.V(view, i);
        }
    }

    public static d0 g(View view, d0 d0Var, Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return u.g.b(view, d0Var, rect);
        }
        return d0Var;
    }

    private static void g0(int i, View view) {
        int i2 = 0;
        final List list = u.q(view);
        i2 = 0;
        while (i2 < list.size()) {
            if ((c.a)list.get(i2).b() == i) {
                list.remove(i2);
            }
        }
    }

    public static d0 h(View view, d0 d0Var) {
        int i = 21;
        if (Build.VERSION.SDK_INT >= 21 && windowInsets != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return d0.w(dispatchApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    public static void h0(View view, c.a aVar, java.lang.CharSequence charSequence, f fVar) {
        if (fVar != null || charSequence != null) {
            u.c(view, aVar.a(charSequence, fVar));
        } else {
            u.f0(view, aVar.b());
        }
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return u.k.a(view).b(view, keyEvent);
    }

    public static void i0(View view) {
        final int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 20;
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            i = 16;
            if (Build.VERSION.SDK_INT >= 16) {
                view.requestFitSystemWindows();
            }
        }
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return u.k.a(view).f(keyEvent);
    }

    public static void j0(View view, Context context, int[] iArr, AttributeSet set, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            u.i.a(view, context, iArr, set, typedArray, i, i2);
        }
    }

    public static int k() {
        int i2 = 1;
        int i = 17;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        AtomicInteger atomicInteger = u.a;
        i = atomicInteger.get();
        i2 = i + 1;
        int i3 = 16777215;
        do {
            atomicInteger = u.a;
            i = u.a.get();
            i2 = i + 1;
            i3 = 16777215;
            if (u.a.compareAndSet(i, i2)) {
                return i;
            }
            i2 = 1;
        } while (i + 1 > 16777215);
        return i;
    }

    private static u.f<Boolean> k0() {
        return new u.a(c.M, Boolean.class, 28);
    }

    public static a l(View view) {
        View.AccessibilityDelegate accessibilityDelegate = u.m(view);
        if (accessibilityDelegate == null) {
            return null;
        }
        if (accessibilityDelegate instanceof a.a) {
            return accessibilityDelegate.a;
        }
        return new a(accessibilityDelegate);
    }

    public static void l0(View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate = null;
        if (aVar == null && u.m(view) instanceof a.a) {
            aVar = new a();
        }
        if (aVar == null) {
            int i = 0;
        } else {
            accessibilityDelegate = aVar.d();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    private static View.AccessibilityDelegate m(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return u.n(view);
    }

    public static void m0(View view, boolean z) {
        u.a().g(view, Boolean.valueOf(z));
    }

    private static View.AccessibilityDelegate n(View view) {
        final int i = 0;
        if (u.i) {
            return null;
        }
        if (u.h == null) {
            try {
                str = "mAccessibilityDelegate";
                Field declaredField = View.class.getDeclaredField(str);
                u.h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                u.i = z3;
                return obj2;
            }
        }
        try {
            final Object obj3 = u.h.get(view);
        } catch (Throwable unused) {
            u.i = z3;
            return obj2;
        }
        return i;
    }

    public static void n0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void o0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static java.lang.CharSequence p(View view) {
        return (CharSequence)u.a0().f(view);
    }

    public static void p0(View view, ColorStateList list) {
        int i = 0;
        boolean stateful;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        final int i2 = 21;
        if (Build.VERSION.SDK_INT >= i2) {
            view.setBackgroundTintList(list);
            if (Build.VERSION.SDK_INT == i2) {
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null) {
                    i = 1;
                }
                if (background != null && Build.VERSION.SDK_INT != 0 && background.isStateful()) {
                    background.setState(view.getDrawableState());
                    view.setBackground(background);
                }
            }
        } else {
            stateful = view instanceof t;
            if (view instanceof t) {
                view.setSupportBackgroundTintList(list);
            }
        }
    }

    private static List<c.a> q(View view) {
        Object tag;
        final int i = c.H;
        if ((ArrayList)view.getTag(i) == null) {
            view.setTag(c.H, new ArrayList());
        }
        return tag;
    }

    public static void q0(View view, PorterDuff.Mode mode) {
        int i = 0;
        boolean stateful;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        final int i2 = 21;
        if (Build.VERSION.SDK_INT >= i2) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == i2) {
                Drawable background = view.getBackground();
                if (view.getBackgroundTintList() != null || view.getBackgroundTintMode() != null) {
                    i = 1;
                }
                if (background != null && Build.VERSION.SDK_INT != 0 && background.isStateful()) {
                    background.setState(view.getDrawableState());
                    view.setBackground(background);
                }
            }
        } else {
            stateful = view instanceof t;
            if (view instanceof t) {
                view.setSupportBackgroundTintMode(mode);
            }
        }
    }

    private static int r(View view, java.lang.CharSequence charSequence) {
        int size;
        int charSequence22;
        List list = u.q(view);
        size = 0;
        while (size < list.size()) {
            if (TextUtils.equals(charSequence, (c.a)list.get(size).c())) {
                return (c.a)list.get(size).b();
            }
        }
        charSequence22 = -1;
        int[] iArr = u.k;
        while (size < iArr.length) {
        }
        return charSequence22;
    }

    public static void r0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static ColorStateList s(View view) {
        ColorStateList supportBackgroundTintList = null;
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            supportBackgroundTintList = view.getSupportBackgroundTintList();
        } else {
            int i2 = 0;
        }
        return supportBackgroundTintList;
    }

    public static void s0(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static PorterDuff.Mode t(View view) {
        PorterDuff.Mode supportBackgroundTintMode = null;
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            supportBackgroundTintMode = view.getSupportBackgroundTintMode();
        } else {
            int i2 = 0;
        }
        return supportBackgroundTintMode;
    }

    @Deprecated
    public static void t0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static void u0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static Display v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (u.Q(view)) {
            return (WindowManager)view.getContext().getSystemService("window").getDefaultDisplay();
        }
        return null;
    }

    public static void v0(View view, int i) {
        int i3 = 2;
        sDK_INT2 = Build.VERSION.SDK_INT;
        i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i);
        } else {
            i = 16;
            if (Build.VERSION.SDK_INT >= 16 && i == 4) {
                i3 = 2;
                view.setImportantForAccessibility(i3);
            }
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0;
    }

    public static void w0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    private static Rect x() {
        Object obj;
        if (u.j == null) {
            u.j = new ThreadLocal();
        }
        if ((Rect)u.j.get() == null) {
            u.j.set(new Rect());
        }
        obj.setEmpty();
        return obj;
    }

    public static void x0(View view, q qVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            u.g.d(view, qVar);
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void y0(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void z0(View view, s sVar) {
        android.view.PointerIcon pointerIcon = null;
        if (Build.VERSION.SDK_INT >= 24 && sVar != null) {
            Object obj = sVar.a();
            view.setPointerIcon((PointerIcon)pointerIcon);
        }
    }
}
