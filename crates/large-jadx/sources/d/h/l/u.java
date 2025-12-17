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
import d.h.c;
import d.h.l.e0.c;
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

/* loaded from: classes.dex */
public class u {

    private static final AtomicInteger a;
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static WeakHashMap<View, d.h.l.z> g;
    private static Field h;
    private static boolean i;
    private static java.lang.ThreadLocal<Rect> j;
    private static final int[] k;

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        private WeakHashMap<View, Boolean> a;
        e() {
            super();
            WeakHashMap weakHashMap = new WeakHashMap();
            this.a = weakHashMap;
        }

        private void a(View view, boolean z2) {
            int valueOf;
            int obj3;
            valueOf = view.getVisibility() == 0 ? 1 : 0;
            if (z2 != valueOf) {
                obj3 = valueOf != 0 ? 16 : 32;
                u.V(view, obj3);
                this.a.put(view, Boolean.valueOf(valueOf));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            int sDK_INT;
            int booleanValue;
            Object key;
            if (Build.VERSION.SDK_INT < 28) {
                sDK_INT = this.a.entrySet().iterator();
                for (Map.Entry next : sDK_INT) {
                    a((View)next.getKey(), (Boolean)next.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        private final int a;
        private final Class<T> b;
        private final int c;
        private final int d;
        f(int i, Class<T> class2, int i3) {
            super(i, class2, 0, i3);
        }

        f(int i, Class<T> class2, int i3, int i4) {
            super();
            this.a = i;
            this.b = class2;
            this.d = i3;
            this.c = i4;
        }

        private boolean b() {
            int i;
            i = Build.VERSION.SDK_INT >= 19 ? 1 : 0;
            return i;
        }

        private boolean c() {
            int i;
            i = Build.VERSION.SDK_INT >= this.c ? 1 : 0;
            return i;
        }

        boolean a(Boolean boolean, Boolean boolean2) {
            int i;
            boolean obj2;
            boolean obj3;
            i = 0;
            if (boolean == null) {
                obj2 = i;
            } else {
                obj2 = boolean.booleanValue();
            }
            if (boolean2 == null) {
                obj3 = i;
            } else {
                obj3 = boolean2.booleanValue();
            }
            if (obj2 == obj3) {
                i = 1;
            }
            return i;
        }

        abstract T d(View view);

        abstract void e(View view, T t2);

        T f(View view) {
            boolean instance;
            Object obj2;
            if (c()) {
                return d(view);
            }
            obj2 = view.getTag(this.a);
            if (b() && this.b.isInstance(obj2)) {
                obj2 = view.getTag(this.a);
                if (this.b.isInstance(obj2)) {
                    return obj2;
                }
            }
            return 0;
        }

        void g(View view, T t2) {
            boolean z;
            Object obj3;
            if (c()) {
                e(view, t2);
            } else {
                if (b() && h(f(view), t2)) {
                    if (h(f(view), t2)) {
                        u.E(view);
                        view.setTag(this.a, t2);
                        u.V(view, this.d);
                    }
                }
            }
        }

        abstract boolean h(T t, T t2);
    }

    private static class g {
        static void a(WindowInsets windowInsets, View view2) {
            Object tag = view2.getTag(c.R);
            if ((View.OnApplyWindowInsetsListener)tag != null) {
                (View.OnApplyWindowInsetsListener)tag.onApplyWindowInsets(view2, windowInsets);
            }
        }

        static d.h.l.d0 b(View view, d.h.l.d0 d02, Rect rect3) {
            final WindowInsets windowInsets = d02.u();
            if (windowInsets != null) {
                return d0.w(view.computeSystemWindowInsets(windowInsets, rect3), view);
            }
            rect3.setEmpty();
            return d02;
        }

        public static d.h.l.d0 c(View view) {
            return d0.a.a(view);
        }

        static void d(View view, d.h.l.q q2) {
            int sDK_INT;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(c.L, q2);
            }
            if (q2 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)view.getTag(c.R));
            }
            u.g.a aVar = new u.g.a(view, q2);
            view.setOnApplyWindowInsetsListener(aVar);
        }
    }

    private static class h {
        public static d.h.l.d0 a(View view) {
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
        static void a(View view, Context context2, int[] i3Arr3, AttributeSet attributeSet4, TypedArray typedArray5, int i6, int i7) {
            view.saveAttributeDataForStyleable(context2, i3Arr3, attributeSet4, typedArray5, i6, i7);
        }
    }

    public interface j {
        public abstract boolean a(View view, KeyEvent keyEvent2);
    }

    static class k {

        private static final ArrayList<WeakReference<View>> d;
        private WeakHashMap<View, Boolean> a = null;
        private SparseArray<WeakReference<View>> b = null;
        private WeakReference<KeyEvent> c = null;
        static {
            ArrayList arrayList = new ArrayList();
            u.k.d = arrayList;
        }

        k() {
            super();
            final int i = 0;
        }

        static d.h.l.u.k a(View view) {
            Object kVar;
            final int i = c.P;
            if ((u.k)view.getTag(i) == null) {
                kVar = new u.k();
                view.setTag(i, kVar);
            }
            return kVar;
        }

        private View c(View view, KeyEvent keyEvent2) {
            WeakHashMap key;
            int i;
            View view2;
            KeyEvent obj6;
            key = this.a;
            if (key != null) {
                if (!key.containsKey(view)) {
                } else {
                    if (view instanceof ViewGroup) {
                        key = view;
                        childCount--;
                        while (i >= 0) {
                            view2 = c(key.getChildAt(i), keyEvent2);
                            i--;
                        }
                    }
                    if (e(view, keyEvent2)) {
                        return view;
                    }
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            SparseArray sparseArray;
            if (this.b == null) {
                sparseArray = new SparseArray();
                this.b = sparseArray;
            }
            return this.b;
        }

        private boolean e(View view, KeyEvent keyEvent2) {
            int i2;
            int i;
            boolean z;
            Object tag = view.getTag(c.Q);
            if ((ArrayList)tag != null) {
                i = 1;
                size -= i;
                while (i2 >= 0) {
                    i2--;
                }
            }
            return 0;
        }

        private void g() {
            WeakHashMap weakHashMap;
            int i;
            ArrayList parent;
            Object obj;
            Boolean tRUE;
            Boolean tRUE2;
            WeakHashMap map = this.a;
            if (map != null) {
                map.clear();
            }
            ArrayList list = u.k.d;
            if (list.isEmpty()) {
            }
            synchronized (list) {
                weakHashMap = new WeakHashMap();
                this.a = weakHashMap;
                size--;
                while (i >= 0) {
                    parent = u.k.d;
                    obj = (WeakReference)parent.get(i).get();
                    if ((View)obj == null) {
                    } else {
                    }
                    this.a.put((View)obj, Boolean.TRUE);
                    parent = obj.getParent();
                    while (parent instanceof View != null) {
                        this.a.put((View)parent, Boolean.TRUE);
                        parent = parent.getParent();
                    }
                    i--;
                    this.a.put((View)parent, Boolean.TRUE);
                    parent = parent.getParent();
                    parent.remove(i);
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent2) {
            int modifierKey;
            WeakReference weakReference;
            int obj3;
            KeyEvent obj4;
            if (keyEvent2.getAction() == 0) {
                g();
            }
            obj3 = c(view, keyEvent2);
            obj4 = keyEvent2.getKeyCode();
            if (keyEvent2.getAction() == 0 && obj3 != null && !KeyEvent.isModifierKey(obj4)) {
                obj4 = keyEvent2.getKeyCode();
                if (obj3 != null) {
                    if (!KeyEvent.isModifierKey(obj4)) {
                        weakReference = new WeakReference(obj3);
                        d().put(obj4, weakReference);
                    }
                }
            }
            obj3 = obj3 != null ? 1 : 0;
            return obj3;
        }

        boolean f(KeyEvent keyEvent) {
            Object weakReference;
            int valueAt;
            int i;
            int indexOfKey;
            weakReference = this.c;
            i = 0;
            if (weakReference != null && weakReference.get() == keyEvent) {
                if (weakReference.get() == keyEvent) {
                    return i;
                }
            }
            WeakReference weakReference2 = new WeakReference(keyEvent);
            this.c = weakReference2;
            valueAt = 0;
            final SparseArray sparseArray = d();
            final int i2 = 1;
            indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode());
            if (keyEvent.getAction() == i2 && indexOfKey >= 0) {
                indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    valueAt = sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
            }
            if (valueAt == 0) {
                valueAt = sparseArray.get(keyEvent.getKeyCode());
            }
            Object obj = valueAt.get();
            if (valueAt != 0 && obj != null && u.Q((View)obj)) {
                obj = valueAt.get();
                if ((View)obj != null) {
                    if (u.Q((View)obj)) {
                        e(obj, keyEvent);
                    }
                }
                return i2;
            }
            return i;
        }
    }

    class a extends d.h.l.u.f<Boolean> {
        a(int i, Class class2, int i3) {
            super(i, class2, i3);
        }

        @Override // d.h.l.u$f
        Object d(View view) {
            return i(view);
        }

        @Override // d.h.l.u$f
        void e(View view, Object object2) {
            j(view, (Boolean)object2);
        }

        @Override // d.h.l.u$f
        boolean h(Object object, Object object2) {
            return k((Boolean)object, (Boolean)object2);
        }

        @Override // d.h.l.u$f
        Boolean i(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // d.h.l.u$f
        void j(View view, Boolean boolean2) {
            view.setScreenReaderFocusable(boolean2.booleanValue());
        }

        @Override // d.h.l.u$f
        boolean k(Boolean boolean, Boolean boolean2) {
            return obj1 ^= 1;
        }
    }

    class b extends d.h.l.u.f<java.lang.CharSequence> {
        b(int i, Class class2, int i3, int i4) {
            super(i, class2, i3, i4);
        }

        @Override // d.h.l.u$f
        Object d(View view) {
            return i(view);
        }

        @Override // d.h.l.u$f
        void e(View view, Object object2) {
            j(view, (CharSequence)object2);
        }

        @Override // d.h.l.u$f
        boolean h(Object object, Object object2) {
            return k((CharSequence)object, (CharSequence)object2);
        }

        @Override // d.h.l.u$f
        java.lang.CharSequence i(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // d.h.l.u$f
        void j(View view, java.lang.CharSequence charSequence2) {
            view.setAccessibilityPaneTitle(charSequence2);
        }

        @Override // d.h.l.u$f
        boolean k(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return obj1 ^= 1;
        }
    }

    class c extends d.h.l.u.f<java.lang.CharSequence> {
        c(int i, Class class2, int i3, int i4) {
            super(i, class2, i3, i4);
        }

        @Override // d.h.l.u$f
        Object d(View view) {
            return i(view);
        }

        @Override // d.h.l.u$f
        void e(View view, Object object2) {
            j(view, (CharSequence)object2);
        }

        @Override // d.h.l.u$f
        boolean h(Object object, Object object2) {
            return k((CharSequence)object, (CharSequence)object2);
        }

        @Override // d.h.l.u$f
        java.lang.CharSequence i(View view) {
            return view.getStateDescription();
        }

        @Override // d.h.l.u$f
        void j(View view, java.lang.CharSequence charSequence2) {
            view.setStateDescription(charSequence2);
        }

        @Override // d.h.l.u$f
        boolean k(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return obj1 ^= 1;
        }
    }

    class d extends d.h.l.u.f<Boolean> {
        d(int i, Class class2, int i3) {
            super(i, class2, i3);
        }

        @Override // d.h.l.u$f
        Object d(View view) {
            return i(view);
        }

        @Override // d.h.l.u$f
        void e(View view, Object object2) {
            j(view, (Boolean)object2);
        }

        @Override // d.h.l.u$f
        boolean h(Object object, Object object2) {
            return k((Boolean)object, (Boolean)object2);
        }

        @Override // d.h.l.u$f
        Boolean i(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // d.h.l.u$f
        void j(View view, Boolean boolean2) {
            view.setAccessibilityHeading(boolean2.booleanValue());
        }

        @Override // d.h.l.u$f
        boolean k(Boolean boolean, Boolean boolean2) {
            return obj1 ^= 1;
        }
    }
    static {
        int i34 = 1;
        AtomicInteger atomicInteger = new AtomicInteger(i34);
        u.a = atomicInteger;
        u.g = 0;
        int i2 = 0;
        u.i = i2;
        int[] iArr = new int[32];
        iArr[i2] = c.b;
        iArr[i34] = c.c;
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
        u.e eVar = new u.e();
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void A0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void B0(View view, String string2) {
        int sDK_INT;
        WeakHashMap weakHashMap;
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(string2);
        } else {
            if (u.f == null) {
                weakHashMap = new WeakHashMap();
                u.f = weakHashMap;
            }
            u.f.put(view, string2);
        }
    }

    public static int C(View view) {
        boolean z;
        int declaredField;
        String str;
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!u.e) {
            z = 1;
            declaredField = View.class.getDeclaredField("mMinHeight");
            u.d = declaredField;
            declaredField.setAccessible(z);
            u.e = z;
        }
        Field field = u.d;
        if (field != null) {
            return (Integer)field.get(view).intValue();
        }
        return 0;
    }

    private static void C0(View view) {
        int i3;
        ViewParent parent;
        int i2;
        int i;
        if (u.z(view) == 0) {
            u.v0(view, 1);
        }
        parent = view.getParent();
        while (parent instanceof View != null) {
            if (u.z((View)parent) == 4) {
                break;
            } else {
            }
            parent = parent.getParent();
        }
    }

    public static int D(View view) {
        boolean z;
        int declaredField;
        String str;
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!u.c) {
            z = 1;
            declaredField = View.class.getDeclaredField("mMinWidth");
            u.b = declaredField;
            declaredField.setAccessible(z);
            u.c = z;
        }
        Field field = u.b;
        if (field != null) {
            return (Integer)field.get(view).intValue();
        }
        return 0;
    }

    private static d.h.l.u.f<java.lang.CharSequence> D0() {
        u.c cVar = new u.c(c.N, CharSequence.class, 64, 30);
        return cVar;
    }

    static d.h.l.a E(View view) {
        d.h.l.a aVar;
        if (u.l(view) == null) {
            aVar = new a();
        }
        u.l0(view, aVar);
        return aVar;
    }

    public static void E0(View view) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else {
            if (view instanceof k) {
                (k)view.stopNestedScroll();
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
        view.setTranslationY(i += translationY);
        view.setTranslationY(translationY);
    }

    public static int G(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static d.h.l.d0 H(View view) {
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            return u.h.a(view);
        }
        if (sDK_INT >= 21) {
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
        WeakHashMap map = u.f;
        if (map == null) {
            return null;
        }
        return (String)map.get(view);
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
        return 0;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return 1;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return 0;
    }

    public static boolean P(View view) {
        int obj1;
        obj1 = u.a().f(view);
        if ((Boolean)obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = (Boolean)obj1.booleanValue();
        }
        return obj1;
    }

    public static boolean Q(View view) {
        int obj2;
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        obj2 = view.getWindowToken() != null ? 1 : 0;
        return obj2;
    }

    public static boolean R(View view) {
        int obj2;
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            obj2 = view.getHeight() > 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof k) {
            return (k)view.isNestedScrollingEnabled();
        }
        return 0;
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return 0;
    }

    public static boolean U(View view) {
        int obj1;
        obj1 = u.k0().f(view);
        if ((Boolean)obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = (Boolean)obj1.booleanValue();
        }
        return obj1;
    }

    static void V(View view, int i2) {
        Object systemService;
        int obtain;
        java.lang.CharSequence visibility;
        int i;
        Object obj4;
        int obj5;
        systemService = view.getContext().getSystemService("accessibility");
        if (!(AccessibilityManager)systemService.isEnabled()) {
        }
        if (u.p(view) != null && view.getVisibility() == 0) {
            obtain = view.getVisibility() == 0 ? 1 : 0;
        } else {
        }
        i = 32;
        if (u.o(view) == 0) {
            if (obtain != 0) {
                systemService = AccessibilityEvent.obtain();
                if (obtain != 0) {
                } else {
                    i = 2048;
                }
                systemService.setEventType(i);
                systemService.setContentChangeTypes(i2);
                if (obtain != 0) {
                    systemService.getText().add(u.p(view));
                    u.C0(view);
                }
                view.sendAccessibilityEventUnchecked(systemService);
            } else {
                if (i2 == i) {
                    obtain = AccessibilityEvent.obtain();
                    view.onInitializeAccessibilityEvent(obtain);
                    obtain.setEventType(i);
                    obtain.setContentChangeTypes(i2);
                    obtain.setSource(view);
                    view.onPopulateAccessibilityEvent(obtain);
                    obtain.getText().add(u.p(view));
                    systemService.sendAccessibilityEvent(obtain);
                } else {
                    if (view.getParent() != null) {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                    }
                }
            }
        } else {
        }
    }

    public static void W(View view, int i2) {
        Rect sDK_INT;
        int top;
        ViewParent parent;
        boolean right2;
        int right;
        int bottom;
        View obj6;
        int obj7;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else {
            if (sDK_INT >= 21) {
                sDK_INT = u.x();
                top = 0;
                parent = view.getParent();
                if (parent instanceof View != null) {
                    ViewParent view2 = parent;
                    sDK_INT.set((View)view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                    intersects ^= 1;
                }
                u.e(view, i2);
                if (top != 0 && sDK_INT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    if (sDK_INT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                        (View)parent.invalidate(sDK_INT);
                    }
                }
            } else {
                u.e(view, i2);
            }
        }
    }

    public static void X(View view, int i2) {
        Rect sDK_INT;
        int top;
        ViewParent parent;
        boolean right;
        int right2;
        int bottom;
        View obj6;
        int obj7;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else {
            if (sDK_INT >= 21) {
                sDK_INT = u.x();
                top = 0;
                parent = view.getParent();
                if (parent instanceof View != null) {
                    ViewParent view2 = parent;
                    sDK_INT.set((View)view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                    intersects ^= 1;
                }
                u.f(view, i2);
                if (top != 0 && sDK_INT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    if (sDK_INT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                        (View)parent.invalidate(sDK_INT);
                    }
                }
            } else {
                u.f(view, i2);
            }
        }
    }

    public static d.h.l.d0 Y(View view, d.h.l.d0 d02) {
        int sDK_INT;
        int onApplyWindowInsets;
        sDK_INT = d02.u();
        onApplyWindowInsets = view.onApplyWindowInsets(sDK_INT);
        if (Build.VERSION.SDK_INT >= 21 && sDK_INT != null && !onApplyWindowInsets.equals(sDK_INT)) {
            sDK_INT = d02.u();
            if (sDK_INT != null) {
                onApplyWindowInsets = view.onApplyWindowInsets(sDK_INT);
                if (!onApplyWindowInsets.equals(sDK_INT)) {
                    return d0.w(onApplyWindowInsets, view);
                }
            }
        }
        return d02;
    }

    public static void Z(View view, c c2) {
        view.onInitializeAccessibilityNodeInfo(c2.x0());
    }

    private static d.h.l.u.f<Boolean> a() {
        u.d dVar = new u.d(c.J, Boolean.class, 28);
        return dVar;
    }

    private static d.h.l.u.f<java.lang.CharSequence> a0() {
        u.b bVar = new u.b(c.K, CharSequence.class, 8, 28);
        return bVar;
    }

    public static int b(View view, java.lang.CharSequence charSequence2, f f3) {
        int aVar;
        final int i = u.r(view, charSequence2);
        if (i != -1) {
            aVar = new c.a(i, charSequence2, f3);
            u.c(view, aVar);
        }
        return i;
    }

    public static boolean b0(View view, int i2, Bundle bundle3) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle3);
        }
        return 0;
    }

    private static void c(View view, c.a c$a2) {
        int sDK_INT;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 21) {
            u.E(view);
            u.g0(a2.b(), view);
            u.q(view).add(a2);
            u.V(view, 0);
        }
    }

    public static void c0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static d.h.l.z d(View view) {
        WeakHashMap weakHashMap;
        Object zVar;
        WeakHashMap map;
        if (u.g == null) {
            weakHashMap = new WeakHashMap();
            u.g = weakHashMap;
        }
        if ((z)u.g.get(view) == null) {
            zVar = new z(view);
            u.g.put(view, zVar);
        }
        return zVar;
    }

    public static void d0(View view, Runnable runnable2) {
        int frameDelay;
        final int i = 16;
        if (Build.VERSION.SDK_INT >= i) {
            view.postOnAnimation(runnable2);
        } else {
            view.postDelayed(runnable2, ValueAnimator.getFrameDelay());
        }
    }

    private static void e(View view, int i2) {
        Object obj0;
        int obj1;
        view.offsetLeftAndRight(i2);
        u.F0(view);
        obj0 = view.getParent();
        if (view.getVisibility() == 0 && obj0 instanceof View != null) {
            u.F0(view);
            obj0 = view.getParent();
            if (obj0 instanceof View != null) {
                u.F0((View)obj0);
            }
        }
    }

    public static void e0(View view, Runnable runnable2, long l3) {
        int sDK_INT;
        final int i = 16;
        if (Build.VERSION.SDK_INT >= i) {
            view.postOnAnimationDelayed(runnable2, l3);
        } else {
            view.postDelayed(runnable2, frameDelay += l3);
        }
    }

    private static void f(View view, int i2) {
        Object obj0;
        int obj1;
        view.offsetTopAndBottom(i2);
        u.F0(view);
        obj0 = view.getParent();
        if (view.getVisibility() == 0 && obj0 instanceof View != null) {
            u.F0(view);
            obj0 = view.getParent();
            if (obj0 instanceof View != null) {
                u.F0((View)obj0);
            }
        }
    }

    public static void f0(View view, int i2) {
        int obj3;
        if (Build.VERSION.SDK_INT >= 21) {
            u.g0(i2, view);
            u.V(view, 0);
        }
    }

    public static d.h.l.d0 g(View view, d.h.l.d0 d02, Rect rect3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return u.g.b(view, d02, rect3);
        }
        return d02;
    }

    private static void g0(int i, View view2) {
        int i2;
        int size;
        final List obj3 = u.q(view2);
        i2 = 0;
        while (i2 < obj3.size()) {
            if ((c.a)obj3.get(i2).b() == i) {
                break;
            } else {
            }
            i2++;
        }
    }

    public static d.h.l.d0 h(View view, d.h.l.d0 d02) {
        int sDK_INT;
        int dispatchApplyWindowInsets;
        sDK_INT = d02.u();
        dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(sDK_INT);
        if (Build.VERSION.SDK_INT >= 21 && sDK_INT != null && !dispatchApplyWindowInsets.equals(sDK_INT)) {
            sDK_INT = d02.u();
            if (sDK_INT != null) {
                dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(sDK_INT);
                if (!dispatchApplyWindowInsets.equals(sDK_INT)) {
                    return d0.w(dispatchApplyWindowInsets, view);
                }
            }
        }
        return d02;
    }

    public static void h0(View view, c.a c$a2, java.lang.CharSequence charSequence3, f f4) {
        c.a obj1;
        if (f4 == null && charSequence3 == null) {
            if (charSequence3 == null) {
                u.f0(view, a2.b());
            } else {
                u.c(view, a2.a(charSequence3, f4));
            }
        } else {
        }
    }

    static boolean i(View view, KeyEvent keyEvent2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return 0;
        }
        return u.k.a(view).b(view, keyEvent2);
    }

    public static void i0(View view) {
        int i;
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            if (sDK_INT >= 16) {
                view.requestFitSystemWindows();
            }
        }
    }

    static boolean j(View view, KeyEvent keyEvent2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return 0;
        }
        return u.k.a(view).f(keyEvent2);
    }

    public static void j0(View view, Context context2, int[] i3Arr3, AttributeSet attributeSet4, TypedArray typedArray5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            u.i.a(view, context2, i3Arr3, attributeSet4, typedArray5, i6, i7);
        }
    }

