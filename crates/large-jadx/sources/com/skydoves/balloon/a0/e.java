package com.skydoves.balloon.a0;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class e {

    static final class a implements Runnable {

        final View a;
        final long b;
        a(View view, long l2) {
            this.a = view;
            this.b = l2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean attachedToWindow;
            long l;
            int i2;
            int i;
            float f;
            int height;
            if (this.a.isAttachedToWindow()) {
                this.a.setVisibility(0);
                View view3 = this.a;
                i6 /= 2;
                attachedToWindow = ViewAnimationUtils.createCircularReveal(view3, i4 /= 2, i2, 0, (float)i7);
                attachedToWindow.setDuration(this.b);
                attachedToWindow.start();
            }
        }
    }
    public static final void a(View view, long l2) {
        int sDK_INT;
        n.f(view, "$this$circularRevealed");
        view.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 21) {
            sDK_INT = new e.a(view, l2, obj4);
            view.post(sDK_INT);
        }
    }

    public static final int b(View view, boolean z2) {
        int obj2;
        String obj3;
        n.f(view, "$this$getStatusBarHeight");
        Rect rect = new Rect();
        obj2 = view.getContext();
        if (obj2 instanceof Activity != null && z2 != null) {
            if (z2 != null) {
                obj2 = (Activity)obj2.getWindow();
                n.e(obj2, "context.window");
                obj2.getDecorView().getWindowVisibleDisplayFrame(rect);
                obj2 = rect.top;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public static final Point c(View view) {
        n.f(view, "$this$getViewPointOnScreen");
        int[] iArr = new int[2];
        iArr = new int[]{0, 0};
        view.getLocationOnScreen(iArr);
        Point obj3 = new Point(iArr[0], iArr[1]);
        return obj3;
    }

    public static final void d(View view, boolean z2) {
        int obj2;
        n.f(view, "$this$visible");
        obj2 = z2 ? 0 : 8;
        view.setVisibility(obj2);
    }
}
