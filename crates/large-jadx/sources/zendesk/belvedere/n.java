package zendesk.belvedere;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.x;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.f;
import d.h.l.u;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.b0.b;
import zendesk.belvedere.b0.c;
import zendesk.belvedere.b0.d;
import zendesk.belvedere.b0.e;
import zendesk.belvedere.b0.f;
import zendesk.belvedere.b0.g;
import zendesk.belvedere.b0.h;
import zendesk.belvedere.b0.i;

/* loaded from: classes3.dex */
class n extends PopupWindow implements zendesk.belvedere.k {

    private final zendesk.belvedere.l a;
    private final zendesk.belvedere.f b;
    private final List<Integer> c;
    private zendesk.belvedere.p d;
    private View e;
    private View f;
    private View g;
    private View h;
    private zendesk.belvedere.FloatingActionMenu i;
    private RecyclerView j;
    private Toolbar k;
    private BottomSheetBehavior<View> l;
    private Activity m;

    class a implements View.OnClickListener {

        final boolean a;
        final zendesk.belvedere.n b;
        a(zendesk.belvedere.n n, boolean z2) {
            this.b = n;
            this.a = z2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            int i;
            Object obj2;
            if (!this.a) {
                n.i(this.b).Z(4);
            } else {
                this.b.dismiss();
            }
        }
    }

    class d implements View.OnTouchListener {

        final List a;
        final Activity b;
        final zendesk.belvedere.n c;
        d(zendesk.belvedere.n n, List list2, Activity activity3) {
            this.c = n;
            this.a = list2;
            this.b = activity3;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            View viewById;
            int right;
            int i;
            int i2;
            Activity activity;
            Rect bottom;
            int top;
            int obj8;
            MotionEvent obj9;
            obj8 = (int)obj8;
            int i3 = (int)rawY;
            Iterator iterator = this.a.iterator();
            i = 0;
            i2 = 1;
            for (Integer next : iterator) {
                viewById = this.b.findViewById(next.intValue());
                i = 0;
                i2 = 1;
                bottom = new Rect();
                viewById.getGlobalVisibleRect(bottom);
                if (obj8 >= bottom.left && obj8 <= bottom.right) {
                } else {
                }
                viewById = i;
                if (i3 >= bottom.top && i3 <= bottom.bottom) {
                } else {
                }
                activity = i;
                if (i3 <= bottom.bottom) {
                } else {
                }
                activity = i2;
                if (obj8 <= bottom.right) {
                } else {
                }
                viewById = i2;
            }
            i = i2;
            if (i != 0) {
                this.c.dismiss();
            }
            return i2;
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        final Window a;
        final ValueAnimator b;
        e(zendesk.belvedere.n n, Window window2, ValueAnimator valueAnimator3) {
            this.a = window2;
            this.b = valueAnimator3;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setStatusBarColor((Integer)this.b.getAnimatedValue().intValue());
        }
    }

    class b extends BottomSheetBehavior.f {

        final zendesk.belvedere.n a;
        b(zendesk.belvedere.n n) {
            this.a = n;
            super();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onStateChanged(View view, int i2) {
            int obj1;
            if (i2 != 5) {
            } else {
                this.a.dismiss();
            }
        }
    }

    class c implements zendesk.belvedere.p.d {

        final zendesk.belvedere.n a;
        c(zendesk.belvedere.n n) {
            this.a = n;
            super();
        }

        @Override // zendesk.belvedere.p$d
        public void a(int i) {
            int i2;
            int keyboardHeight;
            int obj3;
            if (i != n.i(this.a).C()) {
                n.i(this.a).V(paddingTop += keyboardHeight);
            }
        }
    }

    private class f extends CoordinatorLayout.c<View> {

        private final boolean a;
        final zendesk.belvedere.n b;
        private f(zendesk.belvedere.n n, boolean z2) {
            this.b = n;
            super();
            this.a = z2;
        }

        f(zendesk.belvedere.n n, boolean z2, zendesk.belvedere.n.a n$a3) {
            super(n, z2);
        }

