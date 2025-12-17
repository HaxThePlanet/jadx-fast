package com.yuyakaido.android.cardstackview;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.i.a;

/* loaded from: classes2.dex */
public class e implements a {

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
            this.a = b.Bottom;
            this.b = normal.duration;
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            this.c = decelerateInterpolator;
        }

        public com.yuyakaido.android.cardstackview.e a() {
            e eVar = new e(this.a, this.b, this.c, 0);
            return eVar;
        }
    }
    private e(com.yuyakaido.android.cardstackview.b b, int i2, Interpolator interpolator3) {
        super();
        this.a = b;
        this.b = i2;
        this.c = interpolator3;
    }

    e(com.yuyakaido.android.cardstackview.b b, int i2, Interpolator interpolator3, com.yuyakaido.android.cardstackview.e.a e$a4) {
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
