package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class p extends Surface {

    private static int v;
    private static boolean w;
    public final boolean a;
    private final com.google.android.exoplayer2.video.p.b b;
    private boolean c;

    static class a {
    }

    private static class b extends HandlerThread implements Handler.Callback {

        private EGLSurfaceTexture a;
        private Handler b;
        private Error c;
        private RuntimeException v;
        private com.google.android.exoplayer2.video.p w;
        public b() {
            super("ExoPlayer:DummySurface");
        }

        private void b(int i) {
            int obj4;
            g.e(this.a);
            this.a.h(i);
            obj4 = i != 0 ? 1 : 0;
            p pVar = new p(this, this.a.g(), obj4, 0);
            this.w = pVar;
        }

        private void d() {
            g.e(this.a);
            this.a.i();
        }

        @Override // android.os.HandlerThread
        public com.google.android.exoplayer2.video.p a(int i) {
            int i2;
            Message obj4;
            start();
            Handler handler = new Handler(getLooper(), this);
            this.b = handler;
            EGLSurfaceTexture eGLSurfaceTexture = new EGLSurfaceTexture(this.b);
            this.a = eGLSurfaceTexture;
            this.b.obtainMessage(1, i, 0).sendToTarget();
            synchronized (this) {
                while (this.w == null) {
                    if (this.v == null) {
                    }
                    if (this.c == null) {
                    }
                    wait();
                }
                if (i2 != 0) {
                }
                obj4 = this.v;
                if (obj4 != null) {
                } else {
                    obj4 = this.c;
                    if (obj4 != null) {
                    } else {
                        obj4 = this.w;
                        g.e(obj4);
                        return (p)obj4;
                    }
                    throw obj4;
                }
                throw obj4;
            }
            Thread.currentThread().interrupt();
        }

        @Override // android.os.HandlerThread
        public void c() {
            g.e(this.b);
            this.b.sendEmptyMessage(2);
        }

        @Override // android.os.HandlerThread
        public boolean handleMessage(Message message) {
            int what;
            String str;
            int obj4;
            what = message.what;
            final int i = 1;
            if (what != i && what != 2) {
                if (what != 2) {
                    return i;
                }
                d();
                quit();
                return i;
            }
            b(message.arg1);
            notify();
            synchronized (this) {
                b(message.arg1);
                notify();
            }
            return i;
        }
    }
    private p(com.google.android.exoplayer2.video.p.b p$b, SurfaceTexture surfaceTexture2, boolean z3) {
        super(surfaceTexture2);
        this.b = b;
        this.a = z3;
    }

    p(com.google.android.exoplayer2.video.p.b p$b, SurfaceTexture surfaceTexture2, boolean z3, com.google.android.exoplayer2.video.p.a p$a4) {
        super(b, surfaceTexture2, z3);
    }

    private static int a(Context context) {
        if (r.h(context) && r.i()) {
            if (r.i()) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static boolean b(Context context) {
        int i;
        Context obj3;
        final Class<com.google.android.exoplayer2.video.p> obj = p.class;
        synchronized (obj) {
            p.v = p.a(context);
            p.w = true;
            if (p.v != 0) {
                try {
                    i = 0;
                    return i;
                    throw context;
                }
            } else {
            }
        }
    }

    public static com.google.android.exoplayer2.video.p c(Context context, boolean z2) {
        int i;
        int obj1;
        if (z2) {
            if (p.b(context)) {
                obj1 = 1;
            } else {
                obj1 = i;
            }
        } else {
        }
        g.f(obj1);
        obj1 = new p.b();
        if (z2) {
            i = p.v;
        }
        return obj1.a(i);
    }

    @Override // android.view.Surface
    public void release() {
        boolean z;
        super.release();
        final com.google.android.exoplayer2.video.p.b bVar = this.b;
        synchronized (bVar) {
            this.b.c();
            this.c = true;
        }
    }
}
