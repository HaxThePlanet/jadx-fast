package com.skydoves.balloon;

import android.view.View;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class g {

    public static final class a implements Runnable {

        final View a;
        final com.skydoves.balloon.Balloon b;
        final int c;
        final int v;
        public a(View view, com.skydoves.balloon.Balloon balloon2, int i3, int i4) {
            this.a = view;
            this.b = balloon2;
            this.c = i3;
            this.v = i4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.w0(this.a, this.c, this.v);
        }
    }

    public static final class b implements Runnable {

        final View a;
        final com.skydoves.balloon.Balloon b;
        final int c;
        final int v;
        public b(View view, com.skydoves.balloon.Balloon balloon2, int i3, int i4) {
            this.a = view;
            this.b = balloon2;
            this.c = i3;
            this.v = i4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.x0(this.a, this.c, this.v);
        }
    }
    public static final void a(View view, com.skydoves.balloon.Balloon balloon2, int i3, int i4) {
        n.f(view, "$this$showAlignBottom");
        n.f(balloon2, "balloon");
        g.a aVar = new g.a(view, balloon2, i3, i4);
        view.post(aVar);
    }

    public static final void b(View view, com.skydoves.balloon.Balloon balloon2, int i3, int i4) {
        n.f(view, "$this$showAlignTop");
        n.f(balloon2, "balloon");
        g.b bVar = new g.b(view, balloon2, i3, i4);
        view.post(bVar);
    }
}
