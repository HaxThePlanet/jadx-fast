package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.h.l.a;
import d.h.l.d0;
import d.h.l.e0.c;
import d.h.l.q;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.k;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public class a extends h {

    private com.google.android.material.bottomsheet.BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private com.google.android.material.bottomsheet.BottomSheetBehavior.f bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private com.google.android.material.bottomsheet.BottomSheetBehavior.f edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    class b implements View.OnClickListener {

        final com.google.android.material.bottomsheet.a a;
        b(com.google.android.material.bottomsheet.a a) {
            this.a = a;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            com.google.android.material.bottomsheet.a obj2;
            obj2 = this.a;
            if (obj2.cancelable && obj2.isShowing() && this.a.shouldWindowCloseOnTouchOutside()) {
                if (obj2.isShowing()) {
                    if (this.a.shouldWindowCloseOnTouchOutside()) {
                        this.a.cancel();
                    }
                }
            }
        }
    }

    class d implements View.OnTouchListener {
        d(com.google.android.material.bottomsheet.a a) {
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            return 1;
        }
    }

    class a implements q {

        final com.google.android.material.bottomsheet.a a;
        a(com.google.android.material.bottomsheet.a a) {
            this.a = a;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            com.google.android.material.bottomsheet.BottomSheetBehavior.f fVar;
            FrameLayout frameLayout;
            int i;
            Object obj4;
            if (a.access$000(this.a) != null) {
                a.access$100(this.a).I(a.access$000(this.a));
            }
            if (d02 != null) {
                obj4 = this.a;
                a.f fVar2 = new a.f(a.access$200(obj4), d02, 0);
                a.access$002(obj4, fVar2);
                a.access$100(this.a).o(a.access$000(this.a));
            }
            return d02;
        }
    }

    class c extends a {

        final com.google.android.material.bottomsheet.a d;
        c(com.google.android.material.bottomsheet.a a) {
            this.d = a;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            int obj1;
            super.g(view, c2);
            if (obj1.cancelable) {
                c2.a(1048576);
                c2.c0(true);
            } else {
                c2.c0(false);
            }
        }

        @Override // d.h.l.a
        public boolean j(View view, int i2, Bundle bundle3) {
            int i;
            boolean cancelable;
            i = this.d;
            if (i2 == 1048576 && i.cancelable) {
                i = this.d;
                if (i.cancelable) {
                    i.cancel();
                    return 1;
                }
            }
            return super.j(view, i2, bundle3);
        }
    }

    class e extends com.google.android.material.bottomsheet.BottomSheetBehavior.f {

        final com.google.android.material.bottomsheet.a a;
        e(com.google.android.material.bottomsheet.a a) {
            this.a = a;
            super();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onStateChanged(View view, int i2) {
            int obj1;
            if (i2 == 5) {
                this.a.cancel();
            }
        }
    }

    private static class f extends com.google.android.material.bottomsheet.BottomSheetBehavior.f {

        private final boolean a;
        private final boolean b;
        private final d0 c;
        private f(View view, d0 d02) {
            ColorStateList list;
            View obj2;
            int obj3;
            super();
            this.c = d02;
            if (Build.VERSION.SDK_INT >= 23 && obj3 &= 8192 != 0) {
                obj3 = obj3 &= 8192 != 0 ? 1 : 0;
            } else {
            }
            this.b = obj3;
            g gVar = BottomSheetBehavior.y(view).B();
            if (gVar != null) {
                list = gVar.x();
            } else {
                list = u.s(view);
            }
            if (list != null) {
                this.a = a.f(list.getDefaultColor());
            } else {
                if (background instanceof ColorDrawable) {
                    this.a = a.f((ColorDrawable)view.getBackground().getColor());
                } else {
                    this.a = obj3;
                }
            }
        }

        f(View view, d0 d02, com.google.android.material.bottomsheet.a.a a$a3) {
            super(view, d02);
        }

        private void a(View view) {
            int paddingLeft;
            int i;
            int paddingRight;
            int paddingBottom;
            if (view.getTop() < this.c.l()) {
                a.setLightStatusBar(view, this.a);
                view.setPadding(view.getPaddingLeft(), i2 -= top2, view.getPaddingRight(), view.getPaddingBottom());
            } else {
                if (view.getTop() != 0) {
                    a.setLightStatusBar(view, this.b);
                    view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
                }
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onSlide(View view, float f2) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onStateChanged(View view, int i2) {
            a(view);
        }
    }
    public a(Context context) {
        final int i = 0;
        super(context, i);
        int[] iArr = new int[1];
        iArr[i] = b.v;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(iArr).getBoolean(i, i);
    }

    public a(Context context, int i2) {
        super(context, a.getThemeResId(context, i2));
        int obj3 = 1;
        this.cancelable = obj3;
        this.canceledOnTouchOutside = obj3;
        a.e obj4 = new a.e(this);
        this.bottomSheetCallback = obj4;
        supportRequestWindowFeature(obj3);
        obj3 = new int[obj3];
        final int i3 = 0;
        obj3[i3] = b.v;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(obj3).getBoolean(i3, i3);
    }

    protected a(Context context, boolean z2, DialogInterface.OnCancelListener dialogInterface$OnCancelListener3) {
        super(context, z2, onCancelListener3);
        int obj2 = 1;
        this.cancelable = obj2;
        this.canceledOnTouchOutside = obj2;
        a.e obj4 = new a.e(this);
        this.bottomSheetCallback = obj4;
        supportRequestWindowFeature(obj2);
        this.cancelable = z2;
        obj2 = new int[obj2];
        final int i = 0;
        obj2[i] = b.v;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(obj2).getBoolean(i, i);
    }

    static com.google.android.material.bottomsheet.BottomSheetBehavior.f access$000(com.google.android.material.bottomsheet.a a) {
        return a.edgeToEdgeCallback;
    }

    static com.google.android.material.bottomsheet.BottomSheetBehavior.f access$002(com.google.android.material.bottomsheet.a a, com.google.android.material.bottomsheet.BottomSheetBehavior.f bottomSheetBehavior$f2) {
        a.edgeToEdgeCallback = f2;
        return f2;
    }

    static com.google.android.material.bottomsheet.BottomSheetBehavior access$100(com.google.android.material.bottomsheet.a a) {
        return a.behavior;
    }

    static FrameLayout access$200(com.google.android.material.bottomsheet.a a) {
        return a.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        Object container;
        boolean cancelable;
        int i;
        if (this.container == null) {
            View inflate = View.inflate(getContext(), h.b, 0);
            this.container = (FrameLayout)inflate;
            this.coordinator = (CoordinatorLayout)inflate.findViewById(f.d);
            View viewById2 = this.container.findViewById(f.e);
            this.bottomSheet = (FrameLayout)viewById2;
            com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.y(viewById2);
            this.behavior = bottomSheetBehavior;
            bottomSheetBehavior.o(this.bottomSheetCallback);
            this.behavior.S(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(Context context, int i2) {
        int i3;
        int i;
        boolean obj2;
        int obj3;
        if (i2 == 0) {
            obj3 = new TypedValue();
            obj3 = context.getTheme().resolveAttribute(b.f, obj3, true) ? obj3.resourceId : k.f;
        }
        return obj3;
    }

    public static void setLightStatusBar(View view, boolean z2) {
        int systemUiVisibility;
        int obj3;
        if (Build.VERSION.SDK_INT >= 23) {
            systemUiVisibility = view.getSystemUiVisibility();
            obj3 = z2 != 0 ? systemUiVisibility | 8192 : systemUiVisibility & -8193;
            view.setSystemUiVisibility(obj3);
        }
    }

    private View wrapInBottomSheet(int i, View view2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        int aVar;
        boolean obj3;
        View obj4;
        ensureContainerAndBehavior();
        View viewById = this.container.findViewById(f.d);
        if (i != 0 && view2 == null) {
            if (view2 == null) {
                obj4 = getLayoutInflater().inflate(i, (CoordinatorLayout)viewById, false);
            }
        }
        if (this.edgeToEdgeEnabled) {
            aVar = new a.a(this);
            u.x0(this.bottomSheet, aVar);
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams3 == null) {
            this.bottomSheet.addView(obj4);
        } else {
            this.bottomSheet.addView(obj4, layoutParams3);
        }
        obj4 = new a.b(this);
        viewById.findViewById(f.j0).setOnClickListener(obj4);
        obj4 = new a.c(this);
        u.l0(this.bottomSheet, obj4);
        obj4 = new a.d(this);
        this.bottomSheet.setOnTouchListener(obj4);
        return this.container;
    }

    @Override // androidx.appcompat.app.h
    public void cancel() {
        int dismissWithAnimation;
        int i;
        final com.google.android.material.bottomsheet.BottomSheetBehavior behavior = getBehavior();
        if (this.dismissWithAnimation) {
            i = 5;
            if (behavior.D() == i) {
                super.cancel();
            } else {
                behavior.Z(i);
            }
        } else {
        }
    }

    public com.google.android.material.bottomsheet.BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    @Override // androidx.appcompat.app.h
    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    @Override // androidx.appcompat.app.h
    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // androidx.appcompat.app.h
    public void onAttachedToWindow() {
        Object decorView;
        int sDK_INT;
        boolean edgeToEdgeEnabled;
        int coordinator;
        int i;
        super.onAttachedToWindow();
        decorView = getWindow();
        if (decorView != null && Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.edgeToEdgeEnabled && Color.alpha(decorView.getNavigationBarColor()) < 255) {
                    sDK_INT = Color.alpha(decorView.getNavigationBarColor()) < 255 ? 1 : 0;
                } else {
                }
                FrameLayout container = this.container;
                if (container != null) {
                    container.setFitsSystemWindows(sDK_INT ^ 1);
                }
                coordinator = this.coordinator;
                if (coordinator != null) {
                    coordinator.setFitsSystemWindows(sDK_INT ^ 1);
                }
                if (sDK_INT != 0) {
                    decorView.getDecorView().setSystemUiVisibility(768);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.h
    protected void onCreate(Bundle bundle) {
        int sDK_INT;
        int i2;
        int i;
        super.onCreate(bundle);
        final Window obj3 = getWindow();
        sDK_INT = Build.VERSION.SDK_INT;
        obj3.setStatusBarColor(0);
        obj3.addFlags(Integer.MIN_VALUE);
        if (obj3 != null && sDK_INT >= 21 && sDK_INT < 23) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                obj3.setStatusBarColor(0);
                obj3.addFlags(Integer.MIN_VALUE);
                if (sDK_INT < 23) {
                    obj3.addFlags(67108864);
                }
            }
            i2 = -1;
            obj3.setLayout(i2, i2);
        }
    }

    @Override // androidx.appcompat.app.h
    protected void onStart() {
        com.google.android.material.bottomsheet.BottomSheetBehavior behavior;
        int i;
        super.onStart();
        behavior = this.behavior;
        if (behavior != null && behavior.D() == 5) {
            if (behavior.D() == 5) {
                this.behavior.Z(4);
            }
        }
    }

    @Override // androidx.appcompat.app.h
    void removeDefaultCallback() {
        this.behavior.I(this.bottomSheetCallback);
    }

    @Override // androidx.appcompat.app.h
    public void setCancelable(boolean z) {
        boolean cancelable;
        super.setCancelable(z);
        this.cancelable = z;
        cancelable = this.behavior;
        if (this.cancelable != z && cancelable != null) {
            this.cancelable = z;
            cancelable = this.behavior;
            if (cancelable != null) {
                cancelable.S(z);
            }
        }
    }

    @Override // androidx.appcompat.app.h
    public void setCanceledOnTouchOutside(boolean z) {
        boolean cancelable;
        super.setCanceledOnTouchOutside(z);
        final int i = 1;
        if (z && !this.cancelable) {
            if (!this.cancelable) {
                this.cancelable = i;
            }
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = i;
    }

    @Override // androidx.appcompat.app.h
    public void setContentView(int i) {
        final int i2 = 0;
        super.setContentView(wrapInBottomSheet(i, i2, i2));
    }

    @Override // androidx.appcompat.app.h
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, 0));
    }

    @Override // androidx.appcompat.app.h
    public void setContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams2));
    }

    @Override // androidx.appcompat.app.h
    public void setDismissWithAnimation(boolean z) {
        this.dismissWithAnimation = z;
    }

    @Override // androidx.appcompat.app.h
    boolean shouldWindowCloseOnTouchOutside() {
        boolean canceledOnTouchOutsideSet;
        int i3;
        boolean boolean;
        int i;
        int i2;
        if (this.canceledOnTouchOutsideSet == null) {
            i3 = 1;
            int[] iArr = new int[i3];
            i2 = 0;
            iArr[i2] = 16843611;
            canceledOnTouchOutsideSet = getContext().obtainStyledAttributes(iArr);
            this.canceledOnTouchOutside = canceledOnTouchOutsideSet.getBoolean(i2, i3);
            canceledOnTouchOutsideSet.recycle();
            this.canceledOnTouchOutsideSet = i3;
        }
        return this.canceledOnTouchOutside;
    }
}
