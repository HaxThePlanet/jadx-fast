package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class x {

    private final com.google.android.exoplayer2.video.q a;
    private final com.google.android.exoplayer2.video.x.a b;
    private final com.google.android.exoplayer2.video.x.d c = null;
    private boolean d;
    private Surface e;
    private float f = -1f;
    private float g;
    private float h;
    private float i = 1f;
    private long j = -9223372036854775807L;
    private long k = -9223372036854775807L;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;

    private interface a {
        public abstract void a(com.google.android.exoplayer2.video.x.a.a x$a$a);

        public abstract void unregister();
    }

    private static final class d implements Choreographer.FrameCallback, Handler.Callback {

        private static final com.google.android.exoplayer2.video.x.d x;
        public volatile long a = -9223372036854775807L;
        private final Handler b;
        private final HandlerThread c;
        private Choreographer v;
        private int w;
        static {
            x.d dVar = new x.d();
            x.d.x = dVar;
        }

        private d() {
            super();
            long l = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.c = handlerThread;
            handlerThread.start();
            Handler handler = p0.t(handlerThread.getLooper(), this);
            this.b = handler;
            handler.sendEmptyMessage(0);
        }

        private void b() {
            int i;
            final int i3 = 1;
            i2 += i3;
            this.w = i;
            if (i == i3) {
                i = this.v;
                g.e(i);
                (Choreographer)i.postFrameCallback(this);
            }
        }

        private void c() {
            this.v = Choreographer.getInstance();
        }

        public static com.google.android.exoplayer2.video.x.d d() {
            return x.d.x;
        }

        private void f() {
            int i;
            i2--;
            this.w = i;
            if (i == 0) {
                Choreographer choreographer = this.v;
                g.e(choreographer);
                (Choreographer)choreographer.removeFrameCallback(this);
                this.a = -9223372036854775807L;
            }
        }

        @Override // android.view.Choreographer$FrameCallback
        public void a() {
            this.b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer$FrameCallback
        public void doFrame(long l) {
            this.a = l;
            final Choreographer obj3 = this.v;
            g.e(obj3);
            (Choreographer)obj3.postFrameCallbackDelayed(this, 500);
        }

        @Override // android.view.Choreographer$FrameCallback
        public void e() {
            this.b.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer$FrameCallback
        public boolean handleMessage(Message message) {
            int obj3 = message.what;
            final int i = 1;
            if (obj3 != null && obj3 != i && obj3 != 2) {
                if (obj3 != i) {
                    if (obj3 != 2) {
                        return 0;
                    }
                    f();
                    return i;
                }
                b();
                return i;
            }
            c();
            return i;
        }
    }

    private static final class b implements com.google.android.exoplayer2.video.x.a {

        private final WindowManager a;
        private b(WindowManager windowManager) {
            super();
            this.a = windowManager;
        }

        public static com.google.android.exoplayer2.video.x.a b(Context context) {
            com.google.android.exoplayer2.video.x.b bVar;
            final Object obj1 = context.getSystemService("window");
            if ((WindowManager)obj1 != null) {
                bVar = new x.b((WindowManager)obj1);
            } else {
                bVar = 0;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void a(com.google.android.exoplayer2.video.x.a.a x$a$a) {
            a.a(this.a.getDefaultDisplay());
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void unregister() {
        }
    }

    private static final class c implements com.google.android.exoplayer2.video.x.a, DisplayManager.DisplayListener {

        private final DisplayManager a;
        private com.google.android.exoplayer2.video.x.a.a b;
        private c(DisplayManager displayManager) {
            super();
            this.a = displayManager;
        }

        private Display b() {
            return this.a.getDisplay(0);
        }

        public static com.google.android.exoplayer2.video.x.a c(Context context) {
            com.google.android.exoplayer2.video.x.c cVar;
            final Object obj1 = context.getSystemService("display");
            if ((DisplayManager)obj1 != null) {
                cVar = new x.c((DisplayManager)obj1);
            } else {
                cVar = 0;
            }
            return cVar;
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void a(com.google.android.exoplayer2.video.x.a.a x$a$a) {
            this.b = a;
            this.a.registerDisplayListener(this, p0.u());
            a.a(b());
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void onDisplayAdded(int i) {
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void onDisplayChanged(int i) {
            Display obj2;
            final com.google.android.exoplayer2.video.x.a.a aVar = this.b;
            if (aVar != null && i == null) {
                if (i == null) {
                    aVar.a(b());
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void onDisplayRemoved(int i) {
        }

        @Override // com.google.android.exoplayer2.video.x$a
        public void unregister() {
            this.a.unregisterDisplayListener(this);
            this.b = 0;
        }
    }
    public x(Context context) {
        super();
        q qVar = new q();
        this.a = qVar;
        com.google.android.exoplayer2.video.x.a obj3 = x.f(context);
        this.b = obj3;
        if (obj3 != null) {
            obj3 = x.d.d();
        }
        obj3 = 0;
        long l = -9223372036854775807L;
        obj3 = -1082130432;
        obj3 = 1065353216;
    }

    private static boolean b(long l, long l2) {
        int obj0;
        obj0 = Long.compare(obj0, obj2) <= 0 ? 1 : 0;
        return obj0;
    }

    private void c() {
        int i2;
        int cmp;
        int i;
        i2 = this.e;
        if (p0.a >= 30 && i2 != null) {
            i2 = this.e;
            if (i2 != null) {
                i = 0;
                if (Float.compare(f, i) == 0) {
                } else {
                    this.h = i;
                    x.q(i2, i);
                }
            }
        }
    }

    private static long d(long l, long l2, long l3) {
        int i;
        int obj6;
        int obj8;
        l3 += i4;
        if (Long.compare(l, obj6) <= 0) {
            obj8 = obj6 - obj8;
        } else {
            obj6 = obj8;
            obj8 = i;
        }
        if (Long.compare(i5, obj4) < 0) {
        } else {
            obj6 = obj8;
        }
        return obj6;
    }

    public static void e(com.google.android.exoplayer2.video.x x, Display display2) {
        x.r(display2);
    }

    private static com.google.android.exoplayer2.video.x.a f(Context context) {
        int i;
        int i2;
        int i3;
        Context obj3;
        i = 0;
        obj3 = context.getApplicationContext();
        if (context != null && p0.a >= 17) {
            obj3 = context.getApplicationContext();
            if (p0.a >= 17) {
                i = x.c.c(obj3);
            }
            if (i == 0) {
                i = x.b.b(obj3);
            }
        }
        return i;
    }

    private void p() {
        this.l = 0;
        int i2 = -1;
        this.o = i2;
        this.m = i2;
    }

    private static void q(Surface surface, float f2) {
        int i;
        Throwable obj1;
        int obj2;
        i = Float.compare(f2, i2) == 0 ? 0 : 1;
        surface.setFrameRate(f2, i);
    }

    private void r(Display display) {
        int i2;
        int i;
        float obj5;
        if (display != null) {
            long l = (long)i4;
            this.j = l;
            this.k = i3 /= i;
        } else {
            v.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            i2 = -9223372036854775807L;
            this.j = i2;
            this.k = i2;
        }
    }

    private void s() {
        int i3;
        int cmp3;
        int i2;
        int i4;
        boolean cmp2;
        float cmp;
        long l;
        int cmp4;
        int i5;
        int i;
        cmp3 = 30;
        if (p0.a >= cmp3) {
            if (this.e == null) {
            } else {
                if (this.a.e()) {
                    i3 = this.a.b();
                } else {
                    i3 = this.f;
                }
                cmp = this.g;
                if (Float.compare(i3, cmp) == 0) {
                }
                l = -1082130432;
                cmp4 = Float.compare(i3, l);
                i5 = 0;
                if (cmp4 != 0 && Float.compare(cmp, l) != 0) {
                    if (Float.compare(cmp, l) != 0) {
                        if (this.a.e() && Long.compare(l2, l) >= 0) {
                            i2 = Long.compare(l2, l) >= 0 ? i : i5;
                        } else {
                        }
                        i4 = i2 != 0 ? 1017370378 : 1065353216;
                        if (Float.compare(cmp, i4) >= 0) {
                        } else {
                            i = i5;
                        }
                    } else {
                    }
                } else {
                }
                if (i != 0) {
                    this.g = i3;
                    t(i5);
                }
            }
        }
    }

    private void t(boolean z) {
        int i2;
        int i;
        boolean z2;
        int cmp;
        int obj5;
        if (p0.a >= 30) {
            i2 = this.e;
            if (i2 == null) {
            } else {
                i = 0;
                z2 = this.g;
                if (this.d && Float.compare(z2, i3) != 0) {
                    z2 = this.g;
                    if (Float.compare(z2, i3) != 0) {
                        f *= z2;
                    }
                }
                if (z == 0 && Float.compare(obj5, i) == 0) {
                    if (Float.compare(obj5, i) == 0) {
                    }
                }
                this.h = i;
                x.q(i2, i);
            }
        }
    }

    public long a(long l) {
        int cmp;
        float f;
        int i;
        int i2;
        int i3;
        long l2;
        long obj12;
        if (Long.compare(l3, i) != 0 && this.a.e()) {
            if (this.a.e()) {
                l7 += l6;
                if (x.b(l, obj12)) {
                    i2 = i;
                } else {
                    p();
                    i2 = l;
                }
            } else {
            }
        } else {
        }
        this.m = this.l;
        this.n = i2;
        com.google.android.exoplayer2.video.x.d obj11 = this.c;
        if (obj11 != null) {
            i = -9223372036854775807L;
            if (Long.compare(cmp, i) == 0) {
            } else {
                long l9 = obj11.a;
                if (Long.compare(l9, i) == 0) {
                    return i2;
                }
            }
            return obj11 -= l4;
        }
        return i2;
    }

    public void g() {
        Object aVar;
        aVar = this.b;
        if (aVar != null) {
            aVar.unregister();
            aVar = this.c;
            g.e(aVar);
            (x.d)aVar.e();
        }
    }

    public void h() {
        com.google.android.exoplayer2.video.x.a aVar;
        com.google.android.exoplayer2.video.a aVar2;
        if (this.b != null) {
            com.google.android.exoplayer2.video.x.d dVar = this.c;
            g.e(dVar);
            (x.d)dVar.a();
            aVar2 = new a(this);
            this.b.a(aVar2);
        }
    }

    public void i(float f) {
        this.f = f;
        this.a.g();
        s();
    }

    public void j(long l) {
        long l2;
        l2 = this.m;
        if (Long.compare(l2, i3) != 0) {
            this.o = l2;
            this.p = this.n;
        }
        this.l = l3 += i4;
        this.a.f(l *= i2);
        s();
    }

    public void k(float f) {
        this.i = f;
        p();
        t(false);
    }

    public void l() {
        p();
    }

    public void m() {
        this.d = true;
        p();
        t(false);
    }

    public void n() {
        this.d = false;
        c();
    }

    public void o(Surface surface) {
        Object obj2;
        if (surface instanceof p) {
            obj2 = 0;
        }
        if (this.e == obj2) {
        }
        c();
        this.e = obj2;
        t(true);
    }
}