        private void a(int i, float f2, int i3, View view4) {
            int cmp;
            int i2;
            int obj3;
            int obj5;
            obj3 = (float)i;
            obj3 -= i4;
            obj5 = (float)i3;
            if (Float.compare(obj3, obj5) <= 0) {
                a0.e(this.b.getContentView(), true);
                view4.setAlpha(i5 -= obj5);
                view4.setY(obj3);
            } else {
                a0.e(this.b.getContentView(), false);
            }
            n.n(this.b, f2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            int obj1;
            obj1 = view3.getId() == f.d ? 1 : 0;
            return obj1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            int obj3;
            boolean obj4;
            height -= i2;
            i4 /= obj5;
            a(i, i5, u.C(n.l(this.b)), view2);
            if (this.a) {
                n.m(this.b).h(coordinatorLayout.getHeight(), i, i5);
            }
            return 1;
        }
    }
    private n(Activity activity, View view2, zendesk.belvedere.e e3, zendesk.belvedere.b.c b$c4) {
        int i = -1;
        super(view2, i, i, 0);
        setInputMethodMode(2);
        int i3 = 1;
        setFocusable(i3);
        setTouchable(i3);
        BitmapDrawable bitmapDrawable = new BitmapDrawable();
        setBackgroundDrawable(bitmapDrawable);
        setOutsideTouchable(i3);
        o(view2);
        this.m = activity;
        f obj3 = new f();
        this.b = obj3;
        this.d = e3.E1();
        this.c = c4.e();
        obj3 = new i(view2.getContext(), c4);
        l obj4 = new l(obj3, this, e3);
        this.a = obj4;
        obj4.f();
    }

    static BottomSheetBehavior i(zendesk.belvedere.n n) {
        return n.l;
    }

    static View j(zendesk.belvedere.n n) {
        return n.e;
    }

    static zendesk.belvedere.p k(zendesk.belvedere.n n) {
        return n.d;
    }

    static Toolbar l(zendesk.belvedere.n n) {
        return n.k;
    }

    static zendesk.belvedere.l m(zendesk.belvedere.n n) {
        return n.a;
    }

    static void n(zendesk.belvedere.n n, float f2) {
        n.u(f2);
    }

    private void o(View view) {
        this.e = view.findViewById(f.d);
        this.f = view.findViewById(f.e);
        this.j = (RecyclerView)view.findViewById(f.h);
        this.k = (Toolbar)view.findViewById(f.j);
        this.g = view.findViewById(f.k);
        this.h = view.findViewById(f.i);
        this.i = (FloatingActionMenu)view.findViewById(f.f);
    }

    private void p(boolean z) {
        zendesk.belvedere.n.c cVar;
        int keyboardHeight;
        Object obj5;
        u.s0(this.j, (float)dimensionPixelSize);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.y(this.e);
        this.l = bottomSheetBehavior;
        n.b bVar = new n.b(this);
        bottomSheetBehavior.M(bVar);
        int i2 = 0;
        a0.e(getContentView(), i2);
        int i = 1;
        if (!z) {
            this.l.V(paddingTop += keyboardHeight);
            this.l.Z(4);
            cVar = new n.c(this);
            this.d.setKeyboardHeightListener(cVar);
        } else {
            this.l.Y(i);
            this.l.Z(3);
            p.k(this.m);
        }
        this.j.setClickable(i);
        this.e.setVisibility(i2);
    }

    private void q(Activity activity, List<Integer> list2) {
        n.d dVar = new n.d(this, list2, activity);
        this.f.setOnTouchListener(dVar);
    }

    private void r(zendesk.belvedere.f f) {
        final int i4 = 1;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.e.getContext().getResources().getInteger(g.d), i4);
        this.j.setLayoutManager(staggeredGridLayoutManager);
        this.j.setHasFixedSize(i4);
        this.j.setDrawingCacheEnabled(i4);
        this.j.setDrawingCacheQuality(1048576);
        g gVar = new g();
        gVar.setSupportsChangeAnimations(false);
        this.j.setItemAnimator(gVar);
        this.j.setAdapter(f);
    }

    private void s(boolean z) {
        int sDK_INT;
        int fVar;
        int i;
        boolean obj4;
        this.k.setNavigationIcon(e.e);
        this.k.setNavigationContentDescription(i.m);
        this.k.setBackgroundColor(-1);
        n.a aVar = new n.a(this, z);
        this.k.setNavigationOnClickListener(aVar);
        if (Build.VERSION.SDK_INT < 21) {
            this.h.setVisibility(0);
        }
        android.view.ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if ((CoordinatorLayout.f)layoutParams != null) {
            fVar = new n.f(this, z ^= 1, 0);
            (CoordinatorLayout.f)layoutParams.o(fVar);
        }
    }

    static zendesk.belvedere.n t(Activity activity, ViewGroup viewGroup2, zendesk.belvedere.e e3, zendesk.belvedere.b.c b$c4) {
        final int i2 = 0;
        n nVar = new n(activity, LayoutInflater.from(activity).inflate(h.c, viewGroup2, i2), e3, c4);
        nVar.showAtLocation(viewGroup2, 48, i2, i2);
        return nVar;
    }

