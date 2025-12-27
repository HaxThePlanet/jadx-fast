package com.yuyakaido.android.cardstackview;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.yuyakaido.android.cardstackview.i.a;

/* compiled from: RewindAnimationSetting.java */
/* loaded from: classes2.dex */
public class e implements a {

    private final b a;
    private final int b;
    private final Interpolator c;

    static class a {
    }

    public static class b {

        private b a;
        private int b;
        private Interpolator c = new DecelerateInterpolator();
        public b() {
            super();
            this.a = b.Bottom;
            this.b = c.Normal.duration;
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        }

        public e a() {
            return new e(this.a, this.b, this.c, null);
        }
    }
    /* synthetic */ e(b bVar, int i, Interpolator interpolator, e.a aVar) {
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

    private e(b bVar, int i, Interpolator interpolator) {
        super();
        this.a = bVar;
        this.b = i;
        this.c = interpolator;
    }
}