    public static int k() {
        int compareAndSet;
        int i;
        int i3;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        AtomicInteger num = u.a;
        i = num.get();
        do {
            num = u.a;
            i = num.get();
            if (num.compareAndSet(i, i3) == 0) {
            }
            i3 = 1;
        } while (i + 1 > 16777215);
        return i;
    }

    private static d.h.l.u.f<Boolean> k0() {
        u.a aVar = new u.a(c.M, Boolean.class, 28);
        return aVar;
    }

    public static d.h.l.a l(View view) {
        View.AccessibilityDelegate obj1 = u.m(view);
        if (obj1 == null) {
            return null;
        }
        if (obj1 instanceof a.a) {
            return obj1.a;
        }
        a aVar = new a((a.a)obj1);
        return aVar;
    }

    public static void l0(View view, d.h.l.a a2) {
        boolean z;
        d.h.l.a obj2;
        if (a2 == null && view2 instanceof a.a) {
            if (view2 instanceof a.a) {
                obj2 = new a();
            }
        }
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.d();
        }
        view.setAccessibilityDelegate(obj2);
    }

    private static View.AccessibilityDelegate m(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return u.n(view);
    }

    public static void m0(View view, boolean z2) {
        u.a().g(view, Boolean.valueOf(z2));
    }

    private static View.AccessibilityDelegate n(View view) {
        Field declaredField;
        String str;
        final int i = 0;
        if (u.i) {
            return i;
        }
        if (u.h == null) {
            declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
            u.h = declaredField;
            declaredField.setAccessible(true);
        }
        final Object obj4 = u.h.get(view);
        if (obj4 instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate)obj4;
        }
        return i;
    }

    public static void n0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void o0(View view, Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable2);
        } else {
            view.setBackgroundDrawable(drawable2);
        }
    }

    public static java.lang.CharSequence p(View view) {
        return (CharSequence)u.a0().f(view);
    }

    public static void p0(View view, ColorStateList colorStateList2) {
        boolean drawableState;
        Object backgroundTintList;
        Object obj3;
        drawableState = Build.VERSION.SDK_INT;
        final int i = 21;
        if (drawableState >= i) {
            view.setBackgroundTintList(colorStateList2);
            if (drawableState == i) {
                obj3 = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() != null) {
                        drawableState = 1;
                    } else {
                        drawableState = 0;
                    }
                } else {
                }
                if (obj3 != null && drawableState != 0 && obj3.isStateful()) {
                    if (drawableState != 0) {
                        if (obj3.isStateful()) {
                            obj3.setState(view.getDrawableState());
                        }
                        view.setBackground(obj3);
                    }
                }
            }
        } else {
            if (view instanceof t) {
                (t)view.setSupportBackgroundTintList(colorStateList2);
            }
        }
    }

    private static List<c.a> q(View view) {
        Object arrayList;
        final int i = c.H;
        if ((ArrayList)view.getTag(i) == null) {
            arrayList = new ArrayList();
            view.setTag(i, arrayList);
        }
        return arrayList;
    }

    public static void q0(View view, PorterDuff.Mode porterDuff$Mode2) {
        boolean drawableState;
        Object backgroundTintList;
        Object obj3;
        drawableState = Build.VERSION.SDK_INT;
        final int i = 21;
        if (drawableState >= i) {
            view.setBackgroundTintMode(mode2);
            if (drawableState == i) {
                obj3 = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() != null) {
                        drawableState = 1;
                    } else {
                        drawableState = 0;
                    }
                } else {
                }
                if (obj3 != null && drawableState != 0 && obj3.isStateful()) {
                    if (drawableState != 0) {
                        if (obj3.isStateful()) {
                            obj3.setState(view.getDrawableState());
                        }
                        view.setBackground(obj3);
                    }
                }
            }
        } else {
            if (view instanceof t) {
                (t)view.setSupportBackgroundTintMode(mode2);
            }
        }
    }

    private static int r(View view, java.lang.CharSequence charSequence2) {
        int i;
        int i6;
        boolean equals;
        int i5;
        int i7;
        int i3;
        int i2;
        int i4;
        int size;
        List obj8 = u.q(view);
        final int i8 = 0;
        i = i8;
        while (i < obj8.size()) {
            i++;
        }
        final int obj9 = -1;
        i5 = obj9;
        i6 = i8;
        int[] iArr = u.k;
        for (int i7 : obj3) {
            if (i5 == obj9) {
            }
            i3 = 1;
            i2 = i8;
            i4 = i3;
            while (i2 < obj8.size()) {
                if ((c.a)obj8.get(i2).b() != i7) {
                } else {
                }
                size = i8;
                i4 &= size;
                i2++;
                size = i3;
            }
            if (i4 != 0) {
            }
            iArr = u.k;
            i5 = i7;
            if ((c.a)obj8.get(i2).b() != i7) {
            } else {
            }
            size = i8;
            i4 &= size;
            i2++;
            size = i3;
        }
        return i5;
    }

    public static void r0(View view, Rect rect2) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect2);
        }
    }

    public static ColorStateList s(View view) {
        ColorStateList obj2;
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            obj2 = (t)view.getSupportBackgroundTintList();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static void s0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static PorterDuff.Mode t(View view) {
        PorterDuff.Mode obj2;
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            obj2 = (t)view.getSupportBackgroundTintMode();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Deprecated
    public static void t0(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static void u0(View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z2);
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

    public static void v0(View view, int i2) {
        int sDK_INT;
        int i;
        int obj3;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else {
            if (sDK_INT >= 16 && i2 == 4) {
                if (i2 == 4) {
                    obj3 = 2;
                }
                view.setImportantForAccessibility(obj3);
            }
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0;
    }

    public static void w0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    private static Rect x() {
        java.lang.ThreadLocal threadLocal;
        Object rect;
        java.lang.ThreadLocal threadLocal2;
        if (u.j == null) {
            threadLocal = new ThreadLocal();
            u.j = threadLocal;
        }
        if ((Rect)u.j.get() == null) {
            rect = new Rect();
            u.j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, d.h.l.q q2) {
        if (Build.VERSION.SDK_INT >= 21) {
            u.g.d(view, q2);
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return 0;
    }

    public static void y0(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void z0(View view, d.h.l.s s2) {
        int obj3;
        if (Build.VERSION.SDK_INT >= 24) {
            if (s2 != null) {
                obj3 = s2.a();
            } else {
                obj3 = 0;
            }
            view.setPointerIcon((PointerIcon)obj3);
        }
    }
}
