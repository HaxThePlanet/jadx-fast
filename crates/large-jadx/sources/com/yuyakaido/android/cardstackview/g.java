package com.yuyakaido.android.cardstackview;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.i.a;

/* compiled from: SwipeAnimationSetting.java */
/* loaded from: classes2.dex */
public class g implements a {

    private final b a;
    private final int b;
    private final Interpolator c;

    static class a {
    }

    public static class b {

        private b a;
        private int b;
        private Interpolator c = new AccelerateInterpolator();
        public b() {
            super();
            this.a = b.Right;
            this.b = c.Normal.duration;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        }

        public g a() {
            return new g(this.a, this.b, this.c, null);
        }

        public g.b b(b bVar) {
            this.a = bVar;
            return this;
        }

        public g.b c(int i) {
            this.b = i;
            return this;
        }

        public g.b d(Interpolator interpolator) {
            this.c = interpolator;
            return this;
        }
    }
    /* synthetic */ g(b bVar, int i, Interpolator interpolator, g.a aVar) {
        this(bVar, i, interpolator);
    }

    public b a() {
        return this.a;
    }

    public Interpolator b() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    private g(b bVar, int i, Interpolator interpolator) {
        super();
        this.a = bVar;
        this.b = i;
        this.c = interpolator;
    }
}
