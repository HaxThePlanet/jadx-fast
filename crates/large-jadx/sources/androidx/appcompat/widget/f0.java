package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.p;
import androidx.core.widget.j;
import d.a.a;
import d.a.j;
import d.h.l.u;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class f0 implements p {

    private static Method X;
    private static Method Y;
    private static Method Z;
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    int G;
    private View H;
    private int I;
    private DataSetObserver J;
    private View K;
    private Drawable L;
    private AdapterView.OnItemClickListener M;
    private AdapterView.OnItemSelectedListener N;
    final androidx.appcompat.widget.f0.f O;
    private final androidx.appcompat.widget.f0.e P;
    private final androidx.appcompat.widget.f0.d Q;
    private final androidx.appcompat.widget.f0.b R;
    final Handler S;
    private final Rect T;
    private Rect U;
    private boolean V;
    PopupWindow W;
    private Context a;
    private ListAdapter b;
    androidx.appcompat.widget.b0 c;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    class a implements AdapterView.OnItemSelectedListener {

        final androidx.appcompat.widget.f0 a;
        a(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        public void onItemSelected(AdapterView<?> adapterView, View view2, int i3, long l4) {
            int obj1;
            int obj2;
            obj1 = obj1.c;
            if (i3 != -1 && obj1 != null) {
                obj1 = obj1.c;
                if (obj1 != null) {
                    obj1.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class b implements Runnable {

        final androidx.appcompat.widget.f0 a;
        b(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.r();
        }
    }

    private class c extends DataSetObserver {

        final androidx.appcompat.widget.f0 a;
        c(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            boolean z;
            if (this.a.b()) {
                this.a.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.dismiss();
        }
    }

    private class d implements AbsListView.OnScrollListener {

        final androidx.appcompat.widget.f0 a;
        d(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // android.widget.AbsListView$OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView$OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            int obj1;
            int obj2;
            if (i2 == 1 && !this.a.A() && obj1.W.getContentView() != null) {
                if (!this.a.A()) {
                    if (obj1.W.getContentView() != null) {
                        obj1 = this.a;
                        obj1.S.removeCallbacks(obj1.O);
                        obj1.O.run();
                    }
                }
            }
        }
    }

    private class e implements View.OnTouchListener {

        final androidx.appcompat.widget.f0 a;
        e(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            int height;
            int showing;
            androidx.appcompat.widget.f0.f obj3;
            Handler obj4;
            obj3 = motionEvent2.getAction();
            height = (int)f;
            obj4 = (int)obj4;
            showing = f0Var2.W;
            showing = f0Var3.W.getWidth();
            if (obj3 == null && showing != null && showing.isShowing() && height >= 0 && height < showing && obj4 >= 0 && obj4 < f0Var.W.getHeight()) {
                showing = f0Var2.W;
                if (showing != null) {
                    if (showing.isShowing()) {
                        if (height >= 0) {
                            showing = f0Var3.W.getWidth();
                            if (height < showing) {
                                if (obj4 >= 0) {
                                    if (obj4 < f0Var.W.getHeight()) {
                                        obj3 = this.a;
                                        obj3.S.postDelayed(obj3.O, 250);
                                    } else {
                                        if (obj3 == 1) {
                                            obj3 = this.a;
                                            obj3.S.removeCallbacks(obj3.O);
                                        }
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
            } else {
            }
            return 0;
        }
    }

    private class f implements Runnable {

        final androidx.appcompat.widget.f0 a;
        f(androidx.appcompat.widget.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.b0 childCount2;
            int childCount;
            int i;
            childCount2 = f0Var.c;
            childCount = this.a;
            if (childCount2 != null && u.Q(childCount2) && f0Var2.c.getCount() > f0Var4.c.getChildCount() && f0Var3.c.getChildCount() <= childCount.G) {
                if (u.Q(childCount2)) {
                    if (f0Var2.c.getCount() > f0Var4.c.getChildCount()) {
                        childCount = this.a;
                        if (f0Var3.c.getChildCount() <= childCount.G) {
                            childCount.W.setInputMethodMode(2);
                            this.a.a();
                        }
                    }
                }
            }
        }
    }
    static {
        Method declaredMethod;
        int declaredMethod2;
        int declaredMethod3;
        int i;
        int tYPE;
        int str2;
        int str;
        Class[] arr;
        Class<Rect> obj;
        i = 0;
        tYPE = 1;
        final String str4 = "ListPopupWindow";
        if (Build.VERSION.SDK_INT <= 28) {
            Class[] arr2 = new Class[tYPE];
            arr2[i] = Boolean.TYPE;
            f0.X = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", arr2);
            arr = new Class[tYPE];
            arr[i] = Rect.class;
            f0.Z = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", arr);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            arr = new Class[3];
            arr[i] = View.class;
            arr[tYPE] = Integer.TYPE;
            arr[2] = Boolean.TYPE;
            f0.Y = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", arr);
        }
    }

    public f0(Context context) {
        super(context, 0, a.E);
    }

    public f0(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public f0(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super();
        int i = -2;
        this.v = i;
        this.w = i;
        this.z = 1002;
        int i5 = 0;
        this.D = i5;
        this.E = i5;
        this.F = i5;
        this.G = Integer.MAX_VALUE;
        this.I = i5;
        f0.f fVar = new f0.f(this);
        this.O = fVar;
        f0.e eVar = new f0.e(this);
        this.P = eVar;
        f0.d dVar = new f0.d(this);
        this.Q = dVar;
        f0.b bVar = new f0.b(this);
        this.R = bVar;
        Rect rect = new Rect();
        this.T = rect;
        this.a = context;
        Handler handler = new Handler(context.getMainLooper());
        this.S = handler;
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, j.d1, i3, i4);
        this.x = styledAttributes.getDimensionPixelOffset(j.e1, i5);
        int dimensionPixelOffset = styledAttributes.getDimensionPixelOffset(j.f1, i5);
        this.y = dimensionPixelOffset;
        int i9 = 1;
        if (dimensionPixelOffset != null) {
            this.A = i9;
        }
        styledAttributes.recycle();
        n nVar = new n(context, attributeSet2, i3, i4);
        this.W = nVar;
        nVar.setInputMethodMode(i9);
    }

    private void C() {
        Object parent;
        boolean z;
        parent = this.H;
        parent = parent.getParent();
        if (parent != null && parent instanceof ViewGroup) {
            parent = parent.getParent();
            if (parent instanceof ViewGroup) {
                (ViewGroup)parent.removeView(this.H);
            }
        }
    }

    private void N(boolean z) {
        Object obj;
        int i2;
        Object[] arr;
        int i;
        boolean obj5;
        if (Build.VERSION.SDK_INT <= 28) {
            obj = f0.X;
            if (obj != null) {
                arr = new Object[1];
                obj.invoke(this.W, Boolean.valueOf(z));
            }
        } else {
            this.W.setIsClippedToScreen(z);
        }
    }

    private int q() {
        int i6;
        Object layoutParams;
        int i3;
        int measureSpec;
        int i7;
        int i8;
        int paddingBottom;
        int right;
        boolean z;
        int bottomMargin;
        int i4;
        int i2;
        int topMargin2;
        int i5;
        Object dVar;
        int topMargin;
        LinearLayout linearLayout;
        int i;
        int i10 = Integer.MIN_VALUE;
        i7 = -1;
        i8 = 1;
        int i15 = 0;
        if (this.c == null) {
            Context context = this.a;
            androidx.appcompat.widget.b0 b0Var4 = s(context, z2 ^= i8);
            this.c = b0Var4;
            Drawable drawable = this.L;
            if (drawable != null) {
                b0Var4.setSelector(drawable);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.M);
            this.c.setFocusable(i8);
            this.c.setFocusableInTouchMode(i8);
            f0.a aVar = new f0.a(this);
            this.c.setOnItemSelectedListener(aVar);
            this.c.setOnScrollListener(this.Q);
            AdapterView.OnItemSelectedListener list = this.N;
            if (list != null) {
                this.c.setOnItemSelectedListener(list);
            }
            bottomMargin = this.c;
            topMargin = this.H;
            if (topMargin != null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(i8);
                layoutParams = new LinearLayout.LayoutParams(i7, i15, 1065353216);
                i = this.I;
                if (i != 0) {
                    if (i != i8) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid hint position ");
                        stringBuilder.append(this.I);
                        Log.e("ListPopupWindow", stringBuilder.toString());
                    } else {
                        linearLayout.addView(bottomMargin, layoutParams);
                        linearLayout.addView(topMargin);
                    }
                } else {
                    linearLayout.addView(topMargin);
                    linearLayout.addView(bottomMargin, layoutParams);
                }
                i2 = this.w >= 0 ? i10 : i3;
                topMargin.measure(View.MeasureSpec.makeMeasureSpec(i3, i2), i15);
                android.view.ViewGroup.LayoutParams layoutParams2 = topMargin.getLayoutParams();
                i6 = i18;
                bottomMargin = linearLayout;
            } else {
                i6 = i15;
            }
            this.W.setContentView(bottomMargin);
        } else {
            View contentView = this.W.getContentView();
            View view = this.H;
            if (view != null) {
                android.view.ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                i9 += bottomMargin;
            } else {
                i6 = i15;
            }
        }
        Drawable background = this.W.getBackground();
        if (background != null) {
            background.getPadding(this.T);
            Rect rect3 = this.T;
            topMargin2 = rect3.top;
            bottom += topMargin2;
            if (!this.A) {
                this.y = -topMargin2;
            }
        } else {
            this.T.setEmpty();
            i4 = i15;
        }
        if (this.W.getInputMethodMode() == 2) {
        } else {
            i8 = i15;
        }
        paddingBottom = u(t(), this.y, i8);
        if (!this.E) {
            if (this.v == i7) {
            } else {
                right = this.w;
                if (right != -2) {
                    int i11 = 1073741824;
                    if (right != i7) {
                        measureSpec = View.MeasureSpec.makeMeasureSpec(right, i11);
                    } else {
                        Rect rect = this.T;
                        measureSpec = View.MeasureSpec.makeMeasureSpec(widthPixels -= i5, i11);
                    }
                } else {
                    Rect rect2 = this.T;
                    measureSpec = View.MeasureSpec.makeMeasureSpec(widthPixels2 -= i5, i10);
                }
                int i12 = this.c.d(measureSpec, 0, -1, paddingBottom - i6, -1);
                if (i12 > 0) {
                    i6 += i4;
                }
            }
            return i12 += i6;
        }
        return paddingBottom += i4;
    }

    private int u(View view, int i2, boolean z3) {
        Method method;
        boolean obj8;
        method = f0.Y;
        if (Build.VERSION.SDK_INT <= 23 && method != null) {
            method = f0.Y;
            if (method != null) {
                Object[] arr = new Object[3];
                return (Integer)method.invoke(this.W, view, Integer.valueOf(i2), Boolean.valueOf(z3)).intValue();
            }
            return this.W.getMaxAvailableHeight(view, i2);
        }
        return this.W.getMaxAvailableHeight(view, i2, z3);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean A() {
        int i;
        i = this.W.getInputMethodMode() == 2 ? 1 : 0;
        return i;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean B() {
        return this.V;
    }

    @Override // androidx.appcompat.view.menu.p
    public void D(View view) {
        this.K = view;
    }

    @Override // androidx.appcompat.view.menu.p
    public void E(int i) {
        this.W.setAnimationStyle(i);
    }

    @Override // androidx.appcompat.view.menu.p
    public void F(int i) {
        int background;
        int i2;
        background = this.W.getBackground();
        if (background != null) {
            background.getPadding(this.T);
            Rect rect = this.T;
            this.w = i3 += i;
        } else {
            Q(i);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void G(int i) {
        this.D = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void H(Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = 0;
        }
        this.U = rect2;
    }

    @Override // androidx.appcompat.view.menu.p
    public void I(int i) {
        this.W.setInputMethodMode(i);
    }

    @Override // androidx.appcompat.view.menu.p
    public void J(boolean z) {
        this.V = z;
        this.W.setFocusable(z);
    }

    @Override // androidx.appcompat.view.menu.p
    public void K(PopupWindow.OnDismissListener popupWindow$OnDismissListener) {
        this.W.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.view.menu.p
    public void L(AdapterView.OnItemClickListener adapterView$OnItemClickListener) {
        this.M = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public void M(boolean z) {
        this.C = true;
        this.B = z;
    }

    @Override // androidx.appcompat.view.menu.p
    public void O(int i) {
        this.I = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void P(int i) {
        boolean choiceMode;
        final androidx.appcompat.widget.b0 b0Var = this.c;
        b0Var.setListSelectionHidden(false);
        b0Var.setSelection(i);
        if (b() && b0Var != null && b0Var.getChoiceMode() != 0) {
            if (b0Var != null) {
                b0Var.setListSelectionHidden(false);
                b0Var.setSelection(i);
                if (b0Var.getChoiceMode() != 0) {
                    b0Var.setItemChecked(i, true);
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void Q(int i) {
        this.w = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        int i4;
        boolean z3;
        Object method;
        boolean inTouchMode;
        int width2;
        int i2;
        androidx.appcompat.widget.f0.e eVar;
        int i3;
        boolean z;
        Object view;
        PopupWindow z2;
        PopupWindow arr;
        int width;
        int i;
        int i8;
        int i10;
        PopupWindow popupWindow;
        View view2;
        int i5;
        int i7;
        int i9;
        int i6;
        i4 = q();
        z2 = A();
        j.b(this.W, this.z);
        i = 1;
        i10 = -2;
        final int i15 = 0;
        final int i16 = -1;
        if (this.W.isShowing()) {
            if (!u.Q(t())) {
            }
            width = this.w;
            if (width == i16) {
                width = i16;
            } else {
                if (width == i10) {
                    width = t().getWidth();
                }
            }
            int i17 = this.v;
            if (i17 == i16) {
                if (z2) {
                } else {
                    i4 = i16;
                }
                if (z2) {
                    i10 = this.w == i16 ? i16 : i15;
                    this.W.setWidth(i10);
                    this.W.setHeight(i15);
                } else {
                    i10 = this.w == i16 ? i16 : i15;
                    this.W.setWidth(i10);
                    this.W.setHeight(i16);
                }
            } else {
                if (i17 == i10) {
                } else {
                    i4 = i17;
                }
            }
            if (!this.F && !this.E) {
                if (!this.E) {
                } else {
                    i = i15;
                }
            } else {
            }
            this.W.setOutsideTouchable(i);
            i9 = width < 0 ? i16 : width;
            i6 = i4 < 0 ? i16 : i4;
            this.W.update(t(), this.x, this.y, i9, i6);
        } else {
            width2 = this.w;
            if (width2 == i16) {
                width2 = i16;
            } else {
                if (width2 == i10) {
                    width2 = t().getWidth();
                }
            }
            int i11 = this.v;
            if (i11 == i16) {
                i4 = i16;
            } else {
                if (i11 == i10) {
                } else {
                    i4 = i11;
                }
            }
            this.W.setWidth(width2);
            this.W.setHeight(i4);
            N(i);
            if (!this.F && !this.E) {
                i2 = !this.E ? i : i15;
            } else {
            }
            this.W.setOutsideTouchable(i2);
            this.W.setTouchInterceptor(this.P);
            if (this.C) {
                j.a(this.W, this.B);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                method = f0.Z;
                if (method != null) {
                    arr = new Object[i];
                    arr[i15] = this.U;
                    method.invoke(this.W, arr);
                }
            } else {
                this.W.setEpicenterBounds(this.U);
            }
            j.c(this.W, t(), this.x, this.y, this.D);
            this.c.setSelection(i16);
            if (this.V) {
                if (this.c.isInTouchMode()) {
                    r();
                }
            } else {
            }
            if (!this.V) {
                this.S.post(this.R);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b() {
        return this.W.isShowing();
    }

    @Override // androidx.appcompat.view.menu.p
    public void c(Drawable drawable) {
        this.W.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public int d() {
        return this.x;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.W.dismiss();
        C();
        int i = 0;
        this.W.setContentView(i);
        this.c = i;
        this.S.removeCallbacks(this.O);
    }

    @Override // androidx.appcompat.view.menu.p
    public void f(int i) {
        this.x = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public Drawable i() {
        return this.W.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView k() {
        return this.c;
    }

    @Override // androidx.appcompat.view.menu.p
    public void l(int i) {
        this.y = i;
        this.A = true;
    }

    @Override // androidx.appcompat.view.menu.p
    public int o() {
        if (!this.A) {
            return 0;
        }
        return this.y;
    }

    @Override // androidx.appcompat.view.menu.p
    public void p(ListAdapter listAdapter) {
        DataSetObserver cVar;
        ListAdapter list;
        cVar = this.J;
        if (cVar == null) {
            cVar = new f0.c(this);
            this.J = cVar;
        } else {
            list = this.b;
            if (list != null) {
                list.unregisterDataSetObserver(cVar);
            }
        }
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.J);
        }
        final androidx.appcompat.widget.b0 obj3 = this.c;
        if (obj3 != null) {
            obj3.setAdapter(this.b);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void r() {
        int i;
        final androidx.appcompat.widget.b0 b0Var = this.c;
        if (b0Var != null) {
            b0Var.setListSelectionHidden(true);
            b0Var.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    androidx.appcompat.widget.b0 s(Context context, boolean z2) {
        b0 b0Var = new b0(context, z2);
        return b0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public View t() {
        return this.K;
    }

    @Override // androidx.appcompat.view.menu.p
    public Object v() {
        if (!b()) {
            return null;
        }
        return this.c.getSelectedItem();
    }

    @Override // androidx.appcompat.view.menu.p
    public long w() {
        if (!b()) {
            return Long.MIN_VALUE;
        }
        return this.c.getSelectedItemId();
    }

    @Override // androidx.appcompat.view.menu.p
    public int x() {
        if (!b()) {
            return -1;
        }
        return this.c.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.view.menu.p
    public View y() {
        if (!b()) {
            return null;
        }
        return this.c.getSelectedView();
    }

    @Override // androidx.appcompat.view.menu.p
    public int z() {
        return this.w;
    }
}
