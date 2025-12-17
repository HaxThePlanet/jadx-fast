package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import d.h.l.u;
import d.h.l.v;

/* loaded from: classes.dex */
class w0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    private static androidx.appcompat.widget.w0 B;
    private static androidx.appcompat.widget.w0 C;
    private boolean A;
    private final View a;
    private final java.lang.CharSequence b;
    private final int c;
    private final Runnable v;
    private final Runnable w;
    private int x;
    private int y;
    private androidx.appcompat.widget.x0 z;

    class a implements Runnable {

        final androidx.appcompat.widget.w0 a;
        a(androidx.appcompat.widget.w0 w0) {
            this.a = w0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g(false);
        }
    }

    class b implements Runnable {

        final androidx.appcompat.widget.w0 a;
        b(androidx.appcompat.widget.w0 w0) {
            this.a = w0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c();
        }
    }
    private w0(View view, java.lang.CharSequence charSequence2) {
        super();
        w0.a aVar = new w0.a(this);
        this.v = aVar;
        w0.b bVar = new w0.b(this);
        this.w = bVar;
        this.a = view;
        this.b = charSequence2;
        this.c = v.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.a.removeCallbacks(this.v);
    }

    private void b() {
        final int i = Integer.MAX_VALUE;
        this.x = i;
        this.y = i;
    }

    private void d() {
        this.a.postDelayed(this.v, (long)longPressTimeout);
    }

    private static void e(androidx.appcompat.widget.w0 w0) {
        final androidx.appcompat.widget.w0 w0Var = w0.B;
        if (w0Var != null) {
            w0Var.a();
        }
        w0.B = w0;
        if (w0 != null) {
            w0.d();
        }
    }

    public static void f(View view, java.lang.CharSequence charSequence2) {
        Object w0Var;
        androidx.appcompat.widget.w0 w0Var2;
        java.lang.CharSequence obj3;
        w0Var = w0.B;
        final int i = 0;
        if (w0Var != null && w0Var.a == view) {
            if (w0Var.a == view) {
                w0.e(i);
            }
        }
        if (TextUtils.isEmpty(charSequence2)) {
            obj3 = w0.C;
            if (obj3 != null && obj3.a == view) {
                if (obj3.a == view) {
                    obj3.c();
                }
            }
            view.setOnLongClickListener(i);
            view.setLongClickable(false);
            view.setOnHoverListener(i);
        } else {
            w0Var2 = new w0(view, charSequence2);
        }
    }

    private boolean h(MotionEvent motionEvent) {
        int i;
        int i2;
        int i3 = (int)f;
        int obj4 = (int)obj4;
        if (Math.abs(i3 - i4) <= this.c && Math.abs(obj4 - i6) <= this.c) {
            if (Math.abs(obj4 - i6) <= this.c) {
                return 0;
            }
        }
        this.x = i3;
        this.y = obj4;
        return 1;
    }

    @Override // android.view.View$OnLongClickListener
    void c() {
        Object str2;
        String str;
        int i = 0;
        if (w0.C == this) {
            w0.C = i;
            androidx.appcompat.widget.x0 x0Var = this.z;
            if (x0Var != null) {
                x0Var.c();
                this.z = i;
                b();
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (w0.B == this) {
            w0.e(i);
        }
        this.a.removeCallbacks(this.w);
    }

    @Override // android.view.View$OnLongClickListener
    void g(boolean z) {
        int i2;
        int i;
        long view;
        int obj8;
        if (!u.Q(this.a)) {
        }
        w0.e(0);
        androidx.appcompat.widget.w0 w0Var = w0.C;
        if (w0Var != null) {
            w0Var.c();
        }
        w0.C = this;
        this.A = z;
        x0 x0Var = new x0(this.a.getContext());
        this.z = x0Var;
        x0Var.e(this.a, this.x, this.y, this.A, this.b);
        this.a.addOnAttachStateChangeListener(this);
        if (this.A) {
            i2 = 2500;
        } else {
            int i4 = 1;
            if (obj8 &= i4 == i4) {
                i = 3000;
                obj8 = ViewConfiguration.getLongPressTimeout();
            } else {
                i = 15000;
                obj8 = ViewConfiguration.getLongPressTimeout();
            }
            i -= view;
        }
        this.a.removeCallbacks(this.w);
        this.a.postDelayed(this.w, i2);
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onHover(View view, MotionEvent motionEvent2) {
        androidx.appcompat.widget.x0 obj3;
        int obj4;
        final int i = 0;
        if (this.z != null && this.A) {
            if (this.A) {
                return i;
            }
        }
        obj3 = this.a.getContext().getSystemService("accessibility");
        if ((AccessibilityManager)obj3.isEnabled() && obj3.isTouchExplorationEnabled()) {
            if (obj3.isTouchExplorationEnabled()) {
                return i;
            }
        }
        obj3 = motionEvent2.getAction();
        if (obj3 != 7) {
            if (obj3 != 10) {
            } else {
                b();
                c();
            }
        } else {
            if (this.a.isEnabled() && this.z == null && h(motionEvent2)) {
                if (this.z == null) {
                    if (h(motionEvent2)) {
                        w0.e(this);
                    }
                }
            }
        }
        return i;
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(View view) {
        this.x = width /= 2;
        this.y = obj2 /= 2;
        int obj2 = 1;
        g(obj2);
        return obj2;
    }

    @Override // android.view.View$OnLongClickListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View$OnLongClickListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