    private void u(float f) {
        int object;
        int decorView;
        int eVar;
        int statusBarColor;
        Object[] arr;
        int obj9;
        eVar = a0.a(this.k.getContext(), b.b);
        int i5 = 1;
        final int i6 = 0;
        obj9 = Float.compare(f, i4) == 0 ? i5 : i6;
        Window window = this.m.getWindow();
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            if (obj9 != null) {
                if (window.getStatusBarColor() == eVar) {
                    statusBarColor = new ArgbEvaluator();
                    arr = new Object[2];
                    arr[i6] = Integer.valueOf(eVar);
                    arr[i5] = Integer.valueOf(this.k.getResources().getColor(c.c));
                    object = ValueAnimator.ofObject(statusBarColor, arr);
                    object.setDuration(100);
                    eVar = new n.e(this, window, object);
                    object.addUpdateListener(eVar);
                    object.start();
                }
            } else {
                window.setStatusBarColor(eVar);
            }
        }
        if (sDK_INT >= 23) {
            decorView = window.getDecorView();
            if (obj9 != null) {
                decorView.setSystemUiVisibility(8192);
            } else {
                decorView.setSystemUiVisibility(i6);
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void a(int i) {
        Toast.makeText(this.m, i, 0).show();
    }

    @Override // android.widget.PopupWindow
    public boolean b() {
        boolean inPictureInPictureMode;
        int i;
        Object enabledAccessibilityServiceList;
        String str;
        final int i2 = 1;
        if (Build.VERSION.SDK_INT >= 24 && !this.m.isInMultiWindowMode() && this.m.isInPictureInPictureMode()) {
            if (!this.m.isInMultiWindowMode()) {
                if (this.m.isInPictureInPictureMode()) {
                }
            }
            return i2;
        }
        int i4 = 0;
        i = configuration.keyboard != i2 ? i2 : i4;
        if (i != 0) {
            return i2;
        }
        enabledAccessibilityServiceList = this.m.getSystemService("accessibility");
        enabledAccessibilityServiceList = (AccessibilityManager)enabledAccessibilityServiceList.getEnabledAccessibilityServiceList(47);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.size() > 0) {
            enabledAccessibilityServiceList = enabledAccessibilityServiceList.getEnabledAccessibilityServiceList(47);
            if (enabledAccessibilityServiceList != null) {
                if (enabledAccessibilityServiceList.size() > 0) {
                    return i2;
                }
            }
        }
        return i4;
    }

    @Override // android.widget.PopupWindow
    public void c(boolean z) {
        r(this.b);
        s(z);
        p(z);
        q(this.m, this.c);
    }

    public void d(List<zendesk.belvedere.s> list, List<zendesk.belvedere.s> list2, boolean z3, boolean z4, zendesk.belvedere.f.b f$b5) {
        android.widget.EditText obj4;
        zendesk.belvedere.h.c obj5;
        if (z3 == null) {
            p.o(this.d.getInputTrap());
        }
        obj4 = this.e.getLayoutParams();
        obj4.height = -1;
        this.e.setLayoutParams(obj4);
        if (z4 != null) {
            this.b.f(h.a(b5));
        }
        this.b.g(h.b(list, b5, this.e.getContext()));
        this.b.h(list2);
        this.b.notifyDataSetChanged();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        u(0);
        this.a.e();
    }

    @Override // android.widget.PopupWindow
    public void e(View.OnClickListener view$OnClickListener) {
        int i3;
        int i2;
        int i;
        final zendesk.belvedere.FloatingActionMenu num = this.i;
        if (num != null) {
            num.c(e.g, f.a, i.c, onClickListener);
        }
    }

    @Override // android.widget.PopupWindow
    public void f(zendesk.belvedere.r r, zendesk.belvedere.e e2) {
        r.f(e2);
    }

    @Override // android.widget.PopupWindow
    public void g(int i) {
        int i2;
        Toolbar toolbar;
        Locale default;
        Object[] arr;
        int i3;
        Object obj6;
        if (i > 0) {
            arr = new Object[2];
            this.k.setTitle(String.format(Locale.getDefault(), "%s (%d)", this.m.getString(i.f), Integer.valueOf(i)));
        } else {
            this.k.setTitle(i.f);
        }
    }

    @Override // android.widget.PopupWindow
    public void h(View.OnClickListener view$OnClickListener) {
        int i;
        int i3;
        int i2;
        final zendesk.belvedere.FloatingActionMenu num = this.i;
        if (num != null) {
            num.c(e.f, f.b, i.d, onClickListener);
        }
    }
}
