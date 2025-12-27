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

/* compiled from: ViewExtension.kt */
/* loaded from: classes2.dex */
public final class e {

    static final class a implements Runnable {

        final /* synthetic */ View a;
        final /* synthetic */ long b;
        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.isAttachedToWindow()) {
                this.a.setVisibility(0);
                i = (this.a.getTop() + this.a.getBottom()) / 2;
                float f = 0.0f;
                f2 = (float)(Math.max(this.a.getWidth(), this.a.getHeight()));
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(this.a, (this.a.getLeft() + this.a.getRight()) / 2, i, f, f2);
                circularReveal.setDuration(this.b);
                circularReveal.start();
            }
        }

        a(View view, long j) {
            this.a = view;
            this.b = j;
            super();
        }
    }
    public static final /* synthetic */ void a(View view, long j) {
        n.f(view, "$this$circularRevealed");
        view.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 21) {
            view.post(new e.a(view, j, r4));
        }
    }

    public static final /* synthetic */ int b(View view, boolean z) {
        int top2 = 0;
        n.f(view, "$this$getStatusBarHeight");
        Rect rect = new Rect();
        android.content.Context context = view.getContext();
        if (!(context instanceof Activity) || !z) {
            top2 = 0;
        } else {
            Window window = context.getWindow();
            str = "context.window";
            n.e(window, str);
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        return top2;
    }

    public static final /* synthetic */ Point c(View view) {
        n.f(view, "$this$getViewPointOnScreen");
        int[] iArr = new int[] {0, 0};
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final /* synthetic */ void d(View view, boolean z) {
        int i = 0;
        n.f(view, "$this$visible");
        z = z ? 0 : 8;
        view.setVisibility((z ? 0 : 8));
    }
}
