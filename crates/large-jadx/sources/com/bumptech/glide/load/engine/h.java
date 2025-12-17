package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.b;
import com.bumptech.glide.t.m.c;
import d.h.k.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class h<R>  implements com.bumptech.glide.load.engine.f.a, Runnable, Comparable<com.bumptech.glide.load.engine.h<?>>, a.f {

    private f A;
    private h B;
    private com.bumptech.glide.load.engine.n C;
    private int D;
    private int E;
    private com.bumptech.glide.load.engine.j F;
    private h G;
    private com.bumptech.glide.load.engine.h.b<R> H;
    private int I;
    private com.bumptech.glide.load.engine.h.h J;
    private com.bumptech.glide.load.engine.h.g K;
    private long L;
    private boolean M;
    private Object N;
    private Thread O;
    private f P;
    private f Q;
    private Object R;
    private a S;
    private d<?> T;
    private volatile com.bumptech.glide.load.engine.f U;
    private volatile boolean V;
    private volatile boolean W;
    private boolean X;
    private final com.bumptech.glide.load.engine.g<R> a;
    private final List<Throwable> b;
    private final c c;
    private final com.bumptech.glide.load.engine.h.e v;
    private final f<com.bumptech.glide.load.engine.h<?>> w;
    private final com.bumptech.glide.load.engine.h.d<?> x;
    private final com.bumptech.glide.load.engine.h.f y;
    private e z;

    static class a {

        static final int[] a;
        static final int[] b;
        static final int[] c;
        static {
            int[] iArr = new int[values.length];
            h.a.c = iArr;
            int i2 = 1;
            iArr[c.SOURCE.ordinal()] = i2;
            int i = 2;
            h.a.c[c.TRANSFORMED.ordinal()] = i;
            int[] iArr5 = new int[values2.length];
            h.a.b = iArr5;
            iArr5[h.h.RESOURCE_CACHE.ordinal()] = i2;
            h.a.b[h.h.DATA_CACHE.ordinal()] = i;
            int i3 = 3;
            h.a.b[h.h.SOURCE.ordinal()] = i3;
            h.a.b[h.h.FINISHED.ordinal()] = 4;
            h.a.b[h.h.INITIALIZE.ordinal()] = 5;
            int[] iArr10 = new int[values3.length];
            h.a.a = iArr10;
            iArr10[h.g.INITIALIZE.ordinal()] = i2;
            h.a.a[h.g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = i;
            h.a.a[h.g.DECODE_DATA.ordinal()] = i3;
        }
    }

    interface b {
        public abstract void a(com.bumptech.glide.load.engine.GlideException glideException);

        public abstract void c(com.bumptech.glide.load.engine.u<R> u, a a2, boolean z3);

        public abstract void d(com.bumptech.glide.load.engine.h<?> h);
    }

    private static class d {

        private f a;
        private k<Z> b;
        private com.bumptech.glide.load.engine.t<Z> c;
        void a() {
            final int i = 0;
            this.a = i;
            this.b = i;
            this.c = i;
        }

        void b(com.bumptech.glide.load.engine.h.e h$e, h h2) {
            b.a("DecodeJob.encode");
            e eVar = new e(this.b, this.c, h2);
            e.a().a(this.a, eVar);
            this.c.g();
            b.e();
        }

        boolean c() {
            int i;
            i = this.c != null ? 1 : 0;
            return i;
        }

        <X> void d(f f, k<X> k2, com.bumptech.glide.load.engine.t<X> t3) {
            this.a = f;
            this.b = k2;
            this.c = t3;
        }
    }

    interface e {
        public abstract a a();
    }

    private static class f {

        private boolean a;
        private boolean b;
        private boolean c;
        private boolean a(boolean z) {
            boolean obj2;
            if (!this.c && !z) {
                if (!z) {
                    if (this.b && this.a) {
                        obj2 = this.a ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        boolean b() {
            this.b = true;
            return a(false);
            synchronized (this) {
                this.b = true;
                return a(false);
            }
        }

        boolean c() {
            this.c = true;
            return a(false);
            synchronized (this) {
                this.c = true;
                return a(false);
            }
        }

        boolean d(boolean z) {
            this.a = true;
            return a(z);
            synchronized (this) {
                this.a = true;
                return a(z);
            }
        }

        void e() {
            final int i = 0;
            this.b = i;
            this.a = i;
            this.c = i;
            return;
            synchronized (this) {
                i = 0;
                this.b = i;
                this.a = i;
                this.c = i;
            }
        }
    }

    private static enum g {

        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA;
    }

    private static enum h {

        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED;
    }

    private final class c implements com.bumptech.glide.load.engine.i.a<Z> {

        private final a a;
        final com.bumptech.glide.load.engine.h b;
        c(com.bumptech.glide.load.engine.h h, a a2) {
            this.b = h;
            super();
            this.a = a2;
        }

        public com.bumptech.glide.load.engine.u<Z> a(com.bumptech.glide.load.engine.u<Z> u) {
            return this.b.A(this.a, u);
        }
    }
    h(com.bumptech.glide.load.engine.h.e h$e, f<com.bumptech.glide.load.engine.h<?>> f2) {
        super();
        g gVar = new g();
        this.a = gVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = c.a();
        h.d dVar = new h.d();
        this.x = dVar;
        h.f fVar = new h.f();
        this.y = fVar;
        this.v = e;
        this.w = f2;
    }

    private void C() {
        this.y.e();
        this.x.a();
        this.a.a();
        int i = 0;
        this.V = i;
        final int i2 = 0;
        this.z = i2;
        this.A = i2;
        this.G = i2;
        this.B = i2;
        this.C = i2;
        this.H = i2;
        this.J = i2;
        this.U = i2;
        this.O = i2;
        this.P = i2;
        this.R = i2;
        this.S = i2;
        this.T = i2;
        this.L = 0;
        this.W = i;
        this.N = i2;
        this.b.clear();
        this.w.a(this);
    }

    private void D() {
        int i;
        com.bumptech.glide.load.engine.h.h hVar2;
        boolean z;
        boolean hVar;
        com.bumptech.glide.load.engine.h.h sOURCE;
        this.O = Thread.currentThread();
        this.L = g.b();
        i = 0;
        while (!this.W) {
            this.J = p(this.J);
            this.U = o();
        }
        if (this.J != h.h.FINISHED) {
            if (this.W && i == 0) {
                if (i == 0) {
                    x();
                }
            }
        } else {
        }
    }

    private <Data, ResourceType> com.bumptech.glide.load.engine.u<R> E(Data data, a a2, com.bumptech.glide.load.engine.s<Data, ResourceType, R> s3) {
        final e obj7 = this.z.i().l(data);
        h.c cVar = new h.c(this, a2);
        obj7.b();
        return s3.a(obj7, q(a2), this.D, this.E, cVar);
    }

    private void F() {
        com.bumptech.glide.load.engine.f i;
        int i2;
        i = h.a.a[this.K.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    n();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unrecognized run reason: ");
                stringBuilder.append(this.K);
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
            }
            D();
        } else {
            this.J = p(h.h.INITIALIZE);
            this.U = o();
            D();
        }
    }

    private void G() {
        Object obj;
        int i;
        this.c.c();
        int i2 = 1;
        if (this.V) {
            if (this.b.isEmpty()) {
                obj = 0;
            } else {
                List list2 = this.b;
                obj = list2.get(size -= i2);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Already notified", obj);
            throw illegalStateException;
        }
        this.V = i2;
    }

    private <Data> com.bumptech.glide.load.engine.u<R> k(d<?> d, Data data2, a a3) {
        int str;
        boolean obj6;
        if (data2 == null) {
            d.b();
            return 0;
        }
        com.bumptech.glide.load.engine.u obj5 = m(data2, a3);
        if (Log.isLoggable("DecodeJob", 2)) {
            obj6 = new StringBuilder();
            obj6.append("Decoded result ");
            obj6.append(obj5);
            t(obj6.toString(), g.b());
        }
        d.b();
        return obj5;
    }

    private <Data> com.bumptech.glide.load.engine.u<R> m(Data data, a a2) {
        return E(data, a2, this.a.h(data.getClass()));
    }

    private void n() {
        boolean loggable;
        d dVar;
        Object string;
        Object obj;
        Object str;
        a aVar;
        int i2 = 2;
        if (Log.isLoggable("DecodeJob", i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("data: ");
            stringBuilder.append(this.R);
            stringBuilder.append(", cache key: ");
            stringBuilder.append(this.P);
            stringBuilder.append(", fetcher: ");
            stringBuilder.append(this.T);
            u("Retrieved data", this.L, i2);
        }
        int i = 0;
        com.bumptech.glide.load.engine.u uVar = k(this.T, this.R, this.S);
        if (uVar != null) {
            w(uVar, this.S, this.X);
        } else {
            D();
        }
    }

    private com.bumptech.glide.load.engine.f o() {
        int i = h.a.b[this.J.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        return null;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized stage: ");
                    stringBuilder.append(this.J);
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
                }
                y yVar = new y(this.a, this);
                return yVar;
            }
            c cVar = new c(this.a, this);
            return cVar;
        }
        v vVar = new v(this.a, this);
        return vVar;
    }

    private com.bumptech.glide.load.engine.h.h p(com.bumptech.glide.load.engine.h.h h$h) {
        int i;
        com.bumptech.glide.load.engine.h.h obj4;
        int i2 = h.a.b[h.ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                        } else {
                            if (this.F.b()) {
                                obj4 = h.h.RESOURCE_CACHE;
                            } else {
                                obj4 = p(h.h.RESOURCE_CACHE);
                            }
                            return obj4;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unrecognized stage: ");
                        stringBuilder.append(h);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                        throw illegalArgumentException;
                    }
                }
                return h.h.FINISHED;
            }
            obj4 = this.M ? h.h.FINISHED : h.h.SOURCE;
            return obj4;
        }
        if (this.F.a()) {
            obj4 = h.h.DATA_CACHE;
        } else {
            obj4 = p(h.h.DATA_CACHE);
        }
        return obj4;
    }

    private h q(a a) {
        Object booleanValue;
        int obj4;
        h hVar = this.G;
        if (Build.VERSION.SDK_INT < 26) {
            return hVar;
        }
        if (a != a.RESOURCE_DISK_CACHE) {
            if (this.a.x()) {
                obj4 = 1;
            } else {
                obj4 = 0;
            }
        } else {
        }
        com.bumptech.glide.load.g gVar = m.i;
        booleanValue = hVar.c(gVar);
        if (booleanValue != null && (Boolean)booleanValue.booleanValue() && obj4 != null) {
            if (booleanValue.booleanValue()) {
                if (obj4 != null) {
                }
            }
            return hVar;
        }
        h hVar2 = new h();
        hVar2.d(this.G);
        hVar2.e(gVar, Boolean.valueOf(obj4));
        return hVar2;
    }

    private int r() {
        return this.B.ordinal();
    }

    private void t(String string, long l2) {
        u(string, l2, obj4);
    }

    private void u(String string, long l2, String string3) {
        String obj2;
        String obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" in ");
        stringBuilder.append(g.a(l2));
        stringBuilder.append(", load key: ");
        stringBuilder.append(this.C);
        if (obj5 != null) {
            obj2 = new StringBuilder();
            obj2.append(", ");
            obj2.append(obj5);
            obj2 = obj2.toString();
        } else {
            obj2 = "";
        }
        stringBuilder.append(obj2);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        Log.v("DecodeJob", stringBuilder.toString());
    }

    private void v(com.bumptech.glide.load.engine.u<R> u, a a2, boolean z3) {
        G();
        this.H.c(u, a2, z3);
    }

    private void w(com.bumptech.glide.load.engine.u<R> u, a a2, boolean z3) {
        boolean z;
        int i;
        Object obj3;
        Object obj4;
        boolean obj5;
        b.a("DecodeJob.notifyEncodeAndRelease");
        if (u instanceof q) {
            (q)u.initialize();
        }
        i = 0;
        if (this.x.c()) {
            i = obj3;
        }
        v(obj3, a2, z3);
        this.J = h.h.ENCODE;
        if (this.x.c()) {
            try {
                this.x.b(this.v, this.G);
                if (i != 0) {
                }
                i.g();
                y();
                b.e();
                if (obj0 == null) {
                } else {
                }
                obj0.g();
                throw u;
                b.e();
                throw u;
            } catch (Throwable th) {
            }
        }
    }

    private void x() {
        G();
        ArrayList arrayList = new ArrayList(this.b);
        GlideException glideException = new GlideException("Failed to load resource", arrayList);
        this.H.a(glideException);
        z();
    }

    private void y() {
        if (this.y.b()) {
            C();
        }
    }

    private void z() {
        if (this.y.c()) {
            C();
        }
    }

    <Z> com.bumptech.glide.load.engine.u<Z> A(a a, com.bumptech.glide.load.engine.u<Z> u2) {
        com.bumptech.glide.load.engine.u uVar2;
        k i2;
        int i4;
        com.bumptech.glide.load.engine.u uVar;
        int i3;
        int i;
        Object jVar;
        int i5;
        int i7;
        int i6;
        l lVar;
        h hVar;
        boolean obj12;
        c obj13;
        final Class class = u2.get().getClass();
        if (a != a.RESOURCE_DISK_CACHE) {
            l lVar2 = this.a.s(class);
            lVar = lVar2;
            uVar2 = uVar;
        } else {
            uVar2 = u2;
            lVar = i2;
        }
        if (!u2.equals(uVar2)) {
            u2.a();
        }
        if (this.a.w(uVar2)) {
            obj13 = this.a.n(uVar2).b(this.G);
        } else {
            obj13 = c.NONE;
        }
        final k kVar = i2;
        i3 = 1;
        if (this.F.d(z ^= i3, a, obj13)) {
            if (kVar == null) {
            } else {
                obj12 = h.a.c[obj13.ordinal()];
                if (obj12 != i3) {
                    if (obj12 != 2) {
                    } else {
                        super(this.a.b(), this.P, this.A, this.D, this.E, lVar, class, this.G);
                        this.x.d(obj12, kVar, t.d(uVar2));
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown strategy: ");
                    stringBuilder.append(obj13);
                    obj12 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj12;
                }
                obj12 = new d(this.P, this.A);
            }
            obj12 = new Registry.NoResultEncoderAvailableException(uVar2.get().getClass());
            throw obj12;
        }
        return uVar2;
    }

    @Override // com.bumptech.glide.load.engine.f$a
    void B(boolean z) {
        if (this.y.d(z)) {
            C();
        }
    }

    @Override // com.bumptech.glide.load.engine.f$a
    boolean H() {
        int i;
        com.bumptech.glide.load.engine.h.h rESOURCE_CACHE;
        com.bumptech.glide.load.engine.h.h hVar = p(h.h.INITIALIZE);
        if (hVar != h.h.RESOURCE_CACHE) {
            if (hVar == h.h.DATA_CACHE) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void a(f f, Exception exception2, d<?> d3, a a4) {
        Object obj3;
        d3.b();
        GlideException glideException = new GlideException("Fetching data failed", exception2);
        glideException.j(f, a4, d3.a());
        this.b.add(glideException);
        if (Thread.currentThread() != this.O) {
            this.K = h.g.SWITCH_TO_SOURCE_SERVICE;
            this.H.d(this);
        } else {
            D();
        }
    }

    @Override // com.bumptech.glide.load.engine.f$a
    public void c() {
        this.K = h.g.SWITCH_TO_SOURCE_SERVICE;
        this.H.d(this);
    }

    @Override // com.bumptech.glide.load.engine.f$a
    public int compareTo(Object object) {
        return j((h)object);
    }

    public void e(f f, Object object2, d<?> d3, a a4, f f5) {
        Object obj1;
        int obj3;
        this.P = f;
        this.R = object2;
        this.T = d3;
        this.S = a4;
        this.Q = f5;
        if (f != this.a.c().get(0)) {
            obj3 = 1;
        }
        this.X = obj3;
        if (Thread.currentThread() != this.O) {
            this.K = h.g.DECODE_DATA;
            this.H.d(this);
        } else {
            b.a("DecodeJob.decodeFromRetrievedData");
            n();
            b.e();
        }
    }

    @Override // com.bumptech.glide.load.engine.f$a
    public c f() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.engine.f$a
    public void i() {
        this.W = true;
        com.bumptech.glide.load.engine.f fVar = this.U;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    public int j(com.bumptech.glide.load.engine.h<?> h) {
        int i;
        Object obj3;
        if (i2 -= i4 == 0) {
            i3 -= obj3;
        }
        return i;
    }

    @Override // com.bumptech.glide.load.engine.f$a
    public void run() {
        Throwable th;
        int eNCODE;
        String str2;
        final String str3 = "DecodeJob";
        b.c("DecodeJob#run(reason=%s, model=%s)", this.K, this.N);
        d dVar = this.T;
        x();
        if (this.W && dVar != null) {
            x();
            if (dVar != null) {
                dVar.b();
            }
            b.e();
        }
        F();
        if (dVar != null) {
            dVar.b();
        }
        b.e();
    }

    com.bumptech.glide.load.engine.h<R> s(e e, Object object2, com.bumptech.glide.load.engine.n n3, f f4, int i5, int i6, Class<?> class7, Class<R> class8, h h9, com.bumptech.glide.load.engine.j j10, Map<Class<?>, l<?>> map11, boolean z12, boolean z13, boolean z14, h h15, com.bumptech.glide.load.engine.h.b<R> h$b16, int i17) {
        final Object obj = this;
        obj.a.v(e, object2, f4, i5, i6, j10, class7, class8, h9, h15, map11, z12, z13, obj.v);
        obj.z = e;
        obj.A = f4;
        obj.B = h9;
        obj.C = n3;
        obj.D = i5;
        obj.E = i6;
        obj.F = j10;
        obj.M = z14;
        obj.G = h15;
        obj.H = b16;
        obj.I = i17;
        obj.K = h.g.INITIALIZE;
        obj.N = object2;
        return obj;
    }
}
