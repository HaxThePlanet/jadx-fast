package d.h.l.e0;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import androidx.core.os.a;
import d.h.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    private static int d;
    private final AccessibilityNodeInfo a;
    public int b = -1;
    private int c = -1;

    public static class a {

        public static final d.h.l.e0.c.a e;
        public static final d.h.l.e0.c.a f;
        public static final d.h.l.e0.c.a g;
        public static final d.h.l.e0.c.a h;
        public static final d.h.l.e0.c.a i;
        public static final d.h.l.e0.c.a j;
        public static final d.h.l.e0.c.a k;
        public static final d.h.l.e0.c.a l;
        final Object a;
        private final int b;
        private final Class<? extends d.h.l.e0.f.a> c;
        protected final d.h.l.e0.f d;
        static {
            AccessibilityNodeInfo.AccessibilityAction aCTION_CONTEXT_CLICK;
            AccessibilityNodeInfo.AccessibilityAction aCTION_SET_PROGRESS;
            AccessibilityNodeInfo.AccessibilityAction aCTION_MOVE_WINDOW;
            int aCTION_HIDE_TOOLTIP;
            int aCTION_SCROLL_TO_POSITION;
            Object aCTION_SCROLL_LEFT;
            Object aCTION_SCROLL_RIGHT;
            AccessibilityNodeInfo.AccessibilityAction aCTION_PRESS_AND_HOLD;
            int aCTION_SCROLL_DOWN;
            int aCTION_IME_ENTER;
            int i5;
            int i;
            int i2;
            int i3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            int i6;
            int i7;
            int i8;
            int i4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            int i9;
            Class<d.h.l.e0.f.c> obj = f.c.class;
            Class<d.h.l.e0.f.b> obj2 = f.b.class;
            aCTION_IME_ENTER = 0;
            c.a aVar13 = new c.a(1, aCTION_IME_ENTER);
            c.a aVar14 = new c.a(2, aCTION_IME_ENTER);
            c.a aVar15 = new c.a(4, aCTION_IME_ENTER);
            c.a aVar16 = new c.a(8, aCTION_IME_ENTER);
            c.a aVar17 = new c.a(16, aCTION_IME_ENTER);
            c.a.e = aVar17;
            c.a aVar18 = new c.a(32, aCTION_IME_ENTER);
            c.a aVar19 = new c.a(64, aCTION_IME_ENTER);
            c.a aVar20 = new c.a(128, aCTION_IME_ENTER);
            c.a aVar21 = new c.a(256, aCTION_IME_ENTER, obj2);
            c.a aVar22 = new c.a(512, aCTION_IME_ENTER, obj2);
            c.a aVar11 = new c.a(1024, aCTION_IME_ENTER, obj);
            c.a aVar12 = new c.a(2048, aCTION_IME_ENTER, obj);
            c.a aVar = new c.a(4096, aCTION_IME_ENTER);
            c.a.f = aVar;
            c.a aVar2 = new c.a(8192, aCTION_IME_ENTER);
            c.a.g = aVar2;
            c.a aVar3 = new c.a(16384, aCTION_IME_ENTER);
            c.a aVar4 = new c.a(32768, aCTION_IME_ENTER);
            c.a aVar5 = new c.a(65536, aCTION_IME_ENTER);
            c.a aVar6 = new c.a(131072, aCTION_IME_ENTER, f.g.class);
            c.a aVar7 = new c.a(262144, aCTION_IME_ENTER);
            c.a.h = aVar7;
            c.a aVar8 = new c.a(524288, aCTION_IME_ENTER);
            c.a.i = aVar8;
            c.a aVar9 = new c.a(1048576, aCTION_IME_ENTER);
            c.a.j = aVar9;
            c.a aVar10 = new c.a(2097152, aCTION_IME_ENTER, f.h.class);
            int sDK_INT = Build.VERSION.SDK_INT;
            aCTION_CONTEXT_CLICK = 23;
            i5 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_TO_POSITION : aCTION_IME_ENTER;
            c.a aVar23 = new c.a(i5, 16908342, 0, 0, 0);
            i7 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_TO_POSITION : aCTION_IME_ENTER;
            c.a aVar32 = new c.a(i7, 16908343, 0, 0, f.e.class);
            i = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_DOWN : aCTION_IME_ENTER;
            super(i, 16908344, 0, 0, 0);
            c.a.k = aCTION_SCROLL_LEFT;
            i8 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_LEFT : aCTION_IME_ENTER;
            c.a aVar33 = new c.a(i8, 16908345, 0, 0, 0);
            i2 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_DOWN : aCTION_IME_ENTER;
            super(i2, 16908346, 0, 0, 0);
            c.a.l = aCTION_SCROLL_RIGHT;
            i4 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_SCROLL_RIGHT : aCTION_IME_ENTER;
            c.a aVar34 = new c.a(i4, 16908347, 0, 0, 0);
            aCTION_PRESS_AND_HOLD = 29;
            i3 = sDK_INT >= aCTION_PRESS_AND_HOLD ? aCTION_SCROLL_DOWN : aCTION_IME_ENTER;
            c.a aVar26 = new c.a(i3, 16908358, 0, 0, 0);
            accessibilityAction = sDK_INT >= aCTION_PRESS_AND_HOLD ? aCTION_SCROLL_DOWN : aCTION_IME_ENTER;
            c.a aVar35 = new c.a(accessibilityAction, 16908359, 0, 0, 0);
            accessibilityAction3 = sDK_INT >= aCTION_PRESS_AND_HOLD ? aCTION_SCROLL_DOWN : aCTION_IME_ENTER;
            c.a aVar27 = new c.a(accessibilityAction3, 16908360, 0, 0, 0);
            accessibilityAction2 = sDK_INT >= aCTION_PRESS_AND_HOLD ? aCTION_PRESS_AND_HOLD : aCTION_IME_ENTER;
            c.a aVar36 = new c.a(accessibilityAction2, 16908361, 0, 0, 0);
            accessibilityAction4 = sDK_INT >= aCTION_CONTEXT_CLICK ? aCTION_CONTEXT_CLICK : aCTION_IME_ENTER;
            c.a aVar28 = new c.a(accessibilityAction4, 16908348, 0, 0, 0);
            accessibilityAction7 = sDK_INT >= 24 ? aCTION_SET_PROGRESS : aCTION_IME_ENTER;
            c.a aVar37 = new c.a(accessibilityAction7, 16908349, 0, 0, f.f.class);
            accessibilityAction5 = sDK_INT >= 26 ? aCTION_MOVE_WINDOW : aCTION_IME_ENTER;
            c.a aVar29 = new c.a(accessibilityAction5, 16908354, 0, 0, f.d.class);
            aCTION_HIDE_TOOLTIP = 28;
            accessibilityAction6 = sDK_INT >= aCTION_HIDE_TOOLTIP ? aCTION_PRESS_AND_HOLD : aCTION_IME_ENTER;
            c.a aVar38 = new c.a(accessibilityAction6, 16908356, 0, 0, 0);
            i6 = sDK_INT >= aCTION_HIDE_TOOLTIP ? aCTION_HIDE_TOOLTIP : aCTION_IME_ENTER;
            c.a aVar30 = new c.a(i6, 16908357, 0, 0, 0);
            int i18 = 30;
            i9 = sDK_INT >= i18 ? aCTION_PRESS_AND_HOLD : aCTION_IME_ENTER;
            c.a aVar39 = new c.a(i9, 16908362, 0, 0, 0);
            if (sDK_INT >= i18) {
                aCTION_IME_ENTER = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            c.a aVar31 = new c.a(aCTION_IME_ENTER, 16908372, 0, 0, 0);
        }

        public a(int i, java.lang.CharSequence charSequence2) {
            super(0, i, charSequence2, 0, 0);
        }

        public a(int i, java.lang.CharSequence charSequence2, d.h.l.e0.f f3) {
            super(0, i, charSequence2, f3, 0);
        }

        private a(int i, java.lang.CharSequence charSequence2, Class<? extends d.h.l.e0.f.a> class3) {
            super(0, i, charSequence2, 0, class3);
        }

        a(Object object) {
            super(object, 0, 0, 0, 0);
        }

        a(Object object, int i2, java.lang.CharSequence charSequence3, d.h.l.e0.f f4, Class<? extends d.h.l.e0.f.a> class5) {
            Object obj2;
            super();
            this.b = i2;
            this.d = f4;
            if (Build.VERSION.SDK_INT >= 21 && object == null) {
                if (object == null) {
                    obj2 = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence3);
                    this.a = obj2;
                } else {
                    this.a = object;
                }
            } else {
            }
            this.c = class5;
        }

        public d.h.l.e0.c.a a(java.lang.CharSequence charSequence, d.h.l.e0.f f2) {
            super(0, this.b, charSequence, f2, this.c);
            return aVar2;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return (AccessibilityNodeInfo.AccessibilityAction)this.a.getId();
            }
            return 0;
        }

        public java.lang.CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return (AccessibilityNodeInfo.AccessibilityAction)this.a.getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle2) {
            int i;
            Class string;
            int instance;
            Object declaredConstructor;
            String str;
            instance = 0;
            i = 0;
            declaredConstructor = this.c;
            if (this.d != null && declaredConstructor != null) {
                i = 0;
                declaredConstructor = this.c;
                if (declaredConstructor != null) {
                    instance = declaredConstructor.getDeclaredConstructor(new Class[instance]).newInstance(new Object[instance]);
                    (f.a)instance.a(bundle2);
                    i = instance;
                }
                return this.d.a(view, i);
            }
            try {
                return instance;
            } catch (Exception e) {
            }
        }

        public boolean equals(Object object) {
            boolean obj3;
            final int i = 0;
            if (object == null) {
                return i;
            }
            if (!object instanceof c.a) {
                return i;
            }
            Object obj = this.a;
            if (obj == null) {
                if (object.a != null) {
                    return i;
                }
            } else {
                if (!obj.equals(object.a)) {
                    return i;
                }
            }
            return 1;
        }

        public int hashCode() {
            int i;
            Object obj = this.a;
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            return i;
        }
    }

    public static class b {

        final Object a;
        b(Object object) {
            super();
            this.a = object;
        }

        public static d.h.l.e0.c.b a(int i, int i2, boolean z3, int i4) {
            int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                c.b bVar = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z3, i4));
                return bVar;
            }
            if (sDK_INT >= 19) {
                c.b obj5 = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z3));
                return obj5;
            }
            c.b obj2 = new c.b(0);
            return obj2;
        }
    }

    public static class c {

        final Object a;
        c(Object object) {
            super();
            this.a = object;
        }

        public static d.h.l.e0.c.c a(int i, int i2, int i3, int i4, boolean z5, boolean z6) {
            int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                c.c cVar = new c.c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z5, z6));
                return cVar;
            }
            if (sDK_INT >= 19) {
                c.c obj7 = new c.c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z5));
                return obj7;
            }
            c.c obj2 = new c.c(0);
            return obj2;
        }
    }
    static {
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        super();
        final int i = -1;
        this.a = accessibilityNodeInfo;
    }

    public static d.h.l.e0.c K() {
        return c.y0(AccessibilityNodeInfo.obtain());
    }

    public static d.h.l.e0.c L(View view) {
        return c.y0(AccessibilityNodeInfo.obtain(view));
    }

    public static d.h.l.e0.c M(d.h.l.e0.c c) {
        return c.y0(AccessibilityNodeInfo.obtain(c.a));
    }

    private void Q(View view) {
        ArrayList arrayList;
        int i;
        int intValue;
        int size;
        Object valueOf;
        final SparseArray obj5 = u(view);
        if (obj5 != null) {
            arrayList = new ArrayList();
            intValue = i;
            while (intValue < obj5.size()) {
                if ((WeakReference)obj5.valueAt(intValue).get() == null) {
                }
                intValue++;
                arrayList.add(Integer.valueOf(intValue));
            }
            while (i < arrayList.size()) {
                obj5.remove((Integer)arrayList.get(i).intValue());
                i++;
            }
        }
    }

    private void S(int i, boolean z2) {
        String str;
        int i2;
        int i3;
        int i4;
        int obj6;
        final Bundle bundle = r();
        if (bundle != null) {
            str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
            i2 = 0;
            if (z2) {
            } else {
                obj6 = i2;
            }
            bundle.putInt(str, obj6 |= i3);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned2, int i3) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned2.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned2.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned2.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i3));
    }

    private void f() {
        int sDK_INT;
        int str;
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String string) {
        ArrayList integerArrayList;
        int extras;
        if (Build.VERSION.SDK_INT < 19) {
            ArrayList obj3 = new ArrayList();
            return obj3;
        }
        if (this.a.getExtras().getIntegerArrayList(string) == null) {
            integerArrayList = new ArrayList();
            this.a.getExtras().putIntegerArrayList(string, integerArrayList);
        }
        return integerArrayList;
    }

    private static String i(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        return "ACTION_PRESS_AND_HOLD";
                        return "ACTION_PAGE_RIGHT";
                        return "ACTION_PAGE_LEFT";
                        return "ACTION_PAGE_DOWN";
                        return "ACTION_PAGE_UP";
                        return "ACTION_HIDE_TOOLTIP";
                        return "ACTION_SHOW_TOOLTIP";
                        return "ACTION_SET_PROGRESS";
                        return "ACTION_CONTEXT_CLICK";
                        return "ACTION_SCROLL_RIGHT";
                        return "ACTION_SCROLL_DOWN";
                        return "ACTION_SCROLL_LEFT";
                        return "ACTION_SCROLL_UP";
                        return "ACTION_SCROLL_TO_POSITION";
                        return "ACTION_SHOW_ON_SCREEN";
                }
                return "ACTION_UNKNOWN";
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean k(int i) {
        int i2;
        Bundle bundle = r();
        i2 = 0;
        if (bundle == null) {
            return i2;
        }
        if (int &= i == i) {
            i2 = 1;
        }
        return i2;
    }

    public static ClickableSpan[] p(java.lang.CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])(Spanned)charSequence.getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray sparseArray;
        int i;
        if (u(view) == null) {
            sparseArray = new SparseArray();
            view.setTag(c.I, sparseArray);
        }
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray)view.getTag(c.I);
    }

    private boolean x() {
        return empty ^= 1;
    }

    private int y(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray2) {
        int i;
        boolean equals;
        if (sparseArray2 != null) {
            i = 0;
            while (i < sparseArray2.size()) {
                i++;
            }
        }
        int obj3 = c.d;
        c.d = obj3 + 1;
        return obj3;
    }

    public static d.h.l.e0.c y0(AccessibilityNodeInfo accessibilityNodeInfo) {
        c cVar = new c(accessibilityNodeInfo);
        return cVar;
    }

    public boolean A() {
        return this.a.isChecked();
    }

    public boolean B() {
        return this.a.isClickable();
    }

    public boolean C() {
        return this.a.isEnabled();
    }

    public boolean D() {
        return this.a.isFocusable();
    }

    public boolean E() {
        return this.a.isFocused();
    }

    public boolean F() {
        return this.a.isLongClickable();
    }

    public boolean G() {
        return this.a.isPassword();
    }

    public boolean H() {
        return this.a.isScrollable();
    }

    public boolean I() {
        return this.a.isSelected();
    }

    public boolean J() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.a.isShowingHintText();
        }
        return k(4);
    }

    public boolean N(int i, Bundle bundle2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.a.performAction(i, bundle2);
        }
        return 0;
    }

    public void O() {
        this.a.recycle();
    }

    public boolean P(d.h.l.e0.c.a c$a) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)a.a);
        }
        return 0;
    }

    public void R(boolean z) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setAccessibilityFocused(z);
        }
    }

    @Deprecated
    public void T(Rect rect) {
        this.a.setBoundsInParent(rect);
    }

    public void U(Rect rect) {
        this.a.setBoundsInScreen(rect);
    }

    public void V(boolean z) {
        this.a.setCheckable(z);
    }

    public void W(boolean z) {
        this.a.setChecked(z);
    }

    public void X(java.lang.CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }

    public void Y(boolean z) {
        this.a.setClickable(z);
    }

    public void Z(Object object) {
        int sDK_INT;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 19) {
            if (object == null) {
                obj3 = 0;
            } else {
                obj3 = object.a;
            }
            this.a.setCollectionInfo(obj3);
        }
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public void a0(Object object) {
        int sDK_INT;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 19) {
            if (object == null) {
                obj3 = 0;
            } else {
                obj3 = object.a;
            }
            this.a.setCollectionItemInfo(obj3);
        }
    }

    public void b(d.h.l.e0.c.a c$a) {
        int sDK_INT;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.addAction((AccessibilityNodeInfo.AccessibilityAction)a.a);
        }
    }

    public void b0(java.lang.CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public void c(View view, int i2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.addChild(view, i2);
        }
    }

    public void c0(boolean z) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setDismissable(z);
        }
    }

    public void d0(boolean z) {
        this.a.setEnabled(z);
    }

    public void e(java.lang.CharSequence charSequence, View view2) {
        int sDK_INT;
        int length2;
        int length;
        String str;
        java.lang.CharSequence charSequence2;
        Object obj7;
        sDK_INT = Build.VERSION.SDK_INT;
        f();
        Q(view2);
        sDK_INT = c.p(charSequence);
        if (sDK_INT >= 19 && sDK_INT < 26 && sDK_INT != null && sDK_INT.length > 0) {
            if (sDK_INT < 26) {
                f();
                Q(view2);
                sDK_INT = c.p(charSequence);
                if (sDK_INT != null) {
                    if (sDK_INT.length > 0) {
                        r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", c.a);
                        obj7 = s(view2);
                        length2 = 0;
                        while (sDK_INT != null) {
                            if (length2 < sDK_INT.length) {
                            }
                            length = y(sDK_INT[length2], obj7);
                            WeakReference weakReference = new WeakReference(sDK_INT[length2]);
                            obj7.put(length, weakReference);
                            d(sDK_INT[length2], (Spanned)charSequence, length);
                            length2++;
                        }
                    }
                }
            }
        }
    }

    public void e0(java.lang.CharSequence charSequence) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setError(charSequence);
        }
    }

    public boolean equals(Object object) {
        boolean equals;
        AccessibilityNodeInfo accessibilityNodeInfo;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object == null) {
            return i2;
        }
        if (!object instanceof c) {
            return i2;
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.a;
        if (accessibilityNodeInfo2 == null) {
            if (object.a != null) {
                return i2;
            }
        } else {
            if (!accessibilityNodeInfo2.equals(object.a)) {
                return i2;
            }
        }
        if (this.c != object.c) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        return i;
    }

    public void f0(boolean z) {
        this.a.setFocusable(z);
    }

    public void g0(boolean z) {
        this.a.setFocused(z);
    }

    public List<d.h.l.e0.c.a> h() {
        int actionList;
        int i;
        Object obj;
        d.h.l.e0.c.a aVar;
        if (Build.VERSION.SDK_INT >= 21) {
            actionList = this.a.getActionList();
        } else {
            actionList = 0;
        }
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < actionList.size()) {
                aVar = new c.a(actionList.get(i));
                arrayList.add(aVar);
                i++;
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(boolean z) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setHeading(z);
        } else {
            S(2, z);
        }
    }

    public int hashCode() {
        int i;
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            i = 0;
        } else {
            i = accessibilityNodeInfo.hashCode();
        }
        return i;
    }

    public void i0(java.lang.CharSequence charSequence) {
        AccessibilityNodeInfo sDK_INT;
        int str;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 26) {
            this.a.setHintText(charSequence);
        } else {
            if (sDK_INT >= 19) {
                this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
            }
        }
    }

    public int j() {
        return this.a.getActions();
    }

    public void j0(int i) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setMaxTextLength(i);
        }
    }

    public void k0(java.lang.CharSequence charSequence) {
        this.a.setPackageName(charSequence);
    }

    @Deprecated
    public void l(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void l0(java.lang.CharSequence charSequence) {
        AccessibilityNodeInfo sDK_INT;
        int str;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 28) {
            this.a.setPaneTitle(charSequence);
        } else {
            if (sDK_INT >= 19) {
                this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
        }
    }

    public void m(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public void m0(View view) {
        this.b = -1;
        this.a.setParent(view);
    }

    public int n() {
        return this.a.getChildCount();
    }

    public void n0(View view, int i2) {
        int sDK_INT;
        this.b = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setParent(view, i2);
        }
    }

    public java.lang.CharSequence o() {
        return this.a.getClassName();
    }

    public void o0(java.lang.CharSequence charSequence) {
        int sDK_INT;
        int str;
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public void p0(boolean z) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setScreenReaderFocusable(z);
        } else {
            S(1, z);
        }
    }

    public java.lang.CharSequence q() {
        return this.a.getContentDescription();
    }

    public void q0(boolean z) {
        this.a.setScrollable(z);
    }

    public Bundle r() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.a.getExtras();
        }
        Bundle bundle = new Bundle();
        return bundle;
    }

    public void r0(boolean z) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setShowingHintText(z);
        } else {
            S(4, z);
        }
    }

    public void s0(View view, int i2) {
        int sDK_INT;
        this.c = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setSource(view, i2);
        }
    }

    public java.lang.CharSequence t() {
        return this.a.getPackageName();
    }

    public void t0(java.lang.CharSequence charSequence) {
        AccessibilityNodeInfo sDK_INT;
        int str;
        if (a.a()) {
            this.a.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT >= 19) {
                this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
            }
        }
    }

    public String toString() {
        int i;
        int i2;
        int size;
        Object obj;
        String string;
        boolean equals;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("; boundsInParent: ");
        stringBuilder3.append(rect);
        stringBuilder.append(stringBuilder3.toString());
        m(rect);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("; boundsInScreen: ");
        stringBuilder4.append(rect);
        stringBuilder.append(stringBuilder4.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(t());
        stringBuilder.append("; className: ");
        stringBuilder.append(o());
        stringBuilder.append("; text: ");
        stringBuilder.append(v());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(q());
        stringBuilder.append("; viewId: ");
        stringBuilder.append(w());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(z());
        stringBuilder.append("; checked: ");
        stringBuilder.append(A());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(D());
        stringBuilder.append("; focused: ");
        stringBuilder.append(E());
        stringBuilder.append("; selected: ");
        stringBuilder.append(I());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(B());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(F());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(C());
        stringBuilder.append("; password: ");
        stringBuilder.append(G());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; scrollable: ");
        stringBuilder2.append(H());
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("; [");
        String str19 = ", ";
        int i3 = 1;
        if (Build.VERSION.SDK_INT >= 21) {
            i = h();
            i2 = 0;
            while (i2 < i.size()) {
                obj = i.get(i2);
                if (c.i((c.a)obj.b()).equals("ACTION_UNKNOWN") && obj.c() != null) {
                }
                stringBuilder.append(string);
                if (i2 != size2 -= i3) {
                }
                i2++;
                stringBuilder.append(str19);
                if (obj.c() != null) {
                }
                string = obj.c().toString();
            }
        } else {
            i = j();
            while (i != 0) {
                int i4 = i3 << numberOfTrailingZeros;
                stringBuilder.append(c.i(i4));
                if (i &= size != 0) {
                }
                stringBuilder.append(str19);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void u0(java.lang.CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public java.lang.CharSequence v() {
        String substring;
        int intValue2;
        int i;
        int intValue3;
        int intValue;
        if (x()) {
            List list = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
            while (i < list.size()) {
                substring = new a((Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").get(i).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY"));
                spannableString.setSpan(substring, (Integer)list.get(i).intValue(), (Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").get(i).intValue(), (Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").get(i).intValue());
                i++;
            }
            return spannableString;
        }
        return this.a.getText();
    }

    public void v0(View view) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 22) {
            this.a.setTraversalAfter(view);
        }
    }

    public String w() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.a.getViewIdResourceName();
        }
        return null;
    }

    public void w0(boolean z) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setVisibleToUser(z);
        }
    }

    public AccessibilityNodeInfo x0() {
        return this.a;
    }

    public boolean z() {
        return this.a.isCheckable();
    }
}
