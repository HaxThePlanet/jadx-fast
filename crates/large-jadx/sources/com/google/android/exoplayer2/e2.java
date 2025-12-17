package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.audio.p;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.audio.s;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.k2.b;
import com.google.android.exoplayer2.k2.c;
import com.google.android.exoplayer2.l2.g;
import com.google.android.exoplayer2.l2.m;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.e;
import com.google.android.exoplayer2.n2.f;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.n2.n;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.a0;
import com.google.android.exoplayer2.video.b0.d;
import com.google.android.exoplayer2.video.b0.l;
import com.google.android.exoplayer2.video.b0.l.b;
import com.google.android.exoplayer2.video.w;
import com.google.android.exoplayer2.video.y;
import com.google.android.exoplayer2.video.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class e2 extends com.google.android.exoplayer2.t0 implements com.google.android.exoplayer2.v1, com.google.android.exoplayer2.d1 {

    private boolean A;
    private TextureView B;
    private int C;
    private int D;
    private int E;
    private d F;
    private d G;
    private int H;
    private p I;
    private float J;
    private boolean K;
    private List<c> L;
    private boolean M;
    private boolean N;
    private PriorityTaskManager O;
    private boolean P;
    private b Q;
    private a0 R;
    protected final com.google.android.exoplayer2.z1[] b;
    private final l c;
    private final Context d;
    private final com.google.android.exoplayer2.f1 e;
    private final com.google.android.exoplayer2.e2.c f;
    private final com.google.android.exoplayer2.e2.d g;
    private final CopyOnWriteArraySet<y> h;
    private final CopyOnWriteArraySet<r> i;
    private final CopyOnWriteArraySet<k> j;
    private final CopyOnWriteArraySet<e> k;
    private final CopyOnWriteArraySet<c> l;
    private final h1 m;
    private final com.google.android.exoplayer2.r0 n;
    private final com.google.android.exoplayer2.s0 o;
    private final com.google.android.exoplayer2.f2 p;
    private final com.google.android.exoplayer2.h2 q;
    private final com.google.android.exoplayer2.i2 r;
    private final long s;
    private com.google.android.exoplayer2.i1 t;
    private com.google.android.exoplayer2.i1 u;
    private AudioTrack v;
    private Object w;
    private Surface x;
    private SurfaceHolder y;
    private l z;

    static class a {
    }

    public static final class b {

        private final Context a;
        private final com.google.android.exoplayer2.c2 b;
        private i c;
        private long d;
        private n e;
        private a0 f;
        private com.google.android.exoplayer2.l1 g;
        private g h;
        private h1 i;
        private Looper j;
        private PriorityTaskManager k;
        private p l;
        private boolean m;
        private int n;
        private boolean o;
        private boolean p;
        private int q;
        private boolean r;
        private com.google.android.exoplayer2.d2 s;
        private long t;
        private long u;
        private com.google.android.exoplayer2.k1 v;
        private long w;
        private long x;
        private boolean y;
        private boolean z;
        public b(Context context) {
            c1 c1Var = new c1(context);
            g gVar = new g();
            super(context, c1Var, gVar);
        }

        public b(Context context, com.google.android.exoplayer2.c2 c22, m m3) {
            f fVar = new f(context);
            p pVar = new p(context, m3);
            a1 a1Var = new a1();
            h1 h1Var = new h1(i.a);
            super(context, c22, fVar, pVar, a1Var, p.l(context), h1Var);
        }

        public b(Context context, com.google.android.exoplayer2.c2 c22, n n3, a0 a04, com.google.android.exoplayer2.l1 l15, g g6, h1 h17) {
            super();
            this.a = context;
            this.b = c22;
            this.e = n3;
            this.f = a04;
            this.g = l15;
            this.h = g6;
            this.i = h17;
            this.j = p0.J();
            this.l = p.f;
            this.n = 0;
            int obj1 = 1;
            this.q = obj1;
            this.r = obj1;
            this.s = d2.d;
            this.t = 5000;
            this.u = 15000;
            obj1 = new z0.b();
            this.v = obj1.a();
            this.c = i.a;
            this.w = 500;
            this.x = 2000;
        }

        static Context a(com.google.android.exoplayer2.e2.b e2$b) {
            return b.a;
        }

        static h1 b(com.google.android.exoplayer2.e2.b e2$b) {
            return b.i;
        }

        static com.google.android.exoplayer2.c2 c(com.google.android.exoplayer2.e2.b e2$b) {
            return b.b;
        }

        static n d(com.google.android.exoplayer2.e2.b e2$b) {
            return b.e;
        }

        static a0 e(com.google.android.exoplayer2.e2.b e2$b) {
            return b.f;
        }

        static com.google.android.exoplayer2.l1 f(com.google.android.exoplayer2.e2.b e2$b) {
            return b.g;
        }

        static g g(com.google.android.exoplayer2.e2.b e2$b) {
            return b.h;
        }

        static boolean h(com.google.android.exoplayer2.e2.b e2$b) {
            return b.r;
        }

        static com.google.android.exoplayer2.d2 i(com.google.android.exoplayer2.e2.b e2$b) {
            return b.s;
        }

        static long j(com.google.android.exoplayer2.e2.b e2$b) {
            return b.t;
        }

        static long k(com.google.android.exoplayer2.e2.b e2$b) {
            return b.u;
        }

        static com.google.android.exoplayer2.k1 l(com.google.android.exoplayer2.e2.b e2$b) {
            return b.v;
        }

        static PriorityTaskManager m(com.google.android.exoplayer2.e2.b e2$b) {
            return b.k;
        }

        static long n(com.google.android.exoplayer2.e2.b e2$b) {
            return b.w;
        }

        static boolean o(com.google.android.exoplayer2.e2.b e2$b) {
            return b.y;
        }

        static i p(com.google.android.exoplayer2.e2.b e2$b) {
            return b.c;
        }

        static long q(com.google.android.exoplayer2.e2.b e2$b) {
            return b.d;
        }

        static boolean r(com.google.android.exoplayer2.e2.b e2$b) {
            return b.o;
        }

        static boolean s(com.google.android.exoplayer2.e2.b e2$b) {
            return b.m;
        }

        static int t(com.google.android.exoplayer2.e2.b e2$b) {
            return b.n;
        }

        static p u(com.google.android.exoplayer2.e2.b e2$b) {
            return b.l;
        }

        static int v(com.google.android.exoplayer2.e2.b e2$b) {
            return b.q;
        }

        static boolean w(com.google.android.exoplayer2.e2.b e2$b) {
            return b.p;
        }

        static long x(com.google.android.exoplayer2.e2.b e2$b) {
            return b.x;
        }

        static Looper y(com.google.android.exoplayer2.e2.b e2$b) {
            return b.j;
        }

        public com.google.android.exoplayer2.e2 z() {
            final int i2 = 1;
            g.f(z ^= i2);
            this.z = i2;
            e2 e2Var = new e2(this);
            return e2Var;
        }
    }

    private final class c implements z, s, k, e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, l.b, com.google.android.exoplayer2.s0.b, com.google.android.exoplayer2.r0.b, com.google.android.exoplayer2.f2.b, com.google.android.exoplayer2.v1.c, com.google.android.exoplayer2.e1 {

        final com.google.android.exoplayer2.e2 a;
        private c(com.google.android.exoplayer2.e2 e2) {
            this.a = e2;
            super();
        }

        c(com.google.android.exoplayer2.e2 e2, com.google.android.exoplayer2.e2.a e2$a2) {
            super(e2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void D(d d) {
            e2.n0(this.a).D(d);
            int i = 0;
            e2.t0(this.a, i);
            e2.s0(this.a, i);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void E(String string) {
            e2.n0(this.a).E(string);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void F(d d) {
            e2.s0(this.a, d);
            e2.n0(this.a).F(d);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void H(String string, long l2, long l3) {
            e2.n0(this.a).H(string, l2, obj4);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void I(int i) {
            boolean iterator;
            Object next;
            b obj3 = e2.J0(e2.I0(this.a));
            if (!obj3.equals(e2.K0(this.a))) {
                e2.L0(this.a, obj3);
                iterator = e2.M0(this.a).iterator();
                for (c next : iterator) {
                    next.z(obj3);
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void J() {
            e2.H0(this.a, false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void K(boolean z) {
            e2.Q0(this.a);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void M(float f) {
            e2.F0(this.a);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void N(int i) {
            boolean z = this.a.l();
            e2.H0(this.a, z, i, e2.G0(z, i));
        }

        @Override // com.google.android.exoplayer2.video.z
        public void O(Surface surface) {
            e2.C0(this.a, 0);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void P(String string) {
            e2.n0(this.a).P(string);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void Q(String string, long l2, long l3) {
            e2.n0(this.a).Q(string, l2, obj4);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void R(int i, long l2) {
            e2.n0(this.a).R(i, l2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void T(com.google.android.exoplayer2.i1 i1, e e2) {
            e2.t0(this.a, i1);
            e2.n0(this.a).T(i1, e2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void U(Surface surface) {
            e2.C0(this.a, surface);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void V(int i, boolean z2) {
            Object next;
            Iterator iterator = e2.M0(this.a).iterator();
            for (c next : iterator) {
                next.q(i, z2);
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void W(Object object, long l2) {
            Object obj2;
            Object obj3;
            e2.n0(this.a).W(object, l2);
            if (e2.r0(this.a) == object) {
                obj2 = e2.q0(this.a).iterator();
                for (y obj3 : obj2) {
                    obj3.r();
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void Z(d d) {
            e2.m0(this.a, d);
            e2.n0(this.a).Z(d);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void a(boolean z) {
            if (e2.u0(this.a) == z) {
            }
            e2.v0(this.a, z);
            e2.w0(this.a);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void a0(com.google.android.exoplayer2.i1 i1, e e2) {
            e2.o0(this.a, i1);
            e2.n0(this.a).a0(i1, e2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void b(a0 a0) {
            Object next;
            int i2;
            int i3;
            int i;
            float f;
            e2.p0(this.a, a0);
            e2.n0(this.a).b(a0);
            Iterator iterator = e2.q0(this.a).iterator();
            for (y next : iterator) {
                next.b(a0);
                next.V(a0.a, a0.b, a0.c, a0.d);
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void b0(long l) {
            e2.n0(this.a).b0(l);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void d0(Exception exception) {
            e2.n0(this.a).d0(exception);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void f(boolean z) {
            PriorityTaskManager task;
            boolean z2;
            com.google.android.exoplayer2.e2 obj3;
            if (e2.N0(this.a) != null) {
                task = 0;
                if (z != null && !e2.O0(this.a)) {
                    if (!e2.O0(this.a)) {
                        e2.N0(this.a).a(task);
                        e2.P0(this.a, true);
                    } else {
                        if (z == null && e2.O0(this.a)) {
                            if (e2.O0(this.a)) {
                                e2.N0(this.a).c(task);
                                e2.P0(this.a, task);
                            }
                        }
                    }
                } else {
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void f0(Exception exception) {
            e2.n0(this.a).f0(exception);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void h0(d d) {
            e2.n0(this.a).h0(d);
            int i = 0;
            e2.o0(this.a, i);
            e2.m0(this.a, i);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void k0(int i, long l2, long l3) {
            e2.n0(this.a).k0(i, l2, obj4);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void l(int i) {
            e2.Q0(this.a);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void m0(long l, int i2) {
            e2.n0(this.a).m0(l, i2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void o(a a) {
            Object next;
            e2.n0(this.a).o(a);
            e2.z0(this.a).h1(a);
            Iterator iterator = e2.A0(this.a).iterator();
            for (e next : iterator) {
                next.o(a);
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            e2.E0(this.a, surfaceTexture);
            e2.D0(this.a, i2, i3);
        }

        @Override // com.google.android.exoplayer2.video.z
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            e2.C0(this.a, 0);
            int i2 = 0;
            e2.D0(this.a, i2, i2);
            return 1;
        }

        @Override // com.google.android.exoplayer2.video.z
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            e2.D0(this.a, i2, i3);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.video.z
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            e2.D0(this.a, i3, i4);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            boolean z;
            Surface obj2;
            if (e2.B0(this.a)) {
                e2.C0(this.a, surfaceHolder.getSurface());
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            int i;
            boolean obj2;
            if (e2.B0(this.a)) {
                e2.C0(this.a, 0);
            }
            int i2 = 0;
            e2.D0(this.a, i2, i2);
        }

        @Override // com.google.android.exoplayer2.video.z
        public void t(Exception exception) {
            e2.n0(this.a).t(exception);
        }

        public void u(List<c> list) {
            Object next;
            e2.x0(this.a, list);
            Iterator iterator = e2.y0(this.a).iterator();
            for (k next : iterator) {
                next.u(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.z
        public void v(boolean z, int i2) {
            e2.Q0(this.a);
        }
    }

    private static final class d implements w, d, com.google.android.exoplayer2.w1.b {

        private w a;
        private d b;
        private w c;
        private d v;
        d(com.google.android.exoplayer2.e2.a e2$a) {
            super();
        }

        @Override // com.google.android.exoplayer2.video.w
        public void b(long l, float[] f2Arr2) {
            d dVar = this.v;
            if (dVar != null) {
                dVar.b(l, f2Arr2);
            }
            d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.b(l, f2Arr2);
            }
        }

        @Override // com.google.android.exoplayer2.video.w
        public void d() {
            d dVar = this.v;
            if (dVar != null) {
                dVar.d();
            }
            d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.d();
            }
        }

        @Override // com.google.android.exoplayer2.video.w
        public void e(long l, long l2, com.google.android.exoplayer2.i1 i13, MediaFormat mediaFormat4) {
            long l3;
            long l4;
            com.google.android.exoplayer2.i1 i1Var;
            Object i1Var2;
            MediaFormat mediaFormat;
            MediaFormat mediaFormat2;
            MediaFormat mediaFormat3;
            final w wVar = this.c;
            if (wVar != null) {
                wVar.e(l, obj2, i13, obj4);
            }
            w wVar2 = this.a;
            if (wVar2 != null) {
                wVar2.e(l, i1Var, i13, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.video.w
        public void v(int i, Object object2) {
            int i2;
            int obj2;
            if (i != 6) {
                if (i != 7) {
                    if (i != 10000) {
                    } else {
                        if ((l)object2 == null) {
                            obj2 = 0;
                            this.c = obj2;
                            this.v = obj2;
                        } else {
                            this.c = (l)object2.getVideoFrameMetadataListener();
                            this.v = object2.getCameraMotionListener();
                        }
                    }
                } else {
                    this.b = (d)object2;
                }
            } else {
                this.a = (w)object2;
            }
        }
    }
    protected e2(com.google.android.exoplayer2.e2.b e2$b) {
        Object obj;
        int i3;
        int cmp;
        p pVar;
        int i;
        int i2;
        Object obj3 = this;
        super();
        l lVar = new l();
        obj3.c = lVar;
        Context applicationContext = e2.b.a(b).getApplicationContext();
        obj3.d = applicationContext;
        final h1 h1Var = e2.b.b(b);
        obj3.m = h1Var;
        obj3.O = e2.b.m(b);
        obj3.I = e2.b.u(b);
        obj3.C = e2.b.v(b);
        obj3.K = e2.b.w(b);
        obj3.s = e2.b.x(b);
        int i26 = 0;
        e2.c cVar6 = new e2.c(obj3, i26);
        obj3.f = cVar6;
        e2.d dVar2 = new e2.d(i26);
        obj3.g = dVar2;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        obj3.h = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        obj3.i = copyOnWriteArraySet2;
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        obj3.j = copyOnWriteArraySet3;
        CopyOnWriteArraySet copyOnWriteArraySet4 = new CopyOnWriteArraySet();
        obj3.k = copyOnWriteArraySet4;
        CopyOnWriteArraySet copyOnWriteArraySet5 = new CopyOnWriteArraySet();
        obj3.l = copyOnWriteArraySet5;
        Handler handler2 = new Handler(e2.b.y(b));
        com.google.android.exoplayer2.z1[] objArr = e2.b.c(b).a(handler2, cVar6, cVar6, cVar6, cVar6);
        obj3.b = objArr;
        obj3.J = 1065353216;
        int i27 = 21;
        int i38 = 0;
        if (p0.a < i27) {
            obj3.H = obj3.e1(i38);
        } else {
            obj3.H = w0.a(applicationContext);
        }
        obj3.L = Collections.emptyList();
        int i39 = 1;
        obj3.M = i39;
        v1.b.a aVar = new v1.b.a();
        int[] iArr = new int[8];
        iArr[i38] = 20;
        iArr[i39] = i27;
        iArr[2] = 22;
        int i37 = 3;
        iArr[i37] = 23;
        iArr[4] = 24;
        iArr[5] = 25;
        iArr[6] = 26;
        iArr[7] = 27;
        aVar.c(iArr);
        a0 a0Var3 = e2.b.e(b);
        a0 a0Var2 = a0Var3;
        com.google.android.exoplayer2.f1 f1Var = f1Var3;
        int i41 = i38;
        super(objArr, e2.b.d(b), a0Var2, e2.b.f(b), e2.b.g(b), h1Var, e2.b.h(b), e2.b.i(b), e2.b.j(b), i37, e2.b.k(b), i39, e2.b.l(b), e2.b.n(b), a0Var3, e2.b.o(b), e2.b.p(b), e2.b.y(b), this, aVar.e());
        Object obj2 = this;
        obj2.e = f1Var;
        com.google.android.exoplayer2.e2.c cVar = cVar7;
        f1Var.n0(cVar);
        f1Var.m0(cVar);
        if (Long.compare(l2, i25) > 0) {
            f1Var.t0(e2.b.q(b));
        }
        Handler handler3 = handler5;
        r0 r0Var = new r0(e2.b.a(b), handler3, cVar);
        obj2.n = r0Var;
        r0Var.b(e2.b.r(b));
        s0 s0Var = new s0(e2.b.a(b), handler3, cVar);
        obj2.o = s0Var;
        pVar = e2.b.s(b) ? obj2.I : i42;
        s0Var.m(pVar);
        f2 f2Var = new f2(e2.b.a(b), handler3, cVar);
        obj2.p = f2Var;
        f2Var.h(p0.W(pVar4.c));
        h2 h2Var = new h2(e2.b.a(b));
        obj2.q = h2Var;
        i = e2.b.t(b) != 0 ? 1 : i41;
        h2Var.a(i);
        i2 i2Var = new i2(e2.b.a(b));
        obj2.r = i2Var;
        int i24 = 2;
        if (e2.b.t(b) == i24) {
            try {
                i2 = 1;
                i2 = i41;
                i2Var.a(i2);
                obj2.Q = e2.Z0(f2Var);
                obj2.R = a0.e;
                int i13 = 102;
                int i22 = 1;
                obj2.o1(i22, i13, Integer.valueOf(obj2.H));
                obj2.o1(i24, i13, Integer.valueOf(obj2.H));
                obj2.o1(i22, 3, obj2.I);
                obj2.o1(i24, 4, Integer.valueOf(obj2.C));
                obj2.o1(i22, 101, Boolean.valueOf(obj2.K));
                com.google.android.exoplayer2.e2.d dVar = dVar3;
                int i16 = 6;
                obj2.o1(i24, i16, dVar);
                obj2.o1(i16, 7, dVar);
                lVar.d();
                obj.c.d();
                throw th;
            } catch (Throwable th) {
            }
        } else {
        }
    }

    static CopyOnWriteArraySet A0(com.google.android.exoplayer2.e2 e2) {
        return e2.k;
    }

    static boolean B0(com.google.android.exoplayer2.e2 e2) {
        return e2.A;
    }

    static void C0(com.google.android.exoplayer2.e2 e2, Object object2) {
        e2.t1(object2);
    }

    static void D0(com.google.android.exoplayer2.e2 e2, int i2, int i3) {
        e2.f1(i2, i3);
    }

    static void E0(com.google.android.exoplayer2.e2 e2, SurfaceTexture surfaceTexture2) {
        e2.s1(surfaceTexture2);
    }

    static void F0(com.google.android.exoplayer2.e2 e2) {
        e2.p1();
    }

    static int G0(boolean z, int i2) {
        return e2.c1(z, i2);
    }

    static void H0(com.google.android.exoplayer2.e2 e2, boolean z2, int i3, int i4) {
        e2.v1(z2, i3, i4);
    }

    static com.google.android.exoplayer2.f2 I0(com.google.android.exoplayer2.e2 e2) {
        return e2.p;
    }

    static b J0(com.google.android.exoplayer2.f2 f2) {
        return e2.Z0(f2);
    }

    static b K0(com.google.android.exoplayer2.e2 e2) {
        return e2.Q;
    }

    static b L0(com.google.android.exoplayer2.e2 e2, b b2) {
        e2.Q = b2;
        return b2;
    }

    static CopyOnWriteArraySet M0(com.google.android.exoplayer2.e2 e2) {
        return e2.l;
    }

    static PriorityTaskManager N0(com.google.android.exoplayer2.e2 e2) {
        return e2.O;
    }

    static boolean O0(com.google.android.exoplayer2.e2 e2) {
        return e2.P;
    }

    static boolean P0(com.google.android.exoplayer2.e2 e2, boolean z2) {
        e2.P = z2;
        return z2;
    }

    static void Q0(com.google.android.exoplayer2.e2 e2) {
        e2.w1();
    }

    private static b Z0(com.google.android.exoplayer2.f2 f2) {
        b bVar = new b(0, f2.d(), f2.c());
        return bVar;
    }

    private static int c1(boolean z, int i2) {
        int i;
        if (z && i2 != 1) {
            if (i2 != 1) {
                i = 2;
            }
        }
        return i;
    }

    private int e1(int i) {
        AudioTrack audioSessionId;
        AudioTrack audioTrack2;
        AudioTrack audioTrack;
        int i8;
        int i5;
        int i4;
        int i7;
        int i2;
        int i6;
        int i3;
        audioSessionId = this.v;
        if (audioSessionId != null && audioSessionId.getAudioSessionId() != i) {
            if (audioSessionId.getAudioSessionId() != i) {
                this.v.release();
                this.v = 0;
            }
        }
        if (this.v == null) {
            super(3, 4000, 4, 2, 2, 0, i);
            this.v = audioTrack2;
        }
        return this.v.getAudioSessionId();
    }

    private void f1(int i, int i2) {
        int iterator;
        boolean next;
        if (i == this.D) {
            if (i2 != this.E) {
                this.D = i;
                this.E = i2;
                this.m.x(i, i2);
                iterator = this.h.iterator();
                for (y next : iterator) {
                    next.x(i, i2);
                }
            }
        } else {
        }
    }

    private void g1() {
        boolean next;
        boolean z;
        this.m.a(this.K);
        Iterator iterator = this.i.iterator();
        for (r next : iterator) {
            next.a(this.K);
        }
    }

    private void l1() {
        l lVar;
        Object str;
        com.google.android.exoplayer2.e2.c str2;
        final int i = 0;
        if (this.z != null) {
            com.google.android.exoplayer2.w1 w1Var = this.e.q0(this.g);
            w1Var.n(10000);
            w1Var.m(i);
            w1Var.l();
            this.z.i(this.f);
            this.z = i;
        }
        str = this.B;
        if (str != null) {
            if (str.getSurfaceTextureListener() != this.f) {
                v.h("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.B.setSurfaceTextureListener(i);
            }
            this.B = i;
        }
        SurfaceHolder surfaceHolder = this.y;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f);
            this.y = i;
        }
    }

    static d m0(com.google.android.exoplayer2.e2 e2, d d2) {
        e2.F = d2;
        return d2;
    }

    static h1 n0(com.google.android.exoplayer2.e2 e2) {
        return e2.m;
    }

    static com.google.android.exoplayer2.i1 o0(com.google.android.exoplayer2.e2 e2, com.google.android.exoplayer2.i1 i12) {
        e2.t = i12;
        return i12;
    }

    private void o1(int i, int i2, Object object3) {
        int i3;
        com.google.android.exoplayer2.z1 z1Var;
        int i4;
        final com.google.android.exoplayer2.z1[] objArr = this.b;
        i3 = 0;
        while (i3 < objArr.length) {
            z1Var = objArr[i3];
            if (z1Var.i() == i) {
            }
            i3++;
            z1Var = this.e.q0(z1Var);
            z1Var.n(i2);
            z1Var.m(object3);
            z1Var.l();
        }
    }

    static a0 p0(com.google.android.exoplayer2.e2 e2, a0 a02) {
        e2.R = a02;
        return a02;
    }

    private void p1() {
        o1(1, 2, Float.valueOf(f *= f2));
    }

    static CopyOnWriteArraySet q0(com.google.android.exoplayer2.e2 e2) {
        return e2.h;
    }

    static Object r0(com.google.android.exoplayer2.e2 e2) {
        return e2.w;
    }

    private void r1(SurfaceHolder surfaceHolder) {
        int width;
        Surface obj3;
        width = 0;
        this.A = width;
        this.y = surfaceHolder;
        surfaceHolder.addCallback(this.f);
        obj3 = this.y.getSurface();
        if (obj3 != null && obj3.isValid()) {
            if (obj3.isValid()) {
                obj3 = this.y.getSurfaceFrame();
                f1(obj3.width(), obj3.height());
            } else {
                f1(width, width);
            }
        } else {
        }
    }

    static d s0(com.google.android.exoplayer2.e2 e2, d d2) {
        e2.G = d2;
        return d2;
    }

    private void s1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        t1(surface);
        this.x = surface;
    }

    static com.google.android.exoplayer2.i1 t0(com.google.android.exoplayer2.e2 e2, com.google.android.exoplayer2.i1 i12) {
        e2.u = i12;
        return i12;
    }

    private void t1(Object object) {
        Object arrayList;
        Iterator iterator;
        Object next;
        int i4;
        int i;
        int i3;
        com.google.android.exoplayer2.z1 z1Var;
        int i5;
        int i2;
        Object obj10;
        arrayList = new ArrayList();
        com.google.android.exoplayer2.z1[] objArr = this.b;
        final int i7 = 0;
        i4 = i7;
        while (i4 < objArr.length) {
            z1Var = objArr[i4];
            if (z1Var.i() == 2) {
            }
            i4++;
            z1Var = this.e.q0(z1Var);
            z1Var.n(1);
            z1Var.m(object);
            z1Var.l();
            arrayList.add(z1Var);
        }
        next = this.w;
        if (next != null && next != object) {
            if (next != object) {
                iterator = arrayList.iterator();
                for (w1 next : iterator) {
                    next.a(this.s);
                }
                i3 = i7;
                next = this.x;
                if (this.w == next) {
                    next.release();
                    this.x = 0;
                }
            } else {
                i3 = i7;
            }
        } else {
        }
        this.w = object;
        if (i3 != 0) {
            ExoTimeoutException exoTimeoutException = new ExoTimeoutException(3);
            this.e.r1(i7, ExoPlaybackException.e(exoTimeoutException, 1003));
        }
    }

    static boolean u0(com.google.android.exoplayer2.e2 e2) {
        return e2.K;
    }

    static boolean v0(com.google.android.exoplayer2.e2 e2, boolean z2) {
        e2.K = z2;
        return z2;
    }

    private void v1(boolean z, int i2, int i3) {
        int i;
        int obj3;
        final int i4 = 1;
        if (z != 0 && i2 != -1) {
            obj3 = i2 != -1 ? i4 : i;
        } else {
        }
        if (obj3 != null && i2 != i4) {
            if (i2 != i4) {
                i = i4;
            }
        }
        this.e.q1(obj3, i, i3);
    }

    static void w0(com.google.android.exoplayer2.e2 e2) {
        e2.g1();
    }

    private void w1() {
        com.google.android.exoplayer2.i2 i2Var;
        int i;
        int i2;
        boolean z;
        int i3 = E();
        final int i4 = 0;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 3) {
                    if (i3 != 4) {
                    } else {
                        this.q.b(i4);
                        this.r.b(i4);
                    }
                    IllegalStateException illegalStateException = new IllegalStateException();
                    throw illegalStateException;
                }
            }
            if (l() && !a1()) {
                if (!a1()) {
                } else {
                    i = i4;
                }
            } else {
            }
            this.q.b(i);
            this.r.b(l());
        } else {
        }
    }

    static List x0(com.google.android.exoplayer2.e2 e2, List list2) {
        e2.L = list2;
        return list2;
    }

    private void x1() {
        Object currentThread;
        Thread illegalStateException;
        int i;
        String str;
        this.c.b();
        if (Thread.currentThread() != P().getThread()) {
            Object[] arr = new Object[2];
            i = 1;
            arr[i] = P().getThread().getName();
            currentThread = p0.z("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", arr);
            if (this.M) {
            } else {
                if (this.N) {
                    illegalStateException = 0;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                v.i("SimpleExoPlayer", currentThread, illegalStateException);
                this.N = i;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException(currentThread);
            throw illegalStateException2;
        }
    }

    static CopyOnWriteArraySet y0(com.google.android.exoplayer2.e2 e2) {
        return e2.j;
    }

    static com.google.android.exoplayer2.f1 z0(com.google.android.exoplayer2.e2 e2) {
        return e2.e;
    }

    @Override // com.google.android.exoplayer2.t0
    public void A(boolean z) {
        x1();
        int i = this.o.p(z, E());
        v1(z, i, e2.c1(z, i));
    }

    @Override // com.google.android.exoplayer2.t0
    public long B() {
        x1();
        return this.e.B();
    }

    @Override // com.google.android.exoplayer2.t0
    public long C() {
        x1();
        return this.e.C();
    }

    @Override // com.google.android.exoplayer2.t0
    public void D(com.google.android.exoplayer2.v1.e v1$e) {
        g.e(e);
        R0(e);
        W0(e);
        V0(e);
        U0(e);
        S0(e);
        T0(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public int E() {
        x1();
        return this.e.E();
    }

    public List<c> G() {
        x1();
        return this.L;
    }

    @Override // com.google.android.exoplayer2.t0
    public int H() {
        x1();
        return this.e.H();
    }

    @Override // com.google.android.exoplayer2.t0
    public void J(int i) {
        x1();
        this.e.J(i);
    }

    @Override // com.google.android.exoplayer2.t0
    public void K(SurfaceView surfaceView) {
        int obj1;
        x1();
        if (surfaceView == null) {
            obj1 = 0;
        } else {
            obj1 = surfaceView.getHolder();
        }
        Y0(obj1);
    }

    @Override // com.google.android.exoplayer2.t0
    public int L() {
        x1();
        return this.e.L();
    }

    @Override // com.google.android.exoplayer2.t0
    public l0 M() {
        x1();
        return this.e.M();
    }

    @Override // com.google.android.exoplayer2.t0
    public int N() {
        x1();
        return this.e.N();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.g2 O() {
        x1();
        return this.e.O();
    }

    @Override // com.google.android.exoplayer2.t0
    public Looper P() {
        return this.e.P();
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean Q() {
        x1();
        return this.e.Q();
    }

    @Override // com.google.android.exoplayer2.t0
    public long R() {
        x1();
        return this.e.R();
    }

    @Deprecated
    public void R0(r r) {
        g.e(r);
        this.i.add(r);
    }

    @Deprecated
    public void S0(c c) {
        g.e(c);
        this.l.add(c);
    }

    @Deprecated
    public void T0(com.google.android.exoplayer2.v1.c v1$c) {
        g.e(c);
        this.e.n0(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public void U(TextureView textureView) {
        int surfaceTexture;
        Object surfaceTextureListener;
        int str;
        int obj3;
        x1();
        if (textureView == null) {
            X0();
        } else {
            l1();
            this.B = textureView;
            if (textureView.getSurfaceTextureListener() != null) {
                v.h("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f);
            str = 0;
            if (textureView.isAvailable()) {
                surfaceTexture = textureView.getSurfaceTexture();
            } else {
                surfaceTexture = str;
            }
            if (surfaceTexture == 0) {
                t1(str);
                obj3 = 0;
                f1(obj3, obj3);
            } else {
                s1(surfaceTexture);
                f1(textureView.getWidth(), textureView.getHeight());
            }
        }
    }

    @Deprecated
    public void U0(e e) {
        g.e(e);
        this.k.add(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public k V() {
        x1();
        return this.e.V();
    }

    @Deprecated
    public void V0(k k) {
        g.e(k);
        this.j.add(k);
    }

    @Deprecated
    public void W0(y y) {
        g.e(y);
        this.h.add(y);
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.n1 X() {
        return this.e.X();
    }

    @Override // com.google.android.exoplayer2.t0
    public void X0() {
        x1();
        l1();
        t1(0);
        int i2 = 0;
        f1(i2, i2);
    }

    @Override // com.google.android.exoplayer2.t0
    public long Y() {
        x1();
        return this.e.Y();
    }

    @Override // com.google.android.exoplayer2.t0
    public void Y0(SurfaceHolder surfaceHolder) {
        SurfaceHolder surfaceHolder2;
        x1();
        if (surfaceHolder != null && surfaceHolder == this.y) {
            if (surfaceHolder == this.y) {
                X0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public long Z() {
        x1();
        return this.e.Z();
    }

    @Override // com.google.android.exoplayer2.t0
    public void a() {
        int i;
        boolean z;
        x1();
        final int i2 = 0;
        i = this.v;
        if (p0.a < 21 && i != null) {
            i = this.v;
            if (i != null) {
                i.release();
                this.v = i2;
            }
        }
        int i4 = 0;
        this.n.b(i4);
        this.p.g();
        this.q.b(i4);
        this.r.b(i4);
        this.o.i();
        this.e.a();
        this.m.F1();
        l1();
        Surface surface = this.x;
        if (surface != null) {
            surface.release();
            this.x = i2;
        }
        if (this.P) {
            z = this.O;
            g.e(z);
            (PriorityTaskManager)z.c(i4);
            this.P = i4;
        }
        this.L = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean a1() {
        x1();
        return this.e.s0();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.d1 b1() {
        return this;
    }

    @Override // com.google.android.exoplayer2.t0
    public long d() {
        x1();
        return this.e.d();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.ExoPlaybackException d1() {
        x1();
        return this.e.z0();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.u1 e() {
        x1();
        return this.e.e();
    }

    @Override // com.google.android.exoplayer2.t0
    public void f() {
        x1();
        boolean z = l();
        int i = this.o.p(z, 2);
        v1(z, i, e2.c1(z, i));
        this.e.f();
    }

    @Override // com.google.android.exoplayer2.t0
    public void g(float f) {
        int next;
        x1();
        final float obj3 = p0.o(f, 0, 1065353216);
        if (Float.compare(f2, obj3) == 0) {
        }
        this.J = obj3;
        p1();
        this.m.k(obj3);
        Iterator iterator = this.i.iterator();
        for (r next : iterator) {
            next.k(obj3);
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean h() {
        x1();
        return this.e.h();
    }

    @Deprecated
    public void h1(r r) {
        this.i.remove(r);
    }

    @Override // com.google.android.exoplayer2.t0
    public long i() {
        x1();
        return this.e.i();
    }

    @Deprecated
    public void i1(c c) {
        this.l.remove(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public void j(int i, long l2) {
        x1();
        this.m.E1();
        this.e.j(i, l2);
    }

    @Deprecated
    public void j1(com.google.android.exoplayer2.v1.c v1$c) {
        this.e.j1(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.v1.b k() {
        x1();
        return this.e.k();
    }

    @Deprecated
    public void k1(e e) {
        this.k.remove(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean l() {
        x1();
        return this.e.l();
    }

    @Override // com.google.android.exoplayer2.t0
    public void m(boolean z) {
        x1();
        this.e.m(z);
    }

    @Deprecated
    public void m1(k k) {
        this.j.remove(k);
    }

    @Deprecated
    public void n(boolean z) {
        x1();
        this.o.p(l(), 1);
        this.e.n(z);
        this.L = Collections.emptyList();
    }

    @Deprecated
    public void n1(y y) {
        this.h.remove(y);
    }

    @Override // com.google.android.exoplayer2.t0
    public int o() {
        x1();
        return this.e.o();
    }

    @Override // com.google.android.exoplayer2.t0
    public int p() {
        x1();
        return this.e.p();
    }

    @Override // com.google.android.exoplayer2.t0
    public void q1(y y) {
        x1();
        this.e.m1(y);
    }

    @Override // com.google.android.exoplayer2.t0
    public void r(TextureView textureView) {
        TextureView view;
        x1();
        if (textureView != null && textureView == this.B) {
            if (textureView == this.B) {
                X0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public a0 s() {
        return this.R;
    }

    @Override // com.google.android.exoplayer2.t0
    public void t(com.google.android.exoplayer2.v1.e v1$e) {
        g.e(e);
        h1(e);
        n1(e);
        m1(e);
        k1(e);
        i1(e);
        j1(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public int u() {
        x1();
        return this.e.u();
    }

    @Override // com.google.android.exoplayer2.t0
    public void u1(SurfaceHolder surfaceHolder) {
        int surface;
        boolean valid;
        SurfaceHolder obj3;
        x1();
        if (surfaceHolder == null) {
            X0();
        } else {
            l1();
            this.A = true;
            this.y = surfaceHolder;
            surfaceHolder.addCallback(this.f);
            surface = surfaceHolder.getSurface();
            if (surface != null && surface.isValid()) {
                if (surface.isValid()) {
                    t1(surface);
                    obj3 = surfaceHolder.getSurfaceFrame();
                    f1(obj3.width(), obj3.height());
                } else {
                    t1(0);
                    obj3 = 0;
                    f1(obj3, obj3);
                }
            } else {
            }
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public void v(SurfaceView surfaceView) {
        Surface videoSurface;
        com.google.android.exoplayer2.e2.c cVar;
        SurfaceHolder obj3;
        x1();
        if (surfaceView instanceof v) {
            l1();
            t1(surfaceView);
            r1(surfaceView.getHolder());
        } else {
            if (surfaceView instanceof l) {
                l1();
                this.z = (l)surfaceView;
                com.google.android.exoplayer2.w1 w1Var = this.e.q0(this.g);
                w1Var.n(10000);
                w1Var.m(this.z);
                w1Var.l();
                this.z.b(this.f);
                t1(this.z.getVideoSurface());
                r1(surfaceView.getHolder());
            } else {
                if (surfaceView == null) {
                    obj3 = 0;
                } else {
                    obj3 = surfaceView.getHolder();
                }
                u1(obj3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public int x() {
        x1();
        return this.e.x();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.PlaybackException z() {
        return d1();
    }
}
