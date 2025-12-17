package com.yuyakaido.android.cardstackview;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.i.a;

/* loaded from: classes2.dex */
public class g implements a {

    private final com.yuyakaido.android.cardstackview.b a;
    private final int b;
    private final Interpolator c;

    static class a {
    }

    public static class b {

        private com.yuyakaido.android.cardstackview.b a;
        private int b;
        private Interpolator c;
        public b() {
            super();
            this.a = b.Right;
            this.b = normal.duration;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.c = accelerateInterpolator;
        }

        public com.yuyakaido.android.cardstackview.g a() {
            g gVar = new g(this.a, this.b, this.c, 0);
            return gVar;
        }

        public com.yuyakaido.android.cardstackview.g.b b(com.yuyakaido.android.cardstackview.b b) {
            this.a = b;
            return this;
        }

        public com.yuyakaido.android.cardstackview.g.b c(int i) {
            this.b = i;
            return this;
        }

        public com.yuyakaido.android.cardstackview.g.b d(Interpolator interpolator) {
            this.c = interpolator;
            return this;
        }
    }
    private g(com.yuyakaido.android.cardstackview.b b, int i2, Interpolator interpolator3) {
        super();
        this.a = b;
        this.b = i2;
        this.c = interpolator3;
    }

    g(com.yuyakaido.android.cardstackview.b b, int i2, Interpolator interpolator3, com.yuyakaido.android.cardstackview.g.a g$a4) {
        super(b, i2, interpolator3);
    }

    @Override // com.yuyakaido.android.cardstackview.i.a
    public com.yuyakaido.android.cardstackview.b a() {
        return this.a;
    }

    @Override // com.yuyakaido.android.cardstackview.i.a
    public Interpolator b() {
        return this.c;
    }

    @Override // com.yuyakaido.android.cardstackview.i.a
    public int d() {
        return this.b;
    }
}
