package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;

/* loaded from: classes2.dex */
public interface y {

    public interface b {
        public abstract void a(com.google.android.exoplayer2.source.y y, g2 g22);
    }

    public static final class a extends com.google.android.exoplayer2.source.x {
        public a(com.google.android.exoplayer2.source.x x) {
            super(x);
        }

        public a(Object object) {
            super(object);
        }

        public a(Object object, int i2, int i3, long l4) {
            super(object, i2, i3, l4, obj5);
        }

        public a(Object object, long l2, int i3) {
            super(object, l2, i3, obj4);
        }

        @Override // com.google.android.exoplayer2.source.x
        public com.google.android.exoplayer2.source.y.a c(Object object) {
            y.a aVar = new y.a(super.a(object));
            return aVar;
        }
    }
    public abstract com.google.android.exoplayer2.source.w a(com.google.android.exoplayer2.source.y.a y$a, f f2, long l3);

    public abstract void b(com.google.android.exoplayer2.source.y.b y$b);

    public abstract void d(Handler handler, com.google.android.exoplayer2.source.z z2);

    public abstract void e(com.google.android.exoplayer2.source.z z);

    public abstract void f(com.google.android.exoplayer2.source.y.b y$b);

    public abstract m1 g();

    public abstract void h(Handler handler, u u2);

    public abstract void i(u u);

    public abstract void j();

    public boolean k() {
        return 1;
    }

    public abstract void l(com.google.android.exoplayer2.source.w w);

    public g2 m() {
        return null;
    }

    public abstract void n(com.google.android.exoplayer2.source.y.b y$b, b0 b02);

    public abstract void o(com.google.android.exoplayer2.source.y.b y$b);
}
