package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import d.h.l.d0;
import d.h.l.q;
import d.h.l.u;

/* loaded from: classes2.dex */
public class n {

    static class a implements Runnable {

        final View a;
        a(View view) {
            this.a = view;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            (InputMethodManager)this.a.getContext().getSystemService("input_method").showSoftInput(this.a, 1);
        }
    }

    static class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            u.i0(view);
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface d {
        public abstract d0 a(View view, d0 d02, com.google.android.material.internal.n.e n$e3);
    }

    public static class e {

        public int a;
        public int b;
        public int c;
        public int d;
        public e(int i, int i2, int i3, int i4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public e(com.google.android.material.internal.n.e n$e) {
            super();
            this.a = e.a;
            this.b = e.b;
            this.c = e.c;
            this.d = e.d;
        }

        public void a(View view) {
            u.y0(view, this.a, this.b, this.c, this.d);
        }
    }

    static class b implements q {

        final com.google.android.material.internal.n.d a;
        final com.google.android.material.internal.n.e b;
        b(com.google.android.material.internal.n.d n$d, com.google.android.material.internal.n.e n$e2) {
            this.a = d;
            this.b = e2;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            n.e eVar = new n.e(this.b);
            return this.a.a(view, d02, eVar);
        }
    }
    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener2) {
        ViewTreeObserver obj0;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener2);
        }
    }

    public static void b(View view, com.google.android.material.internal.n.d n$d2) {
        n.e eVar = new n.e(u.G(view), view.getPaddingTop(), u.F(view), view.getPaddingBottom());
        n.b bVar = new n.b(d2, eVar);
        u.x0(view, bVar);
        n.i(view);
    }

    public static float c(Context context, int i2) {
        return TypedValue.applyDimension(1, (float)i2, context.getResources().getDisplayMetrics());
    }

    public static float d(View view) {
        int i;
        float f;
        ViewParent obj2;
        obj2 = view.getParent();
        i = 0;
        while (obj2 instanceof View != null) {
            i += f;
            obj2 = obj2.getParent();
        }
        return i;
    }

    public static boolean e(View view) {
        int i;
        if (u.B(view) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public static PorterDuff.Mode f(int i, PorterDuff.Mode porterDuff$Mode2) {
        if (i != 3 && i != 5 && i != 9) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode2;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void g(View view, ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener2) {
        ViewTreeObserver obj0;
        if (view != null) {
            n.h(view.getViewTreeObserver(), onGlobalLayoutListener2);
        }
    }

    public static void h(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener2) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener2);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener2);
        }
    }

    public static void i(View view) {
        boolean cVar;
        if (u.Q(view)) {
            u.i0(view);
        } else {
            cVar = new n.c();
            view.addOnAttachStateChangeListener(cVar);
        }
    }

    public static void j(View view) {
        view.requestFocus();
        n.a aVar = new n.a(view);
        view.post(aVar);
    }
}
