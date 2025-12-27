package com.skydoves.balloon;

import android.view.View;
import kotlin.d0.d.n;

/* compiled from: BalloonExtension.kt */
/* loaded from: classes2.dex */
public final class g {

    public static final class a implements Runnable {

        final /* synthetic */ View a;
        final /* synthetic */ Balloon b;
        final /* synthetic */ int c;
        final /* synthetic */ int v;
        @Override // java.lang.Runnable
        public final void run() {
            this.b.w0(this.a, this.c, this.v);
        }

        public a(View view, Balloon balloon, int i, int i2) {
            this.a = view;
            this.b = balloon;
            this.c = i;
            this.v = i2;
            super();
        }
    }

    public static final class b implements Runnable {

        final /* synthetic */ View a;
        final /* synthetic */ Balloon b;
        final /* synthetic */ int c;
        final /* synthetic */ int v;
        @Override // java.lang.Runnable
        public final void run() {
            this.b.x0(this.a, this.c, this.v);
        }

        public b(View view, Balloon balloon, int i, int i2) {
            this.a = view;
            this.b = balloon;
            this.c = i;
            this.v = i2;
            super();
        }
    }
    public static final void a(View view, Balloon balloon, int i, int i2) {
        n.f(view, "$this$showAlignBottom");
        n.f(balloon, "balloon");
        view.post(new g.a(view, balloon, i, i2));
    }

    public static final void b(View view, Balloon balloon, int i, int i2) {
        n.f(view, "$this$showAlignTop");
        n.f(balloon, "balloon");
        view.post(new g.b(view, balloon, i, i2));
    }
}
