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

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    private static int d;
    private final AccessibilityNodeInfo a;
    public int b = -1;
    private int c = -1;

    public static class a {

        public static final c.a e = new c$a(16, 0);
        public static final c.a f = new c$a(4096, 0);
        public static final c.a g = new c$a(8192, 0);
        public static final c.a h = new c$a(262144, 0);
        public static final c.a i = new c$a(524288, 0);
        public static final c.a j = new c$a(1048576, 0);
        public static final c.a k;
        public static final c.a l;
        final Object a;
        private final int b;
        private final Class<? extends f.a> c;
        protected final f d;
        static {
            int i2 = 2097152;
            AccessibilityNodeInfo.AccessibilityAction aCTION_PAGE_RIGHT2;
            int i3 = 512;
            AccessibilityNodeInfo.AccessibilityAction aCTION_PAGE_DOWN2;
            java.lang.CharSequence charSequence = null;
            AccessibilityNodeInfo.AccessibilityAction aCTION_CONTEXT_CLICK2;
            AccessibilityNodeInfo.AccessibilityAction aCTION_MOVE_WINDOW2;
            AccessibilityNodeInfo.AccessibilityAction aCTION_SET_PROGRESS2;
            Class<d.h.l.e0.f.c> obj = f.c.class;
            Class<d.h.l.e0.f.b> obj2 = f.b.class;
            charSequence = null;
            d.h.l.e0.c.a aVar10 = new c.a(1, charSequence);
            d.h.l.e0.c.a aVar11 = new c.a(2, charSequence);
            d.h.l.e0.c.a aVar12 = new c.a(4, charSequence);
            d.h.l.e0.c.a aVar13 = new c.a(8, charSequence);
            d.h.l.e0.c.a aVar14 = new c.a(32, charSequence);
            d.h.l.e0.c.a aVar15 = new c.a(64, charSequence);
            d.h.l.e0.c.a aVar16 = new c.a(128, charSequence);
            d.h.l.e0.c.a aVar17 = new c.a(256, charSequence, obj2);
            i3 = 512;
            d.h.l.e0.c.a aVar18 = new c.a(i3, charSequence, obj2);
            d.h.l.e0.c.a aVar8 = new c.a(1024, charSequence, obj);
            d.h.l.e0.c.a aVar9 = new c.a(2048, charSequence, obj);
            d.h.l.e0.c.a aVar3 = new c.a(16384, charSequence);
            d.h.l.e0.c.a aVar4 = new c.a(32768, charSequence);
            d.h.l.e0.c.a aVar5 = new c.a(65536, charSequence);
            d.h.l.e0.c.a aVar6 = new c.a(131072, charSequence, f.g.class);
            i2 = 2097152;
            d.h.l.e0.c.a aVar7 = new c.a(i2, charSequence, f.h.class);
            int sDK_INT2 = Build.VERSION.SDK_INT;
            int i12 = 23;
            AccessibilityNodeInfo.AccessibilityAction aCTION_SHOW_ON_SCREEN2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SHOW_ON_SCREEN2 : charSequence;
            c.a aVar19 = new c.a(charSequence, 16908342, null, null, null);
            AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_TO_POSITION2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SCROLL_TO_POSITION2 : charSequence;
            c.a aVar26 = new c.a(charSequence, 16908343, null, null, f.e.class);
            AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_UP2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SCROLL_UP2 : charSequence;
            c.a aVar = new c.a(charSequence, 16908344, null, null, null);
            c.a.k = aVar;
            AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_LEFT2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SCROLL_LEFT2 : charSequence;
            c.a aVar27 = new c.a(charSequence, 16908345, null, null, null);
            AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_DOWN2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SCROLL_DOWN2 : charSequence;
            c.a aVar2 = new c.a(charSequence, 16908346, null, null, null);
            c.a.l = aVar2;
            AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_RIGHT2 = Build.VERSION.SDK_INT >= i12 ? aCTION_SCROLL_RIGHT2 : charSequence;
            c.a aVar28 = new c.a(charSequence, 16908347, null, null, null);
            int i19 = 29;
            AccessibilityNodeInfo.AccessibilityAction aCTION_PAGE_UP2 = Build.VERSION.SDK_INT >= i19 ? aCTION_PAGE_UP2 : charSequence;
            c.a aVar20 = new c.a(charSequence, 16908358, null, null, null);
            aCTION_PAGE_DOWN2 = Build.VERSION.SDK_INT >= i19 ? aCTION_PAGE_DOWN2 : charSequence;
            c.a aVar29 = new c.a(aCTION_PAGE_DOWN2, 16908359, null, null, null);
            aCTION_PAGE_DOWN2 = Build.VERSION.SDK_INT >= i19 ? aCTION_PAGE_DOWN2 : charSequence;
            c.a aVar21 = new c.a(aCTION_PAGE_DOWN2, 16908360, null, null, null);
            aCTION_PAGE_RIGHT2 = Build.VERSION.SDK_INT >= i19 ? aCTION_PAGE_RIGHT2 : charSequence;
            c.a aVar30 = new c.a(aCTION_PAGE_RIGHT2, 16908361, null, null, null);
            aCTION_CONTEXT_CLICK2 = Build.VERSION.SDK_INT >= i12 ? aCTION_CONTEXT_CLICK2 : charSequence;
            c.a aVar22 = new c.a(aCTION_CONTEXT_CLICK2, 16908348, null, null, null);
            aCTION_SET_PROGRESS2 = Build.VERSION.SDK_INT >= 24 ? aCTION_SET_PROGRESS2 : charSequence;
            c.a aVar31 = new c.a(aCTION_SET_PROGRESS2, 16908349, null, null, f.f.class);
            aCTION_MOVE_WINDOW2 = Build.VERSION.SDK_INT >= 26 ? aCTION_MOVE_WINDOW2 : charSequence;
            c.a aVar23 = new c.a(aCTION_MOVE_WINDOW2, 16908354, null, null, f.d.class);
            int i = 28;
            aCTION_PAGE_RIGHT2 = Build.VERSION.SDK_INT >= i ? aCTION_PAGE_RIGHT2 : charSequence;
            c.a aVar32 = new c.a(aCTION_PAGE_RIGHT2, 16908356, null, null, null);
            AccessibilityNodeInfo.AccessibilityAction aCTION_HIDE_TOOLTIP2 = Build.VERSION.SDK_INT >= i ? aCTION_HIDE_TOOLTIP2 : charSequence;
            c.a aVar24 = new c.a(charSequence, 16908357, null, null, null);
            int i15 = 30;
            aCTION_PAGE_RIGHT2 = Build.VERSION.SDK_INT >= i15 ? aCTION_PAGE_RIGHT2 : charSequence;
            c.a aVar33 = new c.a(charSequence, 16908362, null, null, null);
            if (Build.VERSION.SDK_INT >= i15) {
                AccessibilityNodeInfo.AccessibilityAction aCTION_IME_ENTER2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            c.a aVar25 = new c.a(charSequence, 16908372, null, null, null);
        }

        public a(int i, java.lang.CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public c.a a(java.lang.CharSequence charSequence, f fVar) {
            c.a aVar = new c.a(null, this.b, charSequence, fVar, this.c);
            return aVar;
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

        public boolean d(View view, Bundle bundle) throws java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            d.h.l.e0.f.a aVar = null;
            Class name;
            int i = 0;
            if (this.d != null) {
                int i2 = 0;
                if (this.c != null) {
                    try {
                        Object constructor = this.c.getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
                    } catch (Exception e) {
                    }
                    try {
                        constructor.a(e);
                    } catch (Exception e) {
                    }
                }
                return this.d.a(view, aVar);
            }
            return false;
        }

        public boolean equals(Object object) {
            final boolean z = false;
            if (object == null) {
                return false;
            }
            if (!(object instanceof c.a)) {
                return false;
            }
            if (this.a == null) {
                if (object.a != null) {
                    return false;
                }
            } else {
                if (!this.a.equals(object.a)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            if (this.a != null) {
                i = this.a.hashCode();
            } else {
                i = 0;
            }
            return i;
        }

        public a(int i, java.lang.CharSequence charSequence, f fVar) {
            this(null, i, charSequence, fVar, null);
        }

        a(Object object) {
            this(object, 0, null, null, null);
        }

        private a(int i, java.lang.CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i, charSequence, null, cls);
        }

        a(Object object, int i, java.lang.CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            super();
            this.b = i;
            this.d = fVar;
            if (Build.VERSION.SDK_INT < 21 || object != null) {
                this.a = object;
            } else {
                this.a = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            }
            this.c = cls;
        }
    }

    public static class b {

        final Object a;
        b(Object object) {
            super();
            this.a = object;
        }

        public static c.b a(int i, int i2, boolean z, int i3) {
            int sDK_INT2 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 21) {
                return new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new c.b(null);
        }
    }

    public static class c {

        final Object a;
        c(Object object) {
            super();
            this.a = object;
        }

        public static c.c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int sDK_INT2 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 21) {
                return new c.c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c.c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c.c(null);
        }
    }
    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        super();
        this.a = accessibilityNodeInfo;
    }

    public static c K() {
        return c.y0(AccessibilityNodeInfo.obtain());
    }

    public static c L(View view) {
        return c.y0(AccessibilityNodeInfo.obtain(view));
    }

    public static c M(c cVar) {
        return c.y0(AccessibilityNodeInfo.obtain(cVar.a));
    }

    private void Q(View view) {
        int value = 0;
        Object obj;
        final SparseArray sparseArray = u(view);
        if (sparseArray != null) {
            ArrayList arrayList = new ArrayList();
            value = 0;
            while (value < sparseArray.size()) {
                value = value + 1;
            }
            while (value < arrayList.size()) {
                sparseArray.remove((Integer)arrayList.get(value).intValue());
                value = value + 1;
            }
        }
    }

    private void S(int i, boolean z) {
        int i2;
        final Bundle bundle = r();
        if (bundle != null) {
            str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
            i2 = 0;
            i4 = ~i;
            i3 = (bundle.getInt(str, i2)) & i4;
            if (!(z)) {
            }
            i5 = i2 | (bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2) & ~i);
            bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i5);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void f() {
        int i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String str) {
        ArrayList integerArrayList;
        int i = 19;
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        if (this.a.getExtras().getIntegerArrayList(str) == null) {
            this.a.getExtras().putIntegerArrayList(str, new ArrayList());
        }
        return integerArrayList;
    }

    private boolean k(int i) {
        boolean z = false;
        Bundle bundle = r();
        int i3 = 0;
        if (bundle == null) {
            return false;
        }
        if (((bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i3)) & i) == i) {
            int i4 = 1;
        }
        return z;
    }

    public static ClickableSpan[] p(java.lang.CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])(Spanned)charSequence.getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray sparseArray;
        if (u(view) == null) {
            view.setTag(c.I, new SparseArray());
        }
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray)view.getTag(c.I);
    }

    private boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int y(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        int i = 0;
        if (sparseArray != null) {
            i = 0;
            while (i < sparseArray.size()) {
                if (clickableSpan.equals((ClickableSpan)(WeakReference)sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = c.d;
        c.d++;
        return i2;
    }

    public static c y0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
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

    public boolean N(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.a.performAction(i, bundle);
        }
        return false;
    }

    public void O() {
        this.a.recycle();
    }

    public boolean P(c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)aVar.a);
        }
        return false;
    }

    public void R(boolean z) {
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
        AccessibilityNodeInfo.CollectionInfo collectionInfo = null;
        if (Build.VERSION.SDK_INT >= 19 && object == null) {
            int i2 = 0;
            this.a.setCollectionInfo(collectionInfo);
        }
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public void a0(Object object) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = null;
        if (Build.VERSION.SDK_INT >= 19 && object == null) {
            int i2 = 0;
            this.a.setCollectionItemInfo(collectionItemInfo);
        }
    }

    public void b(c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.addAction((AccessibilityNodeInfo.AccessibilityAction)aVar.a);
        }
    }

    public void b0(java.lang.CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public void c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.addChild(view, i);
        }
    }

    public void c0(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setDismissable(z);
        }
    }

    public void d0(boolean z) {
        this.a.setEnabled(z);
    }

    public void e(java.lang.CharSequence charSequence, View view) {
        int length = 0;
        int length2;
        String str;
        Spanned spanned;
        sDK_INT2 = Build.VERSION.SDK_INT;
        length = 19;
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            f();
            Q(view);
            ClickableSpan[] objArr = c.p(charSequence);
            if (objArr != null) {
                length = objArr.length;
                if (objArr.length > 0) {
                    str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
                    r().putInt(str, c.a);
                    SparseArray sparseArray = s(view);
                    length = 0;
                    while (objArr != null) {
                        length2 = objArr.length;
                    }
                }
            }
        }
    }

    public void e0(java.lang.CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setError(charSequence);
        }
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object == null) {
            return false;
        }
        if (!(object instanceof c)) {
            return false;
        }
        if (this.a == null) {
            if (object.a != null) {
                return false;
            }
        } else {
            if (!this.a.equals(object.a)) {
                return false;
            }
        }
        if (this.c != object.c) {
            return false;
        }
        return this.b != object.b ? z2 : z;
    }

    public void f0(boolean z) {
        this.a.setFocusable(z);
    }

    public void g0(boolean z) {
        this.a.setFocused(z);
    }

    public List<c.a> h() {
        int i = 0;
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            List actionList = this.a.getActionList();
        } else {
            i = 0;
        }
        if (Build.VERSION.SDK_INT != 0) {
            ArrayList arrayList = new ArrayList();
            i2 = 0;
            while (i2 < i.size()) {
                arrayList.add(new c.a(i.get(i2)));
                i2 = i2 + 1;
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setHeading(z);
        } else {
            S(2, z);
        }
    }

    public int hashCode() {
        int i = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        return i;
    }

    public void i0(java.lang.CharSequence charSequence) {
        int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setHintText(charSequence);
        } else {
            i = 19;
            if (Build.VERSION.SDK_INT >= 19) {
                this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
            }
        }
    }

    public int j() {
        return this.a.getActions();
    }

    public void j0(int i) {
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
        int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 28;
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setPaneTitle(charSequence);
        } else {
            i = 19;
            if (Build.VERSION.SDK_INT >= 19) {
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

    public void n0(View view, int i) {
        this.b = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setParent(view, i);
        }
    }

    public java.lang.CharSequence o() {
        return this.a.getClassName();
    }

    public void o0(java.lang.CharSequence charSequence) {
        int i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public void p0(boolean z) {
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
        return new Bundle();
    }

    public void r0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setShowingHintText(z);
        } else {
            S(4, z);
        }
    }

    public void s0(View view, int i) {
        this.c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setSource(view, i);
        }
    }

    public java.lang.CharSequence t() {
        return this.a.getPackageName();
    }

    public void t0(java.lang.CharSequence charSequence) {
        if (a.a()) {
            this.a.setStateDescription(charSequence);
        } else {
            int i = 19;
            if (Build.VERSION.SDK_INT >= 19) {
                this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
            }
        }
    }

    public String toString() {
        int i;
        int i2 = 21;
        int size;
        String charSequence;
        boolean equals;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        StringBuilder stringBuilder3 = new StringBuilder();
        String str24 = "; boundsInParent: ";
        str21 = str24 + rect;
        stringBuilder.append(str21);
        m(rect);
        StringBuilder stringBuilder4 = new StringBuilder();
        String str25 = "; boundsInScreen: ";
        str2 = str25 + rect;
        stringBuilder.append(str2);
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
        String str22 = "; scrollable: ";
        boolean z10 = H();
        str18 = str22 + z10;
        stringBuilder.append(str18);
        stringBuilder.append("; [");
        String str23 = ", ";
        int i4 = 1;
        i2 = 21;
        if (Build.VERSION.SDK_INT >= 21) {
            List list = h();
            i2 = 0;
            while (i2 < list.size()) {
                Object item = list.get(i2);
                stringBuilder.append(charSequence);
                i3 = list.size() - i4;
                i2 = i2 + 1;
            }
        } else {
            i = j();
            while (Build.VERSION.SDK_INT != 0) {
                int i5 = i4 << Integer.numberOfTrailingZeros(i);
                size = ~i5;
                i = i & size;
                stringBuilder.append(c.i(i5));
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void u0(java.lang.CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public java.lang.CharSequence v() {
        int i = 0;
        if (x()) {
            List list = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            i = 0;
            final SpannableString spannableString = new SpannableString(TextUtils.substring(this.a.getText(), i, this.a.getText().length()));
            while (i < list.size()) {
                spannableString.setSpan(new a((Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").get(i).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), (Integer)list.get(i).intValue(), (Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").get(i).intValue(), (Integer)g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").get(i).intValue());
                i = i + 1;
            }
            return spannableString;
        }
        return this.a.getText();
    }

    public void v0(View view) {
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


    private static String i(int i) {
        if (i != 1 && i != 2) {
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
            }
            return "ACTION_UNKNOWN";
        }
        return "ACTION_FOCUS";
    }
}
